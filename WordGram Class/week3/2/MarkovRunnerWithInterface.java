
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void testHashMap(){
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        //String st = "yes-this-is-a-thin-pretty-pink-thistle";
        int size = 20;
        
        EfficientMarkovModel me = new EfficientMarkovModel();
        me.setN(5);
        me.setTraining(st);
        me.setRandom(531);
        me.getRandomText(size);
        //runModel(me, st, size,531);
        me.printHashMapInfo();
    }

    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 50;
        
        // MarkovZero mz = new MarkovZero();
        // runModel(mz, st, size,1);
    
        // MarkovOne mOne = new MarkovOne();
        // runModel(mOne, st, size,365);
        
        MarkovModel mThree = new MarkovModel();
        mThree.setN(6);
        runModel(mThree, st, size,792);
        
        // MarkovFour mFour = new MarkovFour();
        // runModel(mFour, st, size,715);

    }
    

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
