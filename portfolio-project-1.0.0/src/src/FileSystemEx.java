import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystemEx {

    private Map<String, File> files;
    private Map<String, List<File>> directories;

    public FileSystem1() {
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

    public void createDirectory(String name) {
        this.directories.put(name, new ArrayList<>());
    }

    public void deleteDirectory(String name) {
        this.directories.remove(name);
    }

    public List<File> listFiles() {
        List<File> fileList = new ArrayList<>();
        for (File file : this.files.values()) {
            fileList.add(file);
        }
        return fileList;
    }

    public void moveFile(String name, String newFolder) {
        File file = this.files.get(name);
        if (file != null) {
            this.files.remove(name);
            List<File> directory = this.directories.getOrDefault(newFolder,
                    new ArrayList<>());
            directory.add(file);
            this.directories.put(newFolder, directory);
        }
    }

    public List<File> searchFiles(String keyword) {
        List<File> result = new ArrayList<>();
        for (File file : this.files.values()) {
            if (file.getName().contains(keyword)) {
                result.add(file);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FileSystem1 fileSystem = new FileSystem1();

        fileSystem.createFile("document1.txt", FileType.TEXT);
        fileSystem.createFile("image1.png", FileType.IMAGE);
        fileSystem.createFile("spreadsheet1.xlsx", FileType.SPREADSHEET);

        fileSystem.createDirectory("documents");

        fileSystem.moveFile("document1.txt", "documents");

        List<File> fileList = fileSystem.listFiles();
        System.out.println("Files in the file system:");
        for (File file : fileList) {
            System.out.println(file.getName());
        }

        List<File> searchResult = fileSystem.searchFiles("document");
        System.out.println("\nFiles containing 'document' in their names:");
        for (File file : searchResult) {
            System.out.println(file.getName());
        }
    }

    public enum FileType {
        TEXT, IMAGE, SPREADSHEET
    }

    public static class File {
        private String name;
        private FileType type;

        public File(String name, FileType type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public FileType getType() {
            return this.type;
        }

        public void setType(FileType type) {
            this.type = type;
        }
    }
}
