package mplanweb.music.web.etc;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class BoardAOP extends BoardLogger {

	/**
	 * Control에 있는 메소드를 AOP한다.
	 * 
	 * @param joinPoint
	 * @return
	 */	 
	// * 만약 com.yk안에 여러개의 패키지가 있을 경우 || 으로 처리한다. (com.yk.*.*.*.*)
	// @Around("execution(public * com.yk.*.*.*Controller.*(..)) || execution(public * com.yk.*.*.*.*Controller.*(..))")
	@Around("execution(public ResultJSON mplanweb.music.web.board.control.*Controller.*(..))")
	public ResultJSON coverAround(ProceedingJoinPoint joinPoint) {
		ResultJSON resultJSON = new ResultJSON();
		try {
			// 해당 메소드 호출
			resultJSON = (ResultJSON) joinPoint.proceed();
		} catch (Throwable e) {
			resultJSON.setSuccess(false);
			resultJSON.setMsg(e.toString());
			logger.error("[" + joinPoint.toString() + "]*" + e);
		}
		return resultJSON;
	}

}
