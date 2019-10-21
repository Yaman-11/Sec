package com.example.second.Second;

import com.example.second.Second.Controller.BookController;
import com.example.second.Second.Entity.Books;
import com.example.second.Second.Services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SecondApplication.class)
@AutoConfigureMockMvc
class SecondApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;



	@Test
	public void contextLoads() throws Exception {
		Books books=new Books();
		books.setBookid(1);
		books.setTitle("sahana");
		Mockito.when(bookService.title(books.getBookid())).thenReturn(books.getTitle());
		RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/title");
		MvcResult result = (MvcResult) mockMvc.perform(requestBuilder)
				.andExpect(status().isOk());
		assertEquals(result.getResponse().getContentAsString(),books.getTitle(),"sahana");
	}


}
