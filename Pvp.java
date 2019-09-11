import java.util.Scanner;

public class Pvp {
	
	static Scanner s = new Scanner (System.in);
	static char[] t = new char[10];
	static char turn = 'X';
	static boolean gameover = false;
	
	public static void main(String[] args) {
		for (int a:t)
			t[a] = ' ';
		update();
	}
	
	public static void layout() {
		System.out.println(t[7]+":"+t[8]+":"+t[9]);
		System.out.println("......");
		System.out.println(t[4]+":"+t[5]+":"+t[6]);
		System.out.println("......");
		System.out.println(t[1]+":"+t[2]+":"+t[3]);
	}
	
	public static void update() {
		int place;
		while(!gameover) {
			System.out.println("\""+turn+"\" is playing");
			layout();
			do {
				System.out.print("enter a number between 1-9: ");
				place = s.nextInt();
			}while(place<1||place>9);
			System.out.println("\n");
			check(place);
		}
	}
	
	public static void check(int a) {
		if (!(t[a] == 'X' || t[a] == 'O')) {
			t[a] = turn;
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
			wincheck();
		}else
			System.out.println("you can't put here");
		update();
	}
	
	public static void wincheck() {
		// CHECK IF "X" WIN
		if (t[1] == 'X' && t[2] == 'X' && t[3] == 'X') winx();
		else if (t[4] == 'X' && t[5] == 'X' && t[6] == 'X') winx();
		else if (t[7] == 'X' && t[8] == 'X' && t[9] == 'X') winx();
		else if (t[1] == 'X' && t[4] == 'X' && t[7] == 'X') winx();
		else if (t[2] == 'X' && t[5] == 'X' && t[8] == 'X') winx();
		else if (t[3] == 'X' && t[6] == 'X' && t[9] == 'X') winx();
		else if (t[1] == 'X' && t[5] == 'X' && t[9] == 'X') winx();
		else if (t[3] == 'X' && t[5] == 'X' && t[7] == 'X') winx();
		// CHECK IF "O" WIN
		else if (t[1] == 'O' && t[2] == 'O' && t[3] == 'O') wino();
		else if (t[4] == 'O' && t[5] == 'O' && t[6] == 'O') wino();
		else if (t[7] == 'O' && t[8] == 'O' && t[9] == 'O') wino();
		else if (t[1] == 'O' && t[4] == 'O' && t[7] == 'O') wino();
		else if (t[2] == 'O' && t[5] == 'O' && t[8] == 'O') wino();
		else if (t[3] == 'O' && t[6] == 'O' && t[9] == 'O') wino();
		else if (t[1] == 'O' && t[5] == 'O' && t[9] == 'O') wino();
		else if (t[3] == 'O' && t[5] == 'O' && t[7] == 'O') wino();
		else isEmpty();
	}
	
	public static void winx() {
		layout();
		System.out.println("player \"X\" win");
		gameover = true;
	}
	
	public static void wino() {
		layout();
		System.out.println("player \"O\" win");
		gameover = true;
	}
	
	public static void isEmpty() {
		if ((t[1] == 'X' || t[1] == 'O') &&
			(t[2] == 'X' || t[2] == 'O') &&
			(t[3] == 'X' || t[3] == 'O') &&
			(t[4] == 'X' || t[4] == 'O') &&
			(t[5] == 'X' || t[5] == 'O') &&
			(t[6] == 'X' || t[6] == 'O') &&
			(t[7] == 'X' || t[7] == 'O') &&
			(t[8] == 'X' || t[8] == 'O') &&
			(t[9] == 'X' || t[9] == 'O')){
			System.out.println("there are no moves left");
			gameover = true;
			layout();
		}
	}

}
