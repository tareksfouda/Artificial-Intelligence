import java.util.*;

public class State implements Comparable<State>{
	static int N=8; //8 queens
	public Queen[] state; //the State's state keep track of all queens in the board
	public ArrayList<State> neighbours;
	public int hn; //heuristic score
	

	public State(){
		this.state = new Queen[N]; //empty state
		this.neighbours = new ArrayList<State>(); //empty neighbour list
	} 
	

	public State(State n){
		state = new Queen[N];
		neighbours = new ArrayList<State>();
		for(int i=0; i<N; i++)
			this.state[i] = new Queen(n.state[i].getRow(), n.state[i].getColumn());
		hn=0;
	}
	

	public ArrayList<State> generateNeighbours(State startState){
		int count=0;
		
		if(startState==null)
			System.out.println("empty state");
		
		for(int i=0; i<N; i++){
			for(int j=1; j<N; j++){
				this.neighbours.add(count, new State(startState));
				this.neighbours.get(count).state[i].moveDown(j);
				this.neighbours.get(count).computeHeuristic();
				
				count++;
			}
		}
		
		return this.neighbours;
	}
	

	public State getRandomNeighbour(State startState){
		Random gen = new Random();
		
		int col = gen.nextInt(N);
		int d = gen.nextInt(N-1)+1;
		
		State neighbour = new State(startState);
		neighbour.state[col].moveDown(d);
		neighbour.computeHeuristic();
		
		return neighbour;
	}
	
// calculate number of attacks in the state
	
	public int computeHeuristic(){
	
		for(int i=0; i<N-1; i++){
			for(int j=i+1; j<N; j++){
				if(state[i].canAttack(state[j])){
						hn++;
				}
			}
		}
		
		return hn;
	}
	

	

	public int getHeuristic(){
		return hn;
	}
	
	//  Comparable method compare between two states based on hn 

	public int compareTo(State n){
		if(this.hn < n.getHeuristic())
			return -1;
		else if(this.hn > n.getHeuristic())
			return 1;
		else 
			return 0;
	}
	

	public void setState(Queen[] s){
		for(int i=0; i<N; i++){
			state[i]= new Queen(s[i].getRow(), s[i].getColumn());
		}
	}
	

	public Queen[] getState(){
		return state;
	}
	

	public String toString(){
		String result="";
		String[][] board = new String[N][N];
		
		//initialise board with X's to indicate empty spaces
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				board[i][j]=" * ";
		
		//place the queens on the board
		for(int i=0; i<N; i++){
			board[state[i].getRow()][state[i].getColumn()]=" Q ";
		}
		
		//feed values into the result string
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				result+=board[i][j];
			}
			result+="\n\n";
		}
		
		return result;
	}
	
	/*public static void main(String[] args){
		Queen q1 = new Queen(0, 0);
		Queen q2 = new Queen(1, 1);
		Queen q3 = new Queen(2, 2);
		Queen q4 = new Queen(3, 3);
		State state = new State();
			state.state[0] = q1;
			state.state[1] = q2;
			state.state[2] = q3;
			state.state[3] = q4;
			//System.out.println(state.generateNeighbours(state));

	}*/
}