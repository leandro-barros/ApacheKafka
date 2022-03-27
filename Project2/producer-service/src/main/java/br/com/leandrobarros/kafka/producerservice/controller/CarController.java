package br.com.leandrobarros.kafka.producerservice.controller;

import br.com.leandrobarros.kafka.producerservice.dto.CarDto;
import br.com.leandrobarros.kafka.producerservice.producer.CarProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarProducer carProducer;

    @PostMapping
    public ResponseEntity<CarDto> creatMenssage(@RequestBody CarDto carDto) {
        carDto.setId(UUID.randomUUID().toString());
        carProducer.sendMessage(carDto);
        return ResponseEntity.ok().body(carDto);
    }
}
