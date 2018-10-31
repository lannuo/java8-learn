package com.study.java8;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

    private long start;
    private long end;
    private static final long Threshold=10000;

    public ForkJoinCalculate() {
    }

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        long length=end-start;
        if(length<=Threshold){
            long sum=0;
            for(long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long middle=(start+end)/2;
            ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
            left.fork();
            ForkJoinCalculate right=new ForkJoinCalculate(middle+1,end);
            right.fork();
            return left.join()+right.join();

        }
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
