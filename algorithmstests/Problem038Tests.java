package algorithmstests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem038;

public class Problem038Tests {
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
            assertEquals("1", Problem038.countAndSay(1));
        }

        @Test
        public void test002() {
            assertEquals("11", Problem038.countAndSay(2));
        }

        @Test
        public void test003() {
            assertEquals("21", Problem038.countAndSay(3));
        }

        @Test
        public void test004() {
            assertEquals("1211", Problem038.countAndSay(4));
        }

        @Test
        public void test005() {
            assertEquals("111221", Problem038.countAndSay(5));
        }

        @Test
        public void test006() {
            assertEquals("312211", Problem038.countAndSay(6));
        }
    }
}
