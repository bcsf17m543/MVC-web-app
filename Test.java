class Test
{
    //all function testing prior to merging into servlets
    public static void main(String[] args)
    {
        PersonDAO temp = new PersonDAO();
        temp.SearchPerson("khalid");
        int num=30078601;
        PersonInfo t2=new PersonInfo("bala","karachi",num);
        int num2=temp.AddNewContacts(t2);
        System.out.println(num2);
    }
   
    
}