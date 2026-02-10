/*+----------------------------------------------------------------------
 ||
 ||  Class Node
 ||
 ||         Author:  Alex Farbrook
 ||
 ||        Purpose:  Act as a grid point on a map for efficient data storage.
 ||
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  Node(x:int,y:int) -- creates a node with the x and y specified.
 ||
 ||  Class Methods:  
 ||                  toString(): string
 ||                  equals(o: Object): boolean
 ||                  hashcode(): int
 ||
 ||  Inst. Methods:  N/A
 ||
 ++-----------------------------------------------------------------------*/
public class Node {
    int x; //x value of grid
    int y; //x value of grid

    /*---------------------------------------------------------------------
        |  Method Node()
        |
        |  Purpose:  Create a Node object and initlize all fields.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: An instance of a Node object is created.
        |
        |  Parameters:
        |      x -- int, y -- int
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public Node(int x, int y){
        this.x = x;
        this.y = y;

    }

    /*---------------------------------------------------------------------
        |  Method toString()
        |
        |  Purpose:  turn a node into a human readable String
        |
        |  Pre-condition:  None
        |
        |  Post-condition: A string representation of Node is returned
        |
        |  Parameters:
        |      None
        |
        |  Returns:  The string representation
        *-------------------------------------------------------------------*/
    public String toString(){
        return (String.valueOf(x) + " " + String.valueOf(y)); 
    }
    /*---------------------------------------------------------------------
        |  Method equals()
        |
        |  Purpose:  comapre two nodes overriding default method.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: t/f value of equality is returned
        |
        |  Parameters:
        |      o - another object to compare to
        |
        |  Returns:  boolean value of them being equal
        *-------------------------------------------------------------------*/
    @Override
    public boolean equals(Object o){
        if(this == o) 
            return true;
        if(o == null || !(o instanceof Node)) 
            return false;
        Node node = (Node) o; //temp. node to be checked
        return x == node.x && y == node.y;
    }
    /*---------------------------------------------------------------------
        |  Method hashCode()
        |
        |  Purpose:  create a hash int for the hashSet overriding default method.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: hashcode is calculated
        |
        |  Parameters:
        |      None
        |
        |  Returns:  int hashcode for hash set
        *-------------------------------------------------------------------*/
    @Override
    public int hashCode() {
        return 100*x+y;
    }
}

