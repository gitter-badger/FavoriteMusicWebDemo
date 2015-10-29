package mplanweb.music.web.admin.excel;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



/*
 * 
 * 
 *  Excel 완료
 * 
 * 
 */
@Service
public class UploadServiceImpl implements UploadService {

	//private String NAMESPACE="Excel.";

	@Autowired
	private UploadDAO uploaddao;
	@Override
	public void addExcel(List<Excel> list){
		uploaddao.addExcel(list);
	}
}
