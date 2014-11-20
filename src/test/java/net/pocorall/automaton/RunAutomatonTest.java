package net.pocorall.automaton;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

public class RunAutomatonTest {

	static public class PatternMatcher {

		private Map<String, Object> mapOrdenado = new TreeMap<String, Object>();

		private final StringUnionOperations builder = new StringUnionOperations();

		public PatternMatcher add(String key, Object value) {
			mapOrdenado.put(key, value);
			return this;
		}

		public RunAutomaton build() {

			for (Entry<String, Object> entry : mapOrdenado.entrySet())
				builder.add(entry.getValue(), entry.getKey());

			DefaultAutomaton a = new DefaultAutomaton();
			a.setInitialState(builder.complete());
			a.setDeterministic(true);
			a.reduce();
			a.recomputeHashCode();
			return new RunAutomaton(a);
		}
	}

	@Test
	public void testSplit() {

		RunAutomaton patterns = new PatternMatcher().add("box", "<item>").add("mailbox", "<item>")
				.add("open", "<command>").add("small", "<item>").add("small mailbox", "<item>").build();

		String result = "";

		RunAutomatonMatcher matcher = patterns.newMatcher("open small mailbox");
		Object aObj = matcher.find();
		while (aObj != null) {
			result += matcher.token() + matcher.group() + "(" + aObj + ")";
			aObj = matcher.find();
		}

		assertEquals("open(<command>) small mailbox(<item>)", result);
	}
}