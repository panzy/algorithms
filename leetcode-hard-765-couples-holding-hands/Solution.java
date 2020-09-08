/*
 * Solve the LeetCode problem "765. Couples Holding Hands" in Java.
 * 
 * Problem description:
 * https://leetcode.com/problems/couples-holding-hands/
 * 
 * by Zhiyong Pan on 8-Sep-2020
 * 
 * -------- Solution status -----------------------
 * Success
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Couples Holding Hands.
 * Memory Usage: 36.8 MB, less than 84.75% of Java online submissions for Couples Holding Hands.
 */
class Solution {
    public int minSwapsCouples(int[] row) {

    	int[] people = initPeopleArray(row);
    	
    	// for every two seats ...
    	int swapCnt = 0;
    	for (int i = 0; i < row.length; i += 2) {
    		if (!isCouple(row[i], row[i + 1])) {
    			// swap the person on seat (i+1) with the coupled one
    			swap(i + 1, people[theOther(row[i])], row, people);
    			++swapCnt;
    		}
    	}
    	
    	return swapCnt;
    }
    
    /**
     * Create a array serving as a map from people to seats.
     * @param row a map from seats to people.
     * @return
     */
    static int[] initPeopleArray(int[] row) {
    	int[] people = new int[row.length];
    	
    	for (int i = 0; i < row.length; ++i) {
    		people[row[i]] = i;
    	}
    	
    	return people;
    }
    
    static boolean isCouple(int a, int b) {
    	if (a < b)
    		return a + 1 == b && a % 2 == 0;
    	else
    		return b + 1 == a && b % 2 == 0;
    }
    
    /**
     * Get the other person who consists a couple with this one.
     * @param a this person
     * @return the other person
     */
    static int theOther(int a) {
    	return a % 2 == 0 ? a + 1 : a - 1;
    }
    
    /**
     * Swap people on seat |i| and |j|.
     * 
     * @param i the seat index to swap
     * @param j the other seat index to swap
     * @param row a map of seat index to person
     * @param people a map of person index to seat
     */
    static void swap(int i, int j, int[] row, int[] people) {
    	int a = row[i];
    	int b = row[j];
    	row[i] = b;
    	row[j] = a;
    	people[a] = j;
    	people[b] = i;
    }
}
