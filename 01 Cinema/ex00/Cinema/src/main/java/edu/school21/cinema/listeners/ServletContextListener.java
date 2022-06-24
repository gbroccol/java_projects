package edu.school21.cinema.listeners;

import edu.school21.cinema.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("springContext", context);
        javax.servlet.ServletContextListener.super.contextInitialized(sce);

        JdbcTemplate jdbcTemplate = (JdbcTemplate)context.getBean("jdbcTemplate");
        List<String> schemaDefinitionStatements = extractSQLStatements("sql/schema.sql");
        List<String> sampleDataSqlStatements = extractSQLStatements("sql/data.sql");

        runSqlStatements(schemaDefinitionStatements, jdbcTemplate);
        runSqlStatements(sampleDataSqlStatements, jdbcTemplate);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        javax.servlet.ServletContextListener.super.contextDestroyed(sce);
    }

    private List<String> extractSQLStatements(String schemaDefinitionFileName) {
        List<String> statements = new ArrayList<>();

        try (InputStream is = ServletContextListener.class.getResourceAsStream("/" + schemaDefinitionFileName))  {
            Scanner scanner = new Scanner(is);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                statements.add(scanner.next());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to open schema definition file.");
        }
        return statements;
    }

    private void runSqlStatements(List<String> ddlStatements, JdbcTemplate jdbcTemplate) {
        try {
            ddlStatements.forEach(jdbcTemplate::execute);
        } catch (Exception e) {}
    }
}
