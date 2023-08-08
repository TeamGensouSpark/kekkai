package io.github.teamgensouspark.kekkai.event;

import java.util.ArrayList;
import java.util.List;

import io.github.teamgensouspark.kekkai.Consts;
import io.github.teamgensouspark.kekkai.utils.KekkaiI18n;
import net.katsstuff.teamnightclipse.danmakucore.entity.spellcard.Spellcard;
import net.katsstuff.teamnightclipse.danmakucore.item.ItemSpellcard;
import net.katsstuff.teamnightclipse.danmakucore.scalastuff.TouhouHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(modid = Consts.MODID)
public class KekkaiEvent {
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onAddTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof ItemSpellcard) {
            Spellcard card = ItemSpellcard.getSpellcard(stack);
            List<String> rebuild = new ArrayList<>();
            List<String> origin = event.getToolTip();
            rebuild.add(origin.get(0));
            rebuild.add(I18n.format("kekkai.tooltip.spellcard.level").concat(String.valueOf(card.level())));
            rebuild.add(I18n.format("kekkai.tooltip.spellcard.char")
                    .concat(KekkaiI18n.getTouhouCharName(card.touhouUser())));
            rebuild.add(I18n.format("kekkai.tooltip.spellcard.removeTime").concat(String.valueOf(card.removeTime())));
            rebuild.add(I18n.format("kekkai.tooltip.spellcard.endTime").concat(String.valueOf(card.endTime())));
            origin.clear();
            origin.addAll(rebuild);
        }
    }
}
