/*
 * Harris Dizdarevic
 * CISC. 3150
 * HW7
 * Question 1:
 *  Implement a Command Line Calculator
 *      including basic functions:
 *          Addition
 *          Subtraction
 *          Multiplication
 *          Division
 *          Modulo (?)
 *          Power (?)
 *      ex) java Calculator 2 + 3
 *              Output: 5
 *  Implement these Exception classes:
 *      AlgebraFailException derived from IllegalArgumentException
 *          Happens when the user fails to enter a number where it belongs
 *      QuitMashingOnYourKeyboardException derived from IllegalArgumentException
 *          Happens when the user enters a non supported operation
 *      UserIsADumbassException derived from IllegalArgumentException
 *          Happens when the user forgets to add a number in a binary operation
 *
 *      Handle all these exceptions gracefully and let the user know when he
 *      fucks up
 *
 *      Also handle ArithmeticException
 *          dividing by 0
 *
 *      IllegalArgumentException is unchecked as it extends RunTimeException.
 *
 *  Implement Parenthesis as well
 *
 *  Make sure it aligns with PEMDAS
 *
 *  Can do postfix, not necessary maybe
 *
 *  Algorithm:
 *      For postfix:
 *          Hold 2 stacks, 1 for the number arguments, and the second for the
 *          operators.
 *
 *          The way how postfix is shown is (ex): 435+* which would equate to
 *          (3*5)+4 = 19
 *
 *          ((4*3) + 2) * 5 / 3
 *          push (())
 *          push 3 5 2 4 3
 *          push / * + *
 *
 *
 *     Use Dequeue?
 *      Push last if '('
 *      push first +/-*%)
 *
 *      push last the numbers
 *
 *  Resources Used:
 *      https://codereview.stackexchange.com/questions/159457/determine-if-an-input-is-an-integer-a-double-or-a-string
 *      https://en.wikipedia.org/wiki/Shunting-yard_algorithm for infix to
 *      postfix expression
 *
 *      https://stackoverflow.com/questions/26699089/infix-to-postfix-using-stacks-java
 *         got stuck with an issue following Djikstra's Shunting yard, used
 *         algorithm from above link
 *
 *      https://en.wikipedia.org/wiki/Reverse_Polish_notation#Converting_from_infix_notation
 *          Algorithm contained for evaluating expression
 *
 *      In Java 8, on the Stack documentation it said deque's are more
 *      recommended than using Stacks.
 *
 *      https://stackoverflow.com/questions/10516967/regexp-for-a-double
 *        regex expression for doubles + ints
 *
 *      https://docs.oracle.com/javase/8/docs/api/java/text/DecimalFormat.html
 *          formatting decimals (mainly removing the trailing 0s)
 */

