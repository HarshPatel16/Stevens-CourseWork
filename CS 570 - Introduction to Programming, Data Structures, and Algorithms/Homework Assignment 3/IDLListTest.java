/***
 * Assignment : Homework Assigment 3
 * Name: Harsh Patel
 * Course: CS-570
 */

public class IDLListTest {
    
    public static void main(String[] args){
        IDLList<Integer> l = new IDLList<Integer>();
        
        l.add(30); //Adds the element from head
        l.append(20); //Adds the element from tail
        l.add(34); 
        l.append(76);
        l.add(45);
        l.add(2,16); // Adds the element at given index
        l.add(2,68);

        try{
            l.add(40,23); // Adds the element at given index if list size is same or less than index 
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index");
        }

        try{
            l.add(-2,23);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index");
        }
        System.out.println("List of elements: " +l.toString());
    
        l.add(0,89);
        l.add(3,45);
        l.append(32);
        l.add(4,90);

        System.out.println("List of elements: " +l.toString());

        System.out.println("Element at the index 3 is "+ l.get(3)); // Returns element at given index

        try {
			System.out.println(l.get(-2)); //this will throw an exception because of the negative index
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println("Index out of bounds");
		}
        

        System.out.println("Element at head is "+l.getHead()); // head element of list

        System.out.println("Element at tail is "+l.getLast()); // tail element of list

        System.out.println("Size of the list: "+l.size()); // Size of the list

        System.out.println("Removing head element: " +l.remove()); // Removes the first element from head
        System.out.println("List after removing the element at the head: " +l.toString());

        System.out.println("Removing tail element: "+l.removeLast()); // removes the element from tail
		System.out.println("After removing the element at the end of the end : " + l.toString());

        System.out.println("Removing element from given index: " +l.removeAt(2)); // removes the element at given index
		System.out.println("After removing the element at the index 2 : "+l.toString());

        System.out.println("Element found: " +l.remove(45)); // Removes the element at given index and returns true if index not present returns false
		System.out.println("Element found: " +l.remove(200));

        System.out.println("List: " +l.toString());

    }
}
