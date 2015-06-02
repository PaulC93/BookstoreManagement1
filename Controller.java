import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller Component
 * 
 * @author Paul Calean
 * @version 1.0
 */

public class Controller {
	private View view;
	private Model model;
	/**
	 * Constructs a controller object with the specified components.
	 * @param view the view component (the GUI of the application)
	 * @param model the model component (the "logic" of the application)
	 */
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	/**
	 * The method called when the application starts running.
	 * Initialises the view (shows the applications window among others). 
	 * Adds the ActionListeners for the view components.
	 * Calls the populateDictionary method from model to populate the Dictionary with which the application works.
	 */
	public void start() {
		//Initialise view
		view.initialization();
		//add action listeners for menu items
		view.addActionListenerMenuItemViewBooks(new MenuItemViewBooksAction());
		view.addActionListenerMenuItemViewAuthors(new MenuItemViewAuthorsAction());
		view.addActionListenerMenuItemViewPublishers(new MenuItemViewPublishersAction());
		view.addActionListenerMenuItemViewCategories(new MenuItemViewCategoriesAction());
		view.addActionListenerMenuItemViewClients(new MenuItemViewClientsAction());
		view.addActionListenerMenuItemViewAccount(new MenuItemViewAccountAction());
		view.addActionListenerMenuItemAddBook(new MenuItemAddBookAction());
		view.addActionListenerMenuItemAddAuthor(new MenuItemAddAuthorAction());
		view.addActionListenerMenuItemAddPublisher(new MenuItemAddPublisherAction());
		view.addActionListenerMenuItemAddCategory(new MenuItemAddCategoryAction());
		view.addActionListenerMenuItemAddClient(new MenuItemAddClientAction());
		view.addActionListenerMenuItemAddFunds(new MenuItemAddFundsAction());
		view.addActionListenerMenuItemUpdateBook(new MenuItemUpdateBookAction());
		view.addActionListenerMenuItemUpdateAuthor(new MenuItemUpdateAuthorAction());
		view.addActionListenerMenuItemUpdatePublisher(new MenuItemUpdatePublisherAction());
		view.addActionListenerMenuItemUpdateCategory(new MenuItemUpdateCategoryAction());
		view.addActionListenerMenuItemUpdateClient(new MenuItemUpdateClientAction());
		view.addActionListenerMenuItemDeleteBook(new MenuItemDeleteBookAction());
		view.addActionListenerMenuItemDeleteAuthor(new MenuItemDeleteAuthorAction());
		view.addActionListenerMenuItemDeletePublisher(new MenuItemDeletePublisherAction());
		view.addActionListenerMenuItemDeleteCategory(new MenuItemDeleteCategoryAction());
		view.addActionListenerMenuItemDeleteClient(new MenuItemDeleteClientAction());
		view.addActionListenerMenuItemSearchBook(new MenuItemSearchBookAction());
		view.addActionListenerMenuItemSearchAuthor(new MenuItemSearchAuthorAction());
		view.addActionListenerMenuItemSearchPublisher(new MenuItemSearchPublisherAction());
		view.addActionListenerMenuItemSearchCategory(new MenuItemSearchCategoryAction());
		view.addActionListenerMenuItemSearchClient(new MenuItemSearchClientAction());
		view.addActionListenerMenuItemBuyBook(new MenuItemBuyBookAction());
		//add action listeners for buttons
		view.addActionListenerBtnConnect(new BtnConnectAction());
		view.addActionListenerBtnDisconnect(new BtnDisconnectAction());
		view.addActionListenerBtnAddBook(new BtnAddBookAction());
		view.addActionListenerBtnAddAuthor(new BtnAddAuthorAction());
		view.addActionListenerBtnAddPublisher(new BtnAddPublisherAction());
		view.addActionListenerBtnAddCategory(new BtnAddCategoryAction());
		view.addActionListenerBtnAddClient(new BtnAddClientAction());
		view.addActionListenerBtnAddFunds(new BtnAddFundsAction());
		view.addActionListenerBtnUpdateBook(new BtnUpdateBookAction());
		view.addActionListenerBtnUpdateAuthor(new BtnUpdateAuthorAction());
		view.addActionListenerBtnUpdatePublisher(new BtnUpdatePublisherAction());
		view.addActionListenerBtnUpdateCategory(new BtnUpdateCategoryAction());
		view.addActionListenerBtnUpdateClient(new BtnUpdateClientAction());
		view.addActionListenerBtnDeleteBook(new BtnDeleteBookAction());
		view.addActionListenerBtnDeleteAuthor(new BtnDeleteAuthorAction());
		view.addActionListenerBtnDeletePublisher(new BtnDeletePublisherAction());
		view.addActionListenerBtnDeleteCategory(new BtnDeleteCategoryAction());
		view.addActionListenerBtnDeleteClient(new BtnDeleteClientAction());
		view.addActionListenerBtnSearchBook(new BtnSearchBookAction());
		view.addActionListenerBtnSearchAuthor(new BtnSearchAuthorAction());
		view.addActionListenerBtnSearchPublisher(new BtnSearchPublisherAction());
		view.addActionListenerBtnSearchCategory(new BtnSearchCategoryAction());
		view.addActionListenerBtnSearchClient(new BtnSearchClientAction());
		view.addActionListenerBtnBuyBook(new BtnBuyBookAction());
		view.addActionListenerBtnGetReceipt(new BtnGetReceiptAction());
		view.addActionListenerBtnSendEmail(new BtnSendMailAction());
	}
	
