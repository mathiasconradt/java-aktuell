# Spring Security 5 OIDC Login Prototype

This work-in-progress prototype example uses Spring Boot 2.1.4 and Spring Security 5 to test and demonstrate OAuth2 Login support.

## Running

Update `application.yml` with values for your domain, client ID, and client secret.

Run the application:

```bash
mvn spring-boot:run
```

Open your browser to [http://localhost:3000](http://localhost:3000).
You will be prompted to login, after which the user information from the ID token of the authenticated user will be displayed.

## Details

- Uses Spring Security 5 OAuth2/OIDC features
- Prototypes proper logout flow
- Uses Authorization Code grant
