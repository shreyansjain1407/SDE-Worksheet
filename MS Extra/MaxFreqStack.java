class Tuple{
    int val;
    Stack<Integer> timestamps = new Stack<Integer>();
    Tuple(int value, int time){
        this.val = value;
        timestamps.push(time);
    }
}
class MaxFreqStack {
    Map<Integer, Tuple> curFreq;
    Queue<Tuple> frequencies;
    int time = 0;
    public FreqStack() {
        frequencies = new PriorityQueue<>(new Comparator<Tuple>() {
            @Override
            public int compare(Tuple o1, Tuple o2) {
                if(o1.timestamps.size() == o2.timestamps.size()){
                    return o2.timestamps.peek() - o1.timestamps.peek();
                }else{
                    return o2.timestamps.size() - o1.timestamps.size();
                }
            }
        });
        curFreq = new HashMap<>();
    }

    public void push(int val) {
        Tuple temp;
        if(curFreq.containsKey(val)){
            temp = curFreq.get(val);
            frequencies.remove(temp);
            temp.timestamps.push(time++);
        }else{
            temp = new Tuple(val, time++);
            curFreq.put(val, temp);
        }
        frequencies.offer(temp);
    }

    public int pop() {
        System.out.println(curFreq);
        Tuple temp = frequencies.poll();
        if(temp.timestamps.size() == 1){
            curFreq.remove(temp.val);
        }else{
            temp.timestamps.pop();
            frequencies.offer(temp);
        }
        return temp.val;
    }
}