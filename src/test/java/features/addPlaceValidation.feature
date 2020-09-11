Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: verify if place is being successfully added using AddPlaceAPI
 Given Add place PayLoad "<name>" "<language >" "<address>"
 When user calls "addPlaceApi" with "Post" http request
 Then the API call got success with status code 200
 And "status" in response body should be "OK"
 And "scope" in response body should be "APP"
 And verify that place_id created maps to "<name>" using "getPlaceApi"
 
 Examples:
    |name    | language   | address  |
    |Aravind | English    |banglore, karnataka|
    #|Spoorthi| Kannada    |banglore, karnataka,India|
    
@DeletePlace @Regression
Scenario: verify that delete place functionality is working
      Given delete place payload
      When user calls "deletePlaceAPI" with "Post" http request
      Then the API call got success with status code 200
      And "status" in response body should be "OK"
      