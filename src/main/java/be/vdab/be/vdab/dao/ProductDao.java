package be.vdab.be.vdab.dao;

import be.vdab.entiteiten.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findProducts(String productname);
    List<Product> getProductList();
}
