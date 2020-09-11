package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@DeletePlace")

    public void beforeScenario() throws IOException {

        // execute this code only if placeId is null
        // write a code to create placeId
        StepDefination sp = new StepDefination();
        if (StepDefination.place_id == null) {
            sp.add_place_PayLoad("Subhash", "Kannada", "#170C, Mattikote");
            sp.user_calls_with_http_request("addPlaceApi", "POST");
            sp.verify_that_place_id_created_maps_to_using("Subhash", "getPlaceApi");
        }
    }

}
