import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sk
 * @version 1.0
 */

    // 该类将中缀表达式，转换为后缀表达式
    // 后缀表达式有利于式子的计算
public class InfixToSuffix {
    public  String[] translation(String[] expression){
        int len = expression.length;
        String[] ret = new String[len];

        int index = 0; // 后续表达式的下标
        Deque<String> stack = new LinkedList<>();
        HashMap<String, Integer> map =  new HashMap(){
            {
                put("+", 0);
                put("-", 0);
                put("*", 1);
                put("/", 1);
                put("(", -100);
                put(")", -100);
            }
        };
        for (int i = 0; i < len; i++) {
            if(expression[i].equals("+") || expression[i].equals("-") || expression[i].equals("/") ||
                    expression[i].equals("*")){
                if(stack.size() == 0){ //当栈为空时，直接将计算符号压入栈中
                    stack.push(expression[i]);
                }else if(map.get(expression[i]) <= map.get(stack.peek())){
                    ret[index++] = expression[i]; // 当运算符优先级较高时，直接将运算符放入ret中
                }else{
                    stack.push(expression[i]);
                }

            }else if(expression[i].equals("(") || expression[i].equals(")")){
                if(expression[i].equals("(")){
                    stack.push(expression[i]);
                }else if(expression[i].equals(")")){ // 将栈中括号内的运算符都弹出
                    while(stack.peek() != "("){
                        ret[index++] = stack.pop();
                    }
                    stack.pop(); // 将（弹出，后缀表达式中可以没有（）
                }
            }else { // 当是一个数字时，就直接放入ret数组
                ret[index++] = expression[i];
            }
        }

        while(stack.size() != 0){
            ret[index++] = stack.pop();
        }

        return java.util.Arrays.copyOf(ret, index);
    }

    public double calculateSuffix(String[] expression){
        int len = expression.length;
        Deque<Double> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if(stack.size() == 0){
                stack.push(Double.parseDouble(expression[i]));
            }else if(expression[i].equals("+")){
                double a = stack.pop();
                double b = stack.pop();
                double c = a + b;
                stack.push(c);
            }else if(expression[i].equals("-")){
                double a = stack.pop();
                double b = stack.pop();
                double c = b - a;
                stack.push(c);
            }else if(expression[i].equals("*")){
                double a = stack.pop();
                double b = stack.pop();
                double c = a * b;
                stack.push(c);
            }else if(expression[i].equals("/")){
                double a = stack.pop();
                double b = stack.pop();
                double c = b / a;
                stack.push(c);
            }else{
                stack.push(Double.parseDouble(expression[i]));
            }
        }

        return stack.pop();
    }
}