	//-------------------------------------------------------------------------------------------------Menu Items action listeners
	
	/**
	 * Implements the ActionListener for the "View Books" Menu Item
	 */
	public class MenuItemViewBooksAction implements ActionListener
	{

		/**
		 * Method called when the "View Books" Menu Item is pressed.
         * Calls the model's get books method and if the returned value is not null calls the View's showBooks method 
         * else calls the View's showMessage method to show a "No books found message"
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] books=model.getBooks();
		if (books!=null) view.showBooks(books);
		else view.showMessage("No books found");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the "View authors" Menu Item
	 */
	public class MenuItemViewAuthorsAction implements ActionListener
	{

		/**
		 * Method called when the "View Authors" Menu Item is pressed.
         * Calls the model's get authors method and if the returned value is not null calls the View's showAuthors method 
         * else calls the View's showMessage method to show a "No authors found message"
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] data=model.getAuthors();
		if (data!=null) view.showAuthors(data);
		else view.showMessage("No authors found");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the "View Publishers" Menu Item
	 */
	public class MenuItemViewPublishersAction implements ActionListener
	{

		/**
		 * Method called when the "View Publishers" Menu Item is pressed.
         * Calls the model's getPublishers method and if the returned value is not null calls the View's showPublishers method 
         * else calls the View's showMessage method to show a "No Publishers found message"
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] data=model.getPublishers();
		if (data!=null) view.showPublishers(data);
		else view.showMessage("No Publishers found");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the "View Categories" Menu Item
	 */
	public class MenuItemViewCategoriesAction implements ActionListener
	{

		/**
		 * Method called when the "View Categories" Menu Item is pressed.
         * Calls the model's getCategories method and if the returned value is not null calls the View's showCategories method 
         * else calls the View's showMessage method to show a "No Categories found message"
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] data=model.getCategories();
		if (data!=null) view.showCategories(data);
		else view.showMessage("No Categories found");
		}	
	}
	
	/**
	 * Implements the ActionListener for the "View Clients" Menu Item
	 */
	public class MenuItemViewClientsAction implements ActionListener
	{

		/**
		 * Method called when the "View Clients" Menu Item is pressed.
         * Calls the model's getClients method and if the returned value is not null calls the View's showClients method 
         * else calls the View's showMessage method to show a "No Clients found message"
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] data=model.getClients();
		if (data!=null) view.showClients(data);
		else view.showMessage("No Clients found");
		}
	}
	
	/**
	 * Implements the ActionListener for the "View Account" Menu Item
	 */
	public class MenuItemViewAccountAction implements ActionListener
	{

