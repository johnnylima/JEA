package view;

import controller.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthSeparatorUI;

import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.JDesktopPane;
import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.prism.image.ViewPort;

import Dominio.Pedido;
import Dominio.Produto;
import Dominio.Usuario;
import Enum.ECategoriaProduto;
import Enum.ETipoUsuario;
import Exceptions.LimiteMaximoException;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import sun.util.resources.cldr.ii.CalendarData_ii_CN;

import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.DebugGraphics;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.DropMode;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Component[] bnts;
	private Component[] telas;

	CarrinhoController carrinhoController = new CarrinhoController();
	ProdutoController produtoController = new ProdutoController();
	PedidoController pedidoController = new PedidoController();
	UsuarioController usuarioController = new UsuarioController();
	
	
	private Component[] camadaScroll;
	
	private JPanel pTela;
	private JTextField textCodigo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// SETANDO LOOKANDFELL (Nimbus, Metal, Windows

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
		// */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frameTelaPrincipal = new TelaPrincipal();
					frameTelaPrincipal.setLocationRelativeTo(frameTelaPrincipal.getParent());
					frameTelaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	public TelaPrincipal() {

		setResizable(false);
		setName("framePrincipal");

		// MINHA PALETA
		Color primary = new Color(30, 35, 54);
		Color fundo = new Color(40, 51, 80);
		Color roxoclaro = new Color(113, 113, 151);
		Color verde = new Color(38, 178, 127);
		Color roxoclaro2 = new Color(153, 154, 167);
		Color roxoclaro3 = new Color(165, 153, 203);
		Color roxoclaro4 = new Color(207, 209, 213);
		Color roxovermelho = new Color(201, 167, 181);

		// -------------------------------------------------------------------------------------------------------------------/

		// GERANDO PRODUTOS INICIAIS
		// -----------------------------------------------------------------------------------------/
		// no final >> crinaod os produtos na classe
		// TODO gerando produtos iniciais
		
		Usuario User = new Usuario("Gerente","123",ETipoUsuario.Gerente);
		Usuario User1 = new Usuario("Cliente1","123",ETipoUsuario.Cliente);
		Usuario User2 = new Usuario("Cliente2","123",ETipoUsuario.Cliente);
		usuarioController.Inserir(User);
		usuarioController.Inserir(User1);
		usuarioController.Inserir(User2);
		//Logar Usuario antes
		if(LoginController.Logar("Gerente", "123")) {
//			System.out.println("logado");
		}
		else
			System.out.println("erro ao logar");
		
		String[] Descricao = { "Burton", "Gwendolyn", "Acton", "Colt", "Kerry", "Briar", "Lawrence", "Preston", "Maite",
				"Ishmael", "Kyle", "Willa", "Evangeline", "Luke", "Fallon" };
		String[] Categoria = { "DVD", "CD", "CD", "LIVRO", "CD", "DVD", "LIVRO", "LIVRO", "CD", "LIVRO", "CD", "LIVRO",
				"LIVRO", "CD", "DVD" };
		int[] qtdEstoque = { 1, 0, 10, 25, 18, 21, 2, 11, 12, 1, 3, 4, 16, 40, 50 };
		String[] figuraLivro = { "/images/003-livro.png", "/images/002-dvd.png", "/images/001-cd.png" };
		;
		int a;
		for (int i = 0; i < Descricao.length; i++) {
			Produto prod = null;
			a = i + 1;
			if (Categoria[i] == "LIVRO") {
				prod = new Produto(Descricao[i], ECategoriaProduto.LIVRO, 30, qtdEstoque[i], figuraLivro[0]);
			} else if (Categoria[i] == "DVD") {
				prod = new Produto(Descricao[i], ECategoriaProduto.DVD, 25, qtdEstoque[i], figuraLivro[1]);
			} else if (Categoria[i] == "CD") {
				prod = new Produto(Descricao[i], ECategoriaProduto.CD, 10, qtdEstoque[i], figuraLivro[2]);
			}

			produtoController.Inserir(prod);

//									System.out.println(prod.getFigura());
		}
		

		setBackground(new Color(51, 102, 255));
		setFont(new Font("Calibri", Font.PLAIN, 12));
		setTitle("JJ Esta\u00E7\u00E3o de Autoatendimento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 617);
		contentPane = new JPanel();
		contentPane.setName("contentPanePrincipal");
		contentPane.setBackground(fundo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/logo.png")));
		logo.setBounds(0, 0, 218, 145);
		contentPane.add(logo);

		JLabel system = new JLabel("JJ ESTA\u00C7\u00C3O DE AUTOATENDIMENTO");
		system.setForeground(verde);
		system.setFont(new Font("Calibri", Font.ITALIC, 20));
		system.setBounds(276, 11, 387, 34);
		contentPane.add(system);

		JPanel menu = new JPanel();
		menu.setName("panelMenu");
		menu.setBackground(primary);
		menu.setBounds(0, 0, 222, 591);
		contentPane.add(menu);
		menu.setLayout(null);

		JPanel cabecalho = new JPanel();
		cabecalho.setName("cabecalho");
		cabecalho.setBackground(primary);
		cabecalho.setBounds(221, 56, 780, 91);
		contentPane.add(cabecalho);
		cabecalho.setLayout(null);

		JLabel titulo = new JLabel("T\u00EDtulo");
		titulo.setBounds(56, 11, 446, 69);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Calibri", Font.PLAIN, 50));
		cabecalho.add(titulo);
		cabecalho.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { titulo }));

		// -------------------------------------- PANELS

		pTela = new JPanel();
		pTela.setName("pTela");
		pTela.setBackground(fundo);
		pTela.setBounds(221, 147, 780, 444);
		contentPane.add(pTela);
		pTela.setLayout(null);
								
										JPanel Produtos = new JPanel();
										Produtos.setBounds(0, 0, 780, 444);
										pTela.add(Produtos);
										Produtos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
										Produtos.setAutoscrolls(true);
										Produtos.setName("Produtos");
										Produtos.setBackground(fundo);
										Produtos.setLayout(null);
										
												JScrollPane scrollProdutos = new JScrollPane();
												scrollProdutos.setName("scrollProdutos");
												scrollProdutos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
												scrollProdutos.setBorder(null);
												scrollProdutos.setBounds(-1, -1, 780, 444);
												scrollProdutos.getVerticalScrollBar().setUnitIncrement(16);
												Produtos.add(scrollProdutos);
												
														JPanel camadaProdutos = new JPanel();
														camadaProdutos.setName("camadaProdutos");
														camadaProdutos.setBackground(fundo);
														scrollProdutos.setViewportView(camadaProdutos);
														GridBagLayout gbl_camadaProdutos = new GridBagLayout();
														gbl_camadaProdutos.columnWidths = new int[] { 32, 150, 32, 150, 32, 150, 32, 150, 31 };
														gbl_camadaProdutos.rowHeights = new int[] { 30, 177, 30, 177, 30, 177, 30, 177, 30 };
														gbl_camadaProdutos.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
														gbl_camadaProdutos.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
														camadaProdutos.setLayout(gbl_camadaProdutos);
						
								JPanel Carrinho = new JPanel();
								Carrinho.setBounds(0, 0, 780, 444);
								pTela.add(Carrinho);
								Carrinho.setLayout(null);
								Carrinho.setName("Carrinho");
								Carrinho.setBackground(new Color(139, 69, 19));
								
										JScrollPane scrollCarrinho = new JScrollPane();
										scrollCarrinho.setName("scrollCarrinho");
										scrollCarrinho.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
										scrollCarrinho.setBorder(null);
										scrollCarrinho.setBounds(-1, 55, 780, 388);
										scrollCarrinho.getVerticalScrollBar().setUnitIncrement(16);
										
										JPanel controleCarrinho = new JPanel();
										controleCarrinho.setName("controleCarrinho");
										controleCarrinho.setLayout(null);
										controleCarrinho.setBounds(0, 0, 780, 56);
										Carrinho.add(controleCarrinho);
										
										JLabel lblValorTotal = new JLabel("Valor Total:       R$");
										lblValorTotal.setName("codigoPedido");
										lblValorTotal.setBounds(10, 16, 105, 24);
										controleCarrinho.add(lblValorTotal);
										
										
										JSeparator separator_2 = new JSeparator();
										separator_2.setOrientation(SwingConstants.VERTICAL);
										separator_2.setName("s1");
										separator_2.setBounds(220, 0, 3, 56);
										controleCarrinho.add(separator_2);
										
										JSeparator separator_3 = new JSeparator();
										separator_3.setOrientation(SwingConstants.VERTICAL);
										separator_3.setName("s2");
										separator_3.setBounds(409, 0, 3, 56);
										controleCarrinho.add(separator_3);
										
										
										JLabel labelValorTotal = new JLabel(String.valueOf(carrinhoController.getValorTotal()));
										labelValorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
										labelValorTotal.setHorizontalAlignment(SwingConstants.RIGHT);
										labelValorTotal.setHorizontalTextPosition(SwingConstants.RIGHT);
										labelValorTotal.setName("labelValorTotal");
										labelValorTotal.setBounds(125, 16, 72, 24);
										controleCarrinho.add(labelValorTotal);
										Carrinho.add(scrollCarrinho);
										
												JPanel camadaCarrinho = new JPanel();
												camadaCarrinho.setName("camadaCarrinho");
												camadaCarrinho.setBackground(new Color(40, 51, 80));
												scrollCarrinho.setViewportView(camadaCarrinho);
												GridBagLayout gbl_camadaCarrinho = new GridBagLayout();
												gbl_camadaCarrinho.columnWidths = new int[] { 32, 150, 32, 150, 32, 150, 32, 150, 31, 0 };
												gbl_camadaCarrinho.rowHeights = new int[] { 30, 177, 30, 177, 30, 177, 30, 177, 30, 0 };
												gbl_camadaCarrinho.columnWeights = new double[] { 0.0, 1.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
														Double.MIN_VALUE };
												gbl_camadaCarrinho.rowWeights = new double[] { 0.0, 1.0, 4.9E-324, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
														Double.MIN_VALUE };
												camadaCarrinho.setLayout(gbl_camadaCarrinho);
												
												JButton btnFinalizarCompra = new JButton("FINALIZAR COMPRA");
												btnFinalizarCompra.addMouseListener(new MouseAdapter() {
													//TODO FINALIZAR
													@Override //FINALIZAR
													public void mouseClicked(MouseEvent e) {
														try {
															
															if(!(carrinhoController.GetAll().isEmpty())) {
//												System.out.println("ko");
																pedidoController.Inserir(carrinhoController.GetAll());
																carrinhoController.zerarValorTotal();
																labelValorTotal.setText(String.valueOf(carrinhoController.getValorTotal()));
																
																carrinhoController.ExcluirTodos();
																
																repaintAllCamadas();
																
																
															}
															
														} catch (LimiteMaximoException e1) {
															JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", 2);
														}
													}
												});
												btnFinalizarCompra.setName("btnFinalizarCompra");
												btnFinalizarCompra.setBounds(233, 16, 166, 24);
												controleCarrinho.add(btnFinalizarCompra);
				
						JPanel Cadastrar = new JPanel();
						Cadastrar.setName("Cadastrar");
						Cadastrar.setBackground(fundo);
						Cadastrar.setAlignmentY(1.0f);
						Cadastrar.setAlignmentX(1.0f);
						Cadastrar.setBounds(0, 0, 780, 444);
						pTela.add(Cadastrar);
						Cadastrar.setLayout(null);
						
						JPanel controleCadastrar = new JPanel();
						controleCadastrar.setLayout(null);
						controleCadastrar.setName("controleCadastrar");
						controleCadastrar.setBounds(0, 0, 780, 56);
						Cadastrar.add(controleCadastrar);
						
						JSeparator separator_4 = new JSeparator();
						separator_4.setOrientation(SwingConstants.VERTICAL);
						separator_4.setName("s1");
						separator_4.setBounds(220, 0, 3, 56);
						controleCadastrar.add(separator_4);
						
						JButton btnCadastrar = new JButton("CADASTRAR");
						btnCadastrar.setName("btnFinalizarCompra");
						btnCadastrar.setBounds(29, 15, 166, 24);
						controleCadastrar.add(btnCadastrar);
						
						JPanel panel = new JPanel();
						panel.setBounds(225, 66, 330, 364);
						Cadastrar.add(panel);

		JPanel Consultar = new JPanel();
		Consultar.setBounds(0, 0, 780, 444);
		pTela.add(Consultar);
		Consultar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Consultar.setAutoscrolls(true);
		Consultar.setName("Consultar");
		Consultar.setBackground(fundo);
		Consultar.setLayout(null);

		JScrollPane scrollConsultar = new JScrollPane();
		scrollConsultar.setName("scrollConsultar");
		scrollConsultar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollConsultar.setBorder(null);
		scrollConsultar.setBounds(-1, 55, 780, 388);
		scrollConsultar.getVerticalScrollBar().setUnitIncrement(16);

		JPanel controleConsultar = new JPanel();
		controleConsultar.setBounds(-1, -1, 780, 56);
		Consultar.add(controleConsultar);
		controleConsultar.setLayout(null);

		JLabel codigoPedido = new JLabel("C\u00F3dido do Pedido:");
		codigoPedido.setBounds(10, 16, 105, 24);
		codigoPedido.setName("codigoPedido");
		controleConsultar.add(codigoPedido);


		JSeparator separator = new JSeparator();
		separator.setName("s1");
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(260, 0, 3, 56);
		controleConsultar.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setName("s2");
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(409, 0, 3, 56);
		controleConsultar.add(separator_1);
		Consultar.add(scrollConsultar);

		JPanel camadaConsultar = new JPanel();
		camadaConsultar.setName("camadaConsultar");
		camadaConsultar.setBackground(fundo);
		scrollConsultar.setViewportView(camadaConsultar);
		GridBagLayout gbl_camadaConsultar = new GridBagLayout();
		gbl_camadaConsultar.columnWidths = new int[] { 32, 150, 32, 150, 32, 150, 32, 150, 31 };
		gbl_camadaConsultar.rowHeights = new int[] { 30, 177, 30, 177, 30, 177, 30, 177, 30 };
		gbl_camadaConsultar.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_camadaConsultar.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		camadaConsultar.setLayout(gbl_camadaConsultar);
		
		textCodigo = new JTextField();
		textCodigo.setToolTipText("Digite o c\u00F3digo e pressione ENTER");
		textCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(((JTextField) e.getSource()).getText().trim().equals("") || (pedidoController.getPedido(((JTextField) e.getSource()).getText())==null)) JOptionPane.showMessageDialog(null, "Digite um código válido.","CÓDIGO INVÁLIDO",2);
				else {

					repaintAllCamadas();
					addPedidoCamada((pedidoController.getPedido(((JTextField) e.getSource()).getText())), camadaConsultar);
				}
				((JTextField) e.getSource()).setText("");			
//				JOptionPane.showMessageDialog(null, ((JTextField) e.getSource()).getText());
			}
		});
		textCodigo.setBounds(115, 14, 135, 30);
		textCodigo.setName("textCodigo");
		controleConsultar.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnTodos = new JButton("LISTAR TODOS");
		btnTodos.addMouseListener(new MouseAdapter() {
			@Override // LISTAR TODOS
			public void mouseClicked(MouseEvent e) {
				repaintAllCamadas();
				addPedidosCamada(pedidoController.GetAll(), camadaConsultar);
			}
		});
		btnTodos.setName("btnTodos");
		btnTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTodos.setBounds(278, 16, 121, 24);
		controleConsultar.add(btnTodos);

		// TODO PANELS = PEDIDO
		/*
		 * JPanel pedido = new JPanel(); pedido.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent arg0) { } });
		 * pedido.setName("pedido"); GridBagConstraints gbc_pedido = new
		 * GridBagConstraints(); gbc_pedido.fill = GridBagConstraints.BOTH;
		 * gbc_pedido.insets = new Insets(0, 0, 5, 5); gbc_pedido.gridx = 1;
		 * gbc_pedido.gridy = 3; camadaConsultar.add(pedido, gbc_pedido);
		 * pedido.setBackground(Color.WHITE); pedido.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64,
		 * 64), Color.WHITE, null));
		 * pedido.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		 * pedido.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 * pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 * pedido.setLayout(new BoxLayout(pedido, BoxLayout.PAGE_AXIS));
		 * 
		 * JLabel pedidoNumero = new JLabel("PEDIDO 10");
		 * pedidoNumero.setName("pedidoNumero"); pedidoNumero.setMaximumSize(new
		 * Dimension(150, 43));
		 * pedidoNumero.setHorizontalAlignment(SwingConstants.CENTER);
		 * pedidoNumero.setForeground(Color.RED); pedidoNumero.setFont(new
		 * Font("Tahoma", Font.BOLD, 14)); pedidoNumero.setAlignmentX(0.5f);
		 * pedido.add(pedidoNumero);
		 * 
		 * JLabel labelCodigo = new JLabel("C\u00D3DIGO");
		 * labelCodigo.setVerticalAlignment(SwingConstants.BOTTOM);
		 * labelCodigo.setName("labelCodigo"); labelCodigo.setMaximumSize(new
		 * Dimension(150, 33)); labelCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * labelCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		 * pedido.add(labelCodigo);
		 * 
		 * JLabel codigo = new JLabel("1524"); codigo.setForeground(Color.BLUE);
		 * codigo.setFont(new Font("Tahoma", Font.BOLD, 11)); codigo.setName("codigo");
		 * codigo.setMaximumSize(new Dimension(150, 33));
		 * codigo.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * codigo.setHorizontalAlignment(SwingConstants.CENTER); pedido.add(codigo);
		 * 
		 * JLabel labelValorTotal = new JLabel("VALOR TOTAL");
		 * labelValorTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		 * labelValorTotal.setName("labelValorTotal");
		 * labelValorTotal.setMaximumSize(new Dimension(150, 33));
		 * labelValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		 * labelValorTotal.setAlignmentX(0.5f); pedido.add(labelValorTotal);
		 * 
		 * JLabel valorTotal = new JLabel("R$ 10"); valorTotal.setFont(new
		 * Font("Tahoma", Font.BOLD, 11)); valorTotal.setForeground(new Color(0, 128,
		 * 0)); valorTotal.setMaximumSize(new Dimension(150, 33));
		 * valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		 * valorTotal.setAlignmentX(0.5f); pedido.add(valorTotal);
		 * pedido.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
		 * labelCodigo, codigo })); //
		 */

		// TODO @MENUS
		JPanel b2 = new JPanel();
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.addMouseListener(new MouseAdapter() {
			// TODO CARRINHO
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(e.getComponent(), telas);
				setTela(roxoclaro2, e.getComponent(), titulo, cabecalho, bnts);
				addProdutoCamada(carrinhoController.GetAll(), camadaCarrinho);
			}
		});

		JPanel b1 = new JPanel();
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.addMouseListener(new MouseAdapter() {
			// TODO PRODUTO
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(e.getComponent(), telas);
				setTela(roxoclaro, e.getComponent(), titulo, cabecalho, bnts);
				addProdutoCamada(produtoController.GetAll(), camadaProdutos);
			}
		});
		b1.setBackground(primary);
		b1.setBounds(0, 146, 221, 56);
		menu.add(b1);
		b1.setLayout(null);

		JLabel l1 = new JLabel("Produtos");
		l1.setBounds(89, 11, 122, 34);
		b1.add(l1);
		l1.setHorizontalAlignment(SwingConstants.LEFT);
		l1.setFont(new Font("Calibri", l1.getFont().getStyle(), l1.getFont().getSize() + 3));
		l1.setForeground(roxoclaro4);

		JPanel bd1 = new JPanel();
		bd1.setBackground(primary);
		FlowLayout fl_bd1 = (FlowLayout) bd1.getLayout();
		bd1.setBounds(0, 0, 5, 56);
		b1.add(bd1);

		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(34, 11, 32, 34);
		b1.add(label);
		label.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/004-laptop.png")));
		b2.setLayout(null);
		b2.setBackground(primary);
		b2.setBounds(0, 202, 221, 56);
		menu.add(b2);

		JLabel l2 = new JLabel("Carrinho");
		l2.setHorizontalAlignment(SwingConstants.LEFT);
		l2.setForeground(roxoclaro4);
		l2.setBounds(90, 11, 122, 34);
		b2.add(l2);

		JPanel bd2 = new JPanel();
		bd2.setBackground(primary);
		bd2.setBounds(0, 0, 5, 56);
		b2.add(bd2);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/001-shopping-cart.png")));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(33, 11, 32, 34);
		b2.add(label_1);

		JPanel b3 = new JPanel();
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b3.addMouseListener(new MouseAdapter() {
			// TODO CONSULTAR
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(e.getComponent(), telas);
				setTela(roxoclaro3, e.getComponent(), titulo, cabecalho, bnts);
				repaintAllCamadas();
			}
		});
		b3.setLayout(null);
		b3.setBackground(primary);
		b3.setBounds(0, 258, 221, 56);
		menu.add(b3);

		JLabel l3 = new JLabel("Consultar");
		l3.setHorizontalAlignment(SwingConstants.LEFT);
		l3.setForeground(roxoclaro4);
		l3.setBounds(90, 11, 122, 34);
		b3.add(l3);

		JPanel bd3 = new JPanel();
		bd3.setBackground(primary);
		bd3.setBounds(0, 0, 5, 56);
		b3.add(bd3);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/002-document.png")));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(35, 11, 32, 34);
		b3.add(label_2);

		// LOGIN
		Login tlm = new Login();

		JPanel b4 = new JPanel();
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b4.addMouseListener(new MouseAdapter() {
			// TODO LOGAR
			@Override
			public void mouseClicked(MouseEvent e) {
				// setVisible(e.getComponent(), telas);
				// setTela(roxoclaro4, e.getComponent(), titulo, cabecalho, bnts);

				if (tlm.session()) {
					((JLabel) ((JPanel) e.getComponent()).getComponent(0)).setText("Logar");
					tlm.setSession();
				} else {
					((JPanel) e.getComponent()).setEnabled(false);
					tlm.setVisible(true);
					if (tlm.session())
						((JLabel) ((JPanel) e.getComponent()).getComponent(0)).setText("Logoff | " + tlm.getLogin());
					((JPanel) e.getComponent()).setEnabled(true);
				}

			}
		});
		b4.setLayout(null);
		b4.setBackground(new Color(30, 35, 54));
		b4.setBounds(0, 524, 221, 56);
		menu.add(b4);

		JLabel l4 = new JLabel("Logar");
		l4.setHorizontalAlignment(SwingConstants.LEFT);
		l4.setForeground(new Color(207, 209, 213));
		l4.setBounds(90, 11, 122, 34);
		b4.add(l4);

		JPanel bd4 = new JPanel();
		bd4.setBackground(new Color(30, 35, 54));
		bd4.setBounds(0, 0, 5, 56);
		b4.add(bd4);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/003-user.png")));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(35, 11, 32, 34);
		b4.add(label_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(30, 35, 54));
		panel_1.setBounds(0, 312, 221, 56);
		menu.add(panel_1);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrar.setForeground(new Color(207, 209, 213));
		lblCadastrar.setBounds(90, 11, 122, 34);
		panel_1.add(lblCadastrar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 35, 54));
		panel_2.setBounds(0, 0, 5, 56);
		panel_1.add(panel_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/001-shopping-cart.png")));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(33, 11, 32, 34);
		panel_1.add(label_6);

		/*
		 * copy paste
		 */

//		for(Produtos p: listaProdutos) System.out.println(p.getDescricao());

		// no final >>
		/*******************************
		 * CRIANDO PRODUTO POR CLASSE
		 *********************************/
		// */

		/*
		 JPanel PRODUTO1 = new JPanel(); PRODUTO1.setName("produto");
		 GridBagConstraints gbc_PRODUTO1 = new GridBagConstraints(); gbc_PRODUTO1.fill
		 = GridBagConstraints.BOTH; gbc_PRODUTO1.insets = new Insets(0, 0, 5, 5);
		 gbc_PRODUTO1.gridx = 1; gbc_PRODUTO1.gridy = 1; camadaCarrinho.add(PRODUTO1,
		 gbc_PRODUTO1); PRODUTO1.setBackground(Color.WHITE); PRODUTO1.setBorder(new
		 BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64,
		 64), Color.WHITE, null));
		 PRODUTO1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		 PRODUTO1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 PRODUTO1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 PRODUTO1.setLayout(new BoxLayout(PRODUTO1, BoxLayout.PAGE_AXIS));
		 
		 JLabel close = new JLabel(""); close.addMouseListener(new MouseAdapter() {
		 
		 @Override public void mouseClicked(MouseEvent e) { } });
		 close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 close.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 close.setAlignmentX(Component.CENTER_ALIGNMENT);
		 close.setAlignmentY(Component.BOTTOM_ALIGNMENT); close.setIconTextGap(1);
		 close.setName("close"); close.setIcon(new
		 ImageIcon(TelaPrincipal.class.getResource("/images/close.png")));
		 close.setMaximumSize(new Dimension(16, 24));
		 close.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO1.add(close);
		 
		 JLabel label_3 = new JLabel(""); label_3.setName("figura");
		 label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		 label_3.setHorizontalAlignment(SwingConstants.CENTER); label_3.setIcon(new
		 ImageIcon(TelaPrincipal.class.getResource("/images/003-livro.png")));
		 PRODUTO1.add(label_3);
		 
		 JLabel lblLivro = new JLabel("LIVRO 01"); lblLivro.setMaximumSize(new
		 Dimension(132, 25)); lblLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
		 lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
		 PRODUTO1.add(lblLivro);
		 
		 JLabel lblR = new JLabel("R$ 10"); lblR.setMaximumSize(new Dimension(132,
		 25)); lblR.setAlignmentX(Component.CENTER_ALIGNMENT);
		 lblR.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO1.add(lblR);
		 
		 JButton btnNewButton = new JButton("Adicionar"); //
		 PRODUTO1.add(btnNewButton);
		 btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		 
		 JSpinner spinner = new JSpinner(); 
		 spinner.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent arg0) {
		 	}
		 });spinner.setModel(new SpinnerNumberModel(1,
		 1, 20, 1)); spinner.setMaximumSize(new Dimension(60, 25));
		 PRODUTO1.add(spinner); PRODUTO1.setFocusTraversalPolicy( new
		 FocusTraversalOnArray(new Component[] { label_3, lblLivro, lblR })); // //
		 //*/

		/*******************************
		 * CRIANDO PRODUTO POR CLASSE
		 *********************************/

		// no final >> COLETANDO TODOS OS BOTÕES DE MENU
		bnts = menu.getComponents();

		// no final >> COLETANDO TODAS AS TELAS
		telas = pTela.getComponents();

		// TODAS AS TELAS INVISIVEIS
		for (Component tela : telas)
			tela.setVisible(false);
		
		camadaScroll = pTela.getComponents();

	}

	/******************** SETTELA ******************/
	private void setTela(Color c, Component bnt, JLabel titulo, Component cabecalho, Component[] bnts) {

		// MUDANDO TÍTULO
		JLabel l = (JLabel) ((JPanel) bnt).getComponent(0);
		/*
		 * l.setForeground(new Color(0,0,0)); System.out.println(l.getText());//
		 */
		titulo.setText(l.getText());

		// MUDAR COR CABECALHO
		cabecalho.setBackground(c);

		// ATIVANDO COR DO BOTÃO
		activeColor(bnt, bnts);
		// System.out.println(bnts.length);

		// TELA VISÍVEL
		// telaVisible(telas)
	}

	/******************** SETTELA ******************/
	private void setVisible(Component bnt, Component[] telas) {
		for (Component t : telas) {
//			System.out.println(((JPanel) t).getName());
//			System.out.println(((JLabel) ((JPanel) bnt).getComponent(0)).getText());
			if (((JPanel) t).getName().equals(((JLabel) ((JPanel) bnt).getComponent(0)).getText())) {
				((JPanel) t).setVisible(true);
			} else
				((JPanel) t).setVisible(false);
		}
	}

	/******************** ACTIVECOLOR ******************/
	private void activeColor(Component bnt, Component[] bnts) {
		JPanel b;

		Color c = new Color(30, 35, 54);
		Color e = new Color(38, 178, 127);
		Color f = new Color(240, 255, 255);
		for (Component a : bnts) {
			a.setBackground(c);
			// getComponent(1) = bd_n
			((JPanel) a).getComponent(1).setBackground(c);
			;
		}

		bnt.setBackground(e);
		// getComponent(1) = bd_n
		((JPanel) bnt).getComponent(1).setBackground(f);
		;
	}

	/******************** PRODUTO ******************/

	private void addProdutoCard(String nomeProduto, // nProduto="produto1"
			JPanel scroll, // scroll
			int gx, int gy, // gx=1, gy=5
			String nomeFigura, // nomeFigura="figura1"
			String pNomeDescricao, // pNomeDescricao="descProtudo1"
			String nomeBotao, // nomeBotao="adicionar1"
			String nomeSpinner, // nomeSpinner="spinner1"
			Produto p) {

		// ------------------------------------------------------------------------------------------------------------------------------/
		// TODO PRODUTO

		String rootFigura = p.getFigura();
		String pDescricao = p.getDescricao();
		String pPreco = Integer.toString(p.getValor());

		JPanel produto = new JPanel();
		produto.setName(nomeProduto);// nomeProduto="produto1"
		GridBagConstraints gbc_produto = new GridBagConstraints();
		gbc_produto.fill = GridBagConstraints.BOTH;
		gbc_produto.insets = new Insets(0, 0, 5, 5);
		gbc_produto.gridx = gx;// gx=1, gy=5
		gbc_produto.gridy = gy;// gx=1, gy=5
		scroll.add(produto, gbc_produto);// scroll
		scroll.revalidate();
		scroll.repaint();
		produto.setBackground(Color.WHITE);
		produto.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64, 64),
				Color.WHITE, null));
		produto.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		produto.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		produto.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		produto.setLayout(new BoxLayout(produto, BoxLayout.PAGE_AXIS));
		
		

		if (scroll.getName() == "camadaCarrinho") {
			JLabel close = new JLabel("");
			close.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
//					JOptionPane.showMessageDialog(null, e.getComponent().getName());
					

					carrinhoController.Excluir(p);
					
					if (scroll.getName() == "camadaCarrinho") {
						JPanel controle = (JPanel) scroll.getParent().getParent().getParent().getComponent(0);
						for(Component c: controle.getComponents()) {
							if(c.getName().equals("labelValorTotal")) {
								JLabel a= (JLabel) c;
//								System.out.println(a.getText());
								carrinhoController.setValorTotal(carrinhoController.GetAll());
								a.setText(String.valueOf(carrinhoController.getValorTotal()));
							}
						}
					}
					

					repaintAllCamadas();
					
					addProdutoCamada(carrinhoController.GetAll(), scroll);

//					System.out.println(p.estoqueQtd());

				}
			});
			close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			close.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			close.setAlignmentX(Component.CENTER_ALIGNMENT);
			close.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			close.setIconTextGap(1);
			close.setName("close");
			close.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/images/close.png")));
			close.setMaximumSize(new Dimension(16, 24));
			close.setHorizontalAlignment(SwingConstants.CENTER);
			produto.add(close);
		}

		JLabel figura = new JLabel("");
		figura.setName(nomeFigura);// nomeFigura="figura1"
		figura.setAlignmentX(Component.CENTER_ALIGNMENT);
		figura.setHorizontalAlignment(SwingConstants.CENTER);
		figura.setIcon(new ImageIcon(TelaPrincipal.class.getResource(rootFigura)));// rootFigura="/images/003-livro.png"
		produto.add(figura);

		JLabel descricao = new JLabel(pDescricao);// pDescricao="LIVRO 01"
		descricao.setName(pNomeDescricao);// pNomeDescricao="descProtudo1"
		descricao.setMaximumSize(new Dimension(132, 25));
		descricao.setAlignmentX(Component.CENTER_ALIGNMENT);
		descricao.setHorizontalAlignment(SwingConstants.CENTER);
		produto.add(descricao);

		JLabel preco = new JLabel(pPreco);// pPreco="R$ 10"
		preco.setMaximumSize(new Dimension(132, 25));
		preco.setAlignmentX(Component.CENTER_ALIGNMENT);
		preco.setHorizontalAlignment(SwingConstants.CENTER);
		produto.add(preco);

		if (scroll.getName() == "camadaCarrinho") {
			JSpinner spinner = new JSpinner();
			 spinner.addChangeListener(new ChangeListener() {
				 
			 	public void stateChanged(ChangeEvent e) {
			 		
//			 		int anterior = ((int)(((JSpinner)e.getSource()).getPreviousValue()));
			 		int atual = ((int)(((JSpinner)e.getSource()).getValue()));
			 		
			 		//QUANTIDADE VENDIDA
			 		p.setQuantidadeVendida(atual);
					carrinhoController.setValorTotal(carrinhoController.GetAll());
					
					if (scroll.getName() == "camadaCarrinho") {
						JPanel controle = (JPanel) scroll.getParent().getParent().getParent().getComponent(0);
						for(Component c: controle.getComponents()) {
							if(c.getName().equals("labelValorTotal")) {
								JLabel a= (JLabel) c;
//								System.out.println(a.getText());
								a.setText(String.valueOf(carrinhoController.getValorTotal()));
							}
						}
					}
			 		
			 	}
			 });
			spinner.setName(nomeSpinner);// nomeSpinner="spinner1"
			spinner.setModel(new SpinnerNumberModel(p.getQuantidadeVendida(), 1, p.getQuantidadeDisponivel(), 1));
			spinner.setMaximumSize(new Dimension(60, 25));
			
			produto.add(spinner);
		}
		
		if (scroll.getName() == "camadaProdutos") {
			
			JButton botao = new JButton("Adicionar");
			botao.setName(nomeBotao);// nomeBotao="adicionar1"
			botao.addMouseListener(new MouseAdapter() {
				// TODO BOTÃO ADICIONAR
				@Override
				public void mouseClicked(MouseEvent e) {
						
						if(!(carrinhoController.GetAll().contains(p))) { //se o produto não estiver dentro do carrinho ele adiciona
							
							//QUANTIDADE VENDIDA
							p.setQuantidadeVendida(1);
									
							carrinhoController.Inserir(p);
							carrinhoController.setValorTotal(carrinhoController.GetAll());
							

							repaintAllCamadas();
							
							addProdutoCamada(produtoController.GetAll(), scroll);
						}
//						else System.out.println("já tem");
				}
				
			});
			
			if(p.getQuantidadeDisponivel() < 1) {
				JLabel indisponivel = new JLabel("Indisponivel");
				indisponivel.setMaximumSize(new Dimension(132, 25));
				indisponivel.setAlignmentX(Component.CENTER_ALIGNMENT);
				indisponivel.setHorizontalAlignment(SwingConstants.CENTER);
				produto.add(indisponivel);
			} else {
				produto.add(botao);
			}
			
			botao.setAlignmentX(Component.CENTER_ALIGNMENT);

			produto.setFocusTraversalPolicy(
					new FocusTraversalOnArray(new Component[] { figura, descricao, preco, botao }));
		}

		if (scroll.getName() == "camadaConsultar") {
			String qtde = "QTD: " + (p.getQuantidadeVendida());
			JLabel qtd = new JLabel(qtde);// pPreco="R$ 10"
			qtd.setMaximumSize(new Dimension(132, 25));
			qtd.setAlignmentX(Component.CENTER_ALIGNMENT);
			qtd.setHorizontalAlignment(SwingConstants.CENTER);
			produto.add(qtd);
		}
		
		if (scroll.getName() == "camadaCarrinho") {
			JPanel controle = (JPanel) scroll.getParent().getParent().getParent().getComponent(0);
			for(Component c: controle.getComponents()) {
				if(c.getName().equals("labelValorTotal")) {
					JLabel a= (JLabel) c;
//					System.out.println(a.getText());
					a.setText(String.valueOf(carrinhoController.getValorTotal()));
				}
			}
		}

		produto.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { figura, descricao, preco }));
		// ------------------------------------------------------------------------------------------------------------------------------------------------/

	}

	// CAMADA CARRINHO
	public void addProdutoCamada(ArrayList<Produto> p, JPanel camada) {
		String nomeProduto = "produto";
		String nomeFigura = "figura";
		String pNomeDescricao = "descProtudo";
//		String pPreco="R$ 10";
		String nomeBotao = "botao";
		String nomeSpinner = "spinner";

		int i = 0;
		for (int x = 1; x <= 7; x += 2) {
			for (int y = 1; y <= 7; y += 2) {

				if (i < p.size())
					addProdutoCard(nomeProduto + i, camada, y, x, nomeFigura + i, pNomeDescricao + i, nomeBotao + i,
							nomeSpinner + i, p.get(i));
				i++;
			}

		}
	}

	/******************** PEDIDO ******************/

	private void addPedidoCard(String nomePedido, // nProduto="pedido1"
			JPanel scroll, // scroll
			int gx, int gy, // gx=1, gy=5
			String numeroPedido, // numeroPedido="PEDIDO 10"
			String pNumeroPedido, // pNumeroPedido="pedidoNumero1"
			String lCodigo, // labelCodigo="labelCodigo1"
			String lValorTotal, // labelValorTotal="labelValorTotal1"
			Pedido p) {

		// ------------------------------------------------------------------------------------------------------------------------------/
		// TODO PEDIDO

		String cod = String.valueOf(p.getCodigo());
		String vTotal = "R$ " + (String.valueOf(p.getValorTotal()));

		JPanel pedido = new JPanel();
		pedido.addMouseListener(new MouseAdapter() {
			@Override // PEDIDO
			public void mouseClicked(MouseEvent e) {
				repaintAllCamadas();
				addProdutoCamada(p.getProdutos(), scroll);
			}
		});
		pedido.setName(nomePedido);
		GridBagConstraints gbc_pedido = new GridBagConstraints();
		gbc_pedido.fill = GridBagConstraints.BOTH;
		gbc_pedido.insets = new Insets(0, 0, 5, 5);
		gbc_pedido.gridx = gx;
		gbc_pedido.gridy = gy;
		scroll.add(pedido, gbc_pedido);
		pedido.setBackground(Color.WHITE);
		pedido.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64, 64),
				Color.WHITE, null));
		pedido.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		pedido.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pedido.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pedido.setLayout(new BoxLayout(pedido, BoxLayout.PAGE_AXIS));

		JLabel pedidoNumero = new JLabel(numeroPedido);
		pedidoNumero.setName(pNumeroPedido);
		pedidoNumero.setMaximumSize(new Dimension(150, 43));
		pedidoNumero.setHorizontalAlignment(SwingConstants.CENTER);
		pedidoNumero.setForeground(Color.RED);
		pedidoNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		pedidoNumero.setAlignmentX(0.5f);
		pedido.add(pedidoNumero);

		JLabel labelCodigo = new JLabel("C\u00D3DIGO");
		labelCodigo.setVerticalAlignment(SwingConstants.BOTTOM);
		labelCodigo.setName(lCodigo);
		labelCodigo.setMaximumSize(new Dimension(150, 33));
		labelCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		pedido.add(labelCodigo);

		JLabel codigo = new JLabel(cod);
		codigo.setForeground(Color.BLUE);
		codigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		codigo.setName("codigo");
		codigo.setMaximumSize(new Dimension(150, 33));
		codigo.setAlignmentX(Component.CENTER_ALIGNMENT);
		codigo.setHorizontalAlignment(SwingConstants.CENTER);
		pedido.add(codigo);

		JLabel labelValorTotal = new JLabel("VALOR TOTAL");
		labelValorTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		labelValorTotal.setName(lValorTotal);
		labelValorTotal.setMaximumSize(new Dimension(150, 33));
		labelValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		labelValorTotal.setAlignmentX(0.5f);
		pedido.add(labelValorTotal);

		JLabel valorTotal = new JLabel(vTotal);
		valorTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		valorTotal.setForeground(new Color(0, 128, 0));
		valorTotal.setMaximumSize(new Dimension(150, 33));
		valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotal.setAlignmentX(0.5f);
		pedido.add(valorTotal);
		pedido.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { labelCodigo, codigo }));

		// ------------------------------------------------------------------------------------------------------------------------------------------------/

	}

	// CAMADA CONSULTAR
	public void addPedidosCamada(ArrayList<Pedido> p, JPanel camada) {
		String nomePedido = "pedido";
		String numeroPedido = "PEDIDO ";
		String pNumeroPedido = "pedidoNumero";
		String lCodigo = "labelCodigo";
		String lValorTotal = "labelValorTotal";

		int i = 0;
		for (int x = 1; x <= 7; x += 2) {
			for (int y = 1; y <= 7; y += 2) {

				if (i < p.size())
					addPedidoCard(nomePedido + i, camada, y, x, numeroPedido + (i + 1), pNumeroPedido + i, lCodigo + i,
							lValorTotal + i, p.get(i));
				i++;
			}

		}
	}
	// CAMADA CONSULTAR
	public void addPedidoCamada(Pedido p, JPanel camada) {
		String nomePedido = "pedido";
		String numeroPedido = "PEDIDO ";
		String pNumeroPedido = "pedidoNumero";
		String lCodigo = "labelCodigo";
		String lValorTotal = "labelValorTotal";

		int i = 0;
		for (int x = 1; x <= 7; x += 2) {
			for (int y = 1; y <= 7; y += 2) {

				if (i < 1)
					addPedidoCard(nomePedido + i, camada, y, x, numeroPedido + (i + 1), pNumeroPedido + i, lCodigo + i,
							lValorTotal + i, p);
				i++;
			}

		}
	}
		
	
	public void repaintAllCamadas() {
		for(Component x: camadaScroll) {
			JPanel a = (JPanel) x;
			for(Component s: a.getComponents()) {
//				System.out.println("s = " + s.getName());
				if(s instanceof JScrollPane) {
					JViewport u = ((JScrollPane) s).getViewport();
					JPanel scroll = (JPanel)u.getView();
					
					scroll.removeAll();
					scroll.revalidate();
					scroll.repaint();
//					System.out.println(scroll.getName());
				}
			}
//			System.out.println(a.getComponentCount());
		}
		
//		for(JPanel scroll: c) {
//			scroll.removeAll();
//			scroll.revalidate();
//			scroll.repaint();
//		}
	}
	
}// final