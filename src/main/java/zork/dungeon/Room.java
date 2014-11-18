package zork.dungeon;

public class Room extends Item {

	public Room() {
	}

	public Room(String name, String description) {
		super(name, description);
	}

	public String look() {
		String text = name + "\n" + description;

		for (Item item : items) 
			text += "\n" + item.look();

		return text + "\n";
	}

}
