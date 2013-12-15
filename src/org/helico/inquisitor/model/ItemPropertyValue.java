package org.helico.inquisitor.model;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 14.12.13
 * Time: 4:04
 * To change this template use File | Settings | File Templates.
 */
public class ItemPropertyValue {

    public ItemPropertyValue(long itemId, long propertyValueId) {
        this.itemId = itemId;
        this.propertyValueId = propertyValueId;
    }

    private long itemId;

    private long propertyValueId;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getPropertyValueId() {
        return propertyValueId;
    }

    public void setPropertyValueId(long propertyValueId) {
        this.propertyValueId = propertyValueId;
    }
}
