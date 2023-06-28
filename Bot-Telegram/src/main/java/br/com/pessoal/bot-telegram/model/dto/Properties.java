package br.com.pessoal.aprendizado.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties(prefix = "telegram")
public class Properties implements Serializable {

    private static final long serialVersionUID = 1L;

    private String token;

    private String url;
}
