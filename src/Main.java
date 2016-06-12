
/**
 * Есть три работника - два худых грузят, один толстый разгружает.
 * Есть тележка, возле которой может поместиться только
 * два худых, или только один толстый работник.
 * Сначала два худых наполняют тележку, один толстый хочет разгружать,
 * но не помещается. Как только оба худых отвалят от тележки,
 * тут же толстый начинает разгружать.
 * <p>
 * Created by Alex Korneyko on 12.06.2016.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        SimpleSemaphore simpleSemaphore = new SimpleSemaphore(2);
        new Worker(simpleSemaphore, "Adder1", true, 1).start();
        new Worker(simpleSemaphore, "Adder2", true, 1).start();
        Thread.sleep(20);
        new Worker(simpleSemaphore, "Reducer", false, 2).start();

    }
}
