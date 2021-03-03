public class LinkedListDeque<T>{

	private IntNode sentinel;
	private int size;

	public class IntNode{

		public T item;
		public IntNode next;
		public IntNode prev;

		public IntNode(T i, IntNode n, IntNode p){
			item = i;
			next = n;
			prev = p;
		}

	}

	/** Create an empty linked list deque */
	public LinkedListDeque(){
		sentinel = new IntNode(null, null , null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}



	/** Return the number of items in the deque */
	public int size(){
		return size;
	}
	/** Returns true if deque is empty, false otherwise. */
	public boolean isEmpty(){

		return size == 0;
	}


	/** Add an item to the front of the deque
	@param item: item to be added to the front of the deque
	*/
	public void addFirst(T item){

		size += 1;
		IntNode p = new IntNode(item, sentinel.next , sentinel);
		sentinel.next = p;
		p.next.prev = p;
	}

	/** Adds an item of type T to the back of the deque. */
	public void addLast(T item){

		size += 1;
		IntNode p = new IntNode(item, sentinel, sentinel.prev);
		sentinel.prev = p;
		p.prev.next = p;

	}

	/** Prints the items in the deque from first to last, separated by a space.
	Once all the items have been printed, print out a new line.*/

	public void printDeque(){

		IntNode p = sentinel;

		while(p.next != sentinel){

			System.out.print(p.next.item + " ");
			p = p.next;
		}
		System.out.println("");
	}

	/** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
	public T removeFirst(){

		if(isEmpty()){
			return null;
		}

		size -= 1;
		T remove = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		return remove;

	}

	/** Removes and returns the item at the back of the deque. If no such item exists, returns null.. */
	public T removeLast(){

		if(isEmpty()){
			return null;
		}

		size -= 1;
		T remove = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		return remove;

	}
	/** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
	If no such item exists, returns null. Must not alter the deque!. */

	public T get(int index){

		if(index >= size()){
			return null;
		}
		IntNode p = sentinel;
		for(int i = 0; i <= index; i++){
			p = sentinel.next;
		}

		return p.item;

	}

	/** Same as get, but uses recursion. */

	public T getRecursiveHelper(int index, IntNode p){
		if(index == 0){
			return p.item;
		}

		return getRecursiveHelper(index - 1, p.next);
	}

	public T getRecursive(int index){

		if(index >= size()){
			return null;
		}else{
			return getRecursiveHelper(index, sentinel.next);
		}
	}
}