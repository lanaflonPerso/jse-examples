package com.corvil;

/**
 * ATM Robot
 * <p>
 * The goal of this task is to write a program that controls a robot arm for entering PIN numbers on an ATM machine
 * keypad.
 * <p>
 * The robot arm can be controlled using 5 instructions: U (up), D (down), L (left), R (right), P (press).
 * <p>
 * The keypad is arranged as follows:
 *              1 2 3
 *              4 5 6
 *              7 8 9
 * <p>
 * Input to the program is a PIN number given as an array of digits. The output should be any shortest series of
 * commands to the robot arm that results in the correct PIN number being entered. The PIN number can contain any number
 * of digits. The robot arm starts positioned over digit 1 on the keypad.
 * <p>
 * Examples (input => output):
 * <p>
 * {1} => “P”, {1,2} => “PRP”, {5,4,7,9} => “RDPLPDPRRP”
 */
public class RobotArm {
        int stepsToMove;

        public static void main(String... args) {
                new RobotArm().Solution(new int[] { 1, 2, 3, 2, 1 }); // PRPRPLPLP

                System.out.println();
                new RobotArm().Solution(new int[] { 3, 2, 1, 4, 7 }); // RRPLPLPDPDP

                System.out.println();
                new RobotArm().Solution(new int[] { 9, 5, 1 }); // DDRRP DRPLLLLP
        }

        public void Solution(int[] pin) {
                stepsToMove = 1;
                for (int i = 0; i < pin.length; i++) {
                        int no = pin[i];
                        if (no <= 3) {
                                move(no);
                        } else if (no <= 6) {
                                System.out.print("D");
                                stepsToMove = 4;
                                move(no);
                        } else {
                                if(stepsToMove <=3) System.out.print("DD"); else System.out.print("D");
                                stepsToMove = 7;
                                move(no);
                        }
                }
        }

        private void move(int steps) {
                if (stepsToMove == steps) {
                        System.out.print('P');
                } else {
                        if (stepsToMove <= steps) {
                                print(stepsToMove, steps, 'R');
                        } else if (stepsToMove >= steps) {
                                print(steps, stepsToMove, 'L');
                        }
                        stepsToMove = steps;
                }
        }

        private void print(int start, int stop, char c) {
                for (int i = start; i < stop; i++) {
                        System.out.print(c);
                }
                System.out.print('P');
        }
}
