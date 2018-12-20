package com.massoftware.windows.sucursal;



import java.util.ArrayList;
import java.util.List;

import org.cendra.jdbc.ex.crud.InsertDuplicateException;
import org.cendra.jdbc.ex.crud.UniqueException;

import com.massoftware.windows.LogAndNotification;
import com.massoftware.windows.UtilUI;
import com.massoftware.windows.sucursales.Sucursales;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;



public class WSucursal extends Window {

	private static final long serialVersionUID = -6410625501465383928L;

	// -------------------------------------------------------------
	
	public final static String INSERT_MODE = "INSERT_MODE";
	public final static String UPDATE_MODE = "UPDATE_MODE";
	public final static String COPY_MODE = "COPY_MODE";

	private String mode;
	
	// -------------------------------------------------------------

	private BeanItem<SucursalFiltro> filterBI;
	private BeanItem<Sucursal> itemBI;
	private BeanItem<TipoSucursal> tipoSucursalBI;
	private BeanItem<Numero> numeroBI;
	
	// -------------------------------------------------------------

	private Button agregarBTN;
	private Button modificarBTN;

	// -------------------------------------------------------------

	private TextField txtSucursal;
	private TextField txtNombre;
	private TextField txtAbreviatura;
	private TextField txtCuenClieDesde;
	private TextField txtCuenClieHasta;
	private TextField txtClieOcaDesde;
	private TextField txtClieOcaHasta;
	private TextField txtCobranzaDesde;
	private TextField txtCobranzaHasta;
	private TextField txtProvDesde;
	private TextField txtProvHasta;
	private ComboBox cmbCantCarClie;
	private ComboBox cmbCantCarProv;
	private ComboBox cmbTipoSucursal;
	private CheckBox chkIdNumClie;
	private CheckBox chkPermCambClie;
	private CheckBox chkIdNumProv;
	private CheckBox chkPermCambProv;
	private Label lblCtaCliente= new Label();
	private Label lblClienteOca= new Label();
	private Label lblNroCobranza= new Label();
	private Label lblProveedor= new Label();
	private Label lblCantCarClie= new Label();
	private Label lblCantCarProv= new Label();
	
	// -------------------------------------------------------------

	public WSucursal() {
		super();

		this.mode = INSERT_MODE;
		filterBI = new BeanItem<SucursalFiltro>(new SucursalFiltro());
		itemBI = new BeanItem<Sucursal>(new Sucursal());
		tipoSucursalBI = new BeanItem<TipoSucursal>(new TipoSucursal());
		numeroBI = new BeanItem<Numero>(new Numero());
		
		init();
	}
	
	public WSucursal(Sucursales item) {
		super();
		
		this.mode = UPDATE_MODE;
		
		SucursalFiltro a = new SucursalFiltro();
		a.setSucursal(item.getSucursal());
		a.setNombre(item.getNombre());
		
		
		filterBI = new BeanItem<SucursalFiltro>(a);
		itemBI = new BeanItem<Sucursal>(new Sucursal());
		tipoSucursalBI = new BeanItem<TipoSucursal>(new TipoSucursal());
		numeroBI = new BeanItem<Numero>(new Numero());
		
		init();
	}
	
