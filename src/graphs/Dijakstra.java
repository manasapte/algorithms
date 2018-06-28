package graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex>{
	int key;
	int name;
	
	public Vertex(int name, int key) {
		this.key = key;
		this.name = name;
	}
	
	public int key() {
		return this.key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	

	@Override
	public int compareTo(Vertex o) {
		if(key() < o.key()) {
			return -1;
		}
		if(key() > o.key()) {
			return 1;
		}
		return 0;
	}
	
	
}
public class Dijakstra {
	
	void dijakstra(int[][] graph, int src, int dest) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		Map<Integer, Vertex> vertices = new HashMap<Integer, Vertex>();
		int key;
		for(int i=0; i<graph.length; i++) {
			key = Integer.MAX_VALUE;
			if(i == src) {
				key = 0;
			}
			Vertex vertex = new Vertex(i, key);
			pq.add(vertex);
			vertices.put(i, vertex);
		}
		
		while(!pq.isEmpty()) {
			Vertex v = pq.remove();
			System.out.println("vertex popped: "+ v.name+ " and key: "+v.key());
			int[] neighbors = graph[v.name];
			for(int i=0; i< neighbors.length; i++) {
				int dist = neighbors[i]; 
				if( dist != 0) {
					if(vertices.get(i).key() > v.key() + dist) {
						System.out.println("updating the key of: "+i+" to: "+ (v.key() + dist));
						vertices.get(i).setKey(v.key() + dist);
						pq.remove(vertices.get(i));
						pq.add(vertices.get(i));
					}
				}
			}
		}
		System.out.println("dist of dest is: "+ vertices.get(dest).key());
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
               };
		Dijakstra d = new Dijakstra();
		d.dijakstra(graph, 0, 6);
	}
	
}
