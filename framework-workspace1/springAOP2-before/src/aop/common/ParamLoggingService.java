package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

// 공통관심사항 정의 클래스 
public class ParamLoggingService {
	private Log log=LogFactory.getLog(getClass());
	public void beforeLogging(JoinPoint point){
		//대상메서드(Target)가 전달받는 데이터
		Object params[]=point.getArgs();
		String data="";
		for(int i=0;i<params.length;i++)
			data+=params[i]+" ";
		// 대상클래스명 메서드명 인자값 ...
		String className=point.getTarget().getClass().getName();		
		String methodName=point.getSignature().getName();
		log.info(className+" "+methodName+" "+data);
	}
}






