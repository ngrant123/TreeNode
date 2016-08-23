# TreeNode
Code for the simulation of a customer help service 

TreeNode simulation 

The purpose of this program is to be used as a versatile decision-making system that is based on user input.
An example of the usage of this code is online Technical Support for a product or group of products. A series 
of questions might be asked and based on the answers, a different branch of questions will be asked as follow-up-questions 
to determine exactly how to help the user. Another example is a telephone Technical Support, like a 1-800 number.
When calling a 1-800 number, you might communicate with a machine. A series of questions are asked and as answers
you typically press the numbers on the keypad, 1-9. After determining exactly what the problem is, a simple answer
is usually possible. 

In this assignment I used a Ternary(3-ary) tree to represent the flow of data that I get from the user.  In each 
node in the Ternary tree there will be a question to ask. The "answers" will be branches towards more questions in
the tree. This code can be used for a number of different situations. The user can change the sample text and add
different questions and answer in it to satisfy their needs. The only thing that needs to be followed in this code
is the way that the sample text file is formatted. The reason behind this is because it tells the program where to
put the necessary nodes into the tree. 

The TreeNode class stores the necessary data in each node. For example you can set a label, message, and prompt in 
each node. 

The Node class is used to set the TreeNode object to either the left, right, or center of a Node. There is a setLeft method,
a setRight method,  and a setMiddle method. These methods allow the program to place the necessasry information in its
appropriate location.

The Tree class adds the necessary nodes into its respective locations. First it takes the first information and places it in
the root. If thats filled up, it sets the information in either the left, middle, or the right of the root. After all those
positions are filled up, the program places the nodes in certain positions based on information on from the sample text
file. For example in the file there is a line that says 1-2-3. The program interprets that as getLeft, getRight, and if 
the middle is null then set the middle to the node. 1's mean getLeft, 2's mean getRight, and 3's mean getMiddle. Additionally 
there is method that loads the file, prints the tree in preOrder, and starts the help session. 

The TreeDriver class contain the main method and displays the menu that either loads the file, starts the help session, 
traverses the tree in preOrder, and quits the program. 
