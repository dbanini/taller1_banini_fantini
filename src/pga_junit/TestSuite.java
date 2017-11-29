package pga_junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses( { CoberturaTest.class, ControladorTest.class, EntidadesTest.class, PersistenciaTest.class } )
public class TestSuite 
{
	
}
