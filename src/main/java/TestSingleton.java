public class TestSingleton {
	static private int test = 0;
	private TestSingleton() {
	}

	public TestSingleton getInstance() {
		if (test++ == 0) {
			return new TestSingleton();
		}
		return null;
	}
}
