package pojo;

import java.util.List;

public class Item_list {

    public ShippingAddress getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(ShippingAddress shipping_address) {
        this.shipping_address = shipping_address;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    private ShippingAddress shipping_address;
    private List<Items> items;

}
