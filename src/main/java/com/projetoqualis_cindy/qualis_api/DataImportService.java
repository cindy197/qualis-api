package com.projetoqualis_cindy.qualis_api;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class DataImportService {

    @Autowired
    private PeriodicoRepository repository;

    @PostConstruct
    public void importData() {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("qualis.csv");

            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader();

            MappingIterator<Periodico> it = mapper.readerFor(Periodico.class)
                    .with(schema)
                    .readValues(is);
            List<Periodico> todos = it.readAll();

            repository.saveAll(todos);

            System.out.println(">>> SUCESSO: " + repository.count() + " registros carregados!");

        } catch (Exception e) {
            System.err.println("Erro ao importar dados: " + e.getMessage());
        }
    }
}