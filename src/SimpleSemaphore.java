/**
 * Created by Alex Korneyko on 11.06.2016.
 */
public class SimpleSemaphore implements Semaphore {

    int permits;
    private final Object lock = new Object();

    public SimpleSemaphore(int permits) {
        this.permits = permits;
    }

    @Override
    public void acquire() {
        if (permits > 0) {
            permits--;
        } else {
            while (permits <= 0) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.permits--;
            lock.notify();
        }

    }

    @Override
    public void acquire(int permits) {
        if (this.permits >= permits) {
            this.permits -= permits;
        } else {
            while (this.permits < permits) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.permits -= permits;
            lock.notifyAll();
        }
    }

    @Override
    public void release() {
        permits++;
    }

    @Override
    public void release(int permits) {
        this.permits += permits;
    }

    @Override
    public int getAvailablePermits() {
        return permits;
    }
}
