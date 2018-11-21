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

import Enum.ECategoriaProduto;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
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

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private Component[] bnts;
	private Component[] telas;

	// CARRINHO
	Carrinho carrinho = new Carrinho();
	Loja loja = new Loja();
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
				prod = new Produto(Descricao[i], ECategoriaProduto.LIVRO, 30.0, qtdEstoque[i], figuraLivro[0]);
			} else if (Categoria[i] == "DVD") {
				prod = new Produto(Descricao[i], ECategoriaProduto.DVD, 25.0, qtdEstoque[i], figuraLivro[1]);
			} else if (Categoria[i] == "CD") {
				prod = new Produto(Descricao[i], ECategoriaProduto.CD, 10.0, qtdEstoque[i], figuraLivro[2]);
			}

			loja.addProduto(prod);

//									System.out.println(prod.getFigura());
		}

		// GERANDO PRODUTOS INICIAIS
		// -----------------------------------------------------------------------------------------/

		// GERANDO PEDIDOS FAKE
		// -----------------------------------------------------------------------------------------/
		// no final >> crinaod os produtos na classe
		// TODO gerando produtos iniciais

		String[] pedidoDescricao = { "Burton", "Gwendolyn", "Acton", "Colt", "Kerry", "Briar", "Lawrence", "Preston",
				"Maite", "Ishmael", "Kyle", "Willa", "Evangeline", "Luke", "Fallon" };
		String[] pedidoCategoria = { "DVD", "CD", "CD", "LIVRO", "CD", "DVD", "LIVRO", "LIVRO", "CD", "LIVRO", "CD",
				"LIVRO", "LIVRO", "CD", "DVD" };
		int[] quantidadeComprada = { 1, 3, 2, 2, 1, 2, 2, 1, 1, 1, 3, 4, 6, 4, 5 };
		String[] pedidofiguraLivro = { "/images/003-livro.png", "/images/002-dvd.png", "/images/001-cd.png" };

		Pedido pedido1 = new Pedido();
		Pedido pedido2 = new Pedido();
		Pedido pedido3 = new Pedido();

		int b, vTotal = 0;
		for (int i = 0; i < 5; i++) {
			Produto prod = null;
			b = i + 1;
			if (pedidoCategoria[i] == "LIVRO") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.LIVRO, 30, quantidadeComprada[i],
						pedidofiguraLivro[0]);
				vTotal += 30 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "DVD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.DVD, 25, quantidadeComprada[i],
						pedidofiguraLivro[1]);
				vTotal += 25 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "CD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.CD, 10, quantidadeComprada[i],
						pedidofiguraLivro[2]);
				vTotal += 10 * quantidadeComprada[i];
			}
			pedido1.addProduto(prod);
		}
		pedido1.setValorTotal(vTotal);

		b = 0;
		vTotal = 0;
		for (int i = 5; i < 7; i++) {
			Produto prod = null;
			b = i + 1;
			if (pedidoCategoria[i] == "LIVRO") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.LIVRO, 30, quantidadeComprada[i],
						pedidofiguraLivro[0]);
				vTotal += 30 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "DVD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.DVD, 25, quantidadeComprada[i],
						pedidofiguraLivro[1]);
				vTotal += 25 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "CD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.CD, 10, quantidadeComprada[i],
						pedidofiguraLivro[2]);
				vTotal += 10 * quantidadeComprada[i];
			}

			pedido2.addProduto(prod);
		}
		pedido2.setValorTotal(vTotal);

		b = 0;
		vTotal = 0;
		for (int i = 7; i < 15; i++) {
			Produto prod = null;
			b = i + 1;
			if (pedidoCategoria[i] == "LIVRO") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.LIVRO, 30, quantidadeComprada[i],
						pedidofiguraLivro[0]);
				vTotal += 30 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "DVD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.DVD, 25, quantidadeComprada[i],
						pedidofiguraLivro[1]);
				vTotal += 25 * quantidadeComprada[i];
			} else if (pedidoCategoria[i] == "CD") {
				prod = new Produto(pedidoDescricao[i], ECategoriaProduto.CD, 10, quantidadeComprada[i],
						pedidofiguraLivro[2]);
				vTotal += 10 * quantidadeComprada[i];
			}

			pedido3.addProduto(prod);
		}
		pedido3.setValorTotal(vTotal);

		Pedidos allPedidos = new Pedidos();
		allPedidos.addPedido(pedido1);
		allPedidos.addPedido(pedido2);
		allPedidos.addPedido(pedido3);

		// GERANDO PEDIDOS FAKE
		// -----------------------------------------------------------------------------------------/

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

		JPanel BfinalizarCompra = new JPanel();
		BfinalizarCompra.setBorder(new LineBorder(Color.WHITE));
		BfinalizarCompra.setBackground(primary);
		BfinalizarCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		BfinalizarCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setBackground(verde);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				e.getComponent().setBackground(primary);
			}
		});
		BfinalizarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BfinalizarCompra.setName("bFinalizarCompra");
		BfinalizarCompra.setLayout(null);
		BfinalizarCompra.setBackground(new Color(30, 35, 54));
		BfinalizarCompra.setBounds(620, 31, 130, 49);
		BfinalizarCompra.setVisible(false);
		cabecalho.add(BfinalizarCompra);

		JLabel LfinalizarCompra = new JLabel("Finalizar Compra");
		LfinalizarCompra.setName("lFinalizarCompra");
		LfinalizarCompra.setAlignmentX(Component.CENTER_ALIGNMENT);
		LfinalizarCompra.setHorizontalAlignment(SwingConstants.CENTER);
		LfinalizarCompra.setForeground(new Color(207, 209, 213));
		LfinalizarCompra.setBounds(10, 11, 110, 27);
		BfinalizarCompra.add(LfinalizarCompra);
		cabecalho.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { titulo }));

		// -------------------------------------- PANELS

		pTela = new JPanel();
		pTela.setName("pTela");
		pTela.setBackground(fundo);
		pTela.setBounds(221, 147, 780, 444);
		contentPane.add(pTela);
		pTela.setLayout(null);

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
				
				if(((JTextField) e.getSource()).getText().trim().equals("") || (allPedidos.getPedido(((JTextField) e.getSource()).getText())==null)) JOptionPane.showMessageDialog(null, "Digite um código válido.","CÓDIGO INVÁLIDO",2);
				else {

					camadaConsultar.removeAll();
					camadaConsultar.revalidate();
					camadaConsultar.repaint();
					addPedidoCamada((allPedidos.getPedido(((JTextField) e.getSource()).getText())), camadaConsultar);
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
				camadaConsultar.removeAll();
				camadaConsultar.revalidate();
				camadaConsultar.repaint();
				addPedidosCamada(allPedidos, camadaConsultar);
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
		scrollCarrinho.setBounds(-1, -1, 780, 444);
		scrollCarrinho.getVerticalScrollBar().setUnitIncrement(16);
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

		// TODO @MENUS
		JPanel b2 = new JPanel();
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.addMouseListener(new MouseAdapter() {
			// TODO CARRINHO
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(e.getComponent(), telas, BfinalizarCompra);
				setTela(roxoclaro2, e.getComponent(), titulo, cabecalho, bnts);
				addProdutoCamada(carrinho.getProdutos(), camadaCarrinho);
			}
		});

		JPanel b1 = new JPanel();
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.addMouseListener(new MouseAdapter() {
			// TODO PRODUTO
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(e.getComponent(), telas, BfinalizarCompra);
				setTela(roxoclaro, e.getComponent(), titulo, cabecalho, bnts);
				addProdutoCamada(loja.getProdutos(), camadaProdutos);
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
				setVisible(e.getComponent(), telas, BfinalizarCompra);
				setTela(roxoclaro3, e.getComponent(), titulo, cabecalho, bnts);
				camadaConsultar.removeAll();
				camadaConsultar.revalidate();
				camadaConsultar.repaint();
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

		/*
		 * copy paste
		 */

		JPanel Logar = new JPanel();
		Logar.setName("Logar");
		Logar.setBackground(fundo);
		Logar.setAlignmentY(1.0f);
		Logar.setAlignmentX(1.0f);
		Logar.setBounds(0, 0, 780, 444);
		pTela.add(Logar);
		Logar.setLayout(null);

//		for(Produtos p: listaProdutos) System.out.println(p.getDescricao());

		// no final >>
		/*******************************
		 * CRIANDO PRODUTO POR CLASSE
		 *********************************/
		// */

		/*
		 * JPanel PRODUTO1 = new JPanel(); PRODUTO1.setName("produto");
		 * GridBagConstraints gbc_PRODUTO1 = new GridBagConstraints(); gbc_PRODUTO1.fill
		 * = GridBagConstraints.BOTH; gbc_PRODUTO1.insets = new Insets(0, 0, 5, 5);
		 * gbc_PRODUTO1.gridx = 1; gbc_PRODUTO1.gridy = 1; camadaCarrinho.add(PRODUTO1,
		 * gbc_PRODUTO1); PRODUTO1.setBackground(Color.WHITE); PRODUTO1.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64,
		 * 64), Color.WHITE, null));
		 * PRODUTO1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		 * PRODUTO1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 * PRODUTO1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 * PRODUTO1.setLayout(new BoxLayout(PRODUTO1, BoxLayout.PAGE_AXIS));
		 * 
		 * JLabel close = new JLabel(""); close.addMouseListener(new MouseAdapter() {
		 * 
		 * @Override public void mouseClicked(MouseEvent e) { } });
		 * close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 * close.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 * close.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * close.setAlignmentY(Component.BOTTOM_ALIGNMENT); close.setIconTextGap(1);
		 * close.setName("close"); close.setIcon(new
		 * ImageIcon(TelaPrincipal.class.getResource("/images/close.png")));
		 * close.setMaximumSize(new Dimension(16, 24));
		 * close.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO1.add(close);
		 * 
		 * JLabel label_3 = new JLabel(""); label_3.setName("figura");
		 * label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * label_3.setHorizontalAlignment(SwingConstants.CENTER); label_3.setIcon(new
		 * ImageIcon(TelaPrincipal.class.getResource("/images/003-livro.png")));
		 * PRODUTO1.add(label_3);
		 * 
		 * JLabel lblLivro = new JLabel("LIVRO 01"); lblLivro.setMaximumSize(new
		 * Dimension(132, 25)); lblLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
		 * PRODUTO1.add(lblLivro);
		 * 
		 * JLabel lblR = new JLabel("R$ 10"); lblR.setMaximumSize(new Dimension(132,
		 * 25)); lblR.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * lblR.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO1.add(lblR);
		 * 
		 * JButton btnNewButton = new JButton("Adicionar"); //
		 * PRODUTO1.add(btnNewButton);
		 * btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		 * 
		 * JSpinner spinner = new JSpinner(); spinner.setModel(new SpinnerNumberModel(1,
		 * 1, 20, 1)); spinner.setMaximumSize(new Dimension(60, 25));
		 * PRODUTO1.add(spinner); PRODUTO1.setFocusTraversalPolicy( new
		 * FocusTraversalOnArray(new Component[] { label_3, lblLivro, lblR })); // //
		 */

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
	private void setVisible(Component bnt, Component[] telas, Component compVisible) {
		for (Component t : telas) {
//			System.out.println(((JPanel) t).getName());
//			System.out.println(((JLabel) ((JPanel) bnt).getComponent(0)).getText());
			if (((JPanel) t).getName().equals(((JLabel) ((JPanel) bnt).getComponent(0)).getText())) {
				((JPanel) t).setVisible(true);

				if (((JPanel) t).getName() == "Carrinho")
					compVisible.setVisible(true);
				else
					compVisible.setVisible(false);
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
		String pPreco = Double.toString(p.getValor());

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

					loja.addProduto(p);
					carrinho.removeProduto(p);
//					System.out.println("carrinho: " + carrinho.qtdProduto() + "\nloja: " + loja.qtdProduto());

//					System.out.println(e.getComponent().getParent().getName());

					scroll.removeAll();
					scroll.revalidate();
					scroll.repaint();
					addProdutoCamada(carrinho.getProdutos(), scroll);

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

		if (scroll.getName() == "camadaProdutos") {
			JButton botao = new JButton("Adicionar");
			botao.setName(nomeBotao);// nomeBotao="adicionar1"
			botao.addMouseListener(new MouseAdapter() {
				// TODO BOTÃO ADICIONAR
				@Override
				public void mouseClicked(MouseEvent e) {

					carrinho.addProduto(p);
					loja.removeProduto(p);
					scroll.removeAll();
					scroll.revalidate();
					scroll.repaint();
					addProdutoCamada(loja.getProdutos(), scroll);

				}
			});

			produto.add(botao);
			botao.setAlignmentX(Component.CENTER_ALIGNMENT);

			produto.setFocusTraversalPolicy(
					new FocusTraversalOnArray(new Component[] { figura, descricao, preco, botao }));
		}

		if (scroll.getName() == "camadaCarrinho") {
			JSpinner spinner = new JSpinner();
			spinner.setName(nomeSpinner);// nomeSpinner="spinner1"
			if (p.estoqueQtd() >= 1)
				spinner.setModel(new SpinnerNumberModel(1, 1, p.estoqueQtd(), 1));
			else if (p.estoqueQtd() == 0)
				spinner.setModel(new SpinnerNumberModel(0, 0, p.estoqueQtd(), 0));
			spinner.setMaximumSize(new Dimension(60, 25));
			produto.add(spinner);
		}

		if (scroll.getName() == "camadaConsultar") {
			String qtde = "QTD: " + (p.estoqueQtd());
			JLabel qtd = new JLabel(qtde);// pPreco="R$ 10"
			qtd.setMaximumSize(new Dimension(132, 25));
			qtd.setAlignmentX(Component.CENTER_ALIGNMENT);
			qtd.setHorizontalAlignment(SwingConstants.CENTER);
			produto.add(qtd);
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

				scroll.removeAll();
				scroll.revalidate();
				scroll.repaint();
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
	public void addPedidosCamada(Pedidos p, JPanel camada) {
		String nomePedido = "pedido";
		String numeroPedido = "PEDIDO ";
		String pNumeroPedido = "pedidoNumero";
		String lCodigo = "labelCodigo";
		String lValorTotal = "labelValorTotal";

		int i = 0;
		for (int x = 1; x <= 7; x += 2) {
			for (int y = 1; y <= 7; y += 2) {

				if (i < p.qtdPedidos())
					addPedidoCard(nomePedido + i, camada, y, x, numeroPedido + (i + 1), pNumeroPedido + i, lCodigo + i,
							lValorTotal + i, p.getPedidos().get(i));
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
}// final

/*
 * JPanel panel = new JPanel(); GridBagConstraints gbc_panel = new
 * GridBagConstraints(); gbc_panel.fill = GridBagConstraints.BOTH;
 * gbc_panel.insets = new Insets(0, 0, 5, 5); gbc_panel.gridx = 1;
 * gbc_panel.gridy = 1; camadaProdutos.add(panel, gbc_panel);
 * panel.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel.setBackground(Color.WHITE); panel.setLayout(new BoxLayout(panel,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_5 = new JLabel(""); label_5.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/001-cd.png")));
 * label_5.setHorizontalAlignment(SwingConstants.CENTER);
 * label_5.setAlignmentX(0.5f); panel.add(label_5);
 * 
 * JLabel label_6 = new JLabel("LIVRO 01"); label_6.setMaximumSize(new
 * Dimension(132, 25)); label_6.setHorizontalAlignment(SwingConstants.CENTER);
 * label_6.setAlignmentX(0.5f); panel.add(label_6);
 * 
 * JLabel label_7 = new JLabel("R$ 10"); label_7.setMaximumSize(new
 * Dimension(132, 25)); label_7.setHorizontalAlignment(SwingConstants.CENTER);
 * label_7.setAlignmentX(0.5f); panel.add(label_7);
 * 
 * JButton button = new JButton("Adicionar"); button.setAlignmentX(0.5f);
 * panel.add(button);
 * 
 * JSpinner spinner_1 = new JSpinner(); spinner_1.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_1.setMaximumSize(new Dimension(60,
 * 25)); panel.add(spinner_1);
 * 
 * JPanel panel_1 = new JPanel(); GridBagConstraints gbc_panel_1 = new
 * GridBagConstraints(); gbc_panel_1.fill = GridBagConstraints.BOTH;
 * gbc_panel_1.insets = new Insets(0, 0, 5, 5); gbc_panel_1.gridx = 3;
 * gbc_panel_1.gridy = 1; camadaProdutos.add(panel_1, gbc_panel_1);
 * panel_1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel_1.setBackground(Color.WHITE); panel_1.setLayout(new BoxLayout(panel_1,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_8 = new JLabel(""); label_8.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/002-dvd.png")));
 * label_8.setHorizontalAlignment(SwingConstants.CENTER);
 * label_8.setAlignmentX(0.5f); panel_1.add(label_8);
 * 
 * JLabel label_9 = new JLabel("LIVRO 01"); label_9.setMaximumSize(new
 * Dimension(132, 25)); label_9.setHorizontalAlignment(SwingConstants.CENTER);
 * label_9.setAlignmentX(0.5f); panel_1.add(label_9);
 * 
 * JLabel label_10 = new JLabel("R$ 10"); label_10.setMaximumSize(new
 * Dimension(132, 25)); label_10.setHorizontalAlignment(SwingConstants.CENTER);
 * label_10.setAlignmentX(0.5f); panel_1.add(label_10);
 * 
 * JButton button_1 = new JButton("Adicionar"); button_1.setAlignmentX(0.5f);
 * panel_1.add(button_1);
 * 
 * JSpinner spinner_2 = new JSpinner(); spinner_2.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_2.setMaximumSize(new Dimension(60,
 * 25)); panel_1.add(spinner_2); JPanel PRODUTO2 = new JPanel();
 * GridBagConstraints gbc_PRODUTO2 = new GridBagConstraints(); gbc_PRODUTO2.fill
 * = GridBagConstraints.BOTH; gbc_PRODUTO2.insets = new Insets(0, 0, 5, 5);
 * gbc_PRODUTO2.gridx = 5; gbc_PRODUTO2.gridy = 1; camadaProdutos.add(PRODUTO2,
 * gbc_PRODUTO2); PRODUTO2.setBackground(Color.WHITE); PRODUTO2.setBorder(new
 * BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64,
 * 64), Color.WHITE, null));
 * PRODUTO2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * PRODUTO2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * PRODUTO2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 * PRODUTO2.setLayout(new BoxLayout(PRODUTO2, BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_31 = new JLabel("");
 * label_31.setAlignmentX(Component.CENTER_ALIGNMENT);
 * label_31.setHorizontalAlignment(SwingConstants.CENTER); label_31.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/003-livro.png")));
 * PRODUTO2.add(label_31);
 * 
 * JLabel lblLivro1 = new JLabel("LIVRO 01"); lblLivro1.setMaximumSize(new
 * Dimension(132, 25)); lblLivro1.setAlignmentX(Component.CENTER_ALIGNMENT);
 * lblLivro1.setHorizontalAlignment(SwingConstants.CENTER);
 * PRODUTO2.add(lblLivro1);
 * 
 * JLabel lblR1 = new JLabel("R$ 10"); lblR1.setMinimumSize(new Dimension(132,
 * 25)); lblR1.setMaximumSize(new Dimension(132, 25));
 * lblR1.setAlignmentX(Component.CENTER_ALIGNMENT);
 * lblR1.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO2.add(lblR1);
 * 
 * JButton btnNewButton1 = new JButton("Adicionar");
 * PRODUTO2.add(btnNewButton1);
 * btnNewButton1.setAlignmentX(Component.CENTER_ALIGNMENT);
 * 
 * JSpinner spinner1 = new JSpinner(); spinner1.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner1.setMaximumSize(new Dimension(60,
 * 25)); PRODUTO2.add(spinner1); PRODUTO2.setFocusTraversalPolicy( new
 * FocusTraversalOnArray(new Component[] { label_31, lblLivro1, lblR1,
 * btnNewButton1 }));
 * 
 * //
 * -----------------------------------------------------------------------------
 * -------------------------------------------------/ JPanel PRODUTO1 = new
 * JPanel(); PRODUTO1.setName("produto"); GridBagConstraints gbc_PRODUTO1 = new
 * GridBagConstraints(); gbc_PRODUTO1.fill = GridBagConstraints.BOTH;
 * gbc_PRODUTO1.insets = new Insets(0, 0, 5, 5); gbc_PRODUTO1.gridx = 7;
 * gbc_PRODUTO1.gridy = 1; camadaProdutos.add(PRODUTO1, gbc_PRODUTO1);
 * PRODUTO1.setBackground(Color.WHITE); PRODUTO1.setBorder(new
 * BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(64, 64,
 * 64), Color.WHITE, null));
 * PRODUTO1.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * PRODUTO1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * PRODUTO1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
 * PRODUTO1.setLayout(new BoxLayout(PRODUTO1, BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_3 = new JLabel(""); label_3.setName("figura");
 * label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
 * label_3.setHorizontalAlignment(SwingConstants.CENTER); label_3.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/003-livro.png")));
 * PRODUTO1.add(label_3);
 * 
 * JLabel lblLivro = new JLabel("LIVRO 01"); lblLivro.setMaximumSize(new
 * Dimension(132, 25)); lblLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
 * lblLivro.setHorizontalAlignment(SwingConstants.CENTER);
 * PRODUTO1.add(lblLivro);
 * 
 * JLabel lblR = new JLabel("R$ 10"); lblR.setMaximumSize(new Dimension(132,
 * 25)); lblR.setAlignmentX(Component.CENTER_ALIGNMENT);
 * lblR.setHorizontalAlignment(SwingConstants.CENTER); PRODUTO1.add(lblR);
 * 
 * JButton btnNewButton = new JButton("Adicionar"); PRODUTO1.add(btnNewButton);
 * btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
 * 
 * JSpinner spinner = new JSpinner(); spinner.setModel(new SpinnerNumberModel(1,
 * 1, 20, 1)); spinner.setMaximumSize(new Dimension(60, 25));
 * PRODUTO1.add(spinner); PRODUTO1.setFocusTraversalPolicy( new
 * FocusTraversalOnArray(new Component[] { label_3, lblLivro, lblR, btnNewButton
 * })); //
 * -----------------------------------------------------------------------------
 * -------------------------------------------------------------------/
 * 
 * 
 * 
 * JPanel panel_5 = new JPanel(); GridBagConstraints gbc_panel_5 = new
 * GridBagConstraints(); gbc_panel_5.fill = GridBagConstraints.BOTH;
 * gbc_panel_5.insets = new Insets(0, 0, 5, 5); gbc_panel_5.gridx = 1;
 * gbc_panel_5.gridy = 3; camadaProdutos.add(panel_5, gbc_panel_5);
 * panel_5.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel_5.setBackground(Color.WHITE); panel_5.setLayout(new BoxLayout(panel_5,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_20 = new JLabel(""); label_20.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/001-cd.png")));
 * label_20.setHorizontalAlignment(SwingConstants.CENTER);
 * label_20.setAlignmentX(0.5f); panel_5.add(label_20);
 * 
 * JLabel label_21 = new JLabel("LIVRO 01"); label_21.setMaximumSize(new
 * Dimension(132, 25)); label_21.setHorizontalAlignment(SwingConstants.CENTER);
 * label_21.setAlignmentX(0.5f); panel_5.add(label_21);
 * 
 * JLabel label_22 = new JLabel("R$ 10"); label_22.setMaximumSize(new
 * Dimension(132, 25)); label_22.setHorizontalAlignment(SwingConstants.CENTER);
 * label_22.setAlignmentX(0.5f); panel_5.add(label_22);
 * 
 * JButton button_5 = new JButton("Adicionar"); button_5.setAlignmentX(0.5f);
 * panel_5.add(button_5);
 * 
 * JSpinner spinner_6 = new JSpinner(); spinner_6.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_6.setMaximumSize(new Dimension(60,
 * 25)); panel_5.add(spinner_6);
 * 
 * JPanel panel_4 = new JPanel(); GridBagConstraints gbc_panel_4 = new
 * GridBagConstraints(); gbc_panel_4.fill = GridBagConstraints.BOTH;
 * gbc_panel_4.insets = new Insets(0, 0, 5, 5); gbc_panel_4.gridx = 3;
 * gbc_panel_4.gridy = 3; camadaProdutos.add(panel_4, gbc_panel_4);
 * panel_4.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel_4.setBackground(Color.WHITE); panel_4.setLayout(new BoxLayout(panel_4,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_17 = new JLabel(""); label_17.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/003-livro.png")));
 * label_17.setHorizontalAlignment(SwingConstants.CENTER);
 * label_17.setAlignmentX(0.5f); panel_4.add(label_17);
 * 
 * JLabel label_18 = new JLabel("LIVRO 01"); label_18.setMaximumSize(new
 * Dimension(132, 25)); label_18.setHorizontalAlignment(SwingConstants.CENTER);
 * label_18.setAlignmentX(0.5f); panel_4.add(label_18);
 * 
 * JLabel label_19 = new JLabel("R$ 10"); label_19.setMaximumSize(new
 * Dimension(132, 25)); label_19.setHorizontalAlignment(SwingConstants.CENTER);
 * label_19.setAlignmentX(0.5f); panel_4.add(label_19);
 * 
 * JButton button_4 = new JButton("Adicionar"); button_4.setAlignmentX(0.5f);
 * panel_4.add(button_4);
 * 
 * JSpinner spinner_5 = new JSpinner(); spinner_5.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_5.setMaximumSize(new Dimension(60,
 * 25)); panel_4.add(spinner_5);
 * 
 * JPanel panel_3 = new JPanel(); GridBagConstraints gbc_panel_3 = new
 * GridBagConstraints(); gbc_panel_3.fill = GridBagConstraints.BOTH;
 * gbc_panel_3.insets = new Insets(0, 0, 5, 5); gbc_panel_3.gridx = 5;
 * gbc_panel_3.gridy = 3; camadaProdutos.add(panel_3, gbc_panel_3);
 * panel_3.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel_3.setBackground(Color.WHITE); panel_3.setLayout(new BoxLayout(panel_3,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_14 = new JLabel(""); label_14.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/002-dvd.png")));
 * label_14.setHorizontalAlignment(SwingConstants.CENTER);
 * label_14.setAlignmentX(0.5f); panel_3.add(label_14);
 * 
 * JLabel label_15 = new JLabel("LIVRO 01"); label_15.setMaximumSize(new
 * Dimension(132, 25)); label_15.setHorizontalAlignment(SwingConstants.CENTER);
 * label_15.setAlignmentX(0.5f); panel_3.add(label_15);
 * 
 * JLabel label_16 = new JLabel("R$ 10"); label_16.setMaximumSize(new
 * Dimension(132, 25)); label_16.setHorizontalAlignment(SwingConstants.CENTER);
 * label_16.setAlignmentX(0.5f); panel_3.add(label_16);
 * 
 * JButton button_3 = new JButton("Adicionar"); button_3.setAlignmentX(0.5f);
 * panel_3.add(button_3);
 * 
 * JSpinner spinner_4 = new JSpinner(); spinner_4.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_4.setMaximumSize(new Dimension(60,
 * 25)); panel_3.add(spinner_4);
 * 
 * JPanel panel_2 = new JPanel(); GridBagConstraints gbc_panel_2 = new
 * GridBagConstraints(); gbc_panel_2.fill = GridBagConstraints.BOTH;
 * gbc_panel_2.insets = new Insets(0, 0, 5, 5); gbc_panel_2.gridx = 7;
 * gbc_panel_2.gridy = 3; camadaProdutos.add(panel_2, gbc_panel_2);
 * panel_2.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
 * panel_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
 * panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192,
 * 192), new Color(64, 64, 64), Color.WHITE, null));
 * panel_2.setBackground(Color.WHITE); panel_2.setLayout(new BoxLayout(panel_2,
 * BoxLayout.PAGE_AXIS));
 * 
 * JLabel label_11 = new JLabel(""); label_11.setIcon(new
 * ImageIcon(TelaPrincipal.class.getResource("/images/002-dvd.png")));
 * label_11.setHorizontalAlignment(SwingConstants.CENTER);
 * label_11.setAlignmentX(0.5f); panel_2.add(label_11);
 * 
 * JLabel label_12 = new JLabel("LIVRO 01"); label_12.setMaximumSize(new
 * Dimension(132, 25)); label_12.setHorizontalAlignment(SwingConstants.CENTER);
 * label_12.setAlignmentX(0.5f); panel_2.add(label_12);
 * 
 * JLabel label_13 = new JLabel("R$ 10"); label_13.setMaximumSize(new
 * Dimension(132, 25)); label_13.setHorizontalAlignment(SwingConstants.CENTER);
 * label_13.setAlignmentX(0.5f); panel_2.add(label_13);
 * 
 * JButton button_2 = new JButton("Adicionar"); button_2.setAlignmentX(0.5f);
 * panel_2.add(button_2);
 * 
 * JSpinner spinner_3 = new JSpinner(); spinner_3.setModel(new
 * SpinnerNumberModel(1, 1, 20, 1)); spinner_3.setMaximumSize(new Dimension(60,
 * 25)); panel_2.add(spinner_3);
 * 
 * //
 */