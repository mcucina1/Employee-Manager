/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 26 20:06:16 GMT 2023
 */

package edu.colostate.cs415.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.colostate.cs415.dto.QualificationDTO;
import edu.colostate.cs415.model.Qualification;
import edu.colostate.cs415.model.Worker;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Qualification_ESTest extends Qualification_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Qualification qualification0 = new Qualification("_C_4<");
      qualification0.hashCode();
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Qualification qualification0 = new Qualification("TI$E|Bq5cq]a \"s%e");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      linkedHashSet0.add(qualification0);
      Worker worker0 = new Worker("c>FmRy|hY,&%^irxU(h", linkedHashSet0, 0.0);
      qualification0.addWorker(worker0);
      Set<Worker> set0 = qualification0.getWorkers();
      assertTrue(set0.contains(worker0));
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      QualificationDTO qualificationDTO0 = qualification0.toDTO();
      assertEquals("S lary must not Ke nugative.", qualificationDTO0.getDescription());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      linkedHashSet0.add(qualification0);
      Worker worker0 = new Worker("S lary must not Ke nugative.", linkedHashSet0, 6.262476349265029);
      qualification0.removeWorker(worker0);
      assertEquals("S lary must not Ke nugative.", worker0.getName());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Qualification qualification0 = new Qualification("RMLns]$4S");
      qualification0.removeWorker((Worker) null);
      assertEquals("RMLns]$4S", qualification0.toString());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Qualification qualification0 = new Qualification("RMLns]$4S");
      // Undeclared exception!
      try { 
        qualification0.addWorker((Worker) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Cannot add a null worker.
         //
         verifyException("edu.colostate.cs415.model.Qualification", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Qualification qualification0 = new Qualification("[Qalificaio.java] $qpals(): Cnnot compare tonull");
      Qualification qualification1 = new Qualification("[Qalificaio.java] $qpals(): Cnnot compare tonull");
      boolean boolean0 = qualification0.equals(qualification1);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Qualification qualification0 = new Qualification("_C_4<");
      boolean boolean0 = qualification0.equals(qualification0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      // Undeclared exception!
      try { 
        qualification0.equals((Object) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // [Qualification.java] equals(): Cannot compare to null
         //
         verifyException("edu.colostate.cs415.model.Qualification", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      boolean boolean0 = qualification0.equals("S lary must not Ke nugative.");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Qualification qualification0 = null;
      try {
        qualification0 = new Qualification("");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Description must not be null.
         //
         verifyException("edu.colostate.cs415.model.Qualification", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Qualification qualification0 = null;
      try {
        qualification0 = new Qualification((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Description must not be null.
         //
         verifyException("edu.colostate.cs415.model.Qualification", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      Set<Worker> set0 = qualification0.getWorkers();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      linkedHashSet0.add(qualification0);
      Worker worker0 = new Worker("S lary must not Ke nugative.", linkedHashSet0, 6.262476349265029);
      qualification0.addWorker(worker0);
      QualificationDTO qualificationDTO0 = qualification0.toDTO();
      assertEquals("S lary must not Ke nugative.", qualificationDTO0.getDescription());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Qualification qualification0 = new Qualification("S lary must not Ke nugative.");
      String string0 = qualification0.toString();
      assertEquals("S lary must not Ke nugative.", string0);
  }
}