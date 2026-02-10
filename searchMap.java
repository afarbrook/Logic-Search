/*+----------------------------------------------------------------------
 ||
 ||  Class searchMap
 ||
 ||         Author:  Alex Farbrook
 ||
 ||        Purpose:  Keep track of all nodes searched in a memory efficient manner. Only stores searched nodes.
 ||
 ||
 |+-----------------------------------------------------------------------
 ||
 ||   Constructors:  searchmap() : initilizes searched to a new hashSet
 ||
 ||  Class Methods:  isSearched(): boolean
 ||                  mark(): void
 ||                  isValid(x: int, y: int): boolean
 ||                  getUnsearched(pos: Node): ArrayList<Node>
 ||                  print(row:int): void
 ||
 ||  Inst. Methods:  N/A
 ||
 ++-----------------------------------------------------------------------*/
import java.util.*;

public class searchMap {
    
    private HashSet<Node> searched; //hashset to store all searched nodes
    /*---------------------------------------------------------------------
        |  Method searchMap()
        |
        |  Purpose:  Create a searchMap object and initlize all fields.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: An instance of a searchmap object is created.
        |
        |  Parameters:
        |      None
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public searchMap(){
        searched = new HashSet<>();
    }
    /*---------------------------------------------------------------------
        |  Method isSearched()
        |
        |  Purpose:  check if a node has been searched
        |
        |  Pre-condition:  pos is a Node
        |
        |  Post-condition: the node will be known if in the map
        |
        |  Parameters:
        |      pos -- Node to be searched
        |
        |  Returns:  true if pos has been searched, false otherwise
        *-------------------------------------------------------------------*/
    public boolean isSearched(Node pos){
        return searched.contains(pos);
    }
    /*---------------------------------------------------------------------
        |  Method mark()
        |
        |  Purpose:  mark a node on the map
        |
        |  Pre-condition:  pos is a node
        |
        |  Post-condition: pos is marked
        |
        |  Parameters:
        |      pos -- Node to be marked
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public void mark(Node pos){
        searched.add(pos);
    }
    /*---------------------------------------------------------------------
        |  Method isValid()
        |
        |  Purpose:  check if a pair of cords is within range
        |
        |  Pre-condition:  None
        |
        |  Post-condition: X and Y will either be in or out of range of the map
        |
        |  Parameters:
        |      x --int of x value
        |      y -- int of y value
        |  Returns:  true if (x,y) are on the map, false otherwise
        *-------------------------------------------------------------------*/
    public boolean isValid(int x, int y){
        return (x>-1 && x<100) && (y>-1 && y<100);
    }
    /*---------------------------------------------------------------------
        |  Method getUnsearched()
        |
        |  Purpose:  get all unsearched neighbors of a node.
        |
        |  Pre-condition:  pos is a Node
        |
        |  Post-condition: the nodes neighbors will be checked
        |
        |  Parameters:
        |      pos -- Node to have neighbors checked
        |
        |  Returns:  ArrayList<Node> of al unserached neighbors
        *-------------------------------------------------------------------*/
    public ArrayList<Node> getUnsearched(Node pos){
        int x = pos.x; //x value of pos
        int y = pos.y; //y value of pos
        ArrayList<Node> neighbors = new ArrayList<>(); //empty list for all neighbors
        if(isValid(x-1, y)){    
            Node North = new Node(x-1, y); //temp node to add to list
            if(!isSearched(North)){
                neighbors.add(North);
            }
        }
        if(isValid(x, y+1)){    
            Node East = new Node(x, y+1); //temp node to add to list
            if(!isSearched(East)){
                neighbors.add(East);
            }
        }
        if(isValid(x+1, y)){    
            Node South = new Node(x+1, y); //temp node to add to list
            if(!isSearched(South)){
                neighbors.add(South);
            }
        }
        if(isValid(x, y-1)){    
            Node West = new Node(x, y-1); //temp node to add to list
            if(!isSearched(West)){
                neighbors.add(West);
            }
        }return neighbors;

    }
    /*---------------------------------------------------------------------
        |  Method print()
        |
        |  Purpose:  print out map in row or col order.
        |
        |  Pre-condition:  None
        |
        |  Post-condition: Map is printed out line by line
        |
        |  Parameters:
        |      row -- int where if the first line of input is "row" then 1, 0 if othewise
        |
        |  Returns:  None
        *-------------------------------------------------------------------*/
    public void print(int row){
        Node end = new Node(50, 50); //starting point does not get printed
        searched.remove(end);
        List<Node> items = new ArrayList<>(searched); //list to get sorted
        if(row ==1){ //checks for row sorted or col sorted
            items.sort(Comparator.comparingInt((Node node) -> node.x).thenComparingInt((Node node) -> node.y)); //uses lambda statement to compare nodes based on row or col
        }else{
            items.sort(Comparator.comparingInt((Node node) -> node.y).thenComparingInt((Node node) -> node.x)); //uses lambda statement to compare nodes based on row or col
        }
        for(Node node:items){
            System.out.println(node);
        }
    }
    

}   

    