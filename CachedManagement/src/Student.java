import java.io.*;

public class Student extends FuMemoryCached {
    public static void main(String[] args) throws Exception {

        File file = new File(
                "D:\\FPT\\SP23\\LAB211\\CachedManagement\\file.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null)
            System.out.println(st);

    }
}
