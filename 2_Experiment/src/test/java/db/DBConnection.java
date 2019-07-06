package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnection {

	@Test
	public void DBConnectionTest() {

		//ojdbc 추가하기 
		//C:\Program Files\ojdkbuild\java-1.8.0-openjdk-1.8.0.212-1\jre\lib\ext
		//ojdbc6.jar



	/*	DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver()); 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@211.56.251.176:1521:ORA9","laputa","laputa"); 
		DatabaseMetaData meta = conn.getMetaData (); */

		
		
		
		Connection conn = null;
        try {
            String user = "JBH"; 
            String pw = "1234";
            String url = "jdbc:oracle:thin:@123.213.29.5:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
          

		
	
	}
	
	
	

}
