import java.util.LinkedList;
import java.util.Queue;
/*
Creates a traffc control system that takes in 100 cars max, 
removes cars during the green and yellow lights. 
Does nothing during red colour. 
Fails to stop when cars queue is 0. 


*/
public class Car {
    private static void green(Queue<Integer> car) throws InterruptedException {
        // implements the green lights and removes cars every 1 second during 30 seconds
        for (int k=30; k > 0; k--) {
        car.poll();
        System.out.println("Lights on Green. Cars left in queue:  " + car.size());

        System.out.println("All clear.You can go. " + k + "seconds left");
        Thread.sleep(1000);
        }
    }

    private static void yellow(Queue<Integer> car) throws InterruptedException {
        // removes a car every 2 seconds during 20 seconds
        for (int k=20; k > 0; k--){
        car.poll();
        System.out.println("Lights on Yellow. Cars left in queue: " + car.size());
        System.out.println("Please slow down. Just " + k + "seconds left");
        Thread.sleep(2000);
        
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
        //   manages insertion of car into Queue. 
        //  I was not able to insert during the execution of the traffic light functions properly
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