	public void init() {
		try {

			UtilUI.confWinForm(this, "Sucursal");


			VerticalLayout content = UtilUI.buildWinContentVertical();
			
			
			// =======================================================
			// -------------------------------------------------------
			// FORM

			// -----------

			VerticalLayout vl = UtilUI.buildVL();
			HorizontalLayout fila1 = UtilUI.buildHL();
			HorizontalLayout fila2 = UtilUI.buildHL();
			HorizontalLayout fila3 = UtilUI.buildHL();
			HorizontalLayout fila4 = UtilUI.buildHL();
			HorizontalLayout fila5 = UtilUI.buildHL();
			HorizontalLayout fila6 = UtilUI.buildHL();
			VerticalLayout vl1 = UtilUI.buildVL();
			VerticalLayout vl2 = UtilUI.buildVL();
			
//			loadData();
			
			txtSucursal = UtilUI.buildTXT(itemBI, "sucursal", "Sucursal", false, 8, -1, 3, true, false, null, false);
			txtNombre = UtilUI.buildTXT(itemBI, "nombre", "Nombre", false, 15, -1, 3, true, false, null, false);
			txtAbreviatura = UtilUI.buildTXT(itemBI, "abreviatura", "Abreviatura", false, 8, -1, 3, false, false, null, false);
			txtCuenClieDesde = UtilUI.buildTXT(itemBI, "ctasClieDesde", "Desde", false, 8, -1, 3, false, false, null, false);
			txtCuenClieHasta = UtilUI.buildTXT(itemBI, "ctasClieHasta", "Hasta", false, 8, -1, 3, false, false, null, false);
			txtClieOcaDesde = UtilUI.buildTXT(itemBI, "ctasClieOcasionalDesde", "", false, 8, -1, 3, false, false, null, false);
			txtClieOcaHasta = UtilUI.buildTXT(itemBI, "ctasClieOcasionalHasta", "", false, 8, -1, 3, false, false, null, false);
			txtCobranzaDesde = UtilUI.buildTXT(itemBI, "nroCobranzaDesde", "", false, 8, -1, 3, false, false, null, false);
			txtCobranzaHasta = UtilUI.buildTXT(itemBI, "nroCobranzaHasta", "", false, 8, -1, 3, false, false, null, false);
			txtProvDesde = UtilUI.buildTXT(itemBI, "ctasProvDesde", "", false, 8, -1, 3, false, false, null, false);
			txtProvHasta = UtilUI.buildTXT(itemBI, "ctasProvHasta", "", false, 8, -1, 3, false, false, null, false);
			
			cmbCantCarClie = UtilUI.buildFieldCB(itemBI, "cantCaracteresClie", "", "numero", "numero", 5, false, false, true, Numero.class, queryDataNumero());
			cmbCantCarProv = UtilUI.buildFieldCB(itemBI, "cantCaracteresProv", "", "numero", "numero", 5, false, false, true, Numero.class, queryDataNumero());
			cmbTipoSucursal = UtilUI.buildFieldCB(itemBI, "tipoSucursal", "Tipo Sucursal", "id", "nombre", 15, false, true, true, TipoSucursal.class, queryDataTipoSucursales());

			
			chkIdNumClie = UtilUI.buildFieldCHK(itemBI, "numericoClie", "Identificación Numérica", false);
			chkPermCambClie = UtilUI.buildFieldCHK(itemBI, "permiteCambioClie", "Permite Cambiar", false);
			chkIdNumProv = UtilUI.buildFieldCHK(itemBI, "numericoProv", "Identificación Numérica", false);
			chkPermCambProv = UtilUI.buildFieldCHK(itemBI, "permiteCambioProv", "Permite Cambiar", false);
			
			lblCtaCliente = UtilUI.buildLbl("Cuenta Clientes", 7f);
			lblClienteOca = UtilUI.buildLbl("Clientes Ocacionales", 7f);
			lblNroCobranza = UtilUI.buildLbl("Nro Cobranza", 7f);
			lblProveedor = UtilUI.buildLbl("Proveedores", 7f);
			lblCantCarClie = UtilUI.buildLbl("Cantidad Caracteres", 6f);
			lblCantCarProv = UtilUI.buildLbl("Cantidad Caracteres", 6f);
			

			
			vl.setSpacing(false);
			vl1.setSpacing(false);
			vl2.setSpacing(false);
			
			fila3.setHeight(2, Unit.EM);
			fila4.setHeight(2, Unit.EM);
			fila5.setHeight(2, Unit.EM);

			
			vl1.addComponents(chkIdNumClie,chkPermCambClie);
			vl2.addComponents(chkIdNumProv,chkPermCambProv);
			fila1.addComponents(txtSucursal,txtNombre);
			fila2.addComponents(txtAbreviatura,cmbTipoSucursal);
			fila3.addComponents(lblCtaCliente,txtCuenClieDesde,txtCuenClieHasta,lblCantCarClie,cmbCantCarClie,vl1);
			fila4.addComponents(lblClienteOca,txtClieOcaDesde,txtClieOcaHasta);
			fila5.addComponents(lblNroCobranza,txtCobranzaDesde,txtCobranzaHasta);
			fila6.addComponents(lblProveedor,txtProvDesde,txtProvHasta,lblCantCarProv,cmbCantCarProv,vl2);

			fila3.setComponentAlignment(lblCtaCliente, Alignment.BOTTOM_LEFT);
			fila4.setComponentAlignment(lblClienteOca, Alignment.BOTTOM_LEFT);
			fila5.setComponentAlignment(lblNroCobranza, Alignment.BOTTOM_LEFT);
			fila6.setComponentAlignment(lblProveedor, Alignment.BOTTOM_LEFT);
			fila3.setComponentAlignment(lblCantCarClie, Alignment.BOTTOM_LEFT);
			fila3.setComponentAlignment(cmbCantCarClie, Alignment.TOP_LEFT);
			fila6.setComponentAlignment(lblCantCarProv, Alignment.BOTTOM_LEFT);
			fila6.setComponentAlignment(cmbCantCarProv, Alignment.TOP_LEFT);
			fila3.setComponentAlignment(vl1, Alignment.BOTTOM_LEFT);
			fila6.setComponentAlignment(vl2, Alignment.BOTTOM_LEFT);
			
			vl.addComponents(fila1,fila2,fila3,fila4,fila5,fila6);
			
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

			content.addComponents(vl, filaBotoneraHL);
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

			Sucursal item = queryData();
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
			
			txtSucursal.validate();
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
	private Sucursal queryData() {
		try {

			System.out.println("Los filtros son "
					+ this.filterBI.getBean().toString());

			// Notification.show("Los filtros son "
			// + this.filterBI.getBean().toString());


			Sucursal item = mockData(this.filterBI.getBean());

			return item;

		} catch (Exception e) {
			LogAndNotification.print(e);
		}
		return new Sucursal();
	}

	private List<TipoSucursal> queryDataTipoSucursales() {
		try {

			return mockDataTipoSucursales();

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return new ArrayList<TipoSucursal>();
	}
	
	private List<Numero> queryDataNumero() {
		List<Numero> a =new ArrayList<Numero>();
		try {

			a= mockDataNumero();

		} catch (Exception e) {
			LogAndNotification.print(e);
		}

		return a;
	}
	
	protected boolean insert() throws Exception {

		return true;
	}

	protected boolean update() throws Exception {

		return true;
	}
	
	// =================================================================================
	// SECCION SOLO PARA FINES DE MOCKUP

	private Sucursal mockData(SucursalFiltro filtro) {

		Sucursal item = new Sucursal();

		item.setSucursal(filtro.getSucursal());
		item.setNombre(filtro.getNombre());
		item.setAbreviatura("abr");
		item.setCantCaracteresClie(3);
		item.setCantCaracteresProv(4);
		item.setCtasClieDesde("444");
		item.setCtasClieHasta("555");

		
		item.setTipoSucursal(1);
		item.setNumericoClie(true);
		item.setPermiteCambioClie(true);
		item.setCtasClieOcasionalDesde(1111);
		item.setCtasClieOcasionalHasta(2222);
		item.setCtasProvDesde("111");
		item.setCtasProvHasta("222");
		item.setNumericoProv(true);
		item.setPermiteCambioProv(false);
		item.setNroCobranzaDesde(44);
		item.setNroCobranzaHasta(55);
		

		return item;
		

	}

	private List<TipoSucursal> mockDataTipoSucursales() {


		List<TipoSucursal> itemsMock = new ArrayList<TipoSucursal>();

		if (itemsMock.size() == 0) {

			for (Integer i = 0; i < 5; i++) {

				TipoSucursal item = new TipoSucursal();

				item.setId(i);
				item.setNombre("Nombre " + i);

				itemsMock.add(item);
			}
		}

		return itemsMock;
		

	}
	
	private List<Numero> mockDataNumero() {


		List<Numero> itemsMock = new ArrayList<Numero>();

		if (itemsMock.size() == 0) {

			for (Integer i = 3; i < 7; i++) {

				Numero item = new Numero();

				item.setNumero(i);

				itemsMock.add(item);
			}
		}

		return itemsMock;
		

	}
	// =================================================================================

} // END CLASS
