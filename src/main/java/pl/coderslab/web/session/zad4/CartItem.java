package pl.coderslab.web.session.zad4;

class CartItem {
    public final String name;
    public final double quantity;
    public final double price;

    public CartItem(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
