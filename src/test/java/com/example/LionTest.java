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
    public void maleLionHasMane() throws Exception {
    Lion lion = new Lion("Самец", feline);
    assertTrue(lion.doesHaveMane());
}

@Test
    public void femaleLionHasNoMane() throws Exception {
    Lion lion = new Lion("Самка", feline);
    assertFalse(lion.doesHaveMane());
}

@Test
    public void invalidSexLionThrowsException(){
    try {
        Lion lion = new Lion("Большой кот", feline);
        fail("Ожидалось исключение");
    } catch (Exception e) {
        assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
    }
}
    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }
    @Test
    public void getFoodDelegatesToFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);
        Lion lion = new Lion("Самец", feline);
        assertEquals(expected, lion.getFood());
        verify(feline).getFood("Хищник");
    }
}
