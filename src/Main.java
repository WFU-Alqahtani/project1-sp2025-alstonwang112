import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Item[] store = setupStore();
        ArrayList<Item> cart = createCart(args, store);
        printReceiptInOrder(cart);
        emptyCartReverseOrder(cart);
    }

    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("iPhone 16 Pro", 999);
        store[1] = new Item("AirPods Pro 2", 249);
        store[2] = new Item("Apple Watch Ultra 2", 799);
        store[3] = new Item("MacBook Pro", 1599);
        store[4] = new Item("iPad Pro", 999);
        return store;
    }

    public static ArrayList<Item> createCart(String[] args, Item[] store) {
        int n = 0;
        int limit = args.length;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e1) {
            System.out.println("\"" + args[0] + "\" is not a valid integer.");
            System.exit(1);
        }
        ArrayList<Item> cart = new ArrayList<>(n);
        if (limit == 1) {
            System.out.println("No valid input to cart.");
            System.exit(1);
        } else {
            for (int i = 1; i < limit; i++) {
                if (i > n)
                    break;
                try {
                    cart.add(store[Integer.parseInt(args[i])]);
                } catch (NumberFormatException e2) {
                    System.out.println("\"" + args[i] + "\" is not a valid integer.");
                    if (i == limit - 1)
                        System.exit(1);
                } catch (ArrayIndexOutOfBoundsException e3) {
                    System.out.println("The store does not have an item of index " + Integer.parseInt(args[i]) + ".");
                    if (i == limit - 1)
                        System.exit(1);
                }
            }
        }
        return cart;
    }

    public static void printReceiptInOrder(ArrayList<Item> cart) {
        System.out.println("Receipt");
        System.out.println("============================");
        System.out.println("Item                   Price");
        int size = cart.size();
        double subtotal = 0;
        for (int i = 0; i < size; i++) {
            String itemName = cart.get(i).getItemName();
            switch (itemName) {
                case "iPhone 16 Pro":
                case "AirPods Pro 2":
                    System.out.println(itemName + "          " + cart.get(i).getItemPrice());
                    break;
                case "Apple Watch Ultra 2":
                    System.out.println(itemName + "    " + cart.get(i).getItemPrice());
                    break;
                case "MacBook Pro":
                    System.out.println(itemName + "            " + cart.get(i).getItemPrice());
                    break;
                case "iPad Pro":
                    System.out.println(itemName + "               " + cart.get(i).getItemPrice());
                    break;
            }
            subtotal += cart.get(i).getItemPrice();
        }
        System.out.println("============================");
        double total = subtotal * 1.05;
        System.out.printf("(a) Subtotal: %.2f\n", subtotal);
        System.out.println("(b) Sales Tax: 5%");
        System.out.printf("(c) Total: %.2f\n", total);
    }

    public static void emptyCartReverseOrder(ArrayList<Item> cart) {
        System.out.println("Removing all items from the cart in \"Last In First Out\" order");
        int index = cart.size() - 1;
        for (int i = index; i >= 0; i--) {
            System.out.println("Removing: " + cart.get(i).getItemName());
            cart.remove(i);
        }
        System.out.println("Cart has been emptied");
    }
}