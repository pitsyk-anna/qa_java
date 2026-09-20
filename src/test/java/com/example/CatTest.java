package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Мясо");
        when(feline.eatMeat()).thenReturn(expectedFood);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
    @Test
    public void testGetFoodDelegatesToPredator() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        verify(feline).eatMeat();
    }

}

