# dummy-demo-test
OrientDB 3.1.0 test case

Make sure to use 3.1.0 server version and use a **single setup**

Steps to reproduce:
1. Create  BD MAPP
2. Create APP vertex class with attributes:
    1. ID (string)
    2. LID(string)
3. Create KEYDOK vertex class with attributes:
    1. ID (string)
    2. LID (string)
    3. current (boolean)
    4. insertedOn (datetime)
    5. version (integer)
4. CREATE UNDER  edge class with attributes:
    1. insertedOn (datetime)
    2. isActive (boolean)
    3. isCurrent (boolean)
    4. versioning (integer)
    5. since (datetime)
5. CREATE HAS_AS_FAVORITE  edge class with attributes:
    1. insertedOn (datetime)
    2. isActive (boolean)
    3. isCurrent (boolean)
    4. versioning (integer)
    5. since (datetime)
6. On OrientDB Studio go to O GRAPH tab
7. Add new vertex of class APP
    1. ID = APP1-ID
    2. LID = APP1
8. Add new vertex of class APP
    1. ID = APP2-ID
    2. LID = APP2
9. Add new vertex of class APP
    1. ID = APP3-ID
    2. LID = APP3
10. Add new edge of class UNDER from APP1 tp APP2 with attributes:
    1. isCurrent = true
    2. isActive = true
    3. versioning = 1
    4. insertedOn = currentDate
    5. since = currentDate
11. Clone repository with contains the project: [https://github.com/CanonTino/dummy-demo-test.git](https://github.com/CanonTino/dummy-demo-test.git)
12. Execute test case orient.test.OrientDB310Test.createEdgeFromANewVertexTpAnExistingOne() which should fail. If you change String targetAppId = "APP1"; for String targetAppId = "APP3"; test will pass

**Example GRAPH**
![image](https://user-images.githubusercontent.com/24844797/86292093-b3e7a980-bbb5-11ea-8634-b58c31060ab3.png)
