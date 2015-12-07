package de.tum.sebis.restbrain.controllers;

import de.tum.sebis.restbrain.models.Pet;

import io.swagger.inflector.models.RequestContext;
import io.swagger.inflector.models.ResponseContext;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.MediaType;

public class PetController {
    public ResponseContext getPets(RequestContext request) {

        // do your magic to fetch a list of pets...
        Pet[] pets = new Pet[4];

        for(int i = 0; i< pets.length; i++){
            pets[i] = new Pet(i,"Pet" + String.valueOf(i));//this will call constructor.
        }

        return new ResponseContext()
                .contentType(MediaType.APPLICATION_JSON)
                .status(Status.OK)
                .entity(pets);
    }
}