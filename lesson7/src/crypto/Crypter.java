package crypto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Crypter {
    public static void main(String[] args) throws IOException {
       // Path path = Paths.get("C:/Users/pashp/IdeaProjects/SBTJavaSchool/lesson7/src/crypto/EncryptedClassLoader.java", "TestImpl.class");
        Path path = Paths.get("C:/Users/pashp/IdeaProjects/SBTJavaSchool/out/production/lesson7/crypto", "TestImpl.class");

        byte key = 17;
        byte[] data = Files.readAllBytes(path);

        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(data[i] ^ key);
        }

        Files.write(path, data, StandardOpenOption.WRITE);
    }
}

