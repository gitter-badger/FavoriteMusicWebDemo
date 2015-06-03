package mplanweb.music.web.admin.excel;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * 
 * 
 *  Excel 완료
 * 
 * 
 */
@Repository
public class UploadImple implements UploadDao {

	private String NAMESPACE="Excel.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void addExcel(List<Excel> list) {
		sqlMapClientTemplate.insert(NAMESPACE+"addExcel", list);
	}
}