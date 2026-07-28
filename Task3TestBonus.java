import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class Task3TestBonus {

    @Test
    public void testProcess_threadSafety() {
        Task3 processor = new Task3();
        List<StatementRecord> testRecords = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            testRecords.add(new StatementRecord()); 
        }
        // 2. Execute: Run the multi-threaded process
        processor.process(testRecords);
        // 3. Assert: Verify the counter caught every single record
        assertEquals(1000, processor.getProcessedCount(), "Processed count must exactly match the input size.");
    }
}