package io.github.teamgensouspark.kekkai.color;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.color.builder.ColorHelper;

public class AtomColors {
    // ATOM
    public static final List<Integer> ATOM_COLORS = new ArrayList<>();
    public static final ColorHelper ATOM_COLORS_HELPER = new ColorHelper(ATOM_COLORS);

    public static final int ATOM_COLOR_BLACK = ATOM_COLORS_HELPER.registColorfromHex("#282C34");
    public static final int ATOM_COLOR_BLUE = ATOM_COLORS_HELPER.registColorfromHex("#61AFEF");
    public static final int ATOM_COLOR_CYAN = ATOM_COLORS_HELPER.registColorfromHex("#56B6C2");
    public static final int ATOM_COLOR_GREEN = ATOM_COLORS_HELPER.registColorfromHex("#98C379");
    public static final int ATOM_COLOR_PURPLE = ATOM_COLORS_HELPER.registColorfromHex("#C678DD");
    public static final int ATOM_COLOR_RED = ATOM_COLORS_HELPER.registColorfromHex("#E06C75");
    public static final int ATOM_COLOR_WHITE = ATOM_COLORS_HELPER.registColorfromHex("#DCDFE4");
    public static final int ATOM_COLOR_YELLOW = ATOM_COLORS_HELPER.registColorfromHex("#E5C07B");

}
