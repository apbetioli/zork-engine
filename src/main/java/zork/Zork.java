package zork;

public class Zork {

	private Map map;

	private Room currentRoom;

	public Zork(Map map) {
		this.map = map;

		currentRoom = map.getRooms().get(0);
	}

	public String interact(String input) {

		if (input.equals("welcome")) {
			return map.describe();
		}

		if (input.equals("look")) {
			return currentRoom.describe();
		}

		return "That is not a verb I recognize.";
	}

}
