public class StackMain {
    public static void main(String[] args){
        StackArrays<String> stringStackArrays = new StackArrays<>(4);
        System.out.println("Empty? " + stringStackArrays.isEmpty());
        System.out.println("Full? " + stringStackArrays.isFull());
        try {
            stringStackArrays.peek();
        }catch (IllegalStateException e){
            System.out.println("Error: " + e.getMessage());
        }
        stringStackArrays.push("A");
        stringStackArrays.push("B");
        stringStackArrays.push("C");
        stringStackArrays.push("D");
        System.out.println(stringStackArrays);
        System.out.println("Full? " + stringStackArrays.isFull());
        System.out.println("Last is: " + stringStackArrays.peek());
        stringStackArrays.pop();
        System.out.println(stringStackArrays);
        stringStackArrays.pop();
        System.out.println(stringStackArrays);
    }
}
