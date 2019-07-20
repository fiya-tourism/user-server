package com.fy.config;


/**
 * Created by 二哥 on 2019/6/3.
 */
//视频路径 https://www.bilibili.com/video/av50333325/?p=4
//详情路径https://blog.csdn.net/qq122516902/article/details/89417964
//访问路径 http://localhost:8080/swagger-ui.html
/*@Component
// 开启Swagger2的自动配置
@EnableSwagger2
public class SwaggerConfig {
  // 配置docket以配置Swagger具体参数
    @Bean
    public Docket docket() {
        // return new Docket(DocumentationType.SWAGGER_2);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 通过.select()方法，去配置扫描接口
                .select()
                // RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.mr.demo.controller")).build();

    }*/
    //配置API分组
    // 配置是否启动Swagger
   /* @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .ignoredParameterTypes(HttpServletRequest.class)
                .enable(true) // 配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerexample.controller")).build();
    }*/

    //配置是否启动Swagger
    // 态配置当项目处于test、dev环境时显示swagger，处于prod时不显示

    /*@Bean
    public Docket docket(Environment environment) {
        // 设置要显示swagger的环境
        Profiles of = Profiles.of("dev", "test");
        // 判断当前是处于该环境，通过 enable() 接收此参数判断是否要显示
        boolean b = environment.acceptsProfiles(of);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .ignoredParameterTypes(HttpServletRequest.class)
                .enable(b) // 配置是否启用Swagger，如果是false，在浏览器将无法访问
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerexample.controller")).build();
    }*/


    //配置API分组

    /*@Bean
    public Docket docket3() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }
*/
/*
*除了通过包路径配置扫描接口外，还可以通过配置其他方式扫描接口，这里注释一下所有的配置方式：
*   any() // 扫描所有，项目中的所有接口都会被扫描到
    none() // 不扫描接口
    withMethodAnnotation(final Class<? extends Annotation> annotation)// 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
    withClassAnnotation(final Class<? extends Annotation> annotation) // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
    basePackage(final String basePackage) // 根据包路径扫描接口

*
* */

/*
    private ApiInfo apiInfo() {
        Contact contact = new Contact("联系人名字", "http://www.baidu.com/联系人访问链接", "联系人邮箱");
        // public ApiInfo(String title, String description, String version, String termsOfServiceUrl, Contact contact, String ", String licenseUrl, Collection<VendorExtension> vendorExtensions) {
        return new ApiInfo("Swagger学习", // 标题
                "学习演示如何配置Swagger", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()); // 扩展
    }


}*/
