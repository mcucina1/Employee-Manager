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
| object  | null  | null  | null  |  |
|   |  | not null  | Company("Test Company")  |  |
|   | Object Type  |  Company | Company("This Will Fail)" |  |
|   |   |  Non-Worker | String nonCompany = "Company"  |  |
|   |   |  Equals self | This.Company  |  |