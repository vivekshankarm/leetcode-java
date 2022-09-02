package Test;

// A simple enum example where enum is declared
// outside any class (Note enum keyword instead of
// class keyword)
enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class TestEnum {

// enum declaration inside a class.
	enum Color {
		RED, GREEN, VIOLET, BLUE;
	}

	public static void main(String[] arg) {
		Day x = Day.SUNDAY;
		System.out.println(x);
		System.out.println();

		for (Day i : Day.values()) {
			System.out.println(i);
		}

		Color y = Color.BLUE;
		System.out.println(y);
	}
}
