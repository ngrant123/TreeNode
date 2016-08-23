
package treenode;


/**
 *This code contains information about a particular TreeNode 
 *object that contains the message,prompt,label and the parent label
 *
 *@author Nathan Grant
 *
 *email:nathan.grant@stonybrook.edu
 *Stony Brook Id:109816757
 *
 */

public class TreeNode{
    
    public TreeNode left;
    public TreeNode right;
    public TreeNode middle;
    
    public TreeNode []arr1= new TreeNode [9];
    private String label;
    private String message;
    private String prompt;
    private String parentLabel;
   
    /**
     *Default constructor for TreeNode
     */
    
    public TreeNode(){
        
    }
    
    /**
     *Default constructor that initializes the Strings prompt, message,label
     *and the parentLabel
     */
    public TreeNode(String label, String prompt, String message, String parentLabel){
        
        this.label=label;
        this.prompt=prompt;
        this.message=message;
        this.parentLabel=parentLabel;
        
    }
    /**
     *
     *Default constructor that initializes the prompt but sets label,message, and
     *parentLabel as null
     *
     */
     
    public TreeNode(String prompt){
        
        this.label=null;
        this.prompt=prompt;
        this.message=null;
        this.parentLabel=null;
        
    }
    
    /**
     *Sets the label of the object
     *
     *@param:
     *The name of the label that the user wants to set it to
     */
    public void setlabel( String label){
        
        this.label=label;
    }
    /**
     *Sets the message of the object
     *
     *@param:
     *The message that the user wants to set to
     */
    
    public void setM(String message){
        this.message=message;
        
    }
    /**
     *Sets the prompt for the object
     *
     *@param:
     *The prompt that the user wants to set it to
     */
    public void setPrompt(String prompt){
        
        this.prompt=prompt;
    }
    
    /**
     *Gets the label for this object
     */
    public String getL(){
        return this.label;
    }
    
   /**
    *Gets the message for this object
    */
    public String getM(){
        return this.message;
        
    }
   /**
    *Gets the prompt for this object
    */
    public String getP(){
        
        return this.prompt;
    }
}