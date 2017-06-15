import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class task2 {
    
    public static final int SOLID = -1000;
    public static final int BLANK = -2000;
    public int[][] board;
    public int numOfWordsOnBoard; // from 1 to 8 in the small puzzle example
    public Letter[][] currentwords; // same size as the board keeps track of every letter on the board and index to the array of dictionary
    public String[] dictionary; // dictionary
    public boolean[] usedwords;   //If dictionary[0] is somewhere in the board, usedwords[0] == true.
    
    // constructor of the class
    public task2(int[][] board, String[] dictionary, int numOfWordsOnBoard) {

        this.dictionary = new String[dictionary.length];
        for(int j =0;j<dictionary.length;j++){
        	this.dictionary[j]=dictionary[j];
        }
        //System.arraycopy(dictionary, 0, this.dictionary, 0, dictionary.length); // copy conteent of array in second array from 0 to dictionary.length
        this.usedwords = new boolean[dictionary.length];

        int numColumns = board[0].length;
        this.board = new int[board.length][numColumns];
 // filling the board with data initially
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
           this.board[i][j] = board[i][j];
            }
        }
        // ending filling the board with data

        this.currentwords = new Letter[board.length][numColumns];

        this.numOfWordsOnBoard = numOfWordsOnBoard;
    }
    // end of constructor

    public void applyValue(int wordIndex, int spaceNumber) {
        int[] spacestart = getSpaceStart(spaceNumber);

        int row = spacestart[0];
        int col = spacestart[1];

        int spaceSize = getSpaceSize(spaceNumber);
        boolean isAcross = board[row][col] > 0;

        Letter[] ltrs = Letter.lettersFromString(dictionary[wordIndex], wordIndex);

        for (int i = 0; i < spaceSize; i++) {
            if (currentwords[row][col] == null) {
                currentwords[row][col] = ltrs[i];
            }

            if (isAcross) {
                col += 1;
            } else {
                row += 1;
            }
        }

        usedwords[wordIndex] = true;
    }
    

    public void removeValue(int wordIndex, int spaceNumber) {
        int[] spaceCoord = getSpaceStart(spaceNumber);

        int row = spaceCoord[0];
        int col = spaceCoord[1];

        int spaceSize = getSpaceSize(spaceNumber);
        boolean isAcross = board[row][col] > 0;

        for (int i = 0; i < spaceSize; i++) {
            if (currentwords[row][col] != null &&
                currentwords[row][col].wordIndex == wordIndex)
            {
                currentwords[row][col] = null;
            }

            if (isAcross) {
                col += 1;
            } else {
                row += 1;
            }
        }

        usedwords[wordIndex] = false;
    }

 
    public boolean isValid(int wordIndex, int wordplace) {
        int spaceSize = getSpaceSize(wordplace);

        return dictionary[wordIndex].length() == spaceSize &&
               intersectionsMatch(wordIndex, wordplace);
    }

 
    public boolean intersectionsMatch(int wordIndex, int spaceNumber) { // 
        int[] spacestart = getSpaceStart(spaceNumber);
        int row = spacestart[0];
        int col = spacestart[1];

        int spaceSize = getSpaceSize(spaceNumber);
        boolean isAcross = board[row][col] > 0;
        String word = dictionary[wordIndex];

        for (int i = 0; i < spaceSize; i++) {
            if (currentwords[row][col] != null &&
                currentwords[row][col].character != word.charAt(i)) // if the letter not equal null and not equal the word's character
            {
                return false;
            }

            if (isAcross) {
                col += 1;
            } else {
                row += 1;
            }
        }

        return true;
    }

    

    public int getSpaceSize(int spaceNumber) {
        int[] spacestart = getSpaceStart(spaceNumber);


        int row = spacestart[0];
        int column = spacestart[1];

        boolean isAcross = board[row][column] > 0; // if positive then across

        int size;

        if (isAcross) {
            size = board[0].length - column;
        } else {
            size = board.length - row;
        }


        int i;
        for (i = 0; i < size; i++) {
            if (isAcross && board[row][column + i] == SOLID) {
                break;
            }

            if (!isAcross && board[row + i][column] == SOLID) {
                break;
            }
        }

        return i;
    }

    public int[] getSpaceStart(int spaceNumber) { // array of size 2, x and y on the board, the start cell of the space number
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == BLANK || board[i][j] == SOLID) {
                    continue;
                }

                if (Math.abs(board[i][j]) == spaceNumber) {
                    int[] result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }
    
  
    
    //recursion method
    public void findSolution() {
        findSolution(1);
    }
    public void findSolution(int wordplace) {  // word place is from 1 to 8
        if (wordplace > numOfWordsOnBoard) {  // if all the wordplaces are assigned to words
            System.out.println(this.toString());
            return;
        }

        for (int index = 0; index < dictionary.length; index++) { //skip  if the word is already used
            if (usedwords[index]) {
                continue;
                
            }

            if (isValid(index, wordplace)) {
                
                applyValue(index, wordplace);
                findSolution(wordplace + 1);
                removeValue(index, wordplace);
               
            }
        }
    }





    public String toString() {
        String s = "";

        for (int i = 0; i < board.length; i++) {

            // add border line between rows
            if (i > 0) {
                for (int k = 0; k < board[i].length; k++) {
                    if (k == board[i].length - 1) {
                        s += "---";
                    } else {
                        s += "---+";
                    }
                }

                s += "\n";
            }

            // add squares to row
            for (int j = 0; j < board[i].length; j++) {
                char ch = ' ';

                if (board[i][j] == SOLID) {
                    ch = '#';
                } else {
                    if (currentwords[i][j] == null) {
                        // the blank is not occupied by a letter
                        ch = ' ';
                    } else {
                        // the blank is filled in with a letter
                        ch = currentwords[i][j].character;
                        ch = Character.toUpperCase(ch);
                    }
                }

                if (j == board[i].length - 1) {
                    s += " " + ch;
                } else {
                    s += " " + ch + " |";
                }
            }

            s += "\n";

        }

        return s;
    }


    public static void main(String[] args) throws Exception {
      int[][] board = { { 1,     BLANK, -2,    BLANK, -3    },
                          { SOLID, SOLID, BLANK, SOLID, BLANK },
                          { SOLID, 4,     BLANK, -5,    BLANK },
                          { -6,    SOLID, 7,     BLANK, BLANK },
                          { 8,     BLANK, BLANK, BLANK, BLANK },
                         { BLANK, SOLID, SOLID, BLANK, SOLID } };

        int wordlocations = 8;

       String[] dictionary = { "aft", "laser", "ale", "lee", "eel", "line",
                           "heel", "sails", "hike", "sheet", "hoses", 
                           "steer", "keel", "tie", "knot" };

        task1 result = new task1(board, dictionary, wordlocations);
        result.findSolution();
      
    	
    	
 /* 	String [] dictionary = new String[21120];
    	FileReader file = new FileReader("C:/Users/tfouda.CS.001/Desktop/words.txt");
    	BufferedReader reader = new BufferedReader(file);
    	String line = reader.readLine();
    	int i = 0;
   */
  /*	while(i<21120){
  		String line2 ="";
  		 line2 = line.replaceAll("\\s+","");
    		dictionary[i] = (String)(line2); 
    		i++;
    		line = reader.readLine();
    	}
  	
*/
 //int wordlocations = 33;
 
/* int[][] board = {  {SOLID,SOLID,-1,-2, -3 , SOLID , SOLID , SOLID,-4,-5,-6,SOLID,SOLID},
		 			{SOLID,7,BLANK,BLANK,BLANK,-8,SOLID,9,BLANK,BLANK,BLANK,-10,SOLID},
		 			{SOLID,11,BLANK,BLANK,BLANK,BLANK,SOLID,12,BLANK,BLANK,BLANK,BLANK,SOLID},
		 			{13,BLANK,BLANK,SOLID,14,BLANK,-15,BLANK,BLANK,SOLID,-16,BLANK,-17},
		 			{18,BLANK,BLANK,-19,SOLID,20,BLANK,BLANK,SOLID,21,BLANK,BLANK,BLANK},
		 			{22,BLANK,BLANK,BLANK,SOLID,23,BLANK,BLANK,SOLID,24,BLANK,BLANK,BLANK},
		 			{SOLID,25,BLANK,BLANK,-26,SOLID,SOLID,SOLID,27,BLANK,BLANK,BLANK,SOLID},
		 			{SOLID,SOLID,28,BLANK,BLANK,-29,SOLID,30,BLANK,BLANK,BLANK,SOLID,SOLID},
		 			{SOLID,SOLID,SOLID,31,BLANK,BLANK,-32,BLANK,BLANK,BLANK,SOLID,SOLID,SOLID},
		 			{SOLID,SOLID,SOLID,SOLID,33,BLANK,BLANK,BLANK,BLANK,SOLID,SOLID,SOLID,SOLID},
		 			{SOLID,SOLID,SOLID,SOLID,SOLID,BLANK,BLANK,BLANK,SOLID,SOLID,SOLID,SOLID,SOLID},
		 			{SOLID,SOLID,SOLID,SOLID,SOLID,SOLID,BLANK,SOLID,SOLID,SOLID,SOLID,SOLID,SOLID}
		 
 };*/
 
 //test result = new test(board, dictionary, wordlocations);
 //result.findSolution();
 
    }
}

