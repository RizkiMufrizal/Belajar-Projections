package org.rizki.mufrizal.belajar.projections.controller;

import org.rizki.mufrizal.belajar.projections.domain.hql.ProductNamePriceHQL;
import org.rizki.mufrizal.belajar.projections.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = "/api/product/interface")
    public ResponseEntity<?> productInterface() {
        return new ResponseEntity<>(productRepository.findAllBy(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/product/interface/query")
    public ResponseEntity<?> productInterfaceQuery() {
        return new ResponseEntity<>(productRepository.findAllCustomQuery(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/product/dto/query")
    public ResponseEntity<?> productDtoQuery() {
        return new ResponseEntity<>(productRepository.getAllPrice(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/product/dto/custom")
    public ResponseEntity<?> productDtoCustom() {
        return new ResponseEntity<>(productRepository.findAllProduct(), HttpStatus.OK);
    }

    @GetMapping(value = "/api/product/dynamic")
    public ResponseEntity<?> productDynamic(@RequestParam(name = "name") String name) {
        return new ResponseEntity<>(productRepository.findByName(name, ProductNamePriceHQL.class), HttpStatus.OK);
    }

}