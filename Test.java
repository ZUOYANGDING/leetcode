import java.util.*;

public class Test {
	public static void main(String[] args) {
		String temp1 = new String("abcd");
		String temp2 = new String("efg");
		ArrayList<String> temp = new ArrayList<>();
		temp.add(temp1);
		temp.add(temp2);
		System.out.println(temp);
		System.out.println(temp2);
		temp2 = "fgh";
		System.out.println(temp);
		System.out.println(temp2);
	}
}
