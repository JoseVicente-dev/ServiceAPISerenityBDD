package co.com.sofka.runners.create;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/create.feature"},
        glue ={"co.com.sofka.stepdefinitions.create"}
)
public class CreateTest {
}
