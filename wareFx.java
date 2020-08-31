
//this class will store the function from staff function and customer function
import java.util.*;
import java.io.*;

public class wareFx {
    // function display the list oof warehouse
    public void listWarehouse(Scanner list) {
        String name;
        while (list.hasNext()) {
            name = list.next();
            System.out.println(name.substring(0, 10));
        }

    }

    // function to add Warehouse.(Add the new element into dynamically array and
    // create new file)
    // the name of file will be add 1 to the number of warehouses
    public void addWarehouse(Scanner wHouse) {
        String nName;
        int num;
        num = numWarehouse(wHouse);
        String str1 = "Warehouse";
        String str2 = ".csv";
        int str3 = num + 1;
        nName = (str1 + str3 + str2);
        try {
            Writer myWriter;
            myWriter = new BufferedWriter(new FileWriter("WarehouseList.txt", true));
            myWriter.append("\n" + nName);
            myWriter.close();
            File newFile = new File(nName);
            newFile.createNewFile();
            System.out.println("Done Added Warehouse");
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // remove the warehouse file and update it to the array
    public void removeWarehouse(Scanner in, Scanner wHouse) {
        List<Warehouse> wList = new ArrayList<Warehouse>();
        wList = wArray(wHouse);
        System.out.println("Enter the name of the Warehouse that you want to remove");
        String name = in.next();
        File rem = new File(name);
        File ware = new File("WarehouseList.txt");
        wHouse.close();
        rem.delete();
        System.out.println("Deleted file name: " + name);
        ware.delete();

        for (int i = 0; i < wList.size(); i++) {
            if (wList.get(i).getName().equals(name)) {
                wList.remove(i);
                break;
            }
        }
        try {
            ware.createNewFile();
            FileWriter myWriter = new FileWriter(ware);
            for (int i = 0; i < wList.size(); i++) {
                myWriter.write(wList.get(i).getName());
                myWriter.write(System.lineSeparator());
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // convert the list of wrehouse into the dynamic array
    public List<Warehouse> wArray(Scanner in) {
        List<Warehouse> wList = new ArrayList<Warehouse>();
        String name;
        while (in.hasNext()) {
            name = in.next();
            Warehouse ware = new Warehouse(name);
            wList.add(ware);
        }

        return wList;
    }

    // function to display list of items
    public void viewItem(List<Item> v1, int num) {
        System.out.printf("%-4s%-10s%-30s\n", "ID", "Name", "Details");
        for (int i = 0; i < v1.size(); i++) {
            System.out.printf("%-4s%-10s%-30s\n", v1.get(i).getID(), v1.get(i).getName(), v1.get(i).getDetails());

        }
    }

    // function to add new item. ( add new element into the dynamically array)
    public void addItem(List<Item> v1, Scanner in, int numList) {
        String newID;
        System.out.println();
        System.out.println("Enter your item name name");
        String n = in.next();
        System.out.println("Enter your item detail");
        String detail = in.next();
        int nID = v1.size() + 1;
        newID = String.valueOf(nID);
        Item it = new Item(newID, n, detail);
        v1.add(it);
        System.out.println("Done add Item");
    }

    // function to remove item. (delete item from the dynamically arrawy)
    public void removeItem(List<Item> v1, Scanner in) {
        System.out.printf("%-4s%-10s%-30s\n", "ID", "Name", "Details");
        for (int i = 0; i < v1.size(); i++) {
            System.out.printf("%-4s%-10s%-30s\n", v1.get(i).getID(), v1.get(i).getName(), v1.get(i).getDetails());

        }
        System.out.println("Enter your item to remove");
        String n = in.next();
        System.out.println("The item name to remove " + n);
        int i = 0;
        while (i < v1.size()) {
            if (v1.get(i).getName().equals(n)) {
                v1.remove(i);
            }
            i++;
        }
    }

    // function to choose warehouse
    // display the wrehouse name from txt file and display it. and than return the
    // name fo the file that user entered
    public String chooseWarehouse(Scanner in, Scanner myReader) {
        String ware = "n";
        System.out.println();
        System.out.println("Choose Warehouse and Enter the file name: ");
        while (myReader.hasNextLine()) {
            String name;
            name = myReader.nextLine();
            System.out.println(name);
        }
        ware = in.next();
        return ware;
    }

    // function to return number of warehouse
    public int numWarehouse(Scanner in) {
        Warehouse[] wList = new Warehouse[20];
        int i = 0;

        String name;
        while (in.hasNext()) {
            name = in.next();
            wList[i] = new Warehouse(name);
            i++;
        }
        return i;
    }
}