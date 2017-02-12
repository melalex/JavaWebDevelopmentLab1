package com.room414.taxipark.application;

import com.room414.taxipark.application.controller.implementation.SimpleController;
import com.room414.taxipark.application.controller.interfaces.Controller;
import com.room414.taxipark.application.model.interfaces.DataStore;
import com.room414.taxipark.application.model.repositories.SimpleDataStore;
import com.room414.taxipark.application.view.implementation.SimpleView;
import com.room414.taxipark.application.view.interfaces.View;

import java.io.*;

/**
 * Class description goes here.
 *
 * @version 1.10 2/5/17
 * @author melalex
 */
public class Application {
    private static final String QUIT_STRING = "exit";
    private static final String BD_FILE_PATH = System.getProperty("user.dir")
            + System.getProperty("file.separator") + ".database.json";

    private boolean isRun = true;

    private BufferedReader inputStream;
    private PrintStream printStream;
    private Controller controller;
    private DataStore dataStore;

    public Application(InputStream inputStream, PrintStream printStream) {
        this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
        this.printStream = printStream;
    }

    public void start() {
        try {
            init();
            run();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    private void init() throws IOException {
        View view = new SimpleView(printStream);
        dataStore = SimpleDataStore.simpleDataStore(BD_FILE_PATH);
        controller = new SimpleController(dataStore, view);
    }

    private void run() throws IOException {
        String input;

        while (isRun) {
            controller.addMessage(">>>");
            input = inputStream.readLine();
            if (!input.equalsIgnoreCase(QUIT_STRING)) {
                controller.executeQuery(input);
            } else {
                isRun = false;
            }
        }
    }

    private void stop() {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dataStore.persistence(BD_FILE_PATH);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
