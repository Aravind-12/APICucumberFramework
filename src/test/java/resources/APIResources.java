package resources;

public enum APIResources {

    addPlaceApi("/maps/api/place/add/json"),
    getPlaceApi("/maps/api/place/get/json"),
    deletePlaceAPI("/maps/api/place/delete/json");
    public String resource;

    APIResources(String resource) {

        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

}
