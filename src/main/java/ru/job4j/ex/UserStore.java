package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User Not Found.");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("The user is not valid.");
        }
        return result;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}