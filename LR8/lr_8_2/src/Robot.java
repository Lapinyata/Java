public class Robot {
    public static void main(String[] args) {
        Thread leftLeg = new Thread(() -> {
            while (true) {
                System.out.println("LEFT");
                try {
                    Thread.sleep(1000); // Задержка для имитации движения ноги
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread rightLeg = new Thread(() -> {
            while (true) {
                System.out.println("RIGHT");
                try {
                    Thread.sleep(1000); // Задержка для имитации движения ноги
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        leftLeg.start();
        rightLeg.start();
    }
}
