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

}   

    