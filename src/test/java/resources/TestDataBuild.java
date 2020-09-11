package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddDetails;
import pojo.Location;

public class TestDataBuild {

    public AddDetails addPlacePayload(String name, String language, String address) {
        AddDetails adding = new AddDetails();
        adding.setAccuracy(40);
        adding.setAddress(address);
        adding.setLanguage(language);
        adding.setName(name);
        adding.setPhone_number("9743198211");
        adding.setWebsite("http://google.com");
        List<String> l = new ArrayList<String>();
        l.add("shoe park");
        l.add("shop");
        adding.setTypes(l);
        Location loc = new Location();
        loc.setLat(-38.383494);
        loc.setLng(33.427362);
        adding.setLocation(loc);
        return adding;
    }

    public String deletePlacePayload(String placeId) {
        return "{\r\n    \"place_id\":\"" + placeId + "\"   \t \r\n}";

    }

}
