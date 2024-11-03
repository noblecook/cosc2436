package edu.collin.cosc.tutor3;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {
    private static FileHandler fileHandler;
    private static String logFileName = "src\\logs\\edu.collin.cosc.tutor3.application.log";

    static {
        try {
            // Create a single file handler that all loggers will share
            fileHandler = new FileHandler(logFileName, true); // "true" for append mode
            fileHandler.setFormatter(new SimpleFormatter());

            // Add this file handler to the root logger, so all loggers inherit it
            Logger.getLogger("").addHandler(fileHandler);

            // Optionally set a default log level
            Logger.getLogger("").setLevel(java.util.logging.Level.INFO);
        } catch (IOException e) {
            Logger.getLogger("").severe("Failed to set up shared file handler: " + e.getMessage());
        }
    }

    // Optional: A method to get the configured file handler if needed
    public static FileHandler getFileHandler() {
        return fileHandler;
    }
}
