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
│
│   ├── api.endpoints/
│   │   ├── UserEndPoints.java        → CRUD API methods for User module
│   │   └── StoreEndPoints.java       → API methods for Store order module
│   │
│   ├── api.payload/
│   │   ├── User.java                 → POJO class for User request payload
│   │   └── Store.java                → POJO class for Store order payload
│   │
│   ├── api.test/
│   │   ├── UserTest.java             → Test cases for User APIs
│   │   ├── StoreTest.java            → Test cases for Store APIs
│   │   └── testUser_DD.java          → Data Driven Tests using Excel
│   │
│   └── api.utilities/
│       ├── ConfigReader.java         → Reads configuration properties
│       ├── DataProviders.java        → TestNG DataProviders
│       ├── ExtentReportManager.java  → Generates Extent HTML reports
│       ├── RequestSpecUtil.java      → Reusable RestAssured request specifications
│       └── XLUtility.java            → Excel utilities using Apache POI
│
├── src/test/resources/
│   ├── schemas/                      → JSON schema validation files
│   ├── config-qa.properties          → Environment configuration
│   ├── routes.properties             → API endpoint URLs
│   └── log4j2.xml                    → Logging configuration
│
├── testData/
│   └── UserData.xlsx                 → Excel test data for Data Driven Testing
│
├── reports/                          → Generated Extent Reports
├── logs/                             → Log4j2 execution logs
├── test-output/                      → TestNG reports
│
├── pom.xml                           → Maven dependencies
└── testng.xml                        → TestNG suite configuration
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

Example TestNG test using **DataProvider + RestAssured + POJO payload**

```java
@Test(dataProvider = "Data", dataProviderClass = DataProviders.class)
public void testPostUser(String userID, String userName, String fname,
                         String lname, String email, String pwd, String phone) {

    User userPayload = new User();

    userPayload.setId(Integer.parseInt(userID));
    userPayload.setUsername(userName);
    userPayload.setFirstName(fname);
    userPayload.setLastName(lname);
    userPayload.setEmail(email);
    userPayload.setPassword(pwd);
    userPayload.setPhone(phone);

    Response response = UserEndPoints.createUser(userPayload);

    response.then().log().body();

    Assert.assertEquals(response.getStatusCode(), 200);
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

Premdevi Kumawat
QA Engineer
