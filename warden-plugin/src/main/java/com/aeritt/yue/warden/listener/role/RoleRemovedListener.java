package com.aeritt.yue.warden.listener.role;

import com.aeritt.yue.api.event.EventListener;
import com.aeritt.yue.api.event.internal.role.RoleRemovedEvent;
import com.aeritt.yue.warden.api.type.RoleCause;
import com.aeritt.yue.warden.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleRemovedListener implements EventListener<RoleRemovedEvent> {
	private final RoleService roleService;

	@Autowired
	public RoleRemovedListener(RoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public void onEvent(RoleRemovedEvent event) {
		roleService.removeRole(event.getUserProfile(), event.getRoleId(), RoleCause.DATABASE_ENTRY);
	}
}
