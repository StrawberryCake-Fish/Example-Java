package org.example.creator.single;

import java.io.Serial;
import java.io.Serializable;

public class Single implements Serializable {
    @Serial
    private static final long serialVersionUID = -6968534045431104534L;

    private Single() {
        // 避免被反射破坏
        if (single != null) {
            throw new RuntimeException("Single instance is not null!");
        }
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

    @Serial
    public Object readResolve() {
        // 避免被序列化破坏
        return Single.createSingle();
    }
}
