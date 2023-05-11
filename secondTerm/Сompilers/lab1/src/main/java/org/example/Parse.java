package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Parse {
    private static final Map<TokenType, String> TOKEN_TYPE_TO_STR = new HashMap<TokenType, String>() {{
        put(TokenType.IDENTIFIER, "IDENTIFIER");
        put(TokenType.INTEGER, "INTEGER");
        put(TokenType.REAL, "REAL");
        put(TokenType.STRING, "STRING");
        put(TokenType.BOOLEAN, "BOOLEAN");
        put(TokenType.KEYWORD, "KEYWORD");
        put(TokenType.OPERATOR, "OPERATOR");
        put(TokenType.DELIMITER, "DELIMITER");
        put(TokenType.ERROR, "ERROR");
        put(TokenType.END_OF_FILE, "END_OF_FILE");
    }};
    private String input;

    public Parse(String _input) {
        this.input = _input;
        parseByValue();
    }

    private void parseByValue() {
        Lexer lexer = new Lexer(this.input);
        Token token = new Token();
        while ((token.getType() != TokenType.END_OF_FILE) && (token.getType() != TokenType.ERROR)) {
            token = lexer.getNextToken();
            String typeStr = TOKEN_TYPE_TO_STR.get(token.getType());
            if (typeStr != null) {
                System.out.print("<" + typeStr);
            }
            if (!token.getValue().equals("")) {
                System.out.print(", " + token.getValue());
            }
            System.out.println(">");
        }
    }
}
