import java.io.PrintWriter;

/* Class AVLTree */
class AVLTree
{
	
    private AVLNode root;

    /* Constructor */
    public AVLTree()
    {
        root = null;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
    	return root == null;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root= null;
    }
    /* Function to insert data */

    public void insert(Comparable data)
    {
    	int [] a =new int[0];
    	root = insert(data,a,root);
    }
    /* Function to insert data and keys array*/
    public void insert(Comparable data, int[] k)
    {
    	root = insert(data,k,root);
    }
    private AVLNode insert(Comparable x,AVLNode t) 
    {
    		int [] a =new int[0];
            return insert( x,a,t);
    }
    private AVLNode insert(Comparable x,int[] key ,AVLNode t)// Function to insert data and keys array in to a tree
    {
        if( t == null )
            t = new AVLNode(x,key);
        else if( x.compareTo( t.data ) < 0 ) //insertion while preserving the AVL tree
        {
            t.left = insert( x,key, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( x.compareTo( t.left.data) < 0 )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( x.compareTo( t.data ) > 0 )
        {
            t.right = insert( x,key, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( x.compareTo( t.right.data ) > 0 )
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
        	t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
    	return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
            if (lhs >= rhs)
            		return lhs;
    		return rhs;
    }
    /* Function to insert data recursively */

    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
    	 AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
    	 AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
    	 k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
    	 k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(Comparable val)
    {
        return search(root,val);
    }
    private boolean search(AVLNode r, Comparable val)
    {
    	 while( r != null )
    	 {
             if( val.compareTo( r.data ) < 0 )
                 r = r.left;
             else if( val.compareTo( r.data ) > 0 )
                 r = r.right;
             else
                 return true;
    	 }
         return false; 
    }
    /* Function for inorder traversal */
    public void inorder(PrintWriter out)
    {
    	//Complete Your Code Here
    }
    private void inorder(AVLNode r, PrintWriter out)
    {
        //Complete Your Code Here
    }

    public Pair<int[],Integer> getPrivateKey(String sIndex) {
    	return getPrivateKey(root, sIndex);
    }

    private Pair<int[],Integer> getPrivateKey(AVLNode r, String sIndex) {
    	int count=0;
    	while( r != null )
    	{
    		 count++;
             if( sIndex.compareTo( (String) r.data ) < 0 )
                 r = r.left;
             else if( sIndex.compareTo( (String) r.data ) > 0 )
                 r = r.right;
             else
                 return new Pair<int[],Integer>(r.key,count);
    	}
        return null; 
    }
}