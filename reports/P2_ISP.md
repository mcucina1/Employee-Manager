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

#### Constructor Base Choice
| Test | Oracle |
|------|--------|
|testConstructorIsValid()(Base Test) - Non-null Name / Full String Name| Pass |
|testCompanyConstructorNullName() - Null Name / Null Name | Fail |
|testCompanyConstructorEmptyName() - Non-null Name / Empty String Name | Fail |
|testCompanyConstructorWhiteSpaceName() - Non-null Name / Whitespace Char Name | Fail |

#### Equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  | testNullEquals() |
|   |  | not null  | Company("Test Company")  | testEquals() |
|   | Object Type  |  Company | Company("Test Company") | testEquals() |
|   |   |  Non-Worker | String nonCompany = "Company"  | testEquals() |
|   |   |  Equals self | This.Company  | testEquals() |

#### Equals Base Choice
| Test | Oracle |
|------|--------|
|testEquals()(Base Test) - Non-null Object / Valid type | Pass |
|testEquals() - Non-null Object / Null type | Pass |
|testEquals() - Null Object / Valid type | Pass |
|testNullEquals() - Null Object / Null type | Fail |

#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|Availible| nullity | null     | impossible state           | impossible state |
|         |         | not null | an initalized set          | testToStringBase()|
|         |emptiness| empty    | an empty set               | testToStringEmptyWorkers()|
|         |         | not empty| a set with 1+ workers(base)| testToStringBase()|
|Name     | nullity | null     | impossible state           | impossible state |
|         |         | not null | an initalized string       | testToStringBase()|
|         |emptiness| empty    | impossible state           | impossible state |
|         |         | not empty| a non empty string   (base)| testToStringBase()|
|Projects | nullity | null     | impossible state           | impossible state |
|         |         | not null | an initialized set         | testToStringBase()|
|         |emptiness| empty    | and empty set              |testToStringEmptyProjects()|
|         |         | not empty| a set with 1+ projects(base)| testToStringBase()|

#### toString Base Choice
| Test | Oracle |
|------|--------|
|testToStringBase()(Base Test) - set with 1+ workers / non empty name / set with 1+ projects |Pass|
|testToStringEmptyWorkers() - empty workers set / non empty name / set with 1+ projects | Pass |
|testToStringEmptyProjects() - Set with 1+ workers / non-empty name / empty project set   | Pass |
*impossible states and nullity characteristics are excluded from the base choice table


#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name Element | Null | Null | null | testNullGetName() |
|  |  | Not null | "Company" | testGetName() (base choice) |
|  | Empty | empty | "" | testEmptyGetName() |
|  | Empty | empty | "    " | testWhiteSpaceGetName() |
|  |  | Non-Empty | "Company" | testGetName() |

#### getName Base Choice
 | Test | Oracle |
 |------|--------|
 |testGetName()(Base Test) - Non-null Name / Non-empty Name | Pass |
 |testNullGetName() - Null Name / Null Name | Fail |
 |testEmptyGetName() - Non-null Name / Empty String Name | Fail |
 |testWhiteSpaceGetName() - Non-null Name / White Space Char Name | Fail |

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

#### CreateProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project Name | Nullness | null | null | testCreateProjNameNull() |
|  |  | not null | "Sample Project" | testCreatProjValid() |
|   | Initialized | Full String | "Sample Project" |testCreatProjValid() (Base Choice)|
|   |  | Empty String | "" |testCreatProjNameEmpty()|
|   |  | Empty String | "  " |testCreatProjNameEmptyString()|
| Qualifications | Nullness | null | null | testCreateProjNullQual() |
|  |  | Not Null | Set of existing qualifications |testCreateProjValidQual() (Base Choice) |
| Size | Nullness | null | null | testCreateProjNullSize() |
|   |   |  Not null | "ProjectSize.SMALL"  | testCreatProjValid() |
|   | Valid enum |  Invalid | Other type  | Impossible state |
|   |  |  Valid | "ProjectSize.SMALL"  | testCreatProjValid()  (Base Choice) |

