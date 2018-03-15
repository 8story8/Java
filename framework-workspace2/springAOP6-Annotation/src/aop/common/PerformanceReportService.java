package aop.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
@Component
@Aspect
public class PerformanceReportService {
	private Log log=LogFactory.getLog(getClass());
	// advice와 pointcut을 어노테이션을 명시한다 
	@Around("execution(public * kosta..*Service.*(..) )")
	public Object checkTime(ProceedingJoinPoint point) throws Throwable {
		String cn=point.getTarget().getClass().getName();
		String mn=point.getSignature().getName();
		Object retValue = null;
		StopWatch watch = new StopWatch();
		watch.start();
		try {
			retValue = point.proceed();// 대상(target) 메서드 호출 			
		} finally {
			watch.stop();
			long time=watch.getTotalTimeMillis();
			if(time>=500&&time<=1000)
				log.warn(cn+" "+mn+" time:"+time);
			else if(time>1000)
				log.error(cn+" "+mn+" time:"+time);			
		}
		return retValue;
	}
}






