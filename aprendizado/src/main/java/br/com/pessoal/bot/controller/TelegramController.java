package br.com.pessoal.bot.controller;

import br.com.pessoal.bot.model.dto.ParametroEntrada;
import br.com.pessoal.bot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("telegram")
public class TelegramController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/getUpdate")
    public ResponseEntity<?> getUpdate(@RequestParam Long offset) {

        return ResponseEntity.ok(chatService.getUpdate(offset));
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody ParametroEntrada parametroEntrada) {
        try {

        return ResponseEntity.ok(chatService.sendMessage(parametroEntrada));

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
