package be.vdab.entiteiten;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class EshopTest {

    Eshop eshop;

    @Before
    public void init() {
        eshop = new Eshop(3, "testEshoP", "testADDREss", "teSTplAAts");
    }

    @Test
    public void getShopNumber()  {
        assertThat(eshop.getShopNumber()).isEqualTo(3);
    }

    @Test
    public void getInfo()  {
        assertThat(eshop.getInfo()).isEqualTo("testEshoP");
    }

    @Test
    public void getAddress()  {
        assertThat(eshop.getAddress()).isEqualTo("testADDREss");
    }

    @Test
    public void getPlaats()  {
        assertThat(eshop.getPlaats()).isEqualTo("teSTplAAts");
    }

}