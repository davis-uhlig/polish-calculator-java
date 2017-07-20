import java.util.Arrays;

public class ReversePolishCalc {
    double firstNum;
    double secondNum;

    // You'll need a variable here to keep track of the top of the stack
    int top = 0;
    // The array of the input string split up
    private String[] tokens;

    // The stack
    private String[] stack;

    public double calculate(String input) {

        // 1. Use the String split method to split the string into tokens at the commas
        tokens = input.split(",");

        // 2. Allocate a stack as big as the number of tokens
        stack = new String[tokens.length];

        // 3. write the algorithm
        for(int i = 0; i < tokens.length; ++i) {
            // calls to push() and pop() and do the math here
            System.out.println("looking at: " + tokens[i]);
            if (tokens[i].equals("+")) {
                 firstNum = pop();
                 secondNum = pop();
                push(firstNum + secondNum);
            } else if (tokens[i].equals("-")) {
                firstNum = pop();
                secondNum = pop();
                push(secondNum - firstNum);
            } else if (tokens[i].equals("*")) {
                firstNum = pop();
                secondNum = pop();
                push(firstNum * secondNum);
            } else if (tokens[i].equals("/")) {
                firstNum = pop();
                secondNum = pop();
                push(secondNum / firstNum);
            }
            else {
                push(Double.parseDouble(tokens[i]));
            }
        }

        // 4. return the result
        return pop();
    }

    private void push(String number) {
        stack[top] = number;
        top ++;
    }

    private void push(double d) {
        // change the double to a string and then push it on the stack
        push(Double.toString(d));

    }

    private double pop() {
        // remove the string from the top of the stack and convert it to a double and return it
        top --;
        return Double.parseDouble(stack[top]);

    }
}
