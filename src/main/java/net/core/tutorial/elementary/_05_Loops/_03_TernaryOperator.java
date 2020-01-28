package net.core.tutorial.elementary._05_Loops;

/**

 Ternary Operator.

 Альтернативой использования оператора условного перехода if-else
 является использование тернарного (тройного) оператора, что в некоторых случаях позволяет
 улучшить читабельность кода.

 Синтаксис:
 booleanExpression ? expression1 : expression2

 The very first operand must be a boolean expression, the second and the third operands can be
 any expression that returns some value. The ternary construct returns expression1 as an output
 if the first operand evaluates to true, expression2 otherwise.

 */

public class _03_TernaryOperator {

    public static void main(String[] args) {

        int num = 8;
        String msg1 = "";
        if(num > 10) {
            msg1 = "Number is greater than 10";
        }
        else {
            msg1 = "Number is less than or equal to 10";
        }
        System.out.println(msg1);

        System.out.println("---------------------------");

        String msg2 = num > 10
                ? "Number is greater than 10"
                : "Number is less than or equal to 10";
        System.out.println(msg2);

        System.out.println("---------------------------");

        // Expression evaluation
        int exp1 = 0, exp2 = 0;
        int result = 12 > 10 ? ++exp1 : ++exp2;
        System.out.println("result=" + result + ", exp1=" + exp1 + ", exp2=" + exp2);

        int exp3 = 0, exp4 = 0;
        result = 12 < 10 ? ++exp3 : ++exp4;
        System.out.println("result=" + result + ", exp3=" + exp3 + ", exp4=" + exp4);

        System.out.println("---------------------------");

        // Nesting Ternary Operator
        String msg3 = num > 10 ? "Number is greater than 10"
                : (num > 5 ? "Number is greater than 5" : "Number is less than equal to 5");
        System.out.println(msg3);
    }
}
