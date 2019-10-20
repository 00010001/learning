package demo.multithreading;

public class StartingThread {

    public static void main(String[] args) {
        Thread annonymousClass = new Thread(() -> printHello());

        Thread classThatImplementsRunnable = new Thread(new ClassThatImplementsRunnable());
        Thread classThatExtendsThread = new ClassThatExtendsThread();

        annonymousClass.start();
        classThatImplementsRunnable.start();
        classThatExtendsThread.start();

    }

    static class ClassThatImplementsRunnable implements Runnable {
        @Override
        public void run() {
            printHello();
        }
    }

    static class ClassThatExtendsThread extends Thread {
        @Override
        public void run() {
            printHello();
        }
    }

    private static void printHello() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
