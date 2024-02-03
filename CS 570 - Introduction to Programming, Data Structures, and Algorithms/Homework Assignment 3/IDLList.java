import java.util.*;

public class IDLList<E> {
    
    private class Node<E>{
        private E data;
        private Node<E> next, prev;
        private Node(E elem){
            this.data=elem;
            this.next=null;
            this.prev=null;
        }
        private Node(E elem, Node<E> next, Node<E> prev){
            this.data = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indices;

    public IDLList(){
        head = null;
		tail = null;
        size=0;
		indices = new ArrayList<Node<E>>();
    }

    // Adds elem at given index
    public boolean add (int index, E elem){
        if(index==0) {
			add(elem);
            return true;
		}
        if(index+1<=size && index>0){
            Node<E> newNode = new Node<>(elem, indices.get(index).prev, indices.get(index));
			indices.get(index).prev.next = newNode;
			indices.get(index).prev = newNode;
			indices.add(index, newNode);
			size++;
			return true;

		} 
        else if(index==size){
            append(elem);
            return true;
        }
        else {
			throw new ArrayIndexOutOfBoundsException("Index doesn't exist: "+index);
		}
    }

    // Adds elem at head
    public boolean add (E elem){
        
        Node<E> newNode = new Node<>(elem);
        if(head==null){
            head=newNode;
			tail=newNode;
			size++;
            indices.add(0, newNode);
            return true;
        }
        else{
		    size++;
		    head.next.prev = newNode;
		    head.next = newNode;
		    indices.add(0, newNode);
		    return true;
    }
    }

    // Adds elem at end of the list
    public boolean append (E elem){
        if(head==null){
            add(elem);
            return true;
        }
        else{
        Node<E> newNode= new Node<E>(elem, tail, tail.prev);
        size++;
        tail.next=newNode;
        tail.prev = newNode;
        tail=newNode;
		indices.add(newNode);
		return true;
        }
    }

    // Returns object at given index
    public E get(int index){
        if(index<0){throw new ArrayIndexOutOfBoundsException("Index doesn't exist: "+index);}
        else
            return indices.get(index).data;
    }

    // Returns head element
    public E getHead () {
        if(size==0){throw new ArrayIndexOutOfBoundsException("there are no elements");}
        return indices.get(0).data;
    }

    // Returns last element
    public E getLast() {
        if(size==0){throw new ArrayIndexOutOfBoundsException("there are no elements");}
		return indices.get(size-1).data;
	}
	
    // Returns size of the list
	public int size() {
		return size;
	}

    // Removes the object from the head
    public E remove(){
    
        if(size==0)
		{
			throw new ArrayIndexOutOfBoundsException("there are no elements");
		}
		
		if(head==tail) {
			head=null;
			tail=null;
			indices.remove(0);
            size--;
			return head.data;
		}
		else
		{
            Node<E> d= indices.get(0);
		    head=head.next; 
		    indices.remove(0);
            size--;
		    return d.data;
	    }

    }

    // Removes the last element
    public E removeLast(){
        if(head==tail){
            head=null;
			tail=null;
			indices.remove(0);
            size--;
			return head.data;
        }
        if(size>0){
            Node<E> temp = indices.get(size-1);
            indices.get(size-1).prev.next = tail;
            tail.prev = indices.get(size-1).prev;
			indices.remove(size-1);
			size--;
			return temp.data;
		} else {
			throw new ArrayIndexOutOfBoundsException("Does not have any elements.");
		}
    }

    // Removes the element from given index
    public E removeAt(int index) {
        if(index==0){
			return remove();
        }
		if(index==size-1) {
			return removeLast();
		}
		if (size > index) {
			E data = indices.get(index).data;
			indices.get(index).prev.next = indices.get(index).next;
			indices.get(index).next.prev = indices.get(index).prev;
			indices.remove(index);
			size--;
			return data;
		} else {
			throw new ArrayIndexOutOfBoundsException("Does not have index: "+index);
		}

	}

    // Returns true and removes the element if found
    // Else returns false
    public boolean remove(Object elem) {
		Node<E> current = head.next;
		for (int i = 0; i < size; i++) {
			if (current.data == elem) {
				removeAt(i);
                return true;
            }
			current = current.next;
		}
		return false;
	}
	
    // Converts list to string representation
	public String toString() {
		Node<E> StringNode;
		String list ="";
		for(int i=0 ; i<size ; i++)
		{
			StringNode = indices.get(i);
			list = list+StringNode.data+" ";
		}
	    return list;
	}
}
