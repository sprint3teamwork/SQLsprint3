package org.example.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.model.domain.Decoration;
import org.example.model.domain.Flower;
import org.example.model.domain.Product;
import org.example.model.domain.Tree;

public class StockSQLServerDAO implements StockDAO {
	
	/*saw this on: https://coderanch.com/t/646858/databases/implement-DAO-update-method
	 * that way a local variable isnt created everytime and its easier to change later on.
	 * 
	 * 
	 * private static final String AUTHENTICATE = "SELECT * FROM users WHERE email=? and password=?";
    private static final String DELETE = "DELETE FROM users WHERE id=?";
    private static final String TRUNCATE = "TRUNCATE users";
    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id=?";
    private static final String FIND_ALL = "SELECT * FROM users ORDER BY id";
    private static final String INSERT = "INSERT INTO users (id, firstName, lastName, joinDate, cardId, email, password, phoneNumber, accountType, location) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET firstName=?, lastName=?, joinDate=?, cardId=?, email=?, password=?, phoneNumber=?, accountType=?, location=? WHERE id=?";
	 */
	
	//this method needed to add all products on first connection?
	//also is another constructor needed to include the invoiceID?
	//flowershop needed to receive addstock and removestock methods?
	@Override
	public List<Product> findAll() {
		
		List<Product> stockList = new ArrayList();
		
		String prompt = "SELECT * FROM stockList;";
		
		try(Connection newConnect = DatabaseConnection.getConnection();
			PreparedStatement ps = newConnect.prepareStatement(prompt);
			ResultSet rs = ps.executeQuery()
			) {
				while (rs.next()) {
					Product p = new Product();
					String type = rs.getString(4);
					//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id
					
					switch(type) {
					case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
					break;
					case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
					break;
					case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
					break;
					}
					stockList.add(p);
					//flowerShopp.setStockValue += p.getprice when?
					//flowerShopp.putProductMap put.p
				}				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public Product findById(int id) {
		
		Product p = new Product();
		p.setId(id);
		
		String prompt = "SELECT * FROM stockList where id = " + id + ";";
		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			rs.next();
			
			String type = rs.getString(4);
			//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id
			
			switch(type) {
			case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
			break;
			case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
			break;
			case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
			break;
			}
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> findByName(String name) {
		
		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where name = " + name + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public List<Product> findByPrice(double price) {

		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where price = " + price + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public List<Product> findByType(String productType) {

		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where type = " + productType + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public List<Product> findByHeight(float height) {

		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where height = " + height + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public List<Product> findByColor(String color) {

		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where height = " + color + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public List<Product> findByMaterial(boolean material) {
		
		List<Product> stockList = new ArrayList();

		String prompt = "SELECT * FROM stockList where material_is_wood = " + material + ";";

		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			while (rs.next()) {
				Product p = new Product();
				String type = rs.getString(4);
				//p.setInvoiceId(rs.getInt(8));	need this variable		//or string param invoice_id

				switch(type) {
				case "Tree": p = new Tree(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getFloat(5));
				break;
				case "Flower": p = new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(6));
				break;
				case "Decoration": p = new Decoration(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getBoolean(7));
				break;
				}
				stockList.add(p);
				//flowerShopp.setStockValue += p.getprice when?
				//flowerShopp.putProductMap put.p
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} 
		return stockList;
	}

	@Override
	public boolean insertProduct(Product p) {
	
		String prompt = "INSERT INTO stockList (product_id, name, price, "
				+ "type, height, color, material_is_wood, invoice_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			
			ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getType());
            
            switch(p.getType()) {
            	case "Tree": Tree tree = (Tree) p; 
            			ps.setFloat(5, tree.getHeight());
            			p = tree;
            	break;
	            case "Flower": Flower flower = (Flower) p;
	            		ps.setString(6, flower.getColor());
	            		p = flower;
	            break;
	            case "Decoration": Decoration decoration = (Decoration) p;
	            		ps.setBoolean(7, decoration.isMaterialIsWood());
	            		p = decoration;
	            break;
            }
                        
            //ps.setInt(8, p.getInvoiceId());			//to be applied still

            ps.executeUpdate();
  
            System.out.println("Product with following details was saved in DB: " + p.toString());
			
            return true;
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		
		String prompt = "UPDATE stockList SET product_id=?, name=?, price=?, type=?, height=?, color=?, material_is_wood=?, invoice_id=? WHERE product_id=?";
		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			
			ps.setInt(1, p.getId());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getType());
            
            switch(p.getType()) {
            	case "Tree": Tree tree = (Tree) p; 
            			ps.setFloat(5, tree.getHeight());
            			p = tree;
            	break;
	            case "Flower": Flower flower = (Flower) p;
	            		ps.setString(6, flower.getColor());
	            		p = flower;
	            break;
	            case "Decoration": Decoration decoration = (Decoration) p;
	            		ps.setBoolean(7, decoration.isMaterialIsWood());
	            		p = decoration;
	            break;
            }
            
          //ps.setInt(8, p.getInvoiceId());			//to be applied still
            
            ps.executeUpdate();
       
            System.out.println("User with id " + p.getId() + " was updated in DB with following details: " + p.toString());

            return true;
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		String prompt = "DELETE FROM stockList WHERE product_id=?";
		try(Connection newConnect = DatabaseConnection.getConnection();
				PreparedStatement ps = newConnect.prepareStatement(prompt);
				ResultSet rs = ps.executeQuery()
				) {
			
			ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();

            System.out.println("Product with id: " + id + " was sucesfully deleted from DB.");
			
		}catch (SQLException sqle) {
			sqle.printStackTrace();
		}return false;
	}

}
