public class BinarySerachTree<E extends Comparable<E>> {

    // Node klassen
    private static class Node<E> {
        private E data;
        private Node<E> left, right;

        private Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    //datamedlemmar
    private Node<E> root;

    public BinarySerachTree() {
        root = null;
    }

    public boolean add(E item) {
        if (root == null) {
            root = new Node<>(item);
            return true;
        }
        return add(item, root);
    }

    private boolean add(E item, Node<E> node) {
        int cmp = item.compareTo(node.data);

        // Dubbletter ej tillåtna
        if (cmp == 0) {
            return false;
        } else if (cmp < 0) { //vänster
            if (node.left == null) {
                node.left = new Node<>(item);
                return true;
            }
            return add(item, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node<>(item);
                return true;
            }
            return add(item, node.right);
        }
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E tagert, Node<E> node) {
        //inget hittad
        if (node == null) {
            return null;
        }
        int cmp = tagert.compareTo(node.data);
        if (cmp == 0) {
            return node.data;
        } else if (cmp < 0) {
            return find(tagert, node.left);
        } else {
            return find(tagert, node.right);
        }
    }


    //Travesering inOrder
    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }


    public E getNextLarger(E value) {
        return getNextLarger(value, root, null);
    }

    private E getNextLarger(E value, Node<E> node, E candidate) {
        // om noden inte finns
        if (node == null) {
            return candidate; //vi tar bästa vi sparade
        }

        int cmp = value.compareTo(node.data);
        // om value < node.data då spara root och gå vänster
        if (cmp < 0) {
            return getNextLarger(value, node.left, node.data);
        } else { // annars value >= node.data då spara root och gå höger
            return getNextLarger(value, node.right, candidate);
        }
    }
}
