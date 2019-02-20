
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JanuaryUSACO {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/shell.in";

        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);
                                                      
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> swap1 = new ArrayList();
        ArrayList <Integer> swap2 = new ArrayList(); 
        ArrayList <Integer> guess = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
                swap1.add(Integer.parseInt(st.nextToken()));
            if(st.hasMoreTokens()){
                swap2.add(Integer.parseInt(st.nextToken()));
            }
            if (st.hasMoreTokens()){
                guess.add(Integer.parseInt(st.nextToken())); 
            }          

            s = f.readLine();
        };
        
        int numberofSwaps = swap1.get(0);
        swap1.remove(0);
        //if the thing starts in 1
        int one = 0;
        int pos1 = 1;
        for (int x = 0; x <numberofSwaps; x++){
            if(swap1.get(x).equals(pos1)){
                pos1 = swap2.get(x);
            }else if(swap2.get(x).equals(pos1)){
                pos1= swap1.get(x);
            }
            
            if(guess.get(x).equals(pos1)){
                one++;
            }
        }
        int two = 0;
        int pos2 = 2;
        for (int x = 0; x <numberofSwaps; x++){
            if(swap1.get(x).equals(pos2)){
                pos2 = swap2.get(x);
            }else if(swap2.get(x).equals(pos2)){
                pos2= swap1.get(x);
            }
            
            if(guess.get(x).equals(pos2)){
                two++;
            }
        }
        
        int three = 0;
        int pos3 = 3;
        for (int x = 0; x <numberofSwaps; x++){
            if(swap1.get(x).equals(pos3)){
                pos3 = swap2.get(x);
            }else if(swap2.get(x).equals(pos3)){
                pos3= swap1.get(x);
            }
            
            if(guess.get(x).equals(pos3)){
                three++;
            }
        }
        
        if(one>= two){
            if(one >= three){
                out.println(one);
            }else{
                out.println(three);
            }
        }else{
            if(two >= three){
                out.println(two);
            }else{
               out.println(three);
            }
        }
        
        f.close();
        fr.close();                             
        out.close();
        
    }
    
}
