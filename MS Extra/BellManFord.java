import java.util.ArrayList;
import java.util.Arrays;

class Edge{
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

}

class BellManFord{
    public void initiate(int nodes, ArrayList<Edge> edges, int src){
        int[] distance = new int[nodes];
        Arrays.fill(distance, 100000);
        distance[src] = 0;
        for(int i = 0; i < nodes-1; i++){
            for(Edge edge : edges){
                if(distance[edge.u] + edge.weight < distance[edge.v]){
                    distance[edge.v] = distance[edge.u] + edge.weight;
                }
            }
        }
        for(Edge edge : edges){
            if(distance[edge.u] + edge.weight < distance[edge.v]){
                System.out.println("Negative cycle detected");
                break;
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(new Edge(3,2,6));
        edges.add(new Edge(5,3,1));
        edges.add(new Edge(0,1,5));
        edges.add(new Edge(1,5,-3));
        edges.add(new Edge(1,2,-2));
        edges.add(new Edge(3,4,-2));
        edges.add(new Edge(2,4,3));
        new BellManFord().initiate(6, edges, 0);
    }
}