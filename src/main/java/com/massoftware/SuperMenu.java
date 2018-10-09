package com.massoftware;

import com.massoftware.windows.condicionesDeVentas.WCondicionesDeVentas;
import com.massoftware.windows.paises.WPaises;
import com.massoftware.windows.provincias.WProvincias;
import com.massoftware.windows.subCtaCte.WSubCtaCte;
import com.massoftware.windows.zonas.WZonas;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class SuperMenu extends AbstractMenu {

	public SuperMenu() {
		super("Super menu");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4876972158479186088L;

	protected MenuBar getMenuBar() {

		MenuBar menubar = new MenuBar();
		menubar.setWidth("100%");
		menubar.addStyleName(ValoTheme.MENUBAR_BORDERLESS);

		final MenuBar.MenuItem a1 = menubar.addItem("Ventas-Archivo", null);

		a1.addItem("Países", openPaisesCmd());
		a1.addItem("Provincias", openProvinciasCmd());
		a1.addItem("Zonas", openZonasCmd());
		a1.addItem("Sub Ctas-Ctes", openSubCtaCteCmd());
		a1.addItem("Condiciones de Ventas", openCondDeVentasCmd());
		
		return menubar;
	}

	protected Command openPaisesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WPaises();
				getUI().addWindow(window);
			}
		};
	}

	protected Command openProvinciasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WProvincias();
				getUI().addWindow(window);
			}
		};
	}

	protected Command openZonasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WZonas();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openSubCtaCteCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WSubCtaCte();
				getUI().addWindow(window);
			}
		};
	}
	
	
	protected Command openCondDeVentasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCondicionesDeVentas();
				getUI().addWindow(window);
			}
		};
	}
	
	
	
	
}
