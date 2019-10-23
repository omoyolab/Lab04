/**
 * Lab 4 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/10/2019)
 */
public class Queue_Omoyola
{
    private Account_Omoyola [] data;
    private int size;
    private int numOfAccounts;
    private int front;
    private int rear;

    /**
     * No argument Constructor for objects of class Queue_Omoyola
     */
    public Queue_Omoyola()
    {
        this.size = 100;
        this.numOfAccounts = 0;
        this.front = 0;
        this.rear = 0;
        data = new Account_Omoyola[100];
    }

    /**
     * Parameterized Constructor for objects of class Queue_Omoyola
     */
    public Queue_Omoyola(int n)
    {
        this.size = n;
        this.numOfAccounts = 0;
        this.front = 0;
        this.rear = 0;
        data = new Account_Omoyola[n];
    }
    
    /**
     * Enque method for objects of class Queue_Omoyola
     */
    public boolean enque(Account_Omoyola newAccount)
    {
        if(numOfAccounts == size){
            System.out.println("Account Insert Failed");
            return false; //Overflow Error
        }
            else{
                numOfAccounts = numOfAccounts +1;
                data[rear] = newAccount.deepCopy();
                rear = (rear + 1) % size;
                System.out.println("Account Insert Sucess");
                return true; // Push Operation sucessfull
            }
    }
    
    /**
     * Deque method for objects of class Queue_Omoyola
     */
    public Account_Omoyola deque()
    {
        int frontLocation;
        if(numOfAccounts == 0){
            System.out.println("Delete Failed");
            return null; // Underflow Error
        }
            else{
                frontLocation = front;
                front = (front + 1)% size;
                numOfAccounts = numOfAccounts - 1;
                System.out.println("Delete Sucess");
                return data[frontLocation];
            }
    }
    
    /**
     * Peek method for objects of class Queue_Omoyola
     */
    public Account_Omoyola peek()
    {   
        if (numOfAccounts != 0)
        {
            return data[front].deepCopy();
        }
        return null;
    }
        
    
    /**
     * ShowAll method for objects of class Queue_Omoyola
     */
    public void showAll()
    {
        int i = front;
        for(int c = 1; c<= numOfAccounts; c++)
        {
            System.out.println(data[i].toString());
            i = (i +1) % size;
        }
    }
    
}
