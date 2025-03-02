package Neprivalomos;

import util.LinkedListStack;

public class FirstTask {

    public static void main(String[] args)
    {
        String input = "}";             // false
        System.out.println(algorithm(input));

        input = "{()} {[]}";    // true
        System.out.println(algorithm(input));

        input = "[{}}";        // false
        System.out.println(algorithm(input));

        input = "{()[{}]}{}";  // true
        System.out.println(algorithm(input));

        input = "{(})";        // false
        System.out.println(algorithm(input));

        input = "([(]{)})";    // false
        System.out.println(algorithm(input));
    }

    public static boolean algorithm(String input)
    {
        LinkedListStack<Character> stack = new LinkedListStack<>();
        char previous;

        for(int i = 0; i < input.length(); i++)
        {
            char current = input.charAt(i);

            if(charOpen(current))
            {
                stack.push(current);
            }
            else
            {
                if (stack.isEmpty()){
                    return false;
                }

                previous = stack.pop();

                if (!correctPair(previous, current)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean charOpen(char character)
    {
        return character == '[' || character == '{' || character == '(';
    }

    public static boolean correctPair(char open, char closed)
    {
        return (open == '(' && closed == ')') || (open == '{' && closed == '}') || (open == '[' && closed == ']');
    }
}
