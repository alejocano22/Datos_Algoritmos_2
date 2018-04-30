package lab05;

/**
 * Laboratorio 5. Punto 1.1 Distancia Levenshtein.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Abril 2018
 */
public class Levenshtein {

    public static void main(String[] args) {
        Levenshtein t = new Levenshtein();
        System.out.println("Casa y Calle: " + t.levenshtein("Casa", "Calle"));
        System.out.println("Casa y \"\": " + t.levenshtein("Casa", ""));
        System.out.println("Alejandro y Sebastián: " + t.levenshtein("Alejandro", "Sebastián"));
    }

    public int levenshtein(String A, String B) {
        int mat[][] = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0) {
                    mat[i][j] = j;
                } else if (j == 0) {
                    mat[i][j] = i;
                } else {
                    double c = Math.min(mat[i - 1][j - 1] + (A.charAt(i - 1) == B.charAt(j - 1) ? 0 : 1), Math.min(mat[i - 1][j] + 1, mat[i][j - 1] + 1));
                    mat[i][j] = (int) c;

                }
            }
        }
        return mat[A.length()][B.length()];
    }
}
