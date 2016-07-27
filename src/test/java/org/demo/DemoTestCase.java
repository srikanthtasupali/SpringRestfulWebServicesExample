package org.demo;

import org.adcampaign.controller.SpringRestController;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;


@ContextConfiguration("file:src/main/webapp/WEB-INF/springrest-servlet.xml")
@WebAppConfiguration
public class DemoTestCase extends AbstractTestNGSpringContextTests
{
	
	private SpringRestController mockSpringRestController = new SpringRestController();
	private MockMvc _mockMVC;
	
	@Test
	public void testDemo() throws Exception{
		_mockMVC = MockMvcBuilders.standaloneSetup(mockSpringRestController).build();
		
		MvcResult result = _mockMVC.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/hello/ad/partnerid4"))
				//.andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
				.andReturn();		
		
	}
}
