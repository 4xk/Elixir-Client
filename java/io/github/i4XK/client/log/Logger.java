package io.github.i4XK.client.log;

public class Logger {
    private String name;


    public Logger(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void log(String message, LogType type) {
        while (true) {
            if (type.equals(LogType.error)) {
                System.err.println("[" + type.name().toUpperCase() + "] [" + this.getName() + "] " + message);
                break;
            }
            System.out.println("[" + type.name().toUpperCase() + "] [" + this.getName() + "] " + message);
            break;
        }
    }

    public enum LogType {
        info, warning, error;
    }

}
