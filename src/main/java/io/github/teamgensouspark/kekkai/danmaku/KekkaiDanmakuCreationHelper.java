package io.github.teamgensouspark.kekkai.danmaku;

import net.katsstuff.teamnightclipse.danmakucore.DanmakuCore;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuState;
import net.katsstuff.teamnightclipse.danmakucore.danmaku.DanmakuTemplate;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.DanmakuCreationHelper;
import net.katsstuff.teamnightclipse.danmakucore.shape.Shape;
import scala.collection.Set;

public class KekkaiDanmakuCreationHelper {
    public static Set<DanmakuState> createWideShot(DanmakuTemplate danmaku, Integer amount, Float wideAngle,
            Float baseAngle, Double distance, Boolean spawnDanmaku) {
        return DanmakuCreationHelper.createWideShot(danmaku, amount, wideAngle, baseAngle, distance, spawnDanmaku);
    }

    public static Set<DanmakuState> createWideShot(DanmakuTemplate danmaku, Integer amount, Float wideAngle,
            Float baseAngle, Double distance) {
        return DanmakuCreationHelper.createWideShot(danmaku, amount, wideAngle, baseAngle, distance, true);
    }

    public static Set<DanmakuState> createCircleShot(DanmakuTemplate danmaku, Integer amount,
            Float baseAngle, Double distance, Boolean spawnDanmaku) {
        return DanmakuCreationHelper.createCircleShot(danmaku, amount, baseAngle, distance, spawnDanmaku);
    }

    public static Set<DanmakuState> createCircleShot(DanmakuTemplate danmaku, Integer amount,
            Float baseAngle, Double distance) {
        return DanmakuCreationHelper.createCircleShot(danmaku, amount, baseAngle, distance, true);
    }

    public static Set<DanmakuState> createRingShot(DanmakuTemplate danmaku, Integer amount, Float size,
            Float baseAngle, Double distance, Boolean spawnDanmaku) {
        return DanmakuCreationHelper.createRingShot(danmaku, amount, size, baseAngle, distance, spawnDanmaku);
    }

    public static Set<DanmakuState> createRingShot(DanmakuTemplate danmaku, Integer amount, Float size,
            Float baseAngle, Double distance) {
        return DanmakuCreationHelper.createRingShot(danmaku, amount, size, baseAngle, distance, true);
    }

    public static Set<DanmakuState> createRandomRingShot(DanmakuTemplate danmaku, Integer amount, Float size,
            Double distance, Boolean spawnDanmaku) {
        return DanmakuCreationHelper.createRandomRingShot(danmaku, amount, size, distance, spawnDanmaku);
    }

    public static Set<DanmakuState> createRandomRingShot(DanmakuTemplate danmaku, Integer amount, Float size,
            Double distance) {
        return DanmakuCreationHelper.createRandomRingShot(danmaku, amount, size, distance, true);
    }

    public static Set<DanmakuState> createSphereShot(DanmakuTemplate danmaku, Integer rings, Integer bands,
            Float baseAngle, Double distance, Boolean spawnDanmaku) {
        return DanmakuCreationHelper.createSphereShot(danmaku, rings, bands, baseAngle, distance, spawnDanmaku);
    }

    public static Set<DanmakuState> createSphereShot(DanmakuTemplate danmaku, Integer rings, Integer bands,
            Float baseAngle, Double distance) {
        return DanmakuCreationHelper.createSphereShot(danmaku, rings, bands, baseAngle, distance, true);
    }

    public static Set<DanmakuState> drawSingle(DanmakuTemplate danmaku, Shape shape, Boolean spawnDanmaku) {
        Set<DanmakuState> res = shape.draw(danmaku.pos(), danmaku.orientation(), 0).spawnedDanmaku();
        if (spawnDanmaku) {
            DanmakuCore.proxy().spawnDanmaku(res.toSeq());
        }
        return res;
    }

    public static Set<DanmakuState> drawSingle(DanmakuTemplate danmaku, Shape shape) {
        Set<DanmakuState> res = shape.draw(danmaku.pos(), danmaku.orientation(), 0).spawnedDanmaku();
        DanmakuCore.proxy().spawnDanmaku(res.toSeq());
        return res;
    }
}
