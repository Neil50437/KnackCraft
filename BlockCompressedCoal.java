import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockCompressedCoal extends Block {

    public BlockCompressedCoal(int id, Material material) {
        super(id, material);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    @Override
          public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Pasta:CompressedCoal");
    }

}