package com.massoftware.windows.motivoNotaDeCredito;



import org.cendra.jdbc.ex.crud.InsertDuplicateException;
import org.cendra.jdbc.ex.crud.UniqueException;

import com.massoftware.windows.LogAndNotification;
import com.massoftware.windows.UtilUI;
import com.massoftware.windows.motivosNotasDeCredito.MotivosNotasDeCreditos;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class WMotivoNotaDeCredito extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------

	private BeanItem<MotivoNotaDeCreditoFiltro> filterBI;
	private BeanItem<MotivoNotaDeCredito> itemBI;

	// -------------------------------------------------------------
	public final static String INSERT_MODE = "INSERT_MODE";
	public final static String UPDATE_MODE = "UPDATE_MODE";
	public final static String COPY_MODE = "COPY_MODE";

	private String mode;

	// -------------------------------------------------------------

	private Button agregarBTN;
	private Button modificarBTN;

	// -------------------------------------------------------------

	private TextField txtMotivo;
	private TextField txtNombre;
	
	// -------------------------------------------------------------

	public WMotivoNotaDeCredito() {
		super();
		
		this.mode = INSERT_MODE;
		filterBI = new BeanItem<MotivoNotaDeCreditoFiltro>(new MotivoNotaDeCreditoFiltro());
		itemBI = new BeanItem<MotivoNotaDeCredito>(new MotivoNotaDeCredito());
		
		init();
	}
	
	public WMotivoNotaDeCredito(MotivosNotasDeCreditos item) {
		super();
		
		this.mode = UPDATE_MODE;
		
		MotivoNotaDeCreditoFiltro a = new MotivoNotaDeCreditoFiltro();
		a.setMotivo(item.getMotivo());
		a.setNombre(item.getNombre());
		
		filterBI = new BeanItem<MotivoNotaDeCreditoFiltro>(a);
		itemBI = new BeanItem<MotivoNotaDeCredito>(new MotivoNotaDeCredito());
		
		init();
		
	}
	
	

	public void init() {

		try {

			UtilUI.confWinList(this, "Motivo nota de credito");

			VerticalLayout content = UtilUI.buildWinContentVertical();

			// =======================================================
			// -------------------------------------------------------
			// FORM

			// -----------

			HorizontalLayout hl = UtilUI.buildHL();
			VerticalLayout column1 = UtilUI.buildVL();

			txtMotivo = UtilUI.buildTXT(itemBI, "motivo", "Motivo", false, 8, -1, 3, true, false, null, false);
			txtNombre = UtilUI.buildTXT(itemBI, "nombre", "Nombre", false, 15, -1, 3, true, false, null, false);


			column1.addComponents(txtMotivo, txtNombre);
			
			hl.addComponents(column1);
			
			// -----------




			// =======================================================
			// -------------------------------------------------------
			// BOTONERA 1

			HorizontalLayout filaBotoneraHL = new HorizontalLayout();
			filaBotoneraHL.setSpacing(true);

			agregarBTN = UtilUI.buildButtonAgregar();
			agregarBTN.addClickListener(e -> {
				save();
			});
			modificarBTN = UtilUI.buildButtonModificar();
			modificarBTN.addClickListener(e -> {
				save();
			});

			agregarBTN.setVisible(INSERT_MODE.equals(mode));
			modificarBTN.setVisible(UPDATE_MODE.equals(mode));

			filaBotoneraHL.addComponents(agregarBTN, modificarBTN);

			// -------------------------------------------------------

			content.addComponents(hl, filaBotoneraHL);
			content.setComponentAlignment(filaBotoneraHL, Alignment.MIDDLE_LEFT);

			this.setContent(content);

			
			
			

			// =======================================================
			// -------------------------------------------------------
			// KEY EVENTs

			// Si tenemos la necesidad de un CBOX descomentamos este codigo
//			this.addShortcutListener(new ShortcutListener("ENTER", KeyCode.ENTER, new int[] {}) {
//				
//				private static final long serialVersionUID = 1L;
//				
//				@Override
//				public void handleAction(Object sender, Object target) {
//					if (target.equals(control)) {
//					
//					}
//				
//				}
//			});

			// --------------------------------------------------
			
			
			this.addShortcutListener(new ShortcutListener("CTRL+S", KeyCode.S,
					new int[] { ModifierKey.CTRL }) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					save();
				}
			});

			this.addShortcutListener(new ShortcutListener("DELETE",
					KeyCode.DELETE, new int[] {}) {

				private static final long serialVersionUID = 1L;

				@Override
				public void handleAction(Object sender, Object target) {
					if (target instanceof TextField
							&& ((TextField) target).isEnabled()
							&& ((TextField) target).isReadOnly() == false) {
						((TextField) target).setValue(null);
					} else if (target instanceof DateField
							&& ((DateField) target).isEnabled()
							&& ((DateField) target).isReadOnly() == false) {
						((DateField) target).setValue(null);
					}
				}
			});


			// =======================================================
			// -------------------------------------------------------

			loadData();

			if (INSERT_MODE.equalsIgnoreCase(mode)) {
				this.setCaption("Agregar " + getCaption().toLowerCase());
				
			} else if (UPDATE_MODE.equalsIgnoreCase(mode)) {
				this.setCaption("Modificar " + getCaption().toLowerCase() + " : " + itemBI.getBean());
				
			} else if (COPY_MODE.equalsIgnoreCase(mode)) {
				this.setCaption("Copiar " + getCaption() + " : " + itemBI.getBean());
				
			}
			
			
			
			
		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	// =================================================================================

	private void loadData() {
		try {

			MotivoNotaDeCredito item = queryData();
			if (item != null) {
				itemBI.setBean(item);
			} else {
				LogAndNotification.printError("No se encontro el item",
						"Se intento buscar un item en base a los siguientes parámetros de búsqueda, "
								+ filterBI.getBean());
			}
		} catch (IllegalArgumentException e) {
			LogAndNotification.print(e);
		} catch (InvalidValueException e) {
			LogAndNotification.print(e);
		} catch (Exception e) {
			LogAndNotification.print(e);
		}
	}

	
	private void save() {
		try {
			
			txtMotivo.validate();
			txtNombre.validate();
			
			String m = null;
			boolean ok = true;

			if (INSERT_MODE.equalsIgnoreCase(mode)) {
				ok = insert();
				m = "El item se agregó con éxito,  " + itemBI.getBean() + ".";
				
			} else if (COPY_MODE.equalsIgnoreCase(mode)) {
				ok = insert();
				m = "El item se copió con éxito, " + itemBI.getBean() + ".";
				
			} else if (UPDATE_MODE.equalsIgnoreCase(mode)) {
				ok = update();
				m = "El item se modificó con éxito, " + itemBI.getBean() + ".";
				
			}

			if (ok) {
				LogAndNotification.printSuccessOk(m);
				close();
				
			}

		} catch (InvalidValueException e) {
			LogAndNotification.print(e);

		} catch (InsertDuplicateException e) {
			LogAndNotification.print(e);

		} catch (UniqueException e) {
			LogAndNotification.print(e);

		} catch (IllegalArgumentException e) {
			LogAndNotification.print(e);
		} catch (Exception e) {
			LogAndNotification.print(e);
		}

	}
	
	
	// =================================================================================
	// SECCION PARA CONSULTAS A LA BASE DE DATOS

	// metodo que realiza la consulta a la base de datos
	private MotivoNotaDeCredito queryData() {
		try {

			System.out.println("Los filtros son "
					+ this.filterBI.getBean().toString());

			// Notification.show("Los filtros son "
			// + this.filterBI.getBean().toString());


			MotivoNotaDeCredito item = mockData(this.filterBI.getBean());

			return item;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
		return new MotivoNotaDeCredito();
	}

	protected boolean insert() throws Exception {

		return true;
	}

	protected boolean update() throws Exception {

		return true;
	}
	
	// =================================================================================
	// SECCION SOLO PARA FINES DE MOCKUP

	private MotivoNotaDeCredito mockData(MotivoNotaDeCreditoFiltro filtro) {

		MotivoNotaDeCredito item = new MotivoNotaDeCredito();

		item.setMotivo(filtro.getMotivo());
		item.setNombre(filtro.getNombre());

		return item;
		

	}

	// =================================================================================

} // END CLASS
