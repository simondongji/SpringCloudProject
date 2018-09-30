package priv.simon.chainmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import zipkin2.server.internal.EnableZipkinServer;
import zipkin2.storage.mysql.v1.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ChainmonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChainmonitorApplication.class, args);
    }
    
//    @Bean
//    public MySQLStorage mySQLStorage(DataSource datasource) {
//        return MySQLStorage.newBuilder().datasource(datasource).executor(Runnable::run).build();
//    }
}
