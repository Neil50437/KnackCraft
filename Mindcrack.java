import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import neil.lib.refrence.Refrence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;




@Mod( modid = Refrence.MOD_ID, name = Refrence.MOD_NAME, version = Refrence.VERSION)

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Mindcrack
{
    public static final String modid = "pasta";

    public static Block CheeseBlock;

    public static Item CheeseItem;



    @SidedProxy(clientSide="ClientProxy", serverSide="CommonProxy")
    public static CommonProxy proxy;

    public static int startEntityId = 300;



    @Init
    public void Init(FMLInitializationEvent event)
    {
        EntityRegistry.registerModEntity(EntityGuude.class, "Guude", 1, this, 80, 3, true);


        LanguageRegistry.instance().addStringLocalization("entity.Guude_Pasta.Guude.name", "Guude");

        CheeseBlock = new BlockCheese(254, Material.rock).setUnlocalizedName("CheeseBlock");


        EntityRegistry.addSpawn(EntityGuude.class, 1, 0, 1, EnumCreatureType.monster, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.plains);



        GameRegistry.registerBlock(CheeseBlock, modid + CheeseBlock.getUnlocalizedName());

        LanguageRegistry.addName(CheeseBlock, "Cheese Block");

        registerEntityEgg(EntityGuude.class, 0xEDF777, 000000);

        CheeseItem = new ItemCheese(5000, 2, 1f, true).setUnlocalizedName("Cheese");

        LanguageRegistry.addName(CheeseItem, "Cheese");

        GameRegistry.registerWorldGenerator(new WorldgeneratorWell());








        GameRegistry.addShapelessRecipe(new ItemStack(CheeseBlock), new Object[]{
                new ItemStack(Item.bucketMilk), new ItemStack(Block.sponge), new ItemStack(Item.bowlSoup)
        });


        GameRegistry.addRecipe(new ItemStack(CheeseItem), new Object[]{
                "XYX",
                "YYY",
                "   ",
                'X', Item.bucketMilk, 'Y', Item.egg});
        GameRegistry.addRecipe(new ItemStack(CheeseBlock), new Object[]{
                 "CCC",
                 "CCC",
                 "CCC",
                  'C', CheeseItem
        });
    }


    public static int getUniqueEntityId()
        {
            do
            {
                startEntityId++;        //I MADE IT HAPPY :D
            }
            while(EntityList.getStringFromID(startEntityId) != null);


            return startEntityId;
        }

    public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor)
    {
         int id = getUniqueEntityId();
        EntityList.IDtoClassMapping.put(id, entity);
        EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    }

}