import java.util.LinkedList;
import java.util.Queue;

public class NB22<E extends Comparable<E>>{
    private static class Node<E>{
        private E data;
        private Node<E> left, right;

        public Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;
    private int size;

    public NB22(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean add(E data){
        if (root == null){
            root = new Node<>(data);
            size++;
            return true;
        }else {
            boolean result = insert(data,root);
            if (result){
                size++;
                return true;
            }else {
                return result;
            }
        }
    }


    private boolean insert(E data, Node<E> node){
        int cmp = data.compareTo(node.data);
        if (cmp == 0){
            return false;
        } else if (cmp < 0) {
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

    public void printTree(){
        if (root == null){
            System.out.println("Empty tree");
            return;
        }

        Queue<Node<E>> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        //start
        nodeQueue.add(root);
        levelQueue.add(0);

        //håller koll på vart vi är
        int currentLevel = -1;
        while (!nodeQueue.isEmpty()){
            // Ta ut nästa nod och dess nivå
            Node<E> current = nodeQueue.poll();
            int level = levelQueue.poll();

            if (level != currentLevel){
                if (currentLevel != -1){
                    System.out.println();
                }
                currentLevel = level;
            }

            if (current == null){
                System.out.print("Null ");
            }else {
                System.out.print(current.data + " ");

                // Köa båda barnen
                nodeQueue.add(current.left);
                levelQueue.add(level + 1);
                nodeQueue.add(current.right);
                levelQueue.add(level + 1);
            }
        }
        System.out.println();
    }
}
