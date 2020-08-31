import java.util.*;
import java.io.*;

public class WarehouseStaff {
    public void navi(Scanner ipt) {
        // declare input stream for csv file
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        wareFx wfx = new wareFx(); // declare class for functions
        try {
            int opt;
            String w = "File.txt";
            List<Item> itemList = new ArrayList<Item>();

            int numList = 0;
            Scanner wHouse = new Scanner(new FileReader("WarehouseList.txt"));

            // display the main maenu
            opt = MainMenu(ipt);
            if (opt == 4 || opt == 5 || opt == 6) {
                // Staff choose warehouse;
                w = wfx.chooseWarehouse(ipt, wHouse);
                System.out.println();
                // readFile and onnvert it to array
                String line;
                fi = new FileInputStream(w);
                is = new InputStreamReader(fi);
                br = new BufferedReader(is);

                // read the data from csv and store it in the array
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    Item item = new Item(data[0], data[1], data[2]);
                    itemList.add(item);
                    numList++;
                }
                br.close();
            }

            // to switch the function
            switch (opt) {
                case 1:
                    wfx.listWarehouse(wHouse);
                    break;
                case 2:
                    wfx.addWarehouse(wHouse);
                    break;
                case 3:
                    wfx.removeWarehouse(ipt, wHouse);
                    break;
                case 4:
                    wfx.viewItem(itemList, numList);
                    break;
                case 5:
                    wfx.addItem(itemList, ipt, numList);
                    break;
                case 6:
                    wfx.removeItem(itemList, ipt);
                    break;
                default:
                    System.out.println("Didn't choose any function");
                    break;
            }

            // overwrite the data into the file
            if (opt == 4 || opt == 5 || opt == 6) {
                File ware = new File(w);
                FileWriter myWriter = new FileWriter(ware);
                for (int i = 0; i < itemList.size(); i++) {
                    myWriter.append(itemList.get(i).getID());
                    myWriter.append(",");
                    myWriter.append(itemList.get(i).getName());
                    myWriter.append(",");
                    myWriter.append(itemList.get(i).getDetails());
                    myWriter.write(System.lineSeparator());
                }
                myWriter.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // Display Staff Menu
    public int MainMenu(Scanner in) {
        int ans;
        System.out.println("-------- Choose Option (Staff) ------");
        System.out.println("1. List Warehouse");
        System.out.println("2. Add Warehouse");
        System.out.println("3. Remove Warehouse");
        System.out.println("4. View Item");
        System.out.println("5. Add Item");
        System.out.println("6. Remove Item");
        System.out.println("Other: Not choose any action");
        ans = in.nextInt();
        return ans;
    }

}
