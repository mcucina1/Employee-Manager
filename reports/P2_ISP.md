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

#### CreateQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Qual String | null | null | null | testNullCreateQualification() |
|  |  | not null | "Qual One" | testCreateQualification() |
|  | Initalized | full string | "Qual One" | testCreateQualification() |
|  |  | empty | "" | testEmptyStringCreateQualification() |
|  |  | white-space only string  | " " | testWhiteSpaceStringCreateQualification() |