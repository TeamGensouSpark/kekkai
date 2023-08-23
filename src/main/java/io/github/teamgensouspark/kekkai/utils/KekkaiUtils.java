package io.github.teamgensouspark.kekkai.utils;

import java.util.List;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;

public class KekkaiUtils {
    public static <T> T randomfromList(List<T> list) {
        if (list.size() == 0) {
            return null;
        }
        return list.get(KekkaiModInfo.RND.nextInt(list.size()));
    }
}
