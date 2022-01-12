package Arithmetic;

import java.util.Stack;

public class PEMDASButInProgramming
{
    public static int evaluate(int num, int num2, String operator)
    {
        if(operator.equals("+")) { return num+num2;}

        if(operator.equals("-")) {return num-num2;}

        if(operator.equals("/")) {return num/num2;}

        if(operator.equals("*")) {return num*num2;}

        if(operator.equals("^")) {return (int) Math.pow(num, num2); }

        return 0;
    }

    public static void main(String[] args)
        {
            Stack<Integer> numbers = new Stack();
            Stack<String> operators = new Stack();
            Stack<String> paran = new Stack();
            int total = 0;
            String equation = "3 + 5 * 8 ^ 2 - 8 / 2";
            String[] splitter = equation.split(" ");
            for(int i = 0; i < splitter.length; i++)
            {
                if (!splitter[i].equals("+") && !splitter[i].equals("-") && !splitter[i].equals("*") && !splitter[i].equals("/") && !splitter[i].equals("^"))
            {
                numbers.push(Integer.parseInt(splitter[i]));
            }
            else if(splitter[i].equals("(") || splitter[i].equals(")"))
            {
                paran.push(splitter[i]);
            }
            else if(splitter[i].equals("^"))
            {
                operators.push(splitter[i]);
            }
            else if((splitter[i].equals("*")  || splitter[i].equals("/")) && (operators.isEmpty() || operators.peek().equals("+") || operators.peek().equals("-") || operators.peek().equals("*") || operators.peek().equals("/")))
            {
                operators.push(splitter[i]);
            }
            else if((splitter[i].equals("+") || splitter[i].equals("-")) && (operators.isEmpty() || operators.peek().equals("+") || operators.peek().equals("-")))
            {
                operators.push(splitter[i]);
            }
            else if(numbers.size() > 1 && operators.size() > 0)
            {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                String operator = operators.pop();

                if(!operators.isEmpty() && operators.peek().equals("-"))
                {
                    num2 = -num2;
                    operators.pop();
                    operators.push("+");
                }
                total = evaluate(num2, num1, operator);
                numbers.push(total);
                i--;
            }
            }
            while(!operators.isEmpty())
            {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                String operator = operators.pop();
                if(!operators.isEmpty() && operators.peek().equals("-"))
                {
                    num2 = -num2;
                    operators.pop();
                    operators.push("+");
                }
                total = evaluate(num2, num1, operator);
                numbers.push(total);
            }
            System.out.println(total);
        }
}