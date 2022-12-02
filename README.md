## mybatis-plus-generator-simple

### 📣是什么

> 简化mybatis-plus-generator生成代码配置，用户可以通过简单配置实现代码生成

### 👇使用说明

> 引入依赖


```xml
<dependency>
  <groupId>io.github.slightlee</groupId>
  <artifactId>mybatis-plus-generator-simple</artifactId>
  <version>0.0.1-RELEASE</version>
</dependency>
```
```java
@Test
public void Test() {
    GeneratorInfoConfig generatorInfoConfig = new GeneratorInfoConfig.Builder().author("demain_lee").dbUrl(
        "jdbc:mysql://127.0.0.1:3306/xxx?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8")
        .username("root").password("root")
        // .packageName("com.xxx.xxx")
        // .outputDir("C:\\Users\\ming\\")
        // .mapperDir("C:\\Users\\ming\\mapper")
        .tablePrefix("t_").includeTable().excludeTable("t_tag").idType(IdType.ASSIGN_ID)
        // .templateEngine(new VelocityTemplateEngine())
        // .enableSwagger()
        // .enableLombok()
        .build();
    CodeGeneratorConfig.runCodeGenerator(generatorInfoConfig);
}

```
### 🍕版本特性

> v0.0.1 基于 mybatis-plus-generator v3.5.3 生成代码封装，简化生成代码配置


### 🌈发布计划

> v0.0.2 代码封装模块化，优化代码结构
>
> v0.0.3 增加自定义模板配置

