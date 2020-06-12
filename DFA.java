import java.util.ArrayList;
import java.util.Arrays;

public class DFA {
	public static  ArrayList <Character> one ;
	public static ArrayList <Character> zero;
	public static ArrayList <Character> accept;
	public DFA(String dfa) {
		// Save accept states into a separate array
		int i = 0;
		while (dfa.charAt(i) != '#' && i < dfa.length() - 1) {
			i++;
		}
		if (i != dfa.length()) {
			String AcceptStates = dfa.substring(i + 1);
			ArrayList<String> AcceptStates2 = new ArrayList<>(
					Arrays.asList(AcceptStates.split(",")));

			accept = new ArrayList<Character>();
			for (int y =0 ; y < AcceptStates2.size(); y++){
				accept.add(AcceptStates2.get(y).charAt(0));
			}

			System.out.println("Accept states" );
			System.out.println(accept);		
		}
		
		// Save DFA states in an array
		String rest = dfa.substring(0, i);
		ArrayList<String> rest2 = new ArrayList<>(Arrays.asList(rest
				.split(";")));
		// Save states 
		ArrayList <Character> states = new ArrayList<Character> ();
				
		for(int x=0 ; x < rest2.size(); x++){
			states.add(rest2.get(x).charAt(0));
		}
		System.out.println("States" + states);
	
		// Save zero transitions
        zero = new ArrayList<Character> ();
		
		for(int x=0 ; x < rest2.size(); x++){
			zero.add(rest2.get(x).charAt(2));
		}
        System.out.println("zero transitions " + zero);
		
		// Save one transitions 
		one = new ArrayList<Character> ();
		
		for(int x=0 ; x < rest2.size(); x++){
			one.add(rest2.get(x).charAt(4));
		}
		System.out.println("one transitions " + one.toString());
		
	
	}
   
	public static void  run(String test){
		char currentState = '0';
		for (int i = 0 ; i < test.length() ; i++){
			if(test.charAt(i) == '0'){
			  char 	tmp = zero.get(Character.getNumericValue(currentState));
			  currentState = tmp;
			}
			else if (test.charAt(i) == '1'){

				  char 	tmp = one.get(Character.getNumericValue(currentState));
				  currentState = tmp;
				  }
		
		}
		boolean contains = false;
		for (char c : accept) {
		    if (c == currentState) {
		        contains = true;
		        break;
		    }
		}
		System.out.println(contains);
   
	}
	public static void main(String[] args) {
		DFA aa = new DFA("0,0,1;1,2,1;2,0,3;3,3,3#1,3");
	    run("10101110");
	
	}
}
