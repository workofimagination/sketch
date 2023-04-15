package sketch;

import java.net.URISyntaxException;

import sketch.Networking.WSClient;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        WSClient c = WSClient.init();
        c.connect();

        System.out.println("test");
        MainFrame temp = new MainFrame();
        temp.setVisible(true);
    }
}

