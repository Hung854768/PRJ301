/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

/**
 *
 * @author asus
 */
public class UserDAO extends DBContext {

    //check tài khoản
    public User check(String username, String password) {
        String sql = "SELECT * FROM [dbo].[User] WHERE name = ? and password = ?";
        User user = null;

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getString("name"), 
                    rs.getString("password"), 
                    rs.getString("fullname"), 
                    rs.getString("email"), 
                    rs.getString("phonenum"), 
                    rs.getString("address"), 
                    rs.getInt("role"), 
                    rs.getInt("id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getCustomerBuyMost() {
        String sql = "select top(1) count(o.cid) as 'NumOfOrds', o.cid, u.fullname, u.email, u.phonenum, u.address\n"
                + "from [PRJ301].[dbo].[Order] o join [User] u on u.id = o.cid\n"
                + "where o.totalmoney != 0\n"
                + "group by o.cid, u.fullname, u.email, u.phonenum, u.address\n"
                + "order by COUNT(cid) desc";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("cid"));
                user.setAddress(resultSet.getString("address"));
                user.setPhonenum(resultSet.getString("phonenum"));
                user.setEmail(resultSet.getString("email"));
                user.setFullname(resultSet.getString("fullname"));
                user.setNumOfOrds(resultSet.getInt("NumOfOrds"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<User> getAllUsers() {
  List<User> userList = new ArrayList<>();
  String selectSql = "SELECT [name], [passWord] FROM [dbo].[User]";
  try {
      PreparedStatement prepStat = connection.prepareStatement(selectSql);
      ResultSet resultSet = prepStat.executeQuery();
      while (resultSet.next()) {
          User user = new User();
          user.setUsername(resultSet.getString("name"));
          user.setPassword(resultSet.getString("password"));
          userList.add(user);
      }
  } catch (SQLException exception) {
      System.out.println(exception);
  }
  return userList;
} 

    public void change(User user) {
        String updateQuery = "UPDATE [dbo].[User]\n"
                + "   SET [password] = ?\n"
                + " WHERE [name]=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    } 

    public void updateUser(User user) {
        String sqlQuery = "UPDATE [dbo].[User]\n"
                + "   SET [fullname] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[phonenum] = ?\n"
                + "      ,[address] = ?\n"
                + " WHERE [name]=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, user.getFullname());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPhonenum());
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getUsername());

            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

    public boolean doesUserExist(String username) {
    String sql = "SELECT [name]\n"
            + "      ,[fullname]\n"
            + "      ,[email]\n"
            + "      ,[phonenum]\n"
            + "      ,[password]\n"
            + "  FROM [dbo].[User] where name=?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return true;
        }
    } catch (Exception e) {
        // handle any exceptions that occur
    }
    return false;
}

    public boolean isEmailExsited(String email) {
    String query = "SELECT * FROM User WHERE email=?";
    try {
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            return true;
        }
    } catch (SQLException e) {
        // Handle exception
    }
    return false;
} 

    public boolean isPhoneNumExisting(String phoneNumber) {
        String query = "SELECT [name]\n"
                + "      ,[fullname]\n"
                + "      ,[email]\n"
                + "      ,[phonenum]\n"
                + "      ,[password]\n"
                + "  FROM [dbo].[User] WHERE phonenum=?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, phoneNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception exception) {
            // Handle the exception
        }
        return false;
    }

    // dang ki
    public void register(User a) {
        String sql = "INSERT INTO [dbo].[User]\n"
                + "           ([name]\n"
                + "           ,[password]\n"
                + "           ,[fullname]\n"
                + "           ,[email]\n"
                + "           ,[phonenum])\n"
                + "             VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setString(2, a.getPassword());
            st.setString(3, a.getFullname());
            st.setString(4, a.getEmail());
            st.setString(5, a.getPhonenum());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        UserDAO d = new UserDAO();
//        List<User> list = d.getAll();
//        System.out.println(list.get(0).getPassword());
//        User u = new User("abc", "123123", "dmfpt", "a@gmail.com", "123123");
//        System.out.println(d.getCustomerBuyMost());
    }
}
