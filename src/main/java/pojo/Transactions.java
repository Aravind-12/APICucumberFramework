package pojo;

public class Transactions {

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PaymentOption getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(PaymentOption payment_options) {
        this.payment_options = payment_options;
    }

    public Item_list getItem_list() {
        return item_list;
    }

    public void setItem_list(Item_list item_list) {
        this.item_list = item_list;
    }

    private Amount amount;
    private String description;
    private PaymentOption payment_options;
    private Item_list item_list;

}
