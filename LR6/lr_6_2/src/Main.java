import java.util.Stack;

/*
    Задана строка, состоящая из символов '(', ')', '[', ']', '{', '}'.
    Проверить правильность расстановки скобок. Использовать стек.
 */

public class Main {
    public static void main(String[] args) {
        String input = "([]{()})"; // Заданная строка
        if (checkBrackets(input)) {
            System.out.println("Скобки расставлены правильно.");
        } else {
            System.out.println("Скобки расставлены неправильно.");
        }
    }

    public static boolean checkBrackets(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // Неправильное сочетание скобок
            }
        }
        return stack.isEmpty(); // Все скобки должны быть закрыты
    }
}