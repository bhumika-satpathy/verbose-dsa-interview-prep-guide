package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

// Reference video: https://www.youtube.com/watch?v=ZVJ3asMoZ18

// Note: BFS only works in this case because the minimum level is needed that suffices the condition.
// For every change, consider all the letter combinations that could be present in that particular place.
// Now after calculating, if that exists in the set, then add it to the queue and also remove this word from the set because this is the lowest level or hierarchy hat it reaches and
// any other word cannot possibly reach or will take more depth to reach here.

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet setOfWords = new HashSet<>();
        boolean isEndWordPresent = false;

        for(String word: wordList){
            if(endWord.equalsIgnoreCase(word)) {
                isEndWordPresent = true;
            }
            setOfWords.add(word);
        }

        // If end word is not present in the list, then return 0
        if(!isEndWordPresent) {
            return 0;
        }

        // Since length of all the words in the list is same, eachWordLength is same across all the words
        int eachWordLength = endWord.length();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Denotes all the words in a particular level belonging s=to the same adjacency list
        int levelSize = 0;

        // Tells about the depth of each node in the list
        int depth = 0;

        while(!queue.isEmpty()) {
            depth += 1;
            levelSize = queue.size();

            // Traverses over one level consisting of levelSize number of nodes
            while(levelSize > 0) {
                // Using the current word in the queue, we try to find all the adjacency words wrt this curr word among the set of words
                String curr = queue.poll();

                for(int i = 0; i < eachWordLength; i++) {

                    // Temporary string to make operations of addition of a character and deletion on
                    char[] temp = curr.toCharArray();

                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        temp[i] = ch;
                        String word = String.valueOf(temp);

                        // If the same word is come across then no need to process
                        if(curr.equals(word)) {
                            continue;
                        }

                        // If the endWord is already come across then return this shortest path using depth
                        if(word.equals(endWord)) {
                            // 1 is added to the depth to include the beginWord too in the list of words it takes to end with the endWord
                            return depth + 1;
                        }

                        // Check if this word is present inside the set to complete a level by changing one character
                        if(setOfWords.contains(word)) {
                            queue.add(word);
                            setOfWords.remove(word);
                        }
                    }
                }
                levelSize--;
            }
        }

        return 0;
    }
}
