package com.corvil;

/**
 * ATM Robot
 *
 * The goal of this task is to write a program that controls a robot arm for entering PIN numbers on an ATM machine
 * keypad.
 *
 * The robot arm can be controlled using 5 instructions: U (up), D (down), L (left), R (right), P (press).
 *
 * The keypad is arranged as follows: 1 2 3 4 5 6 7 8 9
 *
 * Input to the program is a PIN number given as an array of digits. The output should be any shortest series of
 * commands to the robot arm that results in the correct PIN number being entered. The PIN number can contain any number
 * of digits. The robot arm starts positioned over digit 1 on the keypad.
 *
 * Examples (input => output):
 *
 * {1} => “P” {1,2} => “PRP” {5,4,7,9} => “RDP LP DP RRP”
 *
 */
public class RobotArm {
    int stepsToMove = 1;

    public static void main(String[] args) {
        int[] pin = { 9, 5, 1 }; // DDRRPLUPLUP
        new RobotArm().move(pin);
    }

    public void move(final int[] destinations) {
        for (int i = 0; i < destinations.length - 1; i++) {
            move(destinations[i], destinations[i + 1]);
        }

    }

    public void move(int pos, int des) {
        if (rowFromPos(pos) < rowFromPos(des)) {
            System.out.print("D");
            move(pos + 3, des);
        } else if (rowFromPos(pos) > rowFromPos(des)) {
            System.out.print("U");
            move(pos - 3, des);
        } else if (pos < des) {
            System.out.print("R");
            move(pos + 1, des);
        } else if (pos > des) {
            System.out.print("L");
            move(pos - 1, des);
        } else if (pos == des) {
            System.out.print("P");
        }

    }

    public static int rowFromPos(int pos) {
        if (pos % 3 == 0) {
            return pos / 3;
        } else {
            return (pos / 3) + 1;
        }
    }
}
