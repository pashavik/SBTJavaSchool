package crypto;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        byte key = 17;
        ClassLoader loader =
                new EncryptedClassLoader(
                        key,
                        "C:\\Users\\pashp\\IdeaProjects\\SBTJavaSchool\\out\\production\\lesson7\\",
                        Main.class.getClassLoader());

        Test test =  (Test)loader.loadClass("crypto.TestImpl").newInstance();
        test.doSmth();
    }
}
