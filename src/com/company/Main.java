package com.company;

import java.net.*;

import org.jgrapht.*;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm.ColoringImpl;
import org.jgrapht.generate.EmptyGraphGenerator;
import org.jgrapht.graph.*;
import com.company.DegSatColor.*;
import org.jgrapht.alg.interfaces.VertexColoringAlgorithm.*;

//import org.jgrapht.Graphs;

/*
    procedure GREEDY ALGORITHM(V)
        Give an initial ordering of vertices as V = v1,v2...vn;
        Find largest clique V' of G, assign each vertex in V'
        a distinct color class; V = V - V';
        while V != NULL do
            Find a vertex v in V, which is adjacent to the largest number
            of distinctly colored vertices, assign v to the lowest
            indexed color class that contains no vertices adjacent to
            v ;
            if(no existing color class to assignment to)
            create a new color class for v ;
            Move v out of V ;
        end while
        Return color classes
    end procedure

    http://cs.indstate.edu/tdu/mine1.pdf
 */

/*
    format?
    G = { V, E }: class with vertices and edges

    V = { # of edges, edges }: class with number of edges
    and connected edges

    E = { vertice 1, vertice 2 }
 */

public class Main {

  public static void main(String [] args) {
    UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();

    DegSatColor<String ,DefaultEdge> degSatGraph = new DegSatColor<>(stringGraph);
    Coloring<String> degSatCol = degSatGraph.getLimitedColoring(0);

    System.out.println(stringGraph.toString());
    System.out.println(degSatCol.toString());

    //DirectedGraph<URL, DefaultEdge> hrefGraph = createHrefGraph();

    //System.out.println(hrefGraph.toString());
  }

  private static DirectedGraph<URL, DefaultEdge> createHrefGraph() {
    DirectedGraph<URL, DefaultEdge> g =
        new DefaultDirectedGraph<URL, DefaultEdge>(DefaultEdge.class);

    try {
      URL amazon = new URL("[http://www.amazon.com](http://www.amazon.com)");
      URL yahoo = new URL("[http://www.yahoo.com](http://www.yahoo.com)");
      URL ebay = new URL("[http://www.ebay.com](http://www.ebay.com)");

      // add the vertices
      g.addVertex(amazon);
      g.addVertex(yahoo);
      g.addVertex(ebay);

      // add edges to create linking structure
      g.addEdge(yahoo, amazon);
      g.addEdge(yahoo, ebay);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }

    return g;
  }

  private static UndirectedGraph<String, DefaultEdge> createStringGraph()
  {
    UndirectedGraph<String, DefaultEdge> g =
        new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

    String v1 = "v1";
    String v2 = "v2";
    String v3 = "v3";
    String v4 = "v4";
    String v5 = "v5";
    String v6 = "v6";
    String v7 = "v7";

    // add the vertices
    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);
    g.addVertex(v4);
    g.addVertex(v5);
    g.addVertex(v6);
    g.addVertex(v7);

    // add edges to create a circuit
    g.addEdge(v1, v2);
    g.addEdge(v1, v3);
    g.addEdge(v1, v6);
    g.addEdge(v1, v5);
    g.addEdge(v2, v4);
    g.addEdge(v2, v7);
    g.addEdge(v2, v6);
    g.addEdge(v2, v3);
    g.addEdge(v4, v7);
    g.addEdge(v4, v5);
    g.addEdge(v3, v5);
    g.addEdge(v3, v7);

    return g;
  }


  public static void dsatur(int[][] V) {

  }


/*
  public static int [] getOrder(int [][] V ) {

  }
*/
  public static int getMax( int[][] V, int m ) {
    int index = 0;
    int current = 0;
    int max = 0;
    for (int i = 0; i < V.length; i++){
      current = getSat(i,V);
      if (max < current && max < m){
        max = current;
        index = i;
      }
    }
    return index;
  }

  public static int getSat(int k, int[][] V) {
    int count = 0;
    for (int i = 0; i < V.length; i++) {
      if (V[k][i] == 1) {
        count++;
      }
    }
    return count;
  }

  public static void makeGraph(String[] args) {
	// write your code here
    int[][] V = new int[][]{
        {0,1,0,0,1}, //1: 2, 5
        {1,0,1,1,1}, //2: 1, 3, 4 , 5
        {0,1,0,1,1}, //3: 2, 4, 5
        {0,1,1,0,1}, //4: 2, 3, 5
        {1,1,1,1,0}, //5: 1, 2, 3, 4
    };
    dsatur(V);
  }
}
