package Homework10;

public class ValueCalculator {
    private float[] array;
    private int arraySize;
    private int halfSize;

    public ValueCalculator(int arraySize) {
        if (arraySize < 1000000) {
            throw new IllegalArgumentException("Array size must be at least 1,000,000");
        }
        this.arraySize = arraySize;
        this.halfSize = arraySize / 2;
        this.array = new float[arraySize];
    }

    public void calculateValues() {
        long start = System.currentTimeMillis();

        // Заполнить массив одинаковыми значениями
        for (int i = 0; i < arraySize; i++) {
            array[i] = 1.0f;
        }

        // Split the array into two equal halves
        float[] array1 = new float[halfSize];
        float[] array2 = new float[halfSize];
        System.arraycopy(array, 0, array1, 0, halfSize);
        System.arraycopy(array, halfSize, array2, 0, halfSize);

        //Создайте два потока для обработки каждой половины массива
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                int index = i;
                array1[index] = (float) (array1[index] * Math.sin(0.2f + index / 5) *
                        Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < halfSize; i++) {
                int index = i;
                array2[index] = (float) (array2[index] * Math.sin(0.2f + (index + halfSize) / 5) *
                        Math.cos(0.2f + (index + halfSize) / 5) * Math.cos(0.4f + (index + halfSize) / 2));
            }
        });

        //Начать темы
        thread1.start();
        thread2.start();

        // Дождитесь завершения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Объедините две половины обратно в исходный массив
        System.arraycopy(array1, 0, array, 0, halfSize);
        System.arraycopy(array2, 0, array, halfSize, halfSize);

        long end = System.currentTimeMillis();
        long elapsedTime = end - start;

        System.out.println("Execution time: " + elapsedTime + " ms");
    }
}
