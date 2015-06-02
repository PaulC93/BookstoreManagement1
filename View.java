import javax.swing.*; //Necessary for GUI

import java.awt.*; //Necessary for GUI
import java.awt.event.*; //Necessary for ActionListener 
/**
 * The class that builds the GUI of the application.
 * Offers methods for adding ActionListeners, getting input, reseting input, 
 * checking for valid input, showing messages and other info etc.
 * @author Paul Calean
 * @version 1.0
 */
public class View {

	//GUI variables
	private JFrame frame1;
	private Container pane;
	private Insets insets;
	private JMenuBar menuBar;
	private JMenu menuAdd,menuView,menuUpdate,menuDelete,menuSearch,menuBuy;
	private JMenuItem menuItemAddBook,menuItemAddAuthor,menuItemAddPublisher,menuItemAddCategory,menuItemAddClient,menuItemAddFunds,
					  menuItemViewBooks, menuItemViewAuthors,menuItemViewPublishers,menuItemViewCategories,menuItemViewClients,
					  menuItemUpdateBook, menuItemUpdateAuthor,menuItemUpdatePublisher,menuItemUpdateCategory,menuItemUpdateClient,
					  menuItemDeleteBook, menuItemDeleteAuthor,menuItemDeletePublisher,menuItemDeleteCategory,menuItemDeleteClient,
					  menuItemSearchBook, menuItemSearchAuthor,menuItemSearchPublisher,menuItemSearchCategory,menuItemSearchClient,
					  menuItemViewAccount, menuItemBuyBook;
	private JLabel lblUsername, lblPassword, lblOption, lblID, lblTitle, lblNoOfCopies, lblAuthorsIDs, lblPublisherID, lblCategoriesIDs,
					lblPrice, lblAuthorsFN, lblAuthorsLN, lblName, lblPhone, lblAddress, lblEmail, lblCredit, lblOldID, lblPublisher, lblCategory,lblFunds;
	private JTextField txtUsername, txtID, txtTitle, txtNoOfCopies, txtAuthorsIDs, txtPublisherID, txtCategoriesIDs,
						txtPrice, txtAuthorsFN, txtAuthorsLN, txtName, txtPhone, txtAddress, txtEmail, txtCredit, txtOldID, txtPublisher, txtCategory,txtFunds;
	private JPasswordField txtPassword;
	private JButton btnConnect,btnDisconnect,btnAddBook,btnAddAuthor,btnAddPublisher,btnAddCategory,btnAddClient,
					btnUpdateBook,btnUpdateAuthor,btnUpdatePublisher,btnUpdateCategory,btnUpdateClient,
					btnDeleteBook,btnDeleteAuthor,btnDeletePublisher,btnDeleteCategory,btnDeleteClient,
					btnSearchBook,btnSearchAuthor,btnSearchPublisher,btnSearchCategory,btnSearchClient,
					btnAddFunds, btnBuyBook, btnGetReceipt, btnSendMail;
	private Table booksTable,authorsTable,publishersTable,categoriesTable,clientsTable;
	private static final int HS=10,VS=10; //HS=HorizontalSpacing VS=VerticaSpacing

