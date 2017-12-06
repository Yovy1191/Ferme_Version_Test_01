package com.cgi.ferme;

import org.hamcrest.Matchers;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cgi.ferme.controlleur.FermeControlleur;
import com.cgi.ferme.service.IFermeService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = FermeControlleur.class)

public class FermeControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private IFermeService fermeserviceMock;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@Test
	public void testListFerme() throws Exception {

		assertThat(this.fermeserviceMock).isNotNull();
		mockMvc.perform(MockMvcRequestBuilders.get("/ferme")).andExpect(status().isOk())
				.andExpect(content().contentType("text/html;charset=UTF-8")).andExpect(view().name("ferme"))
				.andExpect(MockMvcResultMatchers.view().name("ferme"))
				.andExpect(content().string(Matchers.containsString("Ferme 2.0"))).andDo(print());
	}

}
