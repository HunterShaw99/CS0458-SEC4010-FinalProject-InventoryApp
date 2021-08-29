import java.util.Scanner;

public class InventoryApp {

    //Explicitly typed items that are acceptable for a typical offices supplies.
    //This to help prevent unrelated input for office supply needs.
    enum ItemName {
        PAPERREAMS, WATERBOTTLES, MONITORS, DESKS, CHAIRS, COFFEE, CUPS,
        FILTERS, STAPLES, STAPLERS, STICKYNOTES, PENS, PENCILS,
        FOLDERS, BINDERS, PAPERCLIPS, TAPEROLLS, ERASERS, MARKERS,
        RUBBERBANDS, INKJAR, STAMPPADS, NOTEBOOKS, LETTERENVELOPES,
        CATALOGENVELOPES, SHIPPINGPAPER, SHIPPINGLABELS, CALENDARS,
        TONERCARTRIDGES, GLUESTICKS, THUMBTACKS, WHITEOUT, HIGHLIGHTERS
    }

    private static boolean checkName(String name) {
        for (ItemName n : ItemName.values()) {
            if (n.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static void printEnum() {
        System.out.println("Available item names for Office supplies");
        int counter = 0;
        for (ItemName n : ItemName.values()) {
            if (counter % 5 != 0) {
                System.out.print(" {" + n + "} ");
            } else {
                System.out.print("\n {" + n + "} ");
            }
            counter++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isCont = true;

        printEnum();
        System.out.println();
        do {
            System.out.println("Enter a product or enter q to exit");
            String name = scan.nextLine().toUpperCase();
            if (!name.equals("Q")) {
                if (checkName(name)) {
                    System.out.println("Enter amount");
                    int amount = scan.nextInt();
                    Item item = new Item(name, amount);
                    System.out.println(Data.addItem(name, item));
                    System.out.println(Data.getItem(name));
                    scan.nextLine();
                } else {
                    System.out.println("Wrong name of office object");
                }
            } else {
                isCont = false;
            }
        } while(isCont);

    }



}
