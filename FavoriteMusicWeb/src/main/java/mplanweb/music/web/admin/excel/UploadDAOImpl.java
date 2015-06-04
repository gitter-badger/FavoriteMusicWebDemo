package mplanweb.music.web.admin.excel;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UploadDAOImpl extends SqlSessionDaoSupport implements UploadDAO {

	//private String NAMESPACE="Excel.";

	@Override
	public void addExcel(List<Excel> list) {
		getSqlSession().insert("mplanweb.music.web.admin.excel.Excel.addExcel", list);
	}
}
