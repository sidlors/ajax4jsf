package com.sidlors.managed.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.apache.log4j.Logger;

public class NewBatchBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(NewBatchBean.class);
	private String name;
	private String description;

	public void init() {

	}

	public String viewNewBatch() {
		this.init();
		return "newBatch";
	}

	public String next() {

		return "";

	}

	public void validateBatchDescription(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		log.debug("Component" + component);
		HtmlInputTextarea textArea = (HtmlInputTextarea) component;
		String submitted = textArea.getSubmittedValue().toString();
		if (submitted.length() > 255) {
			textArea.setSubmittedValue(submitted.substring(0, 254));
			FacesMessage msg = new FacesMessage(
					"Solo se permiten 255 caracteres como maximo. Se trunca la entrada a dicha longitud.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
