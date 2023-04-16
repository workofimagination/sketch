package sketch.networking;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import sketch.utils.JsonUtils;

public class WSClient extends WebSocketClient {
    public WebSocketClient client;

    public WSClient(URI uri, HashMap<String, String> headers) {
        super(uri, headers);
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("connected to server");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("new message from server: " + message);
    }

    @Override 
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("websocket connection closed");
        System.out.println("code: " + code);
        System.out.println("reasonse: " + reason);
        System.out.println("remote: " + remote);
    }

    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    public static WSClient init() throws URISyntaxException {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("name", "front");
        
        WSClient client = new WSClient(new URI("ws://127.0.0.1:3001"), headers);

        return client;
    }

    public void sendMessage(int opCode, String message) {
        Request request = new Request(opCode, message);
        String jsonString = new String();

        try {
            jsonString = JsonUtils.toJson(request);
        } catch (IOException error) {
            error.printStackTrace();
            return;
        }

        this.send(jsonString);
    }
}


class Request {
    public int op_code;
    public String message;

    public Request(int opCode, String message) {
        this.op_code = opCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Request[message = " + message + ", op_code = " + op_code + "]";
    }
}

