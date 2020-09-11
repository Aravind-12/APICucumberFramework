package paypalExamples;

import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.http.ContentType;
import pojo.PayPal;

public class CreatePayement extends PayPal {

    static String paymentId;

    /**
     *
     */
    @Test
    public void createPayement() {

        String body = "{\n" +
                "  \"intent\": \"sale\",\n" +
                "  \"payer\": {\n" +
                "    \"payment_method\": \"paypal\"\n" +
                "  },\n" +
                "  \"transactions\": [{\n" +
                "    \"amount\": {\n" +
                "      \"currency\": \"BRL\",\n" +
                "      \"total\": \"93.00\",\n" +
                "      \"details\": {\n" +
                "        \"shipping\": \"11\",\n" +
                "        \"subtotal\": \"75\",\n" +
                "        \"shipping_discount\": \"1.00\",\n" +
                "        \"insurance\": \"1.00\",\n" +
                "        \"handling_fee\": \"1.00\",\n" +
                "        \"tax\": \"6.00\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"description\": \"This is the payment transaction description\",\n" +
                "    \"payment_options\": {\n" +
                "      \"allowed_payment_method\": \"IMMEDIATE_PAY\"\n" +
                "    },\n" +
                "    \"item_list\": {\n" +
                "      \"shipping_address\": {\n" +
                "        \"recipient_name\": \"PP Plus Recipient\",\n" +
                "        \"line1\": \"Gregório Rolim de Oliveira, 42\",\n" +
                "        \"line2\": \"JD Serrano II\",\n" +
                "        \"city\": \"Votorantim\",\n" +
                "        \"country_code\": \"BR\",\n" +
                "        \"postal_code\": \"18117-134\",\n" +
                "        \"state\": \"São Paulo\",\n" +
                "        \"phone\": \"0800-761-0880\"\n" +
                "      },\n" +
                "      \"items\": [{\n" +
                "        \"name\": \"handbag\",\n" +
                "        \"description\": \"red diamond\",\n" +
                "        \"quantity\": \"1\",\n" +
                "        \"price\": \"75\",\n" +
                "        \"tax\": \"6\",\n" +
                "        \"sku\": \"product34\",\n" +
                "        \"currency\": \"BRL\"\n" +
                "      }]\n" +
                "    }\n" +
                "  }],\n" +
                "  \"redirect_urls\": {\n" +
                "    \"return_url\": \"https://example.com/return\",\n" +
                "    \"cancel_url\": \"https://example.com/cancel\"\n" +
                "  }\n" +
                "}";

        /*
         * Items items = new Items();
         * items.setCurrency("BRL");
         * items.setDescription("red diamond");
         * items.setName("handbag");
         * items.setPrice("75");
         * items.setQuantity("1");
         * items.setSku("\"product34\"");
         * items.setTax("6");
         *
         * List<Items> ite = new ArrayList<Items>();
         * ite.add(items);
         * ShippingAddress shi = new ShippingAddress();
         * shi.setCity("Votorantim");
         * shi.setCountry_code("BR");
         * shi.setLine1("Gregório Rolim de Oliveira, 42");
         * shi.setLine2("JD Serrano II");
         * shi.setPhone("0800-761-0880");
         * shi.setPostal_code("18117-134");
         * shi.setRecipient_name("PP Plus Recipient");
         * shi.setState("São Paulo");
         *
         * Item_list item = new Item_list();
         * item.setItems(ite);
         * item.setShipping_address(shi);
         * Redirect direct = new Redirect();
         * direct.setCancel_url("\"https://example.com/cancel\"");
         * direct.setReturn_url("\"https://example.com/return\"");
         * Details details = new Details();
         * details.setHandling_fee("1.00");
         * details.setInsurance("1.00");
         * details.setShipping("11");
         * details.setShipping_discount("1.00");
         * details.setSubtotal("75");
         * details.setTax("6.00");
         * Amount amount = new Amount();
         * amount.setDetails(details);
         * amount.setCurrency("BRL");
         * amount.setDescription("This is the payment transaction description");
         * amount.setTotal("93.00");
         * PaymentOption pay = new PaymentOption();
         * pay.setAllowed_payment_method("IMMEDIATE_PAY");
         * Transactions tra = new Transactions();
         * tra.setAmount(amount);
         * tra.setDescription("This is the payment transaction description");
         * tra.setItem_list(item);
         * tra.setPayment_options(pay);
         * List<Transactions> trans = new ArrayList<Transactions>();
         * trans.add(tra);
         *
         * Payer payer = new Payer();
         * payer.setPayement_method("paypal");
         * PaypalPojo paypal = new PaypalPojo();
         * paypal.setIntent("sale");
         * paypal.setPayer(payer);
         * paypal.setRedirect_urls(direct);
         * paypal.setTransactions(trans);
         */

        paymentId = given().contentType(ContentType.JSON)
                .auth()
                .oauth2(accToken)
                .when()
                .body(body)
                .post("/payments/payment")
                .then().log().all().extract().path("id");

    }

    @Test
    public void payementDet() {
        given().auth().oauth2(accToken)
                .when().get("payments/payment" + paymentId)
                .then().log().all();
    }

}
