import java.util.LinkedList;
import java.util.Queue;

public class Car {
    private static void green(Queue<Integer> car) throws InterruptedException {
        for (int k=30; k > 0; k--) {
        car.poll();
        System.out.println("Lights on Green. Cars left in queue:  " + car.size());

        System.out.println("All clear.You can go. " + k + "seconds left");
        Thread.sleep(1000);
        }
    }

    private static void yellow(Queue<Integer> car) throws InterruptedException {
        for (int k=20; k > 0; k--){
        car.poll();
        System.out.println("Lights on Yellow. Cars left in queue: " + car.size());
        System.out.println("Please slow down. Just " + k + "seconds left");
        Thread.sleep(2000);
        car.offer(1);
        }
    }

    private static void red(Queue<Integer> car) throws InterruptedException {
        for (int k=10; k > 0; k--){
            System.out.println("Lights on Red. Cars left in queue:  " + car.size());
            System.out.println("Please stop. Just " + k + "seconds left");
            Thread.sleep(1000);
            
        }
    
    }

    public static void trafficController(Queue<Integer> car) throws InterruptedException {
        int i = 0;
        while (car.size() < 100) {
            car.offer(i);
            i++;
        }
        while (car.size() > 0) {
            green(car);
            yellow(car);
            red(car);
            
        }
    }
public static void main (String[] args) throws InterruptedException {
    Queue<Integer> cars = new LinkedList<Integer>();
    trafficController(cars);
}

}
