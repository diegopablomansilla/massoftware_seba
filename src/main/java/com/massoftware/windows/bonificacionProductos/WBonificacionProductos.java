package com.massoftware.windows.bonificacionProductos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.massoftware.windows.EliminarDialog;
import com.massoftware.windows.LogAndNotification;
import com.massoftware.windows.UtilUI;
import com.massoftware.windows.bonificacionGrupos.BonificacionGrupos;
import com.vaadin.data.Validatable;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.sort.SortOrder;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.event.ShortcutListener;
import com.vaadin.event.SortEvent;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WBonificacionProductos extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------

	private BeanItemContainer<BonificacionGrupos> itemsFiltroBIC;
	private BeanItem<BonificacionProductosFiltro> filterBI;
	private BeanItemContainer<BonificacionProductos> itemsBIC;

	// -------------------------------------------------------------

	protected int limit = 15;
	protected int offset = 0;
	
	protected int limitFiltro = limit;
	protected int offsetFiltro = 0;
	

	// -------------------------------------------------------------

	private Grid itemsGRD;
	private Button prevPageBTN;
	private Button nextPageBTN;
	private Button agregarBTN;
	private Button modificarBTN;
	private Button eliminarBTN;
	
	private Button prevPageFiltroBTN;
	private Button nextPageFiltroBTN;
	private Button agregarFiltroBTN;
	private Button modificarFiltroBTN;
	private Button eliminarFiltroBTN;
	// -------------------------------------------------------------

	private HorizontalLayout codigoTXTHL;
	private HorizontalLayout descripcionTXTHL;
	private Grid itemsFiltroGRD;

	// -------------------------------------------------------------

	@SuppressWarnings("serial")
	public WBonificacionProductos() {
		super();

		try {

			buildContainersItems();

			UtilUI.confWinList(this, "Bonificación grupos de productos");

			VerticalLayout content = UtilUI.buildWinContentVertical();

			// =======================================================
			// -------------------------------------------------------
			// FILTROS

			HorizontalLayout filaFiltroHL = new HorizontalLayout();
			filaFiltroHL.setSpacing(true);

			// -----------

			codigoTXTHL = UtilUI.buildTXTHLInteger(filterBI, "grupoBonif",
					"Grupo Bonificación", false, 5, -1, 3, false, false, null, false,
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

			descripcionTXTHL = UtilUI.buildTXTHL(filterBI, "descripcion", "Descripción",
					false, 20, -1, 25, false, false, null, false,
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

			Button buscarBTN = UtilUI.buildButtonBuscar();
			buscarBTN.addClickListener(e -> {
				loadData();
			});

			filaFiltroHL.addComponents(codigoTXTHL, descripcionTXTHL,buscarBTN);

			filaFiltroHL.setComponentAlignment(buscarBTN,Alignment.MIDDLE_RIGHT);

			
			
			// --------------
			
			HorizontalLayout grillas = new HorizontalLayout();
			grillas.setSpacing(true);

			VerticalLayout columna1VL = new VerticalLayout();
			columna1VL.setSpacing(true);

			VerticalLayout columna2VL = new VerticalLayout();
			columna2VL.setSpacing(true);

			grillas.addComponents(columna1VL, columna2VL);
			
			
			// -------------------------------------------------------
			// GRILLA FILTRO

			itemsFiltroGRD = UtilUI.buildGrid();
			itemsFiltroGRD.setWidth("270px");

			itemsFiltroGRD.setColumns(new Object[] { "grupoBonif", "descripcion" });

			UtilUI.confColumn(itemsFiltroGRD.getColumn("grupoBonif"), "Código",true, 50);
			UtilUI.confColumn(itemsFiltroGRD.getColumn("descripcion"), "Grupo de productos", true, 200);

			// Group headers by joining the cells
			HeaderRow groupingHeader = itemsFiltroGRD.prependHeaderRow();

			HeaderCell namesCellCobranza = groupingHeader.join(
					groupingHeader.getCell("grupoBonif"),
					groupingHeader.getCell("descripcion"));
			namesCellCobranza.setText("Filtrar por Grupo Bonificaciones");

			itemsFiltroGRD.setContainerDataSource(itemsFiltroBIC);

			List<SortOrder> orderFiltro = new ArrayList<SortOrder>();

			orderFiltro.add(new SortOrder("grupoBonif", SortDirection.ASCENDING));

			itemsFiltroGRD.setSortOrder(orderFiltro);

			HorizontalLayout filaBotoneraPagedFiltroHL = new HorizontalLayout();
			filaBotoneraPagedFiltroHL.setSpacing(true);

			prevPageFiltroBTN = UtilUI.buildButtonPrev(limitFiltro,offsetFiltro);
			prevPageFiltroBTN.addClickListener(e -> {
				prevPageFiltroBTNClick();
			});

			nextPageFiltroBTN = UtilUI.buildButtonNext(limitFiltro,offsetFiltro);
			nextPageFiltroBTN.addClickListener(e -> {
				nextPageFiltroBTNClick();
			});

			filaBotoneraPagedFiltroHL.addComponents(prevPageFiltroBTN,nextPageFiltroBTN);

			
			// =======================================================
			// -------------------------------------------------------
			// GRILLA

			itemsGRD = UtilUI.buildGrid();
			itemsGRD.setWidth("350px");


			itemsGRD.setColumns(new Object[] { "bonifProducto", "descripcion", "porcentaje"});

			UtilUI.confColumn(itemsGRD.getColumn("bonifProducto"), "Código", true,50);
			UtilUI.confColumn(itemsGRD.getColumn("descripcion"), "Descripción.", true, 200);
			UtilUI.confColumn(itemsGRD.getColumn("porcentaje"), "Porcentaje", true, 80);
			
			itemsGRD.setContainerDataSource(itemsBIC);

			// .......

			// SI UNA COLUMNA ES DE TIPO BOOLEAN HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new HtmlRenderer(),
			// new StringToBooleanConverter(FontAwesome.CHECK_SQUARE_O
			// .getHtml(), FontAwesome.SQUARE_O.getHtml()));

			// SI UNA COLUMNA ES DE TIPO DATE HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(new SimpleDateFormat("dd/MM/yyyy")));

			// SI UNA COLUMNA ES DE TIPO TIMESTAMP HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(
			// new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")));

			// .......

			List<SortOrder> order = new ArrayList<SortOrder>();

			order.add(new SortOrder("bonifProducto", SortDirection.ASCENDING));

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
			// =======================================================
			// -------------------------------------------------------
			// BOTONERA 1 Filtro

			HorizontalLayout filaBotoneraFiltroHL = new HorizontalLayout();
			filaBotoneraFiltroHL.setSpacing(true);

			agregarFiltroBTN = UtilUI.buildButtonAgregar();
			agregarFiltroBTN.addClickListener(e -> {
				agregarFiltroBTNClick();
			});
			modificarFiltroBTN = UtilUI.buildButtonModificar();
			modificarFiltroBTN.addClickListener(e -> {
				modificarFiltroBTNClick();
			});

			filaBotoneraFiltroHL.addComponents(agregarFiltroBTN, modificarFiltroBTN);

			// -------------------------------------------------------
			// BOTONERA 2 Filtro

			HorizontalLayout filaBotoneraFiltro2HL = new HorizontalLayout();
			filaBotoneraFiltro2HL.setSpacing(true);

			eliminarFiltroBTN = UtilUI.buildButtonEliminar();
			eliminarFiltroBTN.addClickListener(e -> {
				eliminarFiltroBTNClick();
			});

			filaBotoneraFiltro2HL.addComponents(eliminarFiltroBTN);

			// -------------------------------------------------------

			
			columna1VL.addComponents(itemsFiltroGRD, filaBotoneraPagedFiltroHL,filaBotoneraFiltroHL,filaBotoneraFiltro2HL);

			columna1VL.setComponentAlignment(itemsFiltroGRD,Alignment.MIDDLE_CENTER);
			columna1VL.setComponentAlignment(filaBotoneraPagedFiltroHL,Alignment.MIDDLE_RIGHT);
			columna1VL.setComponentAlignment(filaBotoneraFiltroHL, Alignment.MIDDLE_LEFT);
			columna1VL.setComponentAlignment(filaBotoneraFiltro2HL,Alignment.MIDDLE_RIGHT);
			
			columna2VL.addComponents(itemsGRD, filaBotoneraPagedHL,filaBotoneraHL,filaBotonera2HL);

			columna2VL.setComponentAlignment(filaBotoneraPagedHL,Alignment.MIDDLE_RIGHT);
			columna2VL.setComponentAlignment(filaBotoneraHL, Alignment.MIDDLE_LEFT);
			columna2VL.setComponentAlignment(filaBotonera2HL,Alignment.MIDDLE_RIGHT);

			content.addComponents(grillas);

			
			

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

			
			itemsFiltroGRD.addItemClickListener(new ItemClickListener() {
				@Override
				public void itemClick(ItemClickEvent event) {

					itemsGRD.select(null);

					BonificacionGrupos itemCuentasFondoFiltro = (BonificacionGrupos) event.getItemId();
					filterBI.getBean().setGrupoBonif(itemCuentasFondoFiltro.getGrupoBonif());
					loadDataResetPaged();
				}
			});

	
			
			itemsGRD.addSortListener(e -> {
				sort(e);
			});

			// =======================================================
			// -------------------------------------------------------

			loadDataFiltro();
			
			if (this.itemsFiltroBIC.size() > 0) {
				BonificacionGrupos itemCuentasFondoFiltro = (BonificacionGrupos) this.itemsFiltroBIC.getIdByIndex(0);
				itemsFiltroGRD.select(itemCuentasFondoFiltro);
				filterBI.getBean().setGrupoBonif(itemCuentasFondoFiltro.getGrupoBonif());
			}
			
			loadData();
			
			
		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// =================================================================================

	private void buildContainersItems() throws Exception {
		itemsFiltroBIC = new BeanItemContainer<BonificacionGrupos>(
				BonificacionGrupos.class, new ArrayList<BonificacionGrupos>());
		filterBI = new BeanItem<BonificacionProductosFiltro>(new BonificacionProductosFiltro());
		itemsBIC = new BeanItemContainer<BonificacionProductos>(BonificacionProductos.class, new ArrayList<BonificacionProductos>());
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

	private void nextPageFiltroBTNClick() {
		offsetFiltro = offsetFiltro + limitFiltro;
		prevPageFiltroBTN.setEnabled(offsetFiltro > 0);
		loadDataFiltro();
		if (this.itemsFiltroBIC.size() <= 0) {
			prevPageFiltroBTNClick();
		}
	}

	private void prevPageFiltroBTNClick() {
		offsetFiltro = offsetFiltro - limitFiltro;
		if (offsetFiltro < 0) {
			offsetFiltro = 0;
		}
		prevPageFiltroBTN.setEnabled(offsetFiltro > 0);
		loadDataFiltro();
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

													BonificacionProductos item = (BonificacionProductos) itemsGRD
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

				BonificacionProductos item = (BonificacionProductos) itemsGRD.getSelectedRow();
				item.getBonifProducto();

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

	
	
	private void eliminarFiltroBTNClick() {
		try {

			if (itemsFiltroGRD.getSelectedRow() != null) {

				getUI().addWindow(
						new EliminarDialog(
								itemsFiltroGRD.getSelectedRow().toString(),
								new EliminarDialog.Callback() {
									public void onDialogResult(boolean yes) {

										try {
											if (yes) {
												if (itemsFiltroGRD.getSelectedRow() != null) {

													BonificacionGrupos item = (BonificacionGrupos) itemsFiltroGRD
															.getSelectedRow();

													deleteItemFiltro(item);

													LogAndNotification
															.printSuccessOk("Se eliminó con éxito el ítem "
																	+ item);

													loadDataFiltro();
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
	
	protected void agregarFiltroBTNClick() {
		try {

			itemsFiltroGRD.select(null);
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
	
	private void modificarFiltroBTNClick() {

		try {

			if (itemsFiltroGRD.getSelectedRow() != null) {

				BonificacionGrupos item = (BonificacionGrupos) itemsFiltroGRD.getSelectedRow();
				item.getGrupoBonif();

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

			List<BonificacionProductos> items = queryData();

			itemsBIC.removeAllItems();

			for (BonificacionProductos item : items) {
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

	
	private void loadDataFiltro() {
		try {

			List<BonificacionGrupos> items = queryDataBonificacionGruposFiltro();

			itemsFiltroBIC.removeAllItems();

			for (BonificacionGrupos item : items) {
				itemsFiltroBIC.addBean(item);
			}

			boolean enabled = itemsFiltroBIC.size() > 0;

			itemsFiltroGRD.setEnabled(enabled);

			nextPageFiltroBTN.setEnabled(itemsFiltroBIC.size() > 0
					&& itemsFiltroBIC.size() >= limitFiltro);

			prevPageFiltroBTN.setEnabled(offsetFiltro >= limitFiltro);

		} catch (InvalidValueException e) {
			LogAndNotification.print(e);
		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}
	
	// =================================================================================
	// SECCION PARA CONSULTAS A LA BASE DE DATOS


	// metodo que realiza la consulta a la base de datos
	private List<BonificacionProductos> queryData() {
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

			List<BonificacionProductos> items = mockData(limit, offset,
					this.filterBI.getBean());

			return items;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<BonificacionProductos>();
	}

	
	private List<BonificacionGrupos> queryDataBonificacionGruposFiltro() {
		try {

			return mockDataBonificacionGruposFiltro();

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<BonificacionGrupos>();
	}
	
	
	// metodo que realiza el delete en la base de datos
	private void deleteItem(BonificacionProductos item) {
		try {

			for (int i = 0; i < itemsMock.size(); i++) {
				if (itemsMock.get(i).getBonifProducto().equals(item.getBonifProducto())) {
					itemsMock.remove(i);
					return;
				}
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// metodo que realiza el delete en la base de datos
	private void deleteItemFiltro(BonificacionGrupos item) {
		try {

			for (int i = 0; i < itemsFiltroMock.size(); i++) {
				if (itemsFiltroMock.get(i).getGrupoBonif().equals(item.getGrupoBonif())) {
					itemsFiltroMock.remove(i);
					return;
				}
			}

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}
	// =================================================================================
	// SECCION SOLO PARA FINES DE MOCKUP

	List<BonificacionProductos> itemsMock = new ArrayList<BonificacionProductos>();

	private List<BonificacionProductos> mockData(int limit, int offset, BonificacionProductosFiltro filtro) {

		if (itemsMock.size() == 0) {
			BigDecimal v = new BigDecimal("0.00");
			BigDecimal v1 = new BigDecimal ("1.01");
			for (int i = 0; i < 500; i++) {

				BonificacionProductos item = new BonificacionProductos();
				v=v.add(v1);
				item.setBonifProducto(i);
				item.setDescripcion("Descripción "+ i);
				item.setPorcentaje(v);
				item.setGrupoBonif(new Random().nextInt(10));


				itemsMock.add(item);
			}
		}

		ArrayList<BonificacionProductos> arrayList = new ArrayList<BonificacionProductos>();

		for (BonificacionProductos item : itemsMock) {


			boolean passesFilterNumero = (filtro.getBonifProducto() == null || item
					.getBonifProducto().equals(filtro.getBonifProducto()));

			boolean passesFilterNombre = (filtro.getDescripcion() == null || item
					.getDescripcion().toLowerCase().contains(filtro.getDescripcion().toLowerCase()));

			boolean passesFilterGrupo= (filtro.getGrupoBonif() == null || item
					.getGrupoBonif().equals(filtro.getGrupoBonif()));
			
			if (passesFilterNumero && passesFilterNombre && passesFilterGrupo) {
				arrayList.add(item);
			}
		}

		int end = offset + limit;
		if (end > arrayList.size()) {
			return arrayList.subList(0, arrayList.size());
		}

		return arrayList.subList(offset, end);
	}


	List<BonificacionGrupos> itemsFiltroMock = new ArrayList<BonificacionGrupos>();

	private List<BonificacionGrupos> mockDataBonificacionGruposFiltro() {

		if (itemsFiltroMock.size() == 0) {

			for (int i = 0; i < 10; i++) {

				BonificacionGrupos item = new BonificacionGrupos();

				item.setGrupoBonif(i);
				item.setDescripcion("Nombre " + i);

				itemsFiltroMock.add(item);
			}
		}

		ArrayList<BonificacionGrupos> arrayList = new ArrayList<BonificacionGrupos>();

		for (BonificacionGrupos item : itemsFiltroMock) {

			arrayList.add(item);
		}

		int end = offsetFiltro + limitFiltro;
		if (end > arrayList.size()) {
			return arrayList.subList(0, arrayList.size());
		}

		return arrayList.subList(offsetFiltro, end);

	}
	
	// =================================================================================

} // END CLASS
