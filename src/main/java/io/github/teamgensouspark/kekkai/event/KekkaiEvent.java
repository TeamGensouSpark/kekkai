package io.github.teamgensouspark.kekkai.event;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.KekkaiModInfo;
import io.github.teamgensouspark.kekkai.enums.EnumTouhouCapacity;
import io.github.teamgensouspark.kekkai.utils.KekkaiHelper;
import io.github.teamgensouspark.kekkai.utils.KekkaiI18n;
import net.katsstuff.teamnightclipse.danmakucore.data.ShotData;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemDanmaku;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemSpellcard;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemDanmaku.Pattern;
import net.katsstuff.teamnightclipse.danmakucore.lib.LibColor;
import net.katsstuff.teamnightclipse.danmakucore.lib.data.LibSubEntities;
import net.katsstuff.teamnightclipse.mirror.data.Vector3;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = KekkaiModInfo.MODID)
public class KekkaiEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onAddTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof ItemSpellcard) {
            Spellcard card = ItemSpellcard.getSpellcard(stack);
            List<String> rebuild = new ArrayList<>();
            List<String> origin = event.getToolTip();
            rebuild.add(origin.get(0));
            rebuild.add(
                    String.format("%s%s %s", I18n.format("kekkai.tooltip.spellcard.level"), card.level(),
                            I18n.format("kekkai.tooltip.spellcard.spellcard")));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.spellcard.name"),
                    I18n.format(card.unlocalizedName())));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.spellcard.char"),
                    KekkaiI18n.getTouhouCharName(card.touhouUser())));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.spellcard.removeTime"), card.removeTime()));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.spellcard.endTime"), card.endTime()));
            origin.clear();
            origin.addAll(rebuild);
        }

        if (stack.getItem() instanceof ItemDanmaku) {
            ShotData shot = ShotData.fromNBTItemStack(stack);
            int amount = ItemDanmaku.Amount().get(stack);
            double shotSpeed = ItemDanmaku.Speed().get(stack);
            Pattern danmakuPattern = ItemDanmaku.DanPattern().get(stack);
            Vector3 gravity = ItemDanmaku.getGravity(stack);
            Boolean isInfinity = ItemDanmaku.Infinity().get(stack);
            Boolean custom = ItemDanmaku.Custom().get(stack);
            List<String> rebuild = new ArrayList<>();
            List<String> origin = event.getToolTip();
            rebuild.add(origin.get(0));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.damage"), shot.damage()));
            rebuild.add(String.format("%s%s %s %s", I18n.format("kekkai.tooltip.danmaku.size"), shot.sizeX(),
                    shot.sizeY(), shot.sizeZ()));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.amount"), amount));
            if (custom) {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.form"),
                        I18n.format(shot.form().unlocalizedName())));
            }
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.pattern"),
                    I18n.format("item.danmaku.pattern.".concat(danmakuPattern.toString()))));
            rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.speed"), shotSpeed));
            if (Math.round(gravity.x()) != 0d || Math.round(gravity.y()) != 0d || Math.round(gravity.z()) != 0d) {
                rebuild.add(String.format("%s%s %s %s", I18n.format("kekkai.tooltip.danmaku.gravity"), gravity.x(),
                        gravity.y(), gravity.z()));
            } else {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.gravity"),
                        I18n.format("kekkai.tooltip.danmaku.nogravity")));
            }
            if (LibColor.isNormalColor(shot.edgeColor())) {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.edgeColor"),
                        I18n.format(String.format("item.danmaku.color.%s", shot.edgeColor()))));
            } else {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.edgeColor"),
                        I18n.format("item.danmaku.color.custom")));
            }
            if (LibColor.isNormalColor(shot.coreColor())) {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.coreColor"),
                        I18n.format(String.format("item.danmaku.color.%s", shot.coreColor()))));
            } else {
                rebuild.add(String.format("%s%s", I18n.format("kekkai.tooltip.danmaku.coreColor"),
                        I18n.format("item.danmaku.color.custom")));
            }
            if (shot.subEntity() != LibSubEntities.DEFAULT_TYPE) {
                rebuild.add(String.format("%s%s", I18n.format("item.danmaku.color.subentity"),
                        I18n.format(shot.subEntity().unlocalizedName())));
            }
            if (isInfinity) {
                rebuild.add(I18n.format("item.danmaku.infinity"));
            }
            if (custom) {
                rebuild.add(I18n.format("item.danmaku.custom"));
            }

            origin.clear();
            origin.addAll(rebuild);
        }
    }

    @SubscribeEvent
    public static void dropPower(LivingDeathEvent event) {
        EntityLivingBase living = event.getEntityLiving();
        if (!living.isNonBoss() || living instanceof EntityPlayer) {
            if (!living.world.isRemote) {
                int max = KekkaiModInfo.RND.nextInt(4);
                for (int i = 0; i < max; i++) {
                    KekkaiHelper
                            .spawnTouhouCapacity(living.world, new Vector3(living),
                                    (Vector3) Vector3.directionToPos(new Vector3(living),
                                            (new Vector3(event.getSource().getImmediateSource()))),
                                    EnumTouhouCapacity.POWER);
                }
            }
        }
    }
}
