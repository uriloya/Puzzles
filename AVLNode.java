/* Class AVLNode */
class AVLNode
{
    AVLNode left, right;
    Comparable data;
    int[] key;
    int height;

    /* Constructor */
    public AVLNode()
    {
        left = null;
        right = null;
        data = null;
        key = new int[0];
        height = 0;
    }
    /* Constructor */
    public AVLNode(Comparable n)
    {
        left = null;
        right = null;
        data = n;
        key = new int[n.toString().length()];
        height = 0;
    }
    /* Constructor */
    public AVLNode(Comparable n,int[] k)
    {
        left = null;
        right = null;
        data = n;
        key = k;
        height = 0;
    }
}
 