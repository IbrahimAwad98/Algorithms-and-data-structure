public class Calculator {

    public static double evaluate(String expression){
        NB5<Double> stack = new NB5<>();
        String[] tokens = expression.split(" ");

        for(String token: tokens){
            if(token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                
                double right = stack.pop();
                double left = stack.pop();
                double result = 0;

                if (token.equals("+")) {
                    result = left + right;
                } else if (token.equals("-")) {
                    result = left - right;
                } else if (token.equals("*")) {
                    result = left * right;
                } else if (token.equals("/")) {
                    result = left / right;
                }
                stack.push(result);
            }else {
                double number = Double.parseDouble(token);
                stack.push(number);
            }
        }
        return stack.pop();
    }

}
