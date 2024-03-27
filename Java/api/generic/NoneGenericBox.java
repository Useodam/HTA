package generic;

public class NoneGenericBox {

	// 박스객체에 저장할 객체를 담는 변수
	Object data;
	
	// 객체를 저장하는 기능
	public void add(Object data) {
		this.data = data;
	}
	
	// 객체를 제공하는 기능
	public Object get() {
		return data;
	}
}
