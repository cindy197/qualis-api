package br.com.cindy.qualis;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.projetoqualis_cindy.qualis_api.PeriodicoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class DataImportService {}

@Autowired
private PeriodicoRepository repository;

@PostConstruct
    public void importData(){
    
}