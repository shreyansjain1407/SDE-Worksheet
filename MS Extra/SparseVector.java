class Node{
    int index;
    int val;
    Node next;
    Node(){}
    Node(int val, int index){
        this.val = val;
        this.index = index;
    }
}
class SparseVector {
    Node head = new Node();
    SparseVector(int[] nums) {
        Node cur = head;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                cur.next = new Node(nums[i], i);
                cur = cur.next;
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Node cur = this.head.next;
        Node incoming = vec.head.next;
        int product = 0;
        while(cur != null && incoming != null){
            if(cur.index == incoming.index){
                product += cur.val * incoming.val;
                cur = cur.next; incoming = incoming.next;
            }else if(cur.index < incoming.index){
                cur = cur.next;
            }else{
                incoming = incoming.next;
            }
        }
        return product;
    }
}