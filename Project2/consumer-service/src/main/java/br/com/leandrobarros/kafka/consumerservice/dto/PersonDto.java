package br.com.leandrobarros.kafka.consumerservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDto implements Serializable {

    private String id;

    private String name;

    private Integer age;

}
