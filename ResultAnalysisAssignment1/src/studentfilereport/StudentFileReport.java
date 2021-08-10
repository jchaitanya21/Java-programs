
package studentfilereport;
import java.io.*;
import java.util.*;

class Student
{
    int mks[] = new int[5];
    String studname;
    
    Student(String name, int marks[])
    {
        this.studname = name;
        for(int i=0; i<marks.length;i++)
        {
            this.mks[i] = marks[i];
        }
    }
    
    String getStudentName()
    {
        return this.studname;
    }
    
    float getAvg()
    {
        int total = 0;
        float percentage = 0;
        for(int i=0;i<5;i++)
        {
            total = total + mks[i];
            
        }
        percentage = total/5;
        return percentage;    
    }
    
    String getGrade(float per)
    {
         if(per < 100 && per >= 90)
         return "Excellent : A+";
      else if(per < 90 && per >= 80)
         return "Very Good : A";
      else if(per < 80 && per >= 70)
         return "Good : B+";
      else if(per < 70 && per >= 55)
         return "Average : B";
      else if(per < 55 && per >= 35)
         return "Need to be Improved : C";
      else if(per < 35)
         return "Fail";
      return "NULL";
    }
   
}

public class StudentFileReport
{
    ArrayList<Student> ListOfStudents = new ArrayList<Student>();
    void read()
    {
        String ln = "";
        try
        {
            BufferedReader br = new BufferedReader ( new FileReader("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\studentfilereport\\Student_Record.csv"));
            while((ln = br.readLine())!= null)
            {
                int marks[] = new int[5];
                String data[] = ln.split(",");
                for(int i=0;i<5;i++)
                {
                    marks[i] = Integer.parseInt(data[i+1]);
                    
                }
                ListOfStudents.add(new Student(data[0],marks));
               
            }
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    void report()
    {
        try
        {
            FileWriter fw1 = new FileWriter("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\studentfilereport\\avgreport.csv");
            FileWriter fw2 = new FileWriter("D:\\MCA SEM-4\\java\\ResultAnalysisAssignment1\\src\\studentfilereport\\gradereport.csv");
            fw1.write("Generated Percentage Report"+"\n");
            fw1.write("Student"+" :"+"Percentage"+"\n");
            fw2.write("Generated Grade Report"+"\n");
            fw2.write("Student"+" :"+"Grade"+"\n");
            for(Student s : ListOfStudents)
            {
   
                fw1.write(s.getStudentName()+" :"+s.getAvg()+"\n");
                fw2.write(s.getStudentName()+" :"+s.getGrade(s.getAvg())+"\n");
            }
            fw1.close();
            fw2.close();
            System.out.println("Report Generated Successfully!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }   
    public static void main(String args[])
    {
       StudentFileReport ob = new StudentFileReport();
       ob.read();
       ob.report();
       
    }
}