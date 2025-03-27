package com.example.dropdownjavaapp.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
public class LocationController {
    @GetMapping("/locations")
    public Map<String, Object> getLocations() {
        String url = "https://gist.githubusercontent.com/emamut/6626d3dff58598b624a1/raw/166183f4520c4603987c55498df8d2983703c316/provincias.json";
        RestTemplate restTemplate = new RestTemplate();
        
        try {
            // Obtener la respuesta como String
            String response = restTemplate.getForObject(url, String.class);

            // Convertir la respuesta a un Map
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(response, new TypeReference<Map<String, Object>>() {});
          //return restTemplate.getForObject(url, Map.class);
    
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener o procesar los datos", e);
        }
    }
}