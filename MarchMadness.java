
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; 

public class MarchMadness {
    public static void main(String[] args) throws FileNotFoundException    {
    	// Queue containing all teams 
        Queue<String> team = new LinkedList<>();
        // winners Queue
        Queue<String> won = new LinkedList<>();
        
        // the scanner that lets us take the teams from the text file 
        Scanner Scan = new Scanner(new File("teams.txt"));
        while (Scan.hasNextLine()) {
            team.add(Scan.nextLine());
        }
     
       
     // There will be four Rounds SS,EE,FF,Champ round  
        for (int z = 1; z <= 4; z++) {
        	// There two teams in each round so that how we know the number of rounds 
            int rounds = team.size() / 2; 
        

            System.out.println("Round " + z );
            for (int i = 0; i < rounds; i++) {
            	 // the poll method lets us remove from the top of the Queue and give us teams for the match ups 
                String team1 = team.poll();
                String team2 = team.poll();
             // Uses a random Boolean to choose who wins 
                                boolean result = Math.random() < 0.5; 
                // uses a conditional operator to let program know who wins if true or false 
                String winner = result ? team1 : team2;
             // displays the match up and winner 
                System.out.println (team1 + " vs " + team2 + ": " + winner + " wins");
                // Adds winner to next round
                won.add(winner); 
               
            }
            team = won; 
                     
        }
        
        //Tell us who the champ is
        System.out.println("Champion: " + team.poll());
      
    }
}
