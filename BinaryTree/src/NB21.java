public class NB21<E extends Comparable<E>>{
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

    public NB21(){
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
            }
            return result;
        }
    }

    private boolean insert(E data, Node<E> node){
        int comparison = data.compareTo(node.data);

        if (comparison == 0){
            return false;
        }else if (comparison < 0){
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

    private void inOrder(Node<E> node, StringBuilder sb){
        if (node != null){
            inOrder(node.left, sb);
            sb.append(node.data + " ");
            inOrder(node.right, sb);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }
}
