package com.agromarket.components.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.LinkedList;
import java.util.List;

public class PlantSAXPars extends SAXHandler{

    private String familyId;
    private String familyName;
    private String kindId;
    private String kindName;
    private String groupId;
    private String groupName;
    private String[] ids;

    private List<String> listResult = new LinkedList<>();
    private String itemResult;

    public PlantSAXPars() {
        this.ids = new String[0];
    }

    public PlantSAXPars(String id){
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
            case "family":
                familyId = attributes.getValue("id");
                familyName = attributes.getValue("name");
                break;
            case "kind":
                kindId = attributes.getValue("id");
                kindName = attributes.getValue("name");
                break;
            case "group":
                groupId = attributes.getValue("id");
                groupName = attributes.getValue("name");
                break;
        }

        switch (ids.length){
            case 0:
                if (qName.equals("family")) {
                    listResult.add(attributes.getValue("name"));
                }
                break;
            case 1:
                if (ids[0].equals(familyId) && qName.equals("kind")) {
                    listResult.add(attributes.getValue("name"));
                }
                break;
            case 2:
                if ((ids[0].equals(familyId) && ids[1].equals(kindId)) && qName.equals("group")){
                    listResult.add(attributes.getValue("name"));
                }
                break;
            case 3:
                if (ids[0].equals(familyId) && qName.equals("group")) {
                    if (ids[2].equals(groupId) && ids[1].equals(kindId) ) {
                        itemResult = familyName + ", " + kindName + ", " + groupName;
                    }
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
