package com.cekosment.world.melesat.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cekosment.world.melesat.Model.Todo;

import java.util.List;

@Service
public class TodoService {

    @Value("${api.url}")
    private String apiUrl; // Menggunakan @Value untuk mengambil URL dari konfigurasi atau properties

    private final RestTemplate restTemplate;

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getTodos() {
        ResponseEntity<List<Todo>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {});
        return response.getBody();
    }
}

