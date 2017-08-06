package dxmnd.com.androidxmlparsing;

import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by HunJin on 2017-08-06.
 */

public class XMLParsing extends AsyncTask<Object, Object, List<ParsingData>> {

    // TODO: 2017-08-06 URL 입력
    private String URL;

    private Document doc = null;

    private static final String RECORD = "record";
    private static final String NO = "d_no";
    private static final String DATE = "d_date";
    private static final String TITLE = "d_title";
    private static final String CONT = "d_cont";

    public XMLParsing(String URL) {
        this.URL = URL;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 값을 가져오기 전에 하고 싶은 일 (프로그레스 바를 띄운다던가 등등)
    }

    @Override
    protected List<ParsingData> doInBackground(Object... params) {
        List<ParsingData> list = new ArrayList<>();
        try {
            URL url = new URL(URL);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
            doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
            doc.getDocumentElement().normalize();


            NodeList nodeListRecord = doc.getElementsByTagName(RECORD);
            NodeList nodeListNo = doc.getElementsByTagName(NO);
            NodeList nodeListDate = doc.getElementsByTagName(DATE);
            NodeList nodeListTitle = doc.getElementsByTagName(TITLE);
            NodeList nodeListCont = doc.getElementsByTagName(CONT);

            for (int i = 0; i < nodeListRecord.getLength(); i++) {
                String no = nodeListNo.item(i).getFirstChild().getNodeValue();
                String date = nodeListDate.item(i).getFirstChild().getNodeValue();
                String title = nodeListTitle.item(i).getFirstChild().getNodeValue();
                String cont = nodeListCont.item(i).getFirstChild().getNodeValue();

                list.add(new ParsingData(no, date, title, cont));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<ParsingData> parsingDatas) {
        super.onPostExecute(parsingDatas);
        // 값을 가져오고 나서 하는 일 (프로그레스바를 종료한다던가 등)
    }
}
