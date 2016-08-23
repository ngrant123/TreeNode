
package treenode;

import java.io.*;
import java.util.Scanner;
/**
*
*The code uses the Node class to store all of the objects into
*a binary tree based on the text file. The user is able to access
*this
*
*@author Nathan Grant
*
*email:nathan.grant@stonybrook.edu
*Stony Brook Id:109816757
*/


public class Tree extends Node{
    
     //public Node []arr1= new Tree [9];
     public Node root;
     TreeNode ref;
     Tree new2;
     
   /** 
    *Default constructor that initializes the root
    */
       
    public Node getRoot(){
        
        return this.root;
    }
   /**
    *
    *Adds a node to the root and places is either to the left, right, or middle 
    *of it
    *
    *@param:
    *Contains the label, prompt, message, parentLabel that is used to define a
    *Node in this program
    *
    *Precondition:
    *none
    *
    *Postcondition:
    *The node has been added to the tree. If the user adds another node it would
    *either be place in the left, right, or middle depending on its vacancy
    */
    
    
      public boolean addNode(String label,String prompt,String message, String parentLabel){
          
          TreeNode new1=  new TreeNode(label, prompt,message,parentLabel);
         Node new2= new Node(new1);
         int j;
         
         if(this.root==null){
             
             root= new2;
            // System.out.println(new2.object.getP());
         }
         
         else{
             
             if(root.left==null){
                 root.setL(new2);
                 return true;
             }
             else if( root.left!= null && root.middle==null){
                 root.setM(new2);
                 return true;
             }
             else if(root.left!=null && root.middle!=null && root.right==null){
                 root.setR(new2);
                 return true;
             }
             
         }
             return false;
          
          
      }
      
      /**
       *Gets a string and turns the string into an array
       *
       *@param:
       *Contains a string that is going to be turned into an array
       *
       *Precondition:
       *none
       *
       *Postcondition:
       *The array that is returned it simply the String that was passed.
       *I use it later in the program when the program is reading the text file. 
       *For example, I use it to determine where I should place the next node. I the 
       *location was 1-1, then the program would get the next node, go to the left, 
       *and place it on the left. 
       */
    public int []getL(String location){
         
         int length= location.length();
         //int []num1= new int[length];
         int j=0;
         String word="";
         int m=0;
         
         for(int i=0;i<length;i++){
             
             if(location.charAt(i)!='-'){
                 word+= location.charAt(i);
                 
                 
             }
         }
         int []num3= new int[word.length()];
         int []num5= new int[word.length()];
         
         int num2= Integer.parseInt(word);
         
         while(num2>0){
             
             int num4=num2%10;
             num3[j]=num4;
             
             num2=num2/10;
             j++;
         }
         
         for(int k=num3.length-1;k>=0;k--){
             
             num5[m]=num3[k];
             m++;
         }
         return num5;
         
         
     }
    /**
     *Adds a node in the location that is contained in the array. The array contains 
     *the nodes location, for example 1-1-1, and places the node in its location. If
     *the integer is a 1 the program would go to the left. If the integer is a 2
     *the program would go to the middle. If it is a three it would go to the right. 
     *Eventually it would set the node
     *
     *@param: 
     *The array has to contain only integers 
     *
     *Postcondition:
     *At the end the node is placed at its corresponding position. 
     */
     public boolean addAtN(int []array,TreeNode new1){
         
         int size=array.length;
          Node new2= new Node (new1);
           
         Node cursor=root;
         int j=0;
        // int i=array[j];
         
         while(cursor!=null && j<size){
             int i=array[j];
             
             if(i==1){
                 if(j==size-1){
                 cursor.setL(new2);
                 }
                 else
                    cursor=cursor.getLeft();
             }
             else if(i==2){
                 if(j==size-1){
                 cursor.setM(new2);
                 }
                 else
                    cursor=cursor.getMiddle();
             }
             else if(i==3){
                 if(j==size-1){
                 cursor.setR(new2);
                 }
                 else
                     cursor=cursor.getRight();   
             }
             j++;
           
         }
         return true;
     }
    /**
     *This method prints out the tree in preOrder. It uses a helper method 
     *that is explained in more detailed below
     */
      public void preOrder(){
        Node cursor=root;
        preOrder(cursor);
         
      
    }
     /**
      *This method prints the tree in preorder.It visits the left subtree, then when
      *its done printing everything there it goes to the right subtree and prints everything
      *there. Finally it prints the right subtree. It accepts a node from the preOrder() 
      *because I used recursion for this preOrder method. 
      *
      *@param capacity:
      *A node that is equal to the root
      *
      *Precondition:
      *none;
      *
      *Postcondition:
      *The tree that is printed is the preorder version of the tree, which means that 
      *the left, middle, and right subtree are printed in that order.
      */
      public void preOrder(Node cursor){
     
         int i=0;
//          System.out.println(cursor.object.getP());
         if(cursor==null){
             return;
         }
         else if(cursor.getLeft()==null){
             System.out.println(cursor.object.getL());
             System.out.println(cursor.object.getP());
             System.out.println(cursor.object.getM());
             return;
             //preOrder(cursor.arr1[i++]);   
         }
         else{
                 if(cursor!=null){
                  
                    preOrder(cursor.getLeft());
                    preOrder(cursor.getMiddle());
                    preOrder(cursor.getRight());
                    
                    System.out.println(cursor.object.getL());
                    System.out.println(cursor.object.getP());
                    System.out.println(cursor.object.getM());
                    return;
                    
                }
                 
           }
      }
      
