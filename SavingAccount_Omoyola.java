/**
 * Lab 4 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/03/2019)
 */
import java.text.DecimalFormat;
public class SavingAccount_Omoyola extends Account_Omoyola{
	
	
	private double interestRate;
	private double minimumAmount ;
	final String ACCOUNT_TYPE = "Savings Account";
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	// No argument constructor 
    public SavingAccount_Omoyola()
	{
		super();
		interestRate = 0.05;
		minimumAmount = 100.0;
	}
	
	// Parameterized constructor 
    public SavingAccount_Omoyola(String name,String number,  double bal)
	{
		super(name,number,bal);
		interestRate = 0.05;
		minimumAmount = 100;
	}
	
	 public Account_Omoyola deepCopy()
    {
                Account_Omoyola clone = new SavingAccount_Omoyola (account_name,account_number, balance);
                return clone;
    }
    
     

	public String toString() {
		return  ( "Account  Number: " +account_number + "\n" +
				 "Name: " +account_name + "\n" +
			     "End Balance: " +balance+ "\n" +
			     "Type: " +ACCOUNT_TYPE+ "\n"+
			     "Interest Rate: " +interestRate+ "\n"+
			     "Minimum Amount: " +minimumAmount+ "\n");
	}
	

}