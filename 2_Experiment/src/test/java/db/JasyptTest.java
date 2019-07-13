/**
 * 
 */
package db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;
import org.jasypt.registry.AlgorithmRegistry;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @since : 2019. 7. 13.
 * @author : JeonBH
 * 
 *         <PRE>
 * -----------------------------
 * 개정이력
 * 2019. 7. 13. JeonBH : 최초작성
 *         </PRE>
 */
/**
 * @since  : 2019. 7. 13.
 * @author : JeonBH
 * <PRE>
 * -----------------------------
 * 개정이력
 * 2019. 7. 13. JeonBH : 최초작성
 * </PRE> 
 */
/**
 * @since  : 2019. 7. 13.
 * @author : JeonBH
 * <PRE>
 * -----------------------------
 * 개정이력
 * 2019. 7. 13. JeonBH : 최초작성
 * </PRE> 
 */
public class JasyptTest {

	Logger logger = LoggerFactory.getLogger(JasyptTest.class);

	StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	String dbType = "oracle";
	String driverClassName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@123.213.29.5:1521:orcl";
	String userName = "JBH";
	String password = "1234";
	
	/**
	 * @Author : JeonBH
	 * @Date   : 2019. 7. 13.
	 * @method : checkSupportAlgorithm 
	 * @return : void 
	 * 
	 * 사용가능한 알고리즘 리스트 출려하는 코드
	 */
	@Test
	public void checkSupportAlgorithm() {
		List<Object> supported = new ArrayList<>();
		List<Object> unsupported = new ArrayList<>();
		
		for (Object algorithm : AlgorithmRegistry.getAllPBEAlgorithms()) {
			try {
				StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
				encryptor.setPassword("somePassword");
				encryptor.setAlgorithm(String.valueOf(algorithm));
				String str = "test";
				String encStr = encryptor.encrypt(str);
				String decStr = encryptor.decrypt(encStr);				
				assertEquals(str,decStr);				
				supported.add(algorithm);
			} catch (EncryptionOperationNotPossibleException e) {
				unsupported.add(algorithm);
			}
		}		
		System.out.println("supported   : " + supported);
		System.out.println("unsupported : " + unsupported);		
	}

	
	

	@Test
	public void JasyptEncTest() {

		// given
		encryptor.setPassword("test");
		encryptor.setAlgorithm("PBEWITHMD5ANDDES");
		
		
		List<String> DbTypeList = new ArrayList<String>();
		List<String> DriverClassnameList = new ArrayList<String>();
		List<String> urlList = new ArrayList<String>();
		List<String> userNameList = new ArrayList<String>();
		List<String> passwordList = new ArrayList<String>();

		// work
		// 암호화
		String encDbType = encryptor.encrypt(dbType);
		String encDriverClassName = encryptor.encrypt(driverClassName);
		String encUrl = encryptor.encrypt(url);
		String encUserName = encryptor.encrypt(userName);
		String encPassword = encryptor.encrypt(password);

		// 복호화
		String deccDbType = encryptor.decrypt(encDbType);
		String deccDriverClassName = encryptor.decrypt(encDriverClassName);		
		String decUrl = encryptor.decrypt(encUrl);
		String decUserName = encryptor.decrypt(encUserName);
		String decPassword = encryptor.decrypt(encPassword);
		
		DbTypeList.add(dbType);
		DbTypeList.add(encDbType);
		DbTypeList.add(deccDbType);
		
		DriverClassnameList.add(driverClassName);
		DriverClassnameList.add(encDriverClassName);
		DriverClassnameList.add(deccDriverClassName);

		
		urlList.add(url);
		urlList.add(encUrl);
		urlList.add(decUrl);
		
		userNameList.add(userName);
		userNameList.add(encUserName);
		userNameList.add(decUserName);
		
		passwordList.add(password);   
		passwordList.add(encPassword);
		passwordList.add(decPassword);

		// result	
		System.out.println("DbTypeList   : " + DbTypeList);
		System.out.println("DriverClassnameList : " + DriverClassnameList);
		System.out.println("urlList      :" + urlList);
		System.out.println("userNameList : " + userNameList);
		System.out.println("passwordList : " + passwordList);

		
	}
	

}
