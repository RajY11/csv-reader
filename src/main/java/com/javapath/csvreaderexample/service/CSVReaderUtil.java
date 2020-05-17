package com.javapath.csvreaderexample.service;

import com.javapath.csvreaderexample.models.Product;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderUtil {

    private static final Logger LOG = LoggerFactory.getLogger(CSVReaderUtil.class);

    public CSVReaderUtil(){

    }

    public List<String[]> getProductsFromCSV(String fileName) throws IOException, CsvException {
        List<Product> products = new ArrayList<>();
        LOG.info("Loading {}.csv file......",fileName);
        FileReader fileReader = new FileReader(fileName);
        LOG.info("Reding data from files....");
        CSVReader csvReader = new CSVReaderBuilder(fileReader)
                                    .withSkipLines(1)
                                    .build();
        List<String[]> data = csvReader.readAll();
        LOG.info("Read completed, processing the file");
        return data;
    }
}
