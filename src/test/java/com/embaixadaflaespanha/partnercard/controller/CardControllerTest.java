package com.embaixadaflaespanha.partnercard.controller;

import com.embaixadaflaespanha.partnercard.service.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService service;

    @Test
    void shouldReturnOk_whenGetPartnerValidId() throws Exception {
        when(service.getCardForPartner(anyInt())).thenReturn(any());

        mockMvc.perform(get("/card/{id}", "1"))
                .andExpect(status().isOk());
    }

}