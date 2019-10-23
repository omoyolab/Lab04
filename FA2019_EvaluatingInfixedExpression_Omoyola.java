import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Lab 4 COSC 2436-81501  FA2019
 * @author Abimbola Omoyola
 * @version (10/22/2019)
 */
public class FA2019_EvaluatingInfixedExpression_Omoyola
{
    public static void main (String [] args)
    {
        
            int userInput;// Variables and Objects
        GenericStack_Omoyola<Integer> stackForOperands = new GenericStack_Omoyola<Integer>();  
        GenericStack_Omoyola<Character> stackForOperators = new GenericStack_Omoyola<Character>();
        StringTokenizer tokens;
        Scanner keyboard = null;
       
        do{
         System.out.println(
                    " MENU TO SELECT WHERE TO READ INPUT \n"+
                    " 1. Read one Expression from the keyboard \n" +
                    " 2. Read expressions from an input file \n"+
                    " 0. Exit \n"  
                    );
         keyboard = new Scanner(System.in);
              userInput = keyboard.nextInt();
              keyboard.nextLine();
               
          switch(userInput){
            case 1:
            System.out.println("Enter a Mathematical expression");
            String exp = keyboard.nextLine();
            tokens = new StringTokenizer(exp, " -+()/*", true);
     
            while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();
                // Store ( in Operator variable as a character
                if(token.equals("(")) {
                stackForOperators.push(token.charAt(0));
                }else if(token.equals(")")) {
               
                // run a loop to process operands inside paranthesis 
                while(stackForOperators.peek() != '(') {
                stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
               
                }
                // pop off (
                stackForOperators.pop();
                // check for precedence and process operands
                }else if(token.equals("+") ||token.equals("*")|| token.equals("-")||token.equals("/") ) {
                while (stackForOperators.peek() != null && hasPrecedence(token.charAt(0),stackForOperators.peek())) {
                stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
               
                }
                //push in the next operator if stack is empty
                stackForOperators.push(token.charAt(0));
                // ignore space
                }else if(token.equals(" "))
                    continue;
                else {
                // push the next token that is not an operator into operand stack.
                stackForOperands.push(Integer.parseInt(token));
                }
               
            }
              // Process final calculations when there is no more token to read
              while(stackForOperators.peek() != null) {
                stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
                 }
              // display final result
               System.out.println("The Solution is:" +stackForOperands.pop());
               System.out.println();
            break;
           case 2:
            try {
            Scanner scanner = new Scanner(new File("expression.txt")); 
            
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
   
                tokens = new StringTokenizer(line," -+()/*", true);
                while(tokens.hasMoreTokens()) {
                String token = tokens.nextToken();
                
                 // Store ( in Operator variable as a character   
                    if(token.equals("(")) {
                stackForOperators.push(token.charAt(0));
                }else if(token.equals(")")) {
               // run a loop to process operands inside paranthesis
                while(stackForOperators.peek() != '(') {
                stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
               
                }
                // pop off (
                stackForOperators.pop();
                // check for precedence and process operands
                }else if(token.equals("+") ||token.equals("*")|| token.equals("-")||token.equals("/") ) {
                while (stackForOperators.peek() != null && hasPrecedence(token.charAt(0),stackForOperators.peek())) {
                stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
               
                }
                //push in the next operator if stack is empty
                stackForOperators.push(token.charAt(0));
                // ignore space
                } else if(token.equals(" "))
                    continue;
                else {
                // push the next token that is not an operator into operand stack.
                int num = Integer.parseInt(token);
                stackForOperands.push(num);
                }
                    
                      
                }
                 
                  // Process final calculations when there is no more token to read
                  while(stackForOperators.peek() != null) {
                   stackForOperands.push(processOfOneOperator(stackForOperators.pop(), stackForOperands.pop(),stackForOperands.pop()));
                  }
           
                 // display final result
                 System.out.println("The Solution is : " + stackForOperands.pop());
                 System.out.println();
               
              
            }
            } catch (FileNotFoundException e) {
                   System.out.println("File not found");
                }

              break;
            }
       
           
       
        }while(userInput != 0);
        keyboard.close();
        System.out.println("Thank you. The application is terminating.......");
       
       
    }
   
     public static int processOfOneOperator(Character character, int x, int y ){
         
         switch(character)
         {
             case '+':
             return x + y;
             
             case '-':
              return y - x;
             
             case '*':
             return x * y;
             
             case '/':
             if (x == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
             return y / x;
             
         }
         return 0;
             
           
       }
       
        public static boolean hasPrecedence(char operator1, char operator2)
    {
         if (operator2 == '(' || operator2 == ')')
            return false;
            
         if ((operator1 =='*' || operator1 =='/') && (operator2 == '+' || operator2 == '-'))
            return false;
           
         else
            return true;
    }
       
       
    }