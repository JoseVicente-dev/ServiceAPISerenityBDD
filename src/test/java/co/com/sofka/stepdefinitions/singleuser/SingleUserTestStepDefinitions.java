package co.com.sofka.stepdefinitions.singleuser;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.entity.ContentType;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static co.com.sofka.questions.APIResponse.response;
import static co.com.sofka.task.DoGet.doGet;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class SingleUserTestStepDefinitions extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(SingleUserTestStepDefinitions.class);

    private final HashMap<String, Object> headers = new HashMap<>();
    private final Actor actor = Actor.named("Samuel");
    private String bodyRequest;


    @Given("que estoy en el servicio")
    public void queEstoyEnElServicio() {
        try {
            generalSetUp();

            actor.can(CallAnApi.at(BASE_URI));
            headers.put("Content-Type", ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    @When("y realizo una peticion")
    public void yRealizoUnaPeticion() {

        try {
            actor.attemptsTo(
                    doGet().usingTheResource(RESOURCE_SINGLE_USER)
                            .withHeaders(headers)
            );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }

    }

    @Then("obtendre un status {int}")
    public void obtendreUnStatus(Integer status) {

        LastResponse.received().answeredBy(actor).prettyPrint();

        actor.should(
                seeThatResponse("Es status deberia ser: " + status,
                        validatableResponse -> validatableResponse.statusCode(status)
                ),
                seeThat("La respuesta deberia no ser nula: ", response(), Matchers.notNullValue())
        );
    }
}