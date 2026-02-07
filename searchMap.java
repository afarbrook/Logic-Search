import java.util.*;

public class searchMap {

    private HashSet<Node> searched;

    public searchMap(){
        searched = new HashSet<>();
    }

    public boolean isSearched(Node pos){
        return searched.contains(pos);
    }

    public void mark(Node pos){
        searched.add(pos);
    }

    public boolean isValid(int x, int y){
        return (x>-1 && x<50) && (y>-1 && y<50);
    }

    public ArrayList<Node> getUnsearched(Node pos){
        int x = pos.getX();
        int y = pos.getY();
        ArrayList<Node> neighbors = new ArrayList<>();
        if(isValid(x, y-1)){    
            Node North = new Node(x, y-1);
            if(!isSearched(North)){
                neighbors.add(North);
            }
        }
        if(isValid(x+1, y)){    
            Node East = new Node(x+1, y);
            if(!isSearched(East)){
                neighbors.add(East);
            }
        }
        if(isValid(x, y+1)){    
            Node South = new Node(x, y+1);
            if(!isSearched(South)){
                neighbors.add(South);
            }
        }
        if(isValid(x-1, y)){    
            Node West = new Node(x-1, y);
            if(!isSearched(West)){
                neighbors.add(West);
            }
        }return neighbors;

    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Node n: searched){
            sb.append(n.toString()).append("\n");
        }
        return sb.toString();
    }
    

}   

    