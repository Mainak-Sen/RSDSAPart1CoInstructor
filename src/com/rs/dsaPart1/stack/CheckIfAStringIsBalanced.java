package com.rs.dsaPart1.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckIfAStringIsBalanced {

    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
    }

    private static boolean checkIfAStringIsBalanced(String input) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (currentCharacter == '(' || currentCharacter == '{' || currentCharacter == '[') {
                stack.push(currentCharacter);
            } else if (currentCharacter == ')' || currentCharacter == ']' || currentCharacter == '}') {
                //decisioning factor is when we encounter a closing bracket
                char top = stack.isEmpty() ? '#' : stack.pop(); //dummy character '#' just so that we dont end up in NPE when character is just a closing bracket
                if (top != map.get(currentCharacter)) {
                    return false;
                }
            } else {
                continue;
            }
        }

        //if we happen to reach here the stack should be empty , if not then its not a balanced string
        return stack.isEmpty();


    }


    public static void main(String[] args) {

        String input = "";
        System.out.println(checkIfAStringIsBalanced(input));

    }

}
