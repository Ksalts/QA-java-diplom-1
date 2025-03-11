package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun mockBun;
    @Mock
    private  Ingredient mockIngredientOne;
    @Mock
    private Ingredient mockIngredientTwo;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
        burger.setBuns(mockBun);
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(mockIngredientOne);
        ingredients.add(mockIngredientTwo);
        burger.ingredients = ingredients;
    }

    @Test
    public void testGetPrice(){
        when(mockBun.getPrice()).thenReturn(1.0f);
        when(mockIngredientOne.getPrice()).thenReturn(0.5f);
        when(mockIngredientTwo.getPrice()).thenReturn(0.7f);
        float expectedPrice = 3.2f;
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }
    @Test
    public void testGetReceipt(){
        when(mockBun.getName()).thenReturn("Bun");
        when(mockIngredientOne.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredientOne.getName()).thenReturn("Cheese");
        when(mockIngredientTwo.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredientTwo.getName()).thenReturn("Mayo");
        String expectedReceipt = "(==== Bun ====)\r\n" +
                "= filling Cheese =\r\n" +
                "= sauce Mayo =\r\n" +
                "(==== Bun ====)\r\n" +
                "\r\n" +
                "Price: 0,000000\r\n";
        String actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    public void testAddIngredient(){
        Ingredient newIngredient = mock(Ingredient.class);
        burger.addIngredient(newIngredient);
        assertEquals(3, burger.ingredients.size());
        assertEquals(newIngredient, burger.ingredients.get(2));
    }
    @Test
    public void testRemoveIngredient(){
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredientTwo,burger.ingredients.get(0));
    }

    @Test
    public void testMoveIngredient(){
        burger.moveIngredient(0,1);
        assertEquals(2,burger.ingredients.size());
        assertEquals(mockIngredientTwo, burger.ingredients.get(0));
        assertEquals(mockIngredientOne, burger.ingredients.get(1));
    }
}
