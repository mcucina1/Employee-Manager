# Input Space Partitioning

## Company Class
#### Constructor Method 
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name| null strings  | null  |  null | testCompanyConstructorNullName() |
|   |   | not null  | not null  | testConstructorIsValid() |
|   |  emptiness | empty string  | ""  | testCompanyConstructorEmptyName() |
|   |   | white-space only string  | "         "  | testCompanyConstructorWhiteSpaceName() |
|   |   | full string  | "Test Company"  | testConstructorIsValid() |

#### Equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  | testNullEquals() |
|   |  | not null  | Company("Test Company")  | testEquals() |
|   | Object Type  |  Company | Company("Test Company") | testEquals() |
|   |   |  Non-Worker | String nonCompany = "Company"  | testEquals() |
|   |   |  Equals self | This.Company  | testEquals() |

#### Hashcode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|-----------|-----------------|---------|--------|-----------------|
| Hashcode  | Sameness | hashcode is the same for objects with the same name                  | Project with the same name    ||
|           |          | hash code is different for objects with different names (base choice)| Project with a different name ||