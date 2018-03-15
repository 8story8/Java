package org.kosta.springmvc15.model.aop;

import java.util.HashMap;
import java.util.List;

public interface ReportDAO {
	
	int findReportByKeyword(String keyword);
	List<HashMap<String, Object>> selectReport();
	void updateReport(String keyword);
	void insertReport(String keyword);
}
