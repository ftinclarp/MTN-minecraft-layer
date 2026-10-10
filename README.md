# MTN-minecraft-layer

Minecraft 1.7.10 API stand-ins (`net.minecraft.*`) packaged as a Fabric
library mod. This is a pure library: **no entrypoint**, consumed via
`modImplementation`.

When a Forge 1.7.10 mod is ported, the transform rewrites
`net.minecraft.*` imports to `mtn.minecraft_layer.net.minecraft.*`, which
this artifact provides.

See MTN-forge-layer for the `cpw.mods.fml.*` half of the conpatibility
shim.
