package bits;

/* Leetcode: https://leetcode.com/problems/hamming-distance/description/
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */

public class hammingDistance {
	    public int hammingDistanceI(int x, int y) {
	        int num = x ^ y;
	        int cnt = 0;
	        while(num > 0) {
	            cnt += num & 1;
	            num = num >> 1;
	        }
	        return cnt;
	    }
}
