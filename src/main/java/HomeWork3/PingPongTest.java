package HomeWork3;

public class PingPongTest {

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread ping = new Thread(()->{pingPong.printPingPong("ping");});
        Thread pong = new Thread(()->{pingPong.printPingPong("pong");});
        ping.start();
        pong.start();
    }
}
