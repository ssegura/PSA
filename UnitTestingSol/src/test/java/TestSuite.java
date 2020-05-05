import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

// OJO: JUnit 5 no tiene soporte nativo para suites y es necesario usar JUnit 4 que no reconoce test parametrizados.

@RunWith(JUnitPlatform.class)
@SelectPackages({"psa.math","psa.string"})
@ExcludeTags("parameterized")
public class TestSuite
{
}
