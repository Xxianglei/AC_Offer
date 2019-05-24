package offer;

/**
 * 数据流中的中位数
 */

import java.util.*;

public class Offer41 {
    public static void main(String[] args) {
        // System.out.println("Hello");
        Offer41 s = new Offer41();
        s.Insert(5);
        s.Insert(4);
        s.Insert(3);
        s.Insert(6);
        s.GetMedian();


    }
    LinkedList<Integer> link = new LinkedList<Integer>();

    public void Insert(Integer num) {
        link.add(num);
    }

    public Double GetMedian() {
        double d = 0;
        Collections.sort(link);
        for (int k : link) {
            System.out.print(k + " ");
        }

        if (link.size() % 2 == 0) {
            d = ((double) link.get(link.size() / 2 - 1) + (double) link.get(link.size() / 2)) / 2;

        } else {

            d = link.get((link.size() + 1) / 2 - 1);
        }

        return d;
    }



}