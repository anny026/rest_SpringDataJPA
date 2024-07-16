package shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"shop", "shop.model.entity", "shop.model.repository"})
public class RootConfig {
}
