package com.projetoqualis_cindy.qualis_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface PeriodicoRepository extends JpaRepository<Periodico, Long> {

    Optional<Periodico> findByIssn(String issn);
    List<Periodico> findByTituloContainingIgnoreCase(String titulo);
    List<Periodico> findByAreaAvaliacao(String area);
    List<Periodico> findByEstrato(String estrato);
    List<Periodico> findByAreaAvaliacaoAndEstrato(String area, String estrato);

}