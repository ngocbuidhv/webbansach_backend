package ngoc.webbansach_backend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import ngoc.webbansach_backend.entity.NguoiDung;
import ngoc.webbansach_backend.entity.TheLoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import static org.aspectj.weaver.loadtime.definition.Definition.DeclareAnnotationKind.Type;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url = "http://localhost:3000";

    @Autowired
    private EntityManager entityManager;
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // cho phep id trong khi tra ve json
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(jakarta.persistence.metamodel.Type::getJavaType).toArray(Class[]::new));
        // cors configuration
        cors.addMapping("/**")
                .allowedOrigins(url)
                .allowedMethods("GET", "POST", "PUT", "DELETE");

        // chặn các methods
        HttpMethod[] chanCacPhuongThuc = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
        };

        // export id;

//        config.exposeIdsFor(TheLoai.class);

        disableHttpMethods(TheLoai.class, config, chanCacPhuongThuc);
//
        HttpMethod[] phuongThucDelete = {
                HttpMethod.DELETE
        };
        disableHttpMethods(NguoiDung.class, config, phuongThucDelete);
    }

    private void disableHttpMethods(Class c, RepositoryRestConfiguration config,
                                 HttpMethod[] methods){
        config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(methods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(methods));
    }

}
