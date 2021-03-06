import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import lib.Refrence;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;




@Mod( modid = Refrence.MOD_ID, name = Refrence.MOD_NAME, version = Refrence.VERSION)

@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class KnackCraft
{
    public static final String modid = "Refrence.MOD_ID";

    public static Block BlockCompressedCoal;

    public static Block BlockCompactCoal;

    public static Block BlockNuke;




    @SidedProxy(clientSide="ClientProxy", serverSide="CommonProxy")
    public static CommonProxy proxy;

    public static int startEntityId = 300;



    @Init
    public void Init(FMLInitializationEvent event)
    {

         //entities

        EntityRegistry.registerModEntity(EntityCharKarb.class, "CharKarb", 1, this, 80, 3, true);

        EntityRegistry.addSpawn(EntityCharKarb.class, 1, 0, 1, EnumCreatureType.creature, BiomeGenBase.hell);

        LanguageRegistry.instance().addStringLocalization("entity.KackCraft.CharKarb.name", "CharKarb");

        registerEntityEgg(EntityCharKarb.class, 0x4DF, 0x4DF);


        RenderingRegistry.registerEntityRenderingHandler(EntityCharKarb.class, new RenderLiving(new ModelCharKarb(), 0f));



         //Blocks

        BlockCompactCoal = new BlockCompactCoal(253, Material.rock).setUnlocalizedName("CompactCoal");

        GameRegistry.registerBlock(BlockCompactCoal, modid + BlockCompactCoal.getUnlocalizedName());

        LanguageRegistry.addName(BlockCompactCoal, "Compact Coal");


        BlockCompressedCoal = new BlockCompressedCoal(254, Material.rock).setUnlocalizedName("Compressed Coal");

        GameRegistry.registerBlock(BlockCompressedCoal, modid + BlockCompressedCoal.getUnlocalizedName());

        LanguageRegistry.addName(BlockCompressedCoal, "Compressed Coal");


        BlockNuke = new BlockNuke(255).setUnlocalizedName("Nuke");

        GameRegistry.registerBlock(BlockNuke, modid + BlockNuke.getUnlocalizedName());

        LanguageRegistry.addName(BlockNuke, "Nuke");







        //Smelting

        GameRegistry.addSmelting(Block.blockRedstone.blockID, new ItemStack(Block.stoneBrick), 0.1f);


        GameRegistry.addSmelting(BlockCompressedCoal.blockID, new ItemStack(BlockCompactCoal), 0.1f);






        //Shapless Crafting

        GameRegistry.addShapelessRecipe(new ItemStack(Item.flintAndSteel), new Object[]{
                new ItemStack(Item.flint), new ItemStack(Item.ingotIron),

        });

        GameRegistry.addShapelessRecipe(new ItemStack(Block.waterlily), new Object[]{
                new ItemStack(Item.slimeBall), new ItemStack(Block.vine)

        });



        //Shaped Crafting

        GameRegistry.addRecipe(new ItemStack(Block.portal), new Object[]{
                "OOO",
                "OYO",
                "OOO",
                'O', Block.obsidian, 'Y', Item.flintAndSteel});
        GameRegistry.addRecipe(new ItemStack(Block.whiteStone, 8), new Object[]{
                "CCC",
                "COC",
                "CCC",
                'C', Block.slowSand, 'O', Item.eyeOfEnder});
        GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{
                "CCC",
                "COC",
                "OPO",
                'C', Item.leather, 'O', Item.ingotIron});
        GameRegistry.addRecipe(new ItemStack(Item.saddle), new Object[]{
                "CCC",
                "COC",
                "OPO",
                'C', Item.leather, 'O', Item.ingotIron});
        GameRegistry.addRecipe(new ItemStack(BlockCompressedCoal), new Object[]{
                "CCC",
                "CCC",
                "CCC",
                'C', Item.coal});
        GameRegistry.addRecipe(new ItemStack(Block.oreDiamond), new Object[]{
                "CCC",
                "CCC",
                "CCC",
                'C', BlockCompactCoal
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