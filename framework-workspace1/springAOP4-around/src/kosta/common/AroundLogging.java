package kosta.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;

import kosta.model.InventoryException;

//공통관심사항 정의 클래스
public class AroundLogging {
	private Log log=LogFactory.getLog(getClass());
	/*
	 * ProceedingJoinPoint는 실제 대상(Target) 메서드를 제어한다 
	 * 그러므로 반드시 proceed() 메서드를 호출해야 
	 * 실제 Target(Core) 메서드가 실행된다 
	 * 
	 */
	public Object aroundLog(ProceedingJoinPoint point) throws Throwable{
		log.debug("before:메서드 실행전에 공통기능적용");
		Object retValue=null;
		try{
			retValue=point.proceed();//Target method 호출			
			log.debug("after-returning:메서드 실행 후 리턴시 적용 "+retValue);
		}catch(InventoryException ie){
			log.error("after-throwing:특정 예외발생시 공통기능적용");
			throw ie;
		}finally {
			log.debug("after:메서드 예외 및 리턴여부와 관계없이 항상 적용");
		}
		return retValue;
	}
}








