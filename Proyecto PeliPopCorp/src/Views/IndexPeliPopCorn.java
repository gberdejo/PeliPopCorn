package Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.mysql.jdbc.CallableStatement;

import Animacion.Animacion;
import Cheats.Close;
import Cheats.Delay;
import Cheats.MaximizarAbajo;
import Cheats.MaximizarPanel;
import Cheats.MinimizarArriba;
import Cheats.MinimizarPanel;
import Cheats.MoverAbajo;
import Cheats.MoverArriba;
import Cheats.MoverDerecha;
import Cheats.MoverIzquierda;
import Class.Bocados;
import Class.Cliente;
import Class.Compra;
import Class.ListaFactura;
import Class.ListaTicket;
import Class.Peliculas;
import Class.Proyecciones;
import Interfaces.BocadosG;
import Interfaces.ClienteG;
import Interfaces.CompraG;
import Interfaces.PeliculasG;
import Interfaces.ProyeccionesG;
import Utils.MySQLConexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class IndexPeliPopCorn extends JFrame implements MouseListener ,Runnable {

	private JPanel IndexPanel;
	private JLabel lblCelular;
	private JLabel lblClose;
	private JPanel ContenedorPanel;
	private JLabel lvlFondoCelular;
	private JPanel MenuMantenimiento;
	private JLabel MantenimientoFondo;
	private JPanel MenuVentas;
	private JLabel lblProcesoFondo;
	private JLabel btnPelicula;
	private JLabel btnProyeccion;
	private JLabel btnBocados;
	private JLabel btnCliente;
	private JLabel btnCompra;
		private JLabel IconoMantenimiento;
		private JLabel TituloMantenimiento;
		private JLabel IconoVentas;
		private JLabel TituloVentas;
		private JPanel PanelPeliculas;
		private JTextField txtNombrePelicula;
		private JTextField txtGeneroPelicula;
		private JComboBox cboListarClasificacionPelicula;
		private JPanel PanelProyecciones;
		private JComboBox cboElegirPelicula;
		private JLabel FondoMantenimiento;
		private JLabel FondoProyecciones;
		private JPanel PanelBocados;
		private JLabel FondoBocados;
		private JTextArea txtDescripcionBocados;
		private JTextField txtPrecioBocados;
		private JTextField txtNombreBocados;
		private JPanel PanelCompra;
		private JComboBox cboSeleccionarCliente;
		private JTextField txtCantidadCompra;
		private JLabel lblAadirBocadosPara;
		private JScrollPane scrollPane_1;
		private JTable TableMostrarCombos;
		private JButton btnComprarTicket;
		private JTextField txtCantidadDeCombos;
		private JButton btnComprarBoletosYTicket;
		private JPanel PanelCliente;
		private JLabel lblAgregarNuevoCliente;
		private JTextField txtNombreCliente;
		private JLabel lblNombre;
		private JTextField txtApellidoCliente;
		private JLabel lblApellido;
		private JLabel lblEdad;
		private JTextField txtEdadCliente;
		private JButton btnAgregarCliente;
		private JScrollPane scrollPane_2;
		private JLabel btnExpandirCliente;
		private JTable TableCLiente;
		private JLabel label;
		private JLabel lblNombre_1;
		private JLabel lblGenero;
		private JLabel lblClasificacion;
		private JTextField txtDuracionPelicula;
		private JLabel lblDuracin;
		private JScrollPane scrollPane_3;
		private JTextArea txtDescripcionPelicula;
		private JLabel lblDescripcin;
		private JTextField txtFechaEstrenoPelicula;
		private JLabel lblFechaDeEstreno;
		private JLabel lblAgregarPeliculas;
		private JButton btnAgregarPeliculas;
		private JButton btnActualizarPeliculas;
		private JPanel PeliculasTable;
		private JScrollPane scrollPane_4;
		private JTable TablePeliculas;
		private JTextField txtIdPelicula;
		
		//----------------------------------------
		int PosicionPeliculas;
		int PosicionProyecciones;
		int PosicionBocados;
		int PosicionCompra;
		int PosicionCliente;
		int PosicionExpandirCliente;
		//--------------------------------------------
		int IndiceMantenimiento;
		int IndiceVentas;
		int IndiceConsultas;
		//--------------------------------------
		ArrayList<Peliculas> listaPeliculas= new ArrayList<>();
		ArrayList<Proyecciones> listaProyecciones = new ArrayList<>();
		ArrayList<Bocados> listaBocados = new ArrayList<>();
		ArrayList<Cliente> listaCliente = new ArrayList<>();
		ArrayList<ListaTicket> listaTicket = new ArrayList<>();
		ArrayList<ListaFactura> listaFactura = new ArrayList<>();
		MySQLConexion mysql = new MySQLConexion();
		//-----------------
		PeliculasG peliculasG = new PeliculasG();
		ProyeccionesG proyeccionesG = new ProyeccionesG();
		BocadosG bocadosG = new BocadosG();
		ClienteG clienteG = new ClienteG();
		CompraG compraG = new CompraG();
		//ventanas de manteniento
		private JButton btnNuevoPelicula;
		private JButton btnEliminarPelicula;
		private JPanel ProyeccionesTable;
		private JScrollPane scrollPane_5;
		private JTable TableProyecciones;
		private JLabel lblElegirSala;
		private JLabel lblElegirPelicula;
		private JComboBox cboElegirSala;
		private JTextField txtHoraProyeccion;
		private JLabel lblHorario;
		private JLabel lblAgregarProyecciones;
		private JButton btnAgregarProyecciones;
		private JButton btnNuevaProyeccion;
		private JButton btnActualizarProyeccion;
		private JButton btnEliminarProyeccion;
		private JTextField txtIdProyecciones;
		private JPanel BocadosTable;
		private JScrollPane scrollPane_6;
		private JTable TableBocados;
		private JButton btnAgregarBocado;
		private JButton btnActualizarBocado;
		private JButton btnNuevoBocado;
		private JButton btnEliminarBocado;
		private JLabel lblNombreDeBocados;
		private JLabel lblDescripcinDeBocados;
		private JLabel lblPrecioDeBocados;
		private JScrollPane scrollPane_7;
		private JTextField txtIdBocado;
		private JButton btnActualizarCliente;
		private JButton btnEliminarCliente;
		private JButton btnNuevoCliente;
		private JTextField txtIdCliente;
		private JTextField txtPrecioProyeccion;
		private JLabel lblPrecio;
		private JPanel TablaDeFactura;
		private JScrollPane scrollPane_8;
		private JTable TableCompraFactura;
		private JLabel lblComprasDeTicket;
		private JPanel TablaDeTicket;
		private JScrollPane ScrollTicket;
		private JLabel lblComprasBocados;
		private JTable TableCompraTicket;
		private JLabel lblSeleccionarCliente;
		private JLabel lblSeleccionarProyeccion;
		private JLabel lblCantidadDeTicket;
		private JScrollPane scrollPane;
		private JTable TableMostrarProyecciones;
		private JLabel lblCantidadDeCombos;
		private JLabel btnAbrirTablePeliculas;
		private JLabel BtnAbrirTableBocados;
		private JLabel BtnAbrirTableProyeccion;
		private JLabel lblAgregarNuevosBocados;
		private JLabel btnIzquierdaTicket;
		private JPanel MoveTicket;
		private JLabel btnDerechaTicket;
		private JLabel btnIzquierdaBocados;
		private JLabel btnDerechaBocados;
		private JPanel MoveBocados;
		private JLabel FondoVentas;
		private JLabel btnAbrirTablaCompra;
		private JPanel MovePelicula;
		private JLabel btnMoverIzquierdaPelicula;
		private JLabel btnMoverDerechaPelicula;
		private JPanel MoveProyeccion;
		private JLabel btnMoverIzquierdaProyeccion;
		private JLabel btnMoverDerechaProyeccion;
		private JPanel MoveBocado;
		private JLabel btnMoverIzquierdaBocados;
		private JLabel btnMoverDerechaBocados;
		private JLabel lbltituloPelicula;
		private JLabel lblProyecciones;
		private JLabel lblBocados;
		private JLabel lblCliente;
		private JLabel lblTicketYFactura;
		private JLabel lblBocados_1;
		private JLabel lblVenta;
		private JLabel lblComprarTicketY;
		private JLabel FondoCliente;
		private JLabel btnCerrarPelicula;
		private JLabel btnCerrarProyeccion;
		private JLabel btnCerrarBocados;
		private JLabel btnCerrarCompra;
		private JLabel btnCerrarCliente;
		
	public static void main(String[] args) {
		IndexPeliPopCorn frame = new IndexPeliPopCorn();
		Thread hilo = new Thread(frame);
		hilo.start();
	}
	public IndexPeliPopCorn() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1136, 569);
		IndexPanel = new JPanel();
		
		IndexPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(IndexPanel);
		IndexPanel.setLayout(null);
		setUndecorated(true);
		IndexPanel.setOpaque(false);
		setBackground(new Color(0,  0, 0, 0));
		setOpacity((float) 0.1);
		
		lblClose = new JLabel("");
		lblClose.setBounds(1025, 257, 54, 51);
		IndexPanel.add(lblClose);
		lblClose.addMouseListener(this);
		lblClose.setIcon(null);
		
		ContenedorPanel = new JPanel();
		ContenedorPanel.setBounds(150, 48, 836, 471);
		IndexPanel.add(ContenedorPanel);
		ContenedorPanel.setLayout(null);
		
		MenuVentas = new JPanel();
		MenuVentas.setLayout(null);
		MenuVentas.setBounds(140, 130, 0, 0);
		ContenedorPanel.add(MenuVentas);
		
		btnCompra = new JLabel("");
		btnCompra.addMouseListener(this);
		
		lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVenta.setBounds(10, 85, 76, 14);
		MenuVentas.add(lblVenta);
		
		lblBocados_1 = new JLabel("Bocados");
		lblBocados_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBocados_1.setBounds(10, 122, 76, 14);
		MenuVentas.add(lblBocados_1);
		
		lblTicketYFactura = new JLabel("Ticket");
		lblTicketYFactura.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTicketYFactura.setBounds(10, 108, 46, 14);
		MenuVentas.add(lblTicketYFactura);
		
		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(10, 30, 46, 14);
		MenuVentas.add(lblCliente);
		btnCompra.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\ticket.png"));
		btnCompra.setBounds(86, 85, 64, 64);
		MenuVentas.add(btnCompra);
		
		btnCliente = new JLabel("");
		btnCliente.addMouseListener(this);
		btnCliente.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\cliente.png"));
		btnCliente.setBounds(86, 11, 64, 64);
		MenuVentas.add(btnCliente);
		
		lblProcesoFondo = new JLabel("");
		lblProcesoFondo.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\FondoMenu.jpg"));
		lblProcesoFondo.setBounds(0, 0, 160, 160);
		MenuVentas.add(lblProcesoFondo);
		MenuVentas.setOpaque(false);
		
		MenuMantenimiento = new JPanel();
		MenuMantenimiento.setBounds(15, 130, 0, 0);
		ContenedorPanel.add(MenuMantenimiento);
		MenuMantenimiento.setLayout(null);
		
		
		btnBocados = new JLabel("");
		btnBocados.addMouseListener(this);
		
		btnPelicula = new JLabel("");
		btnPelicula.addMouseListener(this);
		
		btnProyeccion = new JLabel("");
		btnProyeccion.addMouseListener(this);
		
		lbltituloPelicula = new JLabel("Peliculas");
		lbltituloPelicula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbltituloPelicula.setBounds(10, 28, 88, 14);
		MenuMantenimiento.add(lbltituloPelicula);
		btnProyeccion.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\proyeccion.png"));
		btnProyeccion.setBounds(96, 60, 32, 32);
		MenuMantenimiento.add(btnProyeccion);
		btnPelicula.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\pelicula.png"));
		btnPelicula.setBounds(96, 17, 32, 32);
		MenuMantenimiento.add(btnPelicula);
		btnBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\bocado.png"));
		btnBocados.setBounds(96, 103, 32, 32);
		MenuMantenimiento.add(btnBocados);
		MenuMantenimiento.setOpaque(false);
		
		lblProyecciones = new JLabel("Proyecciones");
		lblProyecciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProyecciones.setBounds(10, 74, 88, 14);
		MenuMantenimiento.add(lblProyecciones);
		
		lblBocados = new JLabel("Bocados");
		lblBocados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBocados.setBounds(10, 121, 88, 14);
		MenuMantenimiento.add(lblBocados);
		
		MantenimientoFondo = new JLabel("");
		MantenimientoFondo.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\FondoMenu.jpg"));
		MantenimientoFondo.setBounds(0, 0, 160, 160);
		MenuMantenimiento.add(MantenimientoFondo);
		
		TablaDeTicket = new JPanel();
		TablaDeTicket.setLayout(null);
		TablaDeTicket.setBounds(-364, 50, 364, 200);
		ContenedorPanel.add(TablaDeTicket);
		
		lblComprasDeTicket = new JLabel("Compras de ticket");
		lblComprasDeTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComprasDeTicket.setBounds(10, 11, 202, 14);
		TablaDeTicket.add(lblComprasDeTicket);
		
		btnIzquierdaTicket = new JLabel("");
		btnIzquierdaTicket.addMouseListener(this);
		btnIzquierdaTicket.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\izquierda.png"));
		btnIzquierdaTicket.setBounds(140, 177, 32, 20);
		TablaDeTicket.add(btnIzquierdaTicket);
		
		MoveTicket = new JPanel();
		MoveTicket.setBounds(0, 27, 600, 150);
		TablaDeTicket.add(MoveTicket);
		MoveTicket.setLayout(null);
		
		ScrollTicket = new JScrollPane();
		ScrollTicket.setBounds(0, 0, 600, 150);
		MoveTicket.add(ScrollTicket);
		
		TableCompraTicket = new JTable();
		ScrollTicket.setViewportView(TableCompraTicket);
		
		btnDerechaTicket = new JLabel("");
		btnDerechaTicket.addMouseListener(this);
		btnDerechaTicket.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\derecha .png"));
		btnDerechaTicket.setBounds(180, 177, 32, 20);
		TablaDeTicket.add(btnDerechaTicket);
		
		TablaDeFactura = new JPanel();
		TablaDeFactura.setLayout(null);
		TablaDeFactura.setBounds(-364, 260, 364, 200);
		ContenedorPanel.add(TablaDeFactura);
		
		lblComprasBocados = new JLabel("Compras Bocados");
		lblComprasBocados.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComprasBocados.setBounds(10, 11, 202, 14);
		TablaDeFactura.add(lblComprasBocados);
		
		btnIzquierdaBocados = new JLabel("");
		btnIzquierdaBocados.addMouseListener(this);
		btnIzquierdaBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\izquierda.png"));
		btnIzquierdaBocados.setBounds(140, 180, 32, 20);
		TablaDeFactura.add(btnIzquierdaBocados);
		
		btnDerechaBocados = new JLabel("");
		btnDerechaBocados.addMouseListener(this);
		btnDerechaBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\derecha .png"));
		btnDerechaBocados.setBounds(180, 180, 32, 20);
		TablaDeFactura.add(btnDerechaBocados);
		
		MoveBocados = new JPanel();
		MoveBocados.setBounds(0, 25, 600, 150);
		TablaDeFactura.add(MoveBocados);
		MoveBocados.setLayout(null);
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(0, 0, 600, 150);
		MoveBocados.add(scrollPane_8);
		
		TableCompraFactura = new JTable();
		scrollPane_8.setViewportView(TableCompraFactura);
		
		BocadosTable = new JPanel();
		BocadosTable.setLayout(null);
		BocadosTable.setBounds(0, 472, 364, 200);
		ContenedorPanel.add(BocadosTable);
		
		MoveBocado = new JPanel();
		MoveBocado.setBounds(0, 0, 600, 170);
		BocadosTable.add(MoveBocado);
		MoveBocado.setLayout(null);
		
		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 0, 600, 170);
		MoveBocado.add(scrollPane_6);
		
		TableBocados = new JTable();
		TableBocados.addMouseListener(this);
		scrollPane_6.setViewportView(TableBocados);
		
		btnMoverIzquierdaBocados = new JLabel("");
		btnMoverIzquierdaBocados.addMouseListener(this);
		btnMoverIzquierdaBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\izquierda.png"));
		btnMoverIzquierdaBocados.setBounds(140, 175, 32, 20);
		BocadosTable.add(btnMoverIzquierdaBocados);
		
		btnMoverDerechaBocados = new JLabel("");
		btnMoverDerechaBocados.addMouseListener(this);
		btnMoverDerechaBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\derecha .png"));
		btnMoverDerechaBocados.setBounds(179, 175, 32, 20);
		BocadosTable.add(btnMoverDerechaBocados);
		
		ProyeccionesTable = new JPanel();
		ProyeccionesTable.setBounds(0, 472, 364, 200);
		ContenedorPanel.add(ProyeccionesTable);
		ProyeccionesTable.setLayout(null);
		
		MoveProyeccion = new JPanel();
		MoveProyeccion.setBounds(0, 0, 600, 170);
		ProyeccionesTable.add(MoveProyeccion);
		MoveProyeccion.setLayout(null);
		
		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(0, 0, 600, 170);
		MoveProyeccion.add(scrollPane_5);
		
		TableProyecciones = new JTable();
		TableProyecciones.addMouseListener(this);
		scrollPane_5.setViewportView(TableProyecciones);
		
		btnMoverIzquierdaProyeccion = new JLabel("");
		btnMoverIzquierdaProyeccion.addMouseListener(this);
		btnMoverIzquierdaProyeccion.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\izquierda.png"));
		btnMoverIzquierdaProyeccion.setBounds(135, 175, 32, 20);
		ProyeccionesTable.add(btnMoverIzquierdaProyeccion);
		
		btnMoverDerechaProyeccion = new JLabel("");
		btnMoverDerechaProyeccion.addMouseListener(this);
		btnMoverDerechaProyeccion.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\derecha .png"));
		btnMoverDerechaProyeccion.setBounds(177, 175, 32, 20);
		ProyeccionesTable.add(btnMoverDerechaProyeccion);
		
		PeliculasTable = new JPanel();
		PeliculasTable.setBounds(0, 472, 364, 200);
		ContenedorPanel.add(PeliculasTable);
		PeliculasTable.setLayout(null);
		
		MovePelicula = new JPanel();
		MovePelicula.setBounds(0, 0, 600, 170);
		PeliculasTable.add(MovePelicula);
		MovePelicula.setLayout(null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 0, 600, 170);
		MovePelicula.add(scrollPane_4);
		
		TablePeliculas = new JTable();
		TablePeliculas.addMouseListener(this);
		scrollPane_4.setViewportView(TablePeliculas);
		
		btnMoverIzquierdaPelicula = new JLabel("");
		btnMoverIzquierdaPelicula.addMouseListener(this);
		btnMoverIzquierdaPelicula.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\izquierda.png"));
		btnMoverIzquierdaPelicula.setBounds(97, 175, 32, 20);
		PeliculasTable.add(btnMoverIzquierdaPelicula);
		
		btnMoverDerechaPelicula = new JLabel("");
		btnMoverDerechaPelicula.addMouseListener(this);
		btnMoverDerechaPelicula.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\derecha .png"));
		btnMoverDerechaPelicula.setBounds(204, 175, 32, 20);
		PeliculasTable.add(btnMoverDerechaPelicula);
		
		PanelCliente = new JPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		ContenedorPanel.add(PanelCliente);
		PanelCliente.setLayout(null);
		
		btnCerrarCliente = new JLabel("");
		btnCerrarCliente.addMouseListener(this);
		btnCerrarCliente.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\close.png"));
		btnCerrarCliente.setBounds(336, 0, 64, 64);
		PanelCliente.add(btnCerrarCliente);
		
		lblAgregarNuevoCliente = new JLabel("Agregar Nuevo Cliente");
		lblAgregarNuevoCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAgregarNuevoCliente.setBounds(118, 11, 177, 37);
		PanelCliente.add(lblAgregarNuevoCliente);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(106, 68, 284, 23);
		PanelCliente.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(10, 70, 97, 14);
		PanelCliente.add(lblNombre);
		
		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setBounds(106, 109, 284, 23);
		PanelCliente.add(txtApellidoCliente);
		txtApellidoCliente.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblApellido.setBounds(10, 111, 97, 14);
		PanelCliente.add(lblApellido);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEdad.setBounds(10, 150, 97, 14);
		PanelCliente.add(lblEdad);
		
		txtEdadCliente = new JTextField();
		txtEdadCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtEdadCliente.setBounds(106, 141, 86, 30);
		PanelCliente.add(txtEdadCliente);
		txtEdadCliente.setColumns(10);
		
		btnAgregarCliente = new JButton("Agregar");
		btnAgregarCliente.addMouseListener(this);
		btnAgregarCliente.setBounds(10, 182, 107, 23);
		PanelCliente.add(btnAgregarCliente);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 251, 380, 138);
		PanelCliente.add(scrollPane_2);
		
		TableCLiente = new JTable();
		TableCLiente.addMouseListener(this);
		scrollPane_2.setViewportView(TableCLiente);
		
		btnExpandirCliente = new JLabel("");
		btnExpandirCliente.addMouseListener(this);
		btnExpandirCliente.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\CelularFlechaAtras.png"));
		btnExpandirCliente.setBounds(357, 207, 33, 33);
		PanelCliente.add(btnExpandirCliente);
		
		btnActualizarCliente = new JButton("Actualizar");
		btnActualizarCliente.addMouseListener(this);
		btnActualizarCliente.setBounds(138, 217, 89, 23);
		PanelCliente.add(btnActualizarCliente);
		
		btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.addMouseListener(this);
		btnEliminarCliente.setBounds(10, 216, 107, 23);
		PanelCliente.add(btnEliminarCliente);
		
		btnNuevoCliente = new JButton("Nuevo");
		btnNuevoCliente.addMouseListener(this);
		btnNuevoCliente.setBounds(138, 182, 89, 23);
		PanelCliente.add(btnNuevoCliente);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(10, 31, 0, 0);
		PanelCliente.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		FondoCliente = new JLabel("");
		FondoCliente.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\FondoCliente.jpg"));
		FondoCliente.setBounds(0, 0, 400, 400);
		PanelCliente.add(FondoCliente);
		ContenedorPanel.setOpaque(false);
		
		PanelCompra = new JPanel();
		PanelCompra.setBounds(836, 0, 472, 720);
		ContenedorPanel.add(PanelCompra);
		PanelCompra.setLayout(null);
		
		btnAbrirTablaCompra = new JLabel("");
		btnAbrirTablaCompra.addMouseListener(this);
		
		btnCerrarCompra = new JLabel("");
		btnCerrarCompra.addMouseListener(this);
		btnCerrarCompra.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\close.png"));
		btnCerrarCompra.setBounds(408, 0, 64, 64);
		PanelCompra.add(btnCerrarCompra);
		
		lblComprarTicketY = new JLabel("Comprar Ticket y Bocados");
		lblComprarTicketY.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComprarTicketY.setBounds(24, 11, 278, 31);
		PanelCompra.add(lblComprarTicketY);
		btnAbrirTablaCompra.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\tabla.png"));
		btnAbrirTablaCompra.setBounds(32, 377, 64, 64);
		PanelCompra.add(btnAbrirTablaCompra);
		
		cboSeleccionarCliente = new JComboBox();
		cboSeleccionarCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboSeleccionarCliente.setBounds(163, 53, 216, 41);
		PanelCompra.add(cboSeleccionarCliente);
		
		txtCantidadCompra = new JTextField();
		txtCantidadCompra.setBounds(142, 327, 160, 32);
		PanelCompra.add(txtCantidadCompra);
		txtCantidadCompra.setColumns(10);
		
		lblAadirBocadosPara = new JLabel("Añadir Bocados para ver la Pelicula");
		lblAadirBocadosPara.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAadirBocadosPara.setBounds(185, 417, 234, 30);
		PanelCompra.add(lblAadirBocadosPara);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(24, 479, 438, 110);
		PanelCompra.add(scrollPane_1);
		
		TableMostrarCombos = new JTable();
		TableMostrarCombos.addMouseListener(this);
		scrollPane_1.setViewportView(TableMostrarCombos);
		
		btnComprarTicket = new JButton("Comprar Ticket");
		btnComprarTicket.addMouseListener(this);
		btnComprarTicket.setBounds(339, 328, 123, 30);
		PanelCompra.add(btnComprarTicket);
		
		txtCantidadDeCombos = new JTextField();
		txtCantidadDeCombos.setBounds(216, 631, 86, 26);
		PanelCompra.add(txtCantidadDeCombos);
		txtCantidadDeCombos.setColumns(10);
		
		btnComprarBoletosYTicket = new JButton("Comprar ticket y Combo");
		btnComprarBoletosYTicket.addMouseListener(this);
		btnComprarBoletosYTicket.setBounds(286, 668, 176, 32);
		PanelCompra.add(btnComprarBoletosYTicket);
		
		label = new JLabel("");
		label.addMouseListener(this);
		label.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\CelularFlechaAtras.png"));
		label.setBounds(429, 417, 33, 33);
		PanelCompra.add(label);
		
		lblSeleccionarCliente = new JLabel("Seleccionar Cliente");
		lblSeleccionarCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarCliente.setBounds(24, 68, 129, 14);
		PanelCompra.add(lblSeleccionarCliente);
		
		lblSeleccionarProyeccion = new JLabel("Seleccionar Proyeccion");
		lblSeleccionarProyeccion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccionarProyeccion.setBounds(24, 127, 234, 14);
		PanelCompra.add(lblSeleccionarProyeccion);
		
		lblCantidadDeTicket = new JLabel("Cantidad");
		lblCantidadDeTicket.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidadDeTicket.setBounds(24, 336, 129, 14);
		PanelCompra.add(lblCantidadDeTicket);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 152, 452, 152);
		PanelCompra.add(scrollPane);
		
		TableMostrarProyecciones = new JTable();
		TableMostrarProyecciones.addMouseListener(this);
		scrollPane.setViewportView(TableMostrarProyecciones);
		
		lblCantidadDeCombos = new JLabel("Cantidad de Combos");
		lblCantidadDeCombos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidadDeCombos.setBounds(24, 637, 160, 14);
		PanelCompra.add(lblCantidadDeCombos);
		
		FondoVentas = new JLabel("");
		FondoVentas.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\FondoCompras.jpg"));
		FondoVentas.setBounds(0, 0, 472, 720);
		PanelCompra.add(FondoVentas);
		PanelCompra.setOpaque(false);
		
		PanelBocados = new JPanel();
		PanelBocados.setBounds(836, 0, 472, 472);
		ContenedorPanel.add(PanelBocados);
		PanelBocados.setLayout(null);
		PanelBocados.setOpaque(false);
		
		btnCerrarBocados = new JLabel("");
		btnCerrarBocados.addMouseListener(this);
		btnCerrarBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\close.png"));
		btnCerrarBocados.setBounds(408, 0, 64, 64);
		PanelBocados.add(btnCerrarBocados);
		
		lblAgregarNuevosBocados = new JLabel("Agregar Nuevos Bocados");
		lblAgregarNuevosBocados.setForeground(Color.WHITE);
		lblAgregarNuevosBocados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgregarNuevosBocados.setBounds(65, 37, 317, 35);
		PanelBocados.add(lblAgregarNuevosBocados);
		
		BtnAbrirTableBocados = new JLabel("New label");
		BtnAbrirTableBocados.addMouseListener(this);
		BtnAbrirTableBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\tabla.png"));
		BtnAbrirTableBocados.setBounds(26, 300, 64, 64);
		PanelBocados.add(BtnAbrirTableBocados);
		
		txtIdBocado = new JTextField();
		txtIdBocado.setBounds(190, 60, 0, 0);
		PanelBocados.add(txtIdBocado);
		txtIdBocado.setColumns(10);
		
		txtPrecioBocados = new JTextField();
		txtPrecioBocados.setColumns(10);
		txtPrecioBocados.setBounds(190, 244, 104, 22);
		PanelBocados.add(txtPrecioBocados);
		
		txtNombreBocados = new JTextField();
		txtNombreBocados.setColumns(10);
		txtNombreBocados.setBounds(190, 104, 171, 22);
		PanelBocados.add(txtNombreBocados);
		
		btnAgregarBocado = new JButton("Agregar");
		btnAgregarBocado.addMouseListener(this);
		btnAgregarBocado.setBounds(278, 300, 104, 23);
		PanelBocados.add(btnAgregarBocado);
		
		btnActualizarBocado = new JButton("Actualizar");
		btnActualizarBocado.addMouseListener(this);
		btnActualizarBocado.setBounds(134, 300, 110, 23);
		PanelBocados.add(btnActualizarBocado);
		
		btnNuevoBocado = new JButton("Nuevo");
		btnNuevoBocado.addMouseListener(this);
		btnNuevoBocado.setBounds(278, 334, 104, 23);
		PanelBocados.add(btnNuevoBocado);
		
		btnEliminarBocado = new JButton("Eliminar");
		btnEliminarBocado.addMouseListener(this);
		btnEliminarBocado.setBounds(134, 334, 110, 23);
		PanelBocados.add(btnEliminarBocado);
		
		lblNombreDeBocados = new JLabel("Nombre de Bocados");
		lblNombreDeBocados.setForeground(Color.WHITE);
		lblNombreDeBocados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombreDeBocados.setBounds(10, 108, 170, 14);
		PanelBocados.add(lblNombreDeBocados);
		
		lblDescripcinDeBocados = new JLabel("Descripción de Bocados");
		lblDescripcinDeBocados.setForeground(Color.WHITE);
		lblDescripcinDeBocados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcinDeBocados.setBounds(10, 154, 170, 14);
		PanelBocados.add(lblDescripcinDeBocados);
		
		lblPrecioDeBocados = new JLabel("Precio de Bocados");
		lblPrecioDeBocados.setForeground(Color.WHITE);
		lblPrecioDeBocados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecioDeBocados.setBounds(10, 248, 170, 14);
		PanelBocados.add(lblPrecioDeBocados);
		
		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(190, 148, 253, 85);
		PanelBocados.add(scrollPane_7);
		
		txtDescripcionBocados = new JTextArea();
		scrollPane_7.setViewportView(txtDescripcionBocados);
		
		FondoBocados = new JLabel("");
		FondoBocados.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\randon3.png"));
		FondoBocados.setBounds(0, 0, 472, 472);
		PanelBocados.add(FondoBocados);
		
		PanelPeliculas = new JPanel();
		PanelPeliculas.setBounds(836, 0, 472, 472);
		ContenedorPanel.add(PanelPeliculas);
		PanelPeliculas.setLayout(null);
		PanelPeliculas.setOpaque(false);
		
		btnActualizarPeliculas = new JButton("Actualizar");
		btnActualizarPeliculas.addMouseListener(this);
		
		btnNuevoPelicula = new JButton("Nuevo");
		btnNuevoPelicula.addMouseListener(this);
		
		btnEliminarPelicula = new JButton("Eliminar");
		btnEliminarPelicula.addMouseListener(this);
		
		btnAbrirTablePeliculas = new JLabel("");
		btnAbrirTablePeliculas.addMouseListener(this);
		
		btnCerrarPelicula = new JLabel("");
		btnCerrarPelicula.addMouseListener(this);
		btnCerrarPelicula.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\close.png"));
		btnCerrarPelicula.setBounds(408, 0, 64, 64);
		PanelPeliculas.add(btnCerrarPelicula);
		btnAbrirTablePeliculas.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\tabla.png"));
		btnAbrirTablePeliculas.setBounds(10, 359, 64, 64);
		PanelPeliculas.add(btnAbrirTablePeliculas);
		btnEliminarPelicula.setBounds(110, 381, 89, 23);
		PanelPeliculas.add(btnEliminarPelicula);
		btnNuevoPelicula.setBounds(367, 347, 89, 23);
		PanelPeliculas.add(btnNuevoPelicula);
		
		txtIdPelicula = new JTextField();
		txtIdPelicula.setBounds(167, 57, 0, 0);
		PanelPeliculas.add(txtIdPelicula);
		txtIdPelicula.setColumns(10);
		btnActualizarPeliculas.setBounds(220, 381, 137, 23);
		PanelPeliculas.add(btnActualizarPeliculas);
		
		txtNombrePelicula = new JTextField();
		txtNombrePelicula.setColumns(10);
		txtNombrePelicula.setBounds(166, 88, 246, 20);
		PanelPeliculas.add(txtNombrePelicula);
		
		txtGeneroPelicula = new JTextField();
		txtGeneroPelicula.setColumns(10);
		txtGeneroPelicula.setBounds(166, 119, 246, 20);
		PanelPeliculas.add(txtGeneroPelicula);
		
		cboListarClasificacionPelicula = new JComboBox();
		cboListarClasificacionPelicula.setBounds(166, 159, 119, 29);
		PanelPeliculas.add(cboListarClasificacionPelicula);
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setForeground(Color.WHITE);
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_1.setBounds(37, 91, 83, 14);
		PanelPeliculas.add(lblNombre_1);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGenero.setBounds(37, 122, 46, 14);
		PanelPeliculas.add(lblGenero);
		
		lblClasificacion = new JLabel("Clasificacion");
		lblClasificacion.setForeground(Color.WHITE);
		lblClasificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClasificacion.setBounds(37, 166, 83, 14);
		PanelPeliculas.add(lblClasificacion);
		
		txtDuracionPelicula = new JTextField();
		txtDuracionPelicula.setColumns(10);
		txtDuracionPelicula.setBounds(166, 199, 119, 20);
		PanelPeliculas.add(txtDuracionPelicula);
		
		lblDuracin = new JLabel("Duración");
		lblDuracin.setForeground(Color.WHITE);
		lblDuracin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDuracin.setBounds(37, 202, 83, 14);
		PanelPeliculas.add(lblDuracin);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(166, 230, 290, 90);
		PanelPeliculas.add(scrollPane_3);
		
		txtDescripcionPelicula = new JTextArea();
		scrollPane_3.setViewportView(txtDescripcionPelicula);
		
		lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setForeground(Color.WHITE);
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcin.setBounds(37, 236, 83, 14);
		PanelPeliculas.add(lblDescripcin);
		
		txtFechaEstrenoPelicula = new JTextField();
		txtFechaEstrenoPelicula.setColumns(10);
		txtFechaEstrenoPelicula.setBounds(166, 331, 142, 20);
		PanelPeliculas.add(txtFechaEstrenoPelicula);
		
		lblFechaDeEstreno = new JLabel("Fecha de Estreno");
		lblFechaDeEstreno.setForeground(Color.WHITE);
		lblFechaDeEstreno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaDeEstreno.setBounds(37, 334, 119, 14);
		PanelPeliculas.add(lblFechaDeEstreno);
		
		lblAgregarPeliculas = new JLabel("Agregar Peliculas");
		lblAgregarPeliculas.setForeground(Color.WHITE);
		lblAgregarPeliculas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAgregarPeliculas.setBounds(170, 24, 259, 29);
		PanelPeliculas.add(lblAgregarPeliculas);
		
		btnAgregarPeliculas = new JButton("Agregar");
		btnAgregarPeliculas.addMouseListener(this);
		btnAgregarPeliculas.setBounds(367, 381, 89, 23);
		PanelPeliculas.add(btnAgregarPeliculas);
		
		FondoMantenimiento = new JLabel("");
		FondoMantenimiento.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\randon1.png"));
		FondoMantenimiento.setBounds(0, 0, 472, 472);
		PanelPeliculas.add(FondoMantenimiento);
		
		PanelProyecciones = new JPanel();
		PanelProyecciones.setBounds(836, 0, 472, 472);
		ContenedorPanel.add(PanelProyecciones);
		PanelProyecciones.setLayout(null);
		
		BtnAbrirTableProyeccion = new JLabel("");
		BtnAbrirTableProyeccion.addMouseListener(this);
		
		btnCerrarProyeccion = new JLabel("");
		btnCerrarProyeccion.addMouseListener(this);
		btnCerrarProyeccion.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\close.png"));
		btnCerrarProyeccion.setBounds(408, 0, 64, 64);
		PanelProyecciones.add(btnCerrarProyeccion);
		BtnAbrirTableProyeccion.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\tabla.png"));
		BtnAbrirTableProyeccion.setBounds(33, 344, 64, 64);
		PanelProyecciones.add(BtnAbrirTableProyeccion);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setBounds(53, 280, 46, 14);
		PanelProyecciones.add(lblPrecio);
		
		txtPrecioProyeccion = new JTextField();
		txtPrecioProyeccion.setBounds(177, 277, 86, 20);
		PanelProyecciones.add(txtPrecioProyeccion);
		txtPrecioProyeccion.setColumns(10);
		
		txtIdProyecciones = new JTextField();
		txtIdProyecciones.setBounds(177, 65, 0, 0);
		PanelProyecciones.add(txtIdProyecciones);
		txtIdProyecciones.setColumns(10);
		
		btnEliminarProyeccion = new JButton("Eliminar");
		btnEliminarProyeccion.addMouseListener(this);
		btnEliminarProyeccion.setBounds(124, 378, 119, 23);
		PanelProyecciones.add(btnEliminarProyeccion);
		
		btnActualizarProyeccion = new JButton("Actualizar");
		btnActualizarProyeccion.addMouseListener(this);
		btnActualizarProyeccion.setBounds(124, 344, 119, 23);
		PanelProyecciones.add(btnActualizarProyeccion);
		
		btnNuevaProyeccion = new JButton("Nuevo");
		btnNuevaProyeccion.addMouseListener(this);
		btnNuevaProyeccion.setBounds(269, 378, 114, 23);
		PanelProyecciones.add(btnNuevaProyeccion);
		
		btnAgregarProyecciones = new JButton("Agregar");
		btnAgregarProyecciones.addMouseListener(this);
		btnAgregarProyecciones.setBounds(269, 344, 114, 23);
		PanelProyecciones.add(btnAgregarProyecciones);
		
		lblAgregarProyecciones = new JLabel("Agregar Nuevas Proyecciones");
		lblAgregarProyecciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAgregarProyecciones.setForeground(Color.WHITE);
		lblAgregarProyecciones.setBounds(10, 29, 338, 25);
		PanelProyecciones.add(lblAgregarProyecciones);
		
		lblHorario = new JLabel("Horario");
		lblHorario.setForeground(Color.WHITE);
		lblHorario.setBounds(53, 227, 46, 14);
		PanelProyecciones.add(lblHorario);
		
		txtHoraProyeccion = new JTextField();
		txtHoraProyeccion.setBounds(177, 223, 80, 22);
		PanelProyecciones.add(txtHoraProyeccion);
		txtHoraProyeccion.setColumns(10);
		
		cboElegirSala = new JComboBox();
		cboElegirSala.setBounds(177, 98, 266, 35);
		PanelProyecciones.add(cboElegirSala);
		
		cboElegirPelicula = new JComboBox();
		cboElegirPelicula.setBounds(177, 161, 171, 22);
		PanelProyecciones.add(cboElegirPelicula);
		PanelProyecciones.setOpaque(false);
		
		lblElegirSala = new JLabel("Elegir Sala");
		lblElegirSala.setForeground(Color.WHITE);
		lblElegirSala.setBounds(53, 113, 114, 14);
		PanelProyecciones.add(lblElegirSala);
		
		lblElegirPelicula = new JLabel("Elegir Pelicula");
		lblElegirPelicula.setForeground(Color.WHITE);
		lblElegirPelicula.setBounds(53, 165, 114, 14);
		PanelProyecciones.add(lblElegirPelicula);
		
		FondoProyecciones = new JLabel("");
		FondoProyecciones.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\randon2.png"));
		FondoProyecciones.setBounds(0, 0, 472, 472);
		PanelProyecciones.add(FondoProyecciones);
		
		TituloVentas = new JLabel("Ventas");
		TituloVentas.setFont(new Font("Tahoma", Font.BOLD, 13));
		TituloVentas.setBounds(145, 85, 67, 24);
		ContenedorPanel.add(TituloVentas);
		
		IconoVentas = new JLabel("");
		IconoVentas.addMouseListener(this);
		IconoVentas.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\venta.png"));
		IconoVentas.setBounds(132, 10, 64, 64);
		ContenedorPanel.add(IconoVentas);
		
		TituloMantenimiento = new JLabel("Mantenimiento");
		TituloMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		TituloMantenimiento.setBounds(15, 85, 102, 24);
		ContenedorPanel.add(TituloMantenimiento);
		
		IconoMantenimiento = new JLabel("");
		IconoMantenimiento.addMouseListener(this);
		IconoMantenimiento.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\mantenimiento.png"));
		IconoMantenimiento.setBounds(30, 10, 64, 64);
		ContenedorPanel.add(IconoMantenimiento);
		
		lvlFondoCelular = new JLabel("");
		lvlFondoCelular.addMouseListener(this);
		lvlFondoCelular.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\fondo.jpg"));
		lvlFondoCelular.setBounds(0, 0, 836, 472);
		ContenedorPanel.add(lvlFondoCelular);
		
		lblCelular = new JLabel("");
		lblCelular.setBounds(0, 0, 1136, 569);
		lblCelular.setIcon(new ImageIcon("C:\\Users\\rev-x\\Desktop\\PeliPopCorn-v9\\Proyecto PeliPopCorp\\Img\\fondoCelular.png"));
		
		IndexPanel.add(lblCelular);
		Refresh();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == btnCerrarCliente) {
			mouseClickedBtnCerrarCliente(e);
		}
		if (e.getSource() == btnCerrarCompra) {
			mouseClickedBtnCerrarCompra(e);
		}
		if (e.getSource() == btnCerrarBocados) {
			mouseClickedBtnCerrarBocados(e);
		}
		if (e.getSource() == btnCerrarProyeccion) {
			mouseClickedBtnCerrarProyeccion(e);
		}
		if (e.getSource() == btnCerrarPelicula) {
			mouseClickedBtnCerrarPelicula(e);
		}
		if (e.getSource() == btnMoverDerechaBocados) {
			mouseClickedBtnMoverDerechaBocados(e);
		}
		if (e.getSource() == btnMoverIzquierdaBocados) {
			mouseClickedBtnMoverIzquierdaBocados(e);
		}
		if (e.getSource() == btnMoverDerechaProyeccion) {
			mouseClickedBtnMoverDerechaProyeccion(e);
		}
		if (e.getSource() == btnMoverIzquierdaProyeccion) {
			mouseClickedBtnMoverIzquierdaProyeccion(e);
		}
		if (e.getSource() == btnMoverDerechaPelicula) {
			mouseClickedBtnMoverDerechaPelicula(e);
		}
		if (e.getSource() == btnMoverIzquierdaPelicula) {
			mouseClickedLabel_1(e);
		}
		if (e.getSource() == btnAbrirTablaCompra) {
			mouseClickedBtnAbrirTablaCompra(e);
		}
		if (e.getSource() == btnDerechaBocados) {
			mouseClickedBtnDerechaBocados(e);
		}
		if (e.getSource() == btnIzquierdaBocados) {
			mouseClickedBtnIzquierdaBocados(e);
		}
		if (e.getSource() == btnDerechaTicket) {
			mouseClickedBtnDerechaTicket(e);
		}
		if (e.getSource() == btnIzquierdaTicket) {
			mouseClickedBtnIzquierdaTicket(e);
		}
		if (e.getSource() == BtnAbrirTableBocados) {
			mouseClickedBtnAbrirTableBocados(e);
		}
		if (e.getSource() == BtnAbrirTableProyeccion) {
			mouseClickedBtnAbrirTableProyeccion(e);
		}
		if (e.getSource() == btnAbrirTablePeliculas) {
			mouseClickedBtnAbrirTablePeliculas(e);
		}
		if (e.getSource() == btnComprarBoletosYTicket) {
			mouseClickedBtnComprarBoletosYTicket(e);
		}
		if (e.getSource() == btnComprarTicket) {
			mouseClickedBtnComprarTicket(e);
		}
		if (e.getSource() == btnEliminarCliente) {
			mouseClickedBtnEliminarCliente(e);
		}
		if (e.getSource() == btnActualizarCliente) {
			mouseClickedBtnActualizarCliente(e);
		}
		if (e.getSource() == TableCLiente) {
			mouseClickedTableCLiente(e);
		}
		if (e.getSource() == btnNuevoCliente) {
			mouseClickedBtnNuevoCliente(e);
		}
		if (e.getSource() == btnAgregarCliente) {
			mouseClickedBtnAgregarCliente(e);
		}
		if (e.getSource() == btnNuevoBocado) {
			mouseClickedBtnNuevoBocado(e);
		}
		if (e.getSource() == btnEliminarBocado) {
			mouseClickedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizarBocado) {
			mouseClickedBtnActualizar(e);
		}
		if (e.getSource() == TableBocados) {
			mouseClickedTableBocados(e);
		}
		if (e.getSource() == btnAgregarBocado) {
			mouseClickedBtnAgregar(e);
		}
		if (e.getSource() == btnEliminarProyeccion) {
			mouseClickedBtnEliminarProyeccion(e);
		}
		if (e.getSource() == btnActualizarProyeccion) {
			mouseClickedBtnActualizarProyeccion(e);
		}
		if (e.getSource() == btnNuevaProyeccion) {
			mouseClickedBtnNuevaProyeccion(e);
		}
		if (e.getSource() == TableProyecciones) {
			mouseClickedTableProyecciones(e);
		}
		if (e.getSource() == btnAgregarProyecciones) {
			mouseClickedBtnAgregarProyecciones(e);
		}
		if (e.getSource() == btnEliminarPelicula) {
			mouseClickedBtnEliminarPelicula(e);
		}
		if (e.getSource() == btnNuevoPelicula) {
			mouseClickedBtnNuevo(e);
		}
		if (e.getSource() == btnActualizarPeliculas) {
			mouseClickedBtnActualizarPeliculas(e);
		}
		if (e.getSource() == TablePeliculas) {
			mouseClickedTablePeliculas(e);
		}
		if (e.getSource() == btnAgregarPeliculas) {
			mouseClickedBtnAgregarPeliculas(e);
		}
		if (e.getSource() == label) {
			mouseClickedLabel(e);
		}
		if (e.getSource() == btnExpandirCliente) {
			mouseClickedBtnExpandirCliente(e);
		}
		if (e.getSource() == btnCompra) {
			mouseClickedBtnCompra(e);
		}
		if (e.getSource() == IconoVentas) {
			mouseClickedIconoVentas(e);
		}
		if (e.getSource() == IconoMantenimiento) {
			mouseClickedIconoMantenimiento(e);
		}
		if (e.getSource() == btnCliente) {
			mouseClickedBtnDatosCliente(e);
		}
		if (e.getSource() == lvlFondoCelular) {
			mouseClickedLvlFondoCelular(e);
		}
		if (e.getSource() == btnBocados) {
			mouseClickedBtnBocados(e);
		}
		if (e.getSource() == btnProyeccion) {
			mouseClickedBtnProyeccion(e);
		}
		if (e.getSource() == btnPelicula) {
			mouseClickedBtnPelicula(e);
		}
		if (e.getSource() == lblClose) {
			mouseClickedLblClose(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblClose(MouseEvent e) {
		System.exit(0);
	}
	protected void mouseClickedBtnPelicula(MouseEvent e) {
		PosicionesPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		MinimizarMenus();
		//-------------------------------------------------
		if(PosicionPeliculas == 836){
			
			MoverIzquierdaJPanel(PanelPeliculas, 836, 364, 1);
		}
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnProyeccion(MouseEvent e) {
		PosicionesPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		MinimizarMenus();
		//-------------------------------------------------
		if(PosicionProyecciones == 836){
			
			MoverIzquierdaJPanel(PanelProyecciones, 836, 364, 1);
			
		}
		MoverDerechaPaneles();
		
	}
	protected void mouseClickedBtnBocados(MouseEvent e) {
		PosicionesPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		MinimizarMenus();
		//-------------------------------------------------
		if(PosicionBocados == 836){
			MoverIzquierdaJPanel(PanelBocados, 836, 364, 1);
			
		}
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnCompra(MouseEvent e) {
		PosicionesPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		MinimizarMenus();
		//-------------------------------------------------
		if(PosicionCompra == 836){
			MoverIzquierdaJPanel(PanelCompra, 836, 364, 1);
		}
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnDatosCliente(MouseEvent e) {
		PosicionesPanel();
		PanelCliente.setBounds(420, -248, 400, 248);
		MinimizarMenus();
		if(PosicionCliente == -248){
			Abajo(PanelCliente, -248, 0, 1);
			
			
		}
		//------------------------------------
		MoverDerechaPaneles();
		
	}
	protected void mouseClickedBtnExpandirCliente(MouseEvent e) {
		PosicionesPanel();
		if(PosicionExpandirCliente == 248){
			
			ExpandirAbajo(PanelCliente, 400, 1);
		}
		if(PosicionExpandirCliente == 400){
			ExpandirArriba(PanelCliente, 248, 1);
		}
	}
	protected void mouseClickedLvlFondoCelular(MouseEvent e) {
		/* fonfo del celular */
	}
	protected void mouseClickedIconoMantenimiento(MouseEvent e) {
		IndicesMenu();
		if(IndiceMantenimiento == 0){
			Maximizar(MenuMantenimiento,160,1);
		}
		MinimizarMenus();
	}
	protected void mouseClickedIconoVentas(MouseEvent e) {
		IndicesMenu();
		if(IndiceVentas == 0){
			Maximizar(MenuVentas,160,1);
			
		}
		MinimizarMenus();
	}
	
	void ExpandirAbajo(JPanel panel,int heightFinal,int tiempo){
		int x = (int) panel.getBounds().getX();
		int y = (int) panel.getBounds().getY();
		int width = (int) panel.getBounds().getWidth();
		int heightInicial = (int) panel.getBounds().getHeight();
		MaximizarAbajo max = new MaximizarAbajo(panel, x, y, width, heightInicial, heightFinal, tiempo);
		max.start();
	}
	void ExpandirArriba(JPanel panel,int heightFinal,int tiempo){
		int x = (int) panel.getBounds().getX();
		int y = (int) panel.getBounds().getY();
		int width = (int) panel.getBounds().getWidth();
		int heightInicial = (int) panel.getBounds().getHeight();
		MinimizarArriba max = new MinimizarArriba(panel, x, y, width, heightInicial, heightFinal, tiempo);
		max.start();
	}
	//------------- Mover Arriba y Abajo -----------------//
	void Arriba(JPanel panel,int inicio,int fin,int tiempo){
		int width = (int) panel.getBounds().getWidth();
		int height = (int) panel.getBounds().getHeight();
		int x = (int) panel.getBounds().getX();
		MoverArriba arriba = new MoverArriba(panel,x, inicio, fin, tiempo, width, height);
		arriba.start();
	}
	void Abajo(JPanel panel,int inicio,int fin,int tiempo){
		int width = (int) panel.getBounds().getWidth();
		int height = (int) panel.getBounds().getHeight();
		int x = (int) panel.getBounds().getX();
		MoverAbajo abajo = new MoverAbajo(panel,x, inicio, fin, tiempo, width, height);
		abajo.start();
	}
	//------------- Maximizar y Minimizar -----------------//
	void Maximizar(JPanel panel,int fin,int tiempo){
		int x = (int) panel.getBounds().getX();
		int y = (int) panel.getBounds().getY();
		int width = (int) panel.getBounds().getWidth();
		int height = (int) panel.getBounds().getHeight();
		
		MaximizarPanel maxpanel = new MaximizarPanel(panel,x,y,width,height,fin,tiempo);
		maxpanel.start();
	}
	void Minimizar(JPanel panel,int fin,int tiempo){
		int x = (int) panel.getBounds().getX();
		int y = (int) panel.getBounds().getY();
		int width = (int) panel.getBounds().getWidth();
		int height = (int) panel.getBounds().getHeight();
		
		MinimizarPanel minpanel = new MinimizarPanel(panel, x, y, width,height,fin,tiempo);
		minpanel.start();
	}
	//Instanciando la clase Mover DERECHA E IZQUIERDA
		public void MoverDerechaJPanel(JPanel panel,int inicio,int fin,int tiempo){
			int width = (int) panel.getBounds().getWidth();
			int height = (int) panel.getBounds().getHeight();
			MoverDerecha moverDerecha = new  MoverDerecha(panel, inicio, fin, tiempo,width,height);
			moverDerecha.start();
		}
		public void MoverIzquierdaJPanel(JPanel panel,int inicio,int fin,int tiempo){
			int width = (int) panel.getBounds().getWidth();
			int height = (int) panel.getBounds().getHeight();
			MoverIzquierda moverIzquierda = new  MoverIzquierda(panel, inicio, fin, tiempo,width,height);
			moverIzquierda.start();
		}
		@Override
		public void run() {
			try {
				//Thread.sleep(2000);
				this.setVisible(true);
				this.setLocationRelativeTo(null);
				double opacity = 0.1;
				while (opacity < 1.0) {
					this.setOpacity((float) opacity);
					opacity += 0.1;
					Thread.sleep(50);
					//System.out.println(this.getOpacity());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		void PosicionesPanel(){
			PosicionPeliculas = (int) PanelPeliculas.getBounds().getX();
			PosicionProyecciones = (int) PanelProyecciones.getBounds().getX();
			PosicionBocados = (int) PanelBocados.getBounds().getX();
			PosicionCompra = (int) PanelCompra.getBounds().getX();
			PosicionCliente = (int) PanelCliente.getBounds().getY();
			PosicionExpandirCliente = (int) PanelCliente.getBounds().getHeight();
			IndicesMenu();
		}
		void IndicesMenu(){
			IndiceMantenimiento = (int) MenuMantenimiento.getBounds().getWidth();
			IndiceVentas = (int) MenuVentas.getBounds().getWidth();
		}
		void MinimizarMenus(){
			if(IndiceMantenimiento == 156){
				Minimizar(MenuMantenimiento,0, 1);
			}
			if(IndiceVentas == 156){
				Minimizar(MenuVentas,0, 1);
			}
		}
		void MoverDerechaPaneles(){
			if(PosicionPeliculas == 364){
				MoverDerechaJPanel(PanelPeliculas,364,836,1);
			}
			if(PosicionProyecciones == 364){
				MoverDerechaJPanel(PanelProyecciones,364,836,1);
			}
			if(PosicionBocados == 364){
				MoverDerechaJPanel(PanelBocados,364,836,1);
			}
			if(PosicionCompra == 364){
				MoverDerechaJPanel(PanelCompra, 364, 836, 1);
			}
			if(PosicionCliente == 0){
				Arriba(PanelCliente, 0, -248, 1);
			}
			if(PosicionCliente == 0){
				Arriba(PanelCliente, 0, -248, 1);
			}
			MinimizarTable();
		}
	
	protected void mouseClickedLabel(MouseEvent e) {
		int rotacion=(int) PanelCompra.getBounds().getY();
		if(rotacion == 0){
			Arriba(PanelCompra, 0, -248, 1);
		}
		if(rotacion == -248){
			Abajo(PanelCompra, -248, 0, 1);
		}
		
	}
	void ListarClasificacionPelicula(){
		cboListarClasificacionPelicula.removeAllItems();
		Connection con = mysql.getConection();
		//ListarClasificacion()
		try {
			PreparedStatement pre = con.prepareStatement("call ListarClasificacion()");
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				cboListarClasificacionPelicula.addItem(rs.getString(1));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	
	}
	protected void mouseClickedBtnAgregarPeliculas(MouseEvent e) {
		Peliculas peliculas = new Peliculas();
		//idClasificacion,nombre,genero,descripcion,duracion,fecha
		peliculas.setIdClasificacion(cboListarClasificacionPelicula.getSelectedIndex()+1);
		peliculas.setNombrePelicula(txtNombrePelicula.getText());
		peliculas.setGeneroPelicula(txtGeneroPelicula.getText());
		peliculas.setDescripcionPelicula(txtDescripcionPelicula.getText());
		peliculas.setDuracionPelicula(txtDuracionPelicula.getText());
		peliculas.setEstrenoPelicula(txtFechaEstrenoPelicula.getText());
		peliculasG.AgregarPelicuas(peliculas);
		Refresh();
		
	}
	void CargarTablaPeliculas(){	
		String Columnas[] ={"ID Pelicula","Nombre","Genero","Duracion","Fecha de estreno","descripcion","Clasificaion"};
		listaPeliculas = peliculasG.ListarPeliculas();
		
		String Filas[][] = new String[listaPeliculas.size()][7];
		for(int i = 0; i < listaPeliculas.size(); i++){
			Filas[i][0] = String.valueOf(listaPeliculas.get(i).getIdPelicula());
			Filas[i][1] = listaPeliculas.get(i).getNombrePelicula();
			Filas[i][2] = listaPeliculas.get(i).getGeneroPelicula();
			Filas[i][3] = listaPeliculas.get(i).getDuracionPelicula();
			Filas[i][4] = listaPeliculas.get(i).getEstrenoPelicula();
			Filas[i][5] = listaPeliculas.get(i).getDescripcionPelicula();
			Filas[i][6] = listaPeliculas.get(i).getNombreClasifica();
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TablePeliculas.setModel(MiModelo);
	}
	void CargarTablaProyecciones(){
		String Columnas[] ={"IdProyecciones","Precio","Sala","Cantidad Butacas","Tipo de Sala","Id Pelicula","Nombre Pelicula","Hora"};
		listaProyecciones = proyeccionesG.ListarProyecciones();
		
		String Filas[][] = new String[listaProyecciones.size()][8];
		for(int i = 0; i < listaProyecciones.size(); i++){
			Filas[i][0] = String.valueOf(listaProyecciones.get(i).getIdProyecciones());
			Filas[i][1] = String.valueOf(listaProyecciones.get(i).getPrecio());
			Filas[i][2] = String.valueOf(listaProyecciones.get(i).getIdSala());
			Filas[i][3] = String.valueOf(listaProyecciones.get(i).getButacas());
			Filas[i][4] = listaProyecciones.get(i).getTipoSala();
			Filas[i][5] = String.valueOf(listaProyecciones.get(i).getIdPelicula());
			Filas[i][6] = listaProyecciones.get(i).getNombrePelicula();
			Filas[i][7] = listaProyecciones.get(i).getHora();
			
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableProyecciones.setModel(MiModelo);
		TableMostrarProyecciones.setModel(MiModelo);
		
	}
	void MostrarTablaProyecciones(){
		String Columnas[] ={"IdProyecciones","Precio","Sala","Tipo de Sala","Nombre Pelicula","Hora"};
		listaProyecciones = proyeccionesG.ListarProyecciones();
		
		String Filas[][] = new String[listaProyecciones.size()][6];
		for(int i = 0; i < listaProyecciones.size(); i++){
			Filas[i][0] = String.valueOf(listaProyecciones.get(i).getIdProyecciones());
			Filas[i][1] = String.valueOf(listaProyecciones.get(i).getPrecio());
			Filas[i][2] = String.valueOf(listaProyecciones.get(i).getIdSala());
			Filas[i][3] = listaProyecciones.get(i).getTipoSala();
			Filas[i][4] = listaProyecciones.get(i).getNombrePelicula();
			Filas[i][5] = listaProyecciones.get(i).getHora();
			
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableMostrarProyecciones.setModel(MiModelo);
		
	}
	void CargarTablaBocados(){
		String Columnas[] ={"IdBocados","Nombre de Bocados","Descripción","Precio"};
		listaBocados = bocadosG.ListarBocados();
		
		String Filas[][] = new String[listaBocados.size()][4];
		for(int i = 0; i < listaBocados.size(); i++){
			Filas[i][0] = String.valueOf(listaBocados.get(i).getIdBocado());
			Filas[i][1] = listaBocados.get(i).getNombreBocado();
			Filas[i][2] = listaBocados.get(i).getDescripcionBocado();
			Filas[i][3]= String.valueOf(listaBocados.get(i).getPrecioBocado());
			
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableBocados.setModel(MiModelo);
		TableMostrarCombos.setModel(MiModelo);
	}
	void ajustarAnchoColumnasBocados() {
		TableColumnModel tcm = TableBocados.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 1));
		tcm.getColumn(1).setPreferredWidth(anchoColumna(20));  
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30)); 
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 1));  
	}
	//*********************
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = TableMostrarCombos.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 1));  // Numero Bungalow
		tcm.getColumn(1).setPreferredWidth(anchoColumna(14));  // categoria
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30));  // Precio por dia
		tcm.getColumn(3).setPreferredWidth(anchoColumna( 6));  // Estado
	}
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	void CargarTablaComprasTicket(){
		String Columnas[] ={"IdTicket","Nombre de Pelicula","Sala","Tipo de sala"
				,"Hora de proyeccion","Cliente","Precio","Cantidad","SubTotal","Fecha de Ticket"};
		listaTicket = compraG.ListarTicket();
		
		String Filas[][] = new String[listaTicket.size()][10];
		for(int i = 0; i < listaTicket.size(); i++){
			Filas[i][0] = String.valueOf(listaTicket.get(i).getIdTicket());
			Filas[i][1] = listaTicket.get(i).getNombrePelicula();
			Filas[i][2] = String.valueOf(listaTicket.get(i).getIdSala());
			Filas[i][3] = listaTicket.get(i).getTipoSala();
			Filas[i][4] = listaTicket.get(i).getHoraPro();
			Filas[i][5] = listaTicket.get(i).getCliente();
			Filas[i][6] = String.valueOf(listaTicket.get(i).getPrecio());
			Filas[i][7] = String.valueOf(listaTicket.get(i).getCantidad());
			Filas[i][8] = String.valueOf(listaTicket.get(i).getSubtotal());
			Filas[i][9] = listaTicket.get(i).getFecha();
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableCompraTicket.setModel(MiModelo);
	}
	void CargarTableComprasBocados(){
		String Columnas[] ={"IdFactura","Cliente","Nombre de Bocado","Precio","Cantidad",
				"SubTotal","Fecha"};
		listaFactura = compraG.ListarFactura();
		
		String Filas[][] = new String[listaFactura.size()][7];
		for(int i = 0; i < listaFactura.size(); i++){
			Filas[i][0] = String.valueOf(listaFactura.get(i).getIdFactura());
			Filas[i][1] = listaFactura.get(i).getCliente();
			Filas[i][2] = listaFactura.get(i).getNombreCombo();
			Filas[i][3] = String.valueOf(listaFactura.get(i).getPrecio());
			Filas[i][4] =String.valueOf(listaFactura.get(i).getCantidad());
			Filas[i][5] =String.valueOf(listaFactura.get(i).getSubtotal());
			Filas[i][6] = listaFactura.get(i).getFecha();
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableCompraFactura.setModel(MiModelo);
	}
	
	//------------------------
	void CargarTablaCliente(){
		String Columnas[] ={"IdCliente","Nombre","Apellido","Edad"};
		listaCliente = clienteG.ListarCliente();
		
		String Filas[][] = new String[listaCliente.size()][4];
		for(int i = 0; i < listaCliente.size(); i++){
			Filas[i][0] = String.valueOf(listaCliente.get(i).getIdCliente());
			Filas[i][1] = listaCliente.get(i).getNombreCliente();
			Filas[i][2]=listaCliente.get(i).getApellidoCliente();
			Filas[i][3]=String.valueOf(listaCliente.get(i).getEdadCliente());
		}
		DefaultTableModel MiModelo=new 
						DefaultTableModel(Filas, Columnas);
		TableCLiente.setModel(MiModelo);
	}
	protected void mouseClickedTablePeliculas(MouseEvent e) {
		int fila = TablePeliculas.getSelectedRow();
		txtIdPelicula.setText(TablePeliculas.getValueAt(fila, 0).toString());
		txtNombrePelicula.setText(TablePeliculas.getValueAt(fila, 1).toString());
		txtGeneroPelicula.setText(TablePeliculas.getValueAt(fila, 2).toString());
		cboListarClasificacionPelicula.setSelectedIndex(combo(TablePeliculas.getValueAt(fila, 6).toString()));
		txtDescripcionPelicula.setText(TablePeliculas.getValueAt(fila, 5).toString());
		txtDuracionPelicula.setText(TablePeliculas.getValueAt(fila, 3).toString());
		txtFechaEstrenoPelicula.setText(TablePeliculas.getValueAt(fila, 4).toString());
	}
	int combo(String texto){
		int res=0;
		switch (texto) {
		case "APT":res = 0; break;
		case "+14":res = 1; break;
		case "+18":res = 2; break;
		}
		return res;
	}
	protected void mouseClickedBtnActualizarPeliculas(MouseEvent e) {
		Peliculas peliculas = new Peliculas();
		peliculas.setIdPelicula(Integer.parseInt(txtIdPelicula.getText()));
		peliculas.setIdClasificacion(cboListarClasificacionPelicula.getSelectedIndex()+1);
		peliculas.setNombrePelicula(txtNombrePelicula.getText());
		peliculas.setGeneroPelicula(txtGeneroPelicula.getText());
		peliculas.setDescripcionPelicula(txtDescripcionPelicula.getText());
		peliculas.setDuracionPelicula(txtDuracionPelicula.getText());
		peliculas.setEstrenoPelicula(txtFechaEstrenoPelicula.getText());
		peliculasG.ActualizarPeliculas(peliculas);
		Refresh();
	}
	protected void mouseClickedBtnNuevo(MouseEvent e) {
		LimpiarPelicula();
		
	}
	void LimpiarPelicula(){
		txtNombrePelicula.setText("");
		txtGeneroPelicula.setText("");
		cboListarClasificacionPelicula.setSelectedIndex(0);
		txtDescripcionPelicula.setText("");
		txtDuracionPelicula.setText("");
		txtFechaEstrenoPelicula.setText("");
	}
	protected void mouseClickedBtnEliminarPelicula(MouseEvent e) {
		peliculasG.EliminarPeliculas(Integer.parseInt(txtIdPelicula.getText()));
		Refresh();
	}
	
	void ElegirSalayPeliculas(){
		cboElegirSala.removeAllItems();
		cboElegirPelicula.removeAllItems();
		Connection con = mysql.getConection();
		try {
			
			PreparedStatement pre = con.prepareStatement("call ListarSalas()");
			ResultSet rs  = pre.executeQuery();
			while(rs.next()){
				cboElegirSala.addItem("Sala: "+rs.getString(1)+"   Butacas: "+rs.getString(2)+"   Tipo: "+rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			PreparedStatement pre = con.prepareStatement("call ListarElegirPeliculasPeliculas()");
			ResultSet rs = pre.executeQuery();
			while(rs.next()){
				cboElegirPelicula.addItem(rs.getString(2));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	void Refresh(){
		ListarClasificacionPelicula();
		CargarTablaPeliculas();
		LimpiarPelicula();
		//----------proyecciones
		ElegirSalayPeliculas();
		LimpiarProyeccion();
		CargarTablaProyecciones();
		//---------bocados
		CargarTablaBocados();
		ajustarAnchoColumnasBocados();
		LimpiarBocado();
		//********CLIENTE
		
		LimpiarCliente();
		CargarTablaCliente();
		//********** Compra ticket
		ListarSeleccionarCliente();
		MostrarTablaProyecciones();
		ajustarAnchoColumnas();
		CargarTablaComprasTicket();
		CargarTableComprasBocados();
		
	}
	
	protected void mouseClickedBtnAgregarProyecciones(MouseEvent e) {
		Proyecciones proyecciones = new Proyecciones();
		proyecciones.setIdSala(cboElegirSala.getSelectedIndex()+1);
		proyecciones.setIdPelicula(cboElegirPelicula.getSelectedIndex()+1);
		proyecciones.setHora(txtHoraProyeccion.getText());
		proyecciones.setPrecio(Double.parseDouble(txtPrecioProyeccion.getText()));
		proyeccionesG.AgregarPeliculas(proyecciones);
		Refresh();
	}
	protected void mouseClickedTableProyecciones(MouseEvent e) {
		int fila = TableProyecciones.getSelectedRow();
		String sala = (String) TableProyecciones.getValueAt(fila, 2);
		String pelicula = (String) TableProyecciones.getValueAt(fila, 5);
		
		txtIdProyecciones.setText(TableProyecciones.getValueAt(fila, 0).toString());
		cboElegirSala.setSelectedIndex(Integer.parseInt(sala)-1);
		cboElegirPelicula.setSelectedIndex(Integer.parseInt(pelicula)-1);
		txtHoraProyeccion.setText(TableProyecciones.getValueAt(fila, 7).toString());
		txtPrecioProyeccion.setText(TableProyecciones.getValueAt(fila, 1).toString());
	}
	
	protected void mouseClickedBtnNuevaProyeccion(MouseEvent e) {
		Refresh();
	}
	protected void mouseClickedBtnActualizarProyeccion(MouseEvent e) {
		Proyecciones proyecciones = new Proyecciones();
		proyecciones.setIdSala(cboElegirSala.getSelectedIndex()+1);
		proyecciones.setIdPelicula(cboElegirPelicula.getSelectedIndex()+1);
		proyecciones.setHora(txtHoraProyeccion.getText());
		proyecciones.setIdProyecciones(Integer.parseInt(txtIdProyecciones.getText()));
		proyecciones.setPrecio(Double.parseDouble(txtPrecioProyeccion.getText()));
		proyeccionesG.ActualizarProyecciones(proyecciones);
		Refresh();
	}
	protected void mouseClickedBtnEliminarProyeccion(MouseEvent e) {
		proyeccionesG.EliminarProyeccion(Integer.parseInt(txtIdProyecciones.getText()));
		Refresh();
	}
	void LimpiarProyeccion(){
		cboElegirPelicula.setSelectedIndex(0);
		cboElegirSala.setSelectedIndex(0);
		txtHoraProyeccion.setText("");
		txtIdProyecciones.setText("");
		txtPrecioProyeccion.setText("");
	}
	protected void mouseClickedBtnAgregar(MouseEvent e) {
		Bocados bocados = new Bocados();
		bocados.setNombreBocado(txtNombreBocados.getText());
		bocados.setDescripcionBocado(txtDescripcionBocados.getText());
		bocados.setPrecioBocado(Double.parseDouble(txtPrecioBocados.getText()));
		bocadosG.AgregarBocados(bocados);
		Refresh();
	}
	protected void mouseClickedBtnActualizar(MouseEvent e) {
		Bocados bocados = new Bocados();
		bocados.setIdBocado(Integer.parseInt(txtIdBocado.getText()));
		bocados.setNombreBocado(txtNombreBocados.getText());
		bocados.setDescripcionBocado(txtDescripcionBocados.getText());
		bocados.setPrecioBocado(Double.parseDouble(txtPrecioBocados.getText()));
		bocadosG.ActualizarBocados(bocados);
		Refresh();
	}
	protected void mouseClickedTableBocados(MouseEvent e) {
		int fila = TableBocados.getSelectedRow();
		txtIdBocado.setText( TableBocados.getValueAt(fila, 0).toString());
		txtNombreBocados.setText(TableBocados.getValueAt(fila, 1).toString());
		txtDescripcionBocados.setText(TableBocados.getValueAt(fila, 2).toString());
		txtPrecioBocados.setText(TableBocados.getValueAt(fila, 3).toString());
	}
	
	protected void mouseClickedBtnEliminar(MouseEvent e) {
		bocadosG.EliminarBocados(Integer.parseInt(txtIdBocado.getText()));
		Refresh();
	}
	protected void mouseClickedBtnNuevoBocado(MouseEvent e) {
		LimpiarBocado();
		
	}
	void LimpiarBocado(){
		txtIdBocado.setText("");
		txtNombreBocados.setText("");
		txtDescripcionBocados.setText("");
		txtPrecioBocados.setText("");
	}
	protected void mouseClickedBtnAgregarCliente(MouseEvent e) {
		Cliente cliente = new Cliente();
		cliente.setNombreCliente(txtNombreCliente.getText());
		cliente.setApellidoCliente(txtApellidoCliente.getText());
		cliente.setEdadCliente(Integer.parseInt(txtEdadCliente.getText()));
		clienteG.AgregarCliente(cliente);
		Refresh();
	}
	protected void mouseClickedBtnNuevoCliente(MouseEvent e) {
		LimpiarCliente();
	}
	void LimpiarCliente(){
		txtIdCliente.setText("");
		txtNombreCliente.setText("");
		txtApellidoCliente.setText("");
		txtEdadCliente.setText("");
	}
	protected void mouseClickedTableCLiente(MouseEvent e) {
		int fila = TableCLiente.getSelectedRow();
		txtIdCliente.setText(TableCLiente.getValueAt(fila, 0).toString());
		txtNombreCliente.setText(TableCLiente.getValueAt(fila, 1).toString());
		txtApellidoCliente.setText(TableCLiente.getValueAt(fila, 2).toString());
		txtEdadCliente.setText(TableCLiente.getValueAt(fila, 3).toString());
		
	}
	protected void mouseClickedBtnActualizarCliente(MouseEvent e) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
		cliente.setNombreCliente(txtNombreCliente.getText());
		cliente.setApellidoCliente(txtApellidoCliente.getText());
		cliente.setEdadCliente(Integer.parseInt(txtEdadCliente.getText()));
		clienteG.ActualizarCliente(cliente);
		Refresh();
	}
	protected void mouseClickedBtnEliminarCliente(MouseEvent e) {
		clienteG.EliminarCliente(Integer.parseInt(txtIdCliente.getText()));
		Refresh();
	}
	void ListarSeleccionarCliente(){
		cboSeleccionarCliente.removeAllItems();
		Connection con = mysql.getConection();
		try {
			CallableStatement call = (CallableStatement) con.prepareCall("call ListarCliente()");
			ResultSet rs = call.executeQuery();
			while(rs.next()){
				cboSeleccionarCliente.addItem(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void mouseClickedBtnComprarTicket(MouseEvent e) {
		if(PanelCompra.getBounds().getY() == 0){
			Compra compra = new Compra();
			String idpro = (String) TableMostrarProyecciones.getValueAt(TableMostrarProyecciones.getSelectedRow(),0);
			compra.setIdCliente(cboSeleccionarCliente.getSelectedIndex()+1);
			compra.setIdProyeccion(Integer.parseInt(idpro));
			compra.setCantidadTicket(Integer.parseInt(txtCantidadCompra.getText()));
			compraG.ComprarTicket(compra);
			Refresh();
		}
		
	}
	protected void mouseClickedBtnComprarBoletosYTicket(MouseEvent e) {
		if(PanelCompra.getBounds().getY() == -248){
			Compra compra = new Compra();
			String idpro = (String) TableMostrarProyecciones.getValueAt(TableMostrarProyecciones.getSelectedRow(),0);
			String idboca = (String) TableMostrarCombos.getValueAt(TableMostrarCombos.getSelectedRow(), 0);
		
			compra.setIdCliente(cboSeleccionarCliente.getSelectedIndex()+1);
			compra.setIdProyeccion(Integer.parseInt(idpro));
			compra.setCantidadTicket(Integer.parseInt(txtCantidadCompra.getText()));
			compra.setIdBocado(Integer.parseInt(idboca));
			compra.setCantidadBocado(Integer.parseInt(txtCantidadDeCombos.getText()));
			compraG.GenerarTicketyBocado(compra);
			Refresh();
		}
		
	}
	protected void mouseClickedBtnAbrirTablePeliculas(MouseEvent e) {
		if(PeliculasTable.getBounds().getY() == 472){
			
			Arriba(PeliculasTable, 472, 248, 1);
		}
		if(PeliculasTable.getBounds().getY() == 248){
			Abajo(PeliculasTable, 248, 472, 1);
		}
	}
	protected void mouseClickedBtnAbrirTableProyeccion(MouseEvent e) {
		if(ProyeccionesTable.getBounds().getY() == 472){
			
			Arriba(ProyeccionesTable, 472, 248, 1);
		}
		if(ProyeccionesTable.getBounds().getY() == 248){
			Abajo(ProyeccionesTable, 248, 472, 1);
		}
		
	}
	protected void mouseClickedBtnAbrirTableBocados(MouseEvent e) {
		if(BocadosTable.getBounds().getY() == 472){
			
			Arriba(BocadosTable, 472, 248, 1);
		}
		if(BocadosTable.getBounds().getY() == 248){
			Abajo(BocadosTable, 248, 472, 1);
		}
	}
	protected void mouseClickedBtnIzquierdaTicket(MouseEvent e) {
		if(MoveTicket.getBounds().getX() == 0){
			MoverIzquierdaJPanel(MoveTicket, 0, -234, 2);
		}
	}
	protected void mouseClickedBtnDerechaTicket(MouseEvent e) {
		if(MoveTicket.getBounds().getX() == -232){
			MoverDerechaJPanel(MoveTicket, -232, 0, 2);
		}
	}
	protected void mouseClickedBtnIzquierdaBocados(MouseEvent e) {
		if(MoveBocados.getBounds().getX() == 0){
			
			MoverIzquierdaJPanel(MoveBocados, 0, -240, 2);
		}
	}
	protected void mouseClickedBtnDerechaBocados(MouseEvent e) {
		if(MoveBocados.getBounds().getX() == -240){
			
			MoverDerechaJPanel(MoveBocados, -240, 0, 2);
		}
	}
	protected void mouseClickedBtnAbrirTablaCompra(MouseEvent e) {
		if(TablaDeFactura.getBounds().getX() == 0){
			MoverIzquierdaJPanel(TablaDeFactura, 0, -364, 1);
		}
		if(TablaDeTicket.getBounds().getX() == 0){
			MoverIzquierdaJPanel(TablaDeTicket, 0, -364, 1);
		}
		if(TablaDeFactura.getBounds().getX() == -364){
			
			MoverDerechaJPanel(TablaDeFactura, -364, 0, 1);
		}
		if(TablaDeTicket.getBounds().getX() == -364){
			
			MoverDerechaJPanel(TablaDeTicket, -364, 0, 1);
		}
	}
	protected void mouseClickedLabel_1(MouseEvent e) {
		if(MovePelicula.getBounds().getX() == 0){
			
			MoverIzquierdaJPanel(MovePelicula, 0, -250, 2);
		}
	}
	protected void mouseClickedBtnMoverDerechaPelicula(MouseEvent e) {
		if(MovePelicula.getBounds().getX() == -248){
			
			MoverDerechaJPanel(MovePelicula, -248, 0, 2);
		}
	}
	protected void mouseClickedBtnMoverIzquierdaProyeccion(MouseEvent e) {
		if(MoveProyeccion.getBounds().getX() == 0){
			
			MoverIzquierdaJPanel(MoveProyeccion, 0, -230, 2);
		}
	}
	protected void mouseClickedBtnMoverDerechaProyeccion(MouseEvent e) {
		if(MoveProyeccion.getBounds().getX() == -228){
			
			MoverDerechaJPanel(MoveProyeccion, -228, 0, 2);
		}
	}
	protected void mouseClickedBtnMoverIzquierdaBocados(MouseEvent e) {
		if(MoveBocado.getBounds().getX() == 0){
			
			MoverIzquierdaJPanel(MoveBocado, 0, -236, 2);
		}
	}
	protected void mouseClickedBtnMoverDerechaBocados(MouseEvent e) {
		if(MoveBocado.getBounds().getX() == -236){
			
			MoverDerechaJPanel(MoveBocado, -236, 0, 2);
		}
	}
	void MinimizarTable(){
		if(TablaDeFactura.getBounds().getX() == 0){
			MoverIzquierdaJPanel(TablaDeFactura, 0, -364, 1);
		}
		if(TablaDeTicket.getBounds().getX() == 0){
			MoverIzquierdaJPanel(TablaDeTicket, 0, -364, 1);
		}
		//----
		if(PeliculasTable.getBounds().getY() == 248){
			Abajo(PeliculasTable, 248, 472, 1);
		}
		if(ProyeccionesTable.getBounds().getY() == 248){
			Abajo(ProyeccionesTable, 248, 472, 1);
		}
		if(BocadosTable.getBounds().getY() == 248){
			Abajo(BocadosTable, 248, 472, 1);
		}
	}
	protected void mouseClickedBtnCerrarPelicula(MouseEvent e) {
		PosicionesPanel();
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnCerrarProyeccion(MouseEvent e) {
		PosicionesPanel();
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnCerrarBocados(MouseEvent e) {
		PosicionesPanel();
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnCerrarCompra(MouseEvent e) {
		PosicionesPanel();
		MoverDerechaPaneles();
	}
	protected void mouseClickedBtnCerrarCliente(MouseEvent e) {
		PosicionesPanel();
		MoverDerechaPaneles();
	}
}
