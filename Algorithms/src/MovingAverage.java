
//346. Moving Average from Data Stream
//https://leetcode.com/problems/moving-average-from-data-stream/

class MovingAverage {

    int runningSum;
    Queue<Integer> q;
    int size;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        
        runningSum = 0;
        q = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        
        q.add(val);
        runningSum += val;
        
        if(q.size() == size)
        {
            return 1.0*runningSum/size;
        }
        else if(q.size() > size)
        {
            int first = q.poll();
            runningSum -= first;
            return 1.0*runningSum/size;
        }
        else 
        {
            return 1.0*runningSum/q.size();
        }   
    }
}