package zork.engine;

import java.util.TreeMap;

import zork.language.Token;

public class Dictionary extends TreeMap<String, Token> {

	private static final long serialVersionUID = 4964927938848125605L;

	@Override
	public Token put(String key, Token value) {
		return super.put(key.trim().toUpperCase(), value);
	}

}