package com.jd.jdemo.config;

import com.jd.cachecloud.cfs.client.ConfigRESTClientFactoryBean;
import com.jd.jim.cli.ReloadableJimClientFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;

/**
 * JIMDB 配置类
 */
@Configuration
@Slf4j
public class JimConfig {
  /*  @Value("${jd.resources.jim.url}")
    private String jimUrl;
    @Value("${jd.resources.jim.serviceEndpoint}")
    private String serviceEndpoint;

    @Bean
    public ConfigRESTClientFactoryBean getConfigRESTClientFactoryBean() {
        ConfigRESTClientFactoryBean configRESTClientFactoryBean = new ConfigRESTClientFactoryBean();
        configRESTClientFactoryBean.setServiceEndpoint(serviceEndpoint);
        return configRESTClientFactoryBean;
    }

    @Bean
    public ReloadableJimClientFactoryBean getReloadableJimClientFactoryBean(ConfigRESTClientFactoryBean configRESTClientFactoryBean) {
        ReloadableJimClientFactoryBean reloadableJimClientFactoryBean = null;
        try {
            reloadableJimClientFactoryBean = new ReloadableJimClientFactoryBean();
            reloadableJimClientFactoryBean.setJimUrl(jimUrl);
            reloadableJimClientFactoryBean.setConfigClient(configRESTClientFactoryBean);
        } catch (Exception e) {
            log.error("********JIMDB连接异常********", e);
        }
        return reloadableJimClientFactoryBean;
    }*/

}
