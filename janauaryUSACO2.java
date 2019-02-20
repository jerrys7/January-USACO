import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class janauaryUSACO2 {
    
public static boolean isSorted(ArrayList<Integer> a) {

    for (int i = 0; i < a.size() - 1; i++) {
        if (a.get(i) > a.get(i + 1)) {
            return false; // It is proven that the array is not sorted.
        }
    }

    return true; // If this part has been reached, the array must be sorted.
}
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/sleepy.txt";

        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);
                                                      
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <Integer> order = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                order.add(Integer.parseInt(st.nextToken()));
            }

            s = f.readLine();
        };
        int max = order.get(0);
        order.remove(0);
        int min = 0;
        for(int k = 0; k < order.size(); k++){
            if(isSorted(order)){
                
                return;
            }else{
                for(int x = 0; x < order.size()-1; x++){
                    ArrayList<Integer> sorted = new ArrayList();
                    for(int m = 0; m <= x; m++){
                        sorted.add(order.get(m));
                    }
                    
                    if(isSorted(sorted)){
                        order.add(x+1, order.get(0));
                        order.remove(0);
                        
                    }else if(order.get(0).equals(max) == false){
                        order.add(order.indexOf(order.get(0)+1), order.get(0));
                        order.remove(0);
                    }else if(order.get(0).equals(max)){
                        order.add(order.indexOf(order.get(0)-1)+1, order.get(0));
                    }
                }
            }
        }
        
        System.out.println(min);
    }
    
}
