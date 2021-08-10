import java.io.*;
import java.util.*;
public class FileHandling      
{
    public static void main(String args[]) throws Exception
    {
        int choice;
        File file = new File("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\file.txt");
        while(true)
        {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n MENU \n 1.Create \n 2.Read \n 3.Write \n 4.copy \n 5.delete \n 6.EXIT \n");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        
            switch(choice)
            {
                case 1: System.out.println("Case 1 Create");
                        try 
                        {
                            boolean value = file.createNewFile();
                            if (value) 
                            {
                                System.out.println("The new file is created.");
                            }
                            else 
                            {
                                System.out.println("The file already exists.");
                                
                            }
                        }
                        catch(Exception e) 
                        {
                            e.getStackTrace();
                        }
                        break;
                case 2:System .out.println("Case 2 Read");
                        try
                        {
                            char[] arr = new char[100];
                            FileReader input = new FileReader("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\file.txt");
                            input.read(arr);
                            System.out.println("Data in the file:");
                            System.out.println(arr);
                            input.close();
                        }
                        catch(Exception e)
                        {
                            e.getStackTrace();
                        }
                        break;
                case 3:System.out.println("Case 3 Write");
                        String data = "Hi this is Chaitanya, I'm Writing on to this file.";
                        try
                        {
                            FileWriter output = new FileWriter("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\file.txt");
                            output.write(data);
                            System.out.println("Data is written to the file.");
                            output.close();
                        }
                        catch(Exception e)
                        {
                            e.getStackTrace();
                        }
                        break;
                case 4:System.out.println("Case 4 Copy");
                        byte[] array = new byte[50];
                        try
                        {
                          FileInputStream sourceFile = new FileInputStream("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\file.txt");
                          FileOutputStream destFile = new FileOutputStream("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\new.txt");
                          sourceFile.read(array);
                          destFile.write(array);
                          System.out.println("The file.txt file is copied to new.txt");
                          sourceFile.close();
                          destFile.close();
                        }
                        catch(Exception e)
                        {
                            e.getStackTrace();
                        }
                        break;
                case 5:System.out.println("Case 5 Delete");
                        try
                        {
                            File f = new File("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\new.txt");
                            boolean value = f.delete();
                            if(value) 
                            {
                                System.out.println("The new.txt File is deleted.");
                            }
                            else 
                            {
                                System.out.println("The new.txt File is not deleted.");
                            }
                            
                        }
                        catch(Exception e)
                        {
                            e.getStackTrace();
                        }
                        break;
                case 6:System.out.println("Exited !");
                        System.exit(0);
                        break;
                default:System.out.println("Invalid option pls re-enter!");
                        break;
            }
        }
        
    }
    
}
