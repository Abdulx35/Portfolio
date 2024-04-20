import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class FileSystem1Test {

    @Test
    public void testCreateFile() {
        FileSystem1 fs = new FileSystem1();
        fs.createFile("test.txt", FileType.TEXT);
        assertNotNull(fs.getFile("test.txt"));
    }

    @Test
    public void testDeleteFile() {
        FileSystem1 fs = new FileSystem1();
        fs.createFile("test.txt", FileType.TEXT);
        assertNotNull(fs.getFile("test.txt"));
        fs.deleteFile("test.txt");
        assertNull(fs.getFile("test.txt"));
    }

    // Add more test cases for other methods as needed
}
