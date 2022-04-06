package br.com.leandrobarros.kafka.producerservice.controller;

import br.com.leandrobarros.kafka.producerservice.dto.PersonDto;
import br.com.leandrobarros.kafka.producerservice.producer.PersonProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonProducer personProducer;

    @PostMapping
    public ResponseEntity<PersonDto> sendPerson(@RequestBody PersonDto personDto) {
        personDto.setId(UUID.randomUUID().toString());
        personProducer.sendMessage(personDto);
        return ResponseEntity.ok().body(personDto);
    }
}
