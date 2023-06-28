package br.com.pessoal.aprendizado.config.cache;

import br.com.pessoal.aprendizado.model.dto.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.annotations.Cacheable;

@Configuration
@EnableScheduling
public class CacheTelegram {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private Properties properties;

    @Scheduled(fixedRate = 3600000) //1
    public void atualizarCache () {

        cacheManager.getCacheNames().forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    @Cacheable("token")
    public String buscarToken() {

        return properties.getToken();
    }

}
