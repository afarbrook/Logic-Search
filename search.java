import java.util.*;
import java.io.*;

public class search{

    public static void main(String[] args){
        if(args.length <0){
            System.out.println("Please provide a file name as a command line argument.");
            System.exit(1);
        }

        File file = new File("program_1_example_input.txt"); //args[0];change later
        try(Scanner in = new Scanner(file)){
            String type = in.nextLine();
            searchMap RTs = new searchMap(); //stores all the search terms
            Node start = new Node(50, 50);
            RTs.mark(start);
            clock clock = new clock(); //stores the time
            while(in.hasNextLine()){

                String[] parts = in.nextLine().split(" ");
                if(!clock.canMove()){
                    //impliment moveing back to start
                    clock.reset();
                }

                if(RTs.isValid(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))){ //checks if cords are on map
                    Node newNode = new Node(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                    if(!RTs.isSearched(newNode)){ //checks if RT has been searched
                        if(!clock.canSearch()){
                            clock.reset();
                        }
                        RTs.mark(newNode);
                        clock.tick(); clock.tick(); //tick twice for searching
                        System.out.println(newNode + ": " + String.valueOf(clock.totalTime));
                    } 

                    ArrayList<Node> neighbors = RTs.getUnsearched(newNode);
                    if(!clock.canMoveAndSearch()){ //if we need to sleep then just continue
                        clock.reset();
                        continue;
                    }
                    for(int i = 0; i< neighbors.size();i++ ){
                        Node curr = neighbors.get(i);
                        clock.tick(); //tick for moving
                        RTs.mark(curr);
                        clock.tick();clock.tick(); //ticks for searching
                        System.out.println(curr + ": " + String.valueOf(clock.totalTime));
                        if(i==neighbors.size()-1){
                            break;//no need to go back
                        }
                        if(!clock.canMoveTwice()){
                            clock.reset();
                            break;
                        }
                        clock.tick();//moving back to RT
                    }
                    
                
                } 
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
        
        
    }

}