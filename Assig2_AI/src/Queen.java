public class Queen {
	 int row;
	 int column;
	
	public Queen(int row, int column){
		this.row = row;
		this.column  = column;
	}
	

	//decides if a queen can attack or not
	
	public boolean canAttack(Queen queen){
		boolean canAttack=false;
		
		
		if(this.row==queen.getRow() || this.column==queen.getColumn())
			canAttack=true;
		//test diagonal
		else if(Math.abs(this.column-queen.getColumn()) == Math.abs(this.row-queen.getRow()))
			canAttack=true;
			
		return canAttack;
	}
	
	/**
	 * moves the piece down
	 * @param spaces
	 */
	
	public void moveDown(int cells){
		this.row = this.row+cells;
		
		//bound check/reset
		if(row>7 && row%7!=0){
			row=(row%7)-1;
		}
		else if(row>7 && row%7==0){
			row=7;
		}
	}
	

	
	
	public void setRow(int row){
		this.row=row;
	}
	

	public int getRow(){
		return this.row;
	}

	public void setColumn(int column){
		this.column=column;
	}
	
	
	public int getColumn(){
		return this.column;
	}
	
	public String toString(){
		return "("+this.row+", "+this.column+")";
	}
}