package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void invalidSexLionThrowsException() {
        try {
            Lion lion = new Lion("Большой кот", feline);
            fail("Ожидалось исключение");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test
    public void getKittensReturnsCorrectValue() throws Exception {
        int expectedValue = 3;
        when(feline.getKittens()).thenReturn(expectedValue);
        Lion lion = new Lion("Самец", feline);
        int result = lion.getKittens();
        assertEquals(expectedValue, result);
    }

    @Test
    public void getKittensDelegatesCallToFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);
        List<String> result = lion.getFood();
        assertEquals(expectedFood, result);
    }
    @Test
    public void getFoodDelegatesCallToFeline() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }
    }

