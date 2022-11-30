package com.demain.generator.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;

import java.util.Collections;
import java.util.function.Consumer;

/**
 * 代码生成配置
 * <p>
 * <p>
 * 官方文档-代码生成器配置新： <a href="https://baomidou.com/pages/779a6e/#%E4%BD%BF%E7%94%A8">...</a>
 * <a href="https://baomidou.com/pages/981406/">...</a>
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class CodeGeneratorConfig {

	/**
	 * 代码生成
	 */
	public static void runCodeGenerator(GeneratorInfoConfig generatorInfoConfig) {

		FastAutoGenerator.create(getDataSourceConfig(generatorInfoConfig))
				// 全局配置
				.globalConfig(generatorInfoConfig.isEnableSwagger() ? getGlobalConfigEnableSwagger(generatorInfoConfig)
						: getGlobalConfig(generatorInfoConfig))
				// 包配置
				.packageConfig(getPackageConfig(generatorInfoConfig))
				// 策略配置
				.strategyConfig(generatorInfoConfig.isEnableLombok()
						? getStrategyConfigEnableLombok(generatorInfoConfig) : getStrategyConfig(generatorInfoConfig))
				// 默认的是Velocity引擎模板，也可使用 Beetl 、Freemarker
				.templateEngine(generatorInfoConfig.getTemplateEngine()).execute();
	}

	/**
	 * 数据库配置(DataSourceConfig)
	 */
	static DataSourceConfig.Builder getDataSourceConfig(GeneratorInfoConfig generatorInfoConfig) {
		return new DataSourceConfig.Builder(generatorInfoConfig.getDbUrl(), generatorInfoConfig.getUsername(),
				generatorInfoConfig.getPassword());
	}

	/**
	 * 全局配置(GlobalConfig) 未开启 swagger 模式
	 */
	static Consumer<GlobalConfig.Builder> getGlobalConfig(GeneratorInfoConfig generatorInfoConfig) {
		return builder -> builder.author(generatorInfoConfig.getAuthor()).outputDir(generatorInfoConfig.getOutputDir());
	}

	/**
	 * 全局配置(GlobalConfig) 开启 swagger 模式
	 */
	static Consumer<GlobalConfig.Builder> getGlobalConfigEnableSwagger(GeneratorInfoConfig generatorInfoConfig) {
		return builder -> builder.author(generatorInfoConfig.getAuthor()).outputDir(generatorInfoConfig.getOutputDir())
				// 开启 swagger 模式
				.enableSwagger();
	}

	/**
	 * 包配置(PackageConfig)
	 */
	static Consumer<PackageConfig.Builder> getPackageConfig(GeneratorInfoConfig generatorInfoConfig) {
		return builder -> builder.parent(generatorInfoConfig.getPackageName())
				.moduleName(generatorInfoConfig.getModuleName())
				.pathInfo(Collections.singletonMap(OutputFile.xml, generatorInfoConfig.getMapperDir()));
	}

	/**
	 * 策略配置(StrategyConfig) entityBuilder 未开启 lombok 模式
	 */
	static Consumer<StrategyConfig.Builder> getStrategyConfig(GeneratorInfoConfig generatorInfoConfig) {
		return builder -> builder.addInclude(generatorInfoConfig.getIncludeTable())
				.addExclude(generatorInfoConfig.getExcludeTable()).addTablePrefix(generatorInfoConfig.getTablePrefix())
				// entity 策略配置
				.entityBuilder().idType(generatorInfoConfig.getIdType())
				// mapper 策略配置
				.mapperBuilder().enableBaseResultMap().enableBaseColumnList()
				// service 策略配置
				.serviceBuilder().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImpl")
				// controller 策略配置
				.controllerBuilder().enableRestStyle().formatFileName("%sController").build();
	}

	/**
	 * 策略配置(StrategyConfig) entityBuilder 开启 lombok 模式
	 */
	static Consumer<StrategyConfig.Builder> getStrategyConfigEnableLombok(GeneratorInfoConfig generatorInfoConfig) {
		return builder -> builder.addInclude(generatorInfoConfig.getIncludeTable())
				.addExclude(generatorInfoConfig.getExcludeTable()).addTablePrefix(generatorInfoConfig.getTablePrefix())
				// entity 策略配置
				.entityBuilder().idType(generatorInfoConfig.getIdType()).enableLombok()
				// mapper 策略配置
				.mapperBuilder().enableBaseResultMap().enableBaseColumnList()
				// service 策略配置
				.serviceBuilder().formatServiceFileName("%sService").formatServiceImplFileName("%sServiceImpl")
				// controller 策略配置
				.controllerBuilder().enableRestStyle().formatFileName("%sController").build();
	}

}
