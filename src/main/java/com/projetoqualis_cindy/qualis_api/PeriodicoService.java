package com.projetoqualis_cindy.qualis_api;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodicoService {
    private final PeriodicoRepository repository;
    public PeriodicoService(PeriodicoRepository repository) {
        this.repository = repository;
    }
    public Periodico buscarPorIssn(String issn) {
        return repository.findByIssn(issn).orElse(null);
    }
    public List<Periodico> buscarPorTitulo(String titulo) {
        return repository.findByTituloContainingIgnoreCase(titulo);
    }
    public List<Periodico> buscarPorArea(String area) {
        return repository.findByAreaAvaliacao(area);
    }
    public List<Periodico> buscarPorEstrato(String estrato) {
        return repository.findByEstrato(estrato);
    }
    public List<Periodico> buscarPorAreaEstrato(String area, String estrato) {
        return repository.findByAreaAvaliacaoAndEstrato(area, estrato);
    }
}
