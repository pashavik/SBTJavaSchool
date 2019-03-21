package readURL;

import com.sun.jndi.toolkit.url.Uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLDataException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try{
            Scanner sc=new Scanner(System.in);


            System.out.println("введите url");
            String url=sc.nextLine();
            read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void read(String url) throws IOException {
        URL u=new URL(url);
        BufferedReader reader=new BufferedReader(new InputStreamReader(u.openStream()));
        String input;
        while ((input=reader.readLine())!=null)
            System.out.println(input);
            reader.close();


    }
}
