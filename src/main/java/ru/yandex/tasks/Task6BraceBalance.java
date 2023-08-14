package ru.yandex.tasks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        /*
         * sequence - последовательность скобок []{}() длины до 10^5
         * Выход: true/false, является ли строка ПСП
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        Stack<Character> stack = new Stack<>();
        Set<Character> closing = Set.of(']', '}', ')');
        for(var c: sequence.toCharArray()){
            if(closing.contains(c)){
                if(stack.empty())
                    return false;
                if(c == ']' && stack.pop() != '[')
                    return false;
                if(c == ')' && stack.pop() != '(')
                    return false;
                if(c == '}' && stack.pop() != '{')
                    return false;
            } else{
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}
