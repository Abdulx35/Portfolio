import java.io.File;
import java.util.List;

public interface FileSystem extends FileSystemKernel {

    void copyFile(String name, String newFolder);

    void moveFile(String name, String newFolder);

    List<File> searchFiles(String keyword);
}
