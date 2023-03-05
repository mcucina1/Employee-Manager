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

#### getQualifications Base Choice
| Test | Oracle |
|------|--------|
|testGetQualSingle()(Base Test) - Single Qualification in Set | Pass |
|testGetQualEmpty() - No Qualification in Set | Pass |
|testGetQualMany() - Multiple Qualifications in Set | Pass |


#### CreateQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Qual String | null | null | null | testNullCreateQualification() |
|  |  | not null | "Qual One" | testCreateQualification() |
|  | Initalized | full string | "Qual One" | testCreateQualification() (BASE CHOICE)|
|  |  | empty | "" | testEmptyStringCreateQualification() |
|  |  | white-space only string  | " " | testWhiteSpaceStringCreateQualification() |

#### CreateQualification Base Choice
 | Test | Oracle |
 |------|--------|
 |testCreateQualification()(Base Choice) - Non-null Qualification Description / Full String Description | Pass |
 |testNullCreateQualification() - Null Description / Null Description | Fail |
 |testEmptyStringCreateQualification() - Non-null Qualification Description / Empty String Description | Fail |
 |testWhiteSpaceStringCreateQualification() - Non-null Qualification Description / Whitespace String Description | Fail |

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
| Set of Projects |  Nullity | Null |  Project set assigned null | Initialized in constructor |
|  |  | Not Null | Returns empty set  | testGetProjectEmpty()|
|  | Emptiness | No Projects | Returns empty set  | testGetProjectEmpty()|
|  |   | One Project |  Returns set w/ project | testGetProjectNotEmpty() (base choice) |
|  |   | Two Projects |  Returns set w/ projects | testGetProjectTwoProjects() |

 #### getProjects Base Choice
| Test | Oracle |
|------|--------|
| testGetProjectNotEmpty()(Base Test) - Non-null Project Set / One Project in set | Pass |
| Impossible State - Null Project Set / One Project in set | Initialized in Constructor |
| testGetProjectEmpty() -  Non-null Project Set / No Projects in set | Pass |
| testGetProjectTwoProjects() - Non-null Project Set / Multiple Projects in set | Pass |

 
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

#### CreateWorker Base Choice
| Test | Oracle |
|------|--------|
|testCreateWorker()(Base Test) - Valid Name / Valid Qualifications / Valid Salary | Pass |
|testNullNameCreateWorker() - Null Name / Valid Qualifications / Valid Salary | Fail |
|testCreateWorkerEmptyName() - Empty String Name / Valid Qualifications / Valid Salary | Fail |
|testCreateWorkerBlankName() - Whitespace Char for Name / Valid Qualifications / Valid Salary | Fail |
|testNullQualsCreateWorker() - Valid Name / Null Qualifications / Valid Salary | Pass |
|testEmptyQualsCreateWorker() - Valid Name / Empty Qualification set / Valid Salary | Pass |
|Impossible State - Valid Name / Valid Qualifications / Null Salary | Pass | 


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

