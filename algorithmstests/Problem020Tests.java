package algorithmstests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import algorithms.Problem020;

public class Problem020Tests {
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
            assertEquals(true, Problem020.isValid(""));
        }

        @Test
        public void test002() {
            assertEquals(false, Problem020.isValid("())"));
        }

        @Test
        public void test003() {
            assertEquals(true, Problem020.isValid("(){}[]"));
        }

        @Test
        public void test004() {
            assertEquals(true, Problem020.isValid("({})"));
        }

        @Test
        public void test005() {
            assertEquals(true, Problem020.isValid("({}[()])"));
        }

        @Test
        public void test006() {
            assertEquals(false, Problem020.isValid("({}[(]))"));
        }

        @Test
        public void test007() {
            assertEquals(false, Problem020.isValid(")[(]"));
        }
    }
}