		/**
		 * Method called when the "View Account" Menu Item is pressed.
         * Calls the model's getAccount method and if the returned value is not null calls the View's showAccount method
		 */
	public void actionPerformed(ActionEvent e) {
			
		Object[][] data=model.getAccount(model.getClientID());
		if (data!=null) view.showAccountDetails(data);
		else view.showMessage("No Account found");
		}
	}
	
	/**
	 * Implements the ActionListener for the "Add book" Menu Item
	 */
	public class MenuItemAddBookAction implements ActionListener
	{

		/**
		 * Method called when the "Add Book" Menu Item is pressed.
         * Sets the view so only the options to add a book will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddBookOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Add author" Menu Item
	 */
	public class MenuItemAddAuthorAction implements ActionListener
	{

		/**
		 * Method called when the "Add author" Menu Item is pressed.
		 * Sets the view so only the options to add an author will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddAuthorOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Add Publisher" Menu Item
	 */
	public class MenuItemAddPublisherAction implements ActionListener
	{

		/**
		 * Method called when the "Add Publisher" Menu Item is pressed.
		 * Sets the view so only the options to add a Publisher will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddPublisherOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Add Category" Menu Item
	 */
	public class MenuItemAddCategoryAction implements ActionListener
	{

		/**
		 * Method called when the "Add Category" Menu Item is pressed.
		 * Sets the view so only the options to add a Category will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddCategoryOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Add Client" Menu Item
	 */
	public class MenuItemAddClientAction implements ActionListener
	{

		/**
		 * Method called when the "Add Client" Menu Item is pressed.
		 * Sets the view so only the options to add a Client will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddClientOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Add Funds" Menu Item
	 */
	public class MenuItemAddFundsAction implements ActionListener
	{

		/**
		 * Method called when the "Add Funds" Menu Item is pressed.
		 * Sets the view so only the options to add Funds will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setAddFundsOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Update book" Menu Item
	 */
	public class MenuItemUpdateBookAction implements ActionListener
	{

		/**
		 * Method called when the "Update Book" Menu Item is pressed.
         * Sets the view so only the options to Update a book will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setUpdateBookOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Update author" Menu Item
	 */
	public class MenuItemUpdateAuthorAction implements ActionListener
	{

		/**
		 * Method called when the "Update author" Menu Item is pressed.
		 * Sets the view so only the options to Update an author will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setUpdateAuthorOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Update Publisher" Menu Item
	 */
	public class MenuItemUpdatePublisherAction implements ActionListener
	{

		/**
		 * Method called when the "Update Publisher" Menu Item is pressed.
		 * Sets the view so only the options to Update a Publisher will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setUpdatePublisherOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Update Category" Menu Item
	 */
	public class MenuItemUpdateCategoryAction implements ActionListener
	{

		/**
		 * Method called when the "Update Category" Menu Item is pressed.
		 * Sets the view so only the options to Update a Category will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setUpdateCategoryOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Update Client" Menu Item
	 */
	public class MenuItemUpdateClientAction implements ActionListener
	{

		/**
		 * Method called when the "Update Client" Menu Item is pressed.
		 * Sets the view so only the options to Update a Client will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setUpdateClientOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Delete book" Menu Item
	 */
	public class MenuItemDeleteBookAction implements ActionListener
	{

		/**
		 * Method called when the "Delete Book" Menu Item is pressed.
         * Sets the view so only the options to Delete a book will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setDeleteBookOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Delete author" Menu Item
	 */
	public class MenuItemDeleteAuthorAction implements ActionListener
	{

		/**
		 * Method called when the "Delete author" Menu Item is pressed.
		 * Sets the view so only the options to Delete an author will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setDeleteAuthorOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Delete Publisher" Menu Item
	 */
	public class MenuItemDeletePublisherAction implements ActionListener
	{

