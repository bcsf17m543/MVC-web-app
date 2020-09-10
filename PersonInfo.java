import java.sql.*;
class PersonInfo 
{
    private String name;
    private String add;
    private int ph;
    

    //constructors
    public PersonInfo()
    {
        name="";
        add="";
        ph=0;
    }
    public PersonInfo(String a,String b, String c)
    {
        int num= Integer.parseInt(c);  

        name=a;
        add=b;
        ph=num;
    }
    public PersonInfo(String a,String b,int c)
    {
        name=a;
        add=b;
        ph=c;
    }
    public PersonInfo(PersonInfo p)
    {
        name=p.name;
        add=p.add;
        ph=p.ph; 
    }
    //getters
    public String GetN()
    {
        return name;
    }
    public String GetA()
    {
        return add;
    }
    public int GetP()
    {
        return ph;
    }
    //Setters
    public void SetN(String a)
    {
        name=a;
    }
    public void SetA(String a)
    {
        add=a;
    }

    public void SetP(int a)
    {
        ph=a;
    }
    public String toString()
    {
        String result= "Name: "+name +"\nAddress: "+add+"\nPhone:  "+ph+"\n";
        return result;
    }
}
class PersonDAO
{
    public int AddNewContacts(PersonInfo a)
    {
        int abc=0;
        try{

            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://127.0.0.1/addressbook";
        
            Connection con=DriverManager.getConnection(url, "root", "root");
        
            Statement st=con.createStatement();
             
              String query = "INSERT INTO Person(name,address,phoneNum)VALUES('"+ a.GetN() + "','" + a.GetA()+ "','" + a.GetP()+"') ";
              int rs = st.executeUpdate( query );
              if(rs==1){	abc= 0; //insertion successful
            		}
            else{
               	abc= 1; //record already exists
        		}
                      
                   st.close();
                   con.close();
        return abc;
            }catch(Exception e){
        
              return 1;
            }
    }
    public PersonInfo SearchPerson(String a)
    {
       try{
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1/addressbook";
    
        Connection con=DriverManager.getConnection(url, "root", "root");
    
        Statement st=con.createStatement();
        String query="Select * from Person where name='"+a+"'";
        ResultSet rs = st.executeQuery( query );
        String b="";
        String c="";
        int d=0;
        if(rs.next()){
             b= rs.getString("name");
             c= rs.getString("address");
             d= rs.getInt("phoneNum");

         }
         PersonInfo obj=new PersonInfo(b, c, d);
        st.close();
        con.close();
        return obj;

       }
       catch(Exception e){

        //System.out.println(e);
        PersonInfo temp=new PersonInfo("exception","a",123);
        return temp;
      }
    } 
}
