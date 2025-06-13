import java.util.*;

public class Dictionary {
    private Set<String> words;
    private Random rand;
    private static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    // בנאי שמאתחל את רשימת המילים החוקיות
    public Dictionary() {
        words = new HashSet<>();
        rand = new Random();
        
        words.add("aaaaaaaaaa");
        words.add("b");
        words.add("c");
        words.add("d");
        words.add("e");
        words.add("f");

        // חיות
        words.add("cat");
        words.add("dog");
        words.add("elephant");
        words.add("tiger");
        words.add("lion");
        words.add("giraffe");
        words.add("zebra");
        words.add("monkey");
        words.add("horse");
        words.add("cow");
        words.add("sheep");
        words.add("goat");
        words.add("chicken");
        words.add("pig");
        words.add("bear");
        words.add("wolf");
        words.add("fox");
        words.add("rabbit");
        words.add("deer");

        // פירות
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("mango");
        words.add("grape");
        words.add("peach");
        words.add("plum");
        words.add("kiwi");
        words.add("melon");
        words.add("pear");
        words.add("cherry");
        words.add("pineapple");
        words.add("apricot");
        words.add("blueberry");
        words.add("strawberry");

        // ירקות
        words.add("carrot");
        words.add("potato");
        words.add("tomato");
        words.add("onion");
        words.add("cucumber");
        words.add("pepper");
        words.add("broccoli");
        words.add("cauliflower");
        words.add("lettuce");
        words.add("cabbage");
        words.add("spinach");
        words.add("zucchini");
        words.add("radish");
        words.add("garlic");
        words.add("pumpkin");
    }

    // בדיקה אם מילה חוקית
    public boolean isLegal(String word) {
        return words.contains(word.toLowerCase());
    }

    // החזרת אות רנדומלית
    public String getRandomLetter() {
        int index = rand.nextInt(LETTERS.length());
        return LETTERS.substring(index, index + 1);
    }
}