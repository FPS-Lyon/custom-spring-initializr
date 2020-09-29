package fr.pe.initializr.web.project;

import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.controller.ProjectGenerationController;
import io.spring.initializr.web.project.ProjectGenerationInvoker;

import java.util.Map;

/**
 * A custom {@link ProjectGenerationController} that binds request attributes to a
 * {@link CustomProjectRequest}.
 *
 */
public class CustomProjectGenerationController extends ProjectGenerationController<CustomProjectRequest> {

    public CustomProjectGenerationController(InitializrMetadataProvider metadataProvider, ProjectGenerationInvoker<CustomProjectRequest> projectGenerationInvoker) {
        super(metadataProvider, projectGenerationInvoker);
    }

    @Override
    public CustomProjectRequest projectRequest(Map<String, String> headers) {
        CustomProjectRequest request = new CustomProjectRequest();
        request.getParameters().putAll(headers);
        request.initialize(getMetadata());
        return request;
    }
}
