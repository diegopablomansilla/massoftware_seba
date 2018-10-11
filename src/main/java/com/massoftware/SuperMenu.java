package com.massoftware;

import com.massoftware.windows.alicuotas.WAlicuotas;
import com.massoftware.windows.cargas.WCargas;
import com.massoftware.windows.condicionesDeVentas.WCondicionesDeVentas;
import com.massoftware.windows.cuidades.WCiudades;
import com.massoftware.windows.depositos.WDepositos;
import com.massoftware.windows.motBloqueosClie.WMotBloqueosClie;
import com.massoftware.windows.motivosComentarios.WMotivosComentarios;
import com.massoftware.windows.motivosNotasDeCredito.WMotivosNotasDeCreditos;
import com.massoftware.windows.paises.WPaises;
import com.massoftware.windows.provincias.WProvincias;
import com.massoftware.windows.subCtaCte.WSubCtaCte;
import com.massoftware.windows.sucursales.WSucursales;
import com.massoftware.windows.talonarios.WTalonarios;
import com.massoftware.windows.tiposDeClientes.WTiposDeClientes;
import com.massoftware.windows.tiposDocumentosAfip.WTiposDocumentosAfip;
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
		a1.addItem("Sub ctas-ctes", openSubCtaCteCmd());
		a1.addItem("Condiciones de ventas", openCondDeVentasCmd());
		a1.addItem("Bloqueo de clientes", openBloqClientesCmd());
		a1.addItem("Alícuotas", openAlicuotasCmd());
		a1.addItem("Cargas", openCargasCmd());
		a1.addItem("Sucursales", openSucursalesCmd());
		a1.addItem("Tipos documentos AFIP", openTiposDocAfipCmd());
		a1.addItem("Motivos comentarios", openMotivosComentariosCmd());
		a1.addItem("Motivos notas de créditos", openMotivosNotasCreditoCmd());
		a1.addItem("Depositos", openDepositosCmd());
		a1.addItem("Talonarios", openTalonariosCmd());
		a1.addItem("Ciudades", openCiudadesCmd());
		a1.addItem("Tipos de clientes", openTiposDeClientesCmd());
		
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
	
	
	protected Command openBloqClientesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WMotBloqueosClie();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openAlicuotasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WAlicuotas();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openCargasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCargas();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openSucursalesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WSucursales();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openTiposDocAfipCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WTiposDocumentosAfip();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openMotivosComentariosCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WMotivosComentarios();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openMotivosNotasCreditoCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WMotivosNotasDeCreditos();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openDepositosCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WDepositos();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openTalonariosCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WTalonarios();
				getUI().addWindow(window);
			}
		};
	}
	
	
	protected Command openCiudadesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCiudades();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openTiposDeClientesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WTiposDeClientes();
				getUI().addWindow(window);
			}
		};
	}
	
	
}
