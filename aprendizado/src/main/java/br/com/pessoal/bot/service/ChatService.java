package br.com.pessoal.bot.service;

import br.com.pessoal.bot.config.cache.CacheTelegram;
import br.com.pessoal.bot.model.Integracao;
import br.com.pessoal.bot.model.dto.ParametroEntrada;
import br.com.pessoal.bot.model.dto.Properties;
import br.com.pessoal.bot.model.dto.SendMessage;
import br.com.pessoal.bot.repository.IntegracaoDaoJpa;
import br.com.pessoal.bot.rotas.TelegramRotas;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ChatService {

    @Autowired
    private Properties properties;

    @Autowired
    private CacheTelegram cacheTelegram;

    @Autowired
    private TelegramRotas telegramRotas;

    @Autowired
    private IntegracaoDaoJpa integracaoDaoJpa;

    public Object getUpdate(ParametroEntrada parametroEntrada) {

        String url = String.format("%s%s/getUpdates", properties.getUrl(), cacheTelegram.buscarToken(parametroEntrada.getNomeGrupo()));

        RestTemplate request = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                                        .queryParam("offset", 100);

        ResponseEntity<String> response = request.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
        return response.getBody();
    }

    public Object sendMessage(ParametroEntrada parametroEntrada) throws Exception {

        Integracao integracao = integracaoDaoJpa.findByNomeGrupo(parametroEntrada.getNomeGrupo()).orElse(null);

        if (Objects.isNull(integracao)) {
            throw new Exception("Erro na busca da integração");
        }

        StringBuilder sb = new StringBuilder();
            sb.append(parametroEntrada.getTitulo());
            sb.append("\n\n");
            sb.append(parametroEntrada.getMensagem());

        SendMessage sendMessage = SendMessage.builder()
                                             .chatId(integracao.getChatId())
                                             .mensagem(sb.toString())
                                             .build();

        ResponseEntity<String> response = telegramRotas.sendMessage(sendMessage);

        return response.getBody();
    }
}
