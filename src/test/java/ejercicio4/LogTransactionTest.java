package ejercicio4;

// Implementación simple para testing con JUnit
public class LogTransactionTest implements LogTransaction {
    private String lastLoggedClass;
    private boolean logCalled = false;

    @Override
    public void log(String className) {
        this.lastLoggedClass = className;
        this.logCalled = true;
        System.out.println("Test Log - Clase registrada: " + className);
    }

    public String getLastLoggedClass() {
        return lastLoggedClass;
    }

    public boolean wasLogCalled() {
        return logCalled;
    }

    public void reset() {
        lastLoggedClass = null;
        logCalled = false;
    }
}
