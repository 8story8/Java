package kosta.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

// 공통관심사항 정의 클래스
public class LoggingService {
	private Log log=LogFactory.getLog(getClass());
	public void testLog(JoinPoint point,Object retValue){
		String className=point.getTarget().getClass().getName();
		String methodName=point.getSignature().getName();
		log.debug("target: "+className+" "+methodName
										+" 리턴정보:"+retValue);
	}
}








