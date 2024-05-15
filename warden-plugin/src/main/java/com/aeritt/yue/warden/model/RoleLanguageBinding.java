package com.aeritt.yue.warden.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoleLanguageBinding {
	private final String roleId;
	private final String languageCode;
}
