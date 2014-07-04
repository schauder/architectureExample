package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class CommunicationBufferTest {
    private final CommunicationBuffer buffer = new CommunicationBuffer();

    private final ServerThread serverThread = new ServerThread();

    private final ClientThread clientThread = new ClientThread();
    private Object result;

    @Before
    public void before(){
        serverThread.start();
        clientThread.start();
    }

    @After
    public void after(){
        serverThread.stop();
        clientThread.stop();
    }

    @Test
    public void writeRead() {
        clientThread.execute(new Runnable() {
            @Override
            public void run() {
                buffer.putInput("Hello");
            }
        });

        serverThread.execute(new Runnable() {
            @Override
            public void run() {
                setResult(buffer.pullInput());
            }
        });

        doWait();

        assertEquals("Hello", result);
    }

    @Test
    public void readWriteRead() {
        clientThread.execute(new Runnable() {
            @Override
            public void run() {
                buffer.putInput("Hello");
                setResult(buffer.pullPoints());
            }
        });

        serverThread.execute(new Runnable() {
            @Override
            public void run() {
                buffer.pullInput();
                buffer.putPoints(23);
            }
        });

        doWait();

        assertEquals(23, result);
    }

    private void doWait() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setResult(Object result) {
        this.result = result;
    }
}