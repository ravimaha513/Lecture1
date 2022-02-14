package com.leetcode.problems;

import java.util.*;
import java.util.stream.Stream;

public class SupplyChainBox {
}
class SupplyChainExample {
    public static void main(String[] args) {
        BoxChooser boxChooser = new BoxChooser();
        boxChooser.addBox("Small", 3, 3, 3);
        boxChooser.addBox("Medium", 4, 5, 4);
        boxChooser.addBox("Large", 8, 8, 8);
        boxChooser.addBox("Long", 12, 6, 6);
        boxChooser.addBox("Tall", 5, 5, 10);

       // System.out.println(BoxChooser.boxes);
        boxChooser.findSmallestBoxForProduct(1, 2, 1);
        boxChooser.findSmallestBoxForProduct(4, 3, 3);
        boxChooser.findSmallestBoxForProduct(9, 5, 5);

        assert "Small".equals(boxChooser.findSmallestBoxForProduct(1, 2, 1));
        assert "Medium".equals(boxChooser.findSmallestBoxForProduct(4, 3, 3));
        assert "Long".equals(boxChooser.findSmallestBoxForProduct(9, 5, 5));

    }
    /**
     * A Class that can store box options in memory via addBox(...)
     * And retrieve the best fitting (smallest) box for given product dimensions via findSmallestBoxForProduct(...)
     */
    public static class BoxChooser {
        static List<Box> boxes = new ArrayList<>();
        public void addBox(String boxName, int boxLength, int boxWidth, int boxHeight) {
            boxes.add(new Box(boxName, boxLength, boxWidth, boxHeight));
            Collections.sort(boxes);

        }
        public String findSmallestBoxForProduct(int productLength, int productWidth, int productHeight) {
            int minlen = Integer.MAX_VALUE, minWidth = Integer.MAX_VALUE, minHeight = Integer.MAX_VALUE;
            Box result = new Box();
            for(Box box : boxes){
                int currMinLen = box.getBoxLength() - productLength;
                if(currMinLen < minlen){
                    minlen = currMinLen;
                    int currMinWid = box.getBoxWidth() - productWidth;
                    if(currMinWid < minWidth){
                        minWidth = currMinWid;
                        int currMinHeight = box.getBoxHeight() - productHeight;
                        if(currMinHeight < minHeight){
                            minHeight = currMinHeight;
                            result = box;

                        }

                    }

                }
            }
            System.out.println(result);
            return result.toString();
        }

    }
}

class Box implements Comparable<Box>{
    String boxName; Integer boxLength, boxWidth, boxHeight;

    public Box(String boxName, Integer boxLength, Integer boxWidth, Integer boxHeight) {
        this.boxName = boxName;
        this.boxLength = boxLength;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    public Integer getBoxLength() {
        return boxLength;
    }

    public void setBoxLength(int boxLength) {
        this.boxLength = boxLength;
    }

    public Integer getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(int boxWidth) {
        this.boxWidth = boxWidth;
    }

    public Integer getBoxHeight() {
        return boxHeight;
    }

    public void setBoxHeight(int boxHeight) {
        this.boxHeight = boxHeight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxName='" + boxName + '\'' +
                ", boxLength=" + boxLength +
                ", boxWidth=" + boxWidth +
                ", boxHeight=" + boxHeight +
                '}';
    }

    public Box() {
    }

    @Override
    public int compareTo(Box o) {
        return this.boxHeight.compareTo(o.boxHeight) - (this.boxLength.compareTo(o.getBoxLength())) - (this.boxLength.compareTo(o.getBoxLength()));
       // return 0;
    }
}
