package me.lulu.datounms.v1_17_R1;

import me.lulu.datounms.BiomeHandler;
import me.lulu.datounms.model.biome.BiomeData;
import me.lulu.datounms.model.biome.BiomeMapping;
import me.lulu.datounms.model.biome.BiomeMapping1_17;
import me.lulu.datounms.utils.ReflectionUtil;
import net.minecraft.data.RegistryGeneration;
import net.minecraft.data.worldgen.biome.BiomeRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.BiomeBase;
import net.minecraft.world.level.biome.Biomes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BiomeReplacer implements BiomeHandler {

    private Map<String, BiomeBase> biomeBackup = new HashMap<>();
    private BiomeMapping mapping = new BiomeMapping1_17();

    public BiomeReplacer() {
        List<BiomeBase> base = RegistryGeneration.i.g().collect(Collectors.toList());
        for (BiomeBase b : base) {
            biomeBackup.put(RegistryGeneration.i.getKey(b).getKey().toLowerCase(), b);
        }
    }

    @Override
    public void swap(BiomeData from, BiomeData to) throws Exception {
        try {
            Method method = BiomeRegistry.class.getDeclaredMethod("a", int.class, ResourceKey.class, BiomeBase.class);
            method.setAccessible(true);
            method.invoke(null,
                    from.getId(),
                    ReflectionUtil.getStaticFieldContent(Biomes.class, mapping.getField(to)),
                    biomeBackup.get(mapping.getField(to))
            );
        } catch (InvocationTargetException ex) {
            //ignore, just mojang throws a warn
        }
    }

    @Override
    public void swap(BiomeData to) {
    }
}
