import java.util.List;

public class FileSystemDemo {

    public static void main(String[] args) {
        // Create a new file system
        FileSystem1 fileSystem = new FileSystem1();

        // Create some files
        fileSystem.createFile("document1.txt", FileSystem1.FileType.TEXT);
        fileSystem.createFile("image1.png", FileSystem1.FileType.IMAGE);
        fileSystem.createFile("spreadsheet1.xlsx",
                FileSystem1.FileType.SPREADSHEET);
        fileSystem.createFile("document2.txt", FileSystem1.FileType.TEXT);
        fileSystem.createFile("presentation1.pptx",
                FileSystem1.FileType.PRESENTATION);

        // Create directories
        fileSystem.createDirectory("documents");
        fileSystem.createDirectory("images");
        fileSystem.createDirectory("presentations");

        // Move files to directories
        fileSystem.moveFile("document1.txt", "documents");
        fileSystem.moveFile("image1.png", "images");
        fileSystem.moveFile("spreadsheet1.xlsx", "documents");
        fileSystem.moveFile("document2.txt", "documents");
        fileSystem.moveFile("presentation1.pptx", "presentations");

        // List all files in the file system
        List<FileSystem1.File> fileList = fileSystem.listFiles();
        System.out.println("Files in the file system:");
        for (FileSystem1.File file : fileList) {
            System.out.println(file.getName() + " (" + file.getType() + ")");
        }

        // Search for files containing a keyword
        List<FileSystem1.File> searchResult = fileSystem
                .searchFiles("document");
        System.out.println("\nFiles containing 'document' in their names:");
        for (FileSystem1.File file : searchResult) {
            System.out.println(file.getName() + " (" + file.getType() + ")");
        }
    }
}
