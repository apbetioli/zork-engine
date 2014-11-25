package zork.dungeon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import zork.language.Word;
import zork.util.StringUtils;

public class Item extends Word {

	private String name;
	private String description;
	private List<Item> items;
	private List<String> synonyms;
	private List<String> properties;

	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Item> getItems() {
		if (items == null)
			items = new LinkedList<Item>();
		return items;
	}

	public void addItem(Item item) {
		getItems().add(item);
	}

	public List<String> getSynonyms() {
		if (synonyms == null)
			synonyms = new LinkedList<String>();
		return synonyms;
	}

	public void addSynonyms(String... synonym) {
		getSynonyms().addAll(StringUtils.trimAll(Arrays.asList(synonym)));
	}

	public void addProperties(String... properties) {
		getProperties().addAll(StringUtils.trimAndUpperCaseAll(Arrays.asList(properties)));
	}

	public List<String> getProperties() {
		if (properties == null)
			properties = new LinkedList<String>();
		return properties;
	}

	public boolean is(String property) {
		return getProperties().contains(property);
	}

	public void removeProperties(String... properties) {
		getProperties().removeAll(Arrays.asList(properties));
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
