How To Build a Github OAuth 2 Client with Spring Boot.

Project includes:
- Usage of Rest client
- Usage of OAuth2.0 client
- Usage of Github [Rest API](https://docs.github.com/en/rest/users/users?apiVersion=2022-11-28#get-a-user)

Github setup:
- Open [Developers settings](https://github.com/settings/developers)
- Click [New OAuth App](https://github.com/settings/applications/new)
  - Provides
    - Application name
    - [Homepage URL](http://localhost:8080)
    - [Authorization callback URL](http://localhost:8080/login/oauth2/code/github)
  - Copy & Paste Client Id and Client secret into application.yml

App setup:
- Run App
- Open [Swagger](http://localhost:8080/swagger-ui/index.html)
- Click and Execute [Get Principal name](http://localhost:8080/swagger-ui/index.html?continue#/controller/getUserPrincipal) and copy & paste it into application.yml
- Restart the App
- Click and Execute [Get CSRF Token](http://localhost:8080/swagger-ui/index.html?continue#/controller/getCsrfToken) and copy & keep it
- Click [Get User Info](http://localhost:8080/swagger-ui/index.html?continue#/controller/getUserInfo) and Execute with any user name (for example: denish0w) and CSRF token

Good luck!

[Don’t just disable CSRF every time in your projects!](https://medium.com/@sallu-salman/dont-just-disable-csrf-every-time-in-your-spring-projects-acea1152d0e9)


