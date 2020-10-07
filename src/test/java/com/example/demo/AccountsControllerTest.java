package com.example.demo;

import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.IAccountService;
import com.example.demo.service.ITransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class AccountControllerTest {

	@MockBean
	IAccountRepository accountRepository;

	@MockBean
	IAccountService accountService;

	@MockBean
	ITransferService transferService;

	@Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

	@Test
	void getAllShouldReturnOk() throws Exception {

		when(accountService.getAllAccounts()).thenReturn(Collections.emptyList());

		when(accountRepository.findAll()).thenReturn(Collections.emptyList());

		this.mockMvc.perform(
				MockMvcRequestBuilders.get("/rest/accounts")
						.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk());

	}

    @Test
    void getOneByIdShouldReturnOk() throws Exception {
        Account account = new Account();
        when(accountService.getAccountById(anyLong())).thenReturn(account);
        when(accountRepository.findAccountById(anyLong())).thenReturn(account);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rest/account?id=1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void getOneByIdShouldReturnBadRequest() throws Exception {

        when(accountService.getAccountById(anyLong())).thenReturn(null);
        when(accountRepository.findAccountById(anyLong())).thenReturn(null);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rest/account?id=1")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNotFound());
    }

    @Test
    void transferWrongAmountShouldReturnBadRequest() throws Exception {
        Account account = new Account();
        when(transferService.transfer(anyLong(), anyLong(), anyDouble())).thenReturn(0);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/rest/transfer")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isMethodNotAllowed());
    }

}
