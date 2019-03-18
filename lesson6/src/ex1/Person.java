package ex1;

public class Person {
    public static final String TEST1 = "TEST1";
    public static final String TEST2 = "TEST2";
    public static final String TEST3 = "TEST33";
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String privateMethod(){
        return "private method";
    }
}
