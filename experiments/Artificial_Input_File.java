/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package experiments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author gpavlopo
 */
public class Artificial_Input_File {

    /**
     * @param args the command line arguments
     */
    static int end=51304566;//human chr22
    static int samples=4;
    static StringBuffer str = new StringBuffer("");
    static String output = "/Users/gpavlopo/Desktop/Meander/chr22/chr22_artficial_4_samples.txt";
    public static void main(String[] args) {
        
        Random random = new Random();
        
//        for (int i = 0; i < 10; i++) {
//			         System.out.println(anyRandomIntRange(random, 1, 20));
//            
//		}
        output = "/Users/gpavlopo/Desktop/Meander/chr22/chr22_artficial_"+samples+"_samples.txt";
    
        if(samples==4)
            str.append("position\treference\tsample1\tsample2\tsample3\tsample4\n");
        if(samples==3)
            str.append("position\treference\tsample1\tsample2\tsample3\n");
        if(samples==2)
            str.append("position\treference\tsample1\tsample2\n");
        if(samples==1)
            str.append("position\treference\tsample1\n");
        
        
        
        write_file("", output);
        for (int i = 1; i <= end; i++) {
            int value_ref= anyRandomIntRange(random, 1, 20);
            int value1=anyRandomIntRange(random, 1, 20);
            int value2=anyRandomIntRange(random, 1, 20);
            int value3=anyRandomIntRange(random, 1, 20);
            int value4=anyRandomIntRange(random, 1, 20);
            if(samples==4)
            str.append(""+i+"\t"+value_ref+"\t"+value1+"\t"+value2+"\t"+value3+"\t"+value4+"\n");
            
            if(samples==3)
            str.append(""+i+"\t"+value_ref+"\t"+value1+"\t"+value2+"\t"+value3+"\n");
            
            if(samples==2)
            str.append(""+i+"\t"+value_ref+"\t"+value1+"\t"+value2+"\n");
            
            if(samples==1)
            str.append(""+i+"\t"+value_ref+"\t"+value1+"\n");
            
            if(i%100000==0){
                append_file(str.toString(), output);
                str.setLength(0);
            }
                
            
        }
        append_file(str.toString(), output);
    }
    public static int anyRandomInt(Random random) {
		int randomInt = random.nextInt();
                return randomInt;
		//System.out.println("random integer:" + randomInt);
	}

	public static int anyRandomIntRange(Random random, int low, int high) {
		int randomInt = random.nextInt(high) + low;
                return randomInt;
		//System.out.println("random integer from " + low + " to " + high + ":" + randomInt);
	}
    
     //This method creates a file with the content of the buffer
    public static void write_file(String buffer, String filename) {
        try {
            FileWriter fstream = new FileWriter(filename);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(buffer);
            out.close();


        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();


        }
    }

    public static void append_file(String buffer, String filename) {
        try {
            boolean append = true;
            FileWriter fw = new FileWriter(filename, append);

            fw.write(buffer);//appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
