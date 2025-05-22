package MenuDeListas.MenorCaminho;

import java.util.Scanner;

public class GrafoMenorCaminhoNãoDirecionadoPonderado {
    private int[][] matrisAdj;
    private int size;
    private int peso;
    Scanner r = new Scanner(System.in);

    public GrafoMenorCaminhoNãoDirecionadoPonderado(int tam, int [][] matrix) {
        matrisAdj = matrix;
        size = tam;
    }

    public void addElemento(int[][] matrix) {
        for(int i = 0; i<size; i++) {
            for(int j = i+1; j<size; j++) {
                if(matrix[i][j] == 1) {
                    matrisAdj[i][j] = matrix[i][j];
                }
            }
        }
    }

    public int[] dijkitra(int verticeInicio) {
        int[] distancias = new int[size];
        boolean[] visitado = new boolean[size];

        for (int i = 0; i < size; i++) {
            distancias[i] = Integer.MAX_VALUE;
        }
        distancias[verticeInicio] = 0;

        for (int i = 0; i < size; i++) {
            int u = distanciaMin(distancias, visitado);
            if (u == -1) break;

            visitado[u] = true;
            for (int v = 0; v < size; v++) {
                if (!visitado[v] && matrisAdj[u][v] != 0 && distancias[u] != Integer.MAX_VALUE) {
                    int newDistance = distancias[u] + this.matrisAdj[u][v];
                    if (newDistance < distancias[v]) {
                        distancias[v] = newDistance;
                    }
                }
            }
        }
        return distancias;
    }

    private int distanciaMin(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < size; i++) {
            if (!visitado[i] && distancia[i] <= min) {
                min = distancia[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
