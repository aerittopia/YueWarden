package com.aeritt.yue.warden;

import org.pf4j.PluginWrapper;

public class WardenContext {
	private final PluginWrapper wrapper;

	public WardenContext(PluginWrapper wrapper) {
		this.wrapper = wrapper;
	}

	public PluginWrapper getWrapper() {
		return wrapper;
	}
}
