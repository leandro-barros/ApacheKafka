package br.com.leandrobarros.kafka.producerservice.dto;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class CarDto {

    private String id;

    private String model;

    private String color;

}
