package br.com.pessoal.bot.repository;

import br.com.pessoal.bot.model.Integracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("integracao")
public interface IntegracaoDaoJpa extends JpaRepository<Integracao, Long> {

    @Query(value = "SELECT TOKEN_GRUPO FROM INTEGRACAO WHERE NOME_GRUPO = :nomeGrupo", nativeQuery = true)
    String buscarToken(@Param("nomeGrupo") String nomeGrupo);

    Optional<Integracao> findByNomeGrupo(String nomeGrupo);
}
