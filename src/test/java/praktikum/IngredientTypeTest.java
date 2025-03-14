package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType type;
    private final String name;

    public IngredientTypeTest(IngredientType type, String name){
        this.type = type;
        this.name = name;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientData(){
        return new Object[][]{
                {IngredientType.FILLING, "FILLING"},
                {IngredientType.SAUCE, "SAUCE"},
        };
    }
    @Test
    public void values(){
        Assert.assertEquals(name, type.name());
    }
}
