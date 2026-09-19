package com.example;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;


public class FelineTest {

 private Feline feline = new Feline();

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamilyReturnsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void getKittensReturnsDefaultOne() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithArgReturnsArg() {
        assertEquals(7, feline.getKittens(7));
    }
}
