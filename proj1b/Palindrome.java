public class Palindrome{
    /**
     * Given a String,
     * returns a Deque where the characters appear in the same order as in the String.
     * */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> res = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            res.addLast(word.charAt(i));
        }
        return res;
    }

    private boolean isPalindromeHelper(Deque<Character> word, int begin, int end){
        if (begin >= end){
            return true;
        }
        if(word.removeFirst() != word.removeLast()){
            return false;
        }
        begin++;
        end--;
        return isPalindromeHelper(word,begin,end);
    }
    public boolean isPalindrome(String word){
        Deque<Character> deque = wordToDeque(word);
        return isPalindromeHelper(deque,0,deque.size()-1);

    }
}