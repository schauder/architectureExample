package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import static java.lang.Thread.yield;

public class TestingThread {
    private final String name;
    private volatile boolean stop;
    private Runnable command;

    public TestingThread(String name) {
        this.name = name;
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {
                    synchronized (TestingThread.this) {
                        if (command != null) {
                            command.run();
                            command = null;
                        }
                    }
                    yield();
                }
            }
        }, name).start();
    }

    public synchronized void execute(Runnable command) {
        this.command = command;
    }

    public void stop() {
        stop = true; // boolean sollte thread safe sein.
    }
}
