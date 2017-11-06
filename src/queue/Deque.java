package queue;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node<Item> first,oldFirst,last, oldLast;
	
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
		first = new Node<>(item);
		first.next = oldFirst;
		oldFirst = first;
	}

	public void addLast(Item item) throws IllegalArgumentException{
		if(item == null) throw new IllegalArgumentException ("item illegal to addLast!");
		last = new Node<>(item);
		last.next = oldLast;
		oldLast = last;
	}

	public Item removeFirst() throws NoSuchElementException{
		if(first == null) throw new NoSuchElementException("No element first to remove!");
		oldFirst = first.next;
		first.next = null;
		return oldFirst.item;
	}

	public Item removeLast() throws NoSuchElementException{
		if(last == null) throw new NoSuchElementException("No element last to remove!");
		oldLast = last.next;
		last.next = null;
		return oldLast.item;
	}

	public Iterator<Item> iterator() {
		return null;
	}
	
	private class Node<Item>{
		Item item;
		Node<Item> next;
		public Node(Item item) {
			super();
			this.item = item;
		}
	}
	
	public static void main(String[] args){
		
	}

}
