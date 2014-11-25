package zork.language;

import java.util.List;

public interface Token {

	int getDepth();

	void addToken(Token token);

	List<Token> getTokens();

}
