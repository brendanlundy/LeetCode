package algorithmstests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem001;

public class Problem001Tests {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UnitTests.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }

    public static final class UnitTests {
        @Test
        public void test001() {
            assertArrayEquals(new int[] { 1, 3 }, Problem001.twoSum(new int[] { 2, 7, 11, 15 }, 13));
        }

        @Test
        public void test002() {
            assertArrayEquals(new int[] { 2, 3 }, Problem001.twoSum(new int[] { 3, 2, 4 }, 6));
        }

        @Test
        public void test003() {
            assertArrayEquals(new int[] { 1, 4 }, Problem001.twoSum(new int[] { 0, 4, 3, 0 }, 0));
        }
    }
}
