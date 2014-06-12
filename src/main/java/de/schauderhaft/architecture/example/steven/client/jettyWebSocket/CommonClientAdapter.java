package de.schauderhaft.architecture.example.steven.client.jettyWebSocket;

import java.net.URI;

import de.schauderhaft.architecture.example.common.CommonClient;
import de.schauderhaft.architecture.example.steven.server.jettyWebSocket.CommunicationBuffer;

public class CommonClientAdapter implements CommonClient {

    private final CommunicationBuffer buffer;

    public CommonClientAdapter() throws Exception {
        buffer = new CommunicationBuffer();
        new Client(buffer).run(new URI("ws://localhost:8080/"));
    }

    @Override
    public int sendToServer(String word) {
        buffer.putInput(word);
        return buffer.pullPoints();
    }

}
