// Custom Exception
class InvalidThreadOperationException extends Exception {
    public InvalidThreadOperationException(String message) {
        super(message);
    }
}

// Thread to print numbers 1 to 10
class NumberPrinter extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println("NumberPrinter: " + i);
                Thread.sleep(1000); // 1-second delay
            }
        } catch (InterruptedException e) {
            System.err.println("NumberPrinter interrupted: " + e.getMessage());
        }
    }
}

// Thread to calculate factorial from 1 to 5
class FactorialCalculator extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("FactorialCalculator: " + i + "! = " + calculateFactorial(i));
            }
        } catch (InvalidThreadOperationException e) {
            System.err.println("Error in FactorialCalculator: " + e.getMessage());
        }
    }

    // Synchronized factorial method
    private synchronized long calculateFactorial(int n) throws InvalidThreadOperationException {
        if (n < 0) {
            throw new InvalidThreadOperationException("Cannot calculate factorial of negative number: " + n);
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

// Main class to run the threads
class MultiThreadedApp {
    public static void main(String[] args) {
        try {
            NumberPrinter np = new NumberPrinter();
            FactorialCalculator fc = new FactorialCalculator();

            // Start both threads
            np.start();
            fc.start();

            // Wait for both to finish
            np.join();
            fc.join();

            System.out.println("All threads have completed execution.");

        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }
    }
}
