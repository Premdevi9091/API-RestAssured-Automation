# 🚀 Rest Assured Swagger API Automation Framework

![Java](https://img.shields.io/badge/Java-1.8-orange)
![RestAssured](https://img.shields.io/badge/RestAssured-API%20Testing-green)
![TestNG](https://img.shields.io/badge/TestNG-Framework-red)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Log4j2](https://img.shields.io/badge/Log4j2-Logging-yellow)
![ExtentReports](https://img.shields.io/badge/ExtentReports-Reporting-purple)

A **REST API Automation Framework** built using **Java, Rest Assured, TestNG, and Maven** to automate APIs from **Swagger Petstore**.

The framework demonstrates **layered architecture, reusable utilities, data-driven testing, logging, reporting, and CI execution**.

---

# 🧰 Tech Stack

- Java  
- Rest Assured  
- TestNG  
- Maven  
- Log4j2  
- Extent Reports  
- Apache POI (Excel Data Driven Testing)  
- Jenkins (CI Integration)

---

# 📌 APIs Under Test

Swagger Petstore

https://petstore.swagger.io/

Modules Automated

- 👤 User APIs  
- 🏪 Store APIs  

Operations Covered

- Create User  
- Get User  
- Update User  
- Delete User  
- Create Order  
- Get Order  
- Delete Order  

---

# 📂 Project Structure

```
RESTASSURED_SWAGGER_API_FRAMEWORK
│
├── src/test/java
│   ├── api.endpoints/
│   │   ├── UserEndPoints.java
│   │   └── StoreEndPoints.java
│   │
│   ├── api.payload/
│   │   ├── User.java
│   │   └── Store.java
│   │
│   ├── api.test/
│   │   ├── UserTest.java
│   │   ├── StoreTest.java
│   │   └── testUser_DD.java
│   │
│   └── api.utilities/
│       ├── ConfigReader.java
│       ├── DataProviders.java
│       ├── RequestSpecUtil.java
│       ├── ExtentReportManager.java
│       └── XLUtility.java
│
├── src/test/resources
│   ├── routes.properties
│   ├── config-qa.properties
│   └── log4j2.xml
│
├── testData/
│   └── UserData.xlsx
│
├── reports/
├── logs/
├── test-output/
│
├── pom.xml
└── testng.xml
```

---

# ⚙️ Framework Execution Flow

```
TestNG Suite (testng.xml)
        │
        ▼
   Test Classes
(UserTest / StoreTest)
        │
        ▼
   Endpoints Layer
(UserEndPoints / StoreEndPoints)
        │
        ▼
  RequestSpecUtil
        │
        ▼
   Rest Assured
        │
        ▼
 Swagger Petstore API
        │
        ▼
Response Validation
        │
   ┌────┴─────┐
   ▼          ▼
Log4j2     Extent Report
```

---

# 🧪 Sample API Test

```java
@Test
public void testCreateUser() {

    User payload = new User();
    payload.setId(101);
    payload.setUsername("testuser");
    payload.setFirstName("QA");
    payload.setLastName("Automation");

    Response response = UserEndPoints.createUser(payload);

    response.then()
            .statusCode(200)
            .log().all();
}
```

---

# 📊 Data Driven Testing

Test data stored in Excel

```
testData/UserData.xlsx
```

Implemented using

- Apache POI
- TestNG DataProviders
- XLUtility class

---

# 📈 Reporting

Framework generates **Extent HTML Reports**

```
reports/
```

Includes

- Test summary  
- Passed / Failed tests  
- Execution logs  

---

# 📝 Logging

Logging implemented using **Log4j2**

```
src/test/resources/log4j2.xml
```

Logs stored in

```
logs/
```

---

# ▶️ Running Tests

Run using **TestNG**

```
testng.xml
```

Run using **Maven**

```
mvn clean test
```

---

# 🔄 Jenkins Integration

Steps

1. Create Jenkins Job  
2. Connect GitHub Repository  
3. Add Maven build step  
4. Execute

```
mvn clean test
```

---

# ⭐ Key Features

✔ REST API Automation with Rest Assured  
✔ Data Driven Testing using Excel  
✔ TestNG Framework Integration  
✔ Extent HTML Reporting  
✔ Log4j2 Logging  
✔ Maven Build Execution  
✔ Jenkins CI Support  

---

# 👨‍💻 Author

API Automation Framework developed using

**Java + Rest Assured + TestNG + Maven**

Designed to demonstrate **industry-level API automation framework structure**.
