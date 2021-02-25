package ilya.multithreading.util;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {
    private static final int LIST_SIZE = 1_000_000;

    public static List<Integer> getList(int value) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            integers.add(value);
        }
        return integers;
    }
}
