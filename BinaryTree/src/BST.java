import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> left, right;

        public Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node<E> root;
    private int size;
    private E deletedData;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean add(E data){
        if (isEmpty()){
            root = new Node<>(data);
            size++;
            return true;
        }else {
            boolean result = insert(data,root);
            if (result){
                size++;
            }
            return result;
        }
    }

    private boolean insert(E data, Node<E> node){
        int cmp = data.compareTo(node.data);
        if (cmp == 0){
            return false;
        }else if (cmp < 0){
            if (node.left == null){
                node.left = new Node<>(data);
                return true;
            }else {
                return insert(data,node.left);
            }
        }else {
            if (node.right == null){
                node.right = new Node<>(data);
                return true;
            }else {
                return insert(data,node.right);
            }
        }
    }

    public E find(E target){
        return findhelper(target,root);
    }

    private E findhelper(E target, Node<E> node){
        if (node == null){
            return null;
        }
        int cmp = target.compareTo(node.data);
        if (cmp == 0){
            return node.data;
        }
        else if (cmp < 0){
            return findhelper(target,node.left);
        }else {
            return findhelper(target,node.right);
        }
    }

    public E iterativFind(E target){
        Node<E> current = root;
        while (current != null){
            int cmp = target.compareTo(current.data);
            if (cmp == 0){
                return current.data;
            }else if (cmp < 0){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return null;
    }


    public E maxRec(){
        if (isEmpty()){
            return null;
        }
        return maxRecHelper(root);
    }

    private E maxRecHelper(Node<E> node){
        if (node.right == null){
            return node.data;
        }else {
            return maxRecHelper(node.right);
        }
    }

    public E maxIte(){
        if (isEmpty()){
            return null;
        }
        Node<E> current = root;
        while (current.right != null){
            current = current.right;
        }
        return current.data;
    }


    public E remove(E target){
        deletedData = null;
        root = removeHelper(target, root);
        if (deletedData != null){
            size--;
        }
        return deletedData;
    }

    private Node<E> removeHelper(E target, Node<E> node){
        if (node == null){
            deletedData = null;
            return null;
        }

        int cmp = target.compareTo(node.data);

        if (cmp < 0){
            node.left = removeHelper(target,node.left);
            return node;
        }else if (cmp > 0){
            node.right = removeHelper(target,node.right);
            return node;
        }else {
            deletedData = node.data;
            if (node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }else {
                Node<E> nodeToMove = node.right,
                        parentNodeToMove = node;
                if (nodeToMove.left == null){
                    nodeToMove.left = node.left;
                    return nodeToMove;
                }
                while (nodeToMove.left != null){
                    parentNodeToMove = nodeToMove;
                    nodeToMove= nodeToMove.left;
                }
                parentNodeToMove.left = nodeToMove.right;
                node.data = nodeToMove.data;
                return node;
            }
        }
    }

    public String inOrder(){
        StringBuilder result = new StringBuilder();
        inOrderHelper(root,result);
        return result.toString().trim();
    }

    private void inOrderHelper(Node<E> node, StringBuilder sb){
        if (node != null){
            inOrderHelper(node.left, sb);
            sb.append(node.data + " ");
            inOrderHelper(node.right,sb);
        }
    }

    public String preOrder(){
        StringBuilder result = new StringBuilder();
        preOrderHelper(root,result);
        return result.toString().trim();
    }

    private void preOrderHelper(Node<E> node, StringBuilder sb){
        if (node != null){
            sb.append(node.data + " ");
            preOrderHelper(node.left,sb);
            preOrderHelper(node.right,sb);
        }
    }


    public String postOrder(){
        StringBuilder result = new StringBuilder();
        postOrderHelper(root,result);
        return result.toString().trim();
    }

    private void postOrderHelper(Node<E> node, StringBuilder sb){
        if (node != null){
            postOrderHelper(node.left, sb);
            postOrderHelper(node.right, sb);
            sb.append(node.data + " ");
        }
    }

    public int getHeight(){
        return height(root);
    }

    private int height(Node<E> node){
        if (node == null){
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public int getNumberOfLevels(){
        return getHeight() + 1;
    }

    public int getNumberOfLeaves(){
        return numberOfLeaves(root);
    }

    private int numberOfLeaves(Node<E> node){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return 1;
        }

        // Rekursiva fallet: Räkna löv i båda subträden
        int leftLeaves = numberOfLeaves(node.left);
        int rightLeaves = numberOfLeaves(node.right);
        return leftLeaves + rightLeaves;
    }

    public void printTree(){
        if (isEmpty()){
            System.out.println("Tomt träd");
            return;
        }

        Queue<Node<E>> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        nodeQueue.add(root);
        levelQueue.add(0);

        int currentLevel = -1;

        while (!nodeQueue.isEmpty()){
            Node<E> current = nodeQueue.poll();
            int level = levelQueue.poll();

            if (level != currentLevel){
                if (currentLevel != -1){
                    System.out.println();
                }
                currentLevel = level;
            }

            if (current == null){
                System.out.print("null ");
            }else {
                System.out.print(current.data + " ");

                nodeQueue.add(current.left);
                levelQueue.add(level + 1);
                nodeQueue.add(current.right);
                levelQueue.add(level + 1);
            }
        }
        System.out.println();
    }
}