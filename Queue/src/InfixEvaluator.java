import java.util.Stack;

public class InfixEvaluator {

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;
    private Stack<Character> operatorStack;

    private boolean isOperator(char ch){
        return OPERATORS.indexOf(ch) != -1;
    }

    private int evaluator(char ch){
        int right = operandStack.pop();
        int left = operandStack.pop();
        int result = 0;

        switch (ch){
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
                if(right == 0){
                    throw new ArithmeticException("Can't divide by zero");
                }
                result = left / right;
                break;
        }
        operandStack.push(result);
        return result;
    }

    private int getPrio(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '(':
                return 0;
            default:
                return -1;
        }
    }

    public int eval(String expression) throws SyntaxErrorException {
        operandStack = new Stack<>();
        operatorStack = new Stack<>();

        String[] tokens = expression.split(" +");

        try {
            for (String token: tokens){

                if (Character.isDigit(token.charAt(0))){
                    int number = Integer.parseInt(token);
                    operandStack.push(number);
                }
                else if (token.equals("(")){
                    operatorStack.push('(');
                }
                else if (token.equals(")")) {
                    while (!operatorStack.empty() && operatorStack.peek() != '('){
                        char op = operatorStack.pop();
                        evaluator(op);
                    }
                    operatorStack.pop();
                }
                else if (isOperator(token.charAt(0))) {
                    char currentOp = token.charAt(0);
                    while (!operatorStack.empty() &&
                            operatorStack.peek() != '(' &&
                            getPrio(operatorStack.peek()) >= getPrio(currentOp)) {
                        char op = operatorStack.pop();
                        evaluator(op);
                    }
                    operatorStack.push(currentOp);
                }
            }


            while (!operatorStack.empty()) {
                char op = operatorStack.pop();
                evaluator(op);
            }


            if (operandStack.size() != 1) {
                throw new SyntaxErrorException("Invalid expression");
            }

            return operandStack.pop();

        } catch (Exception ex) {
            throw new SyntaxErrorException("Invalid expression: " + ex.getMessage());
        }
    }
}