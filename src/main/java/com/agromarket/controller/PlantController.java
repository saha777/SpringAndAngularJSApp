package com.agromarket.controller;

import com.agromarket.components.parsers.ParsDelegate;
import com.agromarket.components.parsers.ParserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
public class PlantController {
    @GetMapping("/family")
    public List<String> getFamily(){
        return new ParsDelegate(ParserEntity.PLANT_PARSER).getListResult();
    }

    @PostMapping("/types")
    public List<String> getGroups(@RequestBody String id){
        return new ParsDelegate(ParserEntity.PLANT_PARSER, id).getListResult();
    }
}
