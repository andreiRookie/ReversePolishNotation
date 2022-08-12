import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException {

        Deque<Integer> operands = new ArrayDeque<>();
        Stack<String> operators = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите математическое выражение:");
        String input = scanner.nextLine();

        String[] inputArray = input.split(" ");
        System.out.println("Массив введенных значений: " + Arrays.toString(inputArray));

        for (int i = 0; i < inputArray.length; i++) {
            String arg = inputArray[i];
            if (isSymbolNumeric(arg)) {
                operands.add(Integer.parseInt(arg));
            } else {
                operators.add(arg);
            }
        }
        System.out.println("Операнды: " + operands);
        System.out.println("Операторы: " + operators);

        StringBuilder sb = new StringBuilder();

        while (!operands.isEmpty()) {
            sb.append(operands.poll().toString() + " ");
        }

        while (!operators.isEmpty()) {
            sb.append(operators.pop() + " ");
        }

        System.out.println("Формат ОПН(постфикс): " + sb.toString());

    }

    public static boolean isSymbolNumeric(String symbol) {
        try {
            Integer.parseInt(symbol);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

