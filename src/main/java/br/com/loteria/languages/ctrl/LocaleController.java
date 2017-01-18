package br.com.loteria.languages.ctrl;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name = "localeController")
@SessionScoped
public class LocaleController {

	private Locale currentLocale = new Locale("pt", "BR");

	public LocaleController() {
		// TODO Auto-generated constructor stub
	}

	public void englishLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = Locale.US;
		viewRoot.setLocale(currentLocale);
	}

	public void portugueseLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = new Locale("pt", "BR");
		viewRoot.setLocale(currentLocale);
	}
	
	public void spanishLocale() {
		UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		currentLocale = new Locale("es", "ES");
		viewRoot.setLocale(currentLocale);
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

}
