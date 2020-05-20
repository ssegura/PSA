/*
 * This file was automatically generated by EvoSuite
 * Mon May 11 09:05:42 GMT 2020
 */

package psa.math;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import psa.math.Calculator;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Calculator_ESTest extends Calculator_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.subtract(0, 0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.subtract((-1605), (-2324));
      assertEquals(719, int0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.multiply(2296, 0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.multiply(904, (-4767));
      assertEquals((-4309368), int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.divide(3773, 3773);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.divide(900, (-1));
      assertEquals((-900), int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.add(0, 1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.add(0, (-219));
      assertEquals((-219), int0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      // Undeclared exception!
      try { 
        calculator0.divide(1445, 0);
        fail("Expecting exception: ArithmeticException");
      
      } catch(ArithmeticException e) {
         //
         // / by zero
         //
         verifyException("psa.math.Calculator", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.multiply(1, 1);
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.subtract((-1), 0);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.divide(0, 1);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Calculator calculator0 = new Calculator();
      int int0 = calculator0.add(0, 0);
      assertEquals(0, int0);
  }
}
