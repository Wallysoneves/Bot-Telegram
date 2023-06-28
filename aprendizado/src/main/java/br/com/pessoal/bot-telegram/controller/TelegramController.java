package br.com.pessoal.aprendizado.controller;

import br.com.pessoal.aprendizado.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("telegram")
public class TelegramController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/getUpdate")
    public ResponseEntity<?> getUpdate() {

        return ResponseEntity.ok(chatService.getUpdate());
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public ResponseEntity<?> sendMessage() {
        return ResponseEntity.ok(chatService.sendMessage());
    }
}
