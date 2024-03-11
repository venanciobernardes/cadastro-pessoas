package com.person.registration.controller;

import com.person.registration.entity.Person;
import com.person.registration.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService _service;
    private HttpClient _client;

    @Value("${token-api-gerador-pessoas}")
    private String TOKEN_CONSUMO_API;


    @GetMapping("/cadastro")
    public void save() {
        String uri = "https://api.invertexto.com/v1/faker?token=" + TOKEN_CONSUMO_API + "&fields=name,cpf&locale=pt_BR";
//        for (int i = 0; i < 1000; i++) {
            RestTemplate template = new RestTemplate();
            var person = template.getForObject(uri, Person.class);
            _service.save(person);
//        }
    }

    @GetMapping
    public List<Person> getAll() {
        return _service.getAll();
    }
}
