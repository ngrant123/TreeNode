
package treenode;

import java.io.*;
import java.util.Scanner;

public class TreeDriver extends Tree{
    
    
    
    
    public static void main(String args[]) throws FileNotFoundException, IOException{
        
        Scanner input= new Scanner(System.in);
        Tree new1= new Tree();
        boolean choice2=false;
        
       boolean filechoice=false;
       while(choice2!=true) {
            
        System.out.println("L - Load a Tree");
        System.out.println("H- Begin a Help Session");
        System.out.println("T-Traverse the Tree in preorder");
        System.out.println("Q-Quit");
        
        String choice= input.next();
            
        switch(choice){
          
            case "L":
                
                System.out.println("Enter the fileName");
                
               String choice3= input.next();
                     
                new1.LoadT(choice3);
                filechoice=true;
                choice2=false;
                break;
                
            case "H":
               
                 if(filechoice==true)  {
                new1.beginSession(new1);
                choice2=true;
                 }
               else
                   System.out.println("Please enter a file");   
                break;
                        
            
            case "T":
                new1.preOrder();
                choice2=false;
                break;
                
            case "Q":
                break;
                
            default:
                System.out.println("This is not one of the letters");
                choice2=false;
                    break;
            }
       }
    }
}
