/**
 * Created by Alex Korneyko on 12.06.2016.
 */
public class Worker extends Thread {

    private SimpleSemaphore semaphore;
    private String workerName;
    private boolean isAdder;
    private int needPermits;

    public Worker(SimpleSemaphore semaphore, String workerName, boolean isAdder, int needPermits) {
        this.semaphore = semaphore;
        this.workerName = workerName;
        this.isAdder = isAdder;
        this.needPermits = needPermits;
    }

    @Override
    public void run() {
        System.out.println(workerName + " started working...");
        try {
            System.out.println(workerName + " waiting for cart...");
            semaphore.acquire(needPermits);
            System.out.println(workerName + " got access to cart...");
            for (int i = 0 ; i < 10 ; i++) {
                if (isAdder)
                    Cart.reduceWeight();
                else
                    Cart.addWeight();

                System.out.println(workerName + " changed weight to: " + Cart.getWeight());
                Thread.sleep((long) (Math.random()*10));
            }
            System.out.println(workerName + " finished working with cart...");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            semaphore.release(needPermits);
        }
    }
}
