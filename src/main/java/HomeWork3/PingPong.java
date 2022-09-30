package HomeWork3;

public class PingPong {
    private final Object monitor = new Object();
    private String currentWord = "ping";

    public void printPingPong (String word){

        synchronized (monitor){
            try{
                for (int i = 0; i < 5; i++) {
                    if (!currentWord.equals(word)) {
                        monitor.wait();
                    }
                    System.out.println(word);
                    if (currentWord.equals("ping")) {
                        currentWord = "pong";
                        monitor.notifyAll();
                    } else {
                        currentWord = "ping";
                        monitor.notifyAll();
                    }
                }

            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

