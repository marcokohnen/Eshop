package be.vdab.ui;

import be.vdab.be.vdab.dao.BasketDao;
import be.vdab.be.vdab.dao.ProductDao;
import be.vdab.be.vdab.dao.ShopDao;
import be.vdab.dao.impl.BasketDaoImpl;
import be.vdab.dao.impl.ProductDaoImpl;
import be.vdab.dao.impl.ShopDaoImpl;
import be.vdab.entiteiten.Eshop;

import javax.swing.*;
import java.awt.*;

public class SwingTest extends JFrame {

    private JPanel northPanel1, northPanel2, northPanel3, southPanel;
    private JLabel lblUser, lblPaswd, lblTitleBasket, lblTitleProductList, lblSelectShop;
    private JTextField txtUser;
    private JPasswordField txtPaswd;
    private JButton btnAddProduct, btnLogin, btnAfrekenen;
    private JList<Object> productList;
    private JList<Object> productListB;
    private JList<Object> basketList;
    private BasketDao basketDao;
    private ProductDao productDao;
    private ShopDao shopDao;
    private JSplitPane splitPane;
    private JScrollPane scrollPaneProducts, scrollPaneBasket;
    private JComboBox<Object> comboBoxShops;
    private Eshop selectedShop;


    public SwingTest() {
        productDao = new ProductDaoImpl();
        shopDao = new ShopDaoImpl();
        basketDao = new BasketDaoImpl();
        initComponents();
        layoutComponents();
        initListeners();
    }

    private void initComponents() {
        setTitle("Webshop IBO");
        setSize(1000, 500);
        setLocation(250, 250);
        productList = new JList<>(productDao.getProductList().toArray());
        //basketList =  new JList<Object>(basketDao.getBasket().getBasketMap());
        productList.setSelectedIndex(0);
        scrollPaneProducts = new JScrollPane(productList);
        scrollPaneProducts.setMinimumSize(new Dimension(250, 400));
        scrollPaneBasket = new JScrollPane(productListB);
        scrollPaneBasket.setMinimumSize(new Dimension(250, 400));
        lblUser = new JLabel("  Username ");
        lblPaswd = new JLabel("  password ");
        lblTitleProductList = new JLabel("P R O D U C T L I S T");
        lblTitleBasket = new JLabel("S H O P  B A S K E T");
        lblSelectShop = new JLabel("Select Shop");
        txtUser = new JTextField(15);
        txtUser.setEnabled(false);
        txtPaswd = new JPasswordField(15);
        txtPaswd.setEnabled(false);
        btnLogin = new JButton("Login");
        btnLogin.setEnabled(false);
        btnAddProduct = new JButton("Voeg toe");
        btnAfrekenen = new JButton("Afrekenen");
        northPanel1 = new JPanel();
        northPanel2 = new JPanel();
        northPanel2.setBackground(Color.GREEN);
        northPanel3 = new JPanel();
        northPanel3.setBackground(Color.ORANGE);
        southPanel = new JPanel();
        comboBoxShops = new JComboBox<>(shopDao.listAllShops().toArray());
        comboBoxShops.setSelectedIndex(0);
        selectedShop = (Eshop) comboBoxShops.getSelectedItem();
        setVisible(true);
    }

    private void layoutComponents() {
        //setLayout(new GridLayout(3,1));
        northPanel1.add(lblSelectShop);
        northPanel1.add(comboBoxShops);
        northPanel1.add(lblUser);
        northPanel1.add(txtUser);
        northPanel1.add(lblPaswd);
        northPanel1.add(txtPaswd);
        northPanel1.add(btnLogin);

        northPanel2.add(lblTitleProductList);
        northPanel3.add(lblTitleBasket);

        southPanel.add(btnAddProduct);
        southPanel.add(btnAfrekenen);

        add(northPanel1, BorderLayout.NORTH);

        scrollPaneProducts.add(northPanel2);
        scrollPaneBasket.add(northPanel3);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPaneBasket, scrollPaneProducts);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(500);
        splitPane.setDividerSize(20);

        add(splitPane, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void initListeners() {
        btnAddProduct.addActionListener(e -> System.out.println((Eshop) comboBoxShops.getItemAt(comboBoxShops.getSelectedIndex())));
    }

    public static void main(String[] args) {
        new SwingTest();
    }
}
