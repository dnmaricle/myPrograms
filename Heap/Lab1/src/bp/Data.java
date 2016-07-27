package bp;

public class Data {
		public int value;
		public int priority = 5;
		//Make an array of these guys
		
		//constructor
		public Data(int pValue, int pPriority) {
			value = pValue;
			priority = pPriority;
			
		}
		
		public Data(int pValue) {
			value = pValue;
			priority = 5;
		}
		//public String toString
		// string build value, return value
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append((value));
			return sb.toString();
			
			
		}
}