#### Start Base Choice
| Test | Oracle |
|------|--------|
|testPlannedAndSuspendedStart()(Base Test) - Project Status is ACTIVE / Has Required Qualifications | Pass |
|testPlannedAndSuspendedStart() - Project Status is PLANNED / Has Required Qualifications | Pass |
|testMissingQualsStart() - Project Status is ACTIVE / Has Required Qualifications | Pass |
|testMissingQualsStart() - Project Status is ACTIVE / Does not have required qualifications | Fail |

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
| worker | nullity | not null | not null | testAssignBaseWorker() (base choice) |
|  |  | null | null | testAssignNullWorker() |
|  | Workload | Workload less than 12 | 3 | testAssignBaseWorker() (base choice)|
|  |  | Workload 12 | 12 | testAssignTestWorkerAvailibilty() |
|  |  | Will Overload | 16 (attempted) | testAssignWillOverloadWorker() |
|  | Helpfulness | Qualification not in Project | "Bad Qual" | testAssignWorkerNotHelpful() |
|  |  | Qualification in Project | "Good Qual" | testAssignBaseWorker() (base choice)|
| project | nullity | not null | not null | testAssignBaseWorker() (base choice)|
|  |  | null | null | testAssignNullProject() |
|  | Worker In Project | Worker Already in Project | worker in project | testAssignWorkerAlreadyInProject() |
|  |  | Worker not in Project | worker not in project | testAssignBaseWorker() (base choice)|
|  | ProjectStatus | Not allowed ProjectStatus | ProjectStatus.ACTIVE | testAssignProjectStatusActive() |
|  |  | Not allowed ProjectStatus | ProjectStatus.FINISHED | testAssignProjectStatusFinished() |
|  |  | Allowed ProjectStatus | ProjectStatus.PLANNED |  testAssignProjectStatusPlanned() (base choice)|
| | Helpfulness | Qualification not in Project | "Bad Qual" | testAssignWorkerNotHelpful() |
|  |  | Qualification in Project | "Good Qual" | testAssignBaseWorker() (base choice)|
| assigned | nullity | not null | not null | testAssignBaseWorker() (base choice)|
|  |  | null | null | Not allowed by constructor. |
|  | Worker in Pool | Worker In Pool | Worker already in assigned | testAssignWorkerAlreadyInAssigned() |
|  |  | Worker not In Pool | Worker not assinged | testAssignBaseWorker() (base choice)|
| available | nullity | not null | not null | testAssignBaseWorker() (base choice)|
|  |  | null | null | Not allowed by constructor. |
|  | still available | not null | not null | testAssignBaseWorker() (base choice)|
|  | not in available | not null | not null | testAssignWorkerNotInAvailable() |

#### Assign Worker Base Choice
| Test | Oracle |
|------|--------|
|testAssignBaseWorker()(Base Test) - Non-null Worker / Valid Workload / Valid Qualification  | Pass |
|testAssignNullWorker() - Null Worker / Valid Workload / Valid Qualification | Fail |
|testAssignTestWorkerAvailability() - Non-null Worker / Full Workload / Valid Qualification | Pass |
|testAssignWillOverloadWorker() - Non-null Worker / Over Full Workload / Valid Qualification | Fail |
|testAssignWorkerNotHelpful() - Non-null Worker / Valid Workload / Invalid Qualification | Fail |

#### Assign Project Base Choice
| Test | Oracle |
|------|--------|
|testAssignBaseWorker()(Base Test) - Non-null Project / Worker not in project / Status is PLANNED / Valid Qualification | Pass |
|testAssignNullProject() - Null Project / Worker not in project / Status is PLANNED / Valid Qualification | Fail |
|testAssignWorkerAlreadyInProject() - Non-null Project / Worker already in project / Status is PLANNED / Valid Qualification | Fail |
|testAssignProjectStatusActive() - Non-null Project / Worker not in project / Status is ACTIVE / Valid Qualification | Fail |
|testAssignProjectStatusFinished() - Non-null Project / Worker not in project / Status is FINISHED / Valid Qualification | Fail |
|testAssignWorkerNotHelpful() - Non-null Project / Worker not in project / Status is PLANNED / Invalid Qualification | Fail |

#### Assign assigned Base Choice
| Test | Oracle |
|------|--------|
|testAssignBaseWorker()(Base Test) - Non-null Project / Worker not in project / Status is PLANNED / Valid Qualification | Pass |
|Not allowed by constructor - Non-null Project / Null worker in project / Status is PLANNED / Valid Qualification | Impossible State |
|testAssignWorkerAlreadyInAssigned() - Non-null Project / Worker in assigned / Status is PLANNED / Valid Qualification | Pass |

