package com.sqs.project.nachrichtenapp;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

class ArchitectureTest {

    private final JavaClasses importedClasses = new ClassFileImporter().importPackages("com.sqs.project.nachrichtenapp");

    @Test
    void servicesShouldResideInServicePackage() {
        ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Service")
                .should().resideInAnyPackage("..service..")
                .check(importedClasses);
    }

    @Test
    void controllersShouldResideInControllerPackage() {
        ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Controller")
                .should().resideInAnyPackage("..controller..")
                .check(importedClasses);
    }

    @Test
    void repositoriesShouldResideInRepositoryPackage() {
        ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Repository")
                .should().resideInAnyPackage("..repository..")
                .check(importedClasses);
    }

    @Test
    void servicesShouldBeAnnotatedWithService() {
        ArchRuleDefinition.classes()
                .that().resideInAnyPackage("..service..")
                .should().beAnnotatedWith(Service.class)
                .check(importedClasses);
    }

    @Test
    void controllersShouldBeAnnotatedWithRestController() {
        ArchRuleDefinition.classes()
                .that().resideInAnyPackage("..controller..")
                .should().beAnnotatedWith(RestController.class)
                .check(importedClasses);
    }
}
