package assignment1;

import java.util.Scanner;

public class HumanAgent extends Agent {
	private final Scanner scanner = new Scanner(System.in); //

    public HumanAgent(Board board) {
        super(board);
    }

    /**
     * Asks the human for a move with from and to coordinates and makes sure its valid.
     * Create a Move object with the chosen fromCell and toCell
     * @return the valid human inputted Move
     */
    @Override
    public Move getMove() {
    	String from, to;
    	Move m;
    	Coordinate fc, tc;
    	boolean flag;
    	
    	
    	do {
    		System.out.print("Enter which cell to move from: (row#col#)");
    		from = scanner.nextLine();
    		System.out.print("Enter which cell to move to: (row#col#)");
    		to = scanner.nextLine();
    		
    		
    		fc = new Coordinate(Character.getNumericValue(from.charAt(0)) - 1,Character.getNumericValue(from.charAt(1))-1);
    		tc = new Coordinate(Character.getNumericValue(to.charAt(0)) - 1,Character.getNumericValue(to.charAt(1))-1);
    		
    		m = new Move(this.board.getCell(fc),this.board.getCell(tc));
    		
    		flag = false;
    		
    		if (this.board.getCell(fc).hasPiece() == false)
    			flag = true;
    		
    		if (this.board.getCell(fc).hasPiece()) {
    			if (Integer.parseInt(from) < 1 ||  Integer.parseInt(from) > 99 || Integer.parseInt(to) < 1 ||  Integer.parseInt(to) > 99
    				|| this.board.getCell(fc).getPiece().getType() != this.board.getTurn() || this.board.isValidMove(m) != true 
    				|| this.board.isValidMove(m) != true ||this.board.getCell(fc) == null)
    			flag = true;
    		
    		
    		}
    		
    		if (flag)
    			System.out.print("Invalid move, try again.");
    		
    		
    	} while(flag);
 
        return m;
    }
    
}
