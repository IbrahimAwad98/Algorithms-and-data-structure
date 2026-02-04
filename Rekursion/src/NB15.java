public class NB15 {
    //wrapper metod för validering
    public static int binaryToDecimal(String s){
        if (s == null || s.isEmpty()){
            throw new IllegalArgumentException("text is empty");
        }
        for (char c: s.toCharArray()){
            if (c != '0' && c != '1'){
                throw new IllegalArgumentException("Not allowed: " + c);
            }
        }
        return binaryCalculate(s);
    }

    //Rekursiv för att räkna
    public static int binaryCalculate(String s){
        if (s.isEmpty()){
            return 0;
        }
        String rest = s.substring(0,s.length()-1);
        char last = s.charAt(s.length()-1);
        int lastValue = last - '0';
        return binaryCalculate(rest) * 2 + lastValue;
    }
}
