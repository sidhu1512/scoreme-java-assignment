## Task 2: ConcurrentModificationException Diagnosis

**1. What is the exact cause of ConcurrentModificationException in Java?**
The exception occurs when a collection is modified (elements are added or removed) while it is being iterated over.

**2. What code pattern at line 142 most likely triggered this error?**
The method `filterTransactions` is likely iterating through an `ArrayList` using an enhanced `for-each` loop and calling the list's `remove()` method directly on elements that fail the filter condition. 

**3. Provide the minimal code change (one or two lines) that resolves this safely.**
Replace the `for-each` loop entirely with the `removeIf` method for a concise, safe removal:

`transactions.removeIf(transaction -> /* condition for removal */);`

OR

Use an explicit `Iterator` and call its `remove()` method instead of the list's `remove()` method:
