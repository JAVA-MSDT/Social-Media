# Instagram Controller

This project is a **Spring Boot + Thymeleaf** application that allows users to log in to their Instagram accounts and compare their **followers** with the users they are **following**. It provides a feature to **identify** users who are being followed but don't follow back. The application also handles OAuth integration, token storage, and automatic token renewal to enhance usability.

---
## **Purpose**

This app serves as a **Instagram follower and following management tool** that:

1. **Fetches Instagram followers** and **users followed** by the authenticated user.
2. **Compares followers vs. following** to identify **users who are not following back**.
3. **Stores and manages Instagram OAuth tokens** in a database (PostgresSQL) to persist the user login state.
4. Implements **automatic token renewal** every **Based on Configuration** days to avoid token expiration issues.
5. Provides a **UI** using **Thymeleaf** to display the comparison data, including **profile pictures** and **follow/unfollow actions**.

---

## **Libraries & Technologies Used**

1. **Spring Boot**: The core framework for building the RESTful backend.
2. **Thymeleaf**: For rendering dynamic views with HTML templates.
3. **Spring Data JPA**: For storing and retrieving Instagram tokens from a relational database.
4. **Spring Security OAuth2**: For handling the OAuth flow and authenticating users.
5. **Spring Scheduler**: For automatically refreshing the Instagram token before expiration.
6. **PostgreSQL**: Database for storing OAuth tokens and user data.
7. **RestTemplate**: For making HTTP requests to Instagram's API.
8. **HTML/CSS**: For creating a user-friendly web interface.

---

## **Configuration**

### 1. **Database Configuration**
In the `application.yml` file, configure your MySQL/PostgreSQL database connection.

#### Example (PostgresSQL):
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/instagram_db
    username: your_username
    password: your_password
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```
#### Instagram API Credentials:
```yaml
instagram:
client-id: your_instagram_client_id
client-secret: your_instagram_client_secret
redirect-uri: your_redirect_uri
```
## **Workflow**

1. **OAuth Authentication**:
    - Users are redirected to Instagram's OAuth page.
    - After authentication, the app receives an authorization code.
    - The app exchanges the authorization code for an **access token**.

2. **Storing Tokens**:
    - The access token is stored in the **database** along with metadata (e.g., user ID, expiration time).
    - The app uses this token for subsequent API requests to Instagram.

3. **Fetching Followers & Following**:
    - The app uses the stored access token to make requests to the Instagram API and fetch the list of **followers** and **following** for the authenticated user.

4. **Comparison**:
    - The app compares the two lists (followers vs following) and identifies users who are being **followed but don’t follow back**.

5. **UI Display**:
    - The UI displays:
        - The user's Instagram name and profile picture.
        - The list of **followers**, **following**, and **unfollowed users**.
        - **Follow/Unfollow actions**.

6. **Token Renewal**:
    - Every **50 days**, the app automatically refreshes the access token using Instagram’s token refresh API.
    - The new token is stored in the database.

---

## **Features**
1. OAuth Authentication: Authenticate users with Instagram via OAuth2.
2. Instagram Data Fetching: Retrieve followers and following lists.
3. Comparison: Identify users who follow you but you don't follow back.
4. Token Management: Tokens stored in the database with automatic renewal.
5. UI Features:
   - Display followers and following with profile pictures.
   - Option to follow/unfollow users directly through the UI.

## **Future Improvements**
* Error Handling: Add better error handling and logging for failed API calls or token issues.
* Advanced Token Management: Implement more granular control for token expiry and refresh intervals.
* User Notifications: Send notifications to users when someone unfollows them.
* Multiple Account Support: Enable the app to handle multiple Instagram accounts for the same user.
