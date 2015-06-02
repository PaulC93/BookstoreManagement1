import java.sql.*;//necessary for database operations

/**
 * Model Component
 * DB_URL is the data base URL
 * conn is the connection used to communicate with the database
 * @author Paul Calean
 */

public class Model{

	private String db_url;  
	private Connection conn;
	private Integer clientID, bookID;
	private Pdf pdf;
	private SendMailTLS sendEmail;
	
	public Model()
	{
		 db_url =new String("jdbc:mysql://localhost/BookStore");
		 pdf=new Pdf();
		 sendEmail=new SendMailTLS();
	}
	
	 /**
     * Tries to connect to the data base with the supplied data and returns true if the connection is successful, false otherwise 
     * 
     * @param  USER  the user name with which to connect to the database
     * @param  PASS  the password with which to connect to the database
     * @return true if the connection is successful, false otherwise 
     */
	public boolean tryConnecting(String username, String password) {
		boolean r=true; //return value
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db_url,username,password);
        }catch(SQLException se){
            //Handle errors for JDBC
            r=false;                
            se.printStackTrace(); 
        }catch(Exception e){
            //Handle errors for Class.forName
            r=false;
            e.printStackTrace(); 
        }
        if (r)
        	switch (username)
        	{
        	case "Client" :
        	this.setClientID(1);
        	break;
        	case "client0":
        	this.setClientID(2);
        	break;
        	}        	
        return r;
	}

	/**
	 * If a connection exists it's closed.
	 */
	public void disconnect() {
	      try{
	            if(conn!=null)
	                conn.close();
	        }catch(SQLException se){
	            se.printStackTrace();
	        }
		
	}

	/**
	 * Obtains the books in the bookstore
	 * @return the books in the bookstore with their authors, publishers, categories, noOfCopies and price in a matrix form in order to be displayed as a table
	 */
	public Object[][] getBooks() {
		try{
            CallableStatement cs= conn.prepareCall("{call getBooksWithDetails}");
            ResultSet rs = cs.executeQuery();
            int n=0;
            while (rs.next()) n++; //n=no. of rows
            rs.beforeFirst();
            Object[][] data=new Object[n][8]; 
            int i=-1; //current row
            int previousID=-1,ID=-1,NoOfCopies,price;
            String FirstNames="",FirstName="",Title,Publisher;
            String LastNames="",LastName="";
            String Categories="",Category="";
            while(rs.next()){
                //Retrieve by column name
            	ID=rs.getInt("BookID");
            	Title=rs.getString("Title");
            	FirstName=rs.getString("Author's_FirstName");
            	LastName=rs.getString("Author's_LastName");
            	Publisher=rs.getString("Publisher");
            	Category=rs.getString("Category");
            	NoOfCopies=rs.getInt("NoOfCopies");
            	price=rs.getInt("PRice");
            	if (ID==previousID)
            	{
            		if (!FirstNames.contains(FirstName))
            		{
            			FirstNames+=", "+FirstName;
            			data[i][2]=FirstNames;
            		}
            		if (!LastNames.contains(LastName))
            		{
            			LastNames+=", "+LastName;
            			data[i][3]=LastNames;
            		}
            		if(!Categories.contains(Category))
            		{
            			Categories+=", "+Category;
            			data[i][5]=Categories;
            		}
            	}
            	else
            	{
                i++;
                data[i][0]=ID;
                data[i][1]=Title;
                data[i][2]=FirstName;
                data[i][3]=LastName;
                data[i][4]=Publisher;
                data[i][5]=Category;
                data[i][6]=NoOfCopies;
                data[i][7]=price;
                previousID=ID;
                LastNames=LastName;
                FirstNames=FirstName;
                Categories=Category;
            	}
            }
            rs.close();
            cs.close();
    		return data;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }     
	}

	/**
	 * Obtains the authors in the bookstore
	 * @return the authors in the bookstore in a matrix form in order to be displayed as a table
	 */
	public Object[][] getAuthors() {
		try{
            CallableStatement cs= conn.prepareCall("{call getAuthors}");
            ResultSet rs = cs.executeQuery();
            int n=0;
            while (rs.next()) n++; //n=no. of rows
            rs.beforeFirst();
            Object[][] data=new Object[n][3]; 
            int i=0; //current row
            while(rs.next()){
                //Retrieve by column name
                data[i][0]=rs.getInt("AuthorID");
                data[i][1]=rs.getString("FirstName");
                data[i][2]=rs.getString("LastName");
                i++;
            }
            rs.close();
            cs.close();
    		return data;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        }  
	}

	/**
	 * Obtains the publisher in the bookstore
	 * @return the publishers in the bookstore in a matrix form in order to be displayed as a table
	 */
	public Object[][] getPublishers() {
		try{
            CallableStatement cs= conn.prepareCall("{call getPublishers}");
            ResultSet rs = cs.executeQuery();
            int n=0;
            while (rs.next()) n++; //n=no. of rows
            rs.beforeFirst();
            Object[][] data=new Object[n][2]; 
            int i=0; //current row
            while(rs.next()){
                //Retrieve by column name
                data[i][0]=rs.getInt("PublisherID");
                data[i][1]=rs.getString("Name");
                i++;
            }
            rs.close();
            cs.close();
    		return data;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        } 
	}

	/**
	 * Obtains the categories in the bookstore
	 * @return the categories in the bookstore in a matrix form in order to be displayed as a table
	 */
	public Object[][] getCategories() {
		try{
            CallableStatement cs= conn.prepareCall("{call getCategories}");
            ResultSet rs = cs.executeQuery();
            int n=0;
            while (rs.next()) n++; //n=no. of rows
            rs.beforeFirst();
            Object[][] data=new Object[n][2]; 
            int i=0; //current row
            while(rs.next()){
                //Retrieve by column name
                data[i][0]=rs.getInt("CategoryID");
                data[i][1]=rs.getString("Name");
                i++;
            }
            rs.close();
            cs.close();
    		return data;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        } 
	}

	/**
	 * Obtains the Clients in the bookstore
	 * @return the Clients in the bookstore in a matrix form in order to be displayed as a table
	 */
	public Object[][] getClients() {
		try{
            CallableStatement cs= conn.prepareCall("{call getClients}");
            ResultSet rs = cs.executeQuery();
            int n=0;
            while (rs.next()) n++; //n=no. of rows
            rs.beforeFirst();
            Object[][] data=new Object[n][6]; 
            int i=0; //current row
            while(rs.next()){
                //Retrieve by column name
                data[i][0]=rs.getInt("ClientID");
                data[i][1]=rs.getString("Name");
                data[i][2]=rs.getString("Phone");
                data[i][3]=rs.getString("Address");
                data[i][4]=rs.getString("Email");
                data[i][5]=rs.getInt("Credit");
                i++;
            }
            rs.close();
            cs.close();
    		return data;
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
            return null;
        } 
	}

	/**
	 * Adds a book in the database and its connections (with authors, publisher and categories)
	 * @param id the book's id
	 * @param title the book's title
	 * @param noOfCopies the number of copies of the book available
	 * @param authorsIDs the IDs of the authors that wrote the book
	 * @param publisherID the ID of the publisher of the book
	 * @param categoriesIDs the IDs of the categories the book belongs to
	 * @return true on success, false otherwise
	 */
	public boolean addBook(Integer id, String title,Integer noOfCopies, Integer[] authorsIDs,
			Integer publisherID, Integer[] categoriesIDs, Integer price) {
		// add the book in the books table
		 String sql=new String("insert into Books values ("+id+",\""+title+"\","+noOfCopies+","+price+")");
	        PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
		// add link with the authors 
			for (int i=0; i<authorsIDs.length; i++)
			{ 
				sql=new String("insert into Books_has_Authors values ("+id+","+authorsIDs[i]+")");
				try {
						stmt = conn.prepareStatement(sql);
						stmt.executeUpdate();
						stmt.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return false;
					}
			}
		// add link with the publisher
		     sql=new String("insert into Books_has_Publishers values ("+id+","+publisherID+")");
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}	
		//add link with the categories
			for (int i=0; i<categoriesIDs.length; i++)
			{ 
				sql=new String("insert into Books_has_categories values ("+id+","+categoriesIDs[i]+")");
				try {
						stmt = conn.prepareStatement(sql);
						stmt.executeUpdate();
						stmt.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return false;
					}
			}
	return true;
	}

	/**
	 * Adds an author to the database
	 * @param id the author's ID
	 * @param authorsFN the author's FirstName
	 * @param authorsLN the author's LastName
	 * @return  true on success, false otherwise
	 */
	public boolean addAuthor(Integer id, String authorsFN, String authorsLN) {
		    String sql=new String("insert into Authors values ("+id+",\""+authorsFN+"\","+"\""+authorsLN+"\")");
	        PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				
				return false;
			}
			return true;
	}

	/**
	 * Adds a publisher to the database
	 * @param id the publisher's id
	 * @param publisher the publisher's name
	 * @return true on success, false otherwise
	 */
	public boolean addPublisher(Integer id, String publisher) {
	    String sql=new String("insert into Publishers values ("+id+",\""+publisher+"\")");
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Adds a category in the database
	 * @param id the category's id
	 * @param category the category's name
	 * @return true on success, false otherwise
	 */
	public boolean addCategory(Integer id, String category) {
	    String sql=new String("insert into Categories values ("+id+",\""+category+"\")");
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Adds a client to the database
	 * @param id the Clients's ID
	 * @param name the Clients's Name
	 * @param phone the Clients's phone
	 * @param address the Clients's address
	 * @param email the Clients's email
	 * @return
	 */
	public boolean addClient(Integer id, String name, String phone,
			String address, String email, Integer credit) {
	    String sql=new String("insert into Clients values ("+id+",\""+name+"\",\""+phone+"\",\""+address+"\",\""+email+"\","+credit+")");
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Updates a book in the database and its connections (with authors, publisher and categories)
	 * @param id the book's id
	 * @param title the book's title
	 * @param noOfCopies the number of copies of the book available
	 * @param authorsIDs the IDs of the authors that wrote the book
	 * @param publisherID the ID of the publisher of the book
	 * @param categoriesIDs the IDs of the categories the book belongs to
	 * @return true on success, false otherwise
	 */
	public boolean updateBook(Integer id, String title,Integer noOfCopies, Integer[] authorsIDs,
			Integer publisherID, Integer[] categoriesIDs, Integer price, Integer OldID) {
		 String sql;
	     PreparedStatement stmt;
		//Delete all links before update
		//delete authors links
		  sql=new String("delete from books_has_authors where books_BookID="+OldID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
		//delete publishers links
			sql=new String("delete from books_has_publishers where books_BookID="+OldID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
		          stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}	
		//delete categories links
			sql=new String("delete from books_has_categories where books_BookID="+OldID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
		// Update the book in the books table
		   sql=new String("update Books set BookID="+id+", Title=\""+title+"\", noOfCopies="+noOfCopies+", price="+price+" where BookId="+OldID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
		// Add new link with the authors 
			for (int i=0; i<authorsIDs.length; i++)
			{ 
				sql=new String("insert into Books_has_Authors values ("+id+","+authorsIDs[i]+")");
				try {
						stmt = conn.prepareStatement(sql);
						stmt.executeUpdate();
						stmt.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return false;
					}
			}
		//Add new link with the publisher
		     sql=new String("insert into Books_has_Publishers values ("+id+","+publisherID+")");
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}	
		//Add new link with the categories
			for (int i=0; i<categoriesIDs.length; i++)
			{ 
				sql=new String("insert into Books_has_categories values ("+id+","+categoriesIDs[i]+")");
				try {
						stmt = conn.prepareStatement(sql);
						stmt.executeUpdate();
						stmt.close();
					}
					catch(SQLException e)
					{
						e.printStackTrace();
						return false;
					}
			}
	return true;
	}

	/**
	 * Updates an author to the database
	 * @param id the author's ID
	 * @param authorsFN the author's FirstName
	 * @param authorsLN the author's LastName
	 * @return  true on success, false otherwise
	 */
	public boolean updateAuthor(Integer ID, String authorsFN, String authorsLN) {
		    String sql=new String("update Authors set FirstName=\""+authorsFN+"\" , LastName=\""+authorsLN+"\" where AuthorID="+ID);
	        PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				
				return false;
			}
			return true;
	}

	/**
	 * Updates a publisher to the database
	 * @param id the publisher's id
	 * @param publisher the publisher's name
	 * @return true on success, false otherwise
	 */
	public boolean updatePublisher(Integer ID, String publisher) {
	    String sql=new String("update Publishers set Name=\""+publisher+"\" where PublisherID="+ID);
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Updates a category in the database
	 * @param id the category's id
	 * @param category the category's name
	 * @return true on success, false otherwise
	 */
	public boolean updateCategory(Integer ID, String category) {
	    String sql=new String("update Categories set Name=\""+category+"\" where CategoryID="+ID);
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Updates a client to the database
	 * @param id the Clients's ID
	 * @param name the Clients's Name
	 * @param phone the Clients's phone
	 * @param address the Clients's address
	 * @param email the Clients's email
	 * @return
	 */
	public boolean updateClient(Integer ID, String name, String phone,
			String address, String email, Integer credit) {
	    String sql=new String("update Clients set name=\""+name+"\", phone=\""+phone+"\", address=\""+address+"\", email=\""+email+"\", credit="+credit+" where ClientID="+ID);
        PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
            stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Deletes a book form the database and all its links (first links, book after)
	 * @param id the book's id 
	 * @return true on success, false otherwise
	 */
	public boolean deleteBook(Integer ID) {
		 String sql;
	     PreparedStatement stmt;
		//Delete all links before
		//delete authors links
		  sql=new String("delete from books_has_authors where books_BookID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
	            stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}
		//delete publishers links
			sql=new String("delete from books_has_publishers where books_BookID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
		          stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return false;
			}	
		//delete categories links
			sql=new String("delete from books_has_categories where books_BookID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
			
		//delete book
			sql=new String("delete from books where BookID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
			
		return true;
	}

	/**
	 * Deletes a Author form the database (if the Author is not linked with any books)
	 * @param id the Author's id 
	 * @return true on success, false otherwise
	 */
	public boolean deleteAuthor(Integer ID) {
		 String sql;
	     PreparedStatement stmt;
		//delete Author
			sql=new String("delete from Authors where AuthorID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}	
		return true;
	}

	/**
	 * Deletes a Publisher form the database (if the Publisher is not linked with any books)
	 * @param id the Publisher's id 
	 * @return true on success, false otherwise
	 */
	public boolean deletePublisher(Integer ID) {
		 String sql;
	     PreparedStatement stmt;
		//delete Publisher
			sql=new String("delete from Publishers where PublisherID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}	
		return true;
	}

	/**
	 * Deletes a Category form the database (if the Category is not linked with any books)
	 * @param id the Category's id 
	 * @return true on success, false otherwise
	 */
	public boolean deleteCategory(Integer ID) {
		 String sql;
	     PreparedStatement stmt;
		//delete Category
			sql=new String("delete from Categories where CategoryID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}	
		return true;
	}
	
	/**
	 * Deletes a Client form the database
	 * @param id the Client's id 
	 * @return true on success, false otherwise
	 */
	public boolean deleteClient(Integer ID) {
		 String sql;
	     PreparedStatement stmt;
		//delete Client
			sql=new String("delete from Clients where ClientID="+ID);
			try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			    stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}	
		return true;
	}

	/**
	 * Searches for books based on input,
	 * @param id book's id or null
	 * @param title book's title or ""
	 * @param noOfCopies book's noOfCopies or null
	 * @param authorsFN book's Authors's FirstName or ""
	 * @param authorsLN book's Author's LastName or ""
	 * @param publisher book's publisher or ""
	 * @param category book's category or ""
	 * @return a matrix with the found books data or null if an error occurs 
	 */
	public Object[][] searchBook(Integer id, String title, Integer noOfCopies,
			String authorsFN, String authorsLN, String publisher,
			String category, Integer price) {

		int previousID=-1,tmpID=-1,tmpNoOfCopies,tmpPrice;
		String FirstNames="",tmpFirstName="",tmpTitle,tmpPublisher;
		String LastNames="",tmpLastName="";
		String Categories="",tmpCategory="";
		
		if (id!=null)
			try{
	            CallableStatement cs= conn.prepareCall("{call getBooksWithID(?)}");
	            cs.setInt(1,id);
	        	ResultSet rs = cs.executeQuery();
				int n=0;
				while (rs.next()) n++; //n=no. of rows
				rs.beforeFirst();
				Object[][] data=new Object[n][8]; 
				int i=-1; //current row
				while(rs.next()){
					//Retrieve by column name
					tmpID=rs.getInt("BookID");
					tmpTitle=rs.getString("Title");
					tmpFirstName=rs.getString("Author's_FirstName");
					tmpLastName=rs.getString("Author's_LastName");
					tmpPublisher=rs.getString("Publisher");
					tmpCategory=rs.getString("Category");
					tmpNoOfCopies=rs.getInt("NoOfCopies");
					tmpPrice=rs.getInt("Price");
					if (tmpID==previousID)
					{
						if (!FirstNames.contains(tmpFirstName))
						{
							FirstNames+=", "+tmpFirstName;
							data[i][2]=FirstNames;
						}
						if (!LastNames.contains(tmpLastName))
						{
							LastNames+=", "+tmpLastName;
							data[i][3]=LastNames;
						}
						if(!Categories.contains(tmpCategory))
						{
							Categories+=", "+tmpCategory;
							data[i][5]=Categories;
						}
					}
					else
					{
						i++;
						data[i][0]=tmpID;
						data[i][1]=tmpTitle;
						data[i][2]=tmpFirstName;
						data[i][3]=tmpLastName;
						data[i][4]=tmpPublisher;
						data[i][5]=tmpCategory;
						data[i][6]=tmpNoOfCopies;
						data[i][7]=tmpPrice;
						previousID=tmpID;
						LastNames=tmpLastName;
						FirstNames=tmpFirstName;
						Categories=tmpCategory;
					}
				}
				rs.close();
				cs.close();
				return data;
				}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		else 
		{
			if (title.equals("")) title="%";
			if (authorsFN.equals("")) authorsFN="%";
			if (authorsLN.equals("")) authorsLN="%";
			if (publisher.equals("")) publisher="%";
			if (category.equals("")) category="%";
			if(noOfCopies!=null && price!=null)
				try
				{	
				CallableStatement cs= conn.prepareCall("{call getSpecificBooksWithNoOfCopiesAndPrice(?,?,?,?,?,?,?)}");
				cs.setString(1,title);
				cs.setInt(2, noOfCopies);
				cs.setString(3,authorsFN);
				cs.setString(4,authorsLN);
				cs.setString(5,publisher);
				cs.setString(6,category);
				cs.setInt(7,price);
				ResultSet rs = cs.executeQuery();
				int n=0;
				while (rs.next()) n++; //n=no. of rows
				rs.beforeFirst();
				Object[][] data=new Object[n][8]; 
				int i=-1; //current row
				while(rs.next()){
					//Retrieve by column name
					tmpID=rs.getInt("BookID");
					tmpTitle=rs.getString("Title");
					tmpFirstName=rs.getString("Author's_FirstName");
					tmpLastName=rs.getString("Author's_LastName");
					tmpPublisher=rs.getString("Publisher");
					tmpCategory=rs.getString("Category");
					tmpNoOfCopies=rs.getInt("NoOfCopies");
					tmpPrice=rs.getInt("Price");
					if (tmpID==previousID)
					{
						if (!FirstNames.contains(tmpFirstName))
						{
							FirstNames+=", "+tmpFirstName;
							data[i][2]=FirstNames;
						}
						if (!LastNames.contains(tmpLastName))
						{
							LastNames+=", "+tmpLastName;
							data[i][3]=LastNames;
						}
						if(!Categories.contains(tmpCategory))
						{
							Categories+=", "+tmpCategory;
							data[i][5]=Categories;
						}
					}
					else
					{
						i++;
						data[i][0]=tmpID;
						data[i][1]=tmpTitle;
						data[i][2]=tmpFirstName;
						data[i][3]=tmpLastName;
						data[i][4]=tmpPublisher;
						data[i][5]=tmpCategory;
						data[i][6]=tmpNoOfCopies;
						data[i][7]=tmpPrice;
						previousID=tmpID;
						LastNames=tmpLastName;
						FirstNames=tmpFirstName;
						Categories=tmpCategory;
					}
				}
				rs.close();
				cs.close();
				return data;
				}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
			else if (noOfCopies!=null)
			try
				{	
				CallableStatement cs= conn.prepareCall("{call getSpecificBooksWithNoOfCopies(?,?,?,?,?,?)}");
				cs.setString(1,title);
				cs.setInt(2, noOfCopies);
				cs.setString(3,authorsFN);
				cs.setString(4,authorsLN);
				cs.setString(5,publisher);
				cs.setString(6,category);
				ResultSet rs = cs.executeQuery();
				int n=0;
				while (rs.next()) n++; //n=no. of rows
				rs.beforeFirst();
				Object[][] data=new Object[n][8]; 
				int i=-1; //current row
				while(rs.next()){
					//Retrieve by column name
					tmpID=rs.getInt("BookID");
					tmpTitle=rs.getString("Title");
					tmpFirstName=rs.getString("Author's_FirstName");
					tmpLastName=rs.getString("Author's_LastName");
					tmpPublisher=rs.getString("Publisher");
					tmpCategory=rs.getString("Category");
					tmpNoOfCopies=rs.getInt("NoOfCopies");
					tmpPrice=rs.getInt("Price");
					if (tmpID==previousID)
					{
						if (!FirstNames.contains(tmpFirstName))
						{
							FirstNames+=", "+tmpFirstName;
							data[i][2]=FirstNames;
						}
						if (!LastNames.contains(tmpLastName))
						{
							LastNames+=", "+tmpLastName;
							data[i][3]=LastNames;
						}
						if(!Categories.contains(tmpCategory))
						{
							Categories+=", "+tmpCategory;
							data[i][5]=Categories;
						}
					}
					else
					{
						i++;
						data[i][0]=tmpID;
						data[i][1]=tmpTitle;
						data[i][2]=tmpFirstName;
						data[i][3]=tmpLastName;
						data[i][4]=tmpPublisher;
						data[i][5]=tmpCategory;
						data[i][6]=tmpNoOfCopies;
						data[i][7]=tmpPrice;
						previousID=tmpID;
						LastNames=tmpLastName;
						FirstNames=tmpFirstName;
						Categories=tmpCategory;
					}
				}
				rs.close();
				cs.close();
				return data;
				}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
			else if(price!=null)
			try
			{	
			CallableStatement cs= conn.prepareCall("{call getSpecificBooksWithPrice(?,?,?,?,?,?)}");
			cs.setString(1,title);
			cs.setString(2,authorsFN);
			cs.setString(3,authorsLN);
			cs.setString(4,publisher);
			cs.setString(5,category);
			cs.setInt(6,price);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][8]; 
			int i=-1; //current row
			while(rs.next()){
				//Retrieve by column name
				tmpID=rs.getInt("BookID");
				tmpTitle=rs.getString("Title");
				tmpFirstName=rs.getString("Author's_FirstName");
				tmpLastName=rs.getString("Author's_LastName");
				tmpPublisher=rs.getString("Publisher");
				tmpCategory=rs.getString("Category");
				tmpNoOfCopies=rs.getInt("NoOfCopies");
				tmpPrice=rs.getInt("Price");
				if (tmpID==previousID)
				{
					if (!FirstNames.contains(tmpFirstName))
					{
						FirstNames+=", "+tmpFirstName;
						data[i][2]=FirstNames;
					}
					if (!LastNames.contains(tmpLastName))
					{
						LastNames+=", "+tmpLastName;
						data[i][3]=LastNames;
					}
					if(!Categories.contains(tmpCategory))
					{
						Categories+=", "+tmpCategory;
						data[i][5]=Categories;
					}
				}
				else
				{
					i++;
					data[i][0]=tmpID;
					data[i][1]=tmpTitle;
					data[i][2]=tmpFirstName;
					data[i][3]=tmpLastName;
					data[i][4]=tmpPublisher;
					data[i][5]=tmpCategory;
					data[i][6]=tmpNoOfCopies;
					data[i][7]=tmpPrice;
					previousID=tmpID;
					LastNames=tmpLastName;
					FirstNames=tmpFirstName;
					Categories=tmpCategory;
				}
			}
			rs.close();
			cs.close();
			return data;
			}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
			else 
			try
			{	
			CallableStatement cs= conn.prepareCall("{call getSpecificBooks(?,?,?,?,?)}");
			cs.setString(1,title);
			cs.setString(2,authorsFN);
			cs.setString(3,authorsLN);
			cs.setString(4,publisher);
			cs.setString(5,category);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][8]; 
			int i=-1; //current row
			while(rs.next()){
				//Retrieve by column name
				tmpID=rs.getInt("BookID");
				tmpTitle=rs.getString("Title");
				tmpFirstName=rs.getString("Author's_FirstName");
				tmpLastName=rs.getString("Author's_LastName");
				tmpPublisher=rs.getString("Publisher");
				tmpCategory=rs.getString("Category");
				tmpNoOfCopies=rs.getInt("NoOfCopies");
				tmpPrice=rs.getInt("Price");
				if (tmpID==previousID)
				{
					if (!FirstNames.contains(tmpFirstName))
					{
						FirstNames+=", "+tmpFirstName;
						data[i][2]=FirstNames;
					}
					if (!LastNames.contains(tmpLastName))
					{
						LastNames+=", "+tmpLastName;
						data[i][3]=LastNames;
					}
					if(!Categories.contains(tmpCategory))
					{
						Categories+=", "+tmpCategory;
						data[i][5]=Categories;
					}
				}
				else
				{
					i++;
					data[i][0]=tmpID;
					data[i][1]=tmpTitle;
					data[i][2]=tmpFirstName;
					data[i][3]=tmpLastName;
					data[i][4]=tmpPublisher;
					data[i][5]=tmpCategory;
					data[i][6]=tmpNoOfCopies;
					data[i][7]=tmpPrice;
					previousID=tmpID;
					LastNames=tmpLastName;
					FirstNames=tmpFirstName;
					Categories=tmpCategory;
				}
			}
			rs.close();
			cs.close();
			return data;
			}
			catch(SQLException sqle)
			{
			sqle.printStackTrace();
			return null;
			}
		}
	}


	
	/**
	 * Searches for Authors based on input, the id or both names, or only one name can be specified
	 * @param id author's id or null
	 * @param authorsFN author's Authors's FirstName or ""
	 * @param authorsLN author's Author's LastName or ""
	 * @return a matrix with the found authors data or null if an error occurs or all parameters are null or ""
	 */
	public Object[][] searchAuthor(Integer id, String authorsFN, String authorsLN) {
		if (id!=null)
		{
			try
			{
			CallableStatement cs= conn.prepareCall("{call getAuthorByID(?)}");
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][3]; 
			int i=0; //current row
			while(rs.next())
				{
				//Retrieve by column name
				data[i][0]=rs.getInt("AuthorID");
				data[i][1]=rs.getString("FirstName");
				data[i][2]=rs.getString("LastName");
				i++;
				}
			rs.close();
			cs.close();
			return data;
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
		}
		else if (!authorsFN.equals("") && !authorsLN.equals(""))
		try{
		CallableStatement cs= conn.prepareCall("{call getAuthorsByName(?,?)}");
		cs.setString(1, authorsFN);
		cs.setString(2, authorsLN);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][3]; 
		int i=0; //current row
		while(rs.next()){
			//Retrieve by column name
			data[i][0]=rs.getInt("AuthorID");
			data[i][1]=rs.getString("FirstName");
			data[i][2]=rs.getString("LastName");
			i++;
		}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		else if (!authorsFN.equals(""))
		try{
		CallableStatement cs= conn.prepareCall("{call getAuthorsByFirstName(?)}");
		cs.setString(1, authorsFN);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][3]; 
		int i=0; //current row
		while(rs.next()){
			//Retrieve by column name
			data[i][0]=rs.getInt("AuthorID");
			data[i][1]=rs.getString("FirstName");
			data[i][2]=rs.getString("LastName");
			i++;
		}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		else if (!authorsLN.equals(""))
		try{
		CallableStatement cs= conn.prepareCall("{call getAuthorsByLastName(?)}");
		cs.setString(1, authorsLN);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][3]; 
		int i=0; //current row
		while(rs.next()){
			//Retrieve by column name
			data[i][0]=rs.getInt("AuthorID");
			data[i][1]=rs.getString("FirstName");
			data[i][2]=rs.getString("LastName");
			i++;
		}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		return null;
	}
	
	/**
	 * Searches for Publishers base on input, the id or the name can be specified
	 * @param id Publisher's id or null
	 * @param publisher Publisher's name or ""
	 * @return  a matrix with the found publishers data or null if an error occurs or all parameters are null or ""
	 */
	public Object[][] searchPublisher(Integer id, String publisher) {
		if (id!=null)
		{
			try
			{
			CallableStatement cs= conn.prepareCall("{call getPublisherByID(?)}");
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][2]; 
			int i=0; //current row
			while(rs.next())
				{
				//Retrieve by column name
				data[i][0]=rs.getInt("publisherID");
				data[i][1]=rs.getString("name");
				i++;
				}
			rs.close();
			cs.close();
			return data;
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
		}
		else if (!publisher.equals(""))
		try{
		CallableStatement cs= conn.prepareCall("{call getPublishersByName(?)}");
		cs.setString(1, publisher);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][2]; 
		int i=0; //current row
		while(rs.next()){
			//Retrieve by column name
			data[i][0]=rs.getInt("PublisherID");
			data[i][1]=rs.getString("Name");
			i++;
		}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * Searches for Categories base on input, the id or the name can be specified
	 * @param id Category's id or null
	 * @param name Category's name or ""
	 * @return  a matrix with the found Categories or null if an error occurs or all parameters are null or ""
	 */
	public Object[][] searchCategories(Integer id, String name) {
		if (id!=null)
		{
			try
			{
			CallableStatement cs= conn.prepareCall("{call getCategoryByID(?)}");
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][2]; 
			int i=0; //current row
			while(rs.next())
				{
				//Retrieve by column name
				data[i][0]=rs.getInt("CategoryID");
				data[i][1]=rs.getString("name");
				i++;
				}
			rs.close();
			cs.close();
			return data;
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
		}
		else if (!name.equals(""))
		try{
		CallableStatement cs= conn.prepareCall("{call getCategoriesByName(?)}");
		cs.setString(1, name);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][2]; 
		int i=0; //current row
		while(rs.next()){
			//Retrieve by column name
			data[i][0]=rs.getInt("CategoryID");
			data[i][1]=rs.getString("Name");
			i++;
		}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * Searches for clients based on the input, at least one input must be different than null or ""
	 * @param id client's id or null 
	 * @param name client's name or ""
	 * @param phone client's phone or ""
	 * @param address client's address or ""
	 * @param email client's email or ""
	 * @param credit client's credit or null
	 * @return a matrix with the found clients data or null in case of error or all parameters are "" or null
	 */
	public Object[][] searchClients(Integer id, String name, String phone,
			String address, String email, Integer credit) {
		if (id!=null)
		{
			try
			{
			CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
			cs.setInt(1, id);
			ResultSet rs = cs.executeQuery();
			int n=0;
			while (rs.next()) n++; //n=no. of rows
			rs.beforeFirst();
			Object[][] data=new Object[n][6]; 
			int i=0; //current row
			while(rs.next())
				{
				//Retrieve by column name
				data[i][0]=rs.getInt("ClientID");
				data[i][1]=rs.getString("name");
				data[i][2]=rs.getString("phone");
				data[i][3]=rs.getString("address");
				data[i][4]=rs.getString("email");
				data[i][5]=rs.getInt("credit");
				i++;
				}
			rs.close();
			cs.close();
			return data;
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return null;
			}
		}
			else 
			{
				if (name.equals("")) name="%";
				if (phone.equals("")) phone="%";
				if (address.equals("")) address="%";
				if (email.equals("")) email="%";
				if (credit!=null)
				{
					try{
						CallableStatement cs= conn.prepareCall("{call getSpecificClientsWithCredit(?,?,?,?,?)}");
						cs.setString(1, name);
						cs.setString(2,phone);
						cs.setString(3, address);
						cs.setString(4, email);
						cs.setInt(5,credit);
						ResultSet rs = cs.executeQuery();
						int n=0;
						while (rs.next()) n++; //n=no. of rows
						rs.beforeFirst();
						Object[][] data=new Object[n][6]; 
						int i=0; //current row
						while(rs.next()){
							//Retrieve by column name
							data[i][0]=rs.getInt("ClientID");
							data[i][1]=rs.getString("name");
							data[i][2]=rs.getString("phone");
							data[i][3]=rs.getString("address");
							data[i][4]=rs.getString("email");
							data[i][5]=rs.getInt("credit");
							i++;
						}
						rs.close();
						cs.close();
						return data;
						}
						catch(SQLException sqle)
						{
							sqle.printStackTrace();
							return null;
						}
				}
				else
				try{
				CallableStatement cs= conn.prepareCall("{call getSpecificClients(?,?,?,?)}");
				cs.setString(1, name);
				cs.setString(2,phone);
				cs.setString(3, address);
				cs.setString(4, email);
				ResultSet rs = cs.executeQuery();
				int n=0;
				while (rs.next()) n++; //n=no. of rows
				rs.beforeFirst();
				Object[][] data=new Object[n][6]; 
				int i=0; //current row
				while(rs.next()){
					//Retrieve by column name
					data[i][0]=rs.getInt("ClientID");
					data[i][1]=rs.getString("name");
					data[i][2]=rs.getString("phone");
					data[i][3]=rs.getString("address");
					data[i][4]=rs.getString("email");
					data[i][5]=rs.getInt("credit");
					i++;
				}
				rs.close();
				cs.close();
				return data;
				}
				catch(SQLException sqle)
				{
					sqle.printStackTrace();
					return null;
				}
			}
	}

	public Object[][] getAccount(Integer ID) {
		try
		{
		CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
		cs.setInt(1, ID);
		ResultSet rs = cs.executeQuery();
		int n=0;
		while (rs.next()) n++; //n=no. of rows
		rs.beforeFirst();
		Object[][] data=new Object[n][6]; 
		int i=0; //current row
		while(rs.next())
			{
			//Retrieve by column name
			data[i][0]=rs.getInt("ClientID");
			data[i][1]=rs.getString("name");
			data[i][2]=rs.getString("phone");
			data[i][3]=rs.getString("address");
			data[i][4]=rs.getString("email");
			data[i][5]=rs.getInt("credit");
			i++;
			}
		rs.close();
		cs.close();
		return data;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
	}

	/**
	 * Gets the logged in client's id
	 * @return the logged in client's id
	 */
	public Integer getClientID() {
		return clientID;
	}

	/**
	 * Sets the logged in client's id
	 * @param clientID the logged in client's id
	 */
	public void setClientID(Integer clientID) {
		this.clientID = clientID;
	}

	/**
	 * Tries to decrease the number of copies of a book, if the client has enough credit
	 * @param id the book's id
	 * @return true on success, false otherwise
	 */
	public boolean buyBook(Integer id) {	
		//get user credit
		Integer credit, price, noOfCopies;
		try
		{
		CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
		cs.setInt(1, this.clientID);
		ResultSet rs = cs.executeQuery();
		rs.next();
		credit=rs.getInt("credit");
		rs.close();
		cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		// get book's price and noOfCopies
		try
		{
		CallableStatement cs= conn.prepareCall("{call getBooksWithID(?)}");
		cs.setInt(1, id);
		ResultSet rs = cs.executeQuery();
		rs.next();
		price=rs.getInt("price");
		noOfCopies=rs.getInt("noOfCopies");
		rs.close();
		cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		//check noOfCopies
		if (noOfCopies==0) return false;
		else
		{
		noOfCopies--;
		//check if enough credit
		if (credit>=price)
		{
			//decrease credit
			 String sql=new String("update clients set credit="+(credit-price)+" where ClientID="+this.clientID);
		     PreparedStatement stmt;
		     try {
		    	 stmt = conn.prepareStatement(sql);
		    	 stmt.executeUpdate();
		    	 stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
		     //decrease noOfCopies
		     sql=new String("update books set noOfCopies="+noOfCopies+" where BookID="+id);
		     try {
		    	 stmt = conn.prepareStatement(sql);
		    	 stmt.executeUpdate();
		    	 stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
		     //buying was successful
		     	bookID=id;
				return true;
			}
		else return false;
		}
	}

	/**
	 * Attempts to add funds to the specified account
	 * @param id the id of the clients account
	 * @param funds the funds to add
	 * @return true on success, false otherwise
	 */
	public boolean addFunds(Integer id, Integer funds) {
		//get user credit
			Integer credit;
			try
			{
				CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
				cs.setInt(1, id);
				ResultSet rs = cs.executeQuery();
				rs.next();
				credit=rs.getInt("credit");
				rs.close();
				cs.close();
			}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
				return false;
			}
			//add funds to credit
			 String sql=new String("update clients set credit="+(credit+funds)+" where ClientID="+id);
		     PreparedStatement stmt;
		     try {
		    	 stmt = conn.prepareStatement(sql);
		    	 stmt.executeUpdate();
		    	 stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					return false;
				}
		return true;
	}

	/**
	 * creates and opens a .pdf receipt based on clientID and bookID
	 * @return true on success, false otherwise
	 */
	public boolean GetReceipt() {
		//get client info
		Integer clientID, credit, bookID = null, price = null,previousID=-1;
		String name, phone,  address, email, title = null, authorsFN ="",  authorsLN = "", publisher = null, categories = "";
		try
		{
			CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
			cs.setInt(1, this.clientID);
			ResultSet rs = cs.executeQuery();
			rs.next();
			clientID=rs.getInt("ClientID");
			name=rs.getString("name");
			phone=rs.getString("phone");
			address=rs.getString("address");
			email=rs.getString("email");
			credit=rs.getInt("credit");
			rs.close();
			cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		//get book info
		try
		{
			CallableStatement cs= conn.prepareCall("{call getBooksWithID(?)}");
			cs.setInt(1, this.bookID);
			ResultSet rs = cs.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				bookID=rs.getInt("BookID");
				title=rs.getString("Title");
				String tmpFirstName = rs.getString("Author's_FirstName");
				String tmpLastName = rs.getString("Author's_LastName");
				publisher=rs.getString("Publisher");
				String tmpCategory = rs.getString("Category");
				price=rs.getInt("Price");
				if (bookID==previousID)
				{
					if (!authorsFN.contains(tmpFirstName))
						authorsFN+=", "+tmpFirstName;
					if (!authorsLN.contains(tmpLastName))
						authorsLN+=", "+tmpLastName;
					if(!categories.contains(tmpCategory))
						categories+=", "+tmpCategory;
				}	
				else
				{				
				previousID=bookID;
				authorsLN=tmpLastName;
				authorsFN=tmpFirstName;
				categories=tmpCategory;
				}
			}
			rs.close();
			cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		pdf.createPDF(clientID, name, phone, address, email, credit, bookID, title, authorsFN, authorsLN, publisher, categories, price);
		pdf.open(this.clientID, this.bookID);
		return true;
	}

	public boolean SendMail() {
		//get client info
		Integer clientID, credit, bookID = null, price = null,previousID=-1;
		String name, phone,  address, email, title = null, authorsFN ="",  authorsLN = "", publisher = null, categories = "";
		try
		{
			CallableStatement cs= conn.prepareCall("{call getClientByID(?)}");
			cs.setInt(1, this.clientID);
			ResultSet rs = cs.executeQuery();
			rs.next();
			clientID=rs.getInt("ClientID");
			name=rs.getString("name");
			phone=rs.getString("phone");
			address=rs.getString("address");
			email=rs.getString("email");
			credit=rs.getInt("credit");
			rs.close();
			cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		//get book info
		try
		{
			CallableStatement cs= conn.prepareCall("{call getBooksWithID(?)}");
			cs.setInt(1, this.bookID);
			ResultSet rs = cs.executeQuery();
			while(rs.next()){
				//Retrieve by column name
				bookID=rs.getInt("BookID");
				title=rs.getString("Title");
				String tmpFirstName = rs.getString("Author's_FirstName");
				String tmpLastName = rs.getString("Author's_LastName");
				publisher=rs.getString("Publisher");
				String tmpCategory = rs.getString("Category");
				price=rs.getInt("Price");
				if (bookID==previousID)
				{
					if (!authorsFN.contains(tmpFirstName))
						authorsFN+=", "+tmpFirstName;
					if (!authorsLN.contains(tmpLastName))
						authorsLN+=", "+tmpLastName;
					if(!categories.contains(tmpCategory))
						categories+=", "+tmpCategory;
				}	
				else
				{				
				previousID=bookID;
				authorsLN=tmpLastName;
				authorsFN=tmpFirstName;
				categories=tmpCategory;
				}
			}
			rs.close();
			cs.close();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return false;
		}
		this.sendEmail.send(clientID, name, phone, address, email, credit, bookID, title, authorsFN, authorsLN, publisher, categories, price);
		return true;
	}
}
