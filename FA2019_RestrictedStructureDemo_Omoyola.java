import java.util.Scanner;
/**
 * Lab 4 COSC 2436-81501  FA2019
 *
 * @author Abimbola Omoyola
 * @version (10/10/2019)
 */
public class FA2019_RestrictedStructureDemo_Omoyola
{
    public static void main(String [] args)
    {
        
    Stack_Omoyola stackOperation = new Stack_Omoyola();
    Queue_Omoyola queueOperation = new Queue_Omoyola();
    Account_Omoyola account;
    String accountNumber, accountName;
    double balance;
    int userInput;
      
    
    Scanner keyboard = new Scanner(System.in);
    do {
    System.out.println(
                    " MAIN MENU \n"+
                    " 1. Stack Structure\n" + 
                    " 2. Queue Structure \n"+
                    " 0. Exit \n"   
                    );
    userInput = keyboard.nextInt();
    keyboard.nextLine();
    
    switch(userInput){
    
    case 1:
         // Insert 3 accounts with a loop
        for(int i = 0; i < 3; i++) {
            
            System.out.println("Enter your Name ");
            accountName = keyboard.nextLine();
            
            System.out.println("Enter Your Account Number");
            accountNumber = keyboard.nextLine();
            
            System.out.println("Enter a Starting balance ");
            balance = keyboard.nextDouble();
            keyboard.nextLine();
            
            account = new CheckingAccount_Omoyola(accountName,accountNumber, balance);
            stackOperation.push(account);
                         }
                         System.out.println();
          // Show all Inserted accounts
        System.out.println("*************** Inserted Accounts *****************");
                         stackOperation.showAll();
          // Remove one account
                         stackOperation.pop();
         System.out.println("*************** Show all accounts after top node is removed*****************");
         // Show remaining account
                         stackOperation.showAll();
         System.out.println("*************** Top of Stack*****************");
         //display the account at the top of the stack
                         System.out.println(stackOperation.peek());  
    break;
    case 2:
      // Insert 3 accounts with a loop
        for(int i = 0; i < 3; i++) {
            
            System.out.println("Enter your Name ");
            accountName = keyboard.nextLine();
            
            System.out.println("Enter Your Account Number");
            accountNumber = keyboard.nextLine();
            
            System.out.println("Enter a Starting balance ");
            balance = keyboard.nextDouble();
            keyboard.nextLine();
            
            account = new SavingAccount_Omoyola(accountName,accountNumber, balance);
            queueOperation.enque(account);
                         }
                       System.out.println();
            // show all inserted accounts
        System.out.println("*************** Inserted Accounts *****************");
                         queueOperation.showAll();
            // remove one account
                         queueOperation.deque();
         System.out.println("*************** Show all accounts after top node is removed*****************");
         // re display remaining accounts
                         queueOperation.showAll();
         System.out.println("*************** Front of Queue*****************");
         // Show account at the front of the queue
                         System.out.println(queueOperation.peek());  
    break;
    
    }
    }while(userInput !=0);
     keyboard.close();
     System.out.println("Thank you. The application is terminating.......");
    }
}
