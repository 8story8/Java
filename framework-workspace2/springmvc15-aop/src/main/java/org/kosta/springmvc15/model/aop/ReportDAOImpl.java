package org.kosta.springmvc15.model.aop;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements ReportDAO {
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public int findReportByKeyword(String keyword) {
		return template.selectOne("report.findReportByKeyword", keyword);
	}
	
	@Override
	public List<HashMap<String, Object>> selectReport() {
		return template.selectList("report.selectReport");
	}

	@Override
	public void insertReport(String keyword) {
		template.insert("report.insertReport", keyword);
	}
	
	@Override
	public void updateReport(String keyword) {
		template.update("report.updateReport", keyword);
	}

	
}
