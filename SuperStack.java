import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuperStack {

    private static int[] array = new int[100];

    private static int top = -1;

    private static int noOfOperations = 0;

    private static int counter = 0;

    private static String[] operations = new String[100];

    public static void main(String[] args) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number of stack operations : ");
            noOfOperations = Integer.parseInt(reader.readLine());

            System.out.println("Enter the operations : ");
            while (counter < noOfOperations) {
                operations[counter++] = reader.readLine();
            }
            superStack(operations, noOfOperations);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }

    private static void push(int value) {
        array[++top] = value;
    }

    private static void pop() {
        top--;
    }

    private static void inc(int count, int adder) {
        for (int i = 0; i < count; i++) {
            array[i] += adder;
        }
    }

    private static void superStack(String[] operations, int noOfOperations) {
        for (int i = 0; i < noOfOperations; i++) {
            if (operations[i].contains("push")) {
                push(Integer.parseInt(operations[i].split(" ")[1]));
                System.out.println(array[top]);
            } else if (operations[i].contains("pop")) {
                pop();
                System.out.println(top == -1 ? "EMPTY" : array[top]);
            } else if (operations[i].contains("inc")) {
                inc(Integer.parseInt(operations[i].split(" ")[1]), Integer.parseInt(operations[i].split(" ")[2]));
                System.out.println(array[top]);
            } else {
                throw new RuntimeException("Not a valid operation");
            }

        }
    }
}
