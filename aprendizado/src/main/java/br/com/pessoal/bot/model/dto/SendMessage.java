package br.com.pessoal.bot.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendMessage {

    @JsonProperty("chat_id")
    private Long chatId;

    @JsonProperty("text")
    private String mensagem;
}
