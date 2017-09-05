package com.agromarket.components.parsers;

import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

public abstract class SAXHandler extends DefaultHandler {
    public abstract List<String> getListResult();
    public abstract String getItemResult();
}
