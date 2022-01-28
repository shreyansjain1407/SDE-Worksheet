class Dijkstra {
    public void initiate(int nodes, List<List<List<Integer>>> adj, int src){
        int[] distance = new int[nodes];
        Arrays.fill(distance, 100000);
        distance[src-1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            System.out.println(curNode);
            for(List<Integer> dist: adj.get(curNode-1)){
                System.out.println(dist);
                if(distance[dist.get(0)-1] > distance[curNode-1] + dist.get(1)){
                    distance[dist.get(0)-1] = distance[curNode-1] + dist.get(1);
                    queue.add(dist.get(0));
                }
            }
        }

        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(){{
            add(Arrays.asList(2,2));
            add(Arrays.asList(4,1));
        }});
        adj.add(new ArrayList<>(){{
            add(Arrays.asList(1,2));
            add(Arrays.asList(5,5));
            add(Arrays.asList(3,4));
        }});
        adj.add(new ArrayList<>(){{
            add(Arrays.asList(2,4));
            add(Arrays.asList(4,3));
            add(Arrays.asList(5,1));
        }});
        adj.add(new ArrayList<>(){{
            add(Arrays.asList(1,1));
            add(Arrays.asList(3,3));
        }});
        adj.add(new ArrayList<>(){{
            add(Arrays.asList(2,5));
            add(Arrays.asList(3,1));
        }});

        new Dijkstra().initiate(5, adj, 1);
    }
}