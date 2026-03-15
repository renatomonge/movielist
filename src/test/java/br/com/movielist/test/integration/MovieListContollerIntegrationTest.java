package br.com.movielist.test.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.movielist.MovieListApplication;

public class MovieListContollerIntegrationTest extends BaseIntegrationTest {	
	
	@Test
	public void teste() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/movielist/producers-min-max-interval")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			//max
			.andExpect(MockMvcResultMatchers.jsonPath("$.max", Matchers.notNullValue()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.max[0].producer", Matchers.is("Jerry Weintraub")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.max[0].interval", Matchers.is(18)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.max[0].previousWin", Matchers.is(1980)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.max[0].followingWin", Matchers.is(1998)))
            //min
			.andExpect(MockMvcResultMatchers.jsonPath("$.min", Matchers.notNullValue()))
			.andExpect(MockMvcResultMatchers.jsonPath("$.min[0].producer", Matchers.is("Wyck Godfrey, Stephenie Meyer and Karen Rosenfelt")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.min[0].interval", Matchers.is(1)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.min[0].previousWin", Matchers.is(2011)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.min[0].followingWin", Matchers.is(2012)));;
	}
}
