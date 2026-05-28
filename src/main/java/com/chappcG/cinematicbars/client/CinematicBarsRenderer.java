package com.chappcG.cinematicbars.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.chappcG.cinematicbars.CinematicBarsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = CinematicBarsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class CinematicBarsRenderer {
    
    private static final int BAR_HEIGHT = 40; // Height of cinematic bars in pixels
    private static final int BAR_COLOR = 0xFF000000; // Black color with full opacity

    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        
        if (minecraft.screen == null) {
            GuiGraphics guiGraphics = event.getGuiGraphics();
            int screenWidth = minecraft.getWindow().getWidth();
            int screenHeight = minecraft.getWindow().getHeight();
            
            // Render top cinematic bar
            guiGraphics.fill(0, 0, screenWidth, BAR_HEIGHT, BAR_COLOR);
            
            // Render bottom cinematic bar
            guiGraphics.fill(0, screenHeight - BAR_HEIGHT, screenWidth, screenHeight, BAR_COLOR);
        }
    }
}
