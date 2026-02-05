import java.sql.*;
import java.util.Scanner;

public class ATM_Stimulation_db
{
    static Connection con;
    static Scanner sc=new Scanner(System.in);
    static int accno,pin;
    static String name="";
    static double op_bal=0.0;
    public static void connect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_db","root","Riya@231103");
            con.setAutoCommit(false);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void signup()
    {
        try
        {
            System.out.print("Enter Holder Name : ");
            name=sc.nextLine();
            sc.next();
            System.out.print("Enter Account No : ");
            accno=sc.nextInt();
            System.out.print("Enter 4-Digit Pin : ");
            pin=sc.nextInt();
            System.out.print("Enter Opening Balance : ");
            op_bal=sc.nextDouble();


            Statement stmt=con.createStatement();
            stmt.executeUpdate("insert into account values('"+accno+"','"+pin+"','"+name+"','"+op_bal+"');");
            con.commit();
            System.out.print("\nSign Up Successful...");
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void login()
    {
        try
        {
            System.out.print("Enter Account No : ");
            accno=sc.nextInt();
            System.out.print("Enter 4-Digit Pin : ");
            pin=sc.nextInt();

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select accno,pin from account where accno='"+accno+"' and pin='"+pin+"';");

            if(!rs.next())
            {
                System.out.print("\nInvalid Account No/Pin");
                System.exit(0);
            }
            else
            {
                System.out.print("\nLogin Successful...");
                menu();
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void menu()
    {
        while(true)
        {
            System.out.print("\n-----------------WELCOME to ATM-----------------");
            System.out.print("\n1.Check Balance\n2.Deposit\n3.Withdraw\n0.Exit");
            System.out.print("\n----------------------------------------------");
            System.out.print("\nEnter Choice : ");
            int ch=sc.nextInt();
            if(ch==1)
            {
                chk_bal();
            }
            else if(ch==2)
            {
                deposit();
            }
            else if(ch==3)
            {
                withdraw();
            }
            else if(ch==0)
            {
                System.out.print("\nThank You.........\nHave a Great Day!!!!!!");
                System.exit(0);
            }
            else
            {
                System.out.println("\nInvalid Choice");
            }
        }
    }
    public static void chk_bal()
    {
        try
        {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select op_bal from account where accno='"+accno+"';");
            rs.next();
            System.out.print("\nCurrent Balance : "+rs.getDouble("op_bal"));
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void deposit()
    {
        try
        {
            System.out.print("\nEnter Amount to Deposit : ");
            double amt=sc.nextDouble();

            Statement stmt=con.createStatement();
            stmt.executeUpdate("update account set op_bal=op_bal+'"+amt+"' where accno='"+accno+"';");
            System.out.print("\nRs."+amt+" Deposited Successfully...");
            chk_bal();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void withdraw()
    {
        try
        {
            System.out.print("\nEnter Amount to Withdraw : ");
            double amt=sc.nextDouble();

            Statement stmt=con.createStatement();
            stmt.executeUpdate("update account set op_bal=op_bal-'"+amt+"' where accno='"+accno+"';");
            System.out.print("\nRs."+amt+" Withdrawn Successfully...");
            chk_bal();
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }
    public static void main(String [] args)
    {
        connect();
        System.out.print("\n------------WELCOME------------");
        System.out.print("\n1.Sign Up\n2.Log In\n0.Exit");
        System.out.print("\n-------------------------------");
        System.out.print("\nEnter Choice : ");
        int ch=sc.nextInt();
        if(ch==1)
        {
            signup();
        }
        else if(ch==2)
        {
            login();
        }
        else if(ch==0)
        {
            System.out.print("\nThank You.........\nHave a Great Day!!!!!!");
            System.exit(0);
        }
        else
        {
            System.out.print("\nInvalid Choice");
            System.exit(0);
        }
    }
}
