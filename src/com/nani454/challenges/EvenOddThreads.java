package com.nani454.challenges;

public class EvenOddThreads {
    public static void main(String[] args) {
        int n = 15;
        Printer printer = new Printer(n);
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printEvenNumbers(n);
            }
        });
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printer.printOddNumbers(n);
            }
        });

        evenThread.start();

        oddThread.start();
    }
}
class Printer {
    final int n;
    int counter = 1;

    public Printer(int n) {
        this.n = n;
    }

    public void printEvenNumbers(int n) {
        synchronized(this) {
            while (counter < n) {
                while (counter % 2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }

    public void printOddNumbers(int n) {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
}