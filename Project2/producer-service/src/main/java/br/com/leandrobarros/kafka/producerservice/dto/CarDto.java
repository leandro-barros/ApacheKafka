package br.com.leandrobarros.kafka.producerservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CarDto {

    private String id;

    private String model;

    private String color;

}
