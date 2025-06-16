package Partitioning.KeyValueHashing;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = 1;
            SortedStringTable<Object> sst = new SortedStringTable<>(5);
            Slot<Object> slot;
            while(t != 0) {
                System.out.println("Enter value : ");
                t = sc.nextInt();
                switch(t) {
                    case 1 -> {
                        System.out.println("Enter value type : ");
                        int x = sc.nextInt();
                        switch(x) {
                            case 1 -> {
                                int a = sc.nextInt();
                                sst.addDataToSlot(a);
                            } case 2 -> {
                                String s = sc.next();
                                sst.addDataToSlot(s);
                            } case 3 -> {
                                double d = sc.nextDouble();
                                sst.addDataToSlot(d);
                            } default -> {
                                boolean f = false;
                                sst.addDataToSlot(f);
                            }
                        }
                        System.out.println("Slots balancing...");
                    }
                    case 2 -> {
                        System.out.println("Peeking top slot : ");
                        slot = sst.peekLightSlot();
                        slot.showData();
                    }
                    case 3 -> {
                        System.out.println("Load factors : ");
                        sst.loadFactorList();
                    }
                    case 4 -> {
                        int q = sc.nextInt();
                        System.out.println("Showing slot "+q+" data");
                        sst.getSlotByIndex(q).showData();
                    }
                    default -> {t = 0;}
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
