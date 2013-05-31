import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;



public class WorldgeneratorWell implements IWorldGenerator


{
  public void generate(Random random, int chunkX, int chunkZ, WorldgeneratorWell world, IWorldGenerator chunkGenerator, IWorldGenerator chunkProvider)


    {
           private void generateSurface(World world, Random random, int blockX, int blockZ)
           {
               int Xcoord = blockX + random.nextInt(16);
               int Ycoord = random.nextInt(60);
               int Zcoord = blockZ + random.nextInt(16);

               (new WorldgeneratorWell(BlockCheese.blockID, 254)).generate(world, random, Xcoord, Ycoord, Zcoord);
           }

        ClassCastException: generate(Random random,  chunkX*16, chunkZ*16);
    }

}



