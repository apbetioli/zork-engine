package zork;

import java.util.Scanner;

public class ConsoleRunner {

	public static void main(String[] args) {
		Engine engine = new ZorkEngine(new ZorkOne());
		start(engine);

		System.out.print(">");
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String input = scanner.nextLine();
			if(input.equals("exit"))
				break;
			System.out.println(engine.interact(input));
			System.out.println();
			System.out.print(">");
		}
		scanner.close();
	}

	private static void start(Engine engine) {
		System.out.println(engine.interact("version"));
		System.out.println(engine.interact("look"));
	}
}
