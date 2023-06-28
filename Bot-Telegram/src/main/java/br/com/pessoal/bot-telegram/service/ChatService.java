package br.com.pessoal.aprendizado.service;

import br.com.pessoal.aprendizado.config.cache.CacheTelegram;
import br.com.pessoal.aprendizado.model.dto.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private Properties properties;

    @Autowired
    private CacheTelegram cacheTelegram;

    public Object getUpdate() {

        String url = String.format("%s%s/getUpdates", properties.getUrl(), cacheTelegram.buscarToken());

        RestTemplate request = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                                        .queryParam("offset", 100);

        ResponseEntity<String> response = request.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
        return response.getBody();
    }

    public Object sendMessage() {

        String url = String.format("%s%s/sendMessage", properties.getUrl(), cacheTelegram.buscarToken());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = "{ \"chat_id\": -1001670387445, \"text\": \"testeeeeeeeeeeeeeeeeee \"}";

        HttpEntity<String> httpEntity = new HttpEntity<>(json, headers);

        RestTemplate request = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        ResponseEntity<String> response = request.exchange(builder.toUriString()
                                                         , HttpMethod.POST
                                                         , httpEntity
                                                         , String.class);
        return response.getBody();
    }
}
