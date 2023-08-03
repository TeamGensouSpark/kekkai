package io.github.teamgensouspark.kekkai.color.builder;

import java.util.ArrayList;
import java.util.Collections;
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

        KekkaiColor ndark = normal.getDarkderColor();
        KekkaiColor nlight = normal.getBrighterColor();

        List<Integer> result = new ArrayList<>();
        List<Integer> dark = new ArrayList<>();
        List<Integer> light = new ArrayList<>();

        for (int i = 0; i < iter_num; i++) {
            dark.add(ndark.getRGB());
            light.add(nlight.getRGB());

            ndark = ndark.getDarkderColor();
            nlight = nlight.getBrighterColor();
        }
        Collections.reverse(dark);
        result.addAll(dark);
        result.add(normal.getRGB());
        result.addAll(light);
        return result;
    }

}
