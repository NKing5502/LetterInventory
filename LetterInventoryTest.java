// Nick King
// October 9th, 2024
// CS 145
// LetterImvemtoryTest

public class LetterInventoryTest {
    public static void main(String[] args) {
        // Tests the constructor
        LetterInventory inventory1 = new LetterInventory("George W. Bush");
        System.out.println(inventory1);  // Expected: [beegghorsuw]
        
        // Tests get method
        System.out.println("Count of 'g': " + inventory1.get('g'));  // Expected: 2

        // Tests set method
        inventory1.set('g', 5);
        System.out.println("New count of 'g': " + inventory1.get('g'));  // Expected: 5

        // Tests size method
        System.out.println("Total size: " + inventory1.size());  // Expected: updated total size

        // Tests isEmpty method
        LetterInventory emptyInventory = new LetterInventory("");
        System.out.println("Is empty inventory empty? " + emptyInventory.isEmpty());  // Expected: true

        // Tests toString method
        System.out.println("String representation: " + inventory1);  // Expected: updated string with counts

        // Tests add method
        LetterInventory inventory2 = new LetterInventory("Hillary Clinton");
        LetterInventory sum = inventory1.add(inventory2);
        System.out.println("Sum of inventories: " + sum);  // Expected: combined letter counts

        // Tests subtract method
        LetterInventory diff = inventory1.subtract(inventory2);
        if (diff != null) {
            System.out.println("Difference of inventories: " + diff);  // Expected: subtracted letter counts or null
        } else {
            System.out.println("Subtraction resulted in negative counts, returning null.");
        }
    }
}
