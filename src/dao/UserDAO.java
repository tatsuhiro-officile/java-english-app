package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.Profile;
import model.Register;


public class UserDAO {

    private static Connection getConnection() throws URISyntaxException, SQLException {
            // heroku configに設定されている値を取得。
        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
        // :をデリミタとして必要な情報を抜き取る。
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        // JDBC用のURLを生成。
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }

    public Profile findByLogin(Login login) {

        Profile profile = null;

        try {
                // ドライバの読み込み。
            Class.forName ("com.mysql.cj.jdbc.Driver");
            // データベースへ接続のためprivateメソッドを呼び出す。
            try(Connection conn = getConnection()) {
                // SELECT文を準備。
                String sql = "SELECT ORIGINALID, PASS, POINT,NICKNAME FROM USER WHERE ORIGINALID = ? AND PASS = ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, login.getOriginalid());
                pStmt.setString(2, login.getpassword());

                // SELECTを実行し、結果表を取得
                ResultSet rs = pStmt.executeQuery();



                // 一致したユーザーが存在した場合
                // そのユーザーを表すAccountインスタンスを生成
                if (rs.next()) {



              	String userId = rs.getString("ORIGINALID");
                  String pass = rs.getString("PASS");
                 int point = rs.getInt("POINT");
                 String nickname = rs.getString("NICKNAME");

                  profile = new Profile(userId,nickname,pass,point);
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
        return profile;
    }

    public boolean create(Register register) {
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {
  	      String sql = "INSERT INTO USER(ORIGINALID,PASS,POINT,NICKNAME) VALUES(?, ?, ?, ?)";
  	      PreparedStatement pStmt = conn.prepareStatement(sql);
  	      // INSERT文中の「?」に使用する値を設定しSQLを完成
  	      pStmt.setString(1, register.getOriginalid());
  	      pStmt.setString(2, register.getPassword());
  	      pStmt.setLong(3, register.getPoint());
  	      pStmt.setString(4, register.getNickName());



  	      // INSERT文を実行

  	      int result = pStmt.executeUpdate();



  	      if (result != 1) {
  	        return false;
  	      }
        }catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
        return false;
    }
    return true;
    }


    public String findprofile(Register inputtingoriginalid) {

	    String originalid= null;
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {	      String sql = "SELECT ORIGINALID FROM USER WHERE ORIGINALID =  ?";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      pStmt.setString(1, inputtingoriginalid.getOriginalid());

	      ResultSet rs = pStmt.executeQuery();

	      if (rs.next()) {
	    	  originalid = rs.getString("ORIGINALID");
	    	  }}catch (URISyntaxException e) {
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
	      return originalid;
	      }


}
