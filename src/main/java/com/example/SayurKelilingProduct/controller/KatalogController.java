package com.example.SayurKelilingProduct.controller;

import com.example.SayurKelilingProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.SayurKelilingProduct.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/grobak")
public class KatalogController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{idGrobak}")
    public List<Product> listUser(@PathVariable(value = "idGrobak") Long idGrobak) {
        return productRepository.getProductByKangSayur(idGrobak);
    }

    @GetMapping("/{idGrobak}/kategori/{idKategori}")
    public List<Product> getProductByKategori(@PathVariable(value = "idKategori") Long idKategori,@PathVariable(value = "idGrobak") Long idGrobak) {
        List<Product> product = productRepository.getByIDKategoris(idKategori,idGrobak);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }

    @GetMapping("/{idGrobak}/search")
    public List<Product> searchProduct(@RequestParam(required = false) String keyword, @PathVariable(value = "idGrobak") Long idGrobak) {
        List<Product> product = productRepository.search(keyword,idGrobak);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }

}