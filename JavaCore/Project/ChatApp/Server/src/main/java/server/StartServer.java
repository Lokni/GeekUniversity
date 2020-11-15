package server;

import java.io.IOException;
import java.util.logging.*;

public class StartServer {
    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {
        try {
            FileHandler handler = new FileHandler("log_%g.txt", 50 * 1024, 30, true);
            handler.setFormatter(new SimpleFormatter());
            handler.setLevel(Level.CONFIG);
            logger.addHandler(handler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Server();


    }
}
