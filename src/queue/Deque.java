package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first, last;
	private int size;

	public Deque() {
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void addFirst(Item item) {
		if (item == null)
			throw new IllegalArgumentException("item illegal to addFirst!");
		Node<Item> newFirst = new Node<>(item);
		newFirst.next = first;
		if (first != null) {
			first.prev = newFirst;
		}
		first = newFirst;
		if (size == 0)
			last = first;
		size++;
	}

	public void addLast(Item item) {
		if (item == null)
			throw new IllegalArgumentException("item illegal to addLast!");
		Node<Item> newLast = new Node<>(item);
		newLast.prev = last;
		if (last != null) {
			last.next = newLast;
		}
		last = newLast;
		if (size == 0)
			first = last;
		size++;
	}

	public Item removeFirst() {
		if (first == null)
			throw new NoSuchElementException("No element first to remove!");
		Node<Item> firstRemove = first;
		first = first.next;
		firstRemove.next = null;
		if (first != null) {
			first.prev = null;
		}else {
			last = null;
		}
		size--;
		return firstRemove.item;
	}

	public Item removeLast() {
		if (last == null)
			throw new NoSuchElementException("No element last to remove!");
		Node<Item> lastRemove = last;
		last = last.prev;
		lastRemove.prev = null;
		if (last != null) {
			last.next = null;
		}else {
			first = null;
		}
		size--;
		return lastRemove.item;
	}

	public Iterator<Item> iterator() {
		return new DequeueIterator();
	}

	private class DequeueIterator implements Iterator<Item> {

		private Node<Item> current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null)
				throw new NoSuchElementException("No element first to remove!");
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not support remove mothod");
		}

	}

	private class Node<Item> {
		Item item;
		Node<Item> next;
		Node<Item> prev;

		public Node(Item item) {
			super();
			this.item = item;
		}
	}

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.removeFirst();
		deque.removeFirst();
		deque.removeFirst();
		System.out.println("Iterator");
		for(Iterator<Integer> it = deque.iterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}
}
