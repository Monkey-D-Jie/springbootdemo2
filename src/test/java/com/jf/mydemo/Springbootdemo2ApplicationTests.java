package com.jf.mydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springbootdemo2ApplicationTests {

	/**
	 * 打印日志用logger-用debug级别
	 *
	 */
	private Logger LOGGER = LoggerFactory.getLogger(Springbootdemo2ApplicationTests.class.getName());


	@Test
	public void contextLoads() {
	}
	@Test
	public void logTest(){
		LOGGER.debug("debug：....");
		LOGGER.info("info...");
		LOGGER.error("error...");
		String str  = null;
		try {
			System.out.println(str.toString());
		}catch (NullPointerException e){
			LOGGER.error("异常测试日志打印，异常信息 {}",e.getMessage(),e);
		}
	}
}
