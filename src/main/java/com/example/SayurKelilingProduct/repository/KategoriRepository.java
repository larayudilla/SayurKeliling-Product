package com.example.SayurKelilingProduct.repository;

import com.example.SayurKelilingProduct.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KategoriRepository extends JpaRepository<Kategori,Long>,KategoriRepositoryCustom {
}
