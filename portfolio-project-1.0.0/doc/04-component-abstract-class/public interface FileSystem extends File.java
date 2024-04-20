
import java.util.List;

public interface FileSystemKernel extends Standard<FileSystem> {
    
    /**
     * Creates a new file with the given name and type.
     *
     * @param name The name of the file to be created.
     * @param type The type of the file (e.g., TEXT, IMAGE, etc.).
     * @ensures A new file with the specified name and type is created.
     */
    void createFile(String name, FileType type);
    
    /**
     * Deletes ithe file with the given name.
     *
     * @param name The name of the file to be deleted.
     * @ensures If a file with the specified name exists, it is deleted.
     */
    void deleteFile(String name);
    
    /**
     * Retrieves the file with the given name.
     *
     * @param name The name of the file to retrieve.
     * @return The file with the specified name, or null if not found.
     * @ensures If a file with the specified name exists, it is returned.
     */
    File getFile(String name);
    
    /**
     * Creates a new directory with the given name.
     *
     * @param name The name of the directory to be created.
     * @ensures A new directory with the specified name is created.
     */
    void createDirectory(String name);
    
    /**
     * Deletes the directory with the given name.
     *
     * @param name The name of the directory to be deleted.
     * @ensures If a directory with the specified name exists, it is deleted.
     */
    void deleteDirectory(String name);
    
    /**
     * Retrieves a list of all files in the file system.
     *
     * @return A list containing all files in the file system.
     * @ensures A list of all files in the file system is returned.
     */
    List<File> listFiles();
    
    /**
     * Renames the file with the specified old name to the new name.
     *
     * @param oldName The current name of the file.
     * @param newName The new name for the file.
     * @ensures If a file with the specified old name exists, its name is changed to the new name.
     */
    void renameFile(String oldName, String newName);
}


public interface FileSystem extends FileSystemKernel {
    
    /**
     * Copies the file with the specified name to a new location.
     *
     * @param name      The name of the file to be copied.
     * @param newFolder The name of the destination folder for the copied file.
     * @ensures If a file with the specified name exists, a copy of it is created in the specified folder.
     */
    void copyFile(String name, String newFolder);
    
    /**
     * Moves the file with the specified name to a new location.
     *
     * @param name      The name of the file to be moved.
     * @param newFolder The name of the destination folder for the moved file.
     * @ensures If a file with the specified name exists, it is moved to the specified folder.
     */
    void moveFile(String name, String newFolder);
    
    /**
     * Searches for files containing the specified keyword in their names.
     *
     * @param keyword The keyword to search for.
     * @return A list of files containing the keyword in their names.
     * @ensures A list of files containing the specified keyword in their names is returned.
     */
    List<File> searchFiles(String keyword);
}
