package generic;

public class GenericBox<T> {

	private T data;
	
	public void add(T data) {
		this.data = data;
	}
	
	public T get() {
		return data;
	}
}
