class SortStack {
	public void setSortStack(Stack<Integer> stack){
		Stack<Integer> aux = new Stack<>();
		while(stack.size() != 0){
			Stack<Integer> temp = new Stack<>();
			if(aux.top() > stack.top()){
				aux.push(stack.pop());
			}else{
				while(!aux.isEmpty() && aux.top() > stack.top()){
					temp.push(aux.pop());
				}aux.push(stack.top());
				while(!temp.isEmpty()){
					aux.push(temp.pop());
				}
			}
		}
	}
}