package collection;

import java.util.HashSet;
import java.util.Objects;

public class HashSetApp2 {

	public static void main(String[] args) {
		
		HashSet<User> set = new HashSet<>();
		
		set.add(new User("go", "고길동"));
		set.add(new User("no", "노길동"));
		set.add(new User("park", "박길동"));
		set.add(new User("kim", "김길동"));
		set.add(new User("Oh", "오길동"));
		set.add(new User("shin", "신길동"));
		set.add(new User("nu", "누길동"));
		set.add(new User("nu", "누길동"));
		set.add(new User("nu", "누길동"));
		
		for(User u : set) {
			System.out.println(u.id +", " +u.name);
		}
	}
	
	static class User {
		String id;
		String name;
		
		public User(String id, String name) {
			this.id = id;
			this.name = name;
		}
		
		/*
		 * hashCode()와 equals()메소드를 재정의해서
		 * id값이 같은 User객체는 같은 객체로 판단하도록 하였음
		 */
		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(id, other.id) && Objects.equals(name, other.name);
		}
		
		
	}
}
