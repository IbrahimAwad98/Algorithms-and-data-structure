import java.util.Stack;
import java.util.EmptyStackException;

public class PostfixEvaluator {

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    private int evalOp(char op) {

        int right = operandStack.pop();
        int left = operandStack.pop();

        int result = 0;

        switch (op){
            case '+':
                result = left + right;
                break;
            case '-':
                result = left - right;
                break;
            case '*':
                result = left * right;
                break;
            case '/':
                if (right == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = left / right;
                break;
        }
        operandStack.push(result);
        return result;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        operandStack = new Stack<>();
        String[] tokens = expression.split(" +");   //delar upp strängen vid mellanslag
        try {
            for(String nextToken : tokens){
                if (Character.isDigit(nextToken.charAt(0))) {
                        int number = Integer.parseInt(nextToken);
                        operandStack.push(number);
                }
                else if (isOperator(nextToken.charAt(0))) {
                        evalOp(nextToken.charAt(0));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }
            int result = operandStack.pop();
            if(!operandStack.empty()){
                throw new SyntaxErrorException("Syntax Error: Too many operands");
            }
            return result;
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }
}
