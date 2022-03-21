package br.com.leandrobarros.kafka.producerservice.controller;

import br.com.leandrobarros.kafka.producerservice.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("publish-message")
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        messageService.setMessageTopicProducer(message);
        return ResponseEntity.ok().body("Mensagem enviada com sucesso: " + message);
    }
}
