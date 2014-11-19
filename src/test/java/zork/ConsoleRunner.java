package zork;

import java.util.Scanner;

public class ConsoleRunner {

	public static void main(String[] args) {
		Game game = new Zork(new Zork1Map());
		start(game);

		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input.equals("exit"))
				break;
			System.out.println(game.interact(input));
			System.out.println();
			System.out.print(">");
		}
		scanner.close();
	}

	private static void start(Game game) {
		System.out.println(game.interact("version"));
		System.out.println(game.interact("look"));
	}
}
