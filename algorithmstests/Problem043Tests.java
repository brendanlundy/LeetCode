package algorithmstests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem043;

public class Problem043Tests {
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
            assertEquals("0", Problem043.multiply("0", "15"));
        }

        @Test
        public void test002() {
            assertEquals("8", Problem043.multiply("2", "4"));
        }

        @Test
        public void test003() {
            assertEquals("45", Problem043.multiply("3", "15"));
        }

        @Test
        public void test004() {
            assertEquals("45", Problem043.multiply("15", "3"));
        }

        @Test
        public void test005() {
            assertEquals("56088", Problem043.multiply("123", "456"));
        }

        @Test
        public void test006() {
            assertEquals("998001", Problem043.multiply("999", "999"));
        }
    }
}
