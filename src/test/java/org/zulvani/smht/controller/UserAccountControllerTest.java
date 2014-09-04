package org.zulvani.smht.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.zulvani.smht.domain.UserAccounts;
import org.zulvani.smht.service.AuthManagerService;

@RunWith(MockitoJUnitRunner.class)
public class UserAccountControllerTest {

  @Mock
  private AuthManagerService authManagerService;
  
  private MockMvc mockMvc;

  @InjectMocks
  private UserController userAccountController;

  @Before
  public void setup() {
//    MockitoAnnotations.initMocks(this);

    List<UserAccounts> useraccounts = new ArrayList<UserAccounts>();
    useraccounts.add(new UserAccounts(1, "agus.zulvani@softwareseni.com", "testabc"));
    
    when(authManagerService.findAllUserAccounts()).thenReturn(useraccounts);
    
    mockMvc = MockMvcBuilders.standaloneSetup(userAccountController).build();
  }

  @Test
  public void testCall() throws Exception {
    mockMvc.perform(get("/useraccounts").param("name", "test")).andExpect(
        status().isOk());
  }
}