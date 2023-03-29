package company.yuanma.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K,V> {

    private final int MAX_CACHE_SIZE;
    private final float LOAD_FACTOR =0.75f;
    LinkedHashMap<K, V> map;

    public LRUCache1(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        int capcity = (int)Math.ceil(cacheSize/LOAD_FACTOR)+1;
        //根据访问顺序和先入先出
        map = new LinkedHashMap(capcity,LOAD_FACTOR,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()> cacheSize;
            }
        };

        //先入先出
        map = new LinkedHashMap(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size()> cacheSize;
            }
        };
    }

    public synchronized void put(K key,V value){
        map.put(key, value);
    }

    public synchronized V get(K key){
       return map.get(key);
    }

    public synchronized V remove(K key){

        return map.remove(key);
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
