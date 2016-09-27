package classExercise;

// In-class Exercise on 09/19/2016
public class SimpleIntList implements Cloneable {

	private static class Node{
		private int data;
		private Node link;
		
		public Node (int e, Node p) {
			data = e;
			link = p;
		}
		
		public int getData() { return data; }
		public Node getLink() { return link; }
		public void setData(int e) { data = e; }
		public void setLink(Node p) { link = p; }
	}
	
	private Node head;
	private Node tail;
	private int size;   
	
	// no-args constructor
	public SimpleIntList(){
		head = null;
		tail = null;
		size = 0;
	}
	
	// add a new node with e to the head
	public void addToHead(int e){
		head = new Node(e, head);
		if (tail == null)
			tail = head;
		size++;
	}
	
	// add a new node with e to the tail
	public void addToTail(int e){
		Node p = new Node(e, null);
		if (tail != null){
			tail.setLink(p);
		}
		else{
			head = p;
		}
		tail = p;
		size++;
	}
	
	// remove and return the first node from the list
	public Node removeFromHead(){
		// complete this method
		if(head == null){
			System.err.println("List is empty");
			return null;
		}
		
		head = head.getLink();
		size--;
		if(size == 0){
			tail = null;
		}
		return head;// to compile
	}

	// remove and return the last node from the list
	public Node removeFromTail(){
		// complete this method
		if(head == null){
			System.err.println("List is empty");
			return null;
		}
		Node dummy = new Node(0, head);
		Node pre = dummy, cur = head;
		while(cur.link != null){
			pre = cur;
			cur = cur.link;
		}
		pre.link = null;
		tail = pre;
		size--;
		if(size == 0){
			tail = null;
			head = null;
		}
		return tail; // to compile
	}
	
	// add a new node with e after the node p
	public void addAfter(Node p, int e){
		// complete this method
		if(p == null){
			System.err.println("Input node is null.");
			return;	//p is invalid
		}
		Node cur = head;
		while(cur != p && cur != null){
			cur = cur.link;
		}
		if( cur != p){
			System.err.println("Cannot find node in the list.");
			return;	//p is not in the list
		}
		size++;
		Node node = new Node(e, p.link);
		p.link = node;
	}
	
	
	// print the size of the list and all elements in the list separated by spaces 
	public void printList(){
		System.out.print("\nSize = " + size + ", List is: ");
		if (head != null){
			Node current = head;
		    while (current != null){
			   System.out.print(current.getData() + " ");
			   current = current.getLink();
		   }
		}
		else {
			System.out.print("The list is empty");
		}
	}
	
	public void addBefore(Node p, int e){
		if(p == null){
			System.err.println("Input node is null");
			return;
		}
		if(p == head){
			size++;
			Node n = new Node(e, p);
			head = n;
			return;
		}
		if(size == 0){
			System.err.println("List is empty");
			return;
		}
		Node cur = head;
		while(cur.link != null && cur.link != p){
			cur = cur.link;
		}
		if(cur.link == p){
			size++;
			Node n = new Node(e, p);
			cur.link = n;
		}else{
			System.err.println("Input node is not in the list.");
		}
	}
	
	public Node findNode(Node p, int e){
		if(p == null){
			System.err.println("Input node is null");
			return null;
		}
		Node cur = head;
		while(cur != null && cur != p){
			cur = cur.link;
		}

		while(cur != null){
			if(cur.data == e){
				return cur;
			}
			cur = cur.link;
		}
		System.out.println("Result not found.");
		return null;
	}
	
	public Node findNodePos(int e, int n){
		if(n<=0){
			System.err.println("Input n is invalid");
			return null;
		}
		int count = 1;
		Node cur = head;
		while(cur != null){
			if(cur.data == e && count == n){	//Found 
				return cur;
			}else if(cur.data == e){
				count++;
			}
			cur = cur.link;
		}
		System.out.println("Cannot found the result.");
		return null;
	}
	
	@Override
	public SimpleIntList clone() throws CloneNotSupportedException{
		SimpleIntList list = new SimpleIntList();
		list.size = 0;
		if(this.size == 0){
			return list;
		}
		list.head = new Node(this.head.data, null);
		list.size = 1;
		Node pre = list.head;
		Node cur = this.head.link;
		
		while(cur != null){
			list.size++;
			Node cp = new Node(cur.data, null);
			pre.link = cp;
			pre = cp;
			cur = cur.link;
		}
		list.tail = pre;
		return list;
	}
	
	// main method to test SimpleIntList
	public static void main(String[] args) throws CloneNotSupportedException {
		
		SimpleIntList myList = new SimpleIntList();
		myList.printList();
		myList.addToHead(60);
		myList.printList();
		myList.addToHead(40);
		myList.printList();
		myList.addToHead(20);
		myList.printList();
		myList.addToTail(80);
		myList.printList();
		myList.addToTail(100);
		myList.printList();
		myList.addToTail(120);
		myList.printList();	
		myList.addAfter(myList.tail, 10);
		myList.printList();
		myList.addAfter(myList.head, 30);
		myList.printList();
		
		System.out.println("Starting new list:");
		SimpleIntList newList = myList.clone();
		newList.addBefore(newList.head, 90);
		newList.printList();
		Node insert = newList.findNode(newList.head, 20);
		insert = newList.findNodePos(100, 1);
		newList.addAfter(insert, 19);
		System.out.println("\nThe origin list:");
		myList.printList();
		System.out.println("\nThe new list:");
		newList.printList();
		
	}
}
