package fr.pe.initializr.generator.project.configuration;

import fr.pe.initializr.web.project.CustomProjectGenerationController;
import fr.pe.initializr.web.project.CustomProjectRequest;
import fr.pe.initializr.web.project.CustomProjectRequestToDescriptionConverter;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.web.project.ProjectGenerationInvoker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomProjectGenerationConfiguration {

    @Bean
    public CustomProjectGenerationController projectGenerationController (InitializrMetadataProvider metadataProvider,
                                                                          ApplicationContext applicationContext) {
        ProjectGenerationInvoker<CustomProjectRequest> projectGenerationInvoker = new ProjectGenerationInvoker<>(
                applicationContext, new CustomProjectRequestToDescriptionConverter());
        return new CustomProjectGenerationController(metadataProvider, projectGenerationInvoker);
    }
}
