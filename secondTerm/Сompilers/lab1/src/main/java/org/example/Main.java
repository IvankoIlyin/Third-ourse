package org.example;

public class Main {
    public static void main(String[] args) {
        String good_code = "program HelloWorld;\n"
                + "var\n"
                + " xds: boolean;\n"
                + "begin\n"
                + " x := true;\n"
                + " writeln('Hello, world!');\n"
                + " writeln('The value of x is: ', x);\n"
                + "end";


        String error_code = "program HelloWorld;\n"
                + "var\n"
                + "  xds: boolean;\n"
                + "begin\n"
                + "  x := true;\n"
                + "  writeln('Hello, world!');\n"
                + "  writeln('The value of x is: ', x);\n"
                + "end";



        Parse parse = new Parse(error_code);

    }
}