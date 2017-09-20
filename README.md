# AndroidXMLParsing

android에서 xml파싱을 하는 방법

핵심 소스

```
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
}
```
