package org.example.creator.single;

public class Single {
    private Single() {
    }

    private static volatile Single single;

    public static Single createSingle() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

    public String echo(String s) {
        return s;
    }
}
