package Test;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] arg) {
		Map<Character, Integer> dic1 = new HashMap<Character, Integer>();
		dic1.put('a', 1);
		dic1.put('b', dic1.getOrDefault('b', 2));
		System.out.println(dic1.get('b'));
		System.out.println(dic1.get('c'));

		Map<Character, Integer> dic2 = Map.of('z', 4, 'y', 0, 'x', 2, 'p', 3);
		System.out.println(dic2);

		for (Map.Entry<Character, Integer> i : dic2.entrySet()) {
			System.out.println("dic2 key is " + i.getKey() + " dic2 value is " + i.getValue());
		}

		for (Character j : dic2.keySet()) {
			System.out.println("dic2 key is " + j + " dic2 value is " + dic2.get(j));
		}
		for (Integer k : dic2.values()) {
			System.err.println(k);
		}
	}
}
