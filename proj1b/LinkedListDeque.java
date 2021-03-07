public class LinkedListDeque<T> implements Deque<T> {

	private IntNode sentinel;
	private int size;

	private class IntNode {

		private T item;
		private IntNode next;
		private IntNode prev;

		IntNode(T i, IntNode n, IntNode p) {
			item = i;
			next = n;
			prev = p;
		}

	}

	/**
	 * Create an empty linked list deque
	 */
	public LinkedListDeque() {
		sentinel = new IntNode(null, null, null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}



	/**
	 * Return the number of items in the deque
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if deque is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {

		return size == 0;
	}


	/**
	 * Add an item to the front of the deque
	 *
	 * @param item: item to be added to the front of the deque
	 */
	@Override
	public void addFirst(T item) {

		size += 1;
		IntNode p = new IntNode(item, sentinel.next, sentinel);
		sentinel.next = p;
		p.next.prev = p;
	}

	/**
	 * Adds an item of type T to the back of the deque.
	 */
	@Override
	public void addLast(T item) {

		size += 1;
		IntNode p = new IntNode(item, sentinel, sentinel.prev);
		sentinel.prev = p;
		p.prev.next = p;

	}

	/**
	 * Prints the items in the deque from first to last, separated by a space.
	 * Once all the items have been printed, print out a new line.
	 */
	@Override
	public void printDeque() {

		IntNode p = sentinel;

		while (p.next != sentinel) {

			System.out.print(p.next.item + " ");
			p = p.next;
		}
		System.out.println("");
	}

	/**
	 * Removes and returns the item at the front of the deque. If no such item exists, returns null.
	 */
	@Override
	public T removeFirst() {

		if (isEmpty()) {
			return null;
		}

		size -= 1;
		T remove = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		return remove;

	}

	/**
	 * Removes and returns the item at the back of the deque. If no such item exists, returns null..
	 */
	@Override
	public T removeLast() {

		if (isEmpty()) {
			return null;
		}

		size -= 1;
		T remove = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		return remove;

	}

	/**
	 * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
	 * If no such item exists, returns null. Must not alter the deque!.
	 */
	@Override
	public T get(int index) {

		if (index >= size()) {
			return null;
		}
		IntNode p = sentinel.next;

		while(p != sentinel){
			if(index == 0){
				return p.item;
			}
			p = p.next;
			index--;
		}

		return null;

	}

	/**
	 * Same as get, but uses recursion.
	 */

	private T getRecursiveHelper(int index, IntNode p) {
		if (index == 0) {
			return p.item;
		}

		return getRecursiveHelper(index - 1, p.next);
	}

	public T getRecursive(int index) {

		if (index >= size()) {
			return null;
		} else {
			return getRecursiveHelper(index, sentinel.next);
		}
	}
}
