package be.vdab.dao.impl;

import be.vdab.be.vdab.dao.ProductDao;
import be.vdab.entiteiten.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ProductDaoImplTest {

    List<Product> productList;
    ProductDao productDao;

    @Before
    public void init() {
        productList = new ArrayList<>();
        productDao = new ProductDaoImpl();
    }
    @Test
    public void testFindProducts() {
        productList = productDao.findProducts("Fender");
        assertThat(productList).isInstanceOf(List.class);
        assertThat(productList).extracting(Product::getProductId).contains(1001,1002,1003);
    }

}