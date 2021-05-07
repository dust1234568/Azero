package com.dust.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {

	private static SqlSessionFactory sqlSessionFactory;

	// static 초기화 : 해당 실행될때 딱 한번 초기화 시켜줌
	static {
		String resource = "com/dust/mybatis/Configuration.xml";

		try {

			Reader reader = Resources.getResourceAsReader(resource);

			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSesseion() {
		return sqlSessionFactory;
	}

}
