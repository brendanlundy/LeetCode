package algorithms;

public class Problem011 {

    public static void main(String[] args) {
        //System.out.println(maxArea(new int[] { 3, 5, 2, 8 }));

    }

    public static int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length; i++) {
            int iv = height[i];
            for (int j = length - 1; j > i; j--) {
                int jv = height[j];
                int area = (j - i) * Math.min(iv, jv);
                //System.out.println(area);
                if (area > max)
                    max = area;
                if (jv >= iv)
                    break;
                else if ((j - i) * iv <= max)
                    break;
            }
        }

        return max;
    }
}
