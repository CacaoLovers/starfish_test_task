package ru.avito.ads.controller.rest;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.avito.ads.PostgresTestContainer;
import ru.avito.ads.repository.AccountRepository;
import ru.avito.ads.repository.AdvertisementRepository;

@SpringBootTest
@AutoConfigureMockMvc
class AdvertisementRestControllerTest extends PostgresTestContainer {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void createAdvertisement_when_correct_data_then_return_response() throws Exception {

        String advertisement = "{\"title\": \"new adv\"}";

        MediaType responseType = new MediaType(MediaType.APPLICATION_JSON);

        mockMvc.perform(MockMvcRequestBuilders.post("/advertisement")
                        .content(advertisement)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("title", Is.is("new adv")))
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(responseType));
    }
}