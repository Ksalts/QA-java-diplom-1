package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String nameBun;
    private final float priceBun;

    public BunTest(String nameBun, float priceBun) {
        this.nameBun = nameBun;
        this.priceBun = priceBun;
    }

    @Parameterized.Parameters
    public static Object[][] getBun(){
        return new Object[][]{
                {"Булочка из пупырок", 100},
                {"Булочка с горькими крошками", 1000}
        };
    }

    @Test
    public void getNameBunAndPriceBun(){
        Bun bun = new Bun(nameBun, priceBun);
        Assert.assertEquals("Название булочки не совпадает", nameBun, bun.getName());
        Assert.assertEquals("Цена булочки не совпадает",priceBun, bun.getPrice(), 0.001);
        Assert.assertFalse("Название булочки не может быть пустым",nameBun.trim().isEmpty());
        Assert.assertTrue("Цена булочки не может быть отрицательной или 0", priceBun >= 0);

    }
}
