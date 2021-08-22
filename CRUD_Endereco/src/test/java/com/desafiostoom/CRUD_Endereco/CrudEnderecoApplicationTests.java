package com.desafiostoom.CRUD_Endereco;

import com.desafiostoom.CRUD_Endereco.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class CrudEnderecoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void testeFindById_deveRetornarOk() throws Exception {
		this.mockMvc.perform(get("/endereco/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"id\":2,\"streetName\":\"Joao Flora\"")));
	}

	@Test
	public void testeFindById_deveRetornarErro() throws Exception {
		this.mockMvc.perform(get("/endereco/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"id\":999,\"streetName\":\"Joao Flora\"")));
	}

	@Test
	public void testfindAll() throws Exception {
		Endereco endereco = new Endereco();
		endereco.setCity("SGS");
		endereco.setComplement("Casa");
		endereco.setCountry("Brasil");
		endereco.setId(2L);
		endereco.setLatitude("123");
		endereco.setLongitude("333");
		endereco.setNeighbourhood("Centro");
		endereco.setNumber("165");
		endereco.setState("MG");
		endereco.setStreetName("Joao Flora");
		endereco.setZipcode("37490000");
		// List<Endereco> enderecos = Arrays.asList(endereco);
		/*
		 * mockMvc.when(enderecoRepository.findAll()).thenReturn(endereco);
		 * 
		 * mockMvc.perform(get("/endereco")).andExpect(status().isOk()).andExpect(
		 * jsonPath("$", Matchers.hasSize(1))) .andExpect(jsonPath("$[0].streetName",
		 * Matchers.is("Joao Flora")));
		 */
	}

}
