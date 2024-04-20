import java.io.File;

public abstract class FileSystemSecondary extends FileSystemKernel {

    @Override
    public void createDirectory(String n) {
        super.createDirectory(n);
    }

    @Override
    public void deleteDirectory(String name) {
        super.deleteDirectory(name);
    }

    @Override
    public java.util.Queue<File> listFiles() {
        return super.listFiles();
    }

    @Override
    public void renameFile(String oldName, String newName) {
        super.renameFile(oldName, newName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("File System ");
        java.util.Queue<File> fileList = this.listFiles();
        while (fileList.size() > 0) {
            File word = fileList.poll();
            sb.append(word.toString()).append("\n");
            fileList.add(word);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        FileSystemSecondary other = (FileSystemSecondary) obj;
        java.util.Queue<File> thisFiles = this.listFiles();
        java.util.Queue<File> otherFiles = other.listFiles();
        if (thisFiles.size() != otherFiles.size()) {
            return false;
        }
        while (thisFiles.size() > 0) {
            File thisFile = thisFiles.poll();
            File otherFile = otherFiles.poll();
            if (!thisFile.equals(otherFile)) {
                return false;
            }
            thisFiles.add(thisFile);
            otherFiles.add(otherFile);
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        java.util.Queue<File> files = this.listFiles();
        while (!files.isEmpty()) {
            File file = files.poll();
            result = prime * result + file.hashCode();
            files.add(file);
        }
        return result;
    }
}
