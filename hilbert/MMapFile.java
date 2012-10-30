/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import experiments.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;public class MMapFile {

    public class MMapIterator implements Iterator<String> {
        private int offset;

        public MMapIterator(int offset) {
            this.offset = offset;
        }
        
        public boolean hasNext() {
            return offset < cb.limit();
        }

        public String next() {
            ByteArrayOutputStream sb = new ByteArrayOutputStream();
            if (offset >= cb.limit())
                throw new NoSuchElementException();
            for (; offset < cb.limit(); offset++) {
                byte c = (cb.get(offset));
                if (c == '\n') {
                    offset++;
                    break;
                }
                if (c != '\r') {
                    sb.write(c);
                }

            }
            try {
                return sb.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {}
            return sb.toString();
        }

        public void remove() {

        }
    }


    private ByteBuffer cb;
    long size;
    private long numLines = -1;
    
    public MMapFile(String file){
        try {
           FileChannel fc = new FileInputStream(new File(file)).getChannel();
        size = fc.size();
            System.out.println(size);
        cb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public long getNumLines() {
        if (numLines != -1) return numLines;  //cache number of lines
        long cnt = 0;
        for (int i=0; i <size; i++) {
            if (cb.get(i) == '\n')
                cnt++;
        }
        numLines = cnt;
        return cnt;
    }

    public Iterator<String> tail(long lines) {
        long cnt=0;
        long i=0;
        for (i=size-1; i>=0; i--) {
            if (cb.get((int)i) == '\n') {
                cnt++;
                if (cnt == lines+1)
                    break;
            }
        }
        return new MMapIterator((int)i+1);
    }

    public Iterator<String> head() {
        return new MMapIterator(0);
    }

    static public void main(String[] args) {
        
        String file = "/Users/gpavlopo/Desktop/Thierry/B8FB3A_B8FF4C_Chr19/B8FB3A_B8FF4C_Chr19.txt";
        
        
//        try {
//            Iterator<String> it = new MMapFile(file).head();
//            while (it.hasNext()) {
//                System.out.println(it.next());
//            }
//        } catch (Exception e) {
//            
//        }
//
//        System.out.println();

        try {
            Iterator<String> it = new MMapFile(file).tail(1);
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (Exception e) {

        }

        System.out.println();

        try {
            System.out.println("lines: "+new MMapFile("/test.txt").getNumLines());
        } catch (Exception e) {

        }

    }

}
