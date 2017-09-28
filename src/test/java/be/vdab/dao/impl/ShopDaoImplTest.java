package be.vdab.dao.impl;

import be.vdab.entiteiten.Eshop;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopDaoImplTest {

    private ShopDaoImpl shopDaoImpl;
    private List<Eshop> eshopList;

    @Before
    public void init() {
        shopDaoImpl = new ShopDaoImpl();
        eshopList = new ArrayList<>();
    }

    @Test
    public void listAllShops() {
        eshopList = shopDaoImpl.listAllShops();
        assertThat(eshopList).isInstanceOf(List.class);
        assertThat(eshopList).hasSize(2);
        /*assertThat(shopDaoImpl.listAllShops().get(0)).isEqualTo(eshop); werkt niet omdat de hashcode van 2 "dezelfde" objecten niet altijd gelijk zijn*/
        assertThat(shopDaoImpl.listAllShops().get(0).getInfo()).isEqualTo("Gitaarshop IBO");
    }
}