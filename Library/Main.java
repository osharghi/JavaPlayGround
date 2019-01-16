

import java.sql.*;

public class Main {
	
	public static void main(String[] args) throws Exception
    {
		Connection initialConn = null;
        Connection conn = null;
 
        try
        {
        		initialConn = getInitialConnection(); //initial connection used for creating the database
            createDatabase(initialConn);
            conn = getPrimaryConnection(); //primary connection used for connecting to database
            dropTables(conn);
            createTables(conn);
            populate(conn);
            requiredQueries(conn);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
            		initialConn.close();
                conn.close();
            }
            catch (SQLException e)
            {
                System.out.println("SQL Exception " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
		
		
	public static void createTables(Connection conn) throws Exception
    {
        PreparedStatement create = null;
   
        // Create publishers table
        create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS publishers "
            + "(publisherID int NOT NULL AUTO_INCREMENT, publisherName char(100) NOT NULL UNIQUE, "
            + "PRIMARY KEY (publisherID))");
        create.executeUpdate();
   
        // Create titles table
        create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS titles "
            + "(isbn char(10) NOT NULL, editionNumber int NOT NULL, year char(4) NOT NULL, publisherID int NOT NULL, price float(8,2) NOT NULL, title varchar(500) NOT NULL, "
            + "FOREIGN KEY (publisherID) REFERENCES publishers(publisherID) ON UPDATE CASCADE ON DELETE CASCADE, PRIMARY KEY (isbn))");
        create.executeUpdate();
   
        // Create authors table
        create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS authors "
            + "(authorID int NOT NULL AUTO_INCREMENT, firstname char(20) NOT NULL, lastname char(20) NOT NULL, "
            + "PRIMARY KEY (authorID), UNIQUE fullname (firstname, lastname))");
        create.executeUpdate();
   
        // Create authorISBN table
        create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS authorISBN "
            + "(authorID int NOT NULL, isbn char(10) NOT NULL, "
            + "FOREIGN KEY (isbn) REFERENCES titles(isbn) ON UPDATE CASCADE ON DELETE CASCADE, "
            + "FOREIGN KEY (authorID) REFERENCES authors(authorID) ON UPDATE CASCADE ON DELETE CASCADE)");
        create.executeUpdate();
   
