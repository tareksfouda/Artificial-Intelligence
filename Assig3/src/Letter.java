
public class Letter {
    public int wordIndex;
    public char character;

    public Letter(int wordIndex, char ch) {
        this.wordIndex = wordIndex;
        this.character = ch;
    }
    public static Letter[] lettersFromString(String str, int wordIndex) {
        Letter[] letters = new Letter[str.length()];
        for (int i = 0; i < str.length(); i++) {
            letters[i] = new Letter(wordIndex, str.charAt(i));
        }

        return letters;
    }
}
