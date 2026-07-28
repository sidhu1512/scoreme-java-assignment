# ScoreMe Java Assignment

This repository contains solutions for the Java Developer Support Role technical assignment.

* **Task1.java**: Fixed a NullPointerException and corrected logical conditions for null due dates and zero balances.
* **Task3.java**: Resolved a race condition by implementing an AtomicInteger for thread-safe counting.
* **Task4.java**: Fixed a database connection resource leak by properly structuring nested try-with-resources blocks.
* **Task5.java**: Corrected exception handling by integrating SLF4J logging, rethrowing exceptions, and removing silent catches.
* **Task3TestBonus.java**: Included a JUnit test that reproduces the original thread-safety bug and validates the applied fix.
* **ANALYSIS.md**: Provided the root cause diagnosis and proposed solution for the ConcurrentModificationException from Task 2.
