package org.springframework.samples.petclinic.rest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.clinicService.ApplicationTestConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationTestConfig.class)
@WebAppConfiguration
public class ProductRestControllerTests {
	@Autowired
	private ProductRestController productRestController;

	@MockBean
	private ClinicService clinicService;

	private MockMvc mockMvc;

	private List<Product> products;

	@Before
	public void initProducts() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(productRestController)
				.setControllerAdvice(new ExceptionControllerAdvice()).build();

		products = new ArrayList<>();
		products.add(new Product("A"));
		products.add(new Product("B"));
	}

	@Test
	public void testGetAllProducts() throws Exception {
		given(this.clinicService.findAllProducts()).willReturn(products);
		this.mockMvc.perform(get("/api/products/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.[0].description").value("A")).andExpect(jsonPath("$.[1].description").value("B"))

		;
	}

}
