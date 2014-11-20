package zork.dungeon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Item {

	protected String name;
	protected String description;
	protected List<Item> items = new LinkedList<Item>();
	protected List<String> synonyms = new LinkedList<String>();

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public List<String> getSynonyms() {
		return synonyms;
	}
	
	public void addSynonyms(String...synonym) {
		this.synonyms.addAll(Arrays.asList(synonym));
	}

	@Override
	public String toString() {
		return name;
	}
}
