package application;

import org.junit.Assert;
import org.junit.Test;

public class ChaseTest {

  @Test(expected = Exception.class)
  public void invalidAccountNumberTest() throws Exception {
      Chase chase = new Chase(233434l, 123456789l);
  }


  @Test
    public void failTest() {
      Assert.fail();
  }
}
