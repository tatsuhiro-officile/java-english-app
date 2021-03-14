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

import model.Problem;


public class ProblemDao{

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

    public List<Problem> findAll() {

    	List<Problem> problemList = new ArrayList<Problem>();


        try {
                // ドライバの読み込み。
            Class.forName ("com.mysql.cj.jdbc.Driver");
            // データベースへ接続のためprivateメソッドを呼び出す。
            try(Connection conn = getConnection()) {
            	String sql =
            	          "SELECT ID,WORD,LEVEL,No1,No2,No3,No4,No5,No6,No7,No8,No9,No10,No11,No12,No13,No14,No15,JAPANESE,QUATION,COMMA FROM PROBLEM ORDER BY ID DESC";
            	      PreparedStatement pStmt = conn.prepareStatement(sql);

            	      // SELECTを実行
            	      ResultSet rs = pStmt.executeQuery();

            	      // SELECT文の結果をArrayListに格納
            	      while (rs.next()) {
            	        int id = rs.getInt("ID");
            	        int word = rs.getInt("WORD");
            	        int level = rs.getInt("LEVEL");

            	        String no1 = rs.getString("No1");
            	        String no2 = rs.getString("No2");
            	        String no3 = rs.getString("No3");
            	        String no4 = rs.getString("No4");
            	        String no5 = rs.getString("No5");
            	        String no6 = rs.getString("No6");
            	        String no7 = rs.getString("No7");
            	        String no8 = rs.getString("No8");
            	        String no9 = rs.getString("No9");
            	        String no10 = rs.getString("No10");
            	        String no11 = rs.getString("No11");
            	        String no12 = rs.getString("No12");
            	        String no13 = rs.getString("No13");
            	        String no14 = rs.getString("No14");
            	        String no15 = rs.getString("No15");
            	        String japanese = rs.getString("JAPANESE");
            	        int quations = rs.getInt("QUATION");
            	        int comma = rs.getInt("COMMA");




            	        Problem problem = new Problem(id,word,level,no1,no2,no3,no4,no5,no6,no7,no8,no9,no10,no11,no12,no13,no14,no15,japanese,quations,comma);
            	        problemList.add(problem);
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
        return problemList;
    }


    public ArrayList<Problem>  view_problem(ArrayList<Integer> list) {
    	ArrayList<Problem> view_problemlst = new ArrayList<Problem>();

        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {

        	 String sql = "SELECT ID,WORD,LEVEL,NO1,NO2,NO3,NO4,NO5,NO6,NO7,NO8,NO9,NO10,NO11,NO12,NO13,NO14,NO15,JAPANESE,QUATION,COMMA FROM PROBLEM WHERE ID = ?;";
   	      PreparedStatement pStmt = conn.prepareStatement(sql);


   	      for(int number=0;number<20;number++) {

   	    	  int setting_id = list.get(number);
   	    	  setting_id++;




   	    	  String addprroblem = String.valueOf(setting_id);

   	    	  pStmt.setString(1, addprroblem);
   	    	  ResultSet rs = pStmt.executeQuery();;

   	    	   while (rs.next()){
   	        	  int id = rs.getInt("ID");
   	        	  int word = rs.getInt("WORD");
   	        	  int level = rs.getInt("LEVEL");
   	        	  String no1 = rs.getString("NO1");
   	        	  String no2 = rs.getString("NO2");
   	        	  String no3 = rs.getString("NO3");
   	        	  String no4 = rs.getString("NO4");
   	        	  String no5 = rs.getString("NO5");
   	        	  String no6 = rs.getString("NO6");
   	        	  String no7 = rs.getString("NO7");
   	        	  String no8 = rs.getString("NO8");
   	        	  String no9 = rs.getString("NO9");
   	        	  String no10 = rs.getString("NO10");
   	        	  String no11 = rs.getString("NO11");
   	        	  String no12 = rs.getString("NO12");
   	        	  String no13 = rs.getString("NO13");
   	        	  String no14 = rs.getString("NO14");
   	        	  String no15 = rs.getString("NO15");
   	        	  String japanese = rs.getString("JAPANESE");
   	        	  int quations = rs.getInt("QUATION");
   	        	  int comma = rs.getInt("COMMA");


   	              Problem one_problem = new Problem(id,word,level,no1,no2,no3,no4,no5,no6,no7,no8
   	            		  ,no9,no10,no11,no12,no13,no14,no15,japanese,quations,comma);


   	              view_problemlst.add(one_problem);
   	          }}

        }catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();

    }
       return view_problemlst;

    }

    public boolean create(Problem problem) {

        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {





	      // SELECT文の準備
	      String sql = "INSERT INTO PROBLEM(ID,WORD,LEVEL,NO1,NO2,NO3,NO4,NO5,NO6,NO7,NO8,NO9,NO10,NO11,NO12,NO13,NO14,NO15,JAPANESE,QUATION,COMMA) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      System.out.println("sqlinserset");


	      pStmt.setInt(1, problem.getId());
	      pStmt.setInt(2, problem.getWord());
	      pStmt.setInt(3, problem.getLevel());
	      pStmt.setString(4, problem.getNo1());
	      pStmt.setString(5, problem.getNo2());
	      pStmt.setString(6, problem.getNo3());
	      pStmt.setString(7, problem.getNo4());
	      pStmt.setString(8, problem.getNo5());
	      pStmt.setString(9, problem.getNo6());
	      pStmt.setString(10, problem.getNo7());
	      pStmt.setString(11, problem.getNo8());
	      pStmt.setString(12, problem.getNo9());
	      pStmt.setString(13, problem.getNo10());
	      pStmt.setString(14, problem.getNo11());
	      pStmt.setString(15, problem.getNo12());
	      pStmt.setString(16, problem.getNo13());
	      pStmt.setString(17, problem.getNo14());
	      pStmt.setString(18, problem.getNo15());
	      pStmt.setString(19, problem.getJapanese());
	      pStmt.setInt(20, problem.getQuations());
	      pStmt.setInt(21, problem.getComma());





	      // INSERT文を実行
	      int result = pStmt.executeUpdate();
	      System.out.println("update");

	      if (result != 1) {
	  	        return false;
	  	      }
        }catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();

    }
       return true;

    }

}