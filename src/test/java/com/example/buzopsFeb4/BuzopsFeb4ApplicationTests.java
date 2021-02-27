package com.example.buzopsFeb4;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;
import java.util.Collections;

@RunWith(SpringRunner.class)
@WebMvcTest
class BuzopsFeb4ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmailRepository emailRepository;

	@MockBean
	private EmailService emailService;

	@Test
	void contextLoads() throws Exception {

		Mockito.when(emailRepository.findAll()).thenReturn(Collections.emptyList());

		MvcResult mvcResult =  mockMvc.perform(MockMvcRequestBuilders.get("/getEmails")
				.accept(MediaType.APPLICATION_JSON)).andReturn();
		System.out.println(mvcResult.getResponse());

		Mockito.verify(emailRepository).findAll();

	}

}
