import java.util.Scanner;
public class StudentgradeCalulator{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Student Grade Calculator");
        System.out.print("Enter no of Subjects");
        int nS=sc.nextInt();
        int total=0;
        for(int i=0;i<nS;i++){
            System.out.println("Enter Marks obtained in "+(i+1)+": ");
            int marks=sc.nextInt();
            total+=marks;
        }
            int averP=(int)total/nS;
        char Grade;
        if(averP>90){
        Grade='A';
        }
        else if(averP>=80){
        Grade='A';
        }
        else if(averP>=70){
        Grade='B';
        }
        else if(averP>=60){
        Grade='C';
        }
        else if(averP>=50){
        Grade='D';
        }
        else if(averP>=40){
        Grade='E';
        }
        else{
        Grade='F';
        }
    System.out.println("Toatl Marks Scored is "+total);
    System.out.println("Average Percentages Gained is "+averP+"%");
    System.out.println("Grade  :"+Grade);
    sc.close();
}
}
