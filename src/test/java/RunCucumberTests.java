import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.*;
import org.testng.annotations.Test;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"src/test/java/Defs"},
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)

@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests{

}