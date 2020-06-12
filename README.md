# **Compiler Design Projects** 
## **This repo contains eight projects about various topics in compiler design:**
### **Project#1: DFA**
This project is written in Java, it takes an input string representing the DFA and another input string. The implemented methods runs the input string through the DFA and checks if it leads to an accept state or not.  
*Assumptions:*  
a) The alphabet Σ is always the binary alphabet {0, 1}.  
b) The set of states Q is always of the form {0, . . ., n}, for some n ∈ N.  
c) The start state is always state 0.  
Example of input DFA: 0,0,1;1,2,1;2,0,3;3,3,3#1,3  
Each state is followed by its 1 transitions and 0 transitions. The hashtag symbol is followed by the accept states.  
<p align="center">
  <img src="https://i.ibb.co/HPscSK0/Capture.jpg" width="300" >
</p>
Example input string: 10101110   
Output: True     
