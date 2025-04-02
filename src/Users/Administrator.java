package Users;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    public static void addUser(List<User> userList, String name, String password, String userType) {
        userList.add(new User(String.valueOf((userList.size() + 1)), name, password, userType));
    }

    /**
     * Asks for a user ID to update the user's details.
     */
    public void updateUser(ArrayList<User> userList, String newName, String newPassword, String newUserType) {
        if (User.userExists(userList, userName)) {
            userList.get(User.searchUserByName(userList, userName)).setUserName(newName);
            userList.get(User.searchUserByName(userList, userName)).setUserPassword(newPassword);
            userList.get(User.searchUserByName(userList, userName)).setUserType(newUserType);
        }
    }

    /**
     * Removes a user from the system.
     */
    public void removeUser(List<User> userList, String userToRemove) {
        userList.remove(User.searchUserByName(userList,userToRemove));
        System.out.println("User successfully removed.");
    }

    @Override
    public void actionMenu()
}
