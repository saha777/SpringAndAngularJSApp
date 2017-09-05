package com.agromarket.controller;

import com.agromarket.components.parsers.ParsDelegate;
import com.agromarket.components.parsers.ParserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @GetMapping("/regions")
    public List<String> getRegions() {
        return new ParsDelegate(ParserEntity.LOCATION_PARSER).getListResult();
    }

    @PostMapping("/cities")
    public List<String> getCities(@RequestBody String regionId){
        return new ParsDelegate(ParserEntity.LOCATION_PARSER, regionId).getListResult();
    }

}