package HashMap;

import java.util.HashMap;

public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }

        String curr, prev = words[0];
        for(int i = 1; i < words.length; i++){
            curr = words[i];
            if(map.get(prev.charAt(0)) > map.get(curr.charAt(0)))
                return false;
            if(map.get(prev.charAt(0)) == map.get(curr.charAt(0))){
                int k = 1, j = 1;
                while(k < prev.length() && j < curr.length() && prev.charAt(k) == curr.charAt(j)){
                    k++;
                    j++;
                }
                if(k < prev.length() && j < curr.length()){
                    if(map.get(prev.charAt(k)) > map.get(curr.charAt(j)))
                        return false;
                }
                else if(k < prev.length()){
                    return false;
                }
            }
            prev = curr;
        }

        return true;
    }
}
