package MenuDeListas.ListAdj;

import java.util.LinkedList;

public class ListAdjNaoDirecionada {
    private LinkedList<Integer>[] listAdj;
    private int numVertices;
    private int numArestas;

    public ListAdjNaoDirecionada(int vertice) {
        this.numVertices = vertice;
        this.numArestas = 0;
        listAdj = new LinkedList[vertice];

        for(int i = 0; i<vertice; i++) {
            listAdj[i] = new LinkedList<>();
        }
    }

    public void inserirValor(int [][] matrix) {
        for(int i = 0; i<numVertices; i++) {
            for(int j = i+1; j<numVertices; j++) {
                if(matrix[i][j] == 1) {
                    listAdj[i].add(j);
                    numArestas++;
                }
            }
        }

    }

    public void exibirLista() {
        System.out.println("Exibindo grafo(vertices: "+ numVertices +"; arestas: "+ numArestas+ ")");
        for(int i = 0; i<numVertices; i++) {
            System.out.print("Vertice ["+ i+ "]: ");
            for(Integer vizinho : listAdj[i]){
                System.out.print(vizinho+". ");
            }
            System.out.println();
        }
    }
}
