package com.twinkieman.weblab;

public class DatabaseErrors extends Exception {

    public static class EntityManagerFactoryError extends Exception {
        public EntityManagerFactoryError(String message) {super("Something went wrong: couldn't connect to database! " + message);}
    }

    public static class UserNotFoundError extends Exception {
        public UserNotFoundError() {super("Username not found!");}
    }

}