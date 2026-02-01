import java.util.*;

public class search{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        if(args.length <1){
            System.out.println("Please provide a file name as a command line argument.");
            System.exit(1);
        }
        String fileName = args[0];
        String type = in.nextLine();
        ArrayList<String> RTs = new ArrayList<>(); //stores all the search terms
        while(in.hasNextLine()){
            String line = in.nextLine();
            RTs.add(line);
        }
        
    }
}