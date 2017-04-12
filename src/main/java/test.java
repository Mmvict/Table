import java.io.*;
import java.lang.String;

public class test {

    private static String text = "This new text \n This new text2\n This new text3\n This new text4\n";
    private static String fileName = "C://Users//1/a.txt";
    private static String newFileName = "C://Users//1/b.txt";
    private static File file = new File(fileName);

    public static void write(String fileName, String text) {

        //File file = new File(fileName);

        try {

            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                out.print(text);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void renameFile(String fileName, String newFileName) throws FileNotFoundException {
        if (file.exists()) {
            file.renameTo(new File(newFileName));
        }else{
            System.out.println("File not found!");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        test.write(fileName, text);
        test.renameFile(fileName,newFileName);
    }
}
