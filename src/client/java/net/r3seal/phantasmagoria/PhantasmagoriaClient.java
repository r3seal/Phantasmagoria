package net.r3seal.phantasmagoria;

import net.fabricmc.api.ClientModInitializer;
import net.r3seal.phantasmagoria.entity.ModEntityRenderer;

public class PhantasmagoriaClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ModEntityRenderer.register();
	}
}