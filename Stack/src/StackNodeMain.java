public class StackNodeMain {
    public static void main(String[] args){

        StackNode<String> stringStackNode = new StackNode<>();
        System.out.println("Empty? " + stringStackNode.isEmpty());
        stringStackNode.push("A");
        System.out.println(stringStackNode);
        System.out.println("Size= " + stringStackNode.size());
        stringStackNode.push("B");
        System.out.println(stringStackNode);
        System.out.println("Size= " + stringStackNode.size());
        System.out.println("Top is: " + stringStackNode.peek());
        stringStackNode.push("C");
        System.out.println(stringStackNode);
        System.out.println("Size= " + stringStackNode.size());
        System.out.println("Top is: " + stringStackNode.peek());
        stringStackNode.pop();
        System.out.println(stringStackNode);

    }
}
