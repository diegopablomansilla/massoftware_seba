package com.massoftware.windows.tiposRetenciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.massoftware.windows.EliminarDialog;
import com.massoftware.windows.LogAndNotification;
import com.massoftware.windows.UtilUI;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.Validatable;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.sort.SortOrder;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.event.ShortcutListener;
import com.vaadin.event.SortEvent;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;



public class WTiposRetenciones extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------

	private BeanItem<TiposRetencionesFiltro> filterBI;
	private BeanItemContainer<TiposRetenciones> itemsBIC;

	// -------------------------------------------------------------

	protected int limit = 15;
	protected int offset = 0;

	// -------------------------------------------------------------

	public Grid itemsGRD;
	private Button prevPageBTN;
	private Button nextPageBTN;
	private Button agregarBTN;
	private Button modificarBTN;
	private Button eliminarBTN;

	// -------------------------------------------------------------

	private HorizontalLayout codigoTXTHL;
	private HorizontalLayout descripcionTXTHL;
	private OptionGroup numeroEstadoOG;

	// -------------------------------------------------------------


	public WTiposRetenciones() {
		super();
		init(null);

	}

	
	public WTiposRetenciones(Integer numero) {
		super();
		init(numero);
	}
	
	
	
	@SuppressWarnings({ "serial"})
	public void init(Integer numero) {

		try {

			buildContainersItems();

			UtilUI.confWinList(this, "Tipos retenciones");

			VerticalLayout content = UtilUI.buildWinContentVertical();

			// =======================================================
			// -------------------------------------------------------
			// FILTROS

			HorizontalLayout filaFiltroHL = new HorizontalLayout();
			filaFiltroHL.setSpacing(true);

			// -----------

			codigoTXTHL = UtilUI.buildTXTHLInteger(filterBI, "tipoRetencion",
					"Código", false, 5, -1, 3, false, false, null, false,
					UtilUI.EQUALS, 0, 255);

			TextField codigoTXT = (TextField) codigoTXTHL.getComponent(0);
			
			codigoTXT.addTextChangeListener(new TextChangeListener() {
				public void textChange(TextChangeEvent event) {
					try {
						codigoTXT.setValue(event.getText());
						loadDataResetPaged();
					} catch (Exception e) {
						LogAndNotification.print(e);
					}
				}

			});

			Button codigoBTN = (Button) codigoTXTHL.getComponent(1);

			codigoBTN.addClickListener(e -> {
				this.loadDataResetPaged();
			});

			// -----------

			descripcionTXTHL = UtilUI.buildTXTHL(filterBI, "nombre", "Descripción",
					false, 20, -1, 35, false, false, null, false,
					UtilUI.CONTAINS_WORDS_AND);

			TextField descripcionTXT = (TextField) descripcionTXTHL.getComponent(0);

			descripcionTXT.addTextChangeListener(new TextChangeListener() {
				public void textChange(TextChangeEvent event) {
					try {
						descripcionTXT.setValue(event.getText());
						loadDataResetPaged();
					} catch (Exception e) {
						LogAndNotification.print(e);
					}
				}

			});

			Button descripcionBTN = (Button) descripcionTXTHL.getComponent(1);

			descripcionBTN.addClickListener(e -> {
				this.loadDataResetPaged();
			});

			// -----------

			
			numeroEstadoOG = UtilUI.buildBooleanOG(filterBI, "gananciaIvaIngBruto",null, false, false, new String[] { 
							"Ganancias", "I.V.A.", "Ing. Bruto", "Todos" }, new Integer[] {0, 1, 2, 3 }, true, 0);
			
			numeroEstadoOG.addValueChangeListener(new ValueChangeListener() {

				@Override
				public void valueChange(
						com.vaadin.data.Property.ValueChangeEvent event) {
					try {
						loadDataResetPaged();
					} catch (Exception e) {
						LogAndNotification.print(e);
					}
				}
			});

			
			
			// -----------
			
			
			
			Button buscarBTN = UtilUI.buildButtonBuscar();
			buscarBTN.addClickListener(e -> {
				loadData();
			});

			
			
			
			
			
			filaFiltroHL.addComponents(numeroEstadoOG,buscarBTN);

			filaFiltroHL.setComponentAlignment(buscarBTN,Alignment.MIDDLE_RIGHT);

			// =======================================================
			// -------------------------------------------------------
			// GRILLA

			itemsGRD = UtilUI.buildGrid();
			itemsGRD.setWidth("490px");


			itemsGRD.setColumns(new Object[] { "tipoRetencion", "nombre", "formato" });

			UtilUI.confColumn(itemsGRD.getColumn("tipoRetencion"), "Número", true,70);
			UtilUI.confColumn(itemsGRD.getColumn("nombre"), "Descripción", true, 250);
			UtilUI.confColumn(itemsGRD.getColumn("formato"), "Formato", true, 150);

			
			itemsGRD.setContainerDataSource(itemsBIC);

			// .......

			// SI UNA COLUMNA ES DE TIPO BOOLEAN HACER LO QUE SIGUE
//			 itemsGRD.getColumn("proyectoActivo").setRenderer(new HtmlRenderer(),
//			 new StringToBooleanConverter(FontAwesome.CHECK_SQUARE_O.getHtml(), FontAwesome.SQUARE_O.getHtml()));

			// SI UNA COLUMNA ES DE TIPO DATE HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(new SimpleDateFormat("dd/MM/yyyy")));

			// SI UNA COLUMNA ES DE TIPO TIMESTAMP HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(
			// new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")));

//			itemsGRD.getColumn("nombreTipo").setRenderer(new HtmlRenderer(),
//					new Converter<String, String>() {
//						@Override
//						public String convertToModel(String value,
//								Class<? extends String> targetType,
//								Locale locale)
//								throws Converter.ConversionException {
//							return "not implemented";
//						}
//
//						@Override
//						public String convertToPresentation(String value,
//								Class<? extends String> targetType,Locale locale)
//								throws Converter.ConversionException {
//
//							if (value != null && value.trim().equalsIgnoreCase("Centro de Costo")) {
//								return "<font color='blue'>" + value + "</font>";
//								
//							} else if (value != null && value.trim().equalsIgnoreCase("Proyecto")) {
//								return "<font color='red'>" + value + "</font>";
//								
//							} else {
//								return value;
//							}
//
//						}
//
//						@Override
//						public Class<String> getModelType() {
//							return String.class;
//						}
//
//						@Override
//						public Class<String> getPresentationType() {
//							return String.class;
//						}
//					});
			
			// .......

			List<SortOrder> order = new ArrayList<SortOrder>();

			order.add(new SortOrder("tipoRetencion", SortDirection.ASCENDING));

			itemsGRD.setSortOrder(order);

			HorizontalLayout filaBotoneraPagedHL = new HorizontalLayout();
			filaBotoneraPagedHL.setSpacing(true);

			prevPageBTN = UtilUI.buildButtonPrev(limit, offset);
			prevPageBTN.addClickListener(e -> {
				prevPageBTNClick();
			});

			nextPageBTN = UtilUI.buildButtonNext(limit, offset);
			nextPageBTN.addClickListener(e -> {
				nextPageBTNClick();
			});

			filaBotoneraPagedHL.addComponents(prevPageBTN, nextPageBTN);

			// =======================================================
			// -------------------------------------------------------
			// BOTONERA 1

			HorizontalLayout filaBotoneraHL = new HorizontalLayout();
			filaBotoneraHL.setSpacing(true);

			agregarBTN = UtilUI.buildButtonAgregar();
			agregarBTN.addClickListener(e -> {
				agregarBTNClick();
			});
			modificarBTN = UtilUI.buildButtonModificar();
			modificarBTN.addClickListener(e -> {
				modificarBTNClick();
			});

			filaBotoneraHL.addComponents(agregarBTN, modificarBTN);

			// -------------------------------------------------------
			// BOTONERA 2

			HorizontalLayout filaBotonera2HL = new HorizontalLayout();
			filaBotonera2HL.setSpacing(true);

			eliminarBTN = UtilUI.buildButtonEliminar();
			eliminarBTN.addClickListener(e -> {
				eliminarBTNClick();
			});

			filaBotonera2HL.addComponents(eliminarBTN);

			// -------------------------------------------------------

			content.addComponents(filaFiltroHL,itemsGRD, filaBotoneraPagedHL, filaBotoneraHL, filaBotonera2HL);

			content.setComponentAlignment(filaFiltroHL, Alignment.MIDDLE_LEFT);
			content.setComponentAlignment(filaBotoneraPagedHL, Alignment.MIDDLE_RIGHT);
			content.setComponentAlignment(filaBotoneraHL, Alignment.MIDDLE_LEFT);
			content.setComponentAlignment(filaBotonera2HL, Alignment.MIDDLE_RIGHT);

			this.setContent(content);

			// =======================================================
			// -------------------------------------------------------
			// KEY EVENTs

			this.addShortcutListener(new ShortcutListener("ENTER",
					KeyCode.ENTER, new int[] {}) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					if (target.equals(itemsGRD)) {
						modificarBTNClick();
					}

				}
			});

			// --------------------------------------------------

			this.addShortcutListener(new ShortcutListener("CTRL+A", KeyCode.A,
					new int[] { ModifierKey.CTRL }) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					agregarBTNClick();
				}
			});
			// --------------------------------------------------

			this.addShortcutListener(new ShortcutListener("CTRL+M", KeyCode.M,
					new int[] { ModifierKey.CTRL }) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					modificarBTNClick();
				}
			});

			// --------------------------------------------------

			this.addShortcutListener(new ShortcutListener("CTRL+B", KeyCode.B,
					new int[] { ModifierKey.CTRL }) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					loadData();
				}
			});

			// =======================================================
			// -------------------------------------------------------

			itemsGRD.addSortListener(e -> {
				sort(e);
			});

			// =======================================================
			// -------------------------------------------------------

			loadData();

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
		
		
		
		
		
	}
	
	
	
	
	
	// =================================================================================

	private void buildContainersItems() throws Exception {

		filterBI = new BeanItem<TiposRetencionesFiltro>(new TiposRetencionesFiltro());
		itemsBIC = new BeanItemContainer<TiposRetenciones>(TiposRetenciones.class, new ArrayList<TiposRetenciones>());
	}

	// =================================================================================

	private void nextPageBTNClick() {
		offset = offset + limit;
		prevPageBTN.setEnabled(offset > 0);
		loadData();
		if (this.itemsBIC.size() <= 0) {
			prevPageBTNClick();
		}
	}

	private void prevPageBTNClick() {
		offset = offset - limit;
		if (offset < 0) {
			offset = 0;
		}
		prevPageBTN.setEnabled(offset > 0);
		loadData();
	}

	protected void sort(SortEvent sortEvent) {
		try {

			if (itemsGRD.getSortOrder().size() == 1) {
				loadDataResetPaged();
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

	}

	private void eliminarBTNClick() {
		try {

			if (itemsGRD.getSelectedRow() != null) {

				getUI().addWindow(
						new EliminarDialog(
								itemsGRD.getSelectedRow().toString(),
								new EliminarDialog.Callback() {
									public void onDialogResult(boolean yes) {

										try {
											if (yes) {
												if (itemsGRD.getSelectedRow() != null) {

													TiposRetenciones item = (TiposRetenciones) itemsGRD
															.getSelectedRow();

													deleteItem(item);

													LogAndNotification
															.printSuccessOk("Se eliminó con éxito el ítem "
																	+ item);

													loadData();
												}
											}
										} catch (Exception e) {
											LogAndNotification.print(e);
										}

									}
								}));
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	protected void agregarBTNClick() {
		try {

			itemsGRD.select(null);
			Window window = new Window("Agregar ítem");
			window.setModal(true);
			window.center();
			window.setWidth("400px");
			window.setHeight("300px");
			getUI().addWindow(window);

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	private void modificarBTNClick() {
		try {

			if (itemsGRD.getSelectedRow() != null) {

				TiposRetenciones item = (TiposRetenciones) itemsGRD.getSelectedRow();
				item.getTipoRetencion();

				Window window = new Window("Modificar ítem " + item);
				window.setModal(true);
				window.center();
				window.setWidth("400px");
				window.setHeight("300px");
				getUI().addWindow(window);
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// =================================================================================

	private void loadDataResetPaged() {
		this.offset = 0;
		loadData();
	}

	private void loadData() {
		try {

			((Validatable) codigoTXTHL.getComponent(0)).validate();
			((Validatable) descripcionTXTHL.getComponent(0)).validate();

			List<TiposRetenciones> items = queryData();

			itemsBIC.removeAllItems();

			for (TiposRetenciones item : items) {
				itemsBIC.addBean(item);
			}

			boolean enabled = itemsBIC.size() > 0;

			itemsGRD.setEnabled(enabled);
			modificarBTN.setEnabled(enabled);
			eliminarBTN.setEnabled(enabled);

			nextPageBTN.setEnabled(itemsBIC.size() > 0 && itemsBIC.size() >= limit);

			prevPageBTN.setEnabled(offset >= limit);

		} catch (InvalidValueException e) {
			LogAndNotification.print(e);
		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// =================================================================================
	// SECCION PARA CONSULTAS A LA BASE DE DATOS


	// metodo que realiza la consulta a la base de datos
	private List<TiposRetenciones> queryData() {
		try {

			System.out.println("Los filtros son "
					+ this.filterBI.getBean().toString());

			// Notification.show("Los filtros son "
			// + this.filterBI.getBean().toString());

			Map<String, Boolean> orderBy = new HashMap<String, Boolean>();

			for (SortOrder sortOrder : itemsGRD.getSortOrder()) {
				orderBy.put(sortOrder.getPropertyId().toString(), sortOrder
						.getDirection().toString().equals("ASCENDING"));
				System.err.println(sortOrder.getPropertyId() + " "
						+ sortOrder.getDirection());
			}

			List<TiposRetenciones> items = mockData(limit, offset,
					this.filterBI.getBean());

			return items;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<TiposRetenciones>();
	}

	// metodo que realiza el delete en la base de datos
	private void deleteItem(TiposRetenciones item) {
		try {

			for (int i = 0; i < itemsMock.size(); i++) {
				if (itemsMock.get(i).getTipoRetencion().equals(item.getTipoRetencion())) {
					itemsMock.remove(i);
					return;
				}
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// =================================================================================
	// SECCION SOLO PARA FINES DE MOCKUP

	List<TiposRetenciones> itemsMock = new ArrayList<TiposRetenciones>();

	private List<TiposRetenciones> mockData(int limit, int offset, TiposRetencionesFiltro filtro) {

		if (itemsMock.size() == 0) {

			for (int i = 0; i < 500; i++) {

				TiposRetenciones item = new TiposRetenciones();

				item.setTipoRetencion(i);
				item.setNombre("Descripción "+ i);
				item.setFormato("Formato "+ i);
				item.setGananciaIvaIngBruto(new Random().nextInt(3));
				

				

				itemsMock.add(item);
			}
		}

		ArrayList<TiposRetenciones> arrayList = new ArrayList<TiposRetenciones>();

		for (TiposRetenciones item : itemsMock) {


//			boolean passesFilterNumero = (filtro.getNumero() == null || item
//					.getNumero().equals(filtro.getNumero()));
//
//			boolean passesFilterNombre = (filtro.getNombre() == null || item
//					.getNombre().toLowerCase()
//					.contains(filtro.getNombre().toLowerCase()));
			
			boolean passesFilterNumeroEstado = (filtro.getGananciaIvaIngBruto() == null
					|| filtro.getGananciaIvaIngBruto() == 3 || item.getGananciaIvaIngBruto()
					.equals(filtro.getGananciaIvaIngBruto()));
			
			if ( passesFilterNumeroEstado ) {
				arrayList.add(item);
			}
		}

		int end = offset + limit;
		if (end > arrayList.size()) {
			return arrayList.subList(0, arrayList.size());
		}

		return arrayList.subList(offset, end);
	}


	// =================================================================================

} // END CLASS
