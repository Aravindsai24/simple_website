# simple webview
A simple website with login screen that redirects to the user given url.

# Code Structure
```
  * Controllers
    - LoginController
    - RegistrationController
    - PostLoginController
  * Models
    - User
    - UserData
  * Repository
    - UsersRepository
    - UserDataRepository
  * Application
```
# Controllers
## LoginController
It handles the login page (route `/login`)
it takes the username and password from the user checks in the `users` database for validation, on matching credentials it navigates the user to postLogin screen (i.e., URL input screen) and wrong credentials it redirects the user to the same login page again.

## RegistrationController
It handles the register page (route `/register`)
it takes the username and password of the new user and adds the details to `users` table in tha database.

## PostLoginController
It takes the url from the user and maps the url with userID and pushes it to the `userData` table. Directs user to the given url.

# Models
 * User model is to store the user details such as username and password.
 * UserData model is to store the user specified url along with the userID.

# Repository
 * UsersRepository provides the abstraction to access the data in `users` table
 * UserDataRepository provides the abstraction to access the data in `userData` table



