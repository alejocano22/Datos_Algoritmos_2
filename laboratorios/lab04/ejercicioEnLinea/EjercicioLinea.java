
import java.util.Scanner;

/**
 * Lab4. Punto 2. Greedy.
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Abril 2018
 */
public class EjercicioLinea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.nextLine();
            if (a.equals("0 0 0")) {
                break;
            }
            String[] datos = a.split(" ");
            String[] morn = sc.nextLine().split(" ");
            String[] after = sc.nextLine().split(" ");

            int n = Integer.parseInt(datos[0]);
            int h = n * Integer.parseInt(datos[1]);
            int r = Integer.parseInt(datos[2]);
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(morn[i]) + Integer.parseInt(after[i]);
            }
            sum-=h;
            System.out.println(sum*r);

        }
    }
}
