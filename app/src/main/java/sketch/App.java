package sketch;

import java.net.URISyntaxException;

import sketch.networking.WSClient;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        WSClient c = WSClient.init();
        c.connect();

        System.out.println("test");
        MainFrame temp = new MainFrame(c);
        temp.setVisible(true);
    }
}

