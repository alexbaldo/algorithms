package exercises;

public class Exercise_1_1_04 {
    
    public static void main (String[] args) {
        int a = 2, b = 1, c = 0;
        // if (a > b) then c = 0;       // "then" is invalid.
        // if a > b { c = 0; }          // lacks parentheses.
        if (a > b) c = 0;               // correct.
        // if (a > b) c = 0 else b = 0; // missing semicolon after "c = 0".
        System.out.println(c);
    }
}
