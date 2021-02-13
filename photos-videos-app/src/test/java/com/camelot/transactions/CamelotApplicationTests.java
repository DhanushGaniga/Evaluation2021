package com.camelot.transactions;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CamelotApplicationTests.class)
@ContextConfiguration
public class CamelotApplicationTests {

	@Test
	@Ignore("Test1")
	public void contextLoads() {
	}

}
