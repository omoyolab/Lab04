/**
 * Lab 4 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/10/2019)
 */
public class Stack_Omoyola
{
    private Account_Omoyola [] data;
    private int top;
    private int size;

    /**
     *  No Argument Constructor for objects of class Stack_Omoyola
     */
    public Stack_Omoyola()
    {
        this.top = -1;
        this.size = 100;
        this.data = new Account_Omoyola [100];
    }

    /**
     * Parameterized Constructor for objects of class Stack_Omoyola
     *
     */
    public Stack_Omoyola(int n)
    {
        this.top = -1;
        this.size = n;
        this.data = new Account_Omoyola[n];
    }
    
     /**
     * Push Method for objects of class Stack_Omoyola
     *
     */
     public boolean push (Account_Omoyola newAccount)
    {
        if (top == size -1){
            System.out.println("Account Insert Faliure");
            return false; // Overflow Error;
        }else{
                top = top +1;
                data[top] = newAccount.deepCopy();
                System.out.println("Account Insert Sucess");
                return true; //Push Operation sucessful
                
            }
    }
    
     /**
     * Pop Method for objects of class Stack_Omoyola
     *
     */
    public Account_Omoyola pop()
    {
        int topLocation;
        if(top == -1){
            System.out.println("Delete failed");
            return null; // Underflow error
        }
        
            else{
                topLocation = top;
                top = top -1;
                System.out.println("Delete Sucess");
                return data[topLocation];
            }
    }
    
     /**
     * Peek method for objects of class Stack_Omoyola
     */
    public Account_Omoyola peek()
    {   
        if (top != -1)
        {
            return data[top].deepCopy();
        }
        return null;
    }
    
    /**
     * Show All Method for objects of class Stack_Omoyola
     *
     */
    public void showAll()
    {
        for(int i = top; i >=0; i--)
            System.out.println(data[i].toString());
    }
}
