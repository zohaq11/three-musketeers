package assignment1;

public class RandomAgent extends Agent {
	

    public RandomAgent(Board board) {
        super(board);
    }

    /**
     * Gets a valid random move the RandomAgent can do.
     * @return a valid Move that the RandomAgent can perform on the Board
     */
    @Override
    public Move getMove() { // TODO
    	int i = (int)(0 + Math.random()*(board.getPossibleMoves().size()-1));
    	
        return board.getPossibleMoves().get(i);
    }
}
