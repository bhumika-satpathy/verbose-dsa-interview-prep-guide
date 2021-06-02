package Heap;

import java.util.*;

// Given a non-empty list of words, return the k most frequent elements.
//Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++){
            map.put(words[i], 1 + map.getOrDefault(words[i], 0));
        }

        // MinHeap implementation using a comparator via priority queue
        PriorityQueue<String> pQ = new PriorityQueue<String>((m1, m2) -> map.get(m1) == map.get(m2) ?
                m2.compareTo(m1) : map.get(m1) - map.get(m2));

        for(String word: map.keySet()){
            pQ.add(word);
            if(pQ.size() > k)
                pQ.poll();
        }

        List<String> ans = new ArrayList<>();

        while(!pQ.isEmpty()){
            ans.add(pQ.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
