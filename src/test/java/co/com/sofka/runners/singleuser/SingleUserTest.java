package co.com.sofka.runners.singleuser;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/singleuser.feature"},
        glue ={"co.com.sofka.stepdefinitions"}
)
public class SingleUserTest {
}
