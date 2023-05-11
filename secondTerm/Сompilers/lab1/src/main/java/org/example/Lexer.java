package org.example;

import java.util.HashMap;
import java.util.Map;

import static org.example.TokenType.STRING;


public class Lexer {
    private String source;
    private int position = 0;
    private Map<String, TokenType> keywords = new HashMap<String, TokenType>() {{
        put("and", TokenType.BOOLEAN);
        put("array", TokenType.KEYWORD);
        put("begin", TokenType.KEYWORD);
        put("case", TokenType.KEYWORD);
        put("const", TokenType.KEYWORD);
        put("div", TokenType.OPERATOR);
        put("do", TokenType.KEYWORD);
        put("downto", TokenType.KEYWORD);
        put("else", TokenType.KEYWORD);
        put("end", TokenType.END_OF_FILE);
        put("file", TokenType.KEYWORD);
        put("for", TokenType.KEYWORD);
        put("function", TokenType.KEYWORD);
        put("goto", TokenType.KEYWORD);
        put("if", TokenType.KEYWORD);
        put("in", TokenType.KEYWORD);
        put("label", TokenType.KEYWORD);
        put("mod", TokenType.OPERATOR);
        put("nil", TokenType.BOOLEAN);
        put("not", TokenType.OPERATOR);
        put("of", TokenType.KEYWORD);
        put("or", TokenType.BOOLEAN);
        put("packed", TokenType.KEYWORD);
        put("procedure", TokenType.KEYWORD);
        put("program", TokenType.KEYWORD);
        put("record", TokenType.KEYWORD);
        put("repeat", TokenType.KEYWORD);
        put("set", TokenType.KEYWORD);
        put("then", TokenType.KEYWORD);
        put("to", TokenType.KEYWORD);
        put("type", TokenType.KEYWORD);
        put("until", TokenType.KEYWORD);
        put("var", TokenType.KEYWORD);
        put("while", TokenType.KEYWORD);
        put("with", TokenType.KEYWORD);
        put("true", TokenType.BOOLEAN);
        put("false", TokenType.BOOLEAN);
    }};

    public Lexer(String source) {
        this.source = source;
    }

    private boolean isAlpha(char c) {
        return Character.isLetter(c) || c == '_';
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isAlnum(char c) {
        return isAlpha(c) || isDigit(c);
    }

    private char currentChar() {
        return source.charAt(position);
    }

    private void consume() {
        position++;
    }

    private Token getErrorToken(String message) {
        return new Token(TokenType.ERROR, message);
    }

    private Token getDelimiterToken() {
        String value = "";
        value += currentChar();
        consume();
        return new Token(TokenType.DELIMITER, value);
    }

    private Token getOperatorToken() {
        StringBuilder value = new StringBuilder();
        while (currentChar() == '+' || currentChar() == '-' ||
                currentChar() == '*' || currentChar() == '/' ||
                currentChar() == ':' || currentChar() == '=' ||
                currentChar() == '<' || currentChar() == '>' ||
                currentChar() == '^') {
            value.append(currentChar());
            consume();
        }
        return new Token(TokenType.OPERATOR, value.toString());
    }

    private Token getStringToken() {
        StringBuilder value = new StringBuilder();
        consume(); // Consume the opening quote
        while (currentChar() != '\'' && position < source.length()) {
            value.append(currentChar());
            consume();
        }

        if (position >= source.length()) {
            return getErrorToken("Unterminated string");
        } else {
            consume(); // Consume the closing quote
            return new Token(STRING, value.toString());
        }
    }

    private Token getNumberToken() {
        String value = "";
        while (isDigit(currentChar())) {
            value += currentChar();
            consume();
        }
        if (currentChar() == '.') {
            value += currentChar();
            consume();
            while (isDigit(currentChar())) {
                value += currentChar();
                consume();
            }
            return new Token(TokenType.REAL, value);
        } else {
            return new Token(TokenType.INTEGER, value);
        }
    }

    private Token getIdentifierToken() {
        StringBuilder value = new StringBuilder();
        while (isAlnum(currentChar())) {
            value.append(currentChar());
            consume();
        }
        if (keywords.containsKey(value.toString())) {
            return new Token(keywords.get(value.toString()), value.toString());
        }
        else {
            return new Token(TokenType.IDENTIFIER, value.toString());
        }
    }

    public Token getNextToken() {
        while (Character.isWhitespace(currentChar())) {
            consume();
        }

        if (Character.isLetter(currentChar())) {
            return getIdentifierToken();
        }

        if (Character.isDigit(currentChar())) {
            return getNumberToken();
        }

        if (currentChar() == '\'') {
            return getStringToken();
        }

        if (currentChar() == '+' || currentChar() == '-' ||
                currentChar() == '*' || currentChar() == '/' ||
                currentChar() == ':' || currentChar() == '=' ||
                currentChar() == '<' || currentChar() == '>' ||
                currentChar() == '^') {
            return getOperatorToken();
        }

        if (currentChar() == '.' || currentChar() == ',' ||
                currentChar() == ';' || currentChar() == '(' ||
                currentChar() == ')' || currentChar() == '[' ||
                currentChar() == ']') {
            return getDelimiterToken();
        }

        if (currentChar() == '{') {
            while (currentChar() != '}' && position < source.length()) {
                consume();
            }
            if (position == source.length()) {
                return getErrorToken("Unterminated comment");
            } else {
                consume();  // Consume the '}'
                return getNextToken();  // Recurse to get the next token
            }
        }

        if (currentChar() == ':' && source.charAt(position + 1) == '=') {
            consume();  // Consume the ':'
            consume();  // Consume the '='
            return new Token(TokenType.OPERATOR, ":=");
        }

        if (currentChar() == '/' && source.charAt(position + 1) == '/') {
            while (currentChar() != '\n' && position < source.length()) {
                consume();
            }
            return getNextToken();  // Recurse to get the next token
        }

        if (currentChar() == 0) {
            return new Token(TokenType.DELIMITER, "");
        }

        return getErrorToken("Unexpected character");
    }
}
