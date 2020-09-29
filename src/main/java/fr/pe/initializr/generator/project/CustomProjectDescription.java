package fr.pe.initializr.generator.project;

import io.spring.initializr.generator.project.MutableProjectDescription;

/**
 * A custom {@link ProjectDescription} to convey the additional fields to contributor .
 *
 */
public class CustomProjectDescription extends MutableProjectDescription{


    private String idDga;

    private String direction;


    public CustomProjectDescription() {
    }

    /**
     * Create a new instance with the state of the specified {@code source}.
     * @param source the source description to initialize this instance with
     */
    protected CustomProjectDescription(CustomProjectDescription source) {
       super(source);
       this.idDga= source.getIdDga();
       this.direction= source.getDirection();
    }


    @Override
    public CustomProjectDescription createCopy() {
        return new CustomProjectDescription(this);
    }

    public void setIdDga(String idDga) {
        this.idDga = idDga;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIdDga() {
        return idDga;
    }

    public String getDirection() {
        return direction;
    }
}