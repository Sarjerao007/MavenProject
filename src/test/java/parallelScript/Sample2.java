package parallelScript;

import org.testng.annotations.Test;
public class Sample2 {

  @Test
  public void JavaTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("JavaTestSample2  " +id);
  }

  @Test
  public void PythonTestTest() {
	  long id = Thread.currentThread().getId();
    System.out.println("PythonTestsample2  "+id);
  }

  @Test
  public void SeleniumTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("SeleniumTestSample2  " +id);
  }
}
