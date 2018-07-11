package com.nuritelecom.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);

	@Around("execution(* com.nuritelecom.service.BoardService*.*(..))")
	public Object startLog2(ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("-----------------------------time--------------------");
		logger.info("-----------------------------time--------------------");
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));

		Object result = pjp.proceed();

		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName()+ " : " + (endTime - startTime));
		logger.info("-----------------------------endtime--------------------");
		logger.info("-----------------------------endtime--------------------");
		
		return result;
				
	}

}
