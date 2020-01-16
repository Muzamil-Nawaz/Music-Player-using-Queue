package dsaproject ;
class LinkedQueue implements Queue{
        static LinkedQueue lq;
	class Node{
		Node next = this,prev = this;
		Object obj;
		Node(Object obj){
			this.obj = obj;
		}
		Node(Object obj , Node next, Node prev){
			this.obj = obj;
			this.next = next;
			this.prev = prev;
		}

	}
	private int size;
        Node head = new Node(null );
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void add(Object obj){
		head.prev = head.prev.next = new Node(obj , head, head.prev);
		++size;
	}
	public Object first(){
		if(size == 0)
		throw new IllegalStateException("Queue is Empty ");
		return head.next.obj;
	}
	public Object remove(){
		Object tempObj = head.next.obj;
		head.next = head.next.next;
		head.next.prev = head;
		--size;
		return tempObj;
	}
        public Object goForward(Object obj2, LinkedQueue lq){
            Node temp = lq.head.next;
            while(temp.obj  != null){
                if(temp.next == null)
                    return lq.first();
                if(temp.obj.toString().length() == obj2.toString().length()){
                    obj2 = temp.next.obj;
                    break;        
                }
                temp = temp.next;
             }
             return obj2;
        }
        public Object goBackward(Object obj2, LinkedQueue lq){
            Node temp = lq.head.next;
            while(temp.obj  != null){
                if(temp.prev == null)
                    return temp.prev.prev;  
                System.out.println(1);
                if(temp.obj.toString().length() == obj2.toString().length()){
                    System.out.println(2);
                    obj2 = temp.prev.obj;
                    break;        
                }
                temp = temp.next;
        }
          
            return obj2;       
        }
	
	

}
