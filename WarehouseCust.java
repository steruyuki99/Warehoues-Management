import java.util.*;
import java.io.*;

public class WarehouseCust {
    public void navi(Scanner ipt) {
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        wareFx wFx = new wareFx();
        try {
            int opt;
            String w = "File.txt";
            List<Item> itemList = new ArrayList<Item>();

            int numList = 0;
            Scanner wHouse = new Scanner(new FileReader("WarehouseList.txt"));
            opt = MainMenu(ipt);

            if (opt == 1 || opt == 2) {
                // Staff choose warehouse;
                w = wFx.chooseWarehouse(ipt, wHouse);
                System.out.println();
            }

            // readFile and onnvert it to array
            String line;
            fi = new FileInputStream(w);
            is = new InputStreamReader(fi);
            br = new BufferedReader(is);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Item item = new Item(data[0], data[1], data[2]);
                itemList.add(item);
                numList++;
            }
            br.close();

            switch (opt) {

                case 1:
                    wFx.viewItem(itemList, numList);
                    break;
                case 2:
                    wFx.removeItem(itemList, ipt);
                    break;
                default:
                    System.out.println("Didn't choose any function");
                    break;
            }

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

        } catch (FileNotFoundException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public int MainMenu(Scanner in) {
        int ans;
        System.out.println("-------- Choose Option(Customer) ------");
        System.out.println("1. View Item");
        System.out.println("2. Buy Item");
        System.out.println("Other: Not choose any action");
        ans = in.nextInt();
        return ans;
    }

}