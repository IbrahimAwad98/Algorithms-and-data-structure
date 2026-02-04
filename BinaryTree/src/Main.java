public class Main {
    public static void main(String[] args){

        BST<Integer> integerBST = new BST<>();
        System.out.println("Empty tree? " + integerBST.isEmpty());
        integerBST.add(50);
        integerBST.add(30);
        integerBST.add(70);
        integerBST.add(20);
        integerBST.add(40);
        integerBST.add(60);
        integerBST.add(80);

        System.out.println("inOrder: " + integerBST.inOrder());
        System.out.println("preOrder: " + integerBST.preOrder());
        System.out.println("postOrder: " + integerBST.postOrder());
        System.out.println("Number of node= " + integerBST.size());
        System.out.println("Number of Leaves= " + integerBST.getNumberOfLeaves());
        System.out.println("Height= " + integerBST.getHeight());
        System.out.println("Number of levels= " + integerBST.getNumberOfLevels());

        System.out.println("Tree (printTree)");
        integerBST.printTree();

        //rekurs find
        System.out.println("Find top: " + integerBST.find(50));
        // iterativ find
        System.out.println("Find (iterativ) top: " + integerBST.iterativFind(50));

        System.out.println("Remove 30: " +integerBST.remove(30));
        System.out.println("inOrder: " + integerBST.inOrder());


        System.out.println("Max (recursive) = " + integerBST.maxRec());
        System.out.println("Max (iterativ) = " + integerBST.maxIte());

    }
}