     /**
      *This method returns the reference of the node that matches label with
      *the String that is provided
      *
      *@param capacity:
      *none
      *
      *Precondition:
      *none
      *
      *Postcondition:
      *Using a method that traverses through the binary, if the cursor's label matches
      *with the label that is provided then you set the value ref to equal to that 
      *in the setNodeRef() method. Then in the getNodeReference method, the program 
      *accessses the value ref and returns it  
      */
     public TreeNode getNodeReference(String label){
         
         Node cursor=root;
         TreeNode cursor2=null;
         boolean choice=true;
         preOrderT(cursor,label,cursor2);
         
         TreeNode num6=this.ref;
         if(ref!=null){
         return num6;
         }
         else 
             return null;
         
     }
     /**
      *Sets the value of node to ref
      */
     public void setNodeRef(TreeNode node){
         
         this.ref=node;
     }
     
     /**
      *This preOrderT is identical to the preOrder method above but instead it
      *takes in the string choice and if the choice equals the cursors label then 
      *you set ref to that node
      *
      *@param:none
      *
      *Precondition:none
      *Postcondition:
      *If the cursor's label matches the string choice then ref is set to the node
      *If its not, ref stays null.
      */
          
      public void preOrderT(Node cursor,String choice,TreeNode cursor2){
         
         int i=0;
//          System.out.println(cursor.object.getP());
         if(cursor==null){
             return;
         }
         else if(cursor.getL().compareTo(choice)==0){
             cursor2=cursor.object;
            // System.out.println(cursor);
             
             setNodeRef(cursor2);
             return;
             //preOrder(cursor.arr1[i++]);   
             
         }
         else{
                 if(cursor!=null){
                  
                    preOrderT(cursor.getLeft(),choice,cursor2);
                    preOrderT(cursor.getMiddle(),choice,cursor2);
                    preOrderT(cursor.getRight(),choice,cursor2);
                    if(cursor.getL().compareTo(choice)==0){
                    cursor2=cursor.object;
                    
                    return;
                    }
                }
                 
           }
        }
      
