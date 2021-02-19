package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test {

    public static void main(String[] args) {

    // 変数の準備
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

    // SQL文の作成
        String sql = "INSERT INTO USER(ORIGINALID,NICKNAME, PASS) VALUES('2222', 'タツひろ', '2222')";


        try {
            // JDBCドライバのロード
            Class.forName("com.mysql.cj.jdbc.Driver");
            // データベース接続

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF8", "root", "fdg65*Fkkdw");
            // SQL実行準備
            stmt = con.prepareStatement(sql);

            System.out.println("SQL実行結果成功");
            // 実行結果取得
            //rs = stmt.executeQuery();
            stmt.executeUpdate();
            System.out.println("実行結果取得");

            while (rs.next()) {
                String name = rs.getString("TEXT");
                System.out.println("text取得");

               System.out.println(name);
            }
            System.out.println("正常終了");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードでエラーが発生しました");
        } catch (SQLException e) {
        	System.out.println(e);

            System.out.println("データベースへのアクセスでエラーが発生しました。");
        } finally {
            try {
                if (con != null) {
                    System.out.println("終了");

                    con.close();

                }
                System.out.println("正常終了");
            } catch (SQLException e) {
            	System.out.println(e);

                System.out.println("データベースへのアクセスでエラーが発生しました。");
            }
        }
    }

}