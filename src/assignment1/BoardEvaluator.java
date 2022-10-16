package assignment1;

import java.util.List;

public interface BoardEvaluator {
    int evaluateBoard(Board board);
   
    
}

class evaluate implements BoardEvaluator {
	public int evaluateBoard(Board board) {
		int s = 50;
		 
		 if (board.isGameOver() && board.getWinner() == Piece.Type.MUSKETEER)
			 return 100;
		 else if (board.isGameOver() && board.getWinner() == Piece.Type.GUARD)
		 	return 0;
		 
		 // Musketeers win if they cannot capture any guards -> less guards = more chance of winning
		 int g = board.size - 3 - board.getGuardCells().size();
		 s += g;
		 
		 // guards win if all the musketeers are on the same row or column at any point in the game -> closer they are = more chance of winning
		 List<Cell> m = board.getMusketeerCells();
		 // if 2 are on the same row/col
	    	if (m.get(0).getCoordinate().col == m.get(1).getCoordinate().col || m.get(0).getCoordinate().col == m.get(2).getCoordinate().col ||  m.get(1).getCoordinate().col == m.get(2).getCoordinate().col
	    			|| (m.get(0).getCoordinate().row == m.get(1).getCoordinate().row || m.get(0).getCoordinate().row == m.get(2).getCoordinate().row || m.get(1).getCoordinate().row == m.get(2).getCoordinate().row)) {
	    		s -= 50*2/3;
	    	}
	
		return s;
	}
}


