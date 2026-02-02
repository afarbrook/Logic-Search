import java.util.*;

public class search{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        if(args.length <0){
            System.out.println("Please provide a file name as a command line argument.");
            System.exit(1);
        }
        String fileName = "program_1_example_input.txt";//args[0];change later
        String type = in.nextLine();
        searchMap RTs = new searchMap(); //stores all the search terms
        while(in.hasNextLine()){
            String[] parts = in.nextLine().split(" ");
            if(RTs)
        }
        
    }
}