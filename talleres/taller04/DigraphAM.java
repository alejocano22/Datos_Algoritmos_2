
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Taller 4. Clase DigraphAM. Esta clase es una implementacion de un grafo
 * usando matrices de adyacencia. La plantilla de esta clase fue tomada del
 * Github del docente Mauricio Toro, en el siguiente enlace:
 * https://github.com/mauriciotoro/ST0247-Eafit/tree/master/talleres/taller01
 *
 * @author Alejandro Cano Munera
 * @author Sebastián Giraldo Gómez
 *
 * @version Febrero 2018
 */
public class DigraphAM extends Digraph {

    /**
     * Atributos. Matriz sobre la cual se creara el grafo.
     */
    public int[][] matriz;

    /**
     * Constructor de la clase DigraphAM. Se crea y se inicializa la matriz; la
     * matriz es cuadrada y su tamaño viene dado por el numero de vertices.
     *
     * @param size Es el numero de vertices, es decir, es el tamaño de la matriz
     * (size x size). se inicializan todos los valores de la matriz en cero.
     */
    public DigraphAM(int size) {
        super(size);
        matriz = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                //matriz[i][j] = 0;
//                System.out.println(matriz[i][j]);
//            }
//        }
    }

    /**
     * Metodo addArc. Este metodo añade un arco al grafo en una matriz.
     *
     * @param source Es el nodo de salida en el grafo
     * @param destination Es el nodo de llegada en el grafo
     * @param weight Es el peso del arco en el grafo.
     */
    @Override
    public void addArc(int source, int destination, int weight) {
        matriz[source][destination] = weight;
    }

    /**
     * Metodo getWeight. Este metodo retorna el peso de un arco en el grafo
     * dados sus dos nodos adyacentes.
     *
     * @param source Es el nodo de salida en el grafo.
     * @param destination Es el nodo de llegada en el grafo.
     * @return Se retorna el peso del arco encontrado, si no se encuentra el
     * arco se retorna cero (que es el valor por omision en la matriz).
     */
    @Override
    public int getWeight(int source, int destination) {

        return matriz[source][destination];
    }

    /**
     * Metodo getSuccessors. Este metodo retorna un ArrayList con los sucesores
     * de un nodo dado en el grafo.
     *
     * @param vertex Es el nodo al que se le buscaran los sucesores.
     * @return Se rotorna un ArrayList con los sucesores de dicho nodo. Se
     * retorna un ArrayList vacio si el nodo no existe o no contiene sucesores.
     */
    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0; i < matriz[vertex].length; i++) {
//                System.out.println(matriz[vertex][i]);
            if (matriz[vertex][i] != 0) {
//                System.out.print(matriz[vertex][i]);
                array.add(i);
            }
        }
