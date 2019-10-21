package com.example.second.Second;

import com.example.second.Second.Controller.BookController;
import com.example.second.Second.Entity.Books;
import com.example.second.Second.Services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
public class SpringBookControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;
   @Test
    public void booktitleTest() throws Exception {
        Books books=new Books();
        books.setBookid(1);
        books.setTitle("sahana");
        Mockito.when(bookService.title(books.getBookid())).thenReturn(books.getTitle());
        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/title");
        MvcResult result = (MvcResult) mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());
        assertEquals(result.getResponse().getContentAsString(),books.getTitle(),"sahana");
    }


    @Test
    public void booktitleTest() throws Exception {
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
