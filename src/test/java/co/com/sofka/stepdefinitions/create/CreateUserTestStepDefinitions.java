package co.com.sofka.stepdefinitions.create;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import co.com.sofka.util.CreateKeys;
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
import static co.com.sofka.util.FileUtilities.readFile;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CreateUserTestStepDefinitions extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(CreateUserTestStepDefinitions.class);
    private static final String CREATE_JSON_FILE_LOCATION = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\create.json";

    private final HashMap<String, Object> headers = new HashMap<>();
    private String bodyRequest;
    private final Actor actor = Actor.named("José");


    private String defineBodyRequest(String name, String job){
        return readFile(CREATE_JSON_FILE_LOCATION)
                .replace(CreateKeys.NAME.getValue(), name).replace(CreateKeys.JOB.getValue(),job);
    }

    @Given("que como administrador cree el usuario con nombre {string} y cargo {string}")
    public void queComoAdministradorCreeElUsuarioConNombreYCargo(String name, String job) {

        try {
            generalSetUp();

            actor.can(CallAnApi.at(BASE_URI));
            headers.put("Content-Type",ContentType.APPLICATION_JSON.toString());
            bodyRequest=(defineBodyRequest(name, job));

            LOGGER.info(ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8));

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }


    @When("envie la orden a la base de datos")
    public void envieLaOrdenALaBaseDeDatos() {
    }

    @Then("se creara un nuevo usuario con sus datos y un id")
    public void seCrearaUnNuevoUsuarioConSusDatosYUnId() {
    }



    @Given("que como administrador intente crear el usuario con nombre {string} y cargo {string}")
    public void queComoAdministradorIntenteCrearElUsuarioConNombreYCargo(String name, String job) {
    }

    @When("envie la orden a la base de datos, pero con un content-type texto")
    public void envieLaOrdenALaBaseDeDatosPeroConUnContentTypeTexto() {
    }

    @Then("se creara un nuevo registro que solo contiene el campo id")
    public void seCrearaUnNuevoRegistroQueSoloContieneElCampoId() {
    }
}