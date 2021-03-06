public class ArrayDeque<T> {
	private T[] items;
	private final int startSize = 8;
	private int size;
	private int front, rear;


	public ArrayDeque() {
		items = (T[]) new Object[startSize];
		front = rear = 0;
		size = 0;
	}


	public void resize(int newSize) {

		T[] newItems = (T[]) new Object[newSize];
		if (front >= rear) {
			System.arraycopy(items, front, newItems, 0, items.length - front);
			System.arraycopy(items, 0, newItems, items.length - front, rear);
		} else {
			System.arraycopy(items, front, newItems, 0, size);
		}

		items = newItems;

	}

	public void contract() {
		double ratio = (double) size / items.length;
		if (ratio < 0.25) {
			int newSize = items.length / 2;
			resize(newSize);
		}
	}

	public void addFirst(T item) {

		if (size == items.length) {
			resize(items.length * 2);
		}

		front = (front - 1 + items.length) % items.length;
		items[front] = item;
		size += 1;

	}

	public void addLast(T item) {

		if (size == items.length) {
			resize(items.length * 2);
		}

		rear = (rear + 1) % items.length;
		items[rear] = item;
		size += 1;

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {

		int currentIndex = front;
		while (currentIndex != rear) {
			System.out.println(items[currentIndex] + " ");
			currentIndex = (currentIndex + 1) % items.length;
		}
		System.out.println();

	}

	public T removeFirst() {

		if (isEmpty()) {
			return null;
		}
		T removed = items[front];
		front = (front + 1) % items.length;
		size -= 1;
		contract();

		return removed;
	}

	public T removeLast() {

		if (isEmpty()) {
			return null;
		}

		T removed = items[rear];
		rear = (rear - 1 + items.length) % items.length;
		size -= 1;
		contract();

		return removed;

	}

	public T get(int index) {
		if (index > size) {
			return null;
		}

		return items[(front + index) % items.length];
	}

}
