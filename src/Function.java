public class Function { // Literally just to make easy printing of many data types
    public Function() {
    }

    public void print(String str) {
        System.out.println(str);
    }
    public void print(int str) {
        System.out.println(str);
    }
    public void print(String[] str) {
        print("{");
        for(int i=0; i<str.length-1; i++) {
            print(str[i] + ", ");
        }
        print(str[str.length-1]);
        print("}");
    }
    public void print(char[] str) {
        System.out.print("{");
        for(int i=0; i<str.length-1; i++) {
            System.out.print(str[i] + ", ");
        }
        System.out.print(str[str.length-1]);
        System.out.println("},");
    }
    public void print(char[][] arr) {
        print("{");
        for(int i=0; i<arr.length; i++) {
            print(arr[i]);
        }
        print("}");
    }
    public void print(int[] arr) {
        if(arr.length > 0) {
            System.out.print("{");
            for(int i=0; i<arr.length-1; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println(arr[arr.length-1] + "},");
        } else {
            System.out.println("{}");
        }
    }
    public void print(int[][] arr) {
        print("{");
        for(int i=0; i<arr.length; i++) {
            print(arr[i]);
        }
        print("}");
    }
    public void print(Stack[] arr) {
        print("{");
        for(int i=0; i<arr.length; i++) {
            arr[i].print();
        }
        print("},");
    }


    public int[] add(int[] arr, int a) {
        int[] temp = new int[arr.length+1];
        for(int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[arr.length] = a;
        return temp;
    }
    public int[][] add(int[][] arr, int[] a) {
        int[][] temp;
        temp = new int[arr.length+1][a.length];
        for(int i=0; i<arr.length; i++) {
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }
        temp[arr.length][0] = a[0];
        temp[arr.length][1] = a[1];
        return temp;
    }
    public char[] add(char[] arr, char a) {
        char[] temp = new char[arr.length+1];
        for(int i=0; i<arr.length; i++) {
            temp[i] = arr[i];
        }
        temp[arr.length] = a;
        return temp;
    }
    public char[][] add(char[][] arr, char[] a) {
        char[][] temp = new char[arr.length+1][a.length];
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<a.length; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        for(int i=0; i<a.length; i++) {
            temp[arr.length][i] = a[i];
        }
        return temp;
    }

    public int[][] remove(int[][] arr, int p) {
        int[][] temp = new int[arr.length-1][arr[0].length];
        for(int i=0; i<p; i++) {
            temp[i][0] = arr[i][0];
            temp[i][1] = arr[i][1];
        }
        for(int i=p; i<temp.length; i++) {
            temp[i][0] = arr[i+1][0];
            temp[i][1] = arr[i+1][1];
        }
        return temp;
    }
}
