package zork.util;

import java.util.TreeMap;

public class UpperCaseKeyTreeMap<Value> extends TreeMap<String, Value> {

	private static final long serialVersionUID = 2407001958150960685L;

	@Override
	public Value put(String key, Value value) {
		return super.put(key.trim().toUpperCase(), value);
	}

	@Override
	public Value get(Object key) {
		return super.get(((String) key).trim().toUpperCase());
	}

	@Override
	public boolean containsKey(Object key) {
		return super.containsKey(((String) key).trim().toUpperCase());
	}

}
