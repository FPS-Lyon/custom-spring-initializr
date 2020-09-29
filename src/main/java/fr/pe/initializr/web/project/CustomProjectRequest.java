package fr.pe.initializr.web.project;

import io.spring.initializr.web.project.WebProjectRequest;

/**
 * A custom {@link ProjectRequest} with an additional custom fields.
 *
 */
public class CustomProjectRequest extends WebProjectRequest {

    private String idDga;

    private String direction;


    public String getIdDga() {
        return this.idDga;
    }

    public void setIdDga(String idDga) {
        this.idDga = idDga;
    }

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "CustomProjectRequest{" +
                "idDga='" + idDga + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
