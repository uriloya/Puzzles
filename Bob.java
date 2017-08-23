import java.io.*;
import java.util.Random;

public class Bob {

    //Add Fields if needed

    public Bob(){
        //Complete Your Code Here
    }

    public Pair<String, String> choosePuzzle(Puzzle[] puzzles){//Selecting a random puzzle
		Random rnd = new Random();
		int rid = rnd.nextInt(puzzles.length);
		Pair<String,String> p = solvePuzzle(puzzles[rid]);
		return new Pair<String,String>(p.getKey(),p.getValue());
    }

    public Pair<String, String> solvePuzzle(Puzzle puz){//Returns solved puzzle - a secret key and serial number
    	Solve so = new Solve();
    	return so.solvePuzzle(puz);
    	
    }
}
