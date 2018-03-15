package org.kosta.springmvc15.aop;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

import org.aspectj.lang.annotation.Aspect;
import org.kosta.springmvc15.model.aop.ReportService;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ReportAspect {
	@Resource
	private ReportService reportService;

	// advice와 pointcut을 Annotation으로 명시한다.
	@Around("execution(public java.util.List org.kosta.springmvc15.model.*Service.find*List*(..))")

	public Object checkSearchWord(ProceedingJoinPoint point) throws Throwable {
		int flag = 0;
		
		Object[] argValue = point.getArgs();
		String keyword = (String) argValue[1];

		Object retValue = null;

		retValue = point.proceed();

		if (retValue != null) {
			flag = reportService.findReportByKeyword(keyword);
			if(flag == 0){
				reportService.insertReport(keyword);
			}
			else{
				reportService.updateReport(keyword);
			}
		}

		return retValue;
	}
}
