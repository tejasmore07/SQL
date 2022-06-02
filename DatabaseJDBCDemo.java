import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseJDBCDemo {
    public static void main(String[] args) {
        Connection con =null;
        Statement stmt=null;

        try{
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_info",
                    "postgres","root");
            System.out.println("Database Connection is opened");


            stmt=con.createStatement();
            String sql="INSERT INTO EMP_DATA (EMP_ID,FIRST_NAME,LAST_NAME,AGE,GENDER,ADDRESS,SALARY,DEPARTMENT)"
                    + "VALUES(104,'jayesh','pande',22,'M','PUNE',22000,'Quality')";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getClass().getName());
            System.exit(0);

        }
        System.out.println("VALUES INSERTED IN TABLE SUCCESSFULLY");
    }
}