        System.out.println("Created tables");
    }
	
	public static void requiredQueries(Connection c) throws Exception
    {
        Statement stmt = c.createStatement();
       
        
        try {
        	
        		// Select all authors sorted alphabetically 
	        String query = "SELECT * FROM authors ORDER BY lastname, firstname";
	        ResultSet rs1 = stmt.executeQuery(query);
	       
	        System.out.println("\nAUTHORS: ");
	        while(rs1.next())
	        {
	            System.out.println(rs1.getString("firstname") + " " + rs1.getString("lastname"));
	        }
	        rs1.close();
	       
	        // Select all publishers
	        query = "SELECT * FROM publishers";
	        ResultSet rs2 = stmt.executeQuery(query);
	   
	        System.out.println("\nPUBLISHERS: ");
	        while(rs2.next())
	        {
	            System.out.println(rs2.getString("publisherName"));
	        }
	        rs2.close();
	       
	        // Select specific author and corresponding books
	        query = "SELECT title, year, isbn FROM titles WHERE publisherID = (SELECT publisherID FROM publishers WHERE publisherName = 'Knopf') ORDER BY title";
	        ResultSet rs3 = stmt.executeQuery(query);
	   
	        System.out.println("\nTITLE FOR PUBLISHER: ");
	        while(rs3.next())
	        {
	            System.out.println("Title:" + rs3.getString("title") + " Year:" + rs3.getString("year") + " ISBN:" + rs3.getString("isbn"));
	        }
	        rs3.close();
	        
	        // Add new author
	        query = "INSERT IGNORE INTO authors (firstname, lastname) VALUES ('William', 'Shakespeare')";
	        stmt.executeUpdate(query);
	       
	        // Update author name
	        query = "UPDATE authors SET firstname = 'Will' WHERE lastname = 'Shakespeare' AND firstname = 'William'";
	        stmt.executeUpdate(query);
	       
	        // Insert new book, author, publisher
	        query = "INSERT IGNORE INTO authors (firstname, lastname) VALUES ('Dan', 'Brown')";
	        stmt.executeUpdate(query);
	        
	        query = "INSERT IGNORE INTO publishers (publisherName) VALUES ('St. Martins Press')";
	        stmt.executeUpdate(query);
	       
	        query = "INSERT INTO titles (isbn, editionNumber, year, publisherID, price, title) "
	                + "VALUES ('031218087X', '1', '1998', (SELECT publisherID FROM publishers WHERE publisherName = 'St. Martins Press'), '16.15', 'Digital Fortress')";
	        stmt.executeUpdate(query);
	       
	        query = "INSERT INTO authorISBN (authorID, isbn) "
	                + "VALUES ((SELECT authorID FROM authors WHERE firstname = 'Dan' AND lastname = 'Brown'), (SELECT isbn FROM titles WHERE title = 'Digital Fortress'))";
	        stmt.executeUpdate(query);
	       
	        // Insert new publisher
	        query = "INSERT IGNORE INTO publishers (publisherName) VALUES ('Bloomsbury')";
	        stmt.executeUpdate(query);
	       
	        // Update publisher name
	        query = "UPDATE publishers SET publisherName = 'Simon and Schuster' WHERE publisherName = 'Simon & Schuster'";
	        stmt.executeUpdate(query);
	    } 
        catch(Exception e) {
        		System.out.println(e.getMessage());
        } finally {
	        try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());};
	    }
    }
	
	// Drops all tables. For testing purposes
	public static void dropTables(Connection conn) throws Exception
    {		
        Statement stmt = conn.createStatement();
       
        String sql = "DROP TABLE IF EXISTS authorISBN";
        stmt.executeUpdate(sql);
       
        sql = "DROP TABLE IF EXISTS authors";
        stmt.executeUpdate(sql);
       
        sql = "DROP TABLE IF EXISTS titles";
        stmt.executeUpdate(sql);
       
        sql = "DROP TABLE IF EXISTS publishers";
        stmt.executeUpdate(sql);
    }
	
	// Establishes connection with database
	public static Connection getPrimaryConnection() throws Exception{
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testDB";
            String username = "root";
            String password = "test157a";
            Class.forName(driver);
       
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Success");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);;
        }
        return null;
    }
	
	// Establishes initial connection used to create the database
	public static Connection getInitialConnection() throws Exception{
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "test157a";
            Class.forName(driver);
       
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Success");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);;
        }
        return null;
    }
   
	// Tests cascade behavior of foreign keys
    public static void testCascade(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
       
        String sql = "DELETE FROM authors WHERE firstname = 'Stephen' AND lastname = 'King'";
        stmt.executeUpdate(sql);
       
        sql = "DELETE FROM publishers WHERE publisherName = 'St. Martins Press'";
        stmt.executeUpdate(sql);
    }
 
    // Creates a database.
    public static void createDatabase(Connection conn) throws Exception
    {
        Statement s = conn.createStatement();
        int result = s.executeUpdate("CREATE DATABASE IF NOT EXISTS testDB");
        System.out.println("Result: " + result);    
    }
   
    // Initial population of tables
    public static void populate(Connection conn) throws Exception
    {
        Statement stmt = conn.createStatement();
       
        // Pulled from Amazon editor's choices for 2018
       
        // Populate authors table
        String sql = "INSERT IGNORE INTO authors(firstname, lastname) VALUES "
                + "('Tara', 'Westover'),"
                + "('Esi', 'Edugyan'),"
                // Vincent and Vladic co-authored a book
                + "('Lynn', 'Vincent'),"
                + "('Sara', 'Vladic'),"
                + "('Stephen', 'King'),"
                + "('Francisco', 'Cantu'),"
                + "('A.J.', 'Finn'),"
                + "('Diane', 'Setterfield'),"
                + "('Tomi', 'Adeyemi'),"
                + "('Leif', 'Enger'),"
                + "('Tommy', 'Orange'),"
                + "('Kristin', 'Hannah'),"
                + "('Beth', 'Macy'),"
                + "('Kevin', 'McCarthy'),"
                + "('Ottessa', 'Moshfegh'),"
                + "('David', 'Blight'),"
                + "('Yuval', 'Harari'),"
                + "('Tana', 'French'),"
                + "('Shobha', 'Rao'),"
                + "('Heather', 'Morris'),"
                + "('John', 'Carreyrou')";
        stmt.executeUpdate(sql);
       
        // Populate publishers table
        sql = "INSERT IGNORE INTO publishers(publisherName) VALUES "
                + "('Random House'),"
                + "('Knopf'),"
                + "('Simon & Schuster'),"
                + "('Scribner'),"
                + "('Riverhead Books'),"
                + "('William Morrow'),"
                + "('Atria/Emily Bestler Books'),"
                + "('Henry Holt and Co.'),"
                + "('Grove Press'),"
                + "('St. Martins Press'),"   // Had to use escape characters to handle the apostrophe
                + "('Little, Brown and Company'),"
                + "('W. W. Norton & Company'),"
                + "('Penguin Press'),"
                + "('Spiegel & Grau'),"
                + "('Viking'),"
                + "('Flatiron Books'),"
                + "('Harper Paperbacks')";
        stmt.executeUpdate(sql);
       
        // Populate titles table
        // Realized too late that since I'm using a best-of-2018 list all the years and editions are identical
        // Randomly chose a few different values for year to avoid potentially overlooking an issue
        sql = "INSERT IGNORE INTO titles(isbn, editionNumber, year, publisherID, price, title) VALUES "
                + "('0399590501', 1, '2015', 1, 16.80, 'Educated'),"
                + "('0525521429', 2, '2013', 2, 18.32, 'Washington Black'),"
                + "('1501135945', 1, '2018', 3, 12.86, 'Indianapolis: The True Story of the Worst Sea Disaster in U.S. Naval History and the Fifty-Year Fight to Exonerate an Innocent Man'),"
                + "('1982102314', 1, '2018', 4, 11.97, 'Elevation'),"
                + "('0735217718', 1, '2018', 5, 17.68, 'The Line Becomes a River: Dispatches from the Border'),"
                + "('0062678416', 1, '2018', 6, 14.51, 'The Woman in the Window'),"
                + "('0743298071', 1, '2018', 7, 20.85, 'Once Upon a River'),"
                + "('1250170972', 1, '2018', 8, 14.24, 'Children of Blood and Bone'),"
                + "('0802128785', 1, '2018', 9, 17.97, 'Virgil Wander'),"
                + "('0525520375', 1, '2018', 2, 15.57, 'There There'),"
                + "('0312577230', 1, '2018', 10, 19.36, 'The Great Alone'),"
                + "('0316551244', 1, '2018', 11, 19.04, 'Dopesick: Dealers\\, Doctors\\, and the Drug Company that Addicted America'),"
                + "('0393652041', 1, '2018', 12, 17.07, 'Wolves of Eden'),"
                + "('0525522115', 1, '2018', 13, 17.68, 'My Year of Rest and Relaxation'),"
                + "('1416590315', 1, '2018', 3, 22.50, 'Frederick Douglas: Prophet of Freedom'),"
                + "('0525512172', 1, '2018', 14, 12.87, '21 Lessons for the 21st Century'),"
                + "('0735224629', 1, '2018', 15, 18.30, 'The Witch Elm'),"
                + "('1250074256', 1, '2018', 16, 17.24, 'Girls Burn Brighter'),"
                + "('0062797158', 1, '2018', 17, 13.58, 'The Tattoist of Auschwitz'),"
                + "('152473165X', 1, '2018', 2, 12.81, 'Bad Blood: Secrets and Lies in a Silicon Valley Startup')";
        stmt.executeUpdate(sql);
       
        // Populate authorISBN
        sql = "INSERT IGNORE INTO authorISBN(authorID, isbn) VALUES "
                + "(1, '0399590501'),"
                + "(2, '0525521429'),"
                + "(3, '1501135945'),"
                + "(4, '1501135945'),"
                + "(5, '1982102314'),"
                + "(6, '0735217718'),"
                + "(7, '0062678416'),"
                + "(8, '0743298071'),"
                + "(9, '1250170972'),"
                + "(10, '0802128785'),"
                + "(11, '0525520375'),"
                + "(12, '0312577230'),"
                + "(13, '0316551244'),"
                + "(14, '0393652041'),"
                + "(15, '0525522115'),"
                + "(16, '1416590315'),"
                + "(17, '0525512172'),"
                + "(18, '0735224629'),"
                + "(19, '1250074256'),"
                + "(20, '0062797158'),"
                + "(21, '152473165X')";
        stmt.executeUpdate(sql);
    }
}