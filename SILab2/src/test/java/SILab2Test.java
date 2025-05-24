import org.example.Item;
import org.example.SILab2;
import org.junit.jupiter.api.Test;
import org.example.SILab2.*;


import java.awt.event.ItemEvent;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    private final String validCard = "1111222233334444";

    @Test
    public void testEveryStatement() {
        // Null листа
        RuntimeException ex1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, validCard));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // Invalid item
        Item i1 = new Item(null, 1, 100, 0);
        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(i1), validCard));
        assertEquals("Invalid item!", ex2.getMessage());

        // Invalid card number
        Item validItem = new Item("banana", 1, 100, 0);
        RuntimeException ex3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(List.of(validItem), "123ABC"));
        assertEquals("Invalid card number!", ex3.getMessage());

        // Valid scenario without discount
        Item okItem = new Item("banana", 1, 100, 0);
        double total = SILab2.checkCart(List.of(okItem), validCard);
        assertEquals(100, total);

        // Valid scenario with discount
        Item milk = new Item("milk", 2, 400, 0.25);
        double totalMilk = SILab2.checkCart(List.of(milk), validCard);
        assertEquals(570.0, totalMilk);
    }

    @Test
    public void testMultipleCondition() {
        // A=false, B=false, C=false
        Item a = new Item("A", 5, 100, 0);
        assertEquals(100*5, SILab2.checkCart(List.of(a), validCard));

        // A=true
        Item b = new Item("B", 5, 400, 0);
        assertEquals(400*5 - 30, SILab2.checkCart(List.of(b), validCard));

        // B=true
        Item c = new Item("C", 5, 100, 0.1);
        assertEquals(100*0.9*5 - 30, SILab2.checkCart(List.of(c), validCard));

        // C=true
        Item d = new Item("D", 20, 100, 0);
        assertEquals(100*20 - 30, SILab2.checkCart(List.of(d), validCard));

        // A + B + C = true
        Item e = new Item("E", 20, 400, 0.5);
        assertEquals(400*0.5*20 - 30, SILab2.checkCart(List.of(e), validCard));
    }
}
