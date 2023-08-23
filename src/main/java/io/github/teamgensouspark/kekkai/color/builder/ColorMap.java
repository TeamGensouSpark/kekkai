package io.github.teamgensouspark.kekkai.color.builder;

import java.util.Arrays;
import java.util.List;

import io.github.teamgensouspark.kekkai.Kekkai;

public class ColorMap {
    int length;
    KekkaiColor normal;

    public ColorMap(int length, KekkaiColor normal) {
        this.length = length;
        if (length % 2 != 1) {
            Kekkai.logger.warn(String.format("<%s> length is illegal", this.toString()));
        }
    }

    public List<Integer> getListRGB() {
        int iter_num = (length - 1) / 2;

        List<Integer> result = Arrays.asList(normal.getRGB());
        KekkaiColor darker = normal.getDarkderColor();
        KekkaiColor lighter = normal.getBrighterColor();

        for (int i = 0; i < iter_num; i++) {
            result.add(0, darker.getRGB());
            result.add(lighter.getRGB());
        }

        return result;
    }

}
