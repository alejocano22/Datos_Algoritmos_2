
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import jdk.internal.util.xml.impl.Pair;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class LeerA {
    
      private static Digraph leer(String filename) throws FileNotFoundException, IOException
  {
    String[][] data=new String [10][3];
    FileReader in = new FileReader(filename);
    BufferedReader lector = new BufferedReader(in);
      for (int i = 0; i < 10; i++) {
        String linea= lector.readLine();
        if(linea!=null)
        data[i]=linea.split(" ");
      }
      for (int i = 0; i < 3; i++) {
          lector.readLine();
      }
    
    int n = Integer.parseInt(data[0][2]);
    DigraphAL g = new DigraphAL(n);
    String linea = lector.readLine();
    String[][] nodos = new String[n][6];
    int i=0;
    while (linea!=null&&i<n) 
    {
        System.out.println(linea);
        nodos[i]=linea.split(" ");
        i++;
        linea = lector.readLine();
     }
    return g;
  }
  
  public static void main(String[] args) throws IOException
  {
     Digraph g = leer("C:\\Users\\ASUS\\Desktop\\DataSet.txt");
  }

}
