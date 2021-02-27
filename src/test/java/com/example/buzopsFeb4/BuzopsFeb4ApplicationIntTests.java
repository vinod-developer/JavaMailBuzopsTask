package com.example.buzopsFeb4;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = BuzopsFeb4Application.class
)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties" )
class BuzopsFeb4ApplicationIntTests {

	@Autowired
	private MockMvc mockMvc;



	@Test
	void contextLoads() throws Exception {

		MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/getEmails")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());

	}

}
