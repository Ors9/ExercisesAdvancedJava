import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

public class Exercise2_reduceStack {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(10);
        st.push(3);
        st.push(8);
        st.push(1);

        System.out.println("Original stack (top to bottom): " + st);
        Stack<Integer> result = reduceStack(st, 5);
        System.out.println("Filtered stack (<= 5): " + result);
    }
	
	
	public static  <T extends Comparable<T>> Stack <T> reduceStack(Stack <T> st  , T item) {
		Stack <T> temp = new Stack<T>();
		
		while(!st.isEmpty()) {
			T tempItem = st.pop();
			if(tempItem.compareTo(item) <= 0){
				temp.push(tempItem);
			}
			
		}
		
		while(!temp.isEmpty()) {
			st.push(temp.pop());
		}
		
		return st;
		
	}
	
	public interface ColoredShape {
	    Color getColor();
	}
	
	public ColoredShape myMethodNoGeneric(ArrayList<? extends ColoredShape> cs , Color color) {
		
		for (ColoredShape shape : cs) {
		    if (shape.getColor().equals(color)) {
		        return shape;
		    }
		}
		return null;
		
	}
	
}
