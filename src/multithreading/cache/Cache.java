package multithreading.cache;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;


class Key implements Comparable<Key> {
    long weight;
    String name;

    public Key(String name) {
        this.weight = System.currentTimeMillis();
        this.name = name;
    }

    public int compareTo(Key that) {
        long diff = this.weight - that.weight;
        if(diff >0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Key that = (Key) obj;
        return this.name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

public class Cache {
    int capacity;
    TreeSet<Key> weights;
    Map<String, String> data;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DATA:\n");
        for(Map.Entry entry: data.entrySet()) {
            builder.append(entry.getKey()).append(" -> ").append(entry.getValue()).append("\n");
        }
        builder.append("WEIGHTS:\n");
        Iterator<Key> itr = weights.iterator();
        while(itr.hasNext()) {
            Key k = itr.next();
            builder.append(k.name).append(" -> ").append(k.weight).append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }

    public Cache(int capacity) {
        this.capacity = capacity;
        this.data = new HashMap<>();
        this.weights = new TreeSet<>();
    }

    private synchronized void evict() {
        data.remove(weights.first().name);
        weights.remove(weights.first());
    }

    private synchronized void updateWeight(String key) {
        Key k = new Key(key);
        weights.remove(k);
        weights.add(k);
    }

    public void put(String key, String value) {
        if(data.containsKey(key)) {
            updateWeight(key);
        } else {
            if(data.size() == capacity) {
                evict();
            }
            data.put(key, value);
            updateWeight(key);
        }
    }

    public String get(String key) {
        if(data.containsKey(key)) {
            updateWeight(key);
            return data.get(key);
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Cache cache = new Cache(3);
        Driver d0 = new Driver(cache, 0);
        Driver d1 = new Driver(cache, 1);
        d0.start();
        d1.start();
        d0.join();
        d1.join();
        System.out.println(cache);
    }
}

class Driver extends Thread {
    Cache cache;
    int id;

    public Driver(Cache cache, int id) {
        super(Integer.toString(id));
        this.cache = cache;
        this.id = id;
    }

    public void run() {
        for(int i = 0; i < 50; i ++) {
            int someVal = 10000 + i;
            if(id == 1 && i %2 == 0) {
                cache.put(Integer.toString(someVal), "ONIONS");
            } else {
                cache.put(Integer.toString(someVal), "POTATOES");
            }
            try {
                sleep(10L);
            } catch (InterruptedException e) {
            }
        }
    }
}
