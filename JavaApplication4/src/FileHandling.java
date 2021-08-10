
import java.io.*;
import java.util.*;

public class FileHandling {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to File handling:");
        while (true) {
            System.out.println("1.Create");
            System.out.println("2.Read");
            System.out.println("3.Write");
            System.out.println("4.Copy");
            System.out.println("5.Delete");
            System.out.println("6.EXIT");

            System.out.println("Enter your choice::");
            int choice = sc.nextInt();
            File file = new File("D:\\MCA SEM-4\\java\\JavaApplication4\\src\\abc.txt");

            switch (choice) {
                case 1:
                                

    try {

                    boolean value = file.createNewFile();
                    if (value) {
                        System.out.println("The new file is created.");
                    } else {
                        System.out.println("The file already exists.");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

                break;
                case 2:
                    System.out.println("I am case 1 READ");
                    char arr[] = new char[100];
                    try {
                        FileReader input = new FileReader("D:\\MCA SEM-4\\java\\JavaApplication4\\src\\abc.txt");
                        input.read(arr);
                        System.out.println("DATA in file:");
                        System.out.println(arr);
                        input.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("I am case 2 WRITE");
                    String Data = "Hello this is Chaitanya, I'm writing this file now";
                    try {
                        FileWriter output = new FileWriter("D:\\MCA SEM-4\\java\\JavaApplication4\\src\\abc.txt");
                        output.write(Data);
                        System.out.println("Data is successfully written onto the file");
                        output.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    byte[] array = new byte[50];
                    try {
                        FileInputStream sourceFile = new FileInputStream("D:\\MCA SEM-4\\java\\JavaApplication4\\src\\abc.txt");
                        FileOutputStream destFile = new FileOutputStream("D:\\MCA SEM-4\\java\\JavaApplication4\\src\\copied.txt");
                        sourceFile.read(array);
                        destFile.write(array);
                        System.out.println("The file is copied Successfully !");

                        sourceFile.close();
                        destFile.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;
                case 5:
                    boolean value = file.delete();
                    if (value) {
                        System.out.println("File is deleted Successfully !");
                    } else {
                        System.out.println("File is not deleted !!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the application");
                    System.exit(0);
                default:
                    System.out.println("Incorrect input!!! Please re-enter choice from our menu");
            }

        }

    }
}
