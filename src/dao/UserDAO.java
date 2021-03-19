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
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath()+ "?useUnicode=true&characterEncoding=utf8";
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public Profile findByLogin(Login login, int number) {

        Profile profile = null;

        try {
                // ドライバの読み込み。
            Class.forName ("com.mysql.cj.jdbc.Driver");
            // データベースへ接続のためprivateメソッドを呼び出す。
            try(Connection conn = getConnection()) {

                PreparedStatement pStmt=null;

                if(number==1) {
                // SELECT文を準備
                String sql = "SELECT ORIGINALID, PASS, POINT,NICKNAME,PROBLEM1,PROBLEM2,PROBLEM3,PROBLEM4,PROBLEM5,PROBLEM6,PROBLEM7,PROBLEM8,PROBLEM9,PROBLEM10,PROBLEM11,PROBLEM12"
                		+ " FROM USER3 WHERE ORIGINALID = ? AND PASS = ?";
               pStmt = conn.prepareStatement(sql);
                pStmt.setString(1, login.getOriginalid());
                pStmt.setString(2, login.getpassword());
                System.out.println("1dao");

                }else {
                    String sql = "SELECT ORIGINALID, PASS, POINT,NICKNAME,PROBLEM1,PROBLEM2,PROBLEM3,PROBLEM4,PROBLEM5,PROBLEM6,PROBLEM7,PROBLEM8,PROBLEM9,PROBLEM10,PROBLEM11,PROBLEM12"
                      		+ " FROM USER3 WHERE ORIGINALID = ?";
                pStmt = conn.prepareStatement(sql);
                      pStmt.setString(1, login.getOriginalid());
                      System.out.println("2dao");


                }

                  // SELECTを実行し、結果表を取得
                  ResultSet rs = pStmt.executeQuery();


                  System.out.println("3dao");
                  // 一致したユーザーが存在した場合
                  // そのユーザーを表すAccountインスタンスを生成
                  if (rs.next()) {



                	String userId = rs.getString("ORIGINALID");
                    String pass = rs.getString("PASS");
                   int point = rs.getInt("POINT");
                   String nickname = rs.getString("NICKNAME");

                   int problem1 = rs.getInt("PROBLEM1");
                   int problem2 = rs.getInt("PROBLEM2");
                   int problem3 = rs.getInt("PROBLEM3");
                   int problem4 = rs.getInt("PROBLEM4");
                   int problem5 = rs.getInt("PROBLEM5");
                   int problem6 = rs.getInt("PROBLEM6");
                   int problem7 = rs.getInt("PROBLEM7");
                   int problem8 = rs.getInt("PROBLEM8");
                   int problem9 = rs.getInt("PROBLEM9");
                   int problem10 = rs.getInt("PROBLEM10");
                   int problem11 = rs.getInt("PROBLEM11");
                   int problem12 = rs.getInt("PROBLEM12");


                    profile = new Profile(userId,nickname,pass,point,problem1,
                    		problem2,problem3,problem4,problem5,problem6,problem7,
                    		problem8,problem9,problem10,problem11,problem12
                    		);

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
        }System.out.println("4dao");
        return profile;
    }

    public boolean create(Register register) {
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {
  	      String sql = "INSERT INTO USER3(ORIGINALID,PASS,POINT,NICKNAME) VALUES(?,?,?,?)";
  	      PreparedStatement pStmt = conn.prepareStatement(sql);
  	      // INSERT文中の「?」に使用する値を設定しSQLを完成
  	      pStmt.setString(1, register.getOriginalid());
  	      pStmt.setString(2, register.getPassword());
  	      pStmt.setLong(3, register.getPoint());
  	      pStmt.setString(4, register.getNickName());

  	      System.out.println("dao登録ニックネーム"+register.getNickName());



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


    public String findooriginalid(Register inputtingoriginalid) {

	    String originalid= null;
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {
            String sql = "SELECT ORIGINALID FROM USER3 WHERE ORIGINALID =  ?";
  	      PreparedStatement pStmt = conn.prepareStatement(sql);
  	      pStmt.setString(1, inputtingoriginalid.getOriginalid());

  	      ResultSet rs = pStmt.executeQuery();

  	      if (rs.next()) {
  	    	  originalid = rs.getString("ORIGINALID");


  	    }

        }catch (URISyntaxException e) {
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
    public String findnickname(Register inputtingnicikname) {


	    String originalnickname= null;

        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {
		      String sql = "SELECT NICKNAME FROM USER3 WHERE NICKNAME =  ?";
		      PreparedStatement pStmt = conn.prepareStatement(sql);
		      pStmt.setString(1, inputtingnicikname.getNickName());

		      System.out.println("findnickname"+inputtingnicikname.getNickName());

		      ResultSet rs = pStmt.executeQuery();

		      if (rs.next()) {
		    	  originalnickname = rs.getString("NICKNAME");

		    	  System.out.println("sqlから取り出したニックネーム"+originalnickname);



		      // SELECTを実行し、結果表を取得




  	    }


        }catch (URISyntaxException e) {
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
	      return originalnickname;
	      }

    public boolean seisekiupdate(String test) {
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {
  	      String sql = test;
	      System.out.println(sql);
	      PreparedStatement pStmt = conn.prepareStatement(sql);
	      // INSERT文中の「?」に使用する値を設定しSQLを完成
	//      pStmt.setString(1, coulumn);
	 //     pStmt.setString(2, originalid.getOriginalid());

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
        System.out.println("return前");
    return true;
    }

    public int point_update(Profile register) {

        int point;
        try {
            // ドライバの読み込み。
        Class.forName ("com.mysql.cj.jdbc.Driver");
        // データベースへ接続のためprivateメソッドを呼び出す。
        try(Connection conn = getConnection()) {


		      // INSERT文の準備(idは自動連番なので指定しなくてよい）
		      String sql = "UPDATE USER3 SET POINT=? WHERE ORIGINALID=?;";
		      PreparedStatement pStmt = conn.prepareStatement(sql);

		      point =register.getPoint()+1;

		      pStmt.setLong(1,point);
		      pStmt.setString(2, register.getOriginalid());



		      // INSERT文を実行

		      int result = pStmt.executeUpdate();



		      if (result != 1) {
		        return 0;
		      }

        }catch (URISyntaxException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
        return 0;
    }
        System.out.println("return前");
    return point;
    }



}
