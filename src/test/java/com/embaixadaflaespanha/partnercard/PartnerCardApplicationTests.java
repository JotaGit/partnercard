package com.embaixadaflaespanha.partnercard;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.embaixadaflaespanha.partnercard.utils.TestUtils.getResourceAsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class PartnerCardApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnUserInformation_whenReceiveALoginId() throws Exception {
        final JsonNode jsonExpected = objectMapper.readTree(getResourceAsString("/responses/get-card-1.json"));

        final String response = mockMvc.perform(get("/card/{cardId}", "1"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertThat(response).isNotEmpty();
        assertThat(objectMapper.readTree(response))
                .hasSameElementsAs(jsonExpected);
    }
}
