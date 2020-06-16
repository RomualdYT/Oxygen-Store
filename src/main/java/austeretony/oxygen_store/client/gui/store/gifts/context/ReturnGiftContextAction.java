package austeretony.oxygen_store.client.gui.store.gifts.context;

import austeretony.alternateui.screen.core.GUIBaseElement;
import austeretony.oxygen_core.client.api.ClientReference;
import austeretony.oxygen_core.client.gui.elements.OxygenContextMenu.OxygenContextMenuAction;
import austeretony.oxygen_store.client.gui.store.GiftsSection;
import austeretony.oxygen_store.client.gui.store.gifts.GiftPanelEntry;
import austeretony.oxygen_store.common.store.gift.EnumGiftType;

public class ReturnGiftContextAction implements OxygenContextMenuAction {

    private final GiftsSection section;

    public ReturnGiftContextAction(GiftsSection section) {
        this.section = section;
    }

    @Override
    public String getLocalizedName(GUIBaseElement currElement) {
        return ClientReference.localize("oxygen_store.gui.store.context.returnGift");
    }

    @Override
    public boolean isValid(GUIBaseElement currElement) {
        GiftPanelEntry entry = (GiftPanelEntry) currElement;
        return entry.getWrapped().getType() == EnumGiftType.PENDING;
    }

    @Override
    public void execute(GUIBaseElement currElement) {
        this.section.openReturnGiftCallback();
    }
}