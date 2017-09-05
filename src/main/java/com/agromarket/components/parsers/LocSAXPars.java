package com.agromarket.components.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.LinkedList;
import java.util.List;

public class LocSAXPars extends SAXHandler {

    private String cityId;
    private String cityName;
    private String regionId;
    private String regionName;
    private String[] ids;

    private List<String> listResult = new LinkedList<>();
    private String itemResult;

    public LocSAXPars() {
        ids = new String[0];
    }

    public LocSAXPars(String id) {
        this.ids = id.split(" ");
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName){
            case "region":
                regionId = attributes.getValue("id");
                regionName = attributes.getValue("name");
                break;
            case "city":
                cityId = attributes.getValue("id");
                cityName = attributes.getValue("name");
                break;
        }

        switch (ids.length){
            case 0:
                if (qName.equals("region")) {
                    listResult.add(attributes.getValue("name"));
                }
                break;
            case 1:
                if (ids[0].equals(regionId) && qName.equals("city")) {
                    listResult.add(attributes.getValue("name"));
                }
                break;
            case 2:
                if ((ids[0].equals(regionId) && ids[1].equals(cityId)) && qName.equals("city")){
                    itemResult = regionName + ", " + cityName;
                }
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public List<String> getListResult() {
        return listResult;
    }

    @Override
    public String getItemResult() {
        return itemResult;
    }
}
