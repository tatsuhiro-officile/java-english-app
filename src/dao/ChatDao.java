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

import model.Chat;

public class ChatDao {

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



  public List<Chat> findAll() {
    List<Chat> chatList = new ArrayList<Chat>();
    try {
        // ドライバの読み込み。
    Class.forName ("com.mysql.cj.jdbc.Driver");
    // データベースへ接続のためprivateメソッドを呼び出す。
    try(Connection conn = getConnection()) {

      // SELECT文の準備
      String sql =
          "SELECT ID,NAME,TEXT FROM MUTTER ORDER BY ID DESC";
      PreparedStatement pStmt = conn.prepareStatement(sql);

      // SELECTを実行
      ResultSet rs = pStmt.executeQuery();

      // SELECT文の結果をArrayListに格納
      while (rs.next()) {

        String userName = rs.getString("NAME");
        String text = rs.getString("TEXT");
        Chat mutter = new Chat(userName, text);
        chatList.add(mutter);
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
return chatList;
}

  public boolean create(Chat chat) {

    try {
        // ドライバの読み込み。
    Class.forName ("com.mysql.cj.jdbc.Driver");
    // データベースへ接続のためprivateメソッドを呼び出す。
    try(Connection conn = getConnection()) {

      // INSERT文の準備(idは自動連番なので指定しなくてよい）
      String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      // INSERT文中の「?」に使用する値を設定しSQLを完成
      pStmt.setString(1, chat.getName());
      pStmt.setString(2, chat.getText());

      // INSERT文を実行
      int result = pStmt.executeUpdate();

      if (result != 1) {
        return false;
      }
    } catch (URISyntaxException e) {
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

  }}