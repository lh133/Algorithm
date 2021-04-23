package com.lh.LeetCode.March.March19;

/**
 * 1603. 设计停车系统
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * 请你实现 ParkingSystem 类：
 * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType) 检查是否有 carType 对应的停车位。
 * carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 *
 * @Author: LH
 * @Date: 2021/3/21 21:31
 */
public class ParkingSystem {
    int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return park[carType]-- > 0;
    }
}

class Solution {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        boolean b = parkingSystem.addCar(1);
        boolean b1 = parkingSystem.addCar(2);
        boolean b2 = parkingSystem.addCar(3);
        boolean b3 = parkingSystem.addCar(2);
        System.out.println(b);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
    }
}
