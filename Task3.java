import java.util.concurrent.atomic.AtomicInteger;

public class Task3 {
    
    // FIX: Replaced primitive int with AtomicInteger.
    //this causes a race condition leading to lost updates. 
    // AtomicInteger provides lock-free, thread-safe operations on single variables.
    private AtomicInteger processedCount = new AtomicInteger(0);
 
    public void process(List<StatementRecord> records) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
 
        for (StatementRecord record : records) {
            executor.submit(() -> {
                processRecord(record);
                // FIX: Use atomic increment method instead of '++'
                processedCount.incrementAndGet();
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.MINUTES);
    }
 
    public int getProcessedCount() {
        //FIX: Return Int
        return processedCount.get();
    }
}
