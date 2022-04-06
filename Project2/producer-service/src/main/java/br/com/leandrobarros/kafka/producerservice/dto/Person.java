package br.com.leandrobarros.kafka.producerservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String name;

    private Integer age;

}
