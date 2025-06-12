package Trabalho_EDII_2.PontoDeArticulação;

import java.util.Arrays;

public class EncontrarPonto {
    private int tempo;

    private void dfs(int u, boolean[] visitado, int[] discovery, int[] low, int[] pai,
                     boolean[] articulacao, int[][] matriz) {

        visitado[u] = true;
        discovery[u] = low[u] = ++tempo;
        int filhos = 0;

        for (int v = 0; v < matriz.length; v++) {
            if (matriz[u][v] == 1) {
                if (!visitado[v]) {
                    filhos++;
                    pai[v] = u;
                    dfs(v, visitado, discovery, low, pai, articulacao, matriz);

                    low[u] = Math.min(low[u], low[v]);

                    if (pai[u] == -1 && filhos > 1)
                        articulacao[u] = true;

                    if (pai[u] != -1 && low[v] >= discovery[u])
                        articulacao[u] = true;

                } else if (v != pai[u]) {
                    low[u] = Math.min(low[u], discovery[v]);
                }
            }
        }
    }



    public void encontrarPontos(int[][] matriz) {
        int V = matriz.length;
        boolean[] visitado = new boolean[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        int[] pai = new int[V];
        boolean[] articulacao = new boolean[V];

        Arrays.fill(pai, -1);
        tempo = 0;

        for (int i = 0; i < V; i++) {
            if (!visitado[i]) {
                dfs(i, visitado, discovery, low, pai, articulacao, matriz);
            }
        }

        System.out.print("Pontos de articulação: ");
        for (int i = 0; i < V; i++) {
            if (articulacao[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
