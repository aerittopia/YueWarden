package com.aeritt.yue.warden;

import com.aeritt.yue.api.YuePlugin;
import com.aeritt.yue.warden.listener.ListenerRegistrar;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WardenPlugin extends YuePlugin {
	public WardenPlugin(PluginWrapper wrapper) {
		super(wrapper);
	}

	@Override
	public void onLoad() {

	}

	@Override
	public void onEnable() {
		getApplicationContext().getBean(ListenerRegistrar.class).registerListeners();
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
		ApplicationContext parentContext = ((SpringPluginManager) getWrapper().getPluginManager()).getApplicationContext();

		AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
		childContext.setClassLoader(getWrapper().getPluginClassLoader());
		childContext.registerBean(PluginWrapper.class, this::getWrapper);
		childContext.register(WardenConfiguration.class);
		childContext.scan("com.aeritt.yue.warden");
		childContext.setParent(parentContext);
		childContext.refresh();

		this.applicationContext = childContext;

		return childContext;
	}
}