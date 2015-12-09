package storagecraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import storagecraft.SC;
import storagecraft.inventory.ContainerController;
import storagecraft.tile.TileController;

public class GuiHandler implements IGuiHandler {
	private Container getContainer(int ID, EntityPlayer player) {
		switch (ID) {
			case SC.GUI.CONTROLLER:
				return new ContainerController(player);
			default:
				return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return getContainer(ID, player);
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tile = world.getTileEntity(x, y, z);

		switch (ID) {
			case SC.GUI.CONTROLLER:
				return new GuiController(getContainer(ID, player), (TileController) tile);
			default:
				return null;
		}
	}
}
