package enum1;

public enum Grade {

	GOLD("골드", 0.1), SILVER("실버", 0.05), BRONZE("브론즈", 0.0125);
	
	private String name;
	private double depositRate;
	
	private Grade(String name, double depositRate) {
		this.name = name;
		this.depositRate = depositRate;
	}
	
	public String getName() {
		return name;
	}
	
	public double getdepositRate() {
		return depositRate;
	}
}
