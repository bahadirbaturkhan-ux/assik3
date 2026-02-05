package utils;

import model.AccountBase;
import java.util.List;

public class SortingUtils {

    public static List<AccountBase> byBalance(List<AccountBase> list) {
        return list.stream()
                .sorted((a, b) -> Double.compare(a.getBalance(), b.getBalance()))
                .toList();
    }
}
