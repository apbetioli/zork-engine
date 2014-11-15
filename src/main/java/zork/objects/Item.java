package zork.objects;

import zork.Verb;

public class Item {

	protected String name;
	protected String description;
	
	public Item() {
	}

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String look() {
		return description;
	}

	public String execute(Verb todo) {
		return description;
	}

	@Override
	public String toString() {
		return look();
	}
}
