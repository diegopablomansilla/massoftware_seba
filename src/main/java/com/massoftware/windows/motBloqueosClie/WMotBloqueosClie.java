package com.massoftware.windows.motBloqueosClie;

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

public class WMotBloqueosClie extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------

	private BeanItem<MotBloqueosClieFiltro> filterBI;
	private BeanItemContainer<MotBloqueosClie> itemsBIC;

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

	private HorizontalLayout motBloqueoTXTHL;
	private HorizontalLayout detalleTXTHL;

	// -------------------------------------------------------------

	@SuppressWarnings("serial")
	public WMotBloqueosClie() {
		super();

		try {

			buildContainersItems();

			UtilUI.confWinList(this, "Motivos de bloqueos a clientes");

			VerticalLayout content = UtilUI.buildWinContentVertical();

			// =======================================================
			// -------------------------------------------------------
			// FILTROS

			HorizontalLayout filaFiltroHL = new HorizontalLayout();
			filaFiltroHL.setSpacing(true);

			// ------------

			motBloqueoTXTHL = UtilUI.buildTXTHL(filterBI, "motivoBloqueo", "Motivo", 
					false, 8, -1, 2, false, false, null, false,
					UtilUI.CONTAINS_WORDS_AND);

			TextField motBloqueoTXT = (TextField) motBloqueoTXTHL.getComponent(0);

			motBloqueoTXT.addTextChangeListener(new TextChangeListener() {
				public void textChange(TextChangeEvent event) {
					try {
						motBloqueoTXT.setValue(event.getText());
						loadDataResetPaged();
					} catch (Exception e) {
						LogAndNotification.print(e);
					}
				}

			});

			Button motBloqueoBTN = (Button) motBloqueoTXTHL.getComponent(1);

			motBloqueoBTN.addClickListener(e -> {
				this.loadDataResetPaged();
			});

			// -----------

			detalleTXTHL = UtilUI.buildTXTHL(filterBI, "detalle", "Detalle",
					false, 20, -1, 30, false, false, null, false,
					UtilUI.CONTAINS_WORDS_AND);

			TextField detalleTXT = (TextField) detalleTXTHL.getComponent(0);

			detalleTXT.addTextChangeListener(new TextChangeListener() {
				public void textChange(TextChangeEvent event) {
					try {
						detalleTXT.setValue(event.getText());
						loadDataResetPaged();
					} catch (Exception e) {
						LogAndNotification.print(e);
					}
				}

			});

			Button detalleBTN = (Button) detalleTXTHL.getComponent(1);

			detalleBTN.addClickListener(e -> {
				this.loadDataResetPaged();
			});

			// -----------

			Button buscarBTN = UtilUI.buildButtonBuscar();
			buscarBTN.addClickListener(e -> {
				loadData();
			});

			filaFiltroHL.addComponents(motBloqueoTXTHL, detalleTXTHL, buscarBTN);

			filaFiltroHL.setComponentAlignment(buscarBTN, Alignment.MIDDLE_RIGHT);

			// =======================================================
			// -------------------------------------------------------
			// GRILLA

			itemsGRD = UtilUI.buildGrid();
			itemsGRD.setWidth(24f,Unit.EM);

			itemsGRD.setColumns(new Object[] { "motivoBloqueo", "detalle", "clasifCliente" });

			UtilUI.confColumn(itemsGRD.getColumn("motivoBloqueo"), "Motivo", true, 60);
			UtilUI.confColumn(itemsGRD.getColumn("detalle"), "Detalle", true, 200);
			UtilUI.confColumn(itemsGRD.getColumn("clasifCliente"), "Clasif. cta cte",true, 100);
			

			
			itemsGRD.setContainerDataSource(itemsBIC);

			// .......

			// SI UNA COLUMNA ES DE TIPO BOOLEAN HACER LO QUE SIGUE
//			 itemsGRD.getColumn("attName").setRenderer(
//			 new HtmlRenderer(),
//			 new StringToBooleanConverter(FontAwesome.CHECK_SQUARE_O
//			 .getHtml(), FontAwesome.SQUARE_O.getHtml()));

			// SI UNA COLUMNA ES DE TIPO DATE HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(new SimpleDateFormat("dd/MM/yyyy")));

			// SI UNA COLUMNA ES DE TIPO TIMESTAMP HACER LO QUE SIGUE
			// itemsGRD.getColumn("attName").setRenderer(
			// new DateRenderer(
			// new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")));

			// .......

			List<SortOrder> order = new ArrayList<SortOrder>();

			order.add(new SortOrder("motivoBloqueo", SortDirection.ASCENDING));

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

			content.addComponents(filaFiltroHL, itemsGRD, filaBotoneraPagedHL,filaBotoneraHL, filaBotonera2HL);

			content.setComponentAlignment(filaFiltroHL, Alignment.MIDDLE_CENTER);
			content.setComponentAlignment(filaBotoneraPagedHL,Alignment.MIDDLE_RIGHT);
			content.setComponentAlignment(filaBotoneraHL, Alignment.MIDDLE_LEFT);
			content.setComponentAlignment(filaBotonera2HL,Alignment.MIDDLE_RIGHT);

			
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

		filterBI = new BeanItem<MotBloqueosClieFiltro>(new MotBloqueosClieFiltro());
		itemsBIC = new BeanItemContainer<MotBloqueosClie>(MotBloqueosClie.class, new ArrayList<MotBloqueosClie>());
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

													MotBloqueosClie item = (MotBloqueosClie) itemsGRD
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
			Window window = new Window("Agregar ítem ");
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

				MotBloqueosClie item = (MotBloqueosClie) itemsGRD.getSelectedRow();
				item.getMotivoBloqueo();

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

			((Validatable) motBloqueoTXTHL.getComponent(0)).validate();
			((Validatable) detalleTXTHL.getComponent(0)).validate();

			List<MotBloqueosClie> items = queryData();

			itemsBIC.removeAllItems();

			for (MotBloqueosClie item : items) {
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
	private List<MotBloqueosClie> queryData() {
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

			List<MotBloqueosClie> items = mockData(limit,offset,this.filterBI.getBean());

			return items;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<MotBloqueosClie>();
	}

	// metodo que realiza el delete en la base de datos
	private void deleteItem(MotBloqueosClie item) {
		try {

			for (int i = 0; i < itemsMock.size(); i++) {
				if (itemsMock.get(i).getMotivoBloqueo().equals(item.getMotivoBloqueo())) {
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

	List<MotBloqueosClie> itemsMock = new ArrayList<MotBloqueosClie>();

	private List<MotBloqueosClie> mockData(int limit, int offset, MotBloqueosClieFiltro filtro) {

		if (itemsMock.size() == 0) {

			for (int i = 1; i < 99; i++) {

				MotBloqueosClie item = new MotBloqueosClie();
				
				item.setMotivoBloqueo("Z"+i);
				item.setDetalle("Nombre " + i);
				item.setClasifCliente(i);

				
				itemsMock.add(item);
			}
		}

		ArrayList<MotBloqueosClie> arrayList = new ArrayList<MotBloqueosClie>();

		for (MotBloqueosClie item : itemsMock) {

			boolean passesFilterNumero = (filtro.getMotivoBloqueo() == null || item
					.getMotivoBloqueo().toLowerCase()
					.contains(filtro.getMotivoBloqueo().toLowerCase()));

			boolean passesFilterNombre = (filtro.getDetalle() == null || item
					.getDetalle().toLowerCase()
					.contains(filtro.getDetalle().toLowerCase()));

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
