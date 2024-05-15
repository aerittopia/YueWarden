package com.aeritt.yue.warden.listener;

import com.aeritt.yue.api.event.EventManager;
import com.aeritt.yue.warden.listener.role.RoleAddedListener;
import com.aeritt.yue.warden.listener.role.RoleRemovedListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ListenerRegistrar {
	private final ApplicationContext ctx;
	private final EventManager eventManager;

	@Autowired
	public ListenerRegistrar(ApplicationContext ctx, EventManager eventManager) {
		this.ctx = ctx;
		this.eventManager = eventManager;
	}

	public void registerListeners() {
	    Stream.of(RoleAddedListener.class, RoleRemovedListener.class)
			    				.map(ctx::getBean)
			    				.forEach(eventManager::registerListener);
	}
}
