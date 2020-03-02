package com.github.draylar.betterhungertweaker.mixin;

import com.github.draylar.betterhungertweaker.BetterHungerTweaker;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {

    @Shadow private int foodLevel;

    @Shadow private float foodSaturationLevel;

    @Inject(at = @At("HEAD"), method = "eat")
    private void onEat(Item item, ItemStack itemStack, CallbackInfo ci) {
        if(item.equals(Items.BREAD)) {
            this.foodLevel = Math.min(item.getFoodComponent().getHunger() + this.foodLevel, 20);
            this.foodSaturationLevel = Math.min(this.foodSaturationLevel + BetterHungerTweaker.BREAD.get(), (float) this.foodLevel);
            ci.cancel();
        }
    }
}
