package com.comany;

import java.util.Random;
public class Exercises50 {
    public static void main(String[] args){
        System.out.println("HERE COMES THE DICE!");

                System.out.println();
                Random random  = new Random();
                int roll1=0;
                int roll2=0;
                roll1 = 1+random.nextInt(6);
                roll2 = 1+random.nextInt(6);
                while(roll1!=roll2){
                    System.out.println("Roll #1: "+roll1);
                    System.out.println("Roll #2: "+roll2);
                    int sum = roll1+roll2;
                    System.out.println("The total is "+sum+"!");
                    System.out.println();
                    int roll3 = 1+random.nextInt(6);
                    int roll4 = 1+random.nextInt(6);
                    roll1=roll3;
                    roll2=roll4;
                }
                System.out.println();
                System.out.println("Roll #1: "+roll1);
                System.out.println("Roll #2: "+roll2);
                System.out.println("The total is "+(roll1+roll2)+"!");

            }
        }
/*

Modify your dice game from last time so that it keeps rolling until they get
doubles (the same number on both dice).Notice that since there's no user input,
 this will happen very quickly (all the rolls will happen one right after the other).
 */