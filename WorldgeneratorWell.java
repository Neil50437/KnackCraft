import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;


class WorldgeneratorWellGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        chunkX = chunkX << 4;
        chunkZ = chunkZ << 4;

        if (!world.provider.isHellWorld)
        {
            int x, y, z;
            x = chunkX + random.nextInt(16);
            z = chunkZ + random.nextInt(16);
            y = 64 + random.nextInt(72);

            // set block in world
        }
    }
}