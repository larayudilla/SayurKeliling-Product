package com.example.SayurKelilingProduct.controller;

import com.example.SayurKelilingProduct.form.ProductForm;
import com.example.SayurKelilingProduct.model.Kategori;
import com.example.SayurKelilingProduct.model.Product;
import com.example.SayurKelilingProduct.repository.KategoriRepository;
import com.example.SayurKelilingProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    KategoriRepository kategoriRepository;

    @GetMapping("/")
    public List<Product> daftarPelanggan() {
        return productRepository.findAll();
    }

    @PostMapping("/")
    public Product createKategory(@RequestBody ProductForm productForm) {
        Kategori kategoriData = kategoriRepository.findCategoryId(productForm.getIdKategori());
        if(kategoriData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            Product product = new Product();
            product.setPrice(productForm.getPrice());
            product.setProductName(productForm.getProductName());
            product.setIdKategori(productForm.getIdKategori());
            product.setIdUser(productForm.getIdUser());
            return productRepository.save(product);
        }
    }
    @GetMapping("/{idProduct}")
    public Product getProductById(@PathVariable(value = "idProduct") Long idProduct) {
        Product product = productRepository.getByIDs(idProduct);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return product;
        }
    }

    @PutMapping("/{idProduct}")
    public Product updatePelanggan(@PathVariable(value = "idProduct") Long idProduct, @RequestBody ProductForm productForm) {
        Product productData = productRepository.getByIDs(idProduct);
        if(productData ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            Product product = new Product();
            product.setIdKategori(productForm.getIdKategori());
            product.setIdUser(productForm.getIdUser());
            product.setProductName(productForm.getProductName());
            product.setPrice(productForm.getPrice());
            return productRepository.save(product);
        }
    }
    @DeleteMapping("/{idProduct}")
    public ResponseEntity<?> delete(@PathVariable(value = "idProduct") Long idProduct) {
        Product product = productRepository.getByIDs(idProduct);
        if(product ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            productRepository.deleteById(idProduct);
            return ResponseEntity.ok().build();
        }
    }
}