		/**
		 * Method called when the "Delete Publisher" Menu Item is pressed.
		 * Sets the view so only the options to Delete a Publisher will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setDeletePublisherOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Delete Category" Menu Item
	 */
	public class MenuItemDeleteCategoryAction implements ActionListener
	{

		/**
		 * Method called when the "Delete Category" Menu Item is pressed.
		 * Sets the view so only the options to Delete a Category will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setDeleteCategoryOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Delete Client" Menu Item
	 */
	public class MenuItemDeleteClientAction implements ActionListener
	{

		/**
		 * Method called when the "Delete Client" Menu Item is pressed.
		 * Sets the view so only the options to Delete a Client will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setDeleteClientOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Search book" Menu Item
	 */
	public class MenuItemSearchBookAction implements ActionListener
	{

		/**
		 * Method called when the "Search Book" Menu Item is pressed.
         * Sets the view so only the options to Search a book will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setSearchBookOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Search author" Menu Item
	 */
	public class MenuItemSearchAuthorAction implements ActionListener
	{

		/**
		 * Method called when the "Search author" Menu Item is pressed.
		 * Sets the view so only the options to Search an author will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setSearchAuthorOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Search Publisher" Menu Item
	 */
	public class MenuItemSearchPublisherAction implements ActionListener
	{

		/**
		 * Method called when the "Search Publisher" Menu Item is pressed.
		 * Sets the view so only the options to Search a Publisher will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setSearchPublisherOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "Search Category" Menu Item
	 */
	public class MenuItemSearchCategoryAction implements ActionListener
	{

		/**
		 * Method called when the "Search Category" Menu Item is pressed.
		 * Sets the view so only the options to Search a Category will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setSearchCategoryOptionsOnly();
		}
	}
	
	
	/**
	 * Implements the ActionListener for the "Search Client" Menu Item
	 */
	public class MenuItemSearchClientAction implements ActionListener
	{

		/**
		 * Method called when the "Search Client" Menu Item is pressed.
		 * Sets the view so only the options to Search a Client will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setSearchClientOptionsOnly();
		}
	}
	
	/**
	 * Implements the ActionListener for the "BuyBook" Menu Item
	 */
	public class MenuItemBuyBookAction implements ActionListener
	{

		/**
		 * Method called when the "BuyBook" Menu Item is pressed.
		 * Sets the view so only the options to BuyBook will be available.
		 */
	public void actionPerformed(ActionEvent e) {
			view.setBuyOptionsOnly();
		}
	}
	//-------------------------------------------------------------------------------------------------Buttons action listeners
	
	/**
	 * Implements the ActionListener for the Connect button
	 */
	public class BtnConnectAction implements ActionListener
	{

