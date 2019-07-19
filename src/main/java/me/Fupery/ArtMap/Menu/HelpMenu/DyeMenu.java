package me.Fupery.ArtMap.Menu.HelpMenu;

import me.Fupery.ArtMap.ArtMap;
import me.Fupery.ArtMap.Colour.ArtDye;
import me.Fupery.ArtMap.Colour.DyeType;
import me.Fupery.ArtMap.Config.Lang;
import me.Fupery.ArtMap.Menu.API.BasicMenu;
import me.Fupery.ArtMap.Menu.API.ChildMenu;
import me.Fupery.ArtMap.Menu.Button.Button;
import me.Fupery.ArtMap.Menu.Button.CloseButton;
import me.Fupery.ArtMap.Menu.Button.StaticButton;
import me.Fupery.ArtMap.Menu.Handler.CacheableMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class DyeMenu extends BasicMenu implements ChildMenu {

    public DyeMenu() {
        super(Lang.MENU_DYES.get(), InventoryType.CHEST);
    }

    @Override
    public Button[] getButtons() {
        Button[] buttons = new Button[27];
        ArtDye[] dyes = ArtMap.getDyePalette().getDyes(DyeType.DYE);
        buttons[0] = new StaticButton(Material.SIGN, Lang.Array.INFO_DYES.get());
        buttons[26] = new CloseButton();

        for (int i = 1; i < 26; i++) {
            ArtDye dye = dyes[i - 1];
            buttons[i] = new StaticButton(dye.toItem());
        }
        return buttons;
    }

    @Override
    public CacheableMenu getParent(Player viewer) {
        return ArtMap.getMenuHandler().MENU.HELP.get(viewer);
    }
}
