import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item[] store = setupStore();
        ArrayList<Item> cart = createCart(args, store);
        printReceiptInOrder(cart, store);
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
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e1) {
            System.out.println("\"" + args[0] + " is not a valid integer.");
            System.exit(1);
        }
        ArrayList<Item> cart = new ArrayList<>(n);
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                index[i] = Integer.parseInt(args[i + 1]);
                cart.add(store[index[i]]);
            } catch (NumberFormatException e2) {
                System.out.println("\"" + n + " is not a valid integer.");
            } catch (ArrayIndexOutOfBoundsException e3) {
                System.out.println("The store does not have an item of index " + args[0]);
            }
        }
        return cart;
    }

    public static void printReceiptInOrder(ArrayList<Item> cart, Item[] store) {
        System.out.println("Receipt");
        System.out.println("============================");
        System.out.println("Item                   Price");
        int size = cart.size();
        double subtotal = 0;
        for (int i = 0; i < size; i++) {
            String itemName = cart.get(i).getItemName();
            if (itemName.equals("iPhone 16 Pro") || itemName.equals("AirPods Pro 2")) {
                System.out.println(itemName + "          " + cart.get(i).getItemPrice());
            } else if (itemName.equals("Apple Watch Ultra 2")) {
                System.out.println(itemName + "    " + cart.get(i).getItemPrice());
            } else if (itemName.equals("MacBook Pro")) {
                System.out.println(itemName + "            " + cart.get(i).getItemPrice());
            } else if (itemName.equals("iPad Pro")) {
                System.out.println(itemName + "               " + cart.get(i).getItemPrice());
            }
            subtotal += cart.get(i).getItemPrice();
        }
        System.out.println("============================");
        double total = subtotal * 1.05;
        System.out.printf("(a) Subtotal: %.2f\n", subtotal);
        System.out.println("(b) Sales Tax: 5%");
        System.out.printf("(c) Total: %.2f\n", total);
    }
}