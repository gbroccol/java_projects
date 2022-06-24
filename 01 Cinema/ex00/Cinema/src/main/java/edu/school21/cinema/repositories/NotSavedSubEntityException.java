package edu.school21.cinema.repositories;

public class NotSavedSubEntityException extends RuntimeException {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public NotSavedSubEntityException() {
        super(ANSI_RED + "User can not be saved" + ANSI_RESET);
    }
}