package pl.sda.urbaniec.movie_mvc.web.controllers;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class HomeControllerTest {

    @Test
    public void homeTest() {
        HomeController homeController = new HomeController();
        String result = homeController.home();
        assertThat(result).isEqualTo("home");
    }
    @Test
    public void homeTestWithMock() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();

        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}