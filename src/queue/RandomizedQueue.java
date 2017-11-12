package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int size;

	public RandomizedQueue() {
		this.size = 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new IllegalArgumentException("item illegal to enqueue!");
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		size++;
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("No element!");
		int idx = StdRandom.uniform(0, size);
		if (idx == 0) {
			Node<Item> remove = first;
			first = remove.next;
			Item item = remove.item;
			size--;
			return item;
		}
		int i = 0;
		Node<Item> node = first;
		while (i < size - 1) {
			if (i == idx - 1) {
				Node<Item> remove = node.next;
				node.next = remove.next;
				Item item = remove.item;
				remove.next = null;
				size--;
				return item;
			}
			i++;
			node = node.next;
		}
		return null;
	}

	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException("No element!");
		int idx = StdRandom.uniform(0, size);
		int i = 0;
		while (i < size) {
			for (Iterator<Item> it = iterator(); it.hasNext();) {
				Item item = it.next();
				if (i == idx) {
					return item;
				}
				i++;
			}
		}
		return null;
	}

	@Override
	public Iterator<Item> iterator() {
		return new RandomQueueIterator();
	}

	private class Node<Item> {
		Item item;
		Node<Item> next;

		public Node() {
		}
	}

	private class RandomQueueIterator implements Iterator<Item> {

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

	public static void main(String[] args) {
		RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		rq.enqueue(40);
		System.out.println(rq.dequeue());
		rq.enqueue(835);
		System.out.println(rq.isEmpty());
		System.out.println(rq.dequeue());
		rq.enqueue(864);
		rq.enqueue(929);
		rq.enqueue(490);
		System.out.println(rq.dequeue());
		System.out.println(rq.sample());
	}
}
