import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task5 {
    // FIX: Initialize SLF4J logger
    private static final Logger logger = LoggerFactory.getLogger(Task5.class);

    public ValidationResult validate(Document doc) {
        try {
            if (doc == null) {
                throw new RuntimeException("Document is null");
            }
            String content = doc.extractContent();
            if (content.isEmpty()) {
                throw new RuntimeException("Empty content");
            }
            return runValidationRules(content);
 
        } catch (RuntimeException e) {
            // FIX Issue 1: Log expected validation exceptions at WARN level (no stack trace)
            logger.warn("Validation failed: {}", e.getMessage());
            // FIX Issue 2: Rethrow to prevent downstream NPEs
            throw e;
        } catch (Exception e) {
            // FIX Issue 1: Log unexpected errors at ERROR level with stack trace
            logger.error("Unexpected runtime error", e);
            // FIX Issue 2: Rethrow to prevent downstream NPEs
            throw new RuntimeException(e);
        }
    }
 
    public void validateBatch(List<Document> docs) {
        for (Document doc : docs) {
            try {
                ValidationResult r = validate(doc);
                // FIX Issue 3: validate() now throws instead of returning null, but keeping original r.isValid() check
                if (r.isValid()) {                  
                    saveResult(r);
                }
            } catch (Exception e) {
                // FIX Issue 4: Prevent silent swallowing of exceptions by logging them
                logger.error("Failed to process document in batch", e);
            }
        }
    }
}