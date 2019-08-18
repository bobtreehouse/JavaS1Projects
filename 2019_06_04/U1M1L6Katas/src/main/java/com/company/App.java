package com.company;


public class App {


    public static void main(String[] args) {

        System.out.println(reversed);
//
//    public static int total(int[] arr) {
//        int sum = 0;
//        for (int i : arr) {
//            sum = sum + i;
//        }
//        return sum;
//    }
//
//
//    public static int totalOdd(int[] arr) {
//        int sum = arr[1];
//        for (int index = 3; index < arr.length; index += 2) {
//            // **remember i points to the position in the array; not a number itself
//            if (index % 2 != 0) {
//                //the above line "i" is the index position divided by 2 NOT the value of the i-th position
//                sum += arr[index];
//            }
//
//        }
//        return sum;
//    }
//
//    public static int totalEven(int[] arr) {
//        int sum = arr[0];
//        for (int i = 2; i < arr.length; i += 2) {
//            if (i % 2 != 0) {
//            }
//            sum += arr[i];
//        }
//        return sum;
//    }
//
//    public static int secondLargestNumber(int[] arr) {
//        int largest = arr[0];
//        int second = arr[1];
//        if (largest < second) {
//            largest = arr[1];
//            second = arr[0];
//        }
//        for (int i = 2; i < arr.length; i++) {
//            if (arr[i] > largest) {
//                second = largest;
//                largest = arr[i];
//
//            } else if (arr[i] > second) {
//                second = arr[i];
//
//            }
//
//        }
//        return second;
//    }
//
//    public static int[] everyThird(int[] arr) {
//        if (arr.length < 3) {
//            return null;
//        }
//        {
//            int counter = 0;
//            int[] newArray = new int[arr.length / 3];
//            for (int i = 2; i < arr.length; i += 3) {
//                newArray[counter] = arr[i];
//                counter++;
//            }
//            return newArray;
//        }
//    }
//    //===============================================
//    // my answer below  after struggle;
//
//    public static int[] reverse(int[] a) {
//        for (int i = 0; i < a.length / 2; i++) {
//            int j = a[a.length - 1 - i];
//
//            int k = a[i];
//            a[i] = j;
//            a[a.length - 1 - i] = k;
//
//        }
//        return a;
//    }

        //==========================================================

        //==correct answer below;
        public static int[] reverse(int[] numbers) {

            int[] reversed = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++) {

                // length - (i + 1) is the n-th to last element
                // so when i = 0, it would be the last element
                // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
                reversed[i] = numbers[ numbers.length - (i + 1) ];
            }


            return reversed[];


        }
        }

//
//
//
//
//
//
//
////    public static int[] lessThanFive(int[] arr) {
////        int counter = 0;
////
////        for (int i = 0; i < arr.length; i++) {
////            if (arr[i] < 5) {
////                counter++;
////            }
////        }
////
////        int[] newArray = new int [counter];
////
////        int counterTwo = 0;
////
////        for (int i = 0; i< arr.length; i++){
////            if (arr[i] < 5) {
////                newArray [counterTwo] =arr[i];
////                    counterTwo++;
////                }
////            }
////            if (newArray.length == 0){
////                return null;
////            } else{
////                return newArray;
////            }
////        }
//
//
//        public static String[] swapFirstAndLast (String[]a){
//            String num = a[a.length - 1];
//            String num2 = a[0];
//            a[0] = num;
//            a[a.length - 1] = num2;
//            return a;
//        }
//
//        public static String[] lessThanFive ( int[] arr){
//            int counter = 0;
//
//            for (int i = 0; 1 < arr.length; i++) {
//                if (arr[i] < 5) {
//                    counter++;
//
//                }
//            }
//            int[] newArray = new int[counter];
//
//            int counterTwo = 0;
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i] < 5) {
//                    newArray[counterTwo] = arr[i];
//                    counterTwo++;
//                }
//            }
//            if (newArray.length == 0) {
//                return null;
//            } else {
//                return String newArray;
//            }
//        }




