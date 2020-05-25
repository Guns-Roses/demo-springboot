package com.springboot.demo.config.generator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.math.BigDecimal;
import java.sql.Types;

/**
 * *生成实体类字段 数字类型自定义
 *
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {

	public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
		FullyQualifiedJavaType answer;
		JdbcTypeInformation jdbcTypeInformation = typeMap.get(introspectedColumn.getJdbcType());
		if (jdbcTypeInformation != null) {
			switch (introspectedColumn.getJdbcType()) {
			case Types.DECIMAL:
			case Types.NUMERIC:
			case Types.INTEGER:
				// 如果包含小数点则转换成float
				if (introspectedColumn.getScale() > 0) {
					answer = new FullyQualifiedJavaType(BigDecimal.class.getName());
				} else {
					// 长度大于18位转为 BigDecimal else if 大于9 转为 Long 其他 Integer
					if (introspectedColumn.getLength() >= 18 || forceBigDecimals) {
						answer = new FullyQualifiedJavaType(BigDecimal.class.getName());
					} else if (introspectedColumn.getLength() >= 9) {
						answer = new FullyQualifiedJavaType(Long.class.getName());
					} else {
						answer = new FullyQualifiedJavaType(Integer.class.getName());
					}
				}
				break;

			default:
				answer = jdbcTypeInformation.getFullyQualifiedJavaType();
				break;
			}
		} else {
			answer = jdbcTypeInformation.getFullyQualifiedJavaType();
		}

		return answer;
	}
}
