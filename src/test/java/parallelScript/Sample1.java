package parallelScript;

import org.testng.annotations.Test;
public class Sample1 {

  @Test
  public void JavaTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("JavaTestSample1  " +id);
  }

  @Test
  public void PythonTestTest() {
	  long id = Thread.currentThread().getId();
    System.out.println("PythonTestSample1  " +id);
  }

  @Test
  public void SeleniumTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("SeleniumTestSample1  " +id);
  }
}
