package org.example;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private TokenType type;
    private String value;
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

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public Token(){
        this.value="";

    }
    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


enum TokenType {
    IDENTIFIER,
    INTEGER,
    REAL,
    STRING,
    BOOLEAN,
    KEYWORD,
    OPERATOR,
    DELIMITER,
    ERROR,
    END_OF_FILE
}