package algorithms;

public class Problem004 {

    public static void main(String[] args) {
        //findMedianSortedArrays(new int[] { 3, 4, 7, 8, 11 }, new int[] { 6, 9, 14, 17, 18, 19 });
        //System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            if (length2 == 0)
                return -1;
            else if (length2 % 2 == 1)
                return nums2[length2 / 2];
            else
                return (double) (nums2[length2 / 2 - 1] + nums2[length2 / 2]) / 2;
        } else if (length2 == 0) {
            if (length1 == 0)
                return -1;
            else if (length1 % 2 == 1)
                return nums1[length1 / 2];
            else
                return (double) (nums1[length1 / 2 - 1] + nums1[length1 / 2]) / 2;
        } else if (length1 % 2 == 1 && length2 % 2 == 1 && nums1[length1 / 2] == nums2[length2 / 2])
            return nums1[length1 / 2];
        else {
            int numToLeft = (length1 + length2) / 2;
            boolean even = (length1 + length2) % 2 == 0;
            if (even)
                numToLeft--;

            int p1 = 0;
            int p2 = 0;
            int numPassed = 0;
            while (numPassed < numToLeft) {
                if (p1 == length1) {
                    p2 += numToLeft - numPassed;
                    break;
                } else if (p2 == length2) {
                    p1 += numToLeft - numPassed;
                    break;
                }
                if (nums1[p1] < nums2[p2])
                    p1++;
                else if (nums1[p1] == nums2[p2]) {
                    if (p1 == length1 - 1)
                        p1++;
                    else if (p2 == length2 - 1)
                        p2++;
                    else if (nums1[p1 + 1] < nums2[p2 + 1])
                        p1++;
                    else
                        p2++;
                } else
                    p2++;
                numPassed++;
            }

            //System.out.println(p1);
            //System.out.println(p2);
            if (even) {
                if (p1 == length1)
                    return (double) (nums2[p2] + nums2[p2 + 1]) / 2;
                else if (p2 == length2)
                    return (double) (nums1[p1] + nums1[p1 + 1]) / 2;
                else if (nums1[p1] < nums2[p2] && p1 < length1 - 1) {
                    if (nums1[p1 + 1] < nums2[p2])
                        return (double) (nums1[p1] + nums1[p1 + 1]) / 2;
                } else if (nums2[p2] < nums1[p1] && p2 < length2 - 1) {
                    if (nums2[p2 + 1] < nums1[p1])
                        return (double) (nums2[p2] + nums2[p2 + 1]) / 2;
                }
                return (double) (nums1[p1] + nums2[p2]) / 2;
            } else {
                if (p1 == length1)
                    return nums2[p2];
                else if (p2 == length2)
                    return nums1[p1];
                else
                    return Math.min(nums1[p1], nums2[p2]);
            }
        }
    }

}
