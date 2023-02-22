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


#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name Element | Null | Null | null | testNullGetName() |
|  |  | Not null | "Company" | testGetName() (base choice) |
|  | Empty | empty | "" | testEmptyGetName() |
|  | Empty | empty | "    " | testWhiteSpaceGetName() |
|  |  | Non-Empty | "Company" | testGetName() |

#### getQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   | Empty | Empty | Empty qualification set | testGetQualEmpty() |
|   |   | Single qualification | Qualification set w/ one element | testGetQualSingle() (Base choice) |
|   |   | Many qualifications | Qualification set w/ two elements | testGetQualMany() |

#### CreateQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Qual String | null | null | null | testNullCreateQualification() |
|  |  | not null | "Qual One" | testCreateQualification() |
|  | Initalized | full string | "Qual One" | testCreateQualification() (BASE CASE)|
|  |  | empty | "" | testEmptyStringCreateQualification() |
|  |  | white-space only string  | " " | testWhiteSpaceStringCreateQualification() |

#### Hashcode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|-----------|-----------------|---------|--------|-----------------|
| Hashcode  | Sameness | hashcode is the same for objects with the same name                  | Project with the same name    | testHashcodeDifferentforDifferentNames()|
|           |          | hash code is different for objects with different names (base choice)| Project with a different name |testHashcodeDifferentforDifferentNames()|

#### Hashcode Base Choice
| Test | Block   | Oracle |
|------|---------|--------|
|testHashcodeDifferentforDifferentNames() (Base Test)| hashcode is different     | returns a hashcode |
|testHashcodeSameForIdenticalNames()                 | hashcode is the same      | returns a hashcode |


#### getProjects Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Projects |  Emptiness | Empty | Worker with empty Project set | testGetProjectEmpty() NOT IMPLEMENTED |
 |  |  Emptiness | Null |  Project set assigned null | Initialized in constructor |
 |  |  Emptiness | Not empty |  Returns set w/ projects | testGetProjectNotEmpty() (base choice) |
 
#### CreateWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name | null  | null  | null  | testNullNameCreateWorker() |
|   |  | not null  | "Test Worker" | testCreateWorker() (Base Choice)|
| Qualifications | null | null | null | testNullQualsCreateWorker() |
|  |  | not null | {"Qual One"} | testCreateWorker() |
|  | isEmpty | empty | {} | testEmptyQualsCreateWorker() |
|  |  | non-empty | {Qual One} | testCreateWorker() |
|  |  | Not In Company Set | {Qual Two} | testNonCompanyQualCreateWorker() |
| Salary | null | null | null | Impossible State |
|  |  | not null | 10.0 | testCreateWorker() |


#### getEmployedWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| employees | nullity  | null                    | impossible state |
|           |          | not null   (base choice)| testGetEmployedWorkersBase() |
|           | emptiness| empty                   | testGetEmployedWorkersEmpty()|
|           |          | 1 worker                | testGetEmployedWorkersOneWorker()|
|           |          | 1+ workers (base choice)| testGetEmployedWorkersBase() |

#### getEmployedWorkers Base Choice
| Test | Block   | Oracle |
|------|---------|--------|
|testGetEmployedWorkersBase()  (Base Test)  | not null, 1+ workers | return set of size 1+|
|testGetEmployedWorkersOneWorker()          | not null, 1 workers  | return set of size 1 |
|testGetEmployedWorkersEmpty()              | not null, empty      | return set of size 0 |

 #### Start Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project  | Starting Project  | Make ProjectStatus = Active  | ProjectStatus.ACTIVE  | testPlannedAndSuspendedStart()  (Base Choice) |
|   |   | DON"T make ProjectStatus = Active | ProjectStatus.PLANNED  |  testPlannedAndSuspendedStart()  |
| Company's Set of Qualifications  | Required Qualifications  | Has Required Qualifications  | Company Qualifications is a subset of Project Qualifications  | testMissingQualsStart() (Base Choice) |
|   |   |   | Company Qualifications is NOT a subset of Project Qualifications  | testMissingQualsStart()  |