package com.example.SayurKelilingProduct.controller;

import com.example.SayurKelilingProduct.model.Kategori;
import com.example.SayurKelilingProduct.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.example.SayurKelilingProduct.form.KategoriForm;

import java.util.List;

@RestController
@RequestMapping("/api/kategori")
public class KategoriController {
    @Autowired
    KategoriRepository kategoriRepository;

    @GetMapping("/")
    public List<Kategori> listUser() {
        return kategoriRepository.findAll();
    }

    @PostMapping("/")
    public Kategori createKategory(@RequestBody KategoriForm kategoriForm) {
        Kategori kategori = new Kategori();
        kategori.setKategori(kategoriForm.getKategori());
        return kategoriRepository.save(kategori);
    }

    @GetMapping("/{idKategori}")
    public Kategori getUserByPhone(@PathVariable(value = "idKategori") Long idKategori) {
        Kategori kategori = kategoriRepository.findCategoryId(idKategori);
        if(kategori ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            return kategori;
        }
    }
    @PutMapping("/{idKategori}")
    public Kategori updateUser(@PathVariable(value = "idKategori") Long idKategori, @RequestBody KategoriForm kategoriForm) {
        Kategori kategoriData = kategoriRepository.findById(idKategori).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        kategoriData.setKategori(kategoriForm.getKategori());
        return kategoriRepository.save(kategoriData);
    }


    @DeleteMapping("/{idKategori}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "idKategori") Long idKategori) {
        Kategori kategori = kategoriRepository.findCategoryId(idKategori);
        if(kategori ==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }else{
            kategoriRepository.delete(kategori);
            return ResponseEntity.ok().build();
        }


    }
}
