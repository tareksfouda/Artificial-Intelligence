import java.util.*;

public class HillClimbing {
	public static int N=8;
	public Queen[] startState;
	public State start; //start state
	public int StatesGenerated;
	

	public HillClimbing(){
		start = new State(); //empty start State
		startState = new Queen[N]; //empty start state
		startState();
		StatesGenerated=0;
	}
	

	public HillClimbing(Queen[] s){
		start = new State();
		startState = new Queen[N];
		for(int i=0; i<s.length; i++){
			startState[i] = new Queen(s[i].getRow(), s[i].getColumn());
		}
		start.setState(startState);
		start.computeHeuristic();
		
		StatesGenerated=0;
	}
	

	public void startState(){
		//random start state
		Random gen = new Random();
		for(int i=0; i<N; i++){
			startState[i] = new Queen(gen.nextInt(N), i);
		}
		start.setState(startState);
		start.computeHeuristic();

	}
	 
// hill climbing algorithm that returns a State
	public State hillClimbing(){
		State currentState = start;
		
		while(true){
			ArrayList<State> successors = currentState.generateNeighbours(currentState);
			StatesGenerated= StatesGenerated + successors.size();
			
			State nextState = null;
			
			for(int i=0; i<successors.size(); i++){
				if(successors.get(i).compareTo(currentState) < 0){
					nextState = successors.get(i);
				}
			}
			
			if(nextState==null)
				return currentState;
			
			currentState = nextState;
		}
	}
	

	public State getStartState(){
		return start;
	}

	public int getStatesGenerated(){
		return StatesGenerated;
	}
}