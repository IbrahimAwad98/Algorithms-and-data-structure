public class Main {
    public static void main(String[] args) {

        // tom träd
        BinarySerachTree<Integer> stringBinarySerachTree = new BinarySerachTree<>();
        Integer result1 = stringBinarySerachTree.getNextLarger(5);
        System.out.println("Next larger= " + result1); //null eftersom det tom

        // balanserat träd
        BinarySerachTree<Integer> BST = new BinarySerachTree<>();
        BST.add(1);
        BST.add(2);
        BST.add(5);
        BST.add(8);
        BST.add(12);
        System.out.println("Tree (InOrder): " + BST);
        System.out.println("NextLarger(1)= " + BST.getNextLarger(1));
        System.out.println("NextLarger(2)= " + BST.getNextLarger(2));
        System.out.println("NextLarger(5)= " + BST.getNextLarger(5));
        System.out.println("NextLarger(8)= " + BST.getNextLarger(8));
        System.out.println("NextLarger(12)= " + BST.getNextLarger(12));

        //vi skickar value som inte finns
        System.out.println("NextLarger(-5)= " + BST.getNextLarger(-5));
        System.out.println("NextLarger(100)= " + BST.getNextLarger(100));

        //find
        System.out.println("Find first= " + BST.find(1));
        System.out.println("Find last= " + BST.find(12));
    }
}