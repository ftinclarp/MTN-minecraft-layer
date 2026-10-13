package mtn.minecraft_layer.net.minecraft.util;

import java.util.Objects;

/**
 * Dummy stand-in for {@code net.minecraft.util.ResourceLocation} (Forge 1.7.10).
 * Carries a domain/path pair; no registry access.
 */
public class ResourceLocation {
    public final String resourceDomain;
    public final String resourcePath;

    public ResourceLocation(String domain, String path) {
        this.resourceDomain = domain == null || domain.isEmpty() ? "minecraft" : domain;
        this.resourcePath = path;
    }

    public ResourceLocation(String combined) {
        int colon = combined.indexOf(':');
        if (colon >= 0) {
            this.resourceDomain = combined.substring(0, colon);
            this.resourcePath = combined.substring(colon + 1);
        } else {
            this.resourceDomain = "minecraft";
            this.resourcePath = combined;
        }
    }

    public String getResourceDomain() {
        return resourceDomain;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    @Override
    public String toString() {
        return resourceDomain + ":" + resourcePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ResourceLocation that)) {
            return false;
        }
        return resourceDomain.equals(that.resourceDomain) && resourcePath.equals(that.resourcePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceDomain, resourcePath);
    }
}
