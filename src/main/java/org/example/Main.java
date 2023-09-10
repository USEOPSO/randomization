package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int totalPatients = 100;
        int[] ratio = {1, 2};

        ArrayList<Integer> assignmentOrder = assignPatients(totalPatients, ratio);

        System.out.println("Assignment order: " + assignmentOrder);
    }

    public static ArrayList<Integer> assignPatients(int totalPatients, int[] ratio) {
        if (ratio.length != 2) {
            throw new IllegalArgumentException("Ratio array must have exactly 2 elements");
        }

        double totalRatio = ratio[0] + ratio[1];

        System.out.println("totalRatio: " + totalRatio);
        System.out.println("*****************************");
        int controlGroupSize = (int) Math.round((ratio[0] / totalRatio) * totalPatients);
        int testGroupSize = totalPatients - controlGroupSize;

        System.out.println("controlGroupSize: " + controlGroupSize);
        System.out.println("testGroupSize: " + testGroupSize);
        System.out.println("---------------------------");

        ArrayList<Integer> assignmentOrder = new ArrayList<>();

        int controlGroupCount = 0;
        int testGroupCount = 0;

        for (int i = 0; i < totalPatients; i++) {
            System.out.println("index: " + i);
            System.out.println("assignmentOrder: " + assignmentOrder);
            System.out.println("대조군 controlGroupCount: " + controlGroupCount);
            System.out.println("시험군 testGroupCount: " + testGroupCount);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            if (i % 3 == 0) {
                System.out.println("1");
                if (controlGroupCount < controlGroupSize) {
                    System.out.println("1-1");
                    System.out.println("++++++++++++++++++");
                    assignmentOrder.add(1);  // Assign to control group
                    controlGroupCount++;
                } else {
                    System.out.println("1-2");
                    System.out.println("++++++++++++++++++");
                    assignmentOrder.add(2);  // Assign to test group
                    testGroupCount++;
                }
            } else {
                System.out.println("2");
                if (testGroupCount < testGroupSize) {
                    System.out.println("2-1");
                    System.out.println("++++++++++++++++++");
                    assignmentOrder.add(2);  // Assign to test group
                    testGroupCount++;
                } else {
                    System.out.println("2-2");
                    System.out.println("++++++++++++++++++");
                    assignmentOrder.add(1);  // Assign to control group
                    controlGroupCount++;
                }
            }
        }

        System.out.println("대조군 controlGroupCount: " + controlGroupCount);
        System.out.println("시험군 testGroupCount: " + testGroupCount);
        return assignmentOrder;
    }
}