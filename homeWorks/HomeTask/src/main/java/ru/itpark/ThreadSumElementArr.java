package ru.itpark;

public class ThreadSumElementArr extends Thread {
    private final FinalSum finalSum;
    private int array[], start, end;

    public ThreadSumElementArr(int start, int end, int array[],FinalSum finalSum) {
        this.start = start;
        this.end = end;
        this.array = array;
        this.finalSum = finalSum;
    }

    int sumStartEndElem = 0;

    public void sumElements () {
        for (int i = start; i <= end; i++) {
            sumStartEndElem += array[i];
        }

        synchronized (finalSum) {
            finalSum.setSum(finalSum.getSum() + sumStartEndElem);
           // System.out.println(finalSum.getSum());
        }
    }

    @Override
    public void run() {

        sumElements();
    }
}