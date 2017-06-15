import java.util.*;
public class Nqueens {
	public static void main(String[] args){
		Nqueens board = new Nqueens();
		int numberOfRuns = 100;
		int noOfSolutions=0;
		
		for(int i=0; i<numberOfRuns; i++){
			Queen[] initialBoard = board.randomshuffle();
			HillClimbing hc = new HillClimbing(initialBoard);
			State solution = hc.hillClimbing();

			if(i ==0){ // printing initial state
				System.out.println(" The plot of the initial state");
				System.out.println(hc.start.toString());
				System.out.println();
				System.out.println();
			}
			if(i ==10){ // printing the 10th state
				System.out.println(" The plot of the 10th state");
				System.out.println(solution.toString());
				System.out.println();
				System.out.println();
			}
			if(solution.getHeuristic()==0){
				noOfSolutions++;
			}


		}
		
		System.out.println("Hill climb solutions: "+noOfSolutions);
		System.out.println();
		
		//double randomRestartPercent = (double)(randomRestartSuccesses/numberOfRuns);
		

	}
	

	public Queen[] randomshuffle(){
		Queen[] initial = new Queen[8];
	 /*
		Queen q1 = new Queen(0, 0);
		Queen q2 = new Queen(1, 1);
		Queen q3 = new Queen(2, 2);
		Queen q4 = new Queen(3, 3);
		Queen q5 = new Queen(4, 4);
		Queen q6 = new Queen(5, 5);
		Queen q7 = new Queen(6, 6);
		Queen q8 = new Queen(7, 7);
		start[0] = q1;
		start[1] = q2;
		start[2] = q3;
		start[3] = q4;
		start[4] = q5;
		start[5] = q6;
		start[6] = q7;
		start[7] = q8;*/
		
		Random gen = new Random();
		
		for(int i=0; i<8; i++){
			initial[i] = new Queen(gen.nextInt(8),i);
		}
		return initial;
	}
	
	
}
