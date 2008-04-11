package talk1;

import junit.framework.TestCase;

import common.ExpensiveService;

/**
 * <code>
 *   +-----------+     +----------------+            +--------------------------+
 *   |    Test *------------------------------SEAM-->| FriendlyExpensiveService |
 *   |   Driver  |     | ClassUnderTest |            |                          |
 *   +-----------+     +----------------+            +--------------------------+
 * </code>
 */
public class UntestableCodeTest extends TestCase {

  /**
   * This Class does not mixes responsibilities only business logic here. All of
   * the "new" operators were removed.
   */
  static class ClassUnderTest {
    /*
     * Now we are getting the benefit of the interface. Best way to think about
     * this is that the test is in control of the 'expensive' variable/field. As
     * a result it can send subclasses and hence can intercept any method call.
     * Without having control of this method we can't intercept.
     */
    final ExpensiveService expensive;

    public ClassUnderTest(ExpensiveService expensive) {
      this.expensive = expensive;
    }

    public boolean testMe() {
      expensive.untestableMethod();
      return true;
    }
  }

  private static class FriendlyExpensiveService implements ExpensiveService {
    private final StringBuilder log;

    public FriendlyExpensiveService(StringBuilder log) {
      this.log = log;
    }

    public void untestableMethod() {
      log.append("untestableMethod();");
    }
  }

  public void testWeCanPassAFriendlyToTestThis() throws Exception {
    StringBuilder log = new StringBuilder();
    ExpensiveService friendlyService = new FriendlyExpensiveService(log);
    ClassUnderTest cut = new ClassUnderTest(friendlyService);
    boolean response = cut.testMe();
    assertTrue(response);
    assertEquals("untestableMethod();", log.toString());
  }

}
