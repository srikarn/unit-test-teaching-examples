package talk1;

import junit.framework.TestCase;

import common.ExpensiveService;
import common.StandardExpensiveService;

/**
 * <code>
 *   +-----------+     +------------------+            +--------------------------+
 *   |    Test   |====>| ClassUnderTest *====NO_SEAM==>| StandardExpensiveService |
 *   |   Driver  |     |                  |            |                          |
 *   +-----------+     +------------------+            +--------------------------+
 * </code>
 */
public class UntestableCodeTest extends TestCase {

  /**
   * This Class mixes responsibilities: (1) Responsibility of constructing the
   * object graph (2) Responsibility of business logic
   * 
   * As a result there is no way we can test it. This class has no seams.
   */
  static class ClassUnderTest {
    /*
     * Notice that even thought we use an interface here, it does nothing to aid
     * testing of this class. We are paying the cost of an interface and getting
     * zero benefit. Having an interface gives us a false sense that we have a
     * seam here.
     */
    ExpensiveService expensive = new StandardExpensiveService();

    public boolean testMe() {
      expensive.untestableMethod();
      return true;
    }
  }

  public void testThereIsNothingWeCanDoToTestThis() throws Exception {
    ClassUnderTest cut = new ClassUnderTest();
    boolean response = cut.testMe();
    assertTrue(response);
  }

}
