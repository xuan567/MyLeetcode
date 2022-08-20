package 剑指Offer;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    HashMap<Integer,Integer> map;
    LinkedList<Integer> list;
    int max;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        list=new LinkedList<>();
        max=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove((Integer) key);
            list.addLast(key);
            map.put(key,value);
            return;
        }
        if(list.size()==max){
            map.remove(list.removeFirst());
            map.put(key,value);
            list.add(key);
        }else{
            map.put(key,value);
            list.add(key);
        }
    }
}
