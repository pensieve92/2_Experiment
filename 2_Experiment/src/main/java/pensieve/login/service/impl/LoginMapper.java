/**
 * 
 */
package pensieve.login.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * @since  : 2019. 7. 13.
 * @author : JeonBH
 * <PRE>
 * -----------------------------
 * 개정이력
 * 2019. 7. 13. JeonBH : 최초작성
 * </PRE> 
 */
@Mapper("loginMapper")
public interface LoginMapper {
	
	public List<Object> selectAllUser() throws Exception;
	
}