import java.util.Stack;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    //Using a regular expression to parse if the arguments are in the available
    //operations and valid numbers
    public Pattern availOperations = Pattern.compile("[+\\-\\*\\/\\^]");
    public Pattern validNumbers = Pattern.compile("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$");
    public Map<String,Integer> precedenceMap = new HashMap<String,Integer>();
    public Stack<String> opStack = new Stack<String>();
    public Queue<String> argQueue = new ArrayDeque<String>();

    public Calculator() {
        //4 = greatest precedence, 1 = lowest precedence
        precedenceMap.put("(", 4);
        precedenceMap.put(")", 4);
        precedenceMap.put("^", 3);
        precedenceMap.put("*", 2);
        precedenceMap.put("/", 2);
        precedenceMap.put("+", 1);
        precedenceMap.put("-", 1);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        try {
            calc.numberCheck(args);
            calc.infixToPostFix(args);
            calc.evaluatePostExpression();
        } catch(UserIsADumbassException ex) {
            System.out.println("Did you not add a second operand to a binary operation?");
        } catch(QuitMashingOnYourKeyboardException ex) {
            System.out.println("Wrong operation buddy");
        } catch(AlgebraFailException ex) {
            System.out.println("Double check your input, you may be doing something wrong");
        } catch(ArithmeticException ex) {
            System.out.println("Oops, are you trying to divide by 0?");
        }
    }

    public void numberCheck(String[] args) {
        List<String> operators = new ArrayList<String>();
        List<String> operands = new ArrayList<String>();
        int parenthesisCheck = 0;

        //separate operands from operators
        for(String token : args) {
            if(token.matches(this.validNumbers.toString())) {
                operands.add(token);
            } else if(token.matches(this.availOperations.toString()) || token.matches("[\\(\\)]")) {
                operators.add(token);
            }
        }

        //parenthesis comes in pairs, checking how many are in the expression
        for(String token : operators) {
            if(token.matches("[\\(\\)]"))
                parenthesisCheck++;
        }

        //are there matching parenthesis throughout?
        if(!(parenthesisCheck % 2 == 0))
            throw new AlgebraFailException();

        //Testing output of operators and operands
        //System.out.println(operators.toString());
        //System.out.println(operands.toString());

        //With each binary operator, there are two operands, if they are equal
        //one operand is missing
        if(operators.size() == operands.size()) {
            throw new UserIsADumbassException();
        }

        //Make sure that user does not do 2 2 2 + 3 + 5 5 for example
        for(int i = 0; i < args.length-1; i++) {
            if(args[i].matches(this.validNumbers.toString()) && args[i + 1].matches(this.validNumbers.toString()))
                throw new AlgebraFailException();
        }
    }

    public void infixToPostFix(String[] args) {
        for(String token : args) {
            if(token.matches(validNumbers.toString())) {
                this.argQueue.add(token);
            }
            else if(token.matches("[\\)]")) {
                while((!this.opStack.isEmpty()) && (!this.opStack.peek().matches("[\\(]"))) {
                    String operator = this.opStack.pop();
                    this.argQueue.add(operator);
                }
            }
            else if(token.matches(availOperations.toString()) || token.matches("[\\(\\)]")) {
                if (!this.opStack.isEmpty() && this.precedenceMap.get(token) <= this.precedenceMap.get(this.opStack.peek())) {
                    this.argQueue.add(this.opStack.pop());
                }
                this.opStack.push(token);
            }
        }

        //Any other operators left? Push it onto the queue
        while(!this.opStack.isEmpty()) {
            this.argQueue.add(this.opStack.pop());
        }

    }

    public void evaluatePostExpression() {
        Stack<Double> eval = new Stack<Double>();
        String[] output = this.argQueue.toArray(new String[0]);
        //System.out.println(Arrays.toString(output));
        for(String token : output){
            if(token.matches(availOperations.toString())){
                    double operand2 = eval.pop();
                    //System.out.println(operand2);
                    if(eval.empty())
                        throw new UserIsADumbassException();
                    double operand1 = eval.pop();
                    this.performOperation(token, operand1, operand2, eval);
            } else if(token.matches(validNumbers.toString())) {
                eval.push(Double.parseDouble(token));
            }
        }

        //Testing output
        //String queueS = Arrays.toString(this.argQueue.toArray(new String[0]));
        //System.out.println(queueS.substring(1, queueS.length()-1));
        String resultS = Arrays.toString(eval.toArray());
        System.out.println(resultS.substring(1, resultS.length()-1));
    }

    public boolean isLeftAssociative(String exp) {
        return (exp.compareTo("^") < 0) ? true : false;
    }

    public void performOperation(String opChar, double a, double b, Stack<Double> eval) {
        switch(opChar){
            case "+":
                eval.push(a + b);
                break;
            case "-":
                eval.push(a - b);
                break;
            case "*":
                eval.push(a * b);
                break;
            case "/":
                try {
                    if(b == 0)
                        throw new ArithmeticException();
                    eval.push(a / b);
                } catch(ArithmeticException ex) {
                    throw ex;
                }
                break;
            case "^":
                eval.push(Math.pow(a, b));
                break;
            default:
                throw new QuitMashingOnYourKeyboardException();
        }
    }
}

class QuitMashingOnYourKeyboardException extends IllegalArgumentException {
}

class UserIsADumbassException extends IllegalArgumentException {
}

class AlgebraFailException extends IllegalArgumentException {
}

