
public class Solve {
	public int XOR (String s)
	{
		int count=0;
		for(int i=0; i<s.length(); i++)
		{
			if (s.charAt(i)== '1' )
					count ++;
		}
		return count%2;
	}
    public Pair<String, String> solvePuzzle(Puzzle puz){//Returns solved puzzle - a secret key and serial number
    	String sn= "";
    	String key = "";
    	//First sorting arrays
    	MergeSort ms= new MergeSort();
    	ms.mergeSort(puz.getRiddle());
    	ms.mergeSort(puz.getPrivateKey());
    	
    	for (int i = 0 ; i<puz.getRiddle().length; i++)//Decoding the puzzle by using XOR function
    	{
    	   key+= XOR(Integer.toString(puz.getPrivateKey()[i], 2));
     	   sn+= XOR(Integer.toString(puz.getRiddle()[i], 2));
    	}
    	return new Pair<String,String>(sn,key);
    }
    public String solveArr(int [] a){//Decoding an array by using sort and XOR function
    	String x= "";
    	MergeSort ms= new MergeSort();
    	ms.mergeSort(a);
    	for (int i = 0 ; i<a.length; i++ )
    	{
    	   x+= XOR(Integer.toString(a[i], 2));
    	}
    	return x;
    }   


}

  
