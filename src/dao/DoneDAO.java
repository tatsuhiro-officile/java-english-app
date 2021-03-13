package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Done;
import model.Profile;


public class DoneDAO{

    private static Connection getConnection() throws URISyntaxException, SQLException {
            // heroku configに設定されている値を取得。
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        // :をデリミタとして必要な情報を抜き取る。
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        // JDBC用のURLを生成。
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath() + "?useUnicode=true&characterEncoding=utf8";

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public Done findBytoday(Profile profile) {
    	Done done = null;


        try {
                // ドライバの読み込み。
            Class.forName ("com.mysql.cj.jdbc.Driver");
            // データベースへ接続のためprivateメソッドを呼び出す。
            try(Connection conn = getConnection()) {
                String sql = "SELECT ORIGINALID,LISTNING,READING,WRITEING FROM DONE2 WHERE ORIGINALID = ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, profile.getOriginalid());



                // SELECTを実行し、結果表を取得
                ResultSet rs = pStmt.executeQuery();



                // 一致したユーザーが存在した場合
                // そのユーザーを表すAccountインスタンスを生成
                if (rs.next()) {



              	String userId = rs.getString("ORIGINALID");
                  int listning = rs.getInt("LISTNING");
                 int reading = rs.getInt("READING");
                 int writeing = rs.getInt("WRITEING");



                  done = new Done(userId,listning,reading,writeing);
                }

            } catch (URISyntaxException e) {
                e.printStackTrace();
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
            return null;
        }
        return done;
    }

    public void create(String originalid) {
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {

  	      // INSERT文の準備(idは自動連番なので指定しなくてよい）
  	      String sql = "INSERT INTO DONE2(ORIGINALID) VALUES(?)";
  	      PreparedStatement pStmt = conn.prepareStatement(sql);
  	      // INSERT文中の「?」に使用する値を設定しSQLを完成
  	      pStmt.setString(1, originalid);




  	      // INSERT文を実行

  	      int result = pStmt.executeUpdate();
  	      System.out.println("INSERok");



  	      if (result != 1) {

  	      }


	      if (result != 1) {

	      }

        }catch (URISyntaxException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();

    }

    }

    public void point_update(String id) {

        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {



		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = id;



		      PreparedStatement pStmt = conn.prepareStatement(sql);




		      // INSERT文を実行

		      int result = pStmt.executeUpdate();



		      if (result != 1) {

		      }

        }catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();

    }
        System.out.println("return前");

    }

}