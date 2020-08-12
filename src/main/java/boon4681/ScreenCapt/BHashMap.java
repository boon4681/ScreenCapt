package boon4681.ScreenCapt;

import java.util.HashMap;
import java.util.Set;

public class BHashMap<K,V> {
    private HashMap<K,V> c0 = new HashMap<K,V>();
    public BHashMap<K, V> add(K k,V v){
        this.c0.put(k,v);
        return this;
    }
    public Set<K> getKeySet() {
        return this.c0.keySet();
    }
    public V get(K key) {
        return this.c0.get(key);
    }
    public void show(){
        for (K k : this.c0.keySet()){
            System.out.println(this.c0.get(k));
        }
    }
}
