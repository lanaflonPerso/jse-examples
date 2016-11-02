package core.dynamicquery;

import java.io.Serializable;

/**
 * Contains the properties to build dynamic jpql/native query.
 *
 * @author ehimnay
 */
public class FLSQueryBuilder implements Serializable {

	private static final long serialVersionUID = 1292698055339372912L;

	private String field;

	private String operator;

	private String placeHolder;

	private Object value;

	public FLSQueryBuilder(final String field, final String operator, final String placeHolder, final Object value) {
		this.field = field;
		this.operator = operator;
		this.placeHolder = placeHolder;
		this.value = value;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(final String field) {
		this.field = field;
	}

	/**
	 * @return the operators
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(final String operator) {
		this.operator = operator;
	}

	/**
	 * @return the placeHolder
	 */
	public String getPlaceHolder() {
		return placeHolder;
	}

	/**
	 * @param placeHolder
	 *            the placeHolder to set
	 */
	public void setPlaceHolder(final String placeHolder) {
		this.placeHolder = placeHolder;
	}

	/**
	 * @return the values
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(final Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return new StringBuffer().append("FLSQueryBuilder [field=" + field).append(", operator=" + operator)
				.append(", value=" + value + "]").toString();
	}

}