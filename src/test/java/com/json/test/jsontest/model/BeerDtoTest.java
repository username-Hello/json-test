package com.json.test.jsontest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;


@JsonTest
class BeerDtoTest extends BaseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void serializeJson() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void deserializeJson() throws IOException {
        String jsonString = "{\"beerName\":\"Cool beer\",\"beerStyle\":\"Ale\",\"upc\":1123123123123,\"price\":\"100\",\"createdDate\":\"2021-11-21 14:59 +03:00\",\"lastUpdatedDate\":\"2021-11-21T14:59:22.846039+03:00\",\"myLocalDate\":\"20211121\",\"beerId\":\"3e387001-878a-4446-a3ea-3ea2553f945d\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}