package com.demain.generator.example;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 官方示例：交互式代码生成
 * <p>
 * 官方文档-代码生成器配置新： <a href="https://baomidou.com/pages/779a6e/#%E4%BD%BF%E7%94%A8">...</a>
 * <a href="https://baomidou.com/pages/981406/">...</a>
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class InteractionCodeGenerator {

	/**
	 * 数据库连接
	 */
	private static final String DB_URL = "jdbc:mysql://host:3306/xxxx?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8";

	/**
	 * 数据库用户名
	 */
	private static final String USERNAME = "root";

	/**
	 * 数据库密码
	 */
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		FastAutoGenerator.create(DB_URL, USERNAME, PASSWORD)
				// 全局配置
				.globalConfig((scanner, builder) -> builder.author(scanner.apply("请输入作者名称？")).fileOverride())
				// 包配置
				.packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
				// 策略配置
				.strategyConfig(
						(scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
								.controllerBuilder().enableRestStyle().enableHyphenStyle().entityBuilder()
								.enableLombok().addTableFills(new Column("create_time", FieldFill.INSERT)).build())
				/*
				 * 模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker .templateEngine(new
				 * BeetlTemplateEngine()) .templateEngine(new FreemarkerTemplateEngine())
				 */
				.execute();

	}

	/**
	 * 处理 all 情况
	 */
	protected static List<String> getTables(String tables) {
		return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
	}

}
