/**
 * Тележка
 * Created by Alex Korneyko on 12.06.2016.
 */
class Cart {
    private static int weight = 0;

    static void addWeight() {
        weight--;
    }

    static void reduceWeight() {
        weight++;
    }

    static int getWeight() {
        return weight;
    }
}
