package dxmnd.com.androidxmlparsing;

/**
 * Created by HunJin on 2017-08-06.
 */

public class ParsingData {
    private String d_no;
    private String d_date;
    private String d_title;
    private String d_cont;

    public ParsingData(String no, String date, String title, String cont) {
        this.d_no = no;
        this.d_date = date;
        this.d_title = title;
        this.d_cont = cont;
    }

    public String getD_no() {
        return d_no;
    }

    public void setD_no(String d_no) {
        this.d_no = d_no;
    }

    public String getD_date() {
        return d_date;
    }

    public void setD_date(String d_date) {
        this.d_date = d_date;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public String getD_cont() {
        return d_cont;
    }

    public void setD_cont(String d_cont) {
        this.d_cont = d_cont;
    }
}
