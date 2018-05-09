package singleton;

class Incremental {
	private static Incremental singletonInstance;
	private static int count = 0;
	private int numero;

	private Incremental() {
		numero = ++count;
	}

	synchronized static Incremental getInstance() {
		if (singletonInstance == null)
			singletonInstance = new Incremental();

		return singletonInstance;
	}

	public String toString() {
		return "Incrementando: " + numero;
	}
}

public class TesteIncremental {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Incremental inc = Incremental.getInstance();
			System.out.println(inc);
		}
	}
}
