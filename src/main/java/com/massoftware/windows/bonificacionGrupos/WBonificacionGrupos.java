package com.massoftware.windows.bonificacionGrupos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.massoftware.windows.EliminarDialog;
import com.massoftware.windows.LogAndNotification;
import com.massoftware.windows.UtilUI;
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
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WBonificacionGrupos extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------

	private BeanItem<BonificacionGruposFiltro> filterBI;
	private BeanItemContainer<BonificacionGrupos> itemsBIC;

	// -------------------------------------------------------------

	protected int limit = 15;
	protected int offset = 0;

	// -------------------------------------------------------------

	private Grid itemsGRD;
	private Button prevPageBTN;
	private Button nextPageBTN;
	private Button agregarBTN;
	private Button modificarBTN;
	private Button eliminarBTN;

	// -------------------------------------------------------------

	private HorizontalLayout codigoTXTHL;
	private HorizontalLayout descripcionTXTHL;

	// -------------------------------------------------------------

	@SuppressWarnings("serial")
	public WBonificacionGrupos() {
		super();

		try {

			buildContainersItems();

			UtilUI.confWinList(this, "Bonificación grupos");

			VerticalLayout content = UtilUI.buildWinContentVertical();

			// =======================================================
			// -------------------------------------------------------
			// FILTROS

			HorizontalLayout filaFiltroHL = new HorizontalLayout();
			filaFiltroHL.setSpacing(true);

			// -----------

			codigoTXTHL = UtilUI.buildTXTHLInteger(filterBI, "grupoBonif",
					"Número", false, 5, -1, 3, false, false, null, false,
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

			// =======================================================
			// -------------------------------------------------------
			// GRILLA

			itemsGRD = UtilUI.buildGrid();
			itemsGRD.setWidth("270px");


			itemsGRD.setColumns(new Object[] { "grupoBonif", "descripcion" });

			UtilUI.confColumn(itemsGRD.getColumn("grupoBonif"), "Número", true,50);
			UtilUI.confColumn(itemsGRD.getColumn("descripcion"), "Descripción.", true, 200);

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

			order.add(new SortOrder("grupoBonif", SortDirection.ASCENDING));

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

			content.addComponents(itemsGRD, filaBotoneraPagedHL, filaBotoneraHL, filaBotonera2HL);

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

		filterBI = new BeanItem<BonificacionGruposFiltro>(new BonificacionGruposFiltro());
		itemsBIC = new BeanItemContainer<BonificacionGrupos>(BonificacionGrupos.class, new ArrayList<BonificacionGrupos>());
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

													BonificacionGrupos item = (BonificacionGrupos) itemsGRD
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

				BonificacionGrupos item = (BonificacionGrupos) itemsGRD.getSelectedRow();
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

			List<BonificacionGrupos> items = queryData();

			itemsBIC.removeAllItems();

			for (BonificacionGrupos item : items) {
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
	private List<BonificacionGrupos> queryData() {
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

			List<BonificacionGrupos> items = mockData(limit, offset,
					this.filterBI.getBean());

			return items;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<BonificacionGrupos>();
	}

	// metodo que realiza el delete en la base de datos
	private void deleteItem(BonificacionGrupos item) {
		try {

			for (int i = 0; i < itemsMock.size(); i++) {
				if (itemsMock.get(i).getGrupoBonif().equals(item.getGrupoBonif())) {
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

	List<BonificacionGrupos> itemsMock = new ArrayList<BonificacionGrupos>();

	private List<BonificacionGrupos> mockData(int limit, int offset, BonificacionGruposFiltro filtro) {

		if (itemsMock.size() == 0) {

			for (int i = 0; i < 500; i++) {

				BonificacionGrupos item = new BonificacionGrupos();

				item.setGrupoBonif(i);
				item.setDescripcion("Descripción "+ i);


				itemsMock.add(item);
			}
		}

		ArrayList<BonificacionGrupos> arrayList = new ArrayList<BonificacionGrupos>();

		for (BonificacionGrupos item : itemsMock) {


			boolean passesFilterNumero = (filtro.getGrupoBonif() == null || item
					.getGrupoBonif().equals(filtro.getGrupoBonif()));

			boolean passesFilterNombre = (filtro.getDescripcion() == null || item
					.getDescripcion().toLowerCase()
					.contains(filtro.getDescripcion().toLowerCase()));

			if (passesFilterNumero && passesFilterNombre) {
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
