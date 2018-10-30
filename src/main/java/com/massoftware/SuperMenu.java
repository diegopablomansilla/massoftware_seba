package com.massoftware;

import com.massoftware.windows.alicuotas.WAlicuotas;
import com.massoftware.windows.bonificacionGrupos.WBonificacionGrupos;
import com.massoftware.windows.bonificacionProductos.WBonificacionProductos;
import com.massoftware.windows.cargas.WCargas;
import com.massoftware.windows.centrosDeCosto.WCentrosDeCosto;
import com.massoftware.windows.claseComprobante.WClaseComprobante;
import com.massoftware.windows.codigosConvenioMultilateral.WCodigosConvenioMultilateral;
import com.massoftware.windows.conceptosRetenciones.WConceptosRetenciones;
import com.massoftware.windows.condicionesDeVentas.WCondicionesDeVentas;
import com.massoftware.windows.conveniosElaboracion.WConveniosDeElaboracion;
import com.massoftware.windows.cuidades.WCiudades;
import com.massoftware.windows.depositos.WDepositos;
import com.massoftware.windows.marcas.WMarcas;
import com.massoftware.windows.motBloqueosClie.WMotBloqueosClie;
import com.massoftware.windows.motivosComentarios.WMotivosComentarios;
import com.massoftware.windows.motivosNotasDeCredito.WMotivosNotasDeCreditos;
import com.massoftware.windows.paises.WPaises;
import com.massoftware.windows.perfilesDeFacturacion.WPerfilesDeFacturacion;
import com.massoftware.windows.provincias.WProvincias;
import com.massoftware.windows.rubrosProveedores.WRubrosProveedores;
import com.massoftware.windows.subCtaCte.WSubCtaCte;
import com.massoftware.windows.subCtaCteProv.WSubCtaCteProv;
import com.massoftware.windows.sucursales.WSucursales;
import com.massoftware.windows.talonarios.WTalonarios;
import com.massoftware.windows.tiposDeClientes.WTiposDeClientes;
import com.massoftware.windows.tiposDocumentosAfip.WTiposDocumentosAfip;
import com.massoftware.windows.tiposRetenciones.WTiposRetenciones;
import com.massoftware.windows.transportes.WTransportes;
import com.massoftware.windows.unidadesDeMedida.WUnidadesDeMedida;
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
		a1.addItem("Condiciones de ventas", openCondDeVentasCmd("Ventas"));
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
		a1.addItem("Marcas", openMarcasCmd());
		a1.addItem("Unidades de medida", openUnidadesDeMedidaCmd());
		a1.addItem("Códigos convenio multilateral", openCodConvMultilateralCmd());
		a1.addItem("Rubros proveedores", openRubrosProveedoresCmd());
		a1.addItem("Sub cuenta corriente", openSubCtaCteProvCmd());
		a1.addItem("Transportes", openTransporteCmd());
		a1.addItem("Condiciones de compras", openCondDeVentasCmd("Compras"));
		a1.addItem("Centros de costo - Proyectos", openCentroCostoProyectoCmd());
		a1.addItem("Tipos retenciones", openTiposRetencionesCmd());
		a1.addItem("Clase comprobantes", openClaseComprobantesCmd());
		a1.addItem("Perfiles de facturación", openPerfilesDeFacturacionCmd());
		a1.addItem("Convenios de elaboración", openConvenioDeElaboracionCmd());
		a1.addItem("Conceptos retención", openConceptosRetencionCmd());
		a1.addItem("Bonificación Grupos", openBonifGruposCmd());
		a1.addItem("Bonificación Productos", openBonifProductoCmd());
		
		return menubar;
	}

	
	
	protected Command openBonifProductoCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WBonificacionProductos();
				getUI().addWindow(window);
			}
		};
	}	
		
	protected Command openBonifGruposCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WBonificacionGrupos();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openConceptosRetencionCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WConceptosRetenciones();
				getUI().addWindow(window);
			}
		};
	}
	
	
	protected Command openConvenioDeElaboracionCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WConveniosDeElaboracion();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openPerfilesDeFacturacionCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WPerfilesDeFacturacion();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openClaseComprobantesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WClaseComprobante();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openTiposRetencionesCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WTiposRetenciones();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openCentroCostoProyectoCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCentrosDeCosto();
				getUI().addWindow(window);
			}
		};
	}
	
	
	protected Command openTransporteCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WTransportes();
				getUI().addWindow(window);
			}
		};
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
	
	
	protected Command openCondDeVentasCmd(String cod) {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCondicionesDeVentas(cod);
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
	
	protected Command openMarcasCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WMarcas();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openUnidadesDeMedidaCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WUnidadesDeMedida();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openCodConvMultilateralCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WCodigosConvenioMultilateral();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openRubrosProveedoresCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WRubrosProveedores();
				getUI().addWindow(window);
			}
		};
	}
	
	protected Command openSubCtaCteProvCmd() {

		return new Command() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 4645387020070455569L;

			@Override
			public void menuSelected(MenuItem selectedItem) {

				Window window = new WSubCtaCteProv();
				getUI().addWindow(window);
			}
		};
	}
	
	
}
