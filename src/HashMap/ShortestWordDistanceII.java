package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.
//Implement the WordDistance class:
//WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
//int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.
public class ShortestWordDistanceII {
    String[] wordsDict;
    HashMap<String, List<Integer>> map = new HashMap<>();

    public ShortestWordDistanceII(String[] wordsDict) {
        this.wordsDict = wordsDict;
        for(int i = 0; i < wordsDict.length; i++){
            if(!map.containsKey(wordsDict[i])){
                map.put(wordsDict[i], new ArrayList<>());
            }
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int shortestDist = Integer.MAX_VALUE, i = 0, j = 0, m = map.get(word1).size(), n = map.get(word2).size();

        while(i < m && j < n){
            shortestDist = Math.min(Math.abs(map.get(word1).get(i) - map.get(word2).get(j)), shortestDist);
            if(map.get(word1).get(i) >= map.get(word2).get(j))
                j++;
            else i++;
        }
        return shortestDist;
    }
}
