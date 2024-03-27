package loop;

public class ForApp05 {
	public static void main(String[] args) {
		
		/*
		 * 구구단 출력
		 * 
		 * 2 * 1 = 2   3 * 1 = 3   4 * 1 = 4   5 * 1 = 5
		 * 2 * 2 = 4   3 * 2 = 6   4 * 2 = 8   5 * 2 = 10
		 */
		
		for (int row = 1; row <=9; row++) {
			for (int dan =2; dan<=9; dan++){
				System.out.print(dan + " * " + row + " = " + dan * row + "\t" );
			}
			System.out.println();
		}
	}
}
