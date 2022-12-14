public class File { // A file class to help with Day 7
    private String name;
    private int size;

    public File() {
        name = "";
        size = 0;
    }

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void print() {
        System.out.println("- " + name + ", size = " + size);
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
