package br.com.movielist.test.integration;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.movielist.repository.MovieListRepository;

@TestMethodOrder(OrderAnnotation.class)
public class MovieListContollerIntegrationTest extends BaseIntegrationTest {
	
	@Autowired
	private MovieListRepository movieListRepository;
	
	@Test
	@Order(1)
	public void testMinMaxProducersIntervalReturned() throws Exception {				
		mvc.perform(MockMvcRequestBuilders.get("/movielist/producers-min-max-interval")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			//max
			.andExpect(jsonPath("$.max", notNullValue()))
			.andExpect(jsonPath("$.max[0].producer", is("Bo Derek")))
            .andExpect(jsonPath("$.max[0].interval", is(6)))
            .andExpect(jsonPath("$.max[0].previousWin", is(1984)))
            .andExpect(jsonPath("$.max[0].followingWin", is(1990)))
            //min
			.andExpect(jsonPath("$.min", notNullValue()))
			.andExpect(jsonPath("$.min[0].producer", is("Bo Derek")))
            .andExpect(jsonPath("$.min[0].interval", is(6)))
            .andExpect(jsonPath("$.min[0].previousWin", is(1984)))
            .andExpect(jsonPath("$.min[0].followingWin", is(1990)));
	}
	
	@Test
	@Order(2)
	public void testMinMaxProducersEnpty() throws Exception {		
		movieListRepository.deleteAll();
		
		mvc.perform(MockMvcRequestBuilders.get("/movielist/producers-min-max-interval")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			//max
			.andExpect(jsonPath("$.max", empty()))
            //min
			.andExpect(jsonPath("$.min", empty()));			
	}
	
}
