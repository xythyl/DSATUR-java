package com.company;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;

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

  public static void main(String[] args) {
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
