package pojo;

import java.util.List;

public class PaypalPojo {

    private List<Transactions> transactions;

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Payer getPayer() {
        return payer;
    }

    public void setPayer(Payer payer) {
        this.payer = payer;
    }

    public Redirect getRedirect_urls() {
        return redirect_urls;
    }

    public void setRedirect_urls(Redirect redirect_urls) {
        this.redirect_urls = redirect_urls;
    }

    private String intent;
    private Payer payer;
    private Redirect redirect_urls;
}
