/**
 * 
 */
package db;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import pensieve.login.service.impl.LoginMapper;

/**
 * @since  : 2019. 7. 13.
 * @author : JeonBH
 * <PRE>
 * -----------------------------
 * 개정이력
 * 2019. 7. 13. JeonBH : 최초작성
 * </PRE> 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:egovframework/spring/context-*.xml",
									"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml"})
@WebAppConfiguration
public class MyMatisTest {
	
	
	@Resource
	public LoginMapper loginmapper;
	
	
	// TODO mybatis 사용
	//  @Resource(name="sampleMapper")
	//	private SampleMapper sampleDAO;
	
	
	@Test
	public void MyMatisTest() throws Exception {
		
		//given
		
		//work
		List<Object> AllUser = loginmapper.selectAllUser();
		
		//result		
		System.out.println(AllUser);
		assertNotNull(AllUser);
		
		
		/*fail("Not yet implemented");*/
	}

}
