import java.util.*;
import java.io.*;

public class search{

    public static void main(String[] args){
        if(args.length <0){
            System.out.println("Please provide a file name as a command line argument.");
            System.exit(1);
        }
        //args[0];change later
        File file = new File("program_1_example_input.txt");
        try(Scanner in = new Scanner(file)){
            String type = in.nextLine();
            searchMap RTs = new searchMap(); //stores all the search terms
            clock clock = new clock(); //stores the time
            while(in.hasNextLine()){
                String[] parts = in.nextLine().split(" ");
                if(!clock.canMove()){
                    //move back to start
                    clock.reset();
                }
                if(RTs.isValid(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))){ //checks if cords are on map
                    Node newNode = new Node(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    if(!RTs.isSearched(newNode)){
                    RTs.mark(newNode);
                    } 
                    ArrayList<Node> neighbors = RTs.getUnsearched(newNode);
                    for(Node neighbor: neighbors){
                        RTs.mark(neighbor);

                    }
                
            } 
        }System.out.println(RTs.toString());
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        
        
    }
}