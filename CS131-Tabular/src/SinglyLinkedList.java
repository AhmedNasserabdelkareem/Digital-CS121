

/**
 * @author Ahmednasser
 *
 */
public class SinglyLinkedList{
	public Node head = null;
	public int size = 0;


	public void add(int index, Object Value) {
		Node element = new Node();
		element.value = Value;
		if (index > size || index < 0) {
			throw null;
		} else if (index == 0) {

			element.next = head;
			head = element;
			size++;
		} else {
			Node temp = theElementBefore(index);
			element.next = temp.next;
			temp.next = element;
			size++;
		}
	}

	
	public void add(Object Value) {
		Node element = new Node();
		element.value = Value;
		if (size == 0) {
			head = element;
			head.next = null;
			size++;
		} else {
			Node temp = theElementBefore(size);
			temp.next = element;
			element.next = null;
			size++;
		}

	}

	
	public Object get(int index) {
		if (index<0){
			throw null;
		}
		Node temp = head;
		if (index < size) {
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		} else {
			throw null;
		}
		return temp.value;
	}

	
	public void set(int index, Object Value) {
		if (index<0){
			throw null;
		}
		Node element = new Node();
		element.value = Value;
		if (index < size && index != 0) {
			Node temp = theElementBefore(index);
			element.next = temp.next.next;
			temp.next = element;
		} else if (index == 0) {
			element.next = head.next;
			head = element;
		} else {
			throw null;
		}

	}

	
	public void clear() {
		if (size > 0) {
			head = null;// note here
			size = 0;
		} else {
			return;
		}
	}

	
	public boolean isEmpty() {
		boolean Empty = false;
		if (size == 0)
			Empty = true;
		return Empty;
	}

	
	public void remove(int index) {
		if (index >= size || index < 0) {// note here
			throw null;
		}
		if (index < size && size != 0 && index > 0) {
			Node temp = theElementBefore(index);
			Node removed = temp.next;
			temp.next = removed.next;
			size--;
		} else if (index == 0 && size != 0) {
			head = head.next;
			size--;
		}
	}

	
	public int size() {
		return size;
	}



	public boolean contains(Object o) {
		Node temp = head;
		if (size == 0) {
			//throw null;
		}
		for (int i = 0; i < size; i++) {
			if (o.equals(temp.value)) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public void addWithoutGrounding(Object Value) {
		Node element = new Node();
		element.value = Value;
		if (size == 0) {
			head = element;
			size++;
		} else {
			Node temp = theElementBefore(this.size);
			temp.next = element;
			size++;
		}
	}

	public Node theElementBefore(int index) {
		Node temp = head;
		for (int i = 0; i < index - 1; i++)
			temp = temp.next;
		return temp;
	}

	public void printList() {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(this.get(i) + " ");
			temp = temp.next;
		}
	}

}
