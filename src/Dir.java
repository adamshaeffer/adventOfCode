public class Dir { // A directory class to help with Day 7
    private String name;
    private Dir parent;
    private Dir[] subdir;
    private File[] files;

    public Dir() {
        name = "";
        parent = null;
        subdir = new Dir[0];
        files = new File[0];
    }

    public Dir(String name, Dir pops) {
        this.name = name;
        parent = pops;
        subdir = new Dir[0];
        files = new File[0];
    }

    public void addDir(Dir newDir) {
        Dir[] temp = new Dir[subdir.length+1];
        for(int i=0; i<subdir.length; i++) {
            temp[i] = subdir[i];
        }
        temp[subdir.length] = newDir;
        subdir = temp;
    }
    
    public void addFile(File newFile) {
        File[] temp = new File[files.length+1];
        for(int i=0; i<files.length; i++) {
            temp[i] = files[i];
        }
        temp[files.length] = newFile;
        files = temp;
    }

    public void print() {
        System.out.println(name + " (dir)");
        for(int i=0; i<subdir.length; i++) {
            subdir[i].print();
        }
        for(int i=0; i<files.length; i++) {
            files[i].print();
        }
        System.out.println("Close: " + name);
    }

    public int totalSize() {
        int sum = 0;
        for(int i=0; i<files.length; i++) {
            sum += files[i].getSize();
        }
        for(int i=0; i<subdir.length; i++) {
            sum += subdir[i].totalSize();
        }
        return sum;
    }

    public int totalSize(int max) {
        int sum = 0;
        int subsum = 0;
        for(int i=0; i<files.length; i++) {
            sum += files[i].getSize();
        }
        for(int i=0; i<subdir.length; i++) {
            sum += subdir[i].totalSize();
        }
        if(sum > max) {
            sum = 0;
        }
        for(int i=0; i<subdir.length; i++) {
            subsum += subdir[i].totalSize(max);
        }
        sum += subsum;
        System.out.println(name + " contains: " + sum);
        return sum;
    }

    public int smallAtLeast(int atLeast) {
        int curr = totalSize();
        int min = curr;
        int temp;
        for(int i=0; i<subdir.length; i++) {
            temp = subdir[i].smallAtLeast(atLeast);
            if(temp < atLeast)
                continue;
            if(temp < min)
                min = temp;
        }
        return min;
    }

    public String getName() {
        return name;
    }

    public Dir getDir(String name) {
        for(int i=0; i<subdir.length; i++) {
            if(subdir[i].getName().equals(name)) {
                return subdir[i];
            }
        }
        return null;
    }

    public File getFile(String name) {
        for(int i=0; i<files.length; i++) {
            if(files[i].getName().equals(name)) {
                return files[i];
            }
        }
        File blah = new File("Error", 0);
        return blah;
    }

    public Dir getParent() {
        return parent;
    }
}