#### CreateProject Base Choice
| Test | Oracle |
|------|--------|
|testCreatProjValid()(base test) - Full String Name / Non-Null Qualifications / Valid enum| Pass |
|testCreateProjNameNull() - Name string is null / Non-Null Qualifications / Valid enum| Fail |
|testCreatProjNameEmpty() - Empty name string / Non-Null Qualifications / Valid enum| Fail |
|testCreateProjValidQual() - Full String Name / Existing set of Qualifications / Vaid enum | Pass|
|testCreateProjNullQual() - Full String Name / Null set of Qualifications / Valid enum| Fail |
|testCreateProjNullSize() - Full String Name / Non-Null Qualifications / Null size enum| Fail |
|Impossible state - Full String Name / Non-Null Qualifications / Other enum type| Impossible state |



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
| Set of Projects |  Emptiness | Null |  Project set assigned null | Initialized in constructor |
|  |  Emptiness | Not Null | Returns empty set  | testGetProjectEmpty()|
|  |  Emptiness | No Projects | Returns empty set  | testGetProjectEmpty()|
|  |  Emptiness | One Project |  Returns set w/ project | testGetProjectNotEmpty() (base choice) |
|  |  Emptiness | Two Projects |  Returns set w/ projects | testGetProjectTwoProjects() |

 #### getProjects Base Choice
| Test | Block   | Oracle |
|------|---------|--------|
| testGetProjectEmpty() |  No Projects |  Returns Empty Set |
| testGetProjectNotEmpty() |  One Project |  Returns Set w/ a project |
 
#### CreateWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name | null  | null  | null  | testNullNameCreateWorker() |
|   |  | not null  | "Test Worker" | testCreateWorker() (Base Choice)|
| | | not null| "" | testCreateWorkerEmptyName()  |
| | | not null|"  " | testCreateWorkerBlankName() |
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
| Test | Oracle |
|------|--------|
|testGetEmployedWorkersBase()(Base Test) - Non-null Employee set / >1 workers| Pass |
|testGetEmployedWorkersOneWorker() - Non-null Employee set / Single worker| Pass |
|testGetEmployedWorkersEmpty() - Non-null Employee set / empty workers | Pass |

 #### Start Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project  | Starting Project  | Make ProjectStatus = Active  | ProjectStatus.ACTIVE  | testPlannedAndSuspendedStart()  (Base Choice) |
|   |   | DON"T make ProjectStatus = Active | ProjectStatus.PLANNED  |  testPlannedAndSuspendedStart()  |
| Company's Set of Qualifications  | Required Qualifications  | Has Required Qualifications  | Company Qualifications is a subset of Project Qualifications  | testMissingQualsStart() (Base Choice) |
|   |   |   | Company Qualifications is NOT a subset of Project Qualifications  | testMissingQualsStart()  |

#### getUnassignedWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| workers | nullity | not null | not null | testGetUnassignedWorkers() (BASE CHOICE) |
|  |  | null | null | Not Allowed By Constructor |
|  | emptiness | empty | empty | testGetUnassignedWorkersEmpty() |
|  |  | not empty | one worker | testGetUnassignedWorkers() (base choice)|
|  |  | not empty | many workers | testGetUnassignedWorkersMany() |

#### getUnassignedWorkers Base Choice
| Test | Oracle |
|------|--------|
| testGetUnassignedWorkers()(Base Test) - Non-null Worker Set / Non-empty Worker Set| Pass |
| Impossible State - Null Worker Set / Non-empty Worker Set | Not Allowed By Constructor |
| testGetUnassignedWorkersEmpty() - Non-null Worker Set / Empty Worker Set | Pass |
| testGetUnassignedWorkersMany() - Non-null Worker Set / More than one worker in set | Pass |

#### getAssignedWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| assigned | nullity | not null | not null | testGetAssignedWorkers() (BASE CHOICE) |
|  |  | null | null | Not Allowed By Constructor |
|  | emptiness | empty | empty | testGetAssignedWorkersEmpty() |
|  |  | not empty | one worker | testGetAssignedWorkers() (base choice)|
|  |  | not empty | many workers | testGetAssignedWorkersMany() |

#### getAssignedWorkers Base Choice
| Test | Oracle |
|------|--------|
| testGetAssignedWorkers()(Base Test) - Non-null Worker Set / One worker in set | Pass |
| testGetAssignedWorkersEmpty() - Non-null Worker Set / No workers in set | Pass |
| Impossible State - Null Worker Set / One worker in set | Not allowed by constructor |
| testGetAssignedWorkersMany() - Non-null Worker Set / Multiple Workers in set | Pass |

