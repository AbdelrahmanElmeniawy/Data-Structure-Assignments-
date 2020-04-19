package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayBasedTest01.class, ArrayBasedTest02.class, ArrayBasedTest03.class, ArrayBasedTest04.class,
		LinkedBasedTest01.class, LinkedBasedTest02.class, LinkedBasedTest03.class, LinkedBasedTest04.class })
public class AllAssignmentTests {

}
