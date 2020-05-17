package com.javapath.csvreaderexample.service;

import com.javapath.csvreaderexample.models.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ProductUtil.class);

    // filtering produts with price more than 5000
    public List<Product> getProducts(List<String[]> data){
        List<Product> products = new ArrayList<>();
        LOG.info("Filtering data with given conditon....");
        data.stream().filter(d->Double.parseDouble(d[2])>=5000)
                .forEach(d-> {
                    Product product = new Product();
                    product.setId(Integer.parseInt(d[0]));
                    product.setName(d[1]);
                    product.setPrice(Double.parseDouble(d[2]));
                    products.add(product);
                });
        LOG.info("Filtering completed, preparing list of products....");
        return products;
    }
}
