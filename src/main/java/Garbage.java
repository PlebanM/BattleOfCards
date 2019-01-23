public class Garbage {
	private int id;
	private String name;
	private int smell;
	private int recyclingTime;
	private int junkValue;
	private int weight;

	public Garbage(String name, int smell, int recyclingTime, int junkValue, int weight) {
		this.name = name;
		this.smell = smell;
		this.recyclingTime = recyclingTime;
		this.junkValue = junkValue;
		this.weight = weight;
	}

	public Garbage(int id, String name, int smell, int recyclingTime, int junkValue, int weight) {
		this(name, smell, recyclingTime, junkValue, weight);
		this.id = id;
	}

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSmell() {
		return smell;
	}

	public void setSmell(int smell) {
		this.smell = smell;
	}

	public int getRecyclingTime() {
		return recyclingTime;
	}

	public void setRecyclingTime(int recyclingTime) {
		this.recyclingTime = recyclingTime;
	}

	public int getJunkValue() {
		return junkValue;
	}

	public void setJunkValue(int junkValue) {
		this.junkValue = junkValue;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Garbage{" +
				"name='" + name + '\'' +
				", smell=" + smell +
				", recyclingTime=" + recyclingTime +
				", junkValue=" + junkValue +
				", weight=" + weight +
				'}';
	}
}
