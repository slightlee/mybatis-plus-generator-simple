package com.demain.generator.example;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 官方示例：快速代码生成
 * <p>
 * 官方文档-代码生成器配置新： <a href="https://baomidou.com/pages/779a6e/#%E4%BD%BF%E7%94%A8">...</a>
 * <a href="https://baomidou.com/pages/981406/">...</a>
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class FastCodeGenerator {

	public static void main(String[] args) {

		FastAutoGenerator.create("url", "username", "password").globalConfig(builder -> {
			builder.author("baomidou") // 设置作者
					.enableSwagger() // 开启 swagger 模式
					.fileOverride() // 覆盖已生成文件
					.outputDir("D://"); // 指定输出目录
		}).packageConfig(builder -> {
			builder.parent("com.baomidou.mybatisplus.samples.generator") // 设置父包名
					.moduleName("system") // 设置父包模块名
					.pathInfo(Collections.singletonMap(OutputFile.xml, "D://")); // 设置mapperXml生成路径
		}).strategyConfig(builder -> {
			builder.addInclude("t_simple") // 设置需要生成的表名
					.addTablePrefix("t_", "c_"); // 设置过滤表前缀
		})
				// 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.templateEngine(new FreemarkerTemplateEngine()).execute();

	}

}
