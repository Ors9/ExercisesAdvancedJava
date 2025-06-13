
public class UsingGenericMethod {
	private static SortedTable <String ,Integer> myTree;
	
	public static void main(String [] args) {
		String [] keys = {"Or" , "Maya" , "Liad"};
		Integer [] values = { 1000 , 5 , 999999999};
		
		myTree = new SortedTable<String, Integer>();
		
		for(int i = 0 ; i < keys.length ; i++) {
			try {
				myTree.add(keys[i], values[i]);
			} catch (AlreadyExistException e) {
				e.printStackTrace();
			}
		}
		
		myTree.display();
		
	}
}
