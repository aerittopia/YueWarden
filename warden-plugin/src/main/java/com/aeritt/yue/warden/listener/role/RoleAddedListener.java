package com.aeritt.yue.warden.listener.role;

import com.aeritt.yue.api.event.EventListener;
import com.aeritt.yue.api.event.internal.role.RoleAddedEvent;
import com.aeritt.yue.warden.api.type.RoleCause;
import com.aeritt.yue.warden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleAddedListener implements EventListener<RoleAddedEvent> {
	private final RoleService roleService;

	@Autowired
	public RoleAddedListener(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void onEvent(RoleAddedEvent event) {
		roleService.addRole(event.getUserProfile(), event.getRoleId(), RoleCause.DATABASE_ENTRY);
	}
}
