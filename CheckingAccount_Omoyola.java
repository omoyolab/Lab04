/**
 * Lab 4 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/03/2019)
 */

public class CheckingAccount_Omoyola extends Account_Omoyola{
    
    private double serviceFee;
    private double minimumAmount ;
    final String ACCOUNT_TYPE = "Checking Account";
    
    
    // no argument constructor 
    public CheckingAccount_Omoyola()
    {
        super();
        serviceFee = 10;
        minimumAmount = 20.0;
    }
    
    // parameterized constructor 
    public CheckingAccount_Omoyola(String name,String number, double bal)
    {
        super(name,number,bal);
        serviceFee = 10;
        minimumAmount = 20.0;
    }
    
    // To String method
    public String toString() {
        return  ( "Account  Number: " +account_number + "\n" +
                 "Name: " +account_name + "\n" +
                 "End Balance: " +balance+ "\n" +
                 "Type: " +ACCOUNT_TYPE+ "\n");
    }
    

	   
   public Account_Omoyola deepCopy()
    {
               Account_Omoyola clone = new CheckingAccount_Omoyola (account_name,account_number, balance);
               return clone;
    }
   
   
   
        
    
}