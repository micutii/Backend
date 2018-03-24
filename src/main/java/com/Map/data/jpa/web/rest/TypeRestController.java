package com.Map.data.jpa.web.rest;

import com.Map.data.jpa.domain.Pin;
import com.Map.data.jpa.domain.Type;
import com.Map.data.jpa.service.Type.TypeService;
import com.Map.data.jpa.service.Type.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by easyw on 24-Mar-18.
 */
@Controller
@RequestMapping(value = "/api/types",
        produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class TypeRestController {

    @Autowired
    TypeService typeService;

    @RequestMapping(
            value = "/get",
            method = RequestMethod.GET)
    public ResponseEntity<List<Type>> getAll(){
        List<Type> types = typeService.getTypes();
        if(types.isEmpty())
        {
            return new ResponseEntity<List<Type>>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<List<Type>>(types, HttpStatus.OK);
    }
    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Type> createType(@RequestBody Type type){
        if(typeService.saveType(type))
        {
            return new ResponseEntity<Type>(type, HttpStatus.CREATED);
        }
        return new ResponseEntity<Type>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(
            value = "/update/{id}",
            method = RequestMethod.PUT)
    public ResponseEntity<Type> updateType(@PathVariable("id") int idType, @RequestBody Type type){
        Type oldType = typeService.getType(idType);
        if(oldType== null){
            return new ResponseEntity<Type>(HttpStatus.NOT_FOUND);
        }
        else{
            type.setIdType(idType);
            typeService.saveType(type);
            return new ResponseEntity<Type>(type, HttpStatus.OK);
        }
    }

    @RequestMapping(
            value = "/delete/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Type> createPin(@PathVariable("id") int idType){

        typeService.removeType(idType);
        return new ResponseEntity<Type>(HttpStatus.OK);
    }
}
