        /**
         * Lab 4 COSC 2436-81501  FA2019
         * @author Abimbola Omoyola
         * @version (10/22/2019)
         */
        public class GenericStack_Omoyola<T>
        {
            private T[] data;
            private int top;
            private int size;
         
            /**
     *  No Argument Constructor for objects of class GenericStack_Omoyola
     */
        public GenericStack_Omoyola()
            {
                this.top = -1;
                this.size = 100;
                this.data = (T[]) new Object[100];
            }
            
         /**
     * Parameterized Constructor for objects of class GenericStack_Omoyola
     *
     */   
        public GenericStack_Omoyola(int n)
            {
                this.top = -1;
                size = n;
                data = (T[]) new Object[n];
            }
            
         /**
         * Peek Method for objects of class GenericStack_Omoyola
         *
         */       
        public T peek()
           {   
            if (top != -1)
            {
                return data[top];
            }
            return null;
           }
           
      /**
     * Push Method for objects of class GenericStack_Omoyola
     *
     */      
        public boolean push (T newNode)
        {   
                if(top == size -1)
                        return false;// Overflow Error
                       else{ top = top +1;
                           data[top] = newNode;
                           return true; // Push Operation Sucessful
              }   
         }
             
     /**
     * Pop Method for objects of class GenericStack_Omoyola
     *
     */

        public T pop()
        {
            int topLocation;
            if(top == -1)
                return null; // Underflow Error;
                else{ topLocation = top;
                      top = top -1;
                      return data[topLocation];
                }
        }
        
     /**
     * ShowAll Method for objects of class GenericStack_Omoyola
     *
     */
        public void showAll()
        {
            for(int i = top; i >=0; i--)
            System.out.println(data[i].toString());
        }
}
