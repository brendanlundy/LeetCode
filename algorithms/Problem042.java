package algorithms;

public class Problem042 {

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

    }

    public static int trap(int[] height) {
        if (height == null || height.length <= 2)
            return 0;

        int length = height.length;
        int totalVolume = 0;
        int volumeInside = 0;
        int maxIndex = 0;
        int max = height[0];
        //traverse from left to right
        for (int i = 1; i < length; i++) {
            int h = height[i];
            if (h >= max) {
                totalVolume += calcVolume(max, h, maxIndex, i, volumeInside);
                maxIndex = i;
                max = h;
                volumeInside = 0;
            } else {
                volumeInside += h;
            }
        }

        //now traverse from right to left
        int stop = maxIndex;
        volumeInside = 0;
        maxIndex = length - 1;
        max = height[length - 1];
        for (int i = length - 2; i >= stop; i--) {
            int h = height[i];
            if (h >= max) {
                totalVolume += calcVolume(max, h, maxIndex, i, volumeInside);
                maxIndex = i;
                max = h;
                volumeInside = 0;
            } else {
                volumeInside += h;
            }
        }

        return totalVolume;
    }

    private static int calcVolume(int h1, int h2, int index1, int index2, int volumeInside) {
        int height = Math.min(h1, h2);
        int width = Math.abs(index1 - index2) - 1;
        if (width < 0)
            width = 0;
        return (height * width) - volumeInside;
    }

}
