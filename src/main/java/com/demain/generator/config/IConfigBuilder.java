package com.demain.generator.config;

/**
 * 配置构建接口 Type parameters: <T>
 *
 * @author demain_lee
 * @since 0.0.1
 */
public interface IConfigBuilder<T> {

	/**
	 * 返回 T
	 * @return T
	 */
	T build();

}
