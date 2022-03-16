package com.LeahGrace.Practice.Tutorials.ThirtyDaysOfCode;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Day11TwoDArraysDS {


    class Result {

        /*
         * Complete the 'hourglassSum' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts 2D_INTEGER_ARRAY arr as parameter.
         */

        public static int hourglassSum(List<List<Integer>> arr) {
            // Write your code here
            int maxSum = 0;
            int tempSum = 0;
            int[] intArray = new int[7];

            for (int i = 0; i < arr.size() - 2; i++){
                for (int j = 0; j < arr.get(i).size() - 2; j++){
                    System.out.println("tempSum is " + tempSum);
                    // tempSum += arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j + 2);
                    tempSum += arr.get(i + 1).get(j + 1);
                    //    tempSum += arr.get(i+ 2).get(j) + arr.get(i+2).get(j+1) + arr.get(i + 2).get(j + 2);
                    for (int k = 0; k < 3; k++){
                        System.out.println("tempSum is " + tempSum);
                        tempSum += arr.get(i).get(j + k);
                        System.out.println("tempSum is " + tempSum);
                        tempSum += arr.get(i+2).get(j + k);
                        System.out.println("tempSum is " + tempSum);
                    }
                    if (tempSum > maxSum){
                        maxSum = tempSum;
                    }
                    tempSum = 0;
                }
            }
            System.out.println(maxSum);
            return maxSum;
        }
    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            List<List<Integer>> arr = new ArrayList<>();

            IntStream.range(0, 6).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = Result.hourglassSum(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}


/*

TEST CASE 3

-1 -1 0 -9 -2 -2
-2 -1 -6 -8 -2 -5
-1 -1 -1 -2 -3 -4
-1 -9 -2 -4 -4 -5
-7 -3 -3 -2 -9 -9
-1 -3 -1 -2 -4 -5



TEST CASE 7

0 -4 -6 0 -7 -6
-1 -2 -6 -8 -3 -1
-8 -4 -2 -8 -8 -6
-3 -1 -2 -5 -7 -4
-3 -5 -3 -6 -6 -6
-3 -6 0 -8 -6 -7
 */