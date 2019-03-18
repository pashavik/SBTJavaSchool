import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

public class AnnotTest {

    @Documented
    @Target(METHOD)
    @Inherited
    @Retention(RetentionPolicy.CLASS)
    public @interface TestInfo{
        String author() default "defaultAuthor";
        String date();
        int revision() default 1;
    }


    public static void main(String[] args) {

    }

    @Override
    @TestInfo(author = "author1", date ="-1-01010")
    public String toString() {
                return "AnnotTest{}";
    }
}
