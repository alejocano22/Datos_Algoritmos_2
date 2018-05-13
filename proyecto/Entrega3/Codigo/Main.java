
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Clase Main. Desde esta clase se leen los archivos de prueba y se realizan las
 * operaciones principales para buscar las rutas optimas.
 *
 * @author Alejandro Cano Munera
 * @author Sebastian Giraldo Gomez
 *
 * @version Mayo 2018
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //Cambiar esta variable 1-12 para leer DataSets
        int i = 10;
        System.out.println("DATASET " + i + ":");
        long startTime = System.currentTimeMillis();
        try {
            leer("DataSets\\DataSet-" + i + ".txt");
        } catch (IOException e) {
            System.out.println("Ups! ha ocurrido un problema: " + e.getMessage());
        }
       long total = System.currentTimeMillis()-startTime;
       System.out.println(total);
    }

    //Atributos generales de la ejecucion.
    static int n;
    static int m;
    static int u;
    static int breaks;
    static double r;
    static double speed;
    static double Tmax;
    static double Smax;
    static double st_costumer;
    static double q;
    static Node[] nodes;
    static Node[] clients;
    static boolean[] visited;
    static Node[] stations;
    static DigraphAM g;
    static double way;

    /**
     * Metodo Leer. Este metodo lee el archivo de texto especificado e invoca al
     * metodo tsp(), el cual realiza todo el proceso del ruteo.
     *
     * @param filename Es el nombre del archivo que se va a leer.
     * @throws FileNotFoundException Excepcion generada al no encontrar el
     * archivo especificado.
     * @throws IOException Otro tipo de excepcion.
     */
    private static void leer(String filename) throws FileNotFoundException, IOException {
        String[][] data = new String[10][3];
        FileReader in = new FileReader(filename);
        try (BufferedReader lector = new BufferedReader(in)) {
            for (int i = 0; i < 10; i++) {
                String linea = lector.readLine();
                if (linea != null) {
                    data[i] = linea.split(" ");
                }
            }
            for (int i = 0; i < 3; i++) {
                lector.readLine();
            }
            n = Integer.parseInt(data[0][2]);
            m = Integer.parseInt(data[1][2]);
            u = Integer.parseInt(data[2][2]);
            breaks = Integer.parseInt(data[3][2]);
            r = Double.parseDouble(data[4][2]);
            speed = Double.parseDouble(data[5][2]);
            Tmax = Double.parseDouble(data[6][2]);
            Smax = Double.parseDouble(data[7][2]);
            st_costumer = Double.parseDouble(data[8][2]);
            q = Double.parseDouble(data[9][2]);
            nodes = new Node[n];
            clients = new Node[m];
            visited = new boolean[m];
            stations = new Node[u];
            g = new DigraphAM(n);
            String linea = lector.readLine();
            String[] nodos;
            int i = 0;
            int cli = 0;
            int sta = 0;
            while (linea != null && i < n) {
                nodos = linea.split(" ");
                int id = Integer.parseInt(nodos[0]);
                String name = nodos[1];
                double x = Double.parseDouble(nodos[2]);
                double y = Double.parseDouble(nodos[3]);
                char t1 = nodos[4].charAt(0);
                int t2 = Integer.parseInt(nodos[5]);
                Node nod = new Node(id, name, x, y, t1, t2, 0);
                nodes[id] = nod;
                if (t1 == 'c') {
                    clients[cli] = nod;
                    cli++;
                } else if (t1 == 's') {
                    stations[sta] = nod;
                    sta++;
                }
                i++;
                linea = lector.readLine();
            }
            for (int j = 0; j < g.matriz.length; j++) {
                for (int k = 0; k < g.matriz[j].length; k++) {
                    //System.out.println(nodes[j].x+" "+ nodes[j].y+" "+ nodes[k].x+" "+ nodes[k].y);
                    g.matriz[j][k] = calcularDistancia(nodes[j].x, nodes[j].y, nodes[k].x, nodes[k].y);
                }
            }
            for (int l = 0; l < 2; l++) {
                lector.readLine();
            }
            String line;
            ArrayList<Double> times = new ArrayList<>();
            int ii = 0;
            do {
                line = lector.readLine();
                String a[] = line.split(" ");
                times.add(Double.parseDouble(a[3]));
                ii++;
            } while (ii < 3);
            for (int l = 0; l < 3; l++) {
                lector.readLine();
            }
            String lin;
            ArrayList<Integer> wat = new ArrayList<>();
            ii = 0;
            do {
                lin = lector.readLine();
                String a[] = lin.split(" ");
                wat.add(Integer.parseInt(a[3]));
                ii++;
            } while (ii < 3);
            double types[] = new double[times.size()];
            for (int nn = 0; nn < times.size(); nn++) {
                types[nn] = wat.get(nn) / times.get(nn);
            }
            for (Node station : stations) {
                switch (station.t2) {
                    case 0:
                        station.wh = types[0];
                        break;
                    case 1:
                        station.wh = types[1];
                        break;
                    case 2:
                        station.wh = types[2];
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Ups! ha ocurrido un problema: " + e.getMessage());
        }
        tsp();
    }

    /**
     * Metodo tsp. Este metodo es el encargado de hacer todo el proceso de ruteo
     * de los camiones, asignadoles a estos una ruta especifica, se utiliza el
     * modelo del vecino mas cercano con algunas modificaciones.
     */
    private static void tsp() {
        visited[0] = true;
        int node = 0;
        LinkedList<Camion> camiones = new LinkedList<>();
        Camion c = new Camion(q, nodes[0].x, nodes[0].y, Tmax);
        c.visited.addFirst(nodes[0]);
        camiones.addLast(c);
        while (!comprobar(visited)) {
            double min = Double.MAX_VALUE;
            int nod = node;
            for (int i = 0; i < m; i++) {
                if (i != node && g.matriz[i][node] < min && visited[i] != true) {
                    min = g.matriz[i][node];
                    nod = i;
                }
            }
            node = nod;
            int v;
            if ((v = puedeVolver(c, clients[node - 1], node, min)) == -1) {
                way += calcularDistancia(c.x, c.y, nodes[0].x, nodes[0].y);
                c.visited.addLast(nodes[0]);
                c = new Camion(q, nodes[0].x, nodes[0].y, Tmax);
                c.visited.addFirst(nodes[0]);
                camiones.addLast(c);
                node = 0;
            } else {
                node = v;
            }
        }
        c.visited.addLast(nodes[0]);
        way += g.matriz[0][node];
        DecimalFormat formatter = new DecimalFormat("#0.00");
        System.out.println(" - Rutas: ");
        for (int i = 0; i < camiones.size(); i++) {
            Node init = camiones.get(i).visited.get(0);
            System.out.print("Ruta " + (i + 1) + ": " + init.id + "(0 Horas), ");
            for (int k = 1; k < camiones.get(i).visited.size(); k++) {
                Node neo = camiones.get(i).visited.get(k);
                double tt = g.matriz[neo.id][camiones.get(i).visited.get(k - 1).id] / speed;
                if (k == camiones.get(i).visited.size() - 1) {
                    System.out.print(neo.id + " (" + formatter.format(tt) + " Horas)");
                } else {
                    System.out.print(neo.id + " (" + formatter.format(tt) + " Horas), ");
                }
            }
            System.out.println("");
        }
        System.out.println("\n - Datos generales: ");
        System.out.println("Número de camiones: " + camiones.size());
        System.out.println("Total horas: " + formatter.format((way / speed) + ((m - 1) * st_costumer)) + " Horas"); //Número de horas sumando las horas que se gasta cada camión
        System.out.println("Total Kilometros recorridos: " + formatter.format(way) + " Km"); //Total Km recorridos por todos los camiones en conjunto
    }

    /**
     * Metodo puedeVolver. Este metodo calcula si un camion en un nodo actual
     * puede ir a un nodo target y volver al deposito con el tiempo y bateria
     * actuales.
     *
     * @param c Es el camion que esta haciendo el recorrido.
     * @param target Es el nodo objetivo que se quiere visitar
     * @param way Es el recorrido total que se ha realizado.
     * @param nodact Es el nodo actual
     * @param mi Es la distancia minima del nodo actual al nodo target
     * @return Si se puede volver se retorna -1, de lo contrario se retorna el
     * nodo actual.
     */
    private static int puedeVolver(Camion c, Node target, int nodact, double mi) {
        double distanceD = g.getWeight(target.id, 0);
        double distanceN = mi;
        double distance = distanceD + distanceN;
        double time = (distance / speed) + st_costumer;
        if (c.time >= time) {
            double outlay = (distance / speed) * r;
            if (c.bat >= outlay) {
                c.time -= (distanceN / speed) + st_costumer;
                c.bat -= (distanceN / speed) * r;
                c.x = target.x;
                c.y = target.y;
                c.visited.addLast(target);
                visited[target.id] = true;
                nodact = target.id;
                way += distanceN;
                return nodact;
            }
        }
        return -1;
    }

    /**
     * Metodo comprobar. Este metodo verifica que todos los nodos han sido
     * visitados
     *
     * @param a Es el arreglo de visitados en representacion de los nodos
     * @return Se retorna true si todos los nodos han sido visitados, y false de
     * lo contrario.
     */
    private static boolean comprobar(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            if (!a[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo calcularDistancia. Este metodo calcula la distancia entre dos
     * puntos P1(x1,y1) y P2(x2,y2).
     *
     * @param x1 coordenada en x del punto 1
     * @param y1 coordenada en y del punto 1
     * @param x2 coordenada en x del punto 2
     * @param y2 coordenada en y del punto 2
     * @return Distancia entre ambos puntos.
     */
    private static double calcularDistancia(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
