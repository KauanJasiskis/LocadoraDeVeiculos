package view;

import java.util.Scanner;

public class ScannerSingleton {

    private final Scanner scanner = new Scanner(System.in);
    private static final ScannerSingleton SINGLETON = new ScannerSingleton();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Fechando scanner pelo shutdown hook");
                instance().getScanner().close();
            }
        });
    }

    private ScannerSingleton() {
    }

    public static ScannerSingleton instance() {
        return SINGLETON;
    }

    public Scanner getScanner() {
        return scanner;
    }
}

