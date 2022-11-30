package com.demain.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.demain.generator.config.CodeGeneratorConfig;
import com.demain.generator.config.GeneratorInfoConfig;
import org.junit.jupiter.api.Test;

/**
 * 测试
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class CodeGeneratorConfigTest {

	/**
	 * 代码生成
	 */
	@Test
	public void Test() {

		GeneratorInfoConfig generatorInfoConfig = new GeneratorInfoConfig.Builder().author("demain_lee").dbUrl(
				"jdbc:mysql://127.0.0.1:3306/blog-cloud?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8")
				.username("root").password("root")
				// .packageName("com.xxx.xxx")
				// .outputDir("C:\\Users\\ming\\")
				// .mapperDir("C:\\Users\\ming\\mapper")
				.tablePrefix("blog_").includeTable().excludeTable("blog_tag").idType(IdType.ASSIGN_ID)
				// .templateEngine(new VelocityTemplateEngine())
				// .enableSwagger()
				// .enableLombok()
				.build();

		CodeGeneratorConfig.runCodeGenerator(generatorInfoConfig);
	}

}
