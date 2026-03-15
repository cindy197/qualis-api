package com.projetoqualis_cindy.qualis_api;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Periodico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco gera o 1, 2, 3... automaticamente

    private Long id;

    private String issn;
    private String titulo;
    private String areaAvaliacao;
    private String estrato;
}
