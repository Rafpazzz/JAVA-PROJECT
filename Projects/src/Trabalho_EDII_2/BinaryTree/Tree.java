package Trabalho_EDII_2.BinaryTree;

class TreeNode{
    public TreeNode left, right;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }
}

public class Tree {

    private TreeNode root;

    public void inserir(int value) {
        root = inserirRec(root, value);

    }

    private TreeNode inserirRec(TreeNode node , int value) {
        if(node == null) {
            return new TreeNode(value);
        }

        if(value > node.value) {
            node.right = inserirRec(node.right, value);
        }else if(value < node.value) {
            node.left = inserirRec(node.left, value);
        }

        return node;
    }

    public void preOrdem() {
        preOndemRec(root);
        System.out.println();
    }

    private void preOndemRec(TreeNode node) {
        if(node != null) {
            System.out.print(node.value + " ");
            preOndemRec(node.left);
            preOndemRec(node.right);

        }
    }

    public void emOrdem() {
        emOrdemRec(root);
        System.out.println();
    }

    private void emOrdemRec(TreeNode node) {
        if(node != null) {
            preOndemRec(node.left);
            System.out.print(node.value + " ");
            preOndemRec(node.right);
        }
    }

    public void posOrdem() {
        posOrdeRec(root);
        System.out.println();
    }

    private void posOrdeRec(TreeNode node) {
        if(node != null) {
            posOrdeRec(node.left);
            posOrdeRec(node.right);
            System.out.print(node.value + " ");
        }
    }

}
