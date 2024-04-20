import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystemKernel {

    private Map<String, File> files;
    private Map<String, List<File>> directories;

    public FileSystemKernel() {
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
    }

    public void createFile(String name, FileType type) {
        File file = new File(name, type);
        this.files.put(name, file);
    }

    public void deleteFile(String name) {
        this.files.remove(name);
    }

    public File getFile(String name) {
        return this.files.get(name);
    }

    protected void createDirectory(String name) {
        this.directories.put(name, new ArrayList<>());
    }

    protected void deleteDirectory(String name) {
        this.directories.remove(name);
    }

    protected List<File> listFiles() {
        List<File> fileList = new ArrayList<>();
        for (File file : this.files.values()) {
            fileList.add(file);
        }
        return fileList;
    }

    protected void renameFile(String oldName, String newName) {
        if (this.files.containsKey(oldName)) {
            File file = this.files.remove(oldName);
            file.setName(newName);
            this.files.put(newName, file);
        }
    }
}
