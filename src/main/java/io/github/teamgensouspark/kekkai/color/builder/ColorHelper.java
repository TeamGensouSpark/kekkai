package io.github.teamgensouspark.kekkai.color.builder;

import java.awt.Color;
import java.util.List;
import java.util.Random;

public class ColorHelper {
    private List<Integer> color_collection;
    private Random random;

    public ColorHelper(List<Integer> color_collection) {
        this.color_collection = color_collection;
        this.random = new Random();
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
        return Color.decode(hex).getRGB();
    }

    public int randomColor() {
        return color_collection.get(random.nextInt(color_collection.size()));
    }

    // static
    public static int createColorfromRGB(int red, int green, int blue) {
        return new Color(red, green, blue).getRGB();
    }

    public static int createColorfromHex(String hex) {
        return Color.decode(hex).getRGB();
    }
}
