package company.fanxing;

public class Util {

    public static <K,V> boolean compare(Pair p1, Pair p2){


        return p1.getKey().equals(p2.getKey())&&
                p1.getValue().equals(p2.getValue());
    }

    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static <T extends Comparable<T>> int coutThann(T[] anArray, T elem){
        int count = 0 ;
        for (T e : anArray)
        {
            if (e.compareTo(elem) > 0)
                ++count;
        }
        return count;
    }


    public static class Pair<K,V>{
        private K key;
        private V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public void setKey(K key) { this.key = key; }
        public void setValue(V value) { this.value = value; }
        public K getKey()   { return key; }
        public V getValue() { return value; }
    }

}