	/**
	 *The method for initialising the GUI. Creates and adds the different components of the GUI.
	 * Shows the application's window and sets its position to the centre of the screen.
	 */
	// Initialises graphical components
	public void initialization() {

		// Set Look and Feel
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

		// Create the frame
		frame1 = new JFrame("BookStore");
		frame1.setSize(450, 80);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane = frame1.getContentPane();
		insets = pane.getInsets();
		pane.setLayout(null);
		
		//Create the components
		//Create the menuBar
		menuBar=new JMenuBar();
		//Create menus
		menuAdd=new JMenu("Add");
		menuView=new JMenu("View");
		menuUpdate=new JMenu("Update");
		menuDelete=new JMenu("Delete");
		menuSearch=new JMenu("Search");
		menuBuy=new JMenu("Buy");
		//Create menu items
		menuItemAddBook=new JMenuItem("Add book");
		menuItemAddAuthor=new JMenuItem("Add author");
		menuItemAddPublisher=new JMenuItem("Add publisher");
		menuItemAddCategory=new JMenuItem("Add category");
		menuItemAddClient=new JMenuItem("Add client");
		menuItemAddFunds=new JMenuItem("Add funds to a client");
		menuItemViewBooks=new JMenuItem("View books");
		menuItemViewAuthors=new JMenuItem("View authors");
		menuItemViewPublishers=new JMenuItem("View publishers");
		menuItemViewCategories=new JMenuItem("View categories");
		menuItemViewClients=new JMenuItem("View clients");
		menuItemViewAccount=new JMenuItem("View Account");
		menuItemUpdateBook=new JMenuItem("Update book");
		menuItemUpdateAuthor=new JMenuItem("Update author");
		menuItemUpdatePublisher=new JMenuItem("Update publisher");
		menuItemUpdateCategory=new JMenuItem("Update category");
		menuItemUpdateClient=new JMenuItem("Update client");
		menuItemDeleteBook=new JMenuItem("Delete book");
		menuItemDeleteAuthor=new JMenuItem("Delete author");
		menuItemDeletePublisher=new JMenuItem("Delete publisher");
		menuItemDeleteCategory=new JMenuItem("Delete category");
		menuItemDeleteClient=new JMenuItem("Delete client");
		menuItemSearchBook=new JMenuItem("Search book");
		menuItemSearchAuthor=new JMenuItem("Search author");
		menuItemSearchPublisher=new JMenuItem("Search publisher");
		menuItemSearchCategory=new JMenuItem("Search category");
		menuItemSearchClient=new JMenuItem("Search client");
		menuItemBuyBook=new JMenuItem("Buy Book");
		//Create the labels
		lblUsername=new JLabel("Username:"); 
		lblPassword=new JLabel("Password:");
		lblOption=new JLabel("Option:");
		lblID=new JLabel("ID:");
		lblTitle=new JLabel("Title:");
		lblNoOfCopies=new JLabel("No. Of Copies:");
		lblAuthorsIDs=new JLabel("AuthorsIDs:");
		lblPublisherID=new JLabel("PublisherID:");
		lblCategoriesIDs=new JLabel("CategoriesIDs:");
		lblPrice=new JLabel("Price:");
		lblAuthorsFN=new JLabel("Author's FirstName:");
		lblAuthorsLN=new JLabel("Author's LastName:");
		lblName=new JLabel("Name:");
		lblPhone=new JLabel("Phone:");
		lblAddress=new JLabel("Address:"); 
		lblEmail=new JLabel("Email:");
		lblCredit=new JLabel("Credit:");
		lblOldID=new JLabel("OldID:");
		lblPublisher=new JLabel("Publisher:");
		lblCategory=new JLabel("Category:");
		lblFunds=new JLabel("Funds:");
		///Create text fields
		txtUsername=new JTextField(10);
		txtID=new JTextField(5);
		txtTitle=new JTextField(20);
		txtNoOfCopies=new JTextField(5);
		txtAuthorsIDs=new JTextField(5);
		txtPublisherID=new JTextField(5);
		txtCategoriesIDs=new JTextField(10);
		txtPrice=new JTextField(10);
		txtAuthorsFN=new JTextField(10);
		txtAuthorsLN=new JTextField(10);
		txtName=new JTextField(10);
		txtPhone=new JTextField(10);
		txtAddress=new JTextField(10);
		txtEmail=new JTextField(10);
		txtCredit=new JTextField(10);
		txtOldID=new JTextField(5);
		txtPublisher=new JTextField(10);
		txtCategory=new JTextField(10);
		txtFunds=new JTextField(10);
		//Create Password field
		txtPassword=new JPasswordField(10);
		//Create buttons
		btnConnect=new JButton("Connect");
		btnDisconnect=new JButton("Disconnect");
		btnAddBook=new JButton("Add Book");
		btnAddAuthor=new JButton("Add Author");
		btnAddPublisher=new JButton("Add Publisher");
		btnAddCategory=new JButton("Add Category");
		btnAddClient=new JButton("Add Client");
		btnUpdateBook=new JButton("Update Book");
		btnUpdateAuthor=new JButton("Update Author");
		btnUpdatePublisher=new JButton("Update Publisher");
		btnUpdateCategory=new JButton("Update Category");
		btnUpdateClient=new JButton("Update Client");
		btnDeleteBook=new JButton("Delete Book");
		btnDeleteAuthor=new JButton("Delete Author");
		btnDeletePublisher=new JButton("Delete Publisher");
		btnDeleteCategory=new JButton("Delete Category");
		btnDeleteClient=new JButton("Delete Client");
		btnSearchBook=new JButton("Search Book");
		btnSearchAuthor=new JButton("Search Author");
		btnSearchPublisher=new JButton("Search Publisher");
		btnSearchCategory=new JButton("Search Category");
		btnSearchClient=new JButton("Search Client");
		btnAddFunds=new JButton("Add funds");
		btnBuyBook=new JButton("Buy Book");
		btnGetReceipt=new JButton("Get Receipt");
		btnSendMail=new JButton("Send confimation email");
		//Add menus to me menuBar
		menuBar.add(menuView);
		menuBar.add(menuSearch);
		//Add menuItems to menus
		menuAdd.add(menuItemAddBook);
		menuAdd.add(menuItemAddAuthor);
		menuAdd.add(menuItemAddPublisher);
		menuAdd.add(menuItemAddCategory);
		menuAdd.add(menuItemAddClient);
		menuAdd.add(menuItemAddFunds);
		menuView.add(menuItemViewBooks);
		menuView.add(menuItemViewAuthors);
		menuView.add(menuItemViewPublishers);
		menuView.add(menuItemViewCategories);
		menuUpdate.add(menuItemUpdateBook);
		menuUpdate.add(menuItemUpdateAuthor);
		menuUpdate.add(menuItemUpdatePublisher);
		menuUpdate.add(menuItemUpdateCategory);
		menuUpdate.add(menuItemUpdateClient);
		menuDelete.add(menuItemDeleteBook);
		menuDelete.add(menuItemDeleteAuthor);
		menuDelete.add(menuItemDeletePublisher);
		menuDelete.add(menuItemDeleteCategory);
		menuDelete.add(menuItemDeleteClient);
		menuSearch.add(menuItemSearchBook);
		menuSearch.add(menuItemSearchAuthor);
		menuSearch.add(menuItemSearchPublisher);
		menuSearch.add(menuItemSearchCategory);
		 
		// Add components to the panel
		//labels
		pane.add(lblUsername);
		pane.add(lblPassword);
		pane.add(lblOption);
		pane.add(lblID);
		pane.add(lblNoOfCopies);
		pane.add(lblTitle);
		pane.add(lblAuthorsIDs);
		pane.add(lblPublisherID);
		pane.add(lblCategoriesIDs);
		pane.add(lblPrice);
		pane.add(lblAuthorsFN);
		pane.add(lblAuthorsLN);
		pane.add(lblName);
		pane.add(lblPhone);
		pane.add(lblAddress);
		pane.add(lblEmail);
		pane.add(lblCredit);
		pane.add(lblOldID);
		pane.add(lblPublisher);
		pane.add(lblCategory);
		pane.add(lblFunds);
		//text fields
		pane.add(txtUsername);
		pane.add(txtPassword);
		pane.add(txtID);
		pane.add(txtNoOfCopies);
		pane.add(txtTitle);
		pane.add(txtAuthorsIDs);
		pane.add(txtPublisherID);
		pane.add(txtCategoriesIDs);
		pane.add(txtPrice);
		pane.add(txtAuthorsFN);
		pane.add(txtAuthorsLN);
		pane.add(txtName);
		pane.add(txtPhone);
		pane.add(txtAddress);
		pane.add(txtEmail);
		pane.add(txtCredit);
		pane.add(txtOldID);
		pane.add(txtPublisher);
		pane.add(txtCategory);
		pane.add(txtFunds);
		//buttons
		pane.add(btnConnect);
		pane.add(btnDisconnect);
		pane.add(btnAddBook);
		pane.add(btnAddAuthor);
		pane.add(btnAddPublisher);
		pane.add(btnAddCategory);
		pane.add(btnAddClient);
		pane.add(btnUpdateBook);
		pane.add(btnUpdateAuthor);
		pane.add(btnUpdatePublisher);
		pane.add(btnUpdateCategory);
		pane.add(btnUpdateClient);
		pane.add(btnDeleteBook);
		pane.add(btnDeleteAuthor);
		pane.add(btnDeletePublisher);
		pane.add(btnDeleteCategory);
		pane.add(btnDeleteClient);
		pane.add(btnSearchBook);
		pane.add(btnSearchAuthor);
		pane.add(btnSearchPublisher);
		pane.add(btnSearchCategory);
		pane.add(btnSearchClient);
		pane.add(btnAddFunds);
		pane.add(btnBuyBook);
		pane.add(btnGetReceipt);
		pane.add(btnSendMail);
		
		//set the position of the components
		//login components
		lblUsername.setBounds(insets.left+HS,insets.top+VS,lblUsername.getPreferredSize().width,lblUsername.getPreferredSize().height);
		txtUsername.setBounds(lblUsername.getX()+lblUsername.getWidth(),lblUsername.getY(),txtUsername.getPreferredSize().width,txtUsername.getPreferredSize().height);
		lblPassword.setBounds(txtUsername.getX()+txtUsername.getWidth()+HS,lblUsername.getY(),lblPassword.getPreferredSize().width,lblPassword.getPreferredSize().height);
		txtPassword.setBounds(lblPassword.getX()+lblPassword.getWidth(),lblUsername.getY(),txtPassword.getPreferredSize().width,txtPassword.getPreferredSize().height);
		btnConnect.setBounds(txtPassword.getX()+txtPassword.getWidth()+HS,lblPassword.getY(),btnConnect.getPreferredSize().width,btnConnect.getPreferredSize().height);	
		btnDisconnect.setBounds(txtPassword.getX()+txtPassword.getWidth()+HS,lblPassword.getY(),btnDisconnect.getPreferredSize().width,btnDisconnect.getPreferredSize().height);	
				
		lblOption.setBounds(insets.left+HS,lblUsername.getY()+lblUsername.getHeight()+2*VS,lblOption.getPreferredSize().width,lblOption.getPreferredSize().height);
		
		//addBook components
		lblID.setBounds(insets.left+HS,lblOption.getY()+lblOption.getHeight()+VS,lblID.getPreferredSize().width,lblID.getPreferredSize().height);
		txtID.setBounds(lblID.getX()+lblID.getWidth(),lblID.getY(),txtID.getPreferredSize().width,txtID.getPreferredSize().height);
		lblTitle.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblTitle.getPreferredSize().width,lblTitle.getPreferredSize().height);
		txtTitle.setBounds(lblTitle.getX()+lblTitle.getWidth(),lblID.getY(),txtTitle.getPreferredSize().width,txtTitle.getPreferredSize().height);	
		lblNoOfCopies.setBounds(txtTitle.getX()+txtTitle.getWidth()+HS,lblID.getY(),lblNoOfCopies.getPreferredSize().width,lblNoOfCopies.getPreferredSize().height);
		txtNoOfCopies.setBounds(lblNoOfCopies.getX()+lblNoOfCopies.getWidth(),lblID.getY(),txtNoOfCopies.getPreferredSize().width,txtNoOfCopies.getPreferredSize().height);		
		lblAuthorsIDs.setBounds(insets.left+HS,lblID.getY()+lblID.getHeight()+VS,lblAuthorsIDs.getPreferredSize().width,lblAuthorsIDs.getPreferredSize().height);
		txtAuthorsIDs.setBounds(lblAuthorsIDs.getX()+lblAuthorsIDs.getWidth(),lblAuthorsIDs.getY(),txtAuthorsIDs.getPreferredSize().width,txtAuthorsIDs.getPreferredSize().height);
		lblPublisherID.setBounds(txtAuthorsIDs.getX()+txtAuthorsIDs.getWidth()+HS,lblAuthorsIDs.getY(),lblPublisherID.getPreferredSize().width,lblPublisherID.getPreferredSize().height);
		txtPublisherID.setBounds(lblPublisherID.getX()+lblPublisherID.getWidth(),lblAuthorsIDs.getY(),txtPublisherID.getPreferredSize().width,txtPublisherID.getPreferredSize().height);
		lblCategoriesIDs.setBounds(txtPublisherID.getX()+txtPublisherID.getWidth()+HS,lblAuthorsIDs.getY(),lblCategoriesIDs.getPreferredSize().width,lblCategoriesIDs.getPreferredSize().height);
		txtCategoriesIDs.setBounds(lblCategoriesIDs.getX()+lblCategoriesIDs.getWidth(),lblAuthorsIDs.getY(),txtCategoriesIDs.getPreferredSize().width,txtCategoriesIDs.getPreferredSize().height);
		
