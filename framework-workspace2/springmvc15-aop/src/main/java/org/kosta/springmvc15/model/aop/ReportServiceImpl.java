package org.kosta.springmvc15.model.aop;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
	@Resource
	private ReportDAO reportDAO;

	@Override
	public int findReportByKeyword(String keyword) {
		return reportDAO.findReportByKeyword(keyword);
	}

	@Override
	public List<HashMap<String, Object>> selectReport() {
		return reportDAO.selectReport();
	}

	@Override
	public void insertReport(String keyword) {
		reportDAO.insertReport(keyword);
	}
	
	@Override
	public void updateReport(String keyword) {
		reportDAO.updateReport(keyword);
	}
}