#### assign Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker | nullity | not null | not null | assignBaseWorker() (base choice) |
|  |  | null | null | assignNullWorker() |
|  | Workload | Workload less than 12 | 3 | assignBaseWorker() (base choice)|
|  |  | Workload 12 | 12 | assignTestWorkerAvailibilty() |
|  |  | Will Overload | 16 (attempted) | assignWillOverloadWorker() |
|  | Helpfulness | Qualification not in Project | "Bad Qual" | assignWorkerNotHelpful() |
|  |  | Qualification in Project | "Good Qual" | assignBaseWorker() (base choice)|
| project | nullity | not null | not null | assignBaseWorker() (base choice)|
|  |  | null | null | assignNullProject() |
|  | Worker In Project | Worker Already in Project | worker in project | assignWorkerAlreadyInProject() |
|  |  | Worker not in Project | worker not in project | assignBaseWorker() (base choice)|
|  | ProjectStatus | Not allowed ProjectStatus | ProjectStatus.ACTIVE | assignProjectStatusActive() |
|  |  | Not allowed ProjectStatus | ProjectStatus.FINISHED | assignProjectStatusFinished() |
|  |  | Allowed ProjectStatus | ProjectStatus.PLANNED |  assignProjectStatusPlanned() (base choice)|
| | Helpfulness | Qualification not in Project | "Bad Qual" | assignWorkerNotHelpful() |
|  |  | Qualification in Project | "Good Qual" | assignBaseWorker() (base choice)|
| assigned | nullity | not null | not null | assignBaseWorker() (base choice)|
|  |  | null | null | Not allowed by constructor. |
|  | Worker in Pool | Worker In Pool | Worker already in assigned | assignWorkerAlreadyInAssigned() |
|  |  | Worker not In Pool | Worker not assinged | assignBaseWorker() (base choice)|
| available | nullity | not null | not null | assignBaseWorker() (base choice)|
|  |  | null | null | Not allowed by constructor. |
|  | still available | not null | not null | assignBaseWorker() (base choice)|
|  | not in available | not null | not null | assignWorkerNotInAvailable() |

#### Assign Base Choice
| Test | Oracle |
|------|--------|



#### getAvailableWorkers
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|Availible| nullity |null     | impossible state          | impossible state |
|         |         |not null | an initialized set  (base)| testGetAvailableWokersBase()|
|         |emptiness|empty    | empty set                 |testGetAvailableWorkersEmpty()|
|         |         |not empty| set with 1+ workers (base)| testGetAvailableWokersBase()|

#### getAvailableWorkers Base Choice
| Test | Oracle |
|------|--------|
| testGetAvailableWokersBase()(base) - Non-empty Worker set / initialized set | Pass |
| testGetAvailableWorkersEmpty() - Empty Worker set / initialized set | Pass |
*impossible states and nullity characteristics are excluded from the base choice table

#### getUnavailableWorkers
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  Employees | availability  | All employees are available  |  No workers are at workload capacity | testUnavailableWorkers()  |
|   |   | Some employees are available | Some workers are at workload capacity  |  testUnavailableWorkers() (base choice) |
|   |   | No employees are available  | All workers are at workload capacity  | testUnavailableWorkers()  |

#### getUnavailableWorkers Base Choice
 | Test | Oracle |
 |------|--------|
 | testUnavailableWorkers()(Base Test) - Available Workers / Existing Workers at Capacity | Pass |
 | testUnavailableWorkers() - All workers available / No workers at capacity| Pass |
 | testUnavailableWorkers() - No workers available / All workers at capacity | Pass |

#### unassign Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker | nullity | not null | not null | unassignBaseWorker() (BASE CHOICE)|
| worker | nullity | null | null | testUnassignNullWorker() |
| worker | Workload | Workload less than 12 | 6 | unassignBaseWorker() (BASE CHOICE)|
| worker | Workload | Workload 12 | 12 | testUnssignNonAvailableWorker() |
| worker | isAvailable | is in available set upon project removal | Worker is in available set | unassignBaseWorker() (BASE CHOICE)|
| worker | isAvailable | is not in available set upon project removal | Worker is NOT in available set | testUnssignNonAvailableWorker() |
| worker | isAssigned | Worker is assigned to project | Worker is part of project | unassignBaseWorker() (BASE CHOICE)|
| worker | isAssigned | Worker is NOT assigned to project | Worker is NOT part of project | testUnassignWorkerNotAssigned() |
| worker | hasProject | Project is in project set | project is in project set | unassignBaseWorker() (BASE CHOICE)|
| worker | hasProject | Project is NOT in project set | project is NOT in project set | testUnassignProjectNotInWorkerSet() |
| project | nullity | not null | not null | unassignBaseWorker() (BASE CHOICE)|
| project | nullity | null | null | testUnassignNullProject() |
| project | Worker assigned | Worker is Assigned to project | worker assigned to project | unassignBaseWorker() (BASE CHOICE)|
| project | Worker assigned | Worker is NOT Assigned to project | worker NOT assigned to project | testUnassignWorkerNotAssigned() |
| project | Qualifications | Missing Qualifcations | remove worker resulting in missing qualifications | testUnassignMissingQuals() |
| project | Qualifications | Proper Qualifcations | remove worker resulting in NO missing qualifications | unassignBaseWorker() (BASE CHOICE)|