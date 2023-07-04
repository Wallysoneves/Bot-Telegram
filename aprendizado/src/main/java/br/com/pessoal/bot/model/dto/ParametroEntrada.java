package br.com.pessoal.bot.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroEntrada {

    private String nomeGrupo;

    private String titulo;

    private String mensagem;
}
