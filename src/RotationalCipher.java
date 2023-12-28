public class RotationalCipher {
    private static final int maxUpperCaseAscii = 90;
    private static final int minUpperCaseAscii = 65;
    private static final int maxLowerCaseAscii = 122;
    private static final int minLowerCaseAscii = 97;

    public static void main(String[] args) {
        String cipheredString = RotationalCipher.cipher("The quick brown fox jumps over the lazy dog.", 13);
        System.out.printf("Ciphered text: %s%n", cipheredString);
    }

    public static String cipher(String string, int rotation) {
        StringBuilder cipheredWord = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            int ascii = string.charAt(i);
            if (ascii == 46) {
                cipheredWord.append(".");
            } else if (ascii < maxUpperCaseAscii && ascii >= minUpperCaseAscii) {
                cipheredWord.append(RotationalCipher.transform(ascii, rotation, maxUpperCaseAscii, minUpperCaseAscii));
            } else if (ascii >= minLowerCaseAscii) {
                cipheredWord.append(RotationalCipher.transform(ascii, rotation, maxLowerCaseAscii, minLowerCaseAscii));
            }
            else{
                cipheredWord.append(string.charAt(i));
            }
        }
        return cipheredWord.toString();
    }

    public static String transform(int ascii, int rotation, int maxAscii, int minAscii) {
        int rotAscii = ascii + rotation;
        if (rotAscii > maxAscii) {
            int diff = rotAscii - maxAscii - 1;
            return Character.toString(minAscii + diff);
        }
        return Character.toString(rotAscii);
    }
}
