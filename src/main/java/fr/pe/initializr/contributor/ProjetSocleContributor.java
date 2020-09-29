package fr.pe.initializr.contributor;

import fr.pe.initializr.generator.project.CustomProjectDescription;
import io.spring.initializr.generator.buildsystem.maven.MavenBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnBuildSystem;
import io.spring.initializr.generator.condition.ConditionalOnPackaging;
import io.spring.initializr.generator.packaging.jar.JarPackaging;
import io.spring.initializr.generator.project.ProjectDescription;
import io.spring.initializr.generator.project.contributor.ProjectContributor;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

@ConditionalOnBuildSystem(MavenBuildSystem.ID)
@ConditionalOnPackaging(JarPackaging.ID)
public class ProjetSocleContributor implements ProjectContributor {

    private final ProjectDescription description;

    ProjetSocleContributor(ProjectDescription description) {
        this.description = description;
    }

    @Override
    public void contribute(Path projectRoot) throws IOException {

        Files.delete( projectRoot.resolve( "src/main/resources/application.properties" ) );
        Files.createFile( projectRoot.resolve( "src/main/resources/application.yml" ) );
        try (PrintWriter writer = new PrintWriter( Files.newBufferedWriter( projectRoot.resolve( "src/main/resources/application.yml" ) ) )) {
            writer.println( "info:" );
            writer.println( "  app:" );
            writer.println( "    version: @project.version@" );
        }

        Path file = Files.createFile( projectRoot.resolve( "readme.md" ) );
        try (PrintWriter writer = new PrintWriter( Files.newBufferedWriter( file ) )) {
            writer.println();
        }

        if (this.description instanceof CustomProjectDescription) {
            CustomProjectDescription customProjectDescription =(CustomProjectDescription) this.description;
            Path customFilePath=Files.createFile(projectRoot.resolve("custom.txt"));
            try (PrintWriter writer = new PrintWriter( Files.newBufferedWriter( customFilePath ) )) {
                writer.println(customProjectDescription.getIdDga());
                writer.println(this.description.getName());
            }
        }


    }

    @Override
    public int getOrder() {
        return 1;
    }
}
