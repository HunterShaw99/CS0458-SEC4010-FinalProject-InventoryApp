package src.test.java.com.HarlanHunter.InventoryProject;

public class Main {

	public static void main(String[] args) {
		List<String> lst = new AList<>();
		Dictionary<String, Integer> dict = new HashDictionary<>();
		lst.add("Mike");
		lst.add("Joe");
		lst.add("Weirach");
		dict.put("Coffee", 12);
		dict.put("WATER", 79);
		dict.put("LaVa", 64);
		System.out.println(dict.size());
		System.out.println(lst.size());
	}

}
