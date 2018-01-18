package Day001Recursive;

import java.util.Scanner;

public class RecursiveHanoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		recursiveHanoi(input, 'A', 'B', 'C');
	}
	
	public static void recursiveHanoi(int n, char from, char by, char to){
		if(n==1){
			System.out.println(n+"을 "+from+"에서 "+to+"로 이동합니다.");
		}else{
			recursiveHanoi(n-1, from, to, by);
			System.out.println(n+"을 "+from+"에서 "+to+"로 이동합니다.");
			recursiveHanoi(n-1, by, from, to);
		}
		
	}
}
