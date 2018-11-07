
public class WordGram {
    private String[] myWords;
    private int myHash;
    private String partial;
    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
        for(int i=start; i < start + size; i++){
            partial += source[i];
        }
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method
        for(String s:myWords){
            ret +=s;
            ret += " ";
        }
        return ret.trim();
    }
    public String getString(){
        return partial;
    }
    public int hashCode(){
        return partial.hashCode();
    }
    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        if(this.length() != other.length()){
            return false;
        }
        for(int k=0; k < myWords.length; k++){
            if(!myWords[k].equals(other.wordAt(k))){
                return false;
            }
        }
        return true;
    }

    public WordGram shiftAdd(String word) { 
        String[] answer = new String[myWords.length];
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        for(int i=1; i<myWords.length; i++){
            answer[i-1] = myWords[i];
        }
        answer[myWords.length-1] = word;
        WordGram out = new WordGram(answer, 0, answer.length);
        return out;
    }

}