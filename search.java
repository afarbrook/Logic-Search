/*=============================================================================
 |   Assignment:  Program #1
 |       Author:  Alex Farbrook
 |
 |       Course:  CSC 345 Spring 26
 |   Instructor:  Lynam
 |     Due Date:  2/10/26, at the beginning of class
 |
 |     Language:  Java
 |  Compile/Run:  Add an input document
 |
 +-----------------------------------------------------------------------------
 |
 |  Description:  We want to be able to search a grid based off of a list of points to search from. We can search neighbors of these points
 |  But we can only search for 16 hours at a time. We want to store searched points in a memory effecient data structure such that we can
 |  Easily see where we have been.
 |                
 |        Input:  a text file containing search points
 |
 |       Output:  The nodes visited in order, and then the time taken to search
 |
 |   Known Bugs:  As far as I know none, I have tried amny differnt edge cases and all seem to pass.
 |
 *===========================================================================*/
import java.util.*;
import java.io.*;

public class search{

    public static void main(String[] args){
        if(args.length <1){
            System.out.println("Please provide a file name as a command line argument.");
            System.exit(1);
        }
        File file = new File(args[0]); //creates a file to be traversed
        try(Scanner in = new Scanner(file)){ //canner to go through file
            String type = in.nextLine();
            int row = 0; //1 if we want row first and 0 if not
            if(type.equals("row")) //defaults to collumn if not row
                row = 1;
            searchMap RTs = new searchMap(); //stores all the search terms
            Node start = new Node(50, 50); //starting node to add
            RTs.mark(start);
            clock clock = new clock(); //stores the time
            while(in.hasNextLine()){

                String[] parts = in.nextLine().split(" "); //parts of input in array
                if(parts.length!=2){
                    System.out.println("bad x y -> skipping");
                    continue;
                }
                if(!clock.canMove()){
                    //impliment moveing back to start
                    if(in.hasNextLine()){
                        clock.reset();
                    }
                    
                }
                if(RTs.isValid(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]))){ //checks if cords are on map
                    Node newNode = new Node(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])); //temp. node to check
                    if(!RTs.isSearched(newNode)){ //checks if RT has been searched
                        if(!clock.canSearch()){
                            if(in.hasNextLine()){
                                clock.reset();
                            }
                        }
                        RTs.mark(newNode);
                        clock.tick(); clock.tick(); //tick twice for searching
                        //System.out.println(newNode + ": " + String.valueOf(clock.totalTime));
                    } 
                    ArrayList<Node> neighbors = RTs.getUnsearched(newNode); //neighbors of node
                    if(!clock.canMoveAndSearch()){ //if we need to sleep then just continue
                        if(in.hasNextLine()){
                            clock.reset();
                        }
                        continue;
                    }
                    for(int i = 0; i< neighbors.size();i++ ){
                        Node curr = neighbors.get(i); //current neighbor
                        clock.tick(); //tick for moving
                        RTs.mark(curr);
                        clock.tick();clock.tick(); //ticks for searching
                        //System.out.println(curr + ": " + String.valueOf(clock.totalTime));
                        if(i==neighbors.size()-1){
                            break;//no need to go back
                        }
                        if(!clock.canMoveTwice()){
                            if(in.hasNextLine()){
                                clock.reset();
                            }
                            break;
                        }
                        clock.tick();//moving back to RT
                    }
                } 
            }
            RTs.print(row);
            System.out.println(clock.totalTime);
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }

}