package mtn.minecraft_layer.net.minecraft.network;

/**
 * Stand-in for {@code net.minecraft.network.Packet} (Forge 1.7.10).
 *
 * <p>The layer's {@code Packet} is a concrete base for Forge-side packets such as
 * {@code FMLProxyPacket}. 1.7.10 {@code Packet} carries serialization responsibility,
 * so our proxy subclasses perform the real serialization instead of this base doing
 * nothing meaningful.
 */
public class Packet {
}
