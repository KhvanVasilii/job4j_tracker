package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean isValidName = user.getUsername().length() > 2;
        if (isValidName && user.isValid()) {
            return true;
        }
        throw new UserInvalidException("Invalid user");
    }

    public static void main(String[] args) {
        User[] users = {new User("Khvan Vasilii", true),
                        new User("Pa", true),
                        new User("Petr Arsentev", true)};
        try {
            User user = findUser(users, "Khvan Vasilii");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println(e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
