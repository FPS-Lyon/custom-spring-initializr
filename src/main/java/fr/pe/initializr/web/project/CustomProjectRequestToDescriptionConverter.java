package fr.pe.initializr.web.project;

import fr.pe.initializr.generator.project.CustomProjectDescription;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.web.project.DefaultProjectRequestToDescriptionConverter;
import io.spring.initializr.web.project.ProjectRequestToDescriptionConverter;

/**
 * A custom {@link ProjectRequestToDescriptionConverter} to made available {@link CustomProjectDescription} in the {@link ProjectGenerationContext}.
 * {@link DefaultProjectRequestToDescriptionConverter} could reuse to apply general rules for standard fields.
 *
 */
public class CustomProjectRequestToDescriptionConverter implements ProjectRequestToDescriptionConverter<CustomProjectRequest> {

    @Override
    public ProjectDescription convert(CustomProjectRequest request, InitializrMetadata metadata) {
        CustomProjectDescription description = new CustomProjectDescription();
        new DefaultProjectRequestToDescriptionConverter().convert(request, description, metadata);
        description.setIdDga(request.getIdDga());
        description.setDirection(request.getDirection());
        return description;
    }





}
