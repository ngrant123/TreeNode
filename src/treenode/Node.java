
package treenode;

/**
 *This code contains information about a particular Node that 
 *would contain the TreeNode object
 *the node left,right,and middle are available
 *
 *@author Nathan Grant
 *
 *email:nathan.grant@stonybrook.edu
 *Stony Brook Id:109816757
 */



public class Node extends TreeNode{
    
    public TreeNode object;
    public Node []arr1= new Node [9];
    
    public Node left;
    public Node right;
    public Node middle;
    
    /**
     *Default constructor for Node
     */
    
    public Node(){
       
    }
    /**
     *Constructor that initializes the TreeNode object for this program
     *
     *@param:
     *The TreeNode that the user wants to set
     */
         
    public Node(TreeNode new1){
        
        this.object=new1;
       
    }  
    /**
     *Method that allows the user to set the left node of the object
     *
     *@param:
     *The Node that the user wants to the left
     */
    public void setL(Node node){
        this.left=node;
    }
    /**
     *
     *Method that allows the user to set the right node of the object
     *
     *@param:
     *The Node that the user wants to set to the right
     */
    
    public void setR(Node node){
        this.right=node;
    }
    /**
     *Method that allows the user to set the middle node of the object
     *
     *@param:
     *The node that the user wants to set to the middle
     */
    public void setM(Node node){
        
        this.middle=node;
    }
    /**
     *Returns the node to the left of the object
     */   
    
    public Node getLeft(){
        return this.left;
    }
    /**
     *Returns the node to the right of the object
     */   
    
    public Node getRight(){
        
        return this.right;
    }
    
    /**
     *Returns the node to the middle of the object
     */   
    
    public Node getMiddle(){
        return this.middle;
    }
   

    /**
     *Method that allows the user to set the TreeNode object
     */
        
    public void setInfo(TreeNode info){
        this.object=info;
    } 
}