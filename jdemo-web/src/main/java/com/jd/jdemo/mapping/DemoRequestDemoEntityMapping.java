package com.jd.jdemo.mapping;

import com.jd.jdemo.dto.request.DemoRequest;
import com.jd.jdemo.entity.primary.DemoEntity;
import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.stereotype.Component;

/**
 * DTO转换工具，特殊映射关系配置类（不同属性名，不同层级关系等的映射）
 */
@Component
public class DemoRequestDemoEntityMapping implements OrikaMapperFactoryConfigurer {


    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(DemoRequest.class, DemoEntity.class)
                .mapNulls(false)
                .fieldAToB("id", "id")
                .fieldAToB("name", "name")
                .byDefault().register();
    }
}
