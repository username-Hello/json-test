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
        String jsonString = "{\"beerId\":\"e86ee9a5-f878-49db-986a-3ef7b8003654\",\"beerName\":\"Cool beer\",\"beerStyle\":\"Ale\",\"upc\":1123123123123,\"price\":100,\"createdDate\":\"2019-06-03 21:01 -04:00\",\"lastUpdatedDate\":\"2021-11-16T02:26:30.55217+03:00\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}