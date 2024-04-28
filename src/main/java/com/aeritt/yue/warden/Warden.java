package com.aeritt.yue.warden;

import com.aeritt.yue.api.YuePlugin;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Warden extends YuePlugin {
	private final WardenContext context;

	public Warden(PluginWrapper wrapper) {
		super(wrapper);

		this.context = new WardenContext(wrapper);
	}

	@Override
	public void onLoad() {

	}

	@Override
	public void onEnable() {

	}

	@Override
	public void onUnload() {

	}

	@Override
	public void onDisable() {

	}

	@Override
	public void onReload() {

	}

	@Override
	public ApplicationContext createApplicationContext() {
		ApplicationContext parentContext = ((SpringPluginManager) context.getWrapper().getPluginManager()).getApplicationContext();

		AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
		childContext.setClassLoader(context.getWrapper().getPluginClassLoader());
		childContext.registerBean(PluginWrapper.class, context.getWrapper());
		childContext.register(WardenConfiguration.class);
		childContext.scan("com.aeritt.yue.warden");
		childContext.setParent(parentContext);
		childContext.refresh();

		this.applicationContext = childContext;

		return childContext;
	}
}