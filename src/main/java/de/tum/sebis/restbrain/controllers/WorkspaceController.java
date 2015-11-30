package de.tum.sebis.restbrain.controllers;

import de.tum.sebis.restbrain.models.Workspace;

import io.swagger.inflector.models.RequestContext;
import io.swagger.inflector.models.ResponseContext;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.MediaType;

public class WorkspaceController {
    public ResponseContext getWorkspaces(RequestContext request) {

        // do your magic to fetch a list of workspaces...
        Workspace [] workspaces = new Workspace[4];

        for(int i=0; i<workspaces.length; i++){
            workspaces[i] = new Workspace(i,"Workspace" + String.valueOf(i));//this will call constructor.
        }

        return new ResponseContext()
                .contentType(MediaType.APPLICATION_JSON)
                .status(Status.OK)
                .entity(workspaces);
    }
}