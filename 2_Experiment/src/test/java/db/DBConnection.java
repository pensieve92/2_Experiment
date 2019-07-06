package db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnection {

	@Test
	public void DBConnectionTest() {

		//ojdbc6.jar 추가하기 
		//C:\Program Files\ojdkbuild\java-1.8.0-openjdk-1.8.0.212-1\jre\lib\ext\ojdbc6.jar
			
        try {        	
        	
        	//given
            String user = "JBH"; 
            String pw = "1234";
            String url = "jdbc:oracle:thin:@123.213.29.5:1521:orcl";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
			//work           
            Connection conn = DriverManager.getConnection(url, user, pw);
            
            //Exception
            /*throw new ClassNotFoundException();*/
            /*throw new SQLException();*/
            
			//result
            assertNotNull(conn);            
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