		//addPublisher/Category components
		lblName.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblName.getPreferredSize().width,lblName.getPreferredSize().height);
		txtName.setBounds(lblName.getX()+lblName.getWidth(),lblID.getY(),txtName.getPreferredSize().width,txtName.getPreferredSize().height);	
		btnAddPublisher.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),btnAddPublisher.getPreferredSize().width,btnAddPublisher.getPreferredSize().height);		
		btnAddCategory.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),btnAddCategory.getPreferredSize().width,btnAddCategory.getPreferredSize().height);		
		
		//addClient components
		lblPhone.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),lblPhone.getPreferredSize().width,lblPhone.getPreferredSize().height);		
		txtPhone.setBounds(lblPhone.getX()+lblPhone.getWidth()+HS,lblID.getY(),txtPhone.getPreferredSize().width,txtPhone.getPreferredSize().height);		
		lblAddress.setBounds(insets.left+HS,lblID.getY()+lblID.getWidth()+VS,lblAddress.getPreferredSize().width,lblAddress.getPreferredSize().height);		
		txtAddress.setBounds(lblAddress.getX()+lblAddress.getWidth()+HS,lblAddress.getY(),txtAddress.getPreferredSize().width,txtAddress.getPreferredSize().height);		
		lblEmail.setBounds(txtAddress.getX()+txtAddress.getWidth()+HS,lblAddress.getY(),lblEmail.getPreferredSize().width,lblEmail.getPreferredSize().height);		
		txtEmail.setBounds(lblEmail.getX()+lblEmail.getWidth()+HS,lblAddress.getY(),txtEmail.getPreferredSize().width,txtEmail.getPreferredSize().height);		
		lblCredit.setBounds(txtEmail.getX()+txtEmail.getWidth()+HS,lblAddress.getY(),lblCredit.getPreferredSize().width,lblCredit.getPreferredSize().height);		
		txtCredit.setBounds(lblCredit.getX()+lblCredit.getWidth()+HS,lblAddress.getY(),txtCredit.getPreferredSize().width,txtCredit.getPreferredSize().height);			
		btnAddClient.setBounds(lblCredit.getX()+lblCredit.getWidth()+HS,lblAddress.getY()+lblAddress.getHeight()+VS,btnAddClient.getPreferredSize().width,btnAddClient.getPreferredSize().height);				
		
		//add Funds
		lblFunds.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblFunds.getPreferredSize().width,lblFunds.getPreferredSize().height);
		txtFunds.setBounds(lblFunds.getX()+lblFunds.getWidth(),lblID.getY(),txtFunds.getPreferredSize().width,txtFunds.getPreferredSize().height);
		btnAddFunds.setBounds(txtFunds.getX()+txtFunds.getWidth()+HS,lblID.getY(),btnAddFunds.getPreferredSize().width,btnAddFunds.getPreferredSize().height);
		
		
		//update buttons
		btnUpdatePublisher.setBounds(txtName.getX()+txtName.getWidth()+HS,lblName.getY(),btnUpdatePublisher.getPreferredSize().width,btnUpdatePublisher.getPreferredSize().height);		
		btnUpdateCategory.setBounds(txtName.getX()+txtName.getWidth()+HS,lblName.getY(),btnUpdateCategory.getPreferredSize().width,btnUpdateCategory.getPreferredSize().height);							
		btnUpdateClient.setBounds(insets.left+HS,lblAddress.getY()+lblAddress.getHeight()+VS,btnUpdateClient.getPreferredSize().width,btnUpdateClient.getPreferredSize().height);	
		
		//delete buttons
		btnDeleteBook.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnDeleteBook.getPreferredSize().width,btnDeleteBook.getPreferredSize().height);
		btnDeleteAuthor.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnDeleteAuthor.getPreferredSize().width,btnDeleteAuthor.getPreferredSize().height);
		btnDeletePublisher.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnDeletePublisher.getPreferredSize().width,btnDeletePublisher.getPreferredSize().height);
		btnDeleteCategory.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnDeleteCategory.getPreferredSize().width,btnDeleteCategory.getPreferredSize().height);
		btnDeleteClient.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnDeleteClient.getPreferredSize().width,btnDeleteClient.getPreferredSize().height);
		
		//Search buttons 
	    btnSearchPublisher.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),btnSearchPublisher.getPreferredSize().width,btnSearchPublisher.getPreferredSize().height);		
		btnSearchCategory.setBounds(txtName.getX()+txtName.getWidth()+HS,lblID.getY(),btnSearchCategory.getPreferredSize().width,btnSearchCategory.getPreferredSize().height);		
		btnSearchClient.setBounds(lblCredit.getX()+lblCredit.getWidth()+HS,lblAddress.getY()+lblAddress.getHeight()+VS,btnSearchClient.getPreferredSize().width,btnSearchClient.getPreferredSize().height);				
		
		//Buy button
		btnBuyBook.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),btnBuyBook.getPreferredSize().width,btnBuyBook.getPreferredSize().height);
		//getReceipt button
		btnGetReceipt.setBounds(btnBuyBook.getX()+btnBuyBook.getWidth()+HS,lblID.getY(),btnGetReceipt.getPreferredSize().width,btnGetReceipt.getPreferredSize().height);
		btnSendMail.setBounds(btnGetReceipt.getX()+btnGetReceipt.getWidth()+HS,lblID.getY(),btnSendMail.getPreferredSize().width,btnSendMail.getPreferredSize().height);
		
		//Sets the frame visible, and its position to the centre of the screen
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
		
		//sets the login options enabled, and the rest unavailable
		this.setLoginEnabled(true);
	}

	//-------------------------------------------------------------------------------------------------Methods for adding ActionListeners to menuItems
	
	/**
	 * Method for adding an ActionListener to the "menuItemViewBooks" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewBooks(ActionListener e) {
		menuItemViewBooks.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "menuItemViewAuthors" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewAuthors(ActionListener e) {
		menuItemViewAuthors.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemViewPublishers" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewPublishers(ActionListener e) {
		menuItemViewPublishers.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemViewCategories" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewCategories(ActionListener e) {
		menuItemViewCategories.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemViewAccount" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewAccount(ActionListener e) {
		menuItemViewAccount.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemViewClients" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemViewClients(ActionListener e) {
		menuItemViewClients.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemAddBook" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddBook(ActionListener e) {
		menuItemAddBook.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "menuItemAddAuthor" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddAuthor(ActionListener e) {
		menuItemAddAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemAddPublisher" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddPublisher(ActionListener e) {
		menuItemAddPublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemAddCategory" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddCategory(ActionListener e) {
		menuItemAddCategory.addActionListener(e);
	}
	
	
	/**
	 * Method for adding an ActionListener to the "menuItemAddClient" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddClient(ActionListener e) {
		menuItemAddClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemAddFunds" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemAddFunds(ActionListener e) {
		menuItemAddFunds.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemUpdateBook" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemUpdateBook(ActionListener e) {
		menuItemUpdateBook.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "menuItemUpdateAuthor" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemUpdateAuthor(ActionListener e) {
		menuItemUpdateAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemUpdatePublisher" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemUpdatePublisher(ActionListener e) {
		menuItemUpdatePublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemUpdateCategory" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemUpdateCategory(ActionListener e) {
		menuItemUpdateCategory.addActionListener(e);
		}
		
	
	/**
	 * Method for adding an ActionListener to the "menuItemUpdateClient" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemUpdateClient(ActionListener e) {
		menuItemUpdateClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemDeleteBook" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemDeleteBook(ActionListener e) {
		menuItemDeleteBook.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "menuItemDeleteAuthor" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemDeleteAuthor(ActionListener e) {
		menuItemDeleteAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemDeletePublisher" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemDeletePublisher(ActionListener e) {
		menuItemDeletePublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemDeleteCategory" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemDeleteCategory(ActionListener e) {
		menuItemDeleteCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemDeleteClient" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemDeleteClient(ActionListener e) {
		menuItemDeleteClient.addActionListener(e);
	}
	
	
	/**
	 * Method for adding an ActionListener to the "menuItemSearchBook" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemSearchBook(ActionListener e) {
		menuItemSearchBook.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "menuItemSearchAuthor" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemSearchAuthor(ActionListener e) {
		menuItemSearchAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemSearchPublisher" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemSearchPublisher(ActionListener e) {
		menuItemSearchPublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemSearchCategory" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemSearchCategory(ActionListener e) {
		menuItemSearchCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemSearchClient" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemSearchClient(ActionListener e) {
		menuItemSearchClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "menuItemBuyBook" menu Item
	 * @param e an ActionListener
	 */
	public void addActionListenerMenuItemBuyBook(ActionListener e) {
		menuItemBuyBook.addActionListener(e);
	}
	//-------------------------------------------------------------------------------------------------Methods for adding ActionListeners to buttons 

	/**
	 * Method for adding an ActionListener to the "btnConnect" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnConnect(ActionListener e) {
		btnConnect.addActionListener(e);
	}

	/**
	 * Method for adding an ActionListener to the "btnDisconnect" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDisconnect(ActionListener e) {
		btnDisconnect.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddBook" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddBook(ActionListener e) {
		btnAddBook.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddAuthor" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddAuthor(ActionListener e) {
		btnAddAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddPublisher" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddPublisher(ActionListener e) {
		btnAddPublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddCategory" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddCategory(ActionListener e) {
		btnAddCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddClient" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddClient(ActionListener e) {
		btnAddClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnAddFunds" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnAddFunds(ActionListener e) {
		btnAddFunds.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnUpdateBook" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnUpdateBook(ActionListener e) {
		btnUpdateBook.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnUpdateAuthor" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnUpdateAuthor(ActionListener e) {
		btnUpdateAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnUpdatePublisher" button
Update @param e an ActionListener
	 */
	public void addActionListenerBtnUpdatePublisher(ActionListener e) {
		btnUpdatePublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnUpdateCategory" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnUpdateCategory(ActionListener e) {
		btnUpdateCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnUpdateClient" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnUpdateClient(ActionListener e) {
		btnUpdateClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnDeleteBook" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDeleteBook(ActionListener e) {
		btnDeleteBook.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnDeleteAuthor" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDeleteAuthor(ActionListener e) {
		btnDeleteAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnDeletePublisher" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDeletePublisher(ActionListener e) {
		btnDeletePublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnDeleteCategory" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDeleteCategory(ActionListener e) {
		btnDeleteCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnDeleteClient" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnDeleteClient(ActionListener e) {
		btnDeleteClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSearchBook" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSearchBook(ActionListener e) {
		btnSearchBook.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSearchAuthor" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSearchAuthor(ActionListener e) {
		btnSearchAuthor.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSearchPublisher" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSearchPublisher(ActionListener e) {
		btnSearchPublisher.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSearchCategory" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSearchCategory(ActionListener e) {
		btnSearchCategory.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSearchClient" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSearchClient(ActionListener e) {
		btnSearchClient.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnBuyBook" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnBuyBook(ActionListener e) {
		btnBuyBook.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnGetReceipt" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnGetReceipt(ActionListener e) {
		btnGetReceipt.addActionListener(e);
	}
	
	/**
	 * Method for adding an ActionListener to the "btnSendEmail" button
	 * @param e an ActionListener
	 */
	public void addActionListenerBtnSendEmail(ActionListener e) {
		btnSendMail.addActionListener(e);
	}
	//-------------------------------------------------------------------------------------------------Methods for checking for valid input
	
	/**
	 * Check for valid number in a string
	 * @param s the string to be checked
	 */
	public boolean checkForValidNumber(String s)
	{
		try{
			Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	
	/**
	 * Check for valid, positive number in a string
	 * @param s the string to be checked
	 */
	public boolean checkForValidPositiveNumber(String s)
	{
		int nr=-1;
		try{
			nr=Integer.parseInt(s);
		}
		catch (NumberFormatException e)
		{
			return false;
		}
		if (nr<=-1) return false;
		else return true;
	}
	
	/**
	 * Check for a valid string (not "")
	 * @param s the string to be checked
	 */
	public boolean checkForValidString(String s)
	{
		if (s.equals("")) return false;
		else return true;
	}
	
	/**
	 * Checks for valid login input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidLoginInput()
	{
		if (!checkForValidString(txtUsername.getText())) return false;
		else if (!checkForValidString(new String(txtPassword.getPassword()))) return false;
		else return true;
	}
	
	/**
	 * Checks for valid addBook input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddBookInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtTitle.getText())) return false;
		else if (!checkForValidPositiveNumber(txtNoOfCopies.getText())) return false;		
		else if (!checkForValidNumber(txtPublisherID.getText())) return false;
		else if (!checkForValidPositiveNumber(txtPrice.getText())) return false;	
		else for (String s:txtCategoriesIDs.getText().split(","))
			if (!checkForValidNumber(s)) return false;
		for (String s:txtAuthorsIDs.getText().split(","))
			if (!checkForValidNumber(s)) return false;
		return true;
	}

	/**
	 * Checks for valid addAuthor input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddAuthorInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtAuthorsFN.getText())) return false;
		else if (!checkForValidString(txtAuthorsLN.getText())) return false;		
		else return true;
	}
	
	
	/**
	 * Checks for valid addPublisher input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddPublisherInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;		
		else return true;
	}
	
	/**
	 * Checks for valid addCategory input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddCategoryInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;		
		else return true;
	}
	
	/**
	 * Checks for valid addClient input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddClientInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;		
		else if (!checkForValidString(txtPhone.getText())) return false;	
		else if (!checkForValidString(txtAddress.getText())) return false;	
		else if (!checkForValidString(txtEmail.getText())) return false;	
		else if (!checkForValidPositiveNumber(txtCredit.getText())) return false;	
		else return true;
	}
	
	/**
	 * Checks for valid addFunds input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidAddFundsInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidNumber(txtFunds.getText())) return false;		
		else return true;
	}
	
	/**
	 * Checks for valid UpdateBook input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidUpdateBookInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtTitle.getText())) return false;
		else if (!checkForValidPositiveNumber(txtNoOfCopies.getText())) return false;		
		else if (!checkForValidNumber(txtPublisherID.getText())) return false;
		else if (!checkForValidPositiveNumber(txtPrice.getText())) return false;	
		else for (String s:txtCategoriesIDs.getText().split(","))
			if (!checkForValidNumber(s)) return false;
		for (String s:txtAuthorsIDs.getText().split(","))
			if (!checkForValidNumber(s)) return false;
		if (!checkForValidNumber(txtOldID.getText())) return false;
		return true;
	}

	/**
	 * Checks for valid UpdateAuthor input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidUpdateAuthorInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtAuthorsFN.getText())) return false;
		else if (!checkForValidString(txtAuthorsLN.getText())) return false;
		else return true;
	}
	
	
	/**
	 * Checks for valid UpdatePublisher input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidUpdatePublisherInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;	
		else return true;
	}
	
	/**
	 * Checks for valid UpdateCategory input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidUpdateCategoryInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;		
		else return true;
	}
	
	/**
	 * Checks for valid UpdateClient input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidUpdateClientInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else if (!checkForValidString(txtName.getText())) return false;		
		else if (!checkForValidString(txtPhone.getText())) return false;	
		else if (!checkForValidString(txtAddress.getText())) return false;	
		else if (!checkForValidString(txtEmail.getText())) return false;	
		else if (!checkForValidPositiveNumber(txtCredit.getText())) return false;	
		else return true;
	}
	
	/**
	 * Checks for valid ID input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidIDInput()
	{
		if (!checkForValidNumber(txtID.getText())) return false;
		else return true;
	}
	
	/**
	 * Checks for valid SearchBook input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidSearchBookInput()
	{
		//at least one field must be filled correctly to in order to search
		if (checkForValidNumber(txtID.getText())) return true;
		else if (checkForValidString(txtTitle.getText())) return true;
		else if (checkForValidPositiveNumber(txtNoOfCopies.getText())) return true;		
		else if (checkForValidString(txtAuthorsFN.getText())) return true;
		else if (checkForValidString(txtAuthorsLN.getText())) return true;
		else if (checkForValidString(txtPublisher.getText())) return true;
		else if (checkForValidString(txtCategory.getText())) return true;
		else if (checkForValidPositiveNumber(txtPrice.getText())) return true;	
		else return false;
	}
	
	/**
	 * Checks for valid SearchAuthor input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidSearchAuthorInput()
	{
		if (checkForValidNumber(txtID.getText())) return true;
		else if (checkForValidString(txtAuthorsFN.getText())) return true;
		else if (checkForValidString(txtAuthorsLN.getText())) return true;		
		else return false;
	}
	
	
	/**
	 * Checks for valid SearchPublisher input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidSearchPublisherInput()
	{
		if (checkForValidNumber(txtID.getText())) return true;
		else if (checkForValidString(txtName.getText())) return true;		
		else return false;
	}
	
	/**
	 * Checks for valid SearchCategory input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidSearchCategoryInput()
	{
		if (checkForValidNumber(txtID.getText())) return true;
		else if (checkForValidString(txtName.getText())) return true;		
		else return false;
	}
	
	/**
	 * Checks for valid SearchClient input
	 * @return true if the input is valid, false otherwise
	 */
	public boolean checkForValidSearchClientInput()
	{
		if (checkForValidNumber(txtID.getText())) return true;
		else if (checkForValidString(txtName.getText())) return true;		
		else if (checkForValidString(txtPhone.getText())) return true;	
		else if (checkForValidString(txtAddress.getText())) return true;	
		else if (checkForValidString(txtEmail.getText())) return true;	
		else if (checkForValidPositiveNumber(txtCredit.getText())) return true;	
		else return false;
	}
	
	//-------------------------------------------------------------------------------------------------Methods for getting input
	
	/**
	 * Obtains the userName for login
	 * @return a string containing the userName
	 */
	public String getUsername() {
		return txtUsername.getText();
	}

	/**
	 * Obtains the password for login
	 * @return an array of characters containing the password
	 */
	public char[] getPassword() {
		return txtPassword.getPassword();
	}

	/**
	 * Obtains the ID
	 * @return the number contained in the ID text field, or null if no number is contained
	 */
	public Integer getID()
	{
		try {
			int nr=Integer.parseInt(txtID.getText());
			return nr;
			}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
	

	/**
	 * Obtains the AuthorsIDs
	 * @return the number contained in the AuthorsIDs text field, or null if not only numbers separated by commas are contained
	 */
	public Integer[] getAuthorsIDs()
	{
		try{
		String[] tmpStrings=txtAuthorsIDs.getText().split(",");
		Integer[] tmpIntegers=new Integer[tmpStrings.length];
		for(int i=0; i<tmpStrings.length; i++)
			tmpIntegers[i]=Integer.parseInt(tmpStrings[i]);
		return tmpIntegers;
		}
		catch (NumberFormatException r)
		{
			return null;
		}
	}
	
	/**
	 * Obtains the PublisherID
	 * @return the number contained in the PublisherID text field, or null if no number is contained
	 */
	public Integer getPublisherID()
	{
		try {
			int nr=Integer.parseInt(txtPublisherID.getText());
			return nr;
			}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
	
	/**
	 * Obtains the Title
	 * @return the string contained in the Title text field
	 */
	public String getTitle()
	{
		return txtTitle.getText();
	}
	
	/**
	 * Obtains the noOfCopies
	 * @return the number contained in the noOfCopies text field, or null if no number is contained
	 */
	public Integer getNoOfCopies() {
		try {
			int nr=Integer.parseInt(txtNoOfCopies.getText());
			return nr;
			}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
	
	/**
	 * Obtains the CategoriesIDs 
	 * @return the numbers contained in the CategoriesIDs text field, or null if not only numbers separated by commas are contained 
	 */
	public Integer[] getCategoriesIDs()
	{
		try{
		String[] tmpStrings=txtCategoriesIDs.getText().split(",");
		Integer[] tmpIntegers=new Integer[tmpStrings.length];
		for(int i=0; i<tmpStrings.length; i++)
			tmpIntegers[i]=Integer.parseInt(tmpStrings[i]);
		return tmpIntegers;
		}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
	
	/**
	 * Obtains the price
	 * @return the number contained in the Price text field, or null if no number is contained
	 */
	public Integer getPrice() {
		try {
			return Integer.parseInt(txtPrice.getText());
			}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
		
	/**
	 * Obtains the funds
	 * @return the number contained in the funds text field
	 */
	public Integer getFunds() {
	return Integer.parseInt(txtFunds.getText());
	}
	
	/**
	 * Obtains the Author's FirstName
	 * @return the string contained in the AuthorsFN text field
	 */
	public String getAuthorsFN()
	{
		return txtAuthorsFN.getText();
	}
	
	/**
	 * Obtains the Author's LastName
	 * @return the string contained in the AuthorsLN text field
	 */
	public String getAuthorsLN()
	{
		return txtAuthorsLN.getText();
	}
	
	/**
	 * Obtains the Name
	 * @return the string contained in the Name text field
	 */
	public String getName()
	{
		return txtName.getText();
	}
	
	/**
	 * Obtains the Phone
	 * @return the string contained in the Phone text field
	 */
	public String getPhone()
	{
		return txtPhone.getText();
	}
	
	/**
	 * Obtains the Address
	 * @return the string contained in the Address text field
	 */
	public String getAddress()
	{
		return txtAddress.getText();
	}
	
	/**
	 * Obtains the Email
	 * @return the string contained in the Email text field
	 */
	public String getEmail()
	{
		return txtEmail.getText();
	}
	
	/**
	 * Obtains the Credit
	 * @return the number contained in the Credit text field
	 */
	public Integer getCredit()
	{
		try 
		{
			return Integer.parseInt(txtCredit.getText());
		}
		catch(NumberFormatException e)
		{
			return null;
		}
	}
		
	
	/**
	 * Obtains the OldID
	 * @return the number contained in the OldID text field
	 */
	public Integer getOldID()
	{
		return Integer.parseInt(txtOldID.getText());
	}
	
	/**
	 * Obtains the Publisher
	 * @return the string contained in the Publisher text field
	 */
	public String getPublisher()
	{
		return txtPublisher.getText();
	}
	
	/**
	 * Obtains the Category
	 * @return the string contained in the Category text field
	 */
	public String getCategory()
	{
		return txtCategory.getText();
	}
	//-------------------------------------------------------------------------------------------------Methods for resetting input
	
	
	/**
	 * Resets the Book input
	 */
	public void resetBookInput() {
		txtID.setText("");
		txtTitle.setText("");
		txtNoOfCopies.setText("");
		txtAuthorsIDs.setText("");
		txtPublisherID.setText("");
		txtCategoriesIDs.setText("");	
		txtPrice.setText("");
		txtOldID.setText("");
	}

	/**
	 * Resets the Author input
	 */
	public void resetAuthorInput() {
		txtID.setText("");
		txtAuthorsFN.setText("");
		txtAuthorsLN.setText("");
	}
	
	/**
	 * Resets the Publisher input
	 */
	public void resetPublisherInput() {
		txtID.setText("");
		txtName.setText("");
	}
	
	/**
	 * Resets the Category input
	 */
	public void resetCategoryInput() {
		txtID.setText("");
		txtName.setText("");
	}
	
	/**
	 * Resets the Client input
	 */
	public void resetClientInput() {
		txtID.setText("");
		txtName.setText("");
		txtPhone.setText("");
		txtAddress.setText("");
		txtEmail.setText("");
		txtCredit.setText("");
	}
	
	/**
	 * Resets the Funds input
	 */
	public void resetFundsInput() {
		txtID.setText("");
		txtFunds.setText("");
	}
	
	/**
	 * Resets the ID input
	 */
	public void resetIDInput() {
		txtID.setText("");
	}
	
	/**
	 * Resets the SearchBook input
	 */
	public void resetSearchBookInput() {
		txtID.setText("");
		txtTitle.setText("");
		txtNoOfCopies.setText("");
		txtAuthorsFN.setText("");
		txtAuthorsLN.setText("");
		txtPublisher.setText("");
		txtCategory.setText("");	
		txtPrice.setText("");
	}
	//-------------------------------------------------------------------------------------------------Methods for changing the view
	
	/**
	 * sets the view so only login options are available or all others according to b
	 * @param b true to set enabled, false to set disabled
	 */
	public void setLoginEnabled(boolean b) {
		lblUsername.setEnabled(b);
		txtUsername.setEnabled(b);
		lblPassword.setEnabled(b);
		txtPassword.setEnabled(b);
		btnConnect.setVisible(b);
		btnDisconnect.setVisible(!b);
		if (b)
		{
			txtUsername.setText("");
			txtPassword.setText("");
			frame1.setJMenuBar(null);
			frame1.setSize(450, 80);
			frame1.setLocationRelativeTo(null);
		}
		this.setAllOptionsOff();
	}
	
	/**
	 * Sets the view for employee or client depending on b
	 * @param b true if the login details belong to an employee
	 */
	public void setEmployeeView(boolean b) {
		frame1.setJMenuBar(menuBar);
		frame1.setSize(450, 500);
		frame1.setLocationRelativeTo(null);
		if (b)
			{
				menuBar.add(menuAdd);
				menuBar.add(menuUpdate);
				menuBar.add(menuDelete);
				menuBar.remove(menuBuy);
				menuView.add(menuItemViewClients);
				menuView.remove(menuItemViewAccount);
				menuSearch.add(menuItemSearchClient);
				menuBuy.remove(menuItemBuyBook);
			}
		else 
			{
				setAllOptionsOff();
				menuBar.add(menuBuy);
				menuBar.remove(menuAdd);
				menuBar.remove(menuUpdate);
				menuBar.remove(menuDelete);
				menuView.remove(menuItemViewClients);
				menuView.add(menuItemViewAccount);
				menuSearch.remove(menuItemSearchClient);	
				menuBuy.add(menuItemBuyBook);
			}
		}

	private void setAllOptionsOff() {
		this.setAddBookOptions(false);
		this.setAddAuthorOptions(false);
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
	}		

	/**
	 * Sets the AddBook options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddBookOptions(boolean b) {
		if(b)
			{
				lblOption.setText("Add a book:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblPrice.setBounds(insets.left+HS,lblAuthorsIDs.getY()+lblAuthorsIDs.getHeight()+VS,lblPrice.getPreferredSize().width,lblPrice.getPreferredSize().height);
				txtPrice.setBounds(lblPrice.getX()+lblPrice.getWidth(),lblPrice.getY(),txtPrice.getPreferredSize().width,txtPrice.getPreferredSize().height);	
				btnAddBook.setBounds(txtPrice.getX()+txtPrice.getWidth()+HS,lblPrice.getY(),btnAddBook.getPreferredSize().width,btnAddBook.getPreferredSize().height);
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblTitle.setVisible(b);
		lblNoOfCopies.setVisible(b);
		lblAuthorsIDs.setVisible(b);
		lblPublisherID.setVisible(b);
		lblCategoriesIDs.setVisible(b);
		lblPrice.setVisible(b);
		txtID.setVisible(b);
		txtTitle.setVisible(b);
		txtNoOfCopies.setVisible(b);
		txtAuthorsIDs.setVisible(b);
		txtPublisherID.setVisible(b);
		txtCategoriesIDs.setVisible(b);
		txtPrice.setVisible(b);
		btnAddBook.setVisible(b);
	}
	
	/**
	 * Sets the AddAuthor options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddAuthorOptions(boolean b) {
		if (b)
			{
				lblOption.setText("Add an author:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblAuthorsFN.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblAuthorsFN.getPreferredSize().width,lblAuthorsFN.getPreferredSize().height);
				txtAuthorsFN.setBounds(lblAuthorsFN.getX()+lblAuthorsFN.getWidth(),lblID.getY(),txtAuthorsFN.getPreferredSize().width,txtAuthorsFN.getPreferredSize().height);	
				lblAuthorsLN.setBounds(insets.left+HS,lblID.getY()+lblID.getWidth()+VS,lblAuthorsLN.getPreferredSize().width,lblAuthorsLN.getPreferredSize().height);
				txtAuthorsLN.setBounds(lblAuthorsLN.getX()+lblAuthorsLN.getWidth(),lblAuthorsLN.getY(),txtAuthorsLN.getPreferredSize().width,txtAuthorsLN.getPreferredSize().height);		
				btnAddAuthor.setBounds(txtAuthorsLN.getX()+txtAuthorsLN.getWidth()+HS,lblAuthorsLN.getY(),btnAddAuthor.getPreferredSize().width,btnAddAuthor.getPreferredSize().height);						
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblAuthorsFN.setVisible(b);
		lblAuthorsLN.setVisible(b);	
		txtID.setVisible(b);
		txtAuthorsFN.setVisible(b);
		txtAuthorsLN.setVisible(b);
		btnAddAuthor.setVisible(b);
	}
	
	/**
	 * Sets the AddPublisher options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddPublisherOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Add a publisher:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);;
		btnAddPublisher.setVisible(b);
	}
	
	/**
	 * Sets the AddCategory options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddCategoryOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Add a Category:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);;
		btnAddCategory.setVisible(b);
	}
	
	/**
	 * Sets the AddClient options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddClientOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Add a Client:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		lblPhone.setVisible(b);
		lblAddress.setVisible(b);
		lblEmail.setVisible(b);
		lblCredit.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		txtPhone.setVisible(b);
		txtAddress.setVisible(b);
		txtEmail.setVisible(b);
		txtCredit.setVisible(b);
		btnAddClient.setVisible(b);
	}
	
	/**
	 * Sets the AddFunds options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setAddFundsOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Add Funds to a specified client's account:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblID.setVisible(b);
		lblFunds.setVisible(b);
		txtID.setVisible(b);
		txtFunds.setVisible(b);
		btnAddFunds.setVisible(b);
	}
	
	/**
	 * Sets the UpdateBook options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setUpdateBookOptions(boolean b) {
		if(b)
			{
				lblOption.setText("Update a book:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblPrice.setBounds(insets.left+HS,lblAuthorsIDs.getY()+lblAuthorsIDs.getHeight()+VS,lblPrice.getPreferredSize().width,lblPrice.getPreferredSize().height);
				txtPrice.setBounds(lblPrice.getX()+lblPrice.getWidth(),lblPrice.getY(),txtPrice.getPreferredSize().width,txtPrice.getPreferredSize().height);	
				lblOldID.setBounds(txtPrice.getX()+txtPrice.getWidth()+HS,lblPrice.getY(),lblOldID.getPreferredSize().width,lblOldID.getPreferredSize().height);
				txtOldID.setBounds(lblOldID.getX()+lblOldID.getWidth()+HS,lblOldID.getY(),txtOldID.getPreferredSize().width,txtOldID.getPreferredSize().height);
				btnUpdateBook.setBounds(txtOldID.getX()+txtOldID.getWidth()+HS,lblOldID.getY(),btnUpdateBook.getPreferredSize().width,btnUpdateBook.getPreferredSize().height);					
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblTitle.setVisible(b);
		lblNoOfCopies.setVisible(b);
		lblAuthorsIDs.setVisible(b);
		lblPublisherID.setVisible(b);
		lblCategoriesIDs.setVisible(b);
		lblPrice.setVisible(b);
		lblOldID.setVisible(b);
		txtID.setVisible(b);
		txtTitle.setVisible(b);
		txtNoOfCopies.setVisible(b);
		txtAuthorsIDs.setVisible(b);
		txtPublisherID.setVisible(b);
		txtCategoriesIDs.setVisible(b);
		txtPrice.setVisible(b);
		txtOldID.setVisible(b);
		btnUpdateBook.setVisible(b);
	}
	
	/**
	 * Sets the UpdateAuthor options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setUpdateAuthorOptions(boolean b) {
		if (b)
			{
				lblOption.setText("Update an author:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblAuthorsFN.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblAuthorsFN.getPreferredSize().width,lblAuthorsFN.getPreferredSize().height);
				txtAuthorsFN.setBounds(lblAuthorsFN.getX()+lblAuthorsFN.getWidth(),lblID.getY(),txtAuthorsFN.getPreferredSize().width,txtAuthorsFN.getPreferredSize().height);	
				lblAuthorsLN.setBounds(insets.left+HS,lblID.getY()+lblID.getWidth()+VS,lblAuthorsLN.getPreferredSize().width,lblAuthorsLN.getPreferredSize().height);
				txtAuthorsLN.setBounds(lblAuthorsLN.getX()+lblAuthorsLN.getWidth(),lblAuthorsLN.getY(),txtAuthorsLN.getPreferredSize().width,txtAuthorsLN.getPreferredSize().height);		
				btnUpdateAuthor.setBounds(txtAuthorsLN.getX()+txtAuthorsLN.getWidth()+HS,lblAuthorsLN.getY(),btnUpdateAuthor.getPreferredSize().width,btnUpdateAuthor.getPreferredSize().height);							
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblAuthorsFN.setVisible(b);
		lblAuthorsLN.setVisible(b);	
		txtID.setVisible(b);
		txtAuthorsFN.setVisible(b);
		txtAuthorsLN.setVisible(b);
		btnUpdateAuthor.setVisible(b);
	}
	
	/**
	 * Sets the UpdatePublisher options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setUpdatePublisherOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Update a publisher:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		btnUpdatePublisher.setVisible(b);
	}
	
	/**
	 * Sets the UpdateCategory options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setUpdateCategoryOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Update a Category:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		btnUpdateCategory.setVisible(b);
	}
	
	/**
	 * Sets the UpdateClient options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setUpdateClientOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Update a Client:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		lblPhone.setVisible(b);
		lblAddress.setVisible(b);
		lblEmail.setVisible(b);
		lblCredit.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		txtPhone.setVisible(b);
		txtAddress.setVisible(b);
		txtEmail.setVisible(b);
		txtCredit.setVisible(b);
		btnUpdateClient.setVisible(b);
	}
	
	/**
	 * Sets the DeleteBook options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setDeleteBookOptions(boolean b) {
		if(b)
			{
				lblOption.setText("Delete a book:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);
		btnDeleteBook.setVisible(b);
	}
	
	/**
	 * Sets the DeleteAuthor options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setDeleteAuthorOptions(boolean b) {
		if (b)
			{
				lblOption.setText("Delete an author:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);
		btnDeleteAuthor.setVisible(b);
	}
	
	/**
	 * Sets the DeletePublisher options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setDeletePublisherOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Delete a publisher:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);
		btnDeletePublisher.setVisible(b);
	}
	
	/**
	 * Sets the DeleteCategory options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setDeleteCategoryOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Delete a Category:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);
		btnDeleteCategory.setVisible(b);
	}
	
	/**
	 * Sets the DeleteClient options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setDeleteClientOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Delete a Client:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);
		btnDeleteClient.setVisible(b);
	}
	
	/**
	 * Sets the SearchBook options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setSearchBookOptions(boolean b) {
		if(b)
			{
				lblOption.setText("Search a book:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblAuthorsFN.setBounds(insets.left+HS,lblID.getY()+lblID.getHeight()+VS,lblAuthorsFN.getPreferredSize().width,lblAuthorsFN.getPreferredSize().height);
				txtAuthorsFN.setBounds(lblAuthorsFN.getX()+lblAuthorsFN.getWidth()+HS,lblAuthorsFN.getY(),txtAuthorsFN.getPreferredSize().width,txtAuthorsFN.getPreferredSize().height);			
				lblAuthorsLN.setBounds(txtAuthorsFN.getX()+txtAuthorsFN.getWidth()+HS,lblAuthorsFN.getY(),lblAuthorsLN.getPreferredSize().width,lblAuthorsLN.getPreferredSize().height);
				txtAuthorsLN.setBounds(lblAuthorsLN.getX()+lblAuthorsLN.getWidth()+HS,lblAuthorsFN.getY(),txtAuthorsLN.getPreferredSize().width,txtAuthorsLN.getPreferredSize().height);			
				lblPublisher.setBounds(insets.left+HS,lblAuthorsFN.getY()+lblAuthorsFN.getHeight()+VS, lblPublisher.getPreferredSize().width,lblPublisher.getPreferredSize().height);
				txtPublisher.setBounds(lblPublisher.getX()+lblPublisher.getWidth(),lblPublisher.getY(),txtPublisher.getPreferredSize().width,txtPublisher.getPreferredSize().height);			
				lblCategory.setBounds(txtPublisher.getX()+txtPublisher.getWidth()+HS,lblPublisher.getY(), lblCategory.getPreferredSize().width,lblCategory.getPreferredSize().height);
				txtCategory.setBounds(lblCategory.getX()+lblCategory.getWidth(),lblPublisher.getY(),txtCategory.getPreferredSize().width,txtCategory.getPreferredSize().height);			
				lblPrice.setBounds(txtCategory.getX()+txtCategory.getWidth()+HS,lblPublisher.getY(),lblPrice.getPreferredSize().width,lblPrice.getPreferredSize().height);
				txtPrice.setBounds(lblPrice.getX()+lblPrice.getWidth(),lblPrice.getY(),txtPrice.getPreferredSize().width,txtPrice.getPreferredSize().height);		
				btnSearchBook.setBounds(insets.left+HS,lblPrice.getY()+lblPrice.getHeight()+VS,btnSearchBook.getPreferredSize().width,btnSearchBook.getPreferredSize().height);			
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblTitle.setVisible(b);
		lblNoOfCopies.setVisible(b);
		lblAuthorsFN.setVisible(b);
		lblAuthorsLN.setVisible(b);
		lblPublisher.setVisible(b);
		lblCategory.setVisible(b);
		lblPrice.setVisible(b);
		txtID.setVisible(b);
		txtTitle.setVisible(b);
		txtNoOfCopies.setVisible(b);
		txtAuthorsFN.setVisible(b);
		txtAuthorsLN.setVisible(b);
		txtPublisher.setVisible(b);
		txtCategory.setVisible(b);
		txtPrice.setVisible(b);
		btnSearchBook.setVisible(b);
	}
	
	/**
	 * Sets the SearchAuthor options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setSearchAuthorOptions(boolean b) {
		if (b)
			{
				lblOption.setText("Search an author:");
				lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
				lblAuthorsFN.setBounds(txtID.getX()+txtID.getWidth()+HS,lblID.getY(),lblAuthorsFN.getPreferredSize().width,lblAuthorsFN.getPreferredSize().height);
				txtAuthorsFN.setBounds(lblAuthorsFN.getX()+lblAuthorsFN.getWidth(),lblID.getY(),txtAuthorsFN.getPreferredSize().width,txtAuthorsFN.getPreferredSize().height);	
				lblAuthorsLN.setBounds(insets.left+HS,lblID.getY()+lblID.getWidth()+VS,lblAuthorsLN.getPreferredSize().width,lblAuthorsLN.getPreferredSize().height);
				txtAuthorsLN.setBounds(lblAuthorsLN.getX()+lblAuthorsLN.getWidth(),lblAuthorsLN.getY(),txtAuthorsLN.getPreferredSize().width,txtAuthorsLN.getPreferredSize().height);		
				btnSearchAuthor.setBounds(txtAuthorsLN.getX()+txtAuthorsLN.getWidth()+HS,lblAuthorsLN.getY(),btnSearchAuthor.getPreferredSize().width,btnSearchAuthor.getPreferredSize().height);		
			}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblAuthorsFN.setVisible(b);
		lblAuthorsLN.setVisible(b);	
		txtID.setVisible(b);
		txtAuthorsFN.setVisible(b);
		txtAuthorsLN.setVisible(b);
		btnSearchAuthor.setVisible(b);
	}
	
	/**
	 * Sets the SearchPublisher options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setSearchPublisherOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Search a publisher:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);;
		btnSearchPublisher.setVisible(b);
	}
	
	/**
	 * Sets the SearchCategory options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setSearchCategoryOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Search a Category:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		btnSearchCategory.setVisible(b);
	}
	
	/**
	 * Sets the SearchClient options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setSearchClientOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Search a Client:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		lblName.setVisible(b);
		lblPhone.setVisible(b);
		lblAddress.setVisible(b);
		lblEmail.setVisible(b);
		lblCredit.setVisible(b);
		txtID.setVisible(b);
		txtName.setVisible(b);
		txtPhone.setVisible(b);
		txtAddress.setVisible(b);
		txtEmail.setVisible(b);
		txtCredit.setVisible(b);	
		btnSearchClient.setVisible(b);
	}
	
	/**
	 * Sets the Buy options according to b
	 * @param b true if the options should be available, otherwise false
	 */
	public void setBuyOptions(boolean b) {
		if (b)
		{
			lblOption.setText("Buy a book:");
			lblOption.setSize(lblOption.getPreferredSize().width, lblOption.getPreferredSize().height);
		}
		lblOption.setVisible(b);
		lblID.setVisible(b);
		txtID.setVisible(b);	
		btnBuyBook.setVisible(b);
		btnGetReceipt.setVisible(b);	
		btnSendMail.setVisible(b);
	}

	/**
	 * Sets only the options for adding a book available.
	 */
	public void setAddBookOptionsOnly() {
		this.setAddAuthorOptions(false);
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddBookOptions(true);
	}

	/**
	 * Sets only the options for adding an author available.
	 */
	public void setAddAuthorOptionsOnly() {
		this.setAddBookOptions(false);
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddAuthorOptions(true);	
	}

	/**
	 * Sets only the options for adding a publisher available.
	 */
	public void setAddPublisherOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddPublisherOptions(true);
	}
	

	/**
	 * Sets only the options for adding a Category available.
	 */
	public void setAddCategoryOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddCategoryOptions(true);
	}
	

	/**
	 * Sets only the options for adding a Client available.
	 */
	public void setAddClientOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddClientOptions(true);
	}
	
	/**
	 * Sets only the options for adding Funds available.
	 */
	public void setAddFundsOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setAddFundsOptions(true);
	}
	
	/**
	 * Sets only the options for Updating a book available.
	 */
	public void setUpdateBookOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setUpdateBookOptions(true);
	}

	/**
	 * Sets only the options for Updating an author available.
	 */
	public void setUpdateAuthorOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setUpdateAuthorOptions(true);	
	}

	/**
	 * Sets only the options for Updating a publisher available.
	 */
	public void setUpdatePublisherOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);	
		this.setUpdateAuthorOptions(false);	
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setUpdatePublisherOptions(true);
	}
	

	/**
	 * Sets only the options for Updating a Category available.
	 */
	public void setUpdateCategoryOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);	
		this.setUpdateAuthorOptions(false);	
		this.setUpdatePublisherOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setUpdateCategoryOptions(true);
	}
	

	/**
	 * Sets only the options for Updating a Client available.
	 */
	public void setUpdateClientOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);	
		this.setUpdateAuthorOptions(false);	
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setUpdateClientOptions(true);
	}
	
	/**
	 * Sets only the options for Deleting a book available.
	 */
	public void setDeleteBookOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);	
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setDeleteBookOptions(true);
	}

	/**
	 * Sets only the options for Deleting an author available.
	 */
	public void setDeleteAuthorOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setDeleteAuthorOptions(true);	
	}

	/**
	 * Sets only the options for Deleting a publisher available.
	 */
	public void setDeletePublisherOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setDeletePublisherOptions(true);
	}
	

	/**
	 * Sets only the options for Deleting a Category available.
	 */
	public void setDeleteCategoryOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setDeleteCategoryOptions(true);
	}
	

	/**
	 * Sets only the options for Deleting a Client available.
	 */
	public void setDeleteClientOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setDeleteClientOptions(true);
	}
	
	/**
	 * Sets only the options for Searching a book available.
	 */
	public void setSearchBookOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);	
		this.setDeleteBookOptions(false);	
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setSearchBookOptions(true);
	}

	/**
	 * Sets only the options for Searching an author available.
	 */
	public void setSearchAuthorOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);	
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setSearchAuthorOptions(true);	
	}

	/**
	 * Sets only the options for Searching a publisher available.
	 */
	public void setSearchPublisherOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);	
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setSearchPublisherOptions(true);
	}
	

	/**
	 * Sets only the options for Searching a Category available.
	 */
	public void setSearchCategoryOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		this.setBuyOptions(false);
		
		this.setSearchCategoryOptions(true);
	}
	

	/**
	 * Sets only the options for Searching a Client available.
	 */
	public void setSearchClientOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setBuyOptions(false);
		
		this.setSearchClientOptions(true);
	}
	
	/**
	 * Sets only the options for Buying books available.
	 */
	public void setBuyOptionsOnly() {
		this.setAddBookOptions(false);	
		this.setAddAuthorOptions(false);	
		this.setAddPublisherOptions(false);
		this.setAddCategoryOptions(false);
		this.setAddClientOptions(false);
		this.setAddFundsOptions(false);
		this.setUpdateBookOptions(false);
		this.setUpdateAuthorOptions(false);
		this.setUpdatePublisherOptions(false);
		this.setUpdateCategoryOptions(false);
		this.setUpdateClientOptions(false);
		this.setDeleteBookOptions(false);
		this.setDeleteAuthorOptions(false);	
		this.setDeletePublisherOptions(false);
		this.setDeleteCategoryOptions(false);
		this.setDeleteClientOptions(false);
		this.setSearchBookOptions(false);
		this.setSearchAuthorOptions(false);	
		this.setSearchPublisherOptions(false);
		this.setSearchCategoryOptions(false);
		this.setSearchClientOptions(false);
		
		this.setBuyOptions(true);
	}
	//-------------------------------------------------------------------------------------------------Methods for showing messages/tables
	
	/**
	 * Shows an informative message
	 * @param s the string containing the message to be showed
	 */
	public void showMessage(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	/**
	 * Shows a table with the books in the book store, if such a table already existed on display the old one is closed. 
	 * @param books the data of the books to display
	 */
	public void showBooks(Object[][] books) {
		if (booksTable!=null)
			booksTable.close();
		String[] columnsNames={"BookID","Title","Authors's FirstNames","Authors's LastNames","Publisher","Categories","NoOfCopies","Price"};
		booksTable=new Table("Books",columnsNames,books);
		booksTable.display();
	}

	/**
	 * Shows a table with the authors in the book store, if such a table already existed on display the old one is closed. 
	 * @param data the data of the authors to display
	 */
	public void showAuthors(Object[][] data) {
		if (authorsTable!=null)
			authorsTable.close();
		String[] columnsNames={"AuthorsIDs","FirstName","LastName"};
		authorsTable=new Table("Authors",columnsNames,data);
		authorsTable.display();
	}

	/**
	 * Shows a table with the Publishers in the book store, if such a table already existed on display the old one is closed. 
	 * @param data the data of the publishers to display
	 */
	public void showPublishers(Object[][] data) {
		if (publishersTable!=null)
			publishersTable.close();
		String[] columnsNames={"PublisherID","Name"};
		publishersTable=new Table("Publishers",columnsNames,data);
		publishersTable.display();
	}
	
	/**
	 * Shows a table with the Categories in the book store, if such a table already existed on display the old one is closed. 
	 * @param data the data of the Categories to display
	 */
	public void showCategories(Object[][] data) {
		if (categoriesTable!=null)
			categoriesTable.close();
		String[] columnsNames={"CategoryID","Name"};
		categoriesTable=new Table("Categories",columnsNames,data);
		categoriesTable.display();
	}

	/**
	 * Shows a table with the Clients in the book store, if such a table already existed on display the old one is closed. 
	 * @param data the data of the Clients to display
	 */
	public void showClients(Object[][] data) {
		if (clientsTable!=null)
			clientsTable.close();
		String[] columnsNames={"ClientID","Name","Phone","Address","Email","Credit"};
		clientsTable=new Table("Clients",columnsNames,data);
		clientsTable.display();
	}

	/**
	 * Shows a table with books. 
	 * @param data the data of the Books to display
	 */
	public void showFoundBooksTable(Object[][] data) {
		String[] columnsNames={"BookID","Title","Authors's FirstNames","Authors's LastNames","Publisher","Categories","NoOfCopies","Price"};
		Table table=new Table("Found Books",columnsNames,data);
		table.display();
	}

	/**
	 * Shows a table with authors. 
	 * @param data the data of the authors to display
	 */
	public void showFoundAuthorsTable(Object[][] data) {
		String[] columnsNames={"AuthorID","Authors's FirstNames","Authors's LastNames"};
		Table table=new Table("Found Authors",columnsNames,data);
		table.display();
		
	}	
	
	/**
	 * Shows a table with publishers. 
	 * @param data the data of the publishers to display
	 */
	public void showFoundPublishersTable(Object[][] data) {
		String[] columnsNames={"PublisherID","Name"};
		Table table=new Table("Found publishers",columnsNames,data);
		table.display();
		
	}	
	
	/**
	 * Shows a table with Categories. 
	 * @param data the data of the Categories to display
	 */
	public void showFoundCategoriesTable(Object[][] data) {
		String[] columnsNames={"CategoryID","Name"};
		Table table=new Table("Found Categories",columnsNames,data);
		table.display();
		
	}
	
	/**
	 * Shows a table with Clients. 
	 * @param data the data of the Clients to display
	 */
	public void showFoundClientsTable(Object[][] data) {
		String[] columnsNames={"ClientID","Name","Phone","Address","Email","Credit"};
		Table table=new Table("Found Clients",columnsNames,data);
		table.display();
	}

	/**
	 * Shows a table with the Account Details 
	 * @param data the data of the Account to display
	 */
	public void showAccountDetails(Object[][] data) {
		String[] columnsNames={"ClientID","Name","Phone","Address","Email","Credit"};
		Table table=new Table("Account information",columnsNames,data);
		table.display();
	}
}