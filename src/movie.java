import java.sql.*;

public class movie {
    
  public static void main(String[] args){
    
    try{
      
      Class.forName("org.sqlite.JDBC");
      
      // creating database and creating connection
      
      String url="jdbc:sqlite:G:\\mulesoft.db";
      Connection con=DriverManager.getConnection(url);
      
      if(con!=null){
        
        System.out.println("Database created");
        
        // creating table
        
        Statement stmt=con.createStatement();
        int n=stmt.executeUpdate("create table Movies(MovieId int primary key, Name text, Actor text, Genre text, Director text, YearOfRelease int)");
        System.out.println("Table created");
        
        // inserting data into table
        
        PreparedStatement pstmt=con.prepareStatement("insert into Movies values(?,?,?,?,?,?)");
    
        pstmt.setInt(1,1);
        pstmt.setString(2,"Interstellar");
        pstmt.setString(3,"Matthew McConaughey");
        pstmt.setString(4,"science fiction");
        pstmt.setString(5,"Christopher Nolan");
        pstmt.setInt(6,2014);
        pstmt.executeUpdate();
        
        pstmt.setInt(1,2);
        pstmt.setString(2,"Django Unchained");
        pstmt.setString(3,"Jamie Foxx");
        pstmt.setString(4,"Action");
        pstmt.setString(5,"Quentin Tarantino");
        pstmt.setInt(6,2012);
        pstmt.executeUpdate();
        
        pstmt.setInt(1,3);
        pstmt.setString(2,"The Terminal");
        pstmt.setString(3,"Tom Hanks");
        pstmt.setString(4,"Comedy");
        pstmt.setString(5,"Steven Spielberg");
        pstmt.setInt(6,2004);
        pstmt.executeUpdate();
        
        pstmt.setInt(1,4);
        pstmt.setString(2,"Seven");
        pstmt.setString(3,"Brad Pitt");
        pstmt.setString(4,"Thriller");
        pstmt.setString(5,"David Fincher");
        pstmt.setInt(6,1995);
        n=pstmt.executeUpdate();
        
        System.out.println(n +" record entered");
    

        //retrieving all the records from table
        
        pstmt=con.prepareStatement("select * from Movies");
        ResultSet rs=pstmt.executeQuery();
        while(rs.next()){
          System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6));
        }
        
        //retrieving data based on Actor's name
        
        pstmt=con.prepareStatement("select * from Movies where Actor=''");
        rs=pstmt.executeQuery();
        while(rs.next()){
          System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6));
        }
    
        //closing connection
        con.close();

            }
    }
    
    catch(Exception e){
      System.out.println(e);
      }

    }
}