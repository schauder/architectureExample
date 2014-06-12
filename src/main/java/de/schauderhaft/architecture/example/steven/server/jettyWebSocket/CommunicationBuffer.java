package de.schauderhaft.architecture.example.steven.server.jettyWebSocket;

import java.util.concurrent.CountDownLatch;

public class CommunicationBuffer {

    private int totalPoints = 0;
    private String word = "";
    private CountDownLatch wordSet = new CountDownLatch(1);
    private CountDownLatch pointsSet = new CountDownLatch(0);

    public void putPoints(int totalPoints) {
        this.totalPoints = totalPoints;
        pointsSet.countDown();
    }

    public int pullPoints() {
        try {
            pointsSet.await();
            wordSet = new CountDownLatch(1);
            return totalPoints;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void putInput(String word) {
        this.word = word;
        wordSet.countDown();
    }

    public String pullInput() {

        try {
            wordSet.await();
            pointsSet = new CountDownLatch(1);
            return word;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }
}
