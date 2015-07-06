package algorithmstests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem033;

public class Problem033Tests {
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
            assertEquals(-1, Problem033.search(new int[] { 1 }, 0));
        }

        @Test
        public void test002() {
            assertEquals(0, Problem033.search(new int[] { 1 }, 1));
        }

        @Test
        public void test003() {
            assertEquals(-1, Problem033.search(new int[] { 1 }, 2));
        }

        @Test
        public void test004() {
            assertEquals(1, Problem033.search(new int[] { 3, 1 }, 1));
        }

        @Test
        public void test005() {
            assertEquals(0, Problem033.search(new int[] { 8, 9, 4, 5, 6, 7 }, 8));
        }

        @Test
        public void test006() {
            assertEquals(5, Problem033.search(new int[] { 8, 9, 4, 5, 6, 7 }, 7));
        }

        @Test
        public void test007() {
            assertEquals(2, Problem033.search(new int[] { 4, 5, 6, 7 }, 6));
        }
    }
}
