import java.util.Random;

public class Alice {

    private Puzzle [] puzzlesArray;
    private AVLTree avl;

    public Alice(){
    }

    public Puzzle[] getPuzzlesCopy(){//The function copies the values ​​of puzzlesArray to new array and messing it.
        Puzzle[] puzzlesCopy = new Puzzle[puzzlesArray.length];
        for(int i = 0; i < puzzlesArray.length; i++){
            puzzlesCopy[i] = new Puzzle(puzzlesArray[i]);
        }
        RandomShuffle(puzzlesCopy);
        return puzzlesCopy;
    }

    public void createPuzzles(int n, int k){//Create puzzles &  builds a tree  that contains the solutions
        Random rnd = new Random();
        Solve s = new Solve();
        avl = new AVLTree();
    	puzzlesArray = new Puzzle[2*k];
        for(int i=0;i<2*k;i++)
        {
        	int[] pk,r;
        	pk = new int[n];
        	r = new int[n];
        	for(int j=0;j<n;j++) //Randomly fills the array in sorted
        	{
        		pk[j] = rnd.nextInt((j+1)*n*n*n-(j*n*n*n))+(j*n*n*n);
        		r[j] = rnd.nextInt((j+1)*n*n*n-(j*n*n*n))+(j*n*n*n);
        	}
        	puzzlesArray[i] = new Puzzle(pk,r);
        	if(!avl.search(s.solveArr(puzzlesArray[i].getRiddle())))//Making sure puzzle is not already exists . And put it in the tree
        		avl.insert(s.solveArr(puzzlesArray[i].getRiddle()),pk);
        	else
        		i-=1;
        }
    }

    public Pair<String, Integer> findKey(String sIndex){//The function returns a secret key that matches the serial number received,And the number of comparisons made.
    	 Solve s = new Solve();
    	 Pair<int[],Integer> p = (avl.getPrivateKey(sIndex));
    	 return new Pair<String,Integer>(s.solveArr(p.getKey()),p.getValue());
    }
    public void RandomShuffle(Puzzle[] arr){// the function randomly messing the array values
        Random rnd = new Random();
    	for (int i=0; i<arr.length; i++)
    	{
    		int swap = (rnd.nextInt(arr.length-i)+i);
    		Puzzle temp= arr[swap];
    		arr[swap]=arr[i];
    		arr[i]=temp;
    	}
    	
    	
    }



}
