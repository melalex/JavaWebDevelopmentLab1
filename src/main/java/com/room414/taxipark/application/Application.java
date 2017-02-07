package com.room414.taxipark.application;

import com.room414.taxipark.application.controller.implementation.SimpleController;
import com.room414.taxipark.application.controller.interfaces.Controller;

import java.io.*;

/**
 * Created by melalex on 2/5/17.
 */
public class Application {
    private static final String QUIT_STRING = "exit";

    private boolean isRun = true;

    private BufferedReader inputStream;
    private PrintStream printStream;
    private Controller controller;

    public Application(InputStream inputStream, PrintStream printStream) {
        this.inputStream = new BufferedReader(new InputStreamReader(inputStream));
        this.printStream = printStream;
    }

    public void forceStop() {
        isRun = false;
    }

    public void start() {
        try {
            init();
            run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    private void init() {
        controller = new SimpleController();
    }

    private void run() throws IOException {
        String input;

        while (isRun) {
            printStream.print(">>>");
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

        }
    }
}
