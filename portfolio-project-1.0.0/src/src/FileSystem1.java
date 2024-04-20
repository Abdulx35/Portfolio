import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystem1 extends FileSystemSecondary implements FileSystem {

    private Map<String, File> files;
    private Map<String, List<File>> directories;

    public FileSystem1() {
        this.files = new HashMap<>();
        this.directories = new HashMap<>();
    }

    @Override
    public void copyFile(String name, String newFolder) {
        // Implement copying file to a new location
    }

    @Override
    public void moveFile(String name, String newFolder) {
        // Implement moving file to a new location
    }

    @Override
    public List<File> searchFiles(String keyword) {
        // Implement searching for files containing the specified keyword
        return null; // Placeholder
    }
}
