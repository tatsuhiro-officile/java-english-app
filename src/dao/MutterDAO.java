package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {

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



  public List<Mutter> findAll() {
    List<Mutter> mutterList = new ArrayList<Mutter>();
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
     try (Connection conn =getConnection()){

      // SELECT文の準備
      String sql =
          "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {
        int id = rs.getInt("ID");
        String userName = rs.getString("NAME");
        String text = rs.getString("TEXT");
        Mutter mutter = new Mutter(id, userName, text);
        mutterList.add(mutter);
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
 return null;
}
}