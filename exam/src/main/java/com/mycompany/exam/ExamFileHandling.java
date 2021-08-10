package com.mycompany.exam;

import java.io.*;
import java.util.*;

public class ExamFileHandling {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** File Handling Menu ***");
        while (true) {
            System.out.println("1.Create");
            System.out.println("2.Read");
            System.out.println("3.Write");
            System.out.println("4.Copy");
            System.out.println("5. Get Absolute Path");
            System.out.println("6. Get Length of file");
            System.out.println("7. Append");
            System.out.println("8.Delete");
            System.out.println("9.EXIT");

            System.out.println("Enter your choice::");

            int choice = sc.nextInt();
            File file = new File("D:\\MCA SEM-4\\java\\exam\\src\\main\\java\\com\\mycompany\\exam\\abc.txt");
            switch (choice) {
                case 1:
                                try {
                    boolean value = file.createNewFile();
                    if (value) {
                        System.out.println("New File is created !");
                    } else {
                        System.out.println("The File already exists !");
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

                case 2:

                    char arr[] = new char[100];
                    try {
                        FileReader input = new FileReader("D:\\MCA SEM-4\\java\\exam\\src\\main\\java\\com\\mycompany\\exam\\abc.txt");
                        input.read(arr);
                        System.out.println("DATA in file:");
                        System.out.println(arr);
                        input.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    String data = "Hello this Chaitanya , Currently giving AJP lab exam !";
                    try {
                        FileWriter output = new FileWriter("D:\\MCA SEM-4\\java\\exam\\src\\main\\java\\com\\mycompany\\exam\\abc.txt");
                        output.write(data);
                        System.out.println("Data successfully written onto the file");
                        output.close();

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    byte array[] = new byte[50];
                    try {
                        FileInputStream source = new FileInputStream("D:\\MCA SEM-4\\java\\exam\\src\\main\\java\\com\\mycompany\\exam\\abc.txt");
                        FileOutputStream dest = new FileOutputStream("D:\\MCA SEM-4\\java\\exam\\src\\main\\java\\com\\mycompany\\exam\\copy.txt");

                        source.read(array);
                        dest.write(array);

                        System.out.println("The File is copied successfully");

                        source.close();
                        dest.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    String path = file.getAbsolutePath();
                    System.out.println("The Path of the given file is :" + path);
                    break;

                case 6:
                    int l = (int) file.length();
                    System.out.println("The Length of the given file in bytes is :" + l);
                    break;

                case 7:
                    try {
                    String a = "Here I'm apppending the data to a existing file !";
                    FileWriter fileWritter = new FileWriter(file.getName(), true);
                    BufferedWriter bw = new BufferedWriter(fileWritter);
                    bw.write(a);
                    bw.close();
                    System.out.println("File Appended successfully !");
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
                case 8:
                    boolean value = file.delete();
                    if (value) {
                        System.out.println("File Deleted successfully !");
                    } else {
                        System.out.println("Error ! while deleting file !!");
                    }

                    break;

                case 9:
                    System.out.println("Exiting the application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect input!!! Please re-enter choice from our menu");
            }
        }
    }
}
