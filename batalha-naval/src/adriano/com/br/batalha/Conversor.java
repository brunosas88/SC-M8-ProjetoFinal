package adriano.com.br.batalha;

public class Conversor {

    public static int coordinatesToIndex(char value) {

        switch (value) {
            case '0': case 'A': case 'a':
                return 1;
            case '1': case 'B': case 'b':
                return 2;
            case '2': case 'C': case 'c':
                return 3;
            case '3': case 'D': case 'd':
                return 4;
            case '4': case 'E': case 'e':
                return 5;
            case '5': case 'F': case 'f':
                return 6;
            case '6': case 'G': case 'g':
                return 7;
            case '7': case 'H': case 'h':
                return 8;
            case '8': case 'I': case 'i':
                return 9;
            case '9': case 'J': case 'j':
                return 10;
            default:
                return -1;
        }
    }
}
