package Homework11;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class PetrolStation {
    private int amount;
    private Semaphore pumpSemaphore;

    public PetrolStation(int initialAmount) {
        this.amount = initialAmount;
        this.pumpSemaphore = new Semaphore(3);
    }

    public void doRefuel(int requestedAmount) {
        try {
            pumpSemaphore.acquire();
            System.out.println("Запит на заправку отримано");

            System.out.println("Початок заправки");
            TimeUnit.SECONDS.sleep((long) (Math.random() * 8) + 3);
            System.out.println("Заправка завершена");

            synchronized (this) {
                if (requestedAmount <= amount) {
                    amount -= requestedAmount;
                    System.out.println("Заправлено " + requestedAmount + " л палива");
                } else {
                    System.out.println("На станції недостатньо палива");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Помилка під час заправки: " + e.getMessage());
        } finally {
            pumpSemaphore.release();
            System.out.println("Запит на заправку оброблено");
        }
    }
}