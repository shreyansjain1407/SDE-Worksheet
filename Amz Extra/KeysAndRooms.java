class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> avlKeys = new LinkedList<>();
        avlKeys.offer(0);
        while (!avlKeys.isEmpty()){
            int room = avlKeys.poll();
            if(visited.contains(room))continue;
            visited.add(room);
            avlKeys.addAll(rooms.get(room));
        }
        return visited.size() == rooms.size();
    }
}