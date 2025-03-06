package src.programmers.lv2;

import java.util.*;

public class Problem75 {

    // [카카오 인턴] 수식 최대화
    public long solution(String expression) {
        String[][] operatorOrders = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "+", "-"},
                {"*", "-", "+"}
        };

        List<Long> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
                operators.add(String.valueOf(c));
            } else {
                num.append(c);
            }
        }
        numbers.add(Long.parseLong(num.toString()));

        long maxResult = 0;

        for (String[] order : operatorOrders) {
            maxResult = Math.max(maxResult, Math.abs(calculate(numbers, operators, order)));
        }

        return maxResult;
    }

    private long calculate(List<Long> numbers, List<String> operators, String[] order) {
        List<Long> numList = new ArrayList<>(numbers);
        List<String> opList = new ArrayList<>(operators);

        for (String op : order) {
            for (int i = 0; i < opList.size(); ) {
                if (opList.get(i).equals(op)) {
                    long result = operate(numList.get(i), numList.get(i + 1), op);
                    numList.set(i, result);
                    numList.remove(i + 1);
                    opList.remove(i);
                } else {
                    i++;
                }
            }
        }
        return numList.get(0);
    }

    private long operate(long a, long b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            default: throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}
