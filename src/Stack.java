public class Stack { // A simple stack class to help with day 5
    private int size;
    private char[] stack;
    public Stack() {
        size = 0;
        stack = new char[size];
    }

    public int getSize() {
        return size;
    }

    public void push(char a) {
        size++;
        char[] arr = new char[size];
        for(int i=0; i<size-1; i++) {
            arr[i] = stack[i];
        }
        arr[arr.length-1] = a;
        stack = arr;
    }

    public char pop() {
        char ret = stack[stack.length-1];
        size--;
        char[] arr = new char[size];
        for(int i=0; i<size; i++) {
            arr[i] = stack[i];
        }
        stack = arr;
        return ret;
    }

    public void print() {
        System.out.print("{");
        if(size != 0) {
            for(int i=0; i<size-1; i++) {
                System.out.print(stack[i] + ", ");
            }
            System.out.print(stack[size-1]);
        }
        System.out.println("}");
    }
}