package deshraj.chatapplication.configuration;

import deshraj.chatapplication.common.Constants;
import deshraj.chatapplication.configuration.filters.ChatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

    @Bean
    public FilterRegistrationBean<ChatFilter> filterRegistrationBean() {
        FilterRegistrationBean < ChatFilter > registrationBean = new FilterRegistrationBean();
        ChatFilter customURLFilter = new ChatFilter();

        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns(Constants.BASE_URL+"/*");
        registrationBean.setOrder(1); //set precedence
        return registrationBean;
    }
}
