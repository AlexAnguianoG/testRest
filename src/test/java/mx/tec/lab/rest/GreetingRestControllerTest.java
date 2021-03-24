package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class GreetingRestControllerTest {
	@Autowired
	private	MockMvc mockMvc;

//	@Disabled
	@Test
	public void givenARequest_WhenEmptyName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
//	@Disabled
	@Test
	public void givenARequest_whenProvidedName_thenHelloName() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Jon"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, Jon!")));
	}
	
//	@Disabled
	@Test
	public void givenARequest_whenNullName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
//	@Disabled
	@Test
	public void givenARequest_whenWrongURL_thenError404() throws Exception {
		this.mockMvc.perform(get("/greting"))
			.andExpect(status().isNotFound());
	}
	
//	Goodbye Methods
	
//	@Disabled
	@Test
	public void givenARequest_WhenEmptyName_thenGoodbyeCruelWorld() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, Cruel World!")));
	}
	
//	@Disabled
	@Test
	public void givenARequest_whenProvidedName_thenGoodbyeName() throws Exception {
		this.mockMvc.perform(get("/goodbye?name=Cersei"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, Cersei!")));
	}

//	@Disabled
	@Test
	public void givenARequest_whenNullName_thenGoodbyeCruelWorld() throws Exception {
		this.mockMvc.perform(get("/goodbye?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, Cruel World!")));
	}
	
	
	
	
}