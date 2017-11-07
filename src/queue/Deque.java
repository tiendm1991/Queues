package queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node<Item> first,last;
	
	public Deque(){
		
	}

	public boolean isEmpty(){
		return first == null;
	}

	public int size(){
		if(isEmpty()) return 0;
		int count = 0;
		for(Iterator<Item> it = iterator(); it.hasNext();){
			count++;
		}
		return count;
	}

	public void addFirst(Item item) throws IllegalArgumentException{
		if(item == null) throw new IllegalArgumentException ("item illegal to addFirst!");
		Node<Item> newFirst = new Node<>(item);
		newFirst.next = first;
		first.prev = newFirst;
		first = newFirst;
	}

	public void addLast(Item item) throws IllegalArgumentException{
		if(item == null) throw new IllegalArgumentException ("item illegal to addLast!");
		Node<Item> newLast = new Node<>(item);
		newLast.prev = last;
		last.next = newLast;
		last = newLast;
	}

	public Item removeFirst() throws NoSuchElementException{
		if(first == null) throw new NoSuchElementException("No element first to remove!");
		Node<Item> firstRemove = first;
		first = first.next;
		firstRemove.next = null;
		first.prev = null;
		return firstRemove.item;
	}

	public Item removeLast() throws NoSuchElementException{
		if(last == null) throw new NoSuchElementException("No element last to remove!");
		Node<Item> lastRemove = last;
		last = last.prev;
		lastRemove.prev= null;
		last.next = null;
		return lastRemove.item;
	}

	public Iterator<Item> iterator() {
		return new DequeueIterator();
	}
	
	private class Node<Item>{
		Item item;
		Node<Item> next;
		Node<Item> prev;
		public Node(Item item) {
			super();
			this.item = item;
		}
	}
	
	private class DequeueIterator implements Iterator<Item>{
		
		private Node<Item> current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("Not support remove mothod");
		}
		
	}
	
	public static void main(String[] args){
		
	}

}
