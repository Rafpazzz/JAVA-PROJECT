package Trabalho_EDII_2.BinaryTree;

public class OrdenaAvore {

    public void preOndemRec(TreeNode node) {
        if(node != null) {
            System.out.print(node.value + " ");
            preOndemRec(node.left);
            preOndemRec(node.right);

        }
    }

    public void emOrdemRec(TreeNode node) {
        if(node != null) {
            preOndemRec(node.left);
            System.out.print(node.value + " ");
            preOndemRec(node.right);
        }
    }

    public void posOrdeRec(TreeNode node) {
        if(node != null) {
            posOrdeRec(node.left);
            posOrdeRec(node.right);
            System.out.print(node.value + " ");
        }
    }
}
