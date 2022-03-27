package pl.lodz.dmcs.javaee.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {

    @Bean
    @Primary
    public ChainedTransactionManager chainedTransactionManager(@Qualifier("TransactionManager") PlatformTransactionManager TransactionManager,
                                                               @Qualifier("AnalyticsTransactionManager") PlatformTransactionManager AnalyticsTransactionManager,
                                                               @Qualifier("mongoTransactionManager") MongoTransactionManager mongoTransactionManager) {
        return new ChainedTransactionManager(TransactionManager, AnalyticsTransactionManager, mongoTransactionManager);
    }
}