		/**
		 * Method called when the button Connect is pressed.
		 * Checks for valid login input if valid
         * Calls the model's connect method in order to connect to the database, and disables the login options,
         * else calls the view's showMessage method to display an invalid input message
		 */
		public void actionPerformed(ActionEvent e) {
			if (view.checkForValidLoginInput())
				if (model.tryConnecting(view.getUsername(), new String(view.getPassword())))
					{
						view.setLoginEnabled(false);
						if (view.getUsername().equals("Angajat")) view.setEmployeeView(true);
						else view.setEmployeeView(false);
					}
				else view.showMessage("Invalid login details");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the Disconnect button
	 */
	public class BtnDisconnectAction implements ActionListener
	{

		/**
		 * Method called when the button Disconnect is pressed.
         * Calls the model's disconnect method in order to disconnect from the database.
		 */
		public void actionPerformed(ActionEvent e) {
			model.disconnect();
			view.setLoginEnabled(true);
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddBook button
	 */
	public class BtnAddBookAction implements ActionListener
	{

		/**
		 * Method called when the button AddBook is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addBook method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddBookInput())
				if	(model.addBook(view.getID(), view.getTitle(), view.getNoOfCopies(), view.getAuthorsIDs(), view.getPublisherID(), view.getCategoriesIDs(), view.getPrice()))
					{
						view.showMessage("Added successfully");
						view.resetBookInput();
					}
				else view.showMessage("ID already exists");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddAuthor button
	 */
	public class BtnAddAuthorAction implements ActionListener
	{

		/**
		 * Method called when the button AddAuthor is pressed.
	     * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addAuthor method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddAuthorInput())
				if	(model.addAuthor(view.getID(), view.getAuthorsFN(), view.getAuthorsLN()))
					{
						view.showMessage("Added successfully");
						view.resetAuthorInput();
					}
				else view.showMessage("ID already exists");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddPublisher button
	 */
	public class BtnAddPublisherAction implements ActionListener
	{

		/**
		 * Method called when the button AddPublisher is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addPublisher method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddPublisherInput())
				if	(model.addPublisher(view.getID(), view.getName()))
					{
						view.showMessage("Added successfully");
						view.resetPublisherInput();
					}
				else view.showMessage("ID already exists");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddCategory button
	 */
	public class BtnAddCategoryAction implements ActionListener
	{

		/**
		 * Method called when the button AddCategory is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addCategory method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddCategoryInput())
				if	(model.addCategory(view.getID(), view.getName()))
					{
						view.showMessage("Added successfully");
						view.resetCategoryInput();
					}
				else view.showMessage("ID already exists");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddClient button
	 */
	public class BtnAddClientAction implements ActionListener
	{
		/**
		 * Method called when the button AddClient is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addClient method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddClientInput())
				if	(model.addClient(view.getID(), view.getName(), view.getPhone(), view.getAddress(), view.getEmail(), view.getCredit()))
					{
						view.showMessage("Added successfully");
						view.resetClientInput();
					}
				else view.showMessage("ID already exists");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the AddFunds button
	 */
	public class BtnAddFundsAction implements ActionListener
	{
		/**
		 * Method called when the button AddFunds is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's addFunds method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidAddFundsInput())
				if	(model.addFunds(view.getID(), view.getFunds()))
					{
						view.showMessage("Added successfully");
						view.resetFundsInput();
					}
				else view.showMessage("an error occurred");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the UpdateBook button
	 */
	public class BtnUpdateBookAction implements ActionListener
	{

		/**
		 * Method called when the button UpdateBook is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's updateBook method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidUpdateBookInput())
				if	(model.updateBook(view.getID(), view.getTitle(), view.getNoOfCopies(), view.getAuthorsIDs(), view.getPublisherID(),
						view.getCategoriesIDs(), view.getPrice(), view.getOldID()))
					{
						view.showMessage("Updated successfully");
						view.resetBookInput();
					}
				else view.showMessage("An error occurred while attempting to update book");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the UpdateAuthor button
	 */
	public class BtnUpdateAuthorAction implements ActionListener
	{

		/**
		 * Method called when the button UpdateAuthor is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's updateAuthor method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidUpdateAuthorInput())
				if	(model.updateAuthor(view.getID(), view.getAuthorsFN(), view.getAuthorsLN()))
					{
						view.showMessage("Updated successfully");
						view.resetAuthorInput();
					}
				else view.showMessage("An error occurred while attempting to update Author");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the UpdatePublisher button
	 */
	public class BtnUpdatePublisherAction implements ActionListener
	{

		/**
		 * Method called when the button UpdatePublisher is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's updatePublisher method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidUpdatePublisherInput())
				if	(model.updatePublisher(view.getID(), view.getName()))
					{
						view.showMessage("Updated successfully");
						view.resetPublisherInput();
					}
				else view.showMessage("An error occurred while attempting to update Publisher");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the UpdateCategory button
	 */
	public class BtnUpdateCategoryAction implements ActionListener
	{

		/**
		 * Method called when the button UpdateCategory is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's updateCategory method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidUpdateCategoryInput())
				if	(model.updateCategory(view.getID(), view.getName()))
					{
						view.showMessage("Updated successfully");
						view.resetCategoryInput();
					}
				else view.showMessage("An error occurred while attempting to update Category");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the UpdateClient button
	 */
	public class BtnUpdateClientAction implements ActionListener
	{
		/**
		 * Method called when the button UpdateClient is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's updateClient method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidUpdateClientInput())
				if	(model.updateClient(view.getID(), view.getName(), view.getPhone(), view.getAddress(), view.getEmail(), view.getCredit()))
					{
						view.showMessage("Updated successfully");
						view.resetClientInput();
					}
				else view.showMessage("An error occurred while attempting to update Client");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the DeleteBook button
	 */
	public class BtnDeleteBookAction implements ActionListener
	{

		/**
		 * Method called when the button DeleteBook is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's deleteBook method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
				if	(model.deleteBook(view.getID()))
					{
						view.showMessage("Deleted successfully");
						view.resetIDInput();
					}
				else view.showMessage("An error occurred while attempting to delete Book");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the DeleteAuthor button
	 */
	public class BtnDeleteAuthorAction implements ActionListener
	{

		/**
		 * Method called when the button DeleteAuthor is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's deleteAuthor method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
				if	(model.deleteAuthor(view.getID()))
					{
						view.showMessage("Deleted successfully");
						view.resetIDInput();
					}
				else view.showMessage("Books written by this author still exist in the bookstore, delete those books and try again");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the DeletePublisher button
	 */
	public class BtnDeletePublisherAction implements ActionListener
	{

		/**
		 * Method called when the button DeletePublisher is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's deletePublisher method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
				if	(model.deletePublisher(view.getID()))
					{
						view.showMessage("Deleted successfully");
						view.resetIDInput();
					}
				else view.showMessage("Books published by this publisher still exist in the bookstore, delete those books and try again");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the DeleteCategory button
	 */
	public class BtnDeleteCategoryAction implements ActionListener
	{

		/**
		 * Method called when the button DeleteCategory is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's deleteCategory method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
				if	(model.deleteCategory(view.getID()))
					{
						view.showMessage("Deleted successfully");
						view.resetIDInput();
					}
				else view.showMessage("Books within this category still exist in the bookstore, delete those books and try again");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the DeleteClient button
	 */
	public class BtnDeleteClientAction implements ActionListener
	{
		/**
		 * Method called when the button Delete Client is pressed.
		 * Checks for valid input, if the input is invalid calls the view's showMessage method to show an "Invalid input" message otherwise
         * calls the model's deleteClient method, if the method returns true calls the view's showMessage method to show a "success" message and resets the input,
         * otherwise calls the view's showMessage method to show an error message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
				if	(model.deleteClient(view.getID()))
					{
						view.showMessage("Deleted successfully");
						view.resetIDInput();
					}
				else view.showMessage("An error occurred while attempting to delete Client");
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the SearchBook button
	 */
	public class BtnSearchBookAction implements ActionListener
	{

		/**
		 * Method called when the button SearchBook is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's SearchBook method and then the view's showFoundBooksTable method to show the found books and resets the input 
         * if the Searching was successful, 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidSearchBookInput())
			{	
				Object[][] data=model.searchBook(view.getID(), view.getTitle(), view.getNoOfCopies(), view.getAuthorsFN(), 
						view.getAuthorsLN(), view.getPublisher(), view.getCategory(), view.getPrice());		
				if (data.length>0) 
					{
						view.showFoundBooksTable(data);
						view.resetSearchBookInput();
					}
				else view.showMessage("No books found");
			}
			else view.showMessage("Invalid input");
		}
	}
		
	
	/**
	 * Implements the ActionListener for the SearchAuthor button
	 */
	public class BtnSearchAuthorAction implements ActionListener
	{

		/**
		 * Method called when the button SearchAuthor is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's SearchAuthor method and then the view's showFoundAuthorsTable method to show the found Authors and resets the input 
         * if the Searching was successful, 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidSearchAuthorInput())
				{
					Object[][] data=model.searchAuthor(view.getID(), view.getAuthorsFN(), view.getAuthorsLN());		
					if (data.length>0) 
					{
						view.showFoundAuthorsTable(data);
						view.resetAuthorInput();
					}
					else view.showMessage("No authors found");
				}
			else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the SearchPublisher button
	 */
	public class BtnSearchPublisherAction implements ActionListener
	{

		/**
		 * Method called when the button SearchPublisher is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's SearchPublisher method and then the view's showFoundPublishersTable method to show the found Publishers and resets the input 
         * if the Searching was successful, 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidSearchPublisherInput())
			{
				Object[][] data=model.searchPublisher(view.getID(), view.getName());		
				if (data.length>0) 
				{
					view.showFoundPublishersTable(data);
					view.resetPublisherInput();
				}
				else view.showMessage("Not found");
			}
		else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the SearchCategory button
	 */
	public class BtnSearchCategoryAction implements ActionListener
	{

		/**
		 * Method called when the button SearchCategory is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's SearchCategory method and then the view's showFoundCategoriesTable method to show the found Categories and resets the input 
         * if the Searching was successful, 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidSearchCategoryInput())
			{
				Object[][] data=model.searchCategories(view.getID(), view.getName());		
				if (data.length>0) 
				{
					view.showFoundCategoriesTable(data);
					view.resetCategoryInput();
				}
				else view.showMessage("Not found");
			}
		else view.showMessage("Invalid input");
		}
		
	}
	

	/**
	 * Implements the ActionListener for the SearchClient button
	 */
	public class BtnSearchClientAction implements ActionListener
	{

		/**
		 * Method called when the button SearchClient is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's SearchClient method and then the view's showFoundClientsTable method to show the found Clients and resets the input 
         * if the Searching was successful 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidSearchClientInput())
			{
				Object[][] data=model.searchClients(view.getID(), view.getName(), view.getPhone(), view.getAddress(), view.getEmail(), view.getCredit());		
				if (data.length>0) 
				{
					view.showFoundClientsTable(data);
					view.resetClientInput();
				}
				else view.showMessage("Not found");
			}
		else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the BuyBook button
	 */
	public class BtnBuyBookAction implements ActionListener
	{

		/**
		 * Method called when the button BuyBook is pressed.
		 * Checks for valid input, calls the view's showMessage method to display a error message if the input is invalid
         * Calls the model's BuyBook method, then the view's showMessage method to show a "success" message and the showEndPurchaseButtons(true) method
         * if the buying was successful 
         * otherwise calls the view's showMessage method to display a "not found" message 
		 */
		public void actionPerformed(ActionEvent e) {
			if(view.checkForValidIDInput())
			{
				if (model.buyBook(view.getID()))
				{
					view.showMessage("Book purchased");
					view.resetIDInput();
				}
				else view.showMessage("Not enought credit or noOfCopies");
			}
		else view.showMessage("Invalid input");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the GetReceipt button
	 */
	public class BtnGetReceiptAction implements ActionListener
	{

		/**
		 * Method called when the button GetReceipt is pressed.
         * Calls the model's GetReceipt method, then the view's showMessage method to show a "success" message and the showEndPurchaseButtons(false) method
         * if successful 
         * otherwise calls the view's showMessage method to display an error message 
		 */
		public void actionPerformed(ActionEvent e) {
				if (model.GetReceipt())
				{
					view.showMessage("Receipt generated");
					view.resetIDInput();
				}
				else view.showMessage("An error occurred");
		}
		
	}
	
	/**
	 * Implements the ActionListener for the SendMail button
	 */
	public class BtnSendMailAction implements ActionListener
	{

		/**
		 * Method called when the button SendMail is pressed.
         * Calls the model's SendMail method, then the view's showMessage method to show a "success" message and  method
         * if successful 
         * otherwise calls the view's showMessage method to display an error message 
		 */
		public void actionPerformed(ActionEvent e) {
				if (model.SendMail())
				{
					view.showMessage("Mail Sent");
					view.resetIDInput();
				}
				else view.showMessage("An error occurred");
		}
		
	}
}