#### Assign Available Base Choice
| Test | Oracle |
|------|--------|
|testAssignBaseWorker()(Base Test) - Non-null Project / Non-null Worker / Status is PLANNED / Valid Qualification | Pass |
|Not allowed by constructor - Non-null Project / Null Worker / Status is PLANNED / Valid Qualification | Impossible State |
|testAssignWorkerNotInAvailable() - Non-null Project / Worker not available / Valid Qualification | Fail |



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
| worker | nullity | not null | not null | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | null | null | testUnassignNullWorker() |
|  | Workload | Workload less than 12 | 6 | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | Workload 12 | 12 | testUnasignNonAvailableWorker() |
|  | isAvailable | is in available set upon project removal | Worker is in available set | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | is not in available set upon project removal | Worker is NOT in available set | testUnasignNonAvailableWorker() |
|  | isAssigned | Worker is assigned to project | Worker is part of project | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | Worker is NOT assigned to project | Worker is NOT part of project | testUnassignWorkerNotAssigned() |
|  | hasProject | Project is in project set | project is in project set | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | Project is NOT in project set | project is NOT in project set | testUnassignProjectNotInWorkerSet() |
| project | nullity | not null | not null | testUnassignBaseWorker() (BASE CHOICE)|
|  |  | null | null | testUnassignNullProject() |
|  | Worker assigned | Worker is Assigned to project | worker assigned to project | testUnassignBaseWorker() (BASE CHOICE)|
|  |   | Worker is NOT Assigned to project | worker NOT assigned to project | testUnassignWorkerNotAssigned() |
|  | Qualifications | Missing Qualifcations | remove worker resulting in missing qualifications | testUnassignMissingQuals() |
|  |  | Proper Qualifcations | remove worker resulting in NO missing qualifications | testUnassignBaseWorker() (BASE CHOICE)|

#### unassign worker Base Choice
| Test | Oracle |
|------|--------|
|testUnassignBaseWorkers()(Base Test) - Non-null Worker / Valid Workload / Available after unassign / Member of Project / Valid Project | Pass |
|testUnassignNullWorker() - Null Worker / Valid Workload / Available after unassign / Member of Project / Valid Project | Fail |
|testUnassignNonAvailableWorker() - Invalid Workload / Available after unassign / Member of Project / Valid Project | Pass |
|testUnassignWorkerNotAssigned() - Valid Workload / Available before unassign / Not member of Project / Valid Project | Fail |
|testUnassignProjectNotInWorkerSet() - Valid Workload / Available after unassign / Member of Project / Invalid Project | Fail |

#### unassign project Base Choice
| Test | Oracle |
|------|--------|
|testUnassignBaseWorkers()(Base Test) - Non-null Worker / Valid Workload / Available after unassign / Member of Project / Valid Project | Pass |
|testUnassignNullProject() - Non-null Worker / Valid Workload / Available after unassign / Member of Project / Null Project | Fail |
|testUnassignWorkerNotAssigned() - Non-null Worker / Valid Workload / Available after unassign / Not member of Project / Valid Project | Fail |
|testUnassignMissingQuals() - Non-null Worker / Valid Workload / Available after unassign / Member of Project / Project missing Qualifications | Pass | 

### finish Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  Project | nullity | null | null | testFinish()|
|  |  |  not null | valid project| testFinish (base choice) |
| | ProjectStatus  | Set to FINISHED  |  project with ACTIVE status | testFinish() (base choice)  |
|   |   |  Not set to FINISHED |  project without ACTIVE status |  testFinish() |
|  Available | Set of available workers | Workers removed from FINISHED project are appropriatly modified in available set | project with ACTIVE status  | testFinish() (base choice)  |
|   |  | Project that is not set to FINISHED does not modify available set | project without ACTIVE status  | testFinish() |
|  Assigned | Set of assigned workers | FINISHED project removes assigned workers | project with ACTIVE status  | testFinish() (base choice)  |
|   | | Project that cannot be set to FINISHED keeps workers assigned | project without ACTIVE status  | testFinish() (base choice)  |