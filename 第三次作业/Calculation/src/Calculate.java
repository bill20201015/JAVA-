/**
 * @author sk
 * @version 1.0
 */
public class Calculate {

    public static void main(String[] args) {
        String[] expression = new String[]{"(", "2", "+", "3",")", "*", "6"};// 2 + 3 * 6
        InfixToSuffix infixToSuffix = new InfixToSuffix();
        String[] str = infixToSuffix.translation(expression);

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
        System.out.println(infixToSuffix.calculateSuffix(str));

    }
}
