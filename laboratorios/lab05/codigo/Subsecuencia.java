package lab05;

/**
 * Laboratorio 5. Punto 1.3 y 1.4 [Opcional] Subsecuencia comun mas larga.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Abril 2018
 */
public class Subsecuencia {

    //Test
    public static void main(String[] args) {
        System.out.println("Test 1:");
        String a = "ABCDGH";
        String b = "AEDFHR";
        System.out.println(subSecuencia(a, b));
        System.out.println("Test 2:");
        String c = "AGGTAB";
        String d = "GXTXAYB";
        System.out.println(subSecuencia(d, c));
    }

    public static int subSecuencia(String a, String b) {
        int[][] tabla = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            tabla[i][0] = 0;
            for (int j = 0; j <= b.length(); j++) {
                tabla[0][j] = 0;
                if (i == 0 || j == 0) {
                    tabla[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    tabla[i][j] = tabla[i - 1][j - 1] + 1;
                } else {
                    tabla[i][j] = Math.max(tabla[i - 1][j],
                            tabla[i][j - 1]);
                }
            }
        }
        System.out.println(subSecuenciaToString(a, b, tabla));
        return tabla[a.length()][b.length()];

    }

    public static String subSecuenciaToString(String a, String b, int[][] tabla) {
        String cad = "";
        int v = 1;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (tabla[i][j] == v) {
                    cad += a.charAt(i - 1);
                    v++;
                }
            }
        }
        return cad;
    }
}
