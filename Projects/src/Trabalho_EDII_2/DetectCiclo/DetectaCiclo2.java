package Trabalho_EDII_2.DetectCiclo;

import java.util.ArrayList;
import java.util.List;

public class DetectaCiclo2 {

    // Função recursiva auxiliar (DFS) para detect ciclos
    private static boolean DFS(List<Integer>[] adj, int v, boolean[] visitado, boolean[] recStack) {
        if (recStack[v]) return true;
        if (visitado[v]) return false;

        visitado[v] = true;
        recStack[v] = true;

        for (int u : adj[v]) {
            if (DFS(adj, u, visitado, recStack)) {
                return true;
            }
        }

        recStack[v] = false;
        return false;
    }

    // Constrói lista de adjacência a partir da matriz de adjacência
    private static List<Integer>[] constructAdj(int[][] matriz) {
        int V = matriz.length;
        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
            for (int j = 0; j < V; j++) {
                if (matriz[i][j] == 1) {
                    adj[i].add(j);
                }
            }
        }

        return adj;
    }

    public static String isCyclicUtil(int[][] matrizAdjacencia, int size) {
        List<Integer>[] adj = constructAdj(matrizAdjacencia);
        boolean[] visitado = new boolean[size];
        boolean[] recStack = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visitado[i]) {
                if (DFS(adj, i, visitado, recStack)) {
                    return "Ciclo encontrado";
                }
            }
        }

        return "Ciclo não encontrado";
    }

}
