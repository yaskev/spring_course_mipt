package ru.sbt.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;

public class FileInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        final var appContext = new AnnotationConfigWebApplicationContext();
        appContext.scan("ru.sbt");
        appContext.refresh();

        final var dispatcher = servletContext.addServlet("filesApp",
                new DispatcherServlet(appContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
