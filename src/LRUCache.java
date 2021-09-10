import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node<T>{
	
	String key;
	T value;
	Node next;
	Node prev;
	
	public Node(String key, T value){
		this.key = key;
		this.value = value;
	}
	
	public Node() {
		this.key="";
		this.value=null;
	}
}


class LinkedList{
	Node head;
	Node tail;
	int count;
	
	public LinkedList() {
		head = new Node();
		tail = new Node();
		
		head.next = tail;
		tail.prev = head;
		count =0;
	}
	
	Node front() {
		return head.next;
	}
	
	Node last() {
		return  tail.prev;
	}
	
	void insert_between(Node prev, Node new_node, Node next) {
		prev.next = new_node;
		next.prev = new_node;
		
		new_node.next = next;
		new_node.prev = prev;
		
		++count;
	}
	
	void push_front(Node new_node) {
		insert_between(this.head, new_node, this.head.next);
	}
	
	Node remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		--count;
		return node;
	}
	
	Node remove_last() {
		return remove(last());
	}
	
}

public class LRUCache<T> {
	int size;
	LinkedList linked_list;
	Map<String, Node> dicc;
	
	public LRUCache(int n) {
		this.size =n;
		dicc = new HashMap<String, Node>();
		linked_list = new LinkedList();
	}
	
	List<String> get_all_keys(){
		if(linked_list.front()== null)
			return null;
		
		List<String> listKey = new ArrayList<String>();
		for (String key : dicc.keySet()) {
			listKey.add(key);
		}
		Collections.reverse(listKey);
		return listKey;
		
	}
	
	void push(String key, T value) {
		Node new_node = new Node(key, value);
		if(dicc.size() < size) {
			linked_list.push_front(new_node);
			dicc.put(key,new_node);
		
			
		}else{
			linked_list.push_front(new_node);
			Node last = linked_list.remove_last();
			dicc.remove(last.key);
			dicc.put(key, new_node);
		}
	}

	 T get_value_from_key(String key) {
		if(dicc.get(key)==null)
			return null;
				
		Node old_node = dicc.get(key);
		linked_list.remove(old_node);
		Node new_node = new Node(old_node.key, old_node.value);
		linked_list.push_front(new_node);
		return (T) new_node.value;
		
	}
	
	String get_most_recent_key() {
		if(linked_list.front()!= null) 
			return linked_list.front().key;
		return "";
	}
	
	
}
