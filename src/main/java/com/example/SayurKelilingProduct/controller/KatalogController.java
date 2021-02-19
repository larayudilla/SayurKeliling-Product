package com.example.SayurKelilingProduct.controller;

import com.example.SayurKelilingProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.SayurKelilingProduct.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/bakulSayur")
public class KatalogController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/{idBakulSayur}")
    public List<Product> daftarPelanggan(@PathVariable(value = "idBakulSayur") Long idBakulSayur) {
        return productRepository.getProductByKangSayur(idBakulSayur);
    }

    @GetMapping("/{idBakulSayur}/kategori/{idKategori}")
    public List<Product> getProductByKategori(@PathVariable(value = "idKategori") Long idKategori,@PathVariable(value = "idBakulSayur") Long idBakulSayur) {
        List<Product> product = productRepository.getByIDKategoris(idKategori,idBakulSayur);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }

    @GetMapping("/{idBakulSayur}/cariProduk")
    public List<Product> searchProduct(@RequestParam(required = false) String keyword, @PathVariable(value = "idBakulSyur") Long idBakulSayur) {
        List<Product> product = productRepository.search(keyword,idBakulSayur);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }

}