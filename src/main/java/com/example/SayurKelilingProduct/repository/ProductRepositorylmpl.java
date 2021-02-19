package com.example.SayurKelilingProduct.repository;
import com.example.SayurKelilingProduct.model.Product;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProductRepositorylmpl implements  ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product getByIDs(Long idProduct) {
        return null;
    }

    @Override
    public List<Product> getProductByKangSayur(Long idUser) {
        return null;
    }

    @Override
    public List<Product> getByIDKategoris(Long idKategori,Long idUser) {
        return null;
    }

    @Override
    public List<Product> search(String keyword,Long idUser) {
        return null;
    }







}
