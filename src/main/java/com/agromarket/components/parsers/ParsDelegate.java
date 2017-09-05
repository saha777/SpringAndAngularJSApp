package com.agromarket.components.parsers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ParsDelegate {

    private static final String PLANT_PATH = "src/main/resources/templates/plants.xml";
    private static final String REGIONS_PATH = "src/main/resources/templates/regions.xml";

    private SAXHandler handler;
    private String uri;

    public ParsDelegate(ParserEntity en) {
        setHandler(en);
        parse();
    }

    public ParsDelegate(ParserEntity en, String id) {
        setHandler(en, id);
        parse();
    }

    private void setHandler(ParserEntity entity) {
        switch (entity){
            case PLANT_PARSER:
                handler = new PlantSAXPars();
                uri = PLANT_PATH;
                break;
            case LOCATION_PARSER:
                handler = new LocSAXPars();
                uri = REGIONS_PATH;
                break;
        }
    }

    private void setHandler(ParserEntity entity, String id) {
        switch (entity){
            case PLANT_PARSER:
                handler = new PlantSAXPars(id);
                uri = PLANT_PATH;
                break;
            case LOCATION_PARSER:
                handler = new LocSAXPars(id);
                uri = REGIONS_PATH;
                break;
        }
    }

    private void parse(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(uri), handler);
        }catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getListResult() {
        return handler.getListResult();
    }

    public String getItemResult() {return handler.getItemResult();}
}
