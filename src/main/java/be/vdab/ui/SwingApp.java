package be.vdab.ui;

import be.vdab.be.vdab.dao.ProductDao;
import be.vdab.dao.impl.ProductDaoImpl;
import be.vdab.entiteiten.Product;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class SwingApp extends JFrame {

    private JPanel northPanel, southPanel, eastPanel, westPanel;
    private JScrollPane scrollPaneWest;
    private JScrollPane scrollPaneEast;
    private JList<Product> productList;
    private JList shopBasket;
    private JButton btnAddProduct, btnLogin;
    private JTextField txtUser, txtPaswd;
    private JLabel lblUser, lblPaswd;
    private Border listBorder;

    private ProductDao productDao;

    public SwingApp() {
        productDao = new ProductDaoImpl();
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        setTitle("Webshop IBO");
        setSize(800, 500);
        setLocation(100, 100);
        southPanel = new JPanel();
        southPanel.setBackground(Color.GREEN);
        northPanel = new JPanel();
        northPanel.setBackground(Color.GREEN);
        scrollPaneEast = new JScrollPane();
        scrollPaneWest = new JScrollPane();
        //listBorder = new BevelBorder(BevelBorder.RAISED);
        productList = new JList(productDao.getProductList().toArray());
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setBorder(listBorder);
        /* productList.setListData( productDao.getProductList().toArray(new Product[0])); */
        shopBasket = new JList();
        shopBasket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        shopBasket.setBorder(new BevelBorder(BevelBorder.LOWERED));
        btnAddProduct = new JButton("Add product");
        btnLogin = new JButton("Login");
        btnLogin.setEnabled(false);
        lblUser = new JLabel("Username ");
        lblPaswd = new JLabel("Password ");
        txtUser = new JTextField(15);
        txtUser.setText("username");
        txtUser.selectAll();
        txtPaswd = new JTextField(15);
        txtPaswd.setText("password");
        txtPaswd.selectAll();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void layoutComponents() {
        add(southPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);
        add(scrollPaneWest, BorderLayout.WEST);
        add(scrollPaneEast, BorderLayout.EAST);
        //productList.add(new JLabel("Productlist"), BorderLayout.NORTH);
        scrollPaneWest.add(productList);
        scrollPaneEast.add(shopBasket);
        northPanel.add(lblUser);
        northPanel.add(txtUser);
        northPanel.add(lblPaswd);
        northPanel.add(txtPaswd);
        northPanel.add(btnLogin);
        southPanel.add(btnAddProduct);
    }


    public static void main(String[] args) {
        new SwingApp();
    }
}