//        System.out.println("");
        if (array.isEmpty()) {
            return null;
        }
        return array;
    }

    /**
     * Código adaptado de
     * http://www.sanfoundry.com/java-program-traverse-graph-using-bfs/
     *
     * @param adjacency_matrix recibe la matriz de adyacencia
     * @param source recibe el nodo en el que se va a iniciar el recorrido
     * @return ArrayList con los nodos que se pueden visitar desde el nodo
     * inicial
     */
    public ArrayList<Integer> bfs(int adjacency_matrix[][], int source) {
        //ArrayList con los nodos posibles
        ArrayList<Integer> bfsres = new ArrayList<>();
        //Queue que va guardando los nodos visitados
        Queue<Integer> queue = new LinkedList<>();
        //Int con el número de nodos del grafo
        int number_of_nodes = adjacency_matrix[source].length - 1;
        //Arreglo que controla los nodos visitados
        int[] visited = new int[number_of_nodes + 1];
        int i, element;

        visited[source] = 1;
        queue.add(source);
        //Mientras la cola de visitados no sea vacía busca
        while (!queue.isEmpty()) {
            //Saca cada elemento que se puede visitar de la cola y lo agrega al ArrayList resultado.
            element = queue.remove();
            i = element;
            bfsres.add(i);
            //Evalúa cuáles puede visitar
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }

        return bfsres;
    }

    /**
     * Metodo canGoToBFS. Este metodo nos define si podemos ir de un nodo a otro
     * en bfs.
     *
     * @param start nodo de inicio
     * @param end nodo de destino
     * @return Se retorna verdadero si se puede efectuar el recorrido y false de
     * lo contrario
     */
    public boolean canGoToBFS(int start, int end) {
        ArrayList<Integer> arr = bfs(matriz, start);
        return arr.contains(end);
    }

    /**
     * Metodo impListaBFS. Este metodo imprime la lista del recorrido en BFS.
     *
     * @param adjacency_matrix Es la lista de nodos que se recorrieron.
     * @param sourc Es el parametro de busqueda en el grafo.
     */
    public void impListaBFS(int adjacency_matrix[][], int sourc) {
        System.out.println(bfs(adjacency_matrix, sourc).toString());
    }

    //Metodo para recorrer el grafo de la manera mas eficiente de un nodo a otro.
    public void bfsCheaper(int adjacency_matrix[][], int source, int end) {

        //ArrayList con los nodos posibles
        ArrayList<Integer> bfsres = new ArrayList<>();
        //Queue que va guardando los nodos visitados
        Queue<Integer> queue = new LinkedList<>();
        //Int con el número de nodos del grafo
        int number_of_nodes = adjacency_matrix[source].length - 1;
        //Arreglo que controla los nodos visitados
        int[] visited = new int[number_of_nodes + 1];
        int i, element;

        visited[source] = 1;
        queue.add(source);
        //Mientras la cola de visitados no sea vacía busca
        while (!queue.isEmpty()) {
            //Saca cada elemento que se puede visitar de la cola y lo agrega al ArrayList resultado.
            element = queue.remove();
            i = element;
            bfsres.add(i);
            //Evalúa cuáles puede visitar
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
        System.out.println("Camino de " + source + " a " + end + bfsres.toString());
    }

    /**
     * Código adaptado de:
     * http://www.sanfoundry.com/java-program-traverse-graph-using-dfs-2/
     *
     * @param adjacency_matrix recibe la matriz de adyacencia
     * @param source recibe el nodo en el que se va a iniciar el recorrido
     * @return ArrayList con los nodos que se pueden visitar desde el nodo
     */
    public ArrayList<Integer> dfs(int adjacency_matrix[][], int source) {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> dfsres = new ArrayList<>();
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i;
        i = source;
        dfsres.add(element);
        visited[source] = 1;
        stack.push(source);

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = element;
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    dfsres.add(element);
                    continue;
                }
                i++;
            }
            stack.pop();
        }
        return dfsres;
    }

    /**
     * Metodo canGoToDFS. Este metodo nos define si podemos ir de un nodo a otro
     * en dfs.
     *
     * @param start nodo de inicio
     * @param end nodo de destino
     * @return Se retorna verdadero si se puede efectuar el recorrido y false de
     * lo contrario
     */
    public boolean canGoToDFS(int start, int end) {
        ArrayList<Integer> arr = dfs(matriz, start);
        return arr.contains(end);
    }

    /**
     * Metodo impListaDFS. Este metodo imprime la lista del recorrido en DFS.
     *
     * @param adjacency_matrix Es la lista de nodos que se recorrieron.
     * @param sourc Es el parametro de busqueda en el grafo.
     */
    public void impListaDFS(int adjacency_matrix[][], int sourc) {
        System.out.println(dfs(adjacency_matrix, sourc).toString());
    }

    //Metodo para recorrer el grafo utilizando el camino mas corto sin repetir
    public void dfsCheaper(int adjacency_matrix[][], int source, int end) {
        int number_of_nodes = adjacency_matrix[source].length - 1;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> dfsres = new ArrayList<>();
        int visited[] = new int[number_of_nodes + 1];
        int element = source;
        int i = source;
        dfsres.add(element);
        visited[source] = 1;
        stack.push(source);

        while (!stack.isEmpty()) {
            element = stack.peek();
            i = element;
            while (i <= number_of_nodes) {
                if (adjacency_matrix[element][i] == 1 && visited[i] == 0) {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    dfsres.add(element);
                    continue;
                }
                i++;
            }
            stack.pop();
        }
        System.out.println("Camino de " + source + " a " + end + dfsres.toString());

    }

    //Metodo para crear las permutaciones posibles.
    public void permutaciones(String b, String c, ArrayList<String> arr) {
        if (c.length() > 0) {
            for (int i = 0; i < c.length(); i++) {
                permutaciones(b.concat(c.charAt(i) + ""), c.substring(0, i) + c.substring(i + 1), arr);
            }

        } else {
            arr.add(b);
        }
    }
}
