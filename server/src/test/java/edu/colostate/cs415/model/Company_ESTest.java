/*
 * This file was automatically generated by EvoSuite
 * Sun Mar 26 20:07:25 GMT 2023
 */

package edu.colostate.cs415.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.colostate.cs415.model.Company;
import edu.colostate.cs415.model.Project;
import edu.colostate.cs415.model.ProjectSize;
import edu.colostate.cs415.model.ProjectStatus;
import edu.colostate.cs415.model.Qualification;
import edu.colostate.cs415.model.Worker;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class Company_ESTest extends Company_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("edu.colostate.cs415.model.Qualification");
      company0.createWorker("5\"nxdZo", set0, 9.71647);
      Set<Worker> set1 = company0.getUnassignedWorkers();
      assertEquals(1, set1.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Company company0 = new Company("B4G");
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      Set<Project> set0 = company0.getProjects();
      assertTrue(set0.contains(project0));
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Company company0 = new Company("B4G");
      company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createWorker("B4G", set0, 0.0);
      Set<Worker> set1 = company0.getEmployedWorkers();
      assertFalse(set1.isEmpty());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Company company0 = new Company("{ iame=Z");
      company0.createQualification("{ iame=Z");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createWorker("{ iame=Z", set0, 1939.679);
      Set<Worker> set1 = company0.getAvailableWorkers();
      assertEquals(1, set1.size());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Company company0 = new Company("B4G");
      Qualification qualification0 = company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      linkedHashSet0.add(qualification0);
      company0.assign(worker0, project0);
      Set<Worker> set1 = company0.getAssignedWorkers();
      assertFalse(set1.isEmpty());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Company company0 = new Company("B4G");
      Qualification qualification0 = company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      linkedHashSet0.add(qualification0);
      company0.assign(worker0, project0);
      ProjectStatus projectStatus0 = ProjectStatus.ACTIVE;
      project0.setStatus(projectStatus0);
      company0.unassign(worker0, project0);
      assertEquals(ProjectStatus.SUSPENDED, project0.getStatus());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Company company0 = new Company("B4G");
      Qualification qualification0 = company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      linkedHashSet0.add(qualification0);
      company0.assign(worker0, project0);
      company0.unassign(worker0, project0);
      assertEquals(12, Worker.MAX_WORKLOAD);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Company company0 = new Company("BIG");
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("BIG", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.unassign((Worker) null, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Company company0 = new Company("B4G");
      Qualification qualification0 = company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      linkedHashSet0.add(qualification0);
      company0.assign(worker0, project0);
      company0.unassignAll(worker0);
      assertEquals(12, Worker.MAX_WORKLOAD);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Company company0 = new Company("No constructor fields may be null.");
      // Undeclared exception!
      try { 
        company0.unassignAll((Worker) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      company0.createQualification("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", linkedHashSet0, projectSize0);
      Worker worker0 = new Worker("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, 214.8880813);
      project0.addWorker(worker0);
      company0.start(project0);
      company0.finish(project0);
      assertEquals(ProjectStatus.FINISHED, project0.getStatus());
      assertEquals("{Company.java} Name when creating a Worker must not be null or empty.:1:1", company0.toString());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Company company0 = new Company("B4G");
      Qualification qualification0 = company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      linkedHashSet0.add(qualification0);
      Project project1 = new Project("B4G", linkedHashSet0, projectSize0);
      company0.assign(worker0, project1);
      company0.unassign(worker0, project0);
      assertNotSame(project0, project1);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Company company0 = new Company("B4G");
      company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.unassign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Comapny.java} Cannot unassign a worker from a project they are not assigned to
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Company company0 = new Company("4|Y{;6*9");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Qualification qualification0 = company0.createQualification("4|Y{;6*9");
      linkedHashSet0.add(qualification0);
      Worker worker0 = new Worker("edu.colostate.cs415.model.ProjectStatus", linkedHashSet0, 0.0);
      // Undeclared exception!
      try { 
        company0.unassign(worker0, (Project) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Company company0 = new Company("{ iame=Z");
      company0.createQualification("{ iame=Z");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      Project project0 = company0.createProject("u;>d(O^Wv", set0, projectSize0);
      Worker worker0 = company0.createWorker("{ iame=Z", set0, 1939.679);
      company0.assign(worker0, project0);
      Project project1 = company0.createProject("u;>d(O^Wv", set0, projectSize0);
      company0.assign(worker0, project1);
      assertEquals(12, Worker.MAX_WORKLOAD);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Company company0 = new Company("B4G");
      company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker does not meet project qualifications
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("{Company.java} Name when creating a Worker must not be null or empty.");
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      Worker worker0 = company0.createWorker("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, 214.8880813);
      company0.start(project0);
      company0.finish(project0);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Project Status must not be ACTIVE or FINISHED
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("edu.colostate.cs415.model.Qualification");
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      company0.start(project0);
      Worker worker0 = company0.createWorker("5\"nxdZo", set0, 9.71647);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Project Status must not be ACTIVE or FINISHED
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Company company0 = new Company("B4G");
      company0.createQualification("B4G");
      Set<Qualification> set0 = company0.getQualifications();
      Worker worker0 = company0.createWorker("B4G", set0, 0.0);
      ProjectSize projectSize0 = ProjectSize.SMALL;
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Project project0 = company0.createProject("B4G", linkedHashSet0, projectSize0);
      project0.addWorker(worker0);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker must be available and not already assigned to Project
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Company company0 = new Company("4|Y{;6*9");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Qualification qualification0 = company0.createQualification("4|Y{;6*9");
      linkedHashSet0.add(qualification0);
      Worker worker0 = company0.createWorker(",PwU9?*&*vVcEe>Y", linkedHashSet0, 0.0);
      ProjectSize projectSize0 = ProjectSize.SMALL;
      Project project0 = new Project("4|Y{;6*9", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker must be employed and project must be in company
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("edu.colostate.cs415.model.Qualification");
      Worker worker0 = new Worker("edu.colostate.cs415.model.Qualification", set0, 1.0);
      ProjectSize projectSize0 = ProjectSize.MEDIUM;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      // Undeclared exception!
      try { 
        company0.assign(worker0, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker must be employed and project must be in company
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Company company0 = new Company("Name must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("[AeC#U$jY>@Q;Fn");
      Worker worker0 = company0.createWorker("Assigning worker to Project will Overload Worker", set0, 1722.396197243);
      // Undeclared exception!
      try { 
        company0.assign(worker0, (Project) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Company company0 = new Company("w");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      ProjectSize projectSize0 = ProjectSize.SMALL;
      Project project0 = new Project("w", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.assign((Worker) null, project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      Worker worker0 = company0.createWorker("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, 214.8880813);
      project0.addWorker(worker0);
      company0.start(project0);
      // Undeclared exception!
      try { 
        company0.finish(project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Worker and Project Arguments may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Company company0 = new Company("h]['%)b#We8Js");
      // Undeclared exception!
      try { 
        company0.finish((Project) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Project may not be null
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      company0.finish(project0);
      assertEquals(ProjectStatus.PLANNED, project0.getStatus());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Company company0 = new Company("edu.colostate.cs415.model.Worker");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("edu.colostate.cs415.model.Worker", linkedHashSet0, projectSize0);
      ProjectStatus projectStatus0 = ProjectStatus.SUSPENDED;
      project0.setStatus(projectStatus0);
      company0.start(project0);
      assertEquals(ProjectStatus.ACTIVE, project0.getStatus());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Company company0 = new Company("edu.colostate.cs415.model.Worker");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      linkedHashSet0.add((Qualification) null);
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("edu.colostate.cs415.model.Worker", linkedHashSet0, projectSize0);
      company0.start(project0);
      assertEquals(ProjectStatus.PLANNED, project0.getStatus());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Company company0 = new Company("3*k8vpB_w!'!x");
      Company company1 = new Company("3*k8vpB_w!'!x");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      ProjectSize projectSize0 = ProjectSize.SMALL;
      Project project0 = company1.createProject("NSixkT_P+9:EeVXV", linkedHashSet0, projectSize0);
      // Undeclared exception!
      try { 
        company0.start(project0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} Cannot start a project that isn't in the company.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Company company0 = new Company("r");
      // Undeclared exception!
      try { 
        company0.createProject("r", linkedHashSet0, (ProjectSize) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} No constructor fields may be null.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Company company0 = new Company("Cannot add a null project.");
      ProjectSize projectSize0 = ProjectSize.SMALL;
      // Undeclared exception!
      try { 
        company0.createProject("Cannot add a null project.", (Set<Qualification>) null, projectSize0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} No constructor fields may be null.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Company company0 = new Company("#8!?");
      ProjectSize projectSize0 = ProjectSize.SMALL;
      Set<Qualification> set0 = company0.getQualifications();
      // Undeclared exception!
      try { 
        company0.createProject("", set0, projectSize0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} No constructor fields may be null.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.BIG;
      Project project0 = company0.createProject("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, projectSize0);
      company0.start(project0);
      company0.start(project0);
      assertEquals(ProjectStatus.ACTIVE, project0.getStatus());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Company company0 = new Company("J.5.pt\"x\"2St*BS-B");
      Set<Qualification> set0 = company0.getQualifications();
      ProjectSize projectSize0 = ProjectSize.SMALL;
      // Undeclared exception!
      try { 
        company0.createProject((String) null, set0, projectSize0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} No constructor fields may be null.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Company company0 = new Company("f");
      // Undeclared exception!
      try { 
        company0.createQualification("");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} Description when creating a Qualification must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Company company0 = new Company("D");
      // Undeclared exception!
      try { 
        company0.createQualification((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} Description when creating a Qualification must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Company company0 = new Company("a\"DH@:~Z5F5um[x");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      Qualification qualification0 = new Qualification("a\"DH@:~Z5F5um[x");
      linkedHashSet0.add(qualification0);
      Worker worker0 = company0.createWorker("pZ64*68GQI2PcY{!'+", linkedHashSet0, (-2.083845671368306));
      assertNull(worker0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Company company0 = new Company("edu.colostate.cs415.model.Worker");
      Worker worker0 = company0.createWorker("edu.colostate.cs415.model.Worker", (Set<Qualification>) null, (-1824.02354));
      assertNull(worker0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Company company0 = new Company("a\"DH@:~Z5F5um[x");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      // Undeclared exception!
      try { 
        company0.createWorker("", linkedHashSet0, 12);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} Name when creating a Worker must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Company company0 = new Company("j$Ie%/N.u.D2}33<");
      LinkedHashSet<Qualification> linkedHashSet0 = new LinkedHashSet<Qualification>();
      // Undeclared exception!
      try { 
        company0.createWorker((String) null, linkedHashSet0, (-341.37131422));
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // {Company.java} Name when creating a Worker must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Qualification> set0 = company0.getQualifications();
      company0.createQualification("{Company.java} Name when creating a Worker must not be null or empty.");
      company0.createWorker("{Company.java} Name when creating a Worker must not be null or empty.:0:0", set0, 214.8880813);
      company0.getUnavailableWorkers();
      assertEquals("{Company.java} Name when creating a Worker must not be null or empty.:1:0", company0.toString());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Company company0 = new Company("3*k8vpB_w!'!x");
      Company company1 = new Company("3*k8vpB_w!'!x");
      boolean boolean0 = company1.equals(company0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Company company0 = new Company("3*k8vpB_w!'!x");
      boolean boolean0 = company0.equals(company0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Company company0 = new Company("nT;&9!Fo/X5W");
      // Undeclared exception!
      try { 
        company0.equals((Object) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // [Comapny.java] equals(): Cannot compare to null.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      boolean boolean0 = company0.equals("{Company.java} Name when creating a Worker must not be null or empty.:0:0");
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Company company0 = null;
      try {
        company0 = new Company("");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Name must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Company company0 = null;
      try {
        company0 = new Company((String) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Name must not be null or empty.
         //
         verifyException("edu.colostate.cs415.model.Company", e);
      }
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Worker> set0 = company0.getAvailableWorkers();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Project> set0 = company0.getProjects();
      assertTrue(set0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Worker> set0 = company0.getAssignedWorkers();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Company company0 = new Company("1T iamZ");
      company0.hashCode();
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Company company0 = new Company("{Company.java} Name when creating a Worker must not be null or empty.");
      Set<Worker> set0 = company0.getUnassignedWorkers();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Company company0 = new Company("{ iame=Z");
      String string0 = company0.toString();
      assertEquals("{ iame=Z:0:0", string0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      Company company0 = new Company("B4G");
      Set<Worker> set0 = company0.getEmployedWorkers();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Company company0 = new Company("B4G");
      String string0 = company0.getName();
      assertEquals("B4G", string0);
  }
}