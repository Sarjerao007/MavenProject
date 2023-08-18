package parallelScript;

import org.testng.annotations.Test;
public class Sample3 {

  @Test
  public void JavaTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("JavaTestSample3  " +id);
  }

  @Test
  public void PythonTestTest() {
	  long id = Thread.currentThread().getId();
    System.out.println("PythonTestsample3  " +id);
  }

  @Test(invocationCount=6, threadPoolSize=3,timeOut=2000)
  public void SeleniumTestTest() {
	  long id = Thread.currentThread().getId();
	  System.out.println("SeleniumTestSample3  " +id);
  }
}
