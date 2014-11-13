package zork;


public class Zork {

	private MapLoader mapLoader;
	private int roomIndex;
	private Room room;

	public String load(String mapResource) {
		mapLoader = new MapLoader();
		mapLoader.load(mapResource);
		return start();
	}

	private String start() {
		roomIndex = 0;
		room = mapLoader.rooms().get(roomIndex);
		return mapLoader.welcome() + "\n\n" + room.getName() + "\n"
				+ room.getDescription();
	}

	public String interact(String input) {
		return "That is not a verb I recognize.";
	}

}
