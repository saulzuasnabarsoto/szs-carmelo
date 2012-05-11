/**
 *
 */
package webapp.saz.carmelo.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author ishaikovsky
 */
@ManagedBean(name = "themeBean")
@SessionScoped
public class ThemeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2399884208294434812L;
	private static final String SKIN_VIEW_PARAMETER = "theme";
	@ManagedProperty(value = "cupertino")
	private String theme;
	private List<String> themes;

	public ThemeBean() {
		themes = new ArrayList<String>();
		//themes.add("aristo");
		themes.add("black-tie");
		themes.add("blitzer");
		themes.add("bluesky");
		themes.add("casablanca");
		themes.add("cupertino");
		themes.add("dark-hive");
		themes.add("dot-luv");
		themes.add("eggplant");
		themes.add("excite-bike");
		themes.add("flick");
		themes.add("glass-x");
		themes.add("home");
		themes.add("hot-sneaks");
		themes.add("humanity");
		themes.add("le-frog");
		themes.add("midnight");
		themes.add("mint-choc");
		themes.add("overcast");
		themes.add("pepper-grinder");
		themes.add("redmond");
		themes.add("rocket");
		themes.add("sam");
		themes.add("smoothness");
		themes.add("south-street");
		themes.add("start");
		themes.add("sunny");
		themes.add("swanky-purse");
		themes.add("trontastic");
		themes.add("ui-darkness");
		themes.add("ui-lightness");
		themes.add("vader");
	}

	private String getViewParameter(String name) {
		FacesContext fc = FacesContext.getCurrentInstance();
		String param = (String) fc.getExternalContext()
				.getRequestParameterMap().get(name);
		if (param != null && param.trim().length() > 0) {
			return param;
		} else {
			return null;
		}
	}

	public String getTheme() {
		String currentTheme = getViewParameter(SKIN_VIEW_PARAMETER);
		if (currentTheme != null) {
			theme = currentTheme;
		}
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public List<String> getThemes() {
		return themes;
	}

}
