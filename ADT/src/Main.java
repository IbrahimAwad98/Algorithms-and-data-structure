public class Main {
    public static void main(String[] args) {

        Array<String> stringArray = new Array<>(3);
        System.out.println("Empty? " + stringArray.isEmpty());
        stringArray.insert("A");
        stringArray.insert("B");
        stringArray.insert("C");
        System.out.println(stringArray);
        System.out.println("Size of= " + stringArray.size());
        stringArray.insert("D");
        System.out.println(stringArray);
        System.out.println("Size of= " + stringArray.size());
        stringArray.delete(4);
        System.out.println(stringArray);
        System.out.println("Size of= " + stringArray.size());
        stringArray.insert(1,"X");
        System.out.println(stringArray);
        System.out.println("Size of= " + stringArray.size());
        System.out.println("W is in it? " + stringArray.serach("W"));
        System.out.println("position 1 is: " + stringArray.get(1));
        












    }
}