package queue;

public class Queue<Item> {
	private LinkedStack<Item> first = new LinkedStack(), last = new LinkedStack();

	public boolean isEMpty() {
		return last.isEMpty();
	}

	public void enqueue(Item item) {
		Item pre = first.pop();
		last.push(pre);
		first.push(item);
	}

	public Item dequeue() {
		return last.pop();
	}
}

class LinkedStack<Item> {
	private Node<Item> first = null;

	public boolean isEMpty() {
		return first == null;
	}

	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
}

class Node<Item> {
	Item item;
	Node<Item> next;
}