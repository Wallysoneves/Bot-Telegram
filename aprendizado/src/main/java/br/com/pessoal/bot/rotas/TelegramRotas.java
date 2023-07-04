package br.com.pessoal.bot.rotas;

import br.com.pessoal.bot.model.dto.SendMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "${telegram.url}", name = "integracao")
public interface TelegramRotas {

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> sendMessage(@RequestBody SendMessage sendMessage);
}
