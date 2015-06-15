package algorithmstests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem004;

public class Problem004Tests {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    public static final class UnitTests {
        double delta = 0.0001;

        @Test
        public void test001() {
            assertEquals(
                    9,
                    Problem004.findMedianSortedArrays(new int[] { 3, 4, 7, 8, 11 }, new int[] { 6, 9, 14, 17, 18, 19 }),
                    delta);
        }

        @Test
        public void test002() {
            assertEquals(8.5,
                    Problem004.findMedianSortedArrays(new int[] { 3, 4, 7, 8, 11 }, new int[] { 6, 9, 14, 17, 18 }),
                    delta);
        }

        @Test
        public void test003() {
            assertEquals(9, Problem004.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 6, 9, 14, 17, 18 }),
                    delta);
        }

        @Test
        public void test004() {
            assertEquals(11.5,
                    Problem004.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 6, 9, 14, 17, 18, 21 }), delta);
        }

        @Test
        public void test005() {
            assertEquals(1.5, Problem004.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }), delta);
        }

        @Test
        public void test006() {
            assertEquals(1, Problem004.findMedianSortedArrays(new int[] { 1, 1 }, new int[] { 1, 2 }), delta);
        }

        @Test
        public void test007() {
            assertEquals(2.5, Problem004.findMedianSortedArrays(new int[] { 4 }, new int[] { 1, 2, 3 }), delta);
        }
    }
}
