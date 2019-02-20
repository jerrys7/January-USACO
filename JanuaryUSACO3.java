import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JanuaryUSACO3 {
    
        public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        String currentDirectory = System.getProperty("user.dir");
        String fullFileName = currentDirectory + "/guess.txt";

        FileReader fr = new FileReader(fullFileName);
        BufferedReader f = new BufferedReader(fr);
        FileReader fr1 = new FileReader(fullFileName);
        BufferedReader f1 = new BufferedReader(fr1);                                              
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));

        StringTokenizer st;
        String s;
        s = f.readLine();
        ArrayList <String> stuff = new ArrayList();
        while ( s!=null && s.length() > 0){
            st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                stuff.add(st.nextToken());
            }

            s = f.readLine();
        };
        
        ArrayList<String> animals = new ArrayList();
        String newLine="";
        while ((newLine = f1.readLine()) != null){
            //System.out.println("Just read: " + line);&
            animals.add(newLine);
            //System.out.println("Printing new Line" + newLine);
        }
        animals.remove(0);
//        System.out.println(stuff);
        int yes = 1;
//        ArrayList<String> woint = new ArrayList();
//        for(int m = 0; m < stuff.size();m++){
//            for(int k = 0; k < 10; k++){
//                if(stuff.get(m).equals(k)==false){
//                    woint.add((String) stuff.get(k));
//                }
//            }
//        }
//        String dab = "dab";
//        if(dab instanceof String){
//            System.out.println("");
//        }
        System.out.println(stuff);
        ArrayList<String> numbers = new ArrayList();
        for(int m = 0; m < 10; m++){
            numbers.add(Integer.toString(m));
        }
        stuff.removeAll(numbers);
        System.out.println(stuff);
        ArrayList<String> checked = new ArrayList();
        int z = 0;
        while(stuff.isEmpty()==false){

            String hi = stuff.get(0);
            stuff.remove(0);
            if(stuff.contains(hi)){
                checked.add(hi);
                stuff.removeAll(checked);
            }
            z++;
        }

        System.out.println(checked);
        for(int k = 0; k < animals.size(); k++){
            for(int m = 0; m < checked.size(); m++){
                if(animals.get(k).contains(checked.get(m))==false){
                    animals.remove(k);
                    animals.add(k,Double.toString(Math.random()));
                    yes++;
                }
            }
        }
        System.out.println(yes);
        f.close();
        fr.close();                             
        out.close();
    }
}
