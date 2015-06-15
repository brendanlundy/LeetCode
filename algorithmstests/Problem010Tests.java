package algorithmstests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem010;

public class Problem010Tests {
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
            assertEquals(false, Problem010.isMatch("aa", "a"));
        }

        @Test
        public void test002() {
            assertEquals(true, Problem010.isMatch("aa", "aa"));
        }

        @Test
        public void test003() {
            assertEquals(false, Problem010.isMatch("aaa", "aa"));
        }

        @Test
        public void test004() {
            assertEquals(true, Problem010.isMatch("aa", "a*"));
        }

        @Test
        public void test005() {
            assertEquals(true, Problem010.isMatch("aa", ".*"));
        }

        @Test
        public void test006() {
            assertEquals(true, Problem010.isMatch("ab", ".*"));
        }

        @Test
        public void test007() {
            assertEquals(true, Problem010.isMatch("aab", "c*a*b"));
        }
    }
}
