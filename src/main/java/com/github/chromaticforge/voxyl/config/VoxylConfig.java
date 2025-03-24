package com.github.chromaticforge.voxyl.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Checkbox;
import cc.polyfrost.oneconfig.config.annotations.Text;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import com.github.chromaticforge.voxyl.VoxylUtils;

public class VoxylConfig extends Config {
    @Checkbox(name = "Auto GG")
    public static boolean gg = true;

    @Text(name = "GG Text")
    public static String ggText = "gg";

    @Checkbox(name = "Auto GL")
    public static boolean gl = false;

    @Text(name = "GL Text")
    public static String glText = "gl";

    public VoxylConfig() {
        super(new Mod(VoxylUtils.NAME, ModType.UTIL_QOL), VoxylUtils.ID + ".json");
        initialize();

        addDependency("ggText", "gg");
        addDependency("glText", "gl");
    }
}
