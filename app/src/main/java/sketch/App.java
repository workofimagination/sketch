package sketch;

import java.net.URISyntaxException;

import sketch.Networking.WSClient;
import sketch.utils.GSParser;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        try {
            GSParser.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }

        WSClient c = WSClient.init();
        c.connect();

        System.out.println("test");
        MainFrame temp = new MainFrame();
        temp.setVisible(true);
    }
}

