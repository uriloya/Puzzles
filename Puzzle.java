public class Puzzle {

    private int[] privateKey;
    private int[] riddle;

    public Puzzle(int[] privateKey, int[] riddle){//constructor
        this.privateKey = privateKey;
        this.riddle = riddle;
    }

    public Puzzle(Puzzle o){//constructor
        int [] oRiddle = o.getRiddle();
        int [] oPrivateKey = o.getPrivateKey();
        privateKey = new int[oPrivateKey.length];
        riddle = new int[oRiddle.length];
        for (int i = 0; i < oPrivateKey.length; i++){
            privateKey[i] = oPrivateKey[i];
        }
        for (int i = 0; i < oRiddle.length; i++){
            riddle[i] = oRiddle[i];
        }
    }

    public int[] getPrivateKey(){
        return privateKey;
    }

    public int[] getRiddle() {
        return riddle;
    }
    public String getIRiddle(){ //Returns a serial number , after decoding it by using XOR function
    	Solve so = new Solve();
    	String str = "";
    	for(int i = 0; i<riddle.length ; i++)
    	{
    		str+=so.XOR(Integer.toString(riddle[i],2));
    	}
    	return str;
    }

	public String getIKey() { //Returns Secret Key , after decoding it by using XOR function.
		Solve so = new Solve();
    	String str = "";
    	for(int i = 0; i<privateKey.length ; i++)
    	{
    		str+=so.XOR(Integer.toString(privateKey[i],2));
    	}
    	return str;
	}

}
