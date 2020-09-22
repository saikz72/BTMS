package ca.mcgill.ecse.debugging;

public class Counter {

	private int result = 0;

	public int getResult() {
		return result;
	}

	public void count() {
		int k = 1 / 0;
		System.out.println(k);
		for (int i = 0; i < 100; i++) {
			result += i + 1;
		}
	}
	
}
