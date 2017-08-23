import java.io.*;

/**
 * Created by tomercoh on 16/04/2016.
 */
public class Eve {
	
	//Add Fields if needed

    public Eve(){}

    public Pair<String, Integer> findKey(String index, Puzzle[] puzzles){//The function returns a secret key that matches the serial number received,And the number of comparisons made.
    	for(int i=0;i<puzzles.length;i++)
    	{
    		Pair<String,String> p = solvePuzzle(puzzles[i]);
    		if(p.getKey().equals(index))
    			return new Pair<String,Integer>(p.getValue(),i);
    	}
    	return null;
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){//Returns solved puzzle - a secret key and serial number
    	Solve so = new Solve();
    	return so.solvePuzzle(puz);
    	
    }
}
