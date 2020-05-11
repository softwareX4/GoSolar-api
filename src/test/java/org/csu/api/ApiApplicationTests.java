package org.csu.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
class ApiApplicationTests {


	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected final ObjectMapper objectMapper = new ObjectMapper();

	@Test
	public void contextLoads() {
		logger.info("I am trace log.");
		logger.debug("I am debug log.");
		logger.warn("I am warn log.");
		logger.error("I am error log.");
	}
}
