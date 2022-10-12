package gay.lemmaeof.realcurseofbinding;

import com.unascribed.ears.api.EarsFeatureType;
import com.unascribed.ears.api.registry.EarsInhibitorRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class RealCurseOfBinding implements ModInitializer {
	public static final String MODID = "realcurseofbinding";

	@Override
	public void onInitialize(ModContainer mod) {
		EarsInhibitorRegistry.register(MODID, ((type, peer) -> {
			if (peer instanceof PlayerEntity player) {
				return type == EarsFeatureType.CHEST && EnchantmentHelper.hasBindingCurse(player.getEquippedStack(EquipmentSlot.CHEST));
			}
			//theoretically unreachable but Just In Case
			return false;
		}));
	}
}
