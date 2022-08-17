import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeFile();

        copyFile("student.txt", "student_coppy.txt");
    }
    private static void writeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter content ");
        String arr = scanner.nextLine();
        String PATH_FILE = "D:\\MD2\\Bai17\\BT2\\BT2\\src\\student.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH_FILE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(arr);

            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFile(String src, String dest) {
        File infile = new File("D:\\MD2\\Bai17\\BT2\\BT2\\src\\student.txt");
        File outfile = new File("D:\\MD2\\Bai17\\BT2\\BT2\\src\\student_coppy.txt");
        FileInputStream instream = null;
        FileOutputStream outstream = null;

        try
        {
            instream = new FileInputStream(infile);
            outstream = new FileOutputStream(outfile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = instream.read(buffer)) > 0) {
                outstream.write(buffer, 0, length);
            }
            instream.close();
            outstream.close();
            System.out.println("Copy success!");

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}