package com.demain.generator.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成器配置信息
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class GeneratorInfoConfig {

	public GeneratorInfoConfig() {
	}

	/**
	 * 作者
	 */
	private String author = "xxx";

	/**
	 * 数据库地址 host 替换为实际的数据库地址 xxx 替换为实际的数据库名称
	 */
	private String dbUrl = "jdbc:mysql://host:3306/xxx?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8";

	/**
	 * 数据库用户名
	 */
	private String username = "root";

	/**
	 * 数据库密码
	 */
	private String password = "root";

	/**
	 * 包名
	 */
	private String packageName = "com.xxx.xxx";

	/**
	 * 模块名
	 */
	private String moduleName = "";

	/**
	 * 生成文件的输出目录 【 windows:D:// linux or mac:/tmp 】
	 */
	private String outputDir = System.getProperty("os.name").toLowerCase().contains("windows") ? "D://" : "/tmp";

	/**
	 * 生成Mapper文件的输出目录
	 */
	private String mapperDir = outputDir + packageName.replace(".", "/") + "/mapper";

	/**
	 * 生成的表名前缀
	 */
	private final List<String> tablePrefix = new ArrayList<>();

	/**
	 * 包含的表
	 */
	private final List<String> includeTable = new ArrayList<>();

	/**
	 * 不包含的表
	 */
	private final List<String> excludeTable = new ArrayList<>();

	/**
	 * 模板引擎
	 */
	private AbstractTemplateEngine templateEngine;

	/**
	 * 开启swagger模式
	 */
	private boolean enableSwagger = false;

	/**
	 * 开启lombok模型
	 */
	private boolean enableLombok = false;

	/**
	 * 主键的ID类型
	 */
	private IdType idType;

	public String getAuthor() {
		return author;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public String getOutputDir() {
		return outputDir;
	}

	public String getMapperDir() {
		return mapperDir;
	}

	public List<String> getTablePrefix() {
		return tablePrefix;
	}

	public List<String> getIncludeTable() {
		return includeTable;
	}

	public List<String> getExcludeTable() {
		return excludeTable;
	}

	public AbstractTemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	public boolean isEnableLombok() {
		return enableLombok;
	}

	public boolean isEnableSwagger() {
		return enableSwagger;
	}

	public IdType getIdType() {
		return idType;
	}

	public void validate() {
		boolean isInclude = this.getIncludeTable().size() > 0;
		boolean isExclude = this.getExcludeTable().size() > 0;
		if (isInclude && isExclude) {
			throw new IllegalArgumentException("<strategy> 标签中 <include> 与 <exclude> 只能配置一项！");
		}
	}

	public static class Builder implements IConfigBuilder<GeneratorInfoConfig> {

		private final GeneratorInfoConfig generatorInfoConfig;

		public Builder() {
			this.generatorInfoConfig = new GeneratorInfoConfig();
		}

		/**
		 * 作者
		 */
		public Builder author(String author) {
			this.generatorInfoConfig.author = author;
			return this;
		}

		/**
		 * 数据库地址
		 */
		public Builder dbUrl(String dbUrl) {
			this.generatorInfoConfig.dbUrl = dbUrl;
			return this;
		}

		/**
		 * 数据库用户名
		 */
		public Builder username(String username) {
			this.generatorInfoConfig.username = username;
			return this;
		}

		/**
		 * 数据库密码
		 */
		public Builder password(String password) {
			this.generatorInfoConfig.password = password;
			return this;
		}

		/**
		 * 包名
		 */
		public Builder packageName(String packageName) {
			this.generatorInfoConfig.packageName = packageName;
			return this;
		}

		/**
		 * 模块名
		 */
		public Builder moduleName(String moduleName) {
			this.generatorInfoConfig.moduleName = moduleName;
			return this;
		}

		/**
		 * 生成文件的输出目录 【 windows:D:// linux or mac:/tmp 】
		 */
		public Builder outputDir(String outputdir) {
			this.generatorInfoConfig.outputDir = outputdir;
			return this;
		}

		/**
		 * 生成Mapper文件的输出目录
		 */
		public Builder mapperDir(String mapperDir) {
			this.generatorInfoConfig.mapperDir = mapperDir;
			return this;
		}

		/**
		 * 生成的表名前缀
		 */
		public Builder tablePrefix(String... tablePrefix) {
			return tablePrefix(Arrays.asList(tablePrefix));
		}

		public Builder tablePrefix(List<String> tablePrefixList) {
			this.generatorInfoConfig.tablePrefix.addAll(tablePrefixList);
			return this;
		}

		/**
		 * 包含的表
		 */
		public Builder includeTable(String... includeTable) {
			return includeTable(Arrays.asList(includeTable));
		}

		public Builder includeTable(List<String> includeTable) {
			this.generatorInfoConfig.includeTable.addAll(includeTable);
			return this;
		}

		/**
		 * 不包含的表
		 */
		public Builder excludeTable(String... excludeTable) {
			return excludeTable(Arrays.asList(excludeTable));
		}

		public Builder excludeTable(List<String> excludeTable) {
			this.generatorInfoConfig.excludeTable.addAll(excludeTable);
			return this;
		}

		/**
		 * 模板引擎
		 */
		public Builder templateEngine(AbstractTemplateEngine templateEngine) {
			this.generatorInfoConfig.templateEngine = templateEngine;
			return this;
		}

		/**
		 * 主键的ID类型
		 */
		public Builder idType(IdType idType) {
			this.generatorInfoConfig.idType = idType;
			return this;
		}

		/**
		 * 开启lombok模型
		 */
		public Builder enableLombok() {
			this.generatorInfoConfig.enableLombok = true;
			return this;
		}

		/**
		 * 开启swagger模式
		 */
		public Builder enableSwagger() {
			this.generatorInfoConfig.enableSwagger = true;
			return this;
		}

		@Override
		public GeneratorInfoConfig build() {
			this.generatorInfoConfig.validate();
			return this.generatorInfoConfig;
		}

	}

}
