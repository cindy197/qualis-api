package com.projetoqualis_cindy.qualis_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Periodico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("ISSN")
    @Column(name = "issn")
    private String issn;

    @JsonProperty("Título")
    @Column(name = "titulo")
    private String titulo;

    @JsonProperty("Área de Avaliação")
    @Column(name = "area_avaliacao")
    private String areaAvaliacao;

    @JsonProperty("Estrato")
    @Column(name = "estrato")
    private String estrato;
}