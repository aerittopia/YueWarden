package com.aeritt.yue.warden;

import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Files;
import java.nio.file.Path;

@Configuration
public class WardenConfiguration {
	private final ApplicationContext ctx;

	@Autowired
	public WardenConfiguration(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	@Bean
	public Path dataPath() {
		PluginWrapper pluginWrapper = ctx.getBean(PluginWrapper.class);
		Path dataPath = pluginWrapper.getPluginPath().getParent().resolve(pluginWrapper.getPluginId() + "/");

		try {
			Files.createDirectories(dataPath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataPath;
	}
}
