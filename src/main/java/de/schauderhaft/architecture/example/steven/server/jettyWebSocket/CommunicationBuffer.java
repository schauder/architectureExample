package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class CommunicationBuffer {

    private BlockingQueue<String> wordQueue = new SynchronousQueue();
    private BlockingQueue<Integer> pointQueue = new SynchronousQueue();


    public void putPoints(int totalPoints) {
        try {
            pointQueue.put(totalPoints);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  int pullPoints() {
        try {
            return pointQueue.poll(3000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 23;
    }

    public  void putInput(String word) {
        try {
            wordQueue.put(word);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  String pullInput() {
        try {
            return wordQueue.poll(3000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "du bist doof";
    }
}
