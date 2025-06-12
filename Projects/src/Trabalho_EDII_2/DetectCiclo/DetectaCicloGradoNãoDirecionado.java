package Trabalho_EDII_2.DetectCiclo;

public class DetectaCicloGradoNãoDirecionado {

    private boolean dfs(int v, int[][] matriz, boolean[] visitado, boolean[] emRecursao) { //busca em profundidade
        visitado[v] = true;
        emRecursao[v] = true;

        for (int u = 0; u < matriz.length; u++) {
            if (matriz[v][u] == 1) { // Existe uma aresta de v para u
                if (!visitado[u]) {
                    if (dfs(u, matriz, visitado, emRecursao)) {
                        return true;
                    }
                } else if (emRecursao[u]) {
                    return true; // Ciclo encontrado
                }
            }
        }

        emRecursao[v] = false;
        return false;
    }


    public String isCyclic(int[][] matix, int size) {

        boolean[] visitado = new boolean[size];
        boolean[] emRecursao = new boolean[size];

        // Verifica cada vértice
        for (int i = 0; i < size; i++) {
            if (!visitado[i]) {
                if (dfs(i, matix, visitado, emRecursao)) {
                    return "Ciclo detectado"; // Ciclo detectado
                }
            }
        }

        return "Ciclo não Detectado"; // Nenhum ciclo encontrado
    }
}
