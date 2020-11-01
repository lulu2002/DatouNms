package me.lulu.datounms.v1_16_R2;

import me.lulu.datounms.BiomeHandler;
import me.lulu.datounms.model.BiomeData;
import net.minecraft.server.v1_16_R2.*;
import org.mineacademy.fo.ReflectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeReplacer implements BiomeHandler {

    Map<String, BiomeBase> biomeBackup = new HashMap<>();

    public BiomeReplacer() {
        List<BiomeBase> base = RegistryGeneration.WORLDGEN_BIOME.g().collect(Collectors.toList());
        for (BiomeBase b : base) {
            biomeBackup.put(RegistryGeneration.WORLDGEN_BIOME.getKey(b).getKey(), b);
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) throws Exception {
        Method method = BiomeRegistry.class.getDeclaredMethod("a", int.class, ResourceKey.class, BiomeBase.class);
        method.setAccessible(true);
        method.invoke(null,
                from.getId(),
                ReflectionUtil.getStaticFieldContent(Biomes.class, to.name()),
                biomeBackup.get(to.getKey_1_13().toLowerCase())
        );
    }

    @Override
    public void swap(BiomeData to) {
    }
}
