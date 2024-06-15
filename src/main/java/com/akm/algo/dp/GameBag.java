package com.akm.algo.dp;

import java.util.HashSet;
import java.util.Set;

public class GameBag {

    //处理过程中需要的二维数组的定义
    private static class ArrayElement {

        //计算后的数组元素值
        private int value;

        //哪些物品的值组成了当前的数组元素
        private Set<Element> elements;

        public ArrayElement(int value, Element element) {
            this.value = value;
            this.elements = new HashSet<>();
            this.elements.add(element);
        }

        public ArrayElement(int value, Set<Element> elements) {
            this.value = value;
            this.elements = elements;
        }

        @Override
        public String toString() {
            return "value: " + value + ", elements: " + elements;
        }

    }

    private static class Element {
        private final String name;
        private final int value; // 物品的价值

        private final int cost; // 物品的花费

        public Element(String name, int value, int cost) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "name: " + name + ", value: " + value + ", cost: " + cost;
        }
    }

    public void putBag(Element[] goods, int bagSize){

        ArrayElement[][] calcArray = new ArrayElement[goods.length][bagSize];
        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < bagSize; j++) {
                //第一行做特殊处理
                if (i == 0) {
                    calcArray[i][j] = new ArrayElement(goods[i].value, goods[i]);
                } else {
                    //计算本单元格是否还能放下当前物品
                    int spareSpace = j+1-goods[i].cost;
                    if (spareSpace < 0) { // 背包空间不足
                        calcArray[i][j] = calcArray[i - 1][j];
                    } else{
                        // 可以放下，需要判断上一行同列的值和当前商品的价值+剩余空间的价值哪个更大
                        int preRow = i - 1;
                        //上一行同列的值
                        int preRowValue = calcArray[preRow][j].value;
                        //当前商品的价值
                        int currentGoodsValue = goods[i].value;
                        //是否有剩余空间，如果有，获取剩余空间的最大值
                        if(spareSpace > 0){
                            currentGoodsValue += calcArray[preRow][spareSpace-1].value;
                        }
                        if(preRowValue >= currentGoodsValue){
                            //使用上一行同列的数据
                            calcArray[i][j] = calcArray[preRow][j];
                        }else {
                            if(spareSpace == 0){
                                //空间只够存放当前物品
                                calcArray[i][j] = new ArrayElement(currentGoodsValue, goods[i]);
                            }else {
                                Set<Element> newElement =
                                        (HashSet<Element>) ((HashSet<Element>) calcArray[preRow][spareSpace - 1].elements);

                                newElement.add(goods[i]);
                                calcArray[i][j] = new ArrayElement(currentGoodsValue, newElement);
                            }
                        }
                    }

                }
            }
        }
        System.out.println("最优解:" + calcArray[goods.length-1][bagSize-1]);
    }

    public void printRow(int row,int bagSize,ArrayElement[][] calcArray){
        System.out.println("当前行: " + row);
        for (int i = 0; i < bagSize; i++) {
            if(calcArray[row][i] != null){
                System.out.println("i= "+i+": "+calcArray[row][i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Element[] tourElements = {
                new Element("天安门", 9, 1),
                new Element("故宫", 9, 4),
                new Element("颐和园", 9, 2),
                new Element("八达岭", 7, 1),
                new Element("天坛", 6, 1),
                new Element("圆明园", 8, 2),
                new Element("恭王府", 5, 1)
        };

        new GameBag().putBag(tourElements, 6);

    }

}
