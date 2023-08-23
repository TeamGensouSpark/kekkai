package io.github.teamgensouspark.kekkai.color.builder;

import java.awt.Color;
import java.util.List;
import io.github.teamgensouspark.kekkai.utils.KekkaiUtils;

public class ColorHelper {
    private List<Integer> color_collection;

    public ColorHelper(List<Integer> color_collection) {
        this.color_collection = color_collection;
    }

    public List<Integer> getColors() {
        return color_collection;
    }

    public int registColorfromRGB(int red, int green, int blue) {
        int color = ColorHelper.createColorfromRGB(red, green, blue);
        this.color_collection.add(color);
        return color;
    }

    public int registColorfromRGB(int color) {
        this.color_collection.add(color);
        return color;
    }

    public int registColorfromHex(String hex) {
        int color = Color.decode(hex).getRGB();
        this.color_collection.add(color);
        return color;
    }

    public int randomColor() {
        return KekkaiUtils.randomfromList(color_collection);
    }

    // static
    public static int createColorfromRGB(int red, int green, int blue) {
        return new Color(red, green, blue).getRGB();
    }

    public static int createColorfromHex(String hex) {
        return Color.decode(hex).getRGB();
    }
}