      /**
       *This begin begins the program where is asks the user the question and gives 
       *an answer. First it starts off by asking the user a question, and depending
       *on the answer the program either traverses left, right, or middle in the tree. 
       *If the cursor's left, middle, and right end null, the program ends and it prompts
       *out a statement. 
       *
       *@param:none 
       *
       *Precondition:
       *none
       *
       *Postcondition:
       *The program traverses through the tree and asks and recieves answers. The program
       *ends when the program reaches a leaf
       */
      public void beginSession(TreeNode new3){
       //   new2=this.ref2;
          Tree cursor=new2;
          Node node= root;
          Node node2= root;
          Node node3= root;
          Node node4= root;
          Scanner input= new Scanner(System.in);
          boolean choice2=true;
          
          System.out.println("Help session starting....");
          System.out.println( cursor.root.object.getP());
          System.out.println("1: "+cursor.root.getLeft().object.getP());
          node2=cursor.root.getLeft();
          
          System.out.println("2: "+cursor.root.getMiddle().object.getP());
          node3=cursor.root.getMiddle();
          
          System.out.println("3: "+cursor.root.getRight().object.getP());
          node4=cursor.root.getRight();
          
         String choice= input.next();
          node=cursor;
          node=cursor.root;

          while(choice2==true){
            
             if(choice.compareTo("1")==0){
                 node=node.getLeft();
                 
                 if(node.getLeft()==null && node.getMiddle()==null && node.getRight()==null) {
                     System.out.println(node.object.getM());
                choice2=false;
                break;
            } 
                 
               else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()!=null){  
                 // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                  System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                else if(node.getLeft()!=null && node.getMiddle()==null && node.getRight()!=null){
                    // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
             
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()==null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  
                  choice= input.next();
                  choice2=true;
                    
                }
                 else if(node.getLeft()==null && node.getMiddle()!=null && node.getRight()!=null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                 
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                    System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                    
                }
              }
              else if(choice.compareTo("2")==0){
                 node=node.getMiddle();
                 
                 if(node.getLeft()==null && node.getMiddle()==null && node.getRight()==null) {
                     System.out.println(node.object.getM());
                choice2=false;
                break;
            } 
                  else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()!=null){  
                 // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                  System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                 else if(node.getLeft()!=null && node.getMiddle()==null && node.getRight()!=null){
                    // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
             
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()==null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  
                  choice= input.next();
                  choice2=true;
                    
                }
                 else if(node.getLeft()==null && node.getMiddle()!=null && node.getRight()!=null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                 
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                    System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                    
                 
                 }  
              }
              else if(choice.compareTo("3")==0){
                  
                    node=node.getRight();
                  
                    if(node.getLeft()==null && node.getMiddle()==null && node.getRight()==null) {
                        System.out.println(node.object.getM());
                    choice2=false;
               
                break;
            } 
                     else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()!=null){  
                 // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                  System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                  else if(node.getLeft()!=null && node.getMiddle()==null && node.getRight()!=null){
                    // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
             
                  System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                }
                else if(node.getLeft()!=null && node.getMiddle()!=null && node.getRight()==null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                  System.out.println("1: "+node.getLeft().object.getP());
                  node2= node.getLeft();
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                  
                  choice= input.next();
                  choice2=true;
                    
                }
                 else if(node.getLeft()==null && node.getMiddle()!=null && node.getRight()!=null){
                       // cursor=cursor.root.getLeft();
//                  cursor=(Tree) cursor.root.getLeft();
                  System.out.println( " "+node2.object.getM());
                 
                  
                    System.out.println("2: "+node.getMiddle().object.getP());
                  node3=node.getMiddle();
                  
                    System.out.println("3: "+node.getRight().object.getP());
                  node4=node.getRight();
                  
                  choice= input.next();
                  choice2=true;
                    
                 }
              }  
          }
       }
      
      /**
       *This method accepts the filename from the user and constructs a tree from that.
       *It first fills up the root and places node in accordance to its label. For example
       *if the label was 1-1, the program would traverse left and place the node to the 
       *left of the object. If the program comes across 1 3 it will ignore it and contain
       *to the next line
       *
       *@param capacity:
       *Contains the filename that the user specifies
       *
       *Precondition:
       *The filename has to match the filename that the user has on his/her computer
       *
       *Postcondition: 
       *If the file exists,the program would place it in a binary tree depending on
       *its location in the text file.
       */
      
      public void LoadT(String fileName2)throws FileNotFoundException, IOException{
           try{
         //String fileName= "sample.txt";
        
        FileReader file= new FileReader(fileName2);
        
        BufferedReader file2= new BufferedReader(file);
        String line=null;
        String line3=null;
        String line4=null;
       int i=0;
        
         Tree new1= new Tree();
         new2= new Tree();
         
          while( i<4) { 
             
            line = file2.readLine();
            line=line.trim();
            if(line.compareTo("root 3")==0){
                  
                  continue;
              }
          //  line=line.trim();
           // line2= file2.readLine();
            line3=file2.readLine();
            line3=line3.trim();
            line4=file2.readLine();
            line4=line4.trim();
           
           new1.addNode(line,line3,line4,line);
           new2.addNode(line,line3,line4,line);
            i++;
         } 
          
        while(line!=null){
            
            line=file2.readLine();
            if(line!=null){
             line=line.trim();
            if(contains2(line)==false){
                continue;
            }
            else{
               
           // line=line.trim();
            
            int []number= new1.getL(line);
            int []number2= new2.getL(line);
           // line2= file2.readLine();
            
            line3=file2.readLine();
            line3=line3.trim();
            
            line4=file2.readLine();
            line4=line4.trim();
             TreeNode new4= new TreeNode(line,line3,line4,line);
            new1.addAtN(number,new4);
            new2.addAtN(number2,new4);
            
            
              }
            } 
            else
                break;
        }
                }
        catch(IllegalArgumentException ex){
            System.out.println("File Does not exist");
            }
        }
      
      /**
       *This method determines if the String that is passed contains a white space
       *or not. It returns false if it does and true if it doesn't
       */
       public static boolean contains2(String name){
        
        int size=name.length();
        boolean choice= true;
           
        for(int i=0;i<size;i++){
            //char j=name.charAt(i);
            if(name.charAt(i)==' '){
                
                choice=false;
                break;
            }
            else
                choice=true;
            
        }
        
        if(choice==true)
            return true;
        else
            return false;
        
        }

      }
      
    
     