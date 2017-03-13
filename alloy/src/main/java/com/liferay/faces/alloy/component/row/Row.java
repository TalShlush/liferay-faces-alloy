/**
 * Copyright (c) 2000-2017 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.alloy.component.row;

import javax.el.ValueExpression;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;


/**
 * @author  Juan Gonzalez
 */
public class Row extends UIPanel {

	// Public Constants
	public static final String FLUID = "fluid";
	public static final String RENDERER_TYPE = "com.liferay.faces.alloy.component.row.internal.RowRenderer";

	// Private Constants
	private static final String CSS_CLASS = "cssClass";
	private static final String STYLE_CLASS = "styleClass";
	public static final String STYLE_CLASS_NAME = "alloy-row";

	// Private Data Members
	private String cssClass;
	private Boolean fluid;
	private String styleClass;

	public String getCssClass() {

		if (cssClass == null) {
			ValueExpression valueExpression = getValueExpression(CSS_CLASS);

			if (valueExpression != null) {
				cssClass = (String) valueExpression.getValue(FacesContext.getCurrentInstance().getELContext());
			}
		}

		return cssClass;
	}

	@Override
	public String getRendererType() {
		return RENDERER_TYPE;
	}

	public String getStyleClass() {

		if (styleClass == null) {
			ValueExpression valueExpression = getValueExpression(STYLE_CLASS);

			styleClass = "";

			if (valueExpression != null) {
				styleClass = (String) valueExpression.getValue(FacesContext.getCurrentInstance().getELContext());
			}

			styleClass = styleClass.concat(STYLE_CLASS_NAME);
		}

		return styleClass;
	}

	public Boolean isFluid() {

		if (fluid == null) {
			ValueExpression valueExpression = getValueExpression(FLUID);

			if (valueExpression != null) {
				fluid = (Boolean) valueExpression.getValue(FacesContext.getCurrentInstance().getELContext());
			}
			else {
				fluid = Boolean.TRUE;
			}
		}

		return fluid;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setFluid(Boolean fluid) {
		this.fluid = fluid;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}
}
