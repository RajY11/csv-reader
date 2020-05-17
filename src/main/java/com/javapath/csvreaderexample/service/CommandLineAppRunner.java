package com.javapath.csvreaderexample.service;

import com.javapath.csvreaderexample.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineAppRunner implements CommandLineRunner {

    private static final String FILE_NAME = "src/main/resources/products.csv";
    private List<Product> products = new ArrayList<>();
    private CSVReaderUtil readerUtil;
    private ProductUtil productUtil;
    private static final Logger LOG = LoggerFactory.getLogger(CommandLineAppRunner.class);

    public CommandLineAppRunner(CSVReaderUtil readerUtil,ProductUtil productUtil){
        this.readerUtil = readerUtil;
        this.productUtil = productUtil;
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Calling data reader service....");
        List<String[]> data = readerUtil.getProductsFromCSV(FILE_NAME);
        LOG.info("calling product filter service.....");
        products = productUtil.getProducts(data);
        LOG.info("list of products with given condition");
        products.forEach(product -> LOG.info("ID: {}   Name : {}    Price : {}",product.getId(),product.getName(),product.getPrice()));

    }
}
