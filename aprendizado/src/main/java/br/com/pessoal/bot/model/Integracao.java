package br.com.pessoal.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "integracao")
public class Integracao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("token_grupo")
    @Column(name = "token_grupo", nullable = false)
    private String token;

    @JsonProperty("chat_id")
    @Column(name = "chat_id", nullable = false)
    private Long chatId;

    @JsonProperty("nome_grupo")
    @Column(name = "nome_grupo", nullable = false)
    private String nomeGrupo;
}
