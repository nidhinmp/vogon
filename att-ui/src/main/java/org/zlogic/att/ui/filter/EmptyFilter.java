/*
 * Awesome Time Tracker project.
 * License TBD.
 * Author: Dmitry Zolotukhin <zlogic@gmail.com>
 */
package org.zlogic.att.ui.filter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.zlogic.att.ui.filter.ui.Filter;

/**
 * Empty filter (default value for new filters)
 *
 * @author Dmitry Zolotukhin <zlogic@gmail.com>
 */
public class EmptyFilter implements Filter<Void> {

	/**
	 * The filter type
	 */
	private FilterTypeFactory filterType;
	/**
	 * The filter value
	 */
	private ObjectProperty<Void> value = new SimpleObjectProperty<>();

	/**
	 * Constructs an EmptyFilter
	 *
	 * @param filterType the filter type (creator of this object)
	 */
	public EmptyFilter(FilterTypeFactory filterType) {
		this.filterType = filterType;
	}

	@Override
	public FilterTypeFactory getType() {
		return filterType;
	}

	@Override
	public ObjectProperty<Void> valueProperty() {
		return value;
	}
}
