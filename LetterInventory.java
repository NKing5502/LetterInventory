// Nick King
// October 9th, 2024
// CS 145
// Lab 3, Letter Inventory

// The LetterInventory class represents the letters within the english alphabet.
public class LetterInventory {
    private int[] inventory;  // Array to store counts of letters
    private int size;         // Totals number of letters
    private static final int ALPHABET_SIZE = 26;  // Class constant for 26 letters

    // Constructor
    public LetterInventory(String data) {
        inventory = new int[ALPHABET_SIZE];
        size = 0;
        data = data.toLowerCase();  // Ignore case

        // Counts letters
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                inventory[ch - 'a']++;
                size++;
            }
        }
    }

    // Returns the count of a specific letter
    public int get(char letter) {
        letter = Character.toLowerCase(letter);
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Invalid character: " + letter);
        }
        return inventory[letter - 'a'];
    }

    // Sets the count for a specific letter
    public void set(char letter, int value) {
        letter = Character.toLowerCase(letter);
        if (!Character.isLetter(letter) || value < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        size += value - inventory[letter - 'a'];  // Updates size based on value change
        inventory[letter - 'a'] = value;
    }

    // Returns the total count of letters
    public int size() {
        return size;
    }

    // Returns true if the inventory is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Returns the inventory as a sorted string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < inventory[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // Addss two inventories together
    public LetterInventory add(LetterInventory other) {
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            result.inventory[i] = this.inventory[i] + other.inventory[i];
        }
        result.size = this.size + other.size;
        return result;
    }

    // Subtracts one inventory from another
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            result.inventory[i] = this.inventory[i] - other.inventory[i];
            if (result.inventory[i] < 0) {
                return null;  // If any count goes negative, return null
            }
        }
        result.size = this.size - other.size;
        return result;
    }
}
    