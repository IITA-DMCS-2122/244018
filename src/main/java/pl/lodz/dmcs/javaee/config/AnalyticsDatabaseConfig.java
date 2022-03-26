package pl.lodz.dmcs.javaee.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.lodz.dmcs.javaee.model.analytics.TodoItemAnalyticsEntity;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "pl.lodz.dmcs.javaee.repositories.analytics",
        entityManagerFactoryRef = "AnalyticsEntityManagerFactory",
        transactionManagerRef = "AnalyticsTransactionManager"
)
public class AnalyticsDatabaseConfig {

    @Bean("postgresAnalyticsDataSource")
    @ConfigurationProperties(prefix = "postgres.analytics")
    public DataSource postgresAnalyticsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "AnalyticsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean AnalyticsEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        return builder.dataSource(postgresAnalyticsDataSource()).packages(TodoItemAnalyticsEntity.class.getPackage().getName()).properties(properties).build();
    }

    @Bean("AnalyticsTransactionManager")
    public PlatformTransactionManager AnalyticsTransactionManager(
            final @Qualifier("AnalyticsEntityManagerFactory") LocalContainerEntityManagerFactoryBean memberEntityManagerFactory) {
        return new JpaTransactionManager(memberEntityManagerFactory.getObject());
    }
}