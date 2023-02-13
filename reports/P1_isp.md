# Input Space Partitioning

## Qualification Class
#### Constructor Method 
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description  | null strings  | null  |  null | testQualificationNull() |
|   |   | not null  | not null  | testQualificationConstructor() |
|   |  emptiness | empty string  | ""  | testQualificationEmptyString() |
|   |   | white-space only string  | "         "  | testQualificationWhiteSpaceString() |
|   |   | full string  | "Engineer"  | testQualificationConstructor() |

#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  | testEqualsWithNull() |
|   |  | not null  | Qualification("Engineer")  | testEquals()  |
|   | Object Type  |  Qualification | Qualification(Engineer))  | testEquals()  |
|   |   |  non-Qualification | String nonQual = "Engineer"  |testEqualsNonQual() |
|   |   |  this.Qualification | current Object  | testEqualsWithTheSameObjects()  |

#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Hashcode | Initialized | Non-Null | Qualification.description identical hashcode |  testHashCodeIsDifferentForDifferentObjects() |
| Hashcode | Initialized | Non-Null | Qualification.description different hashcodes|  testHashCodeIsTheSameForIdenticalObjects() |
|  |  | Null | null value |  Description is prevented from being null. See testQualificationNull() |
#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description | Initialized | Non-Null | Qualification w/ description "Engineer" |  testToString() |
|  |  | Null | null value | testQualificationNull() |
|   |   |   |   |   |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Workers |  Emptiness | Empty | Worker set without members | testGetWorkersWithEmptyWorkers() |
|  |  Emptiness | Null |  Worker set assigned null | testGetWorkersWithUnititalizedSet()  |
|  |  Emptiness | Not empty |  Returns set w/ workers | testGetWorkers() |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | Null-ness | Null| Null |   |
|  | Null-ness | Not null | Object of worker type |   |
| Set of Workers | exists | Set already exists  | addWroker() call on existing set | testAddWorker() call on existing set|
|  | exists | Set does not exist  | addWorkers() call without existing set | Impossible state |

#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | null-ness | Null  | Null | testRemoveWorkerWhenGivenNull()  |
|  |  | Not null  | Worker object to remove in existing set | testRemoveWorker() |
|  | Exists | Valid in set  | Worker object to remove existing in set | testRemoveWorker()  |
|  |  | Not in set  | Worker object to not in set | testRemoveWorkerWhenWorkerIsntPresent()|
| Set of Workers | exists | Set already exists  | addWorker() call on existing set | testRemoveWorker() |
|  |  | Set does not exist  | addWorkers() call without existing set |testRemoveWorkerWhenTheSetIsNull()|
|  |   |   |   |   |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  qualDTO Object | Null-ness  | Null          | Null qualDTO         |  returned dto cannot be null. |
|                 |            | Not null      | Valid qualDTO object |  testToDTO() |
| Description     | Initialized| Null          | null                 |  Cannot be null. |
|                 |            | Not null      | a non-null string    |  testToDTO()  |
| Workers         | Initialized| Null          | null                 |  Cannot be null. |
|                 |            | Not null      | a worker set         |  testToDTO()   |
|                 |            | Not empty set | a set with no workers|  testToDTOEmptyWorkers() |
## Worker Class
#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name | Null-ness |  Null | Null string | testNameNonNull()  |
|  |  |  Not null | Valid string |  testConstructor() |
|  | Emptiness | Empty String | "" |  testNameIsEmpty() |
|  |  |  String | "John" | testConstructor()  |
| Qualification Set | Null-ness | Null | Qualification set without contents | testWorkerNullQualificationSet()  |
|   |  |  Not null | Set of qualifications w/ valid contents |  testConstructor() |
| Qualification Set | Emptiness | Set has contents | Set of Qualifications |  testConstructor() |
|   |  |  Set is empty | Qualification set without contents | testEmptyQualificationsConstructor()  |
| Salary | Negatve | Negative value | -1 | testNegativeSalary()  |
|  | Zero | Zero value | 0 | testZeroSalary()  |
|  | Positive | Positive value | 1 | testConstructor()  |


#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  | testEqualsWithNull()  |
|   |  | not null  | Worker("John", testQualifications, 30000.0)  | testEquals()  |
|   | Object Type  |  Worker | Worker("John", testQualifications, 30000.0))  |  testEquals() |
|   |   |  Non-Worker | String nonWorker = "John"  | testEqualsWithNonWorker()  |
|   |   |  Equals self | This.Worker  | testEqualsWithTheSameObject()  |

#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Hashcode | Initialized | Non-Null | Worker identical hashcode |  testHashCodeIsTheSameForIdenticalWorkers()|
| Hashcode | Initialized | Non-Null | Worker different hashcodes|  testHashCodeIsDifferentForDifferentWorkers()|
|  |  | Null | null value |  name is prevented from being null. See testNameNull() |  

#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker Object | Initialized | Non-Null | "Sample Name:0:2:10" | testToString() |
|   |  | Null | null value | testConstructor() |
|   | Formatted | Correct | "John:2:10:30000" | testToString() |
|   |  | Incorrect | Not following schema | testToString() |


#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name Element | Null |  Null  | null | testNameNull() |
|  |  |  Not null  |  "Sample Name" | testGetName() |
|   |   |   |   |   |

#### getSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Salary Element | Null | Null | null | impossible state |
|  |  | Not null | 30000.0 | testGetSalary() |
|   | Zero | > 0 | 10.0 | testGetSalary() |
|   |  | == 0 | 0 | testGetSalaryZero() |
|   |  | < 0 | -1 | testNegativeSalary() |

#### setSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Salary Element | Non-negative | > 0 | 123  | testSetSalary() |
|  |  | == 0 | 0 | testSetSalaryZero() |
|  |  | < 0 | -1  | testSetSalaryNegative() |
| Type Conversions | Validity |  Valid non-double | 30000  | testSetSalaryNonDouble() |
|  |  | Invalid | "30000" | Impossible state |

#### getQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| qualifications  | nullity  | null  |  null  | testWorkerNullQualificationSet() |
|   |   |  not null | non-empty Set of qualifications | testGetQualifications() |
|   | emptiness  |  empty set | empty Set of qualifications  | testGetEmptyQualifications() |
|   |   |  Set with qualifications | Set with qualifications  | testGetQualifications() |

#### addQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| qualification  | nullity  | null  |  null  | testAddQualAddingNull()  |
|   |   |  not null | instantiated qualification | testAddQualification()  |
| qualifications  | nullity  | null  |  null  | Qualifications cannot be null. See testWorkerNullQualificationSet()  |
|   |   |  not null | non-empty Set of qualifications | testAddQualification()  |
|   | emptiness  |  empty set | empty Set of qualifications  | testAddQualToAnEmptySet() |
|   | emptiness  |  Set with qualifications | Set with qualifications  |  testAddQualification() |

#### getProjects Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Projects |  Emptiness | Empty | Worker with empty Project set | testGetProjectEmpty() |
 |  |  Emptiness | Null |  Project set assigned null | Impossible state, initialized in constructor |
 |  |  Emptiness | Not empty |  Returns set w/ projects | testGetProjectNotEmpty() |
|   |   |   |   |   |

#### addProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project | Null-ness | Null| Null | testAddNullProject()  |
|  | Null-ness | Not null | Object of project type | testAddProject()  |
| Set of Workers | exists | Set already exists  | addProject() call on existing set | testAddProject()  |
|  | exists | Set does not exist  | addProject() call without existing set |  testAddToUninitializedProjects() |

#### removeProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project | null-ness | Null  | Null |  testRemoveProjectNullProject() |
|  | null-ness | Not null  | Project object to remove existing in set |  testRemoveProject() |
|  | Exists | Valid in set  | Project object to remove existing in set | testRemoveProject()  |
|  | Exists | Not in set  | Project object to not in set | testRemoveProjectElementNotInSet()  |
| Set of Projects | exists | Set already exists and is empty| removeProject() call on existing set |  testRemoveProjectFromEmptySet() |
| Set of Projects | exists | Set already exists  and is full| removeProject() call on existing set |  testRemoveProject() |
|  | exists | Set does not exist  | removeProject() call without existing set | Constructor prevents this. See testConstructor()  |

#### getWorkload Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  workload | null-ness  | null  | null  |   |
|   |   | not null  |   |   |
|   | ProjectSize  | ALL BIG  | ALL BIG  |   |
|   |   | ALL MEDIUM  | ALL MEDIUM   |   |
|   |   | ALL SMALL  | ALL SMALL  |   |
|   |   | MIXED Project Sizes | BIG, MEDIUM, SMALL  |   |
|   |   | MIXED Project Sizes | BIG, BIG, SMALL  |   |
|   |   | MIXED Project Sizes | BIG, BIG, MEDIUM  |   |
|   |   | MIXED Project Sizes | BIG, MEDIUM, MEDIUM  |   |
|   |   | MIXED Project Sizes | SMALL, MEDIUM, MEDIUM  |   |
|   |   | MIXED Project Sizes | SMALL, SMALL, BIG  |   |
|   |   | MIXED Project Sizes | SMALL, SMALL, MEDIUM  |   |

#### willOverload Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project | Null-ness | Null| Null | testAddNullProject()  |
|  | Null-ness | Not null | Object of project type | testWillOverload() |
|  |  Already Assigned Project | Assigned Project | Project Object already in current project set | testWillOverload() |
|  |  Project that Will overload | Overloading Project  | A Project that will overload the Worker  | testWillOverload() |
|  |  Project that will NOT overload | Non-Overloading Project  | A Project that will NOT overload the Worker  | testWillOverload() |

#### isAvailable Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Workload | null-ness | null |  | Impossible State |
|   |   | not null | Any Workload  | testIsAvailable() |
|   | Total Workload | No Workload | Empty Project Set | testIsAvailable() |
|   |   | Workload > 0 & < 12  | Project Set with Workload of value 1-11 | testIsAvailable() |
|   |   | Workload > 12  | Project Set with Workload >= 12 | testIsAvailable() |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  WorkerDTO Object | Null-ness | Null | Null WorkerDTO | testNullDTO() |
|  |  | Not null | Valid WorkerDTO object | testToDTO() |
| Qualifications | Initialized | Null |   | testNullQualToDTO() |
|  |  | Not null |   | testToDTO  |
|  |  | Not empty set |   | testToDTO() |
| Projects | Initialized | Null |   | Impossible State |
|  |  | Not null |   | testToDTO() |
|  |  | Not empty set |   | testToDTO() |


## Project Class

#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  name |  null | null  | null | testProjectConstructorNullName() |
|   |   | not null  | Project(testProjectName, testQualifications, ProjectSize.SMALL);  | setUp()  |
|   |  emptiness | empty string  | ""  |  testProjectConstructorEmptyName() |
|   |   | white-space only string  | " "  | testProjectConstructorWhiteSpaceName()  |
|   |   | full string  | "Test Project"  | setUp()  |
|  qualifications | null  | null  | null  | testProjectConstructorQualNull()  |
|   |   | not null  | Project(testProjectName, testQualifications, ProjectSize.SMALL);  |  setUp() |
|   | emptiness  | empty set  |  Empty HashSet |  testProjectConstructorQualEmpty() |
|   |   | filled set  | non empty HashSet  | setUp()  |
|  size | null  | null  |  null | testProjectConstructorSizeNull()  |
|   |   | not null  |  Valid ProjectSize | setUp()  |
|  status | null  | null  |  null | not allowed by constructor, inistatiated to ProjectStatus.PLANNED, see testGetStatus()  |
|   |   | not null  | must be status.PLANNED  |  not allowed by constructor, inistatiated to ProjectStatus.PLANNED, see testGetStatus() |
#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| o  | null  | null  | null  | testEqualsNull()  |
|   |  | not null  | not null  | testEquals()  |
|   | Object  |  Project | Project Object  | testEquals()  |
|   |   |  non-Project | String Object  |  testEqualsNull() |
|   |   |  this.Project | current Object  |  testEqualsSelf() |

#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Hashcode | Sameness    | The hashcode is the same for objects with the same name    | Project with the same name   | testHashcodeWithIdenticalProjects()  |
|          |             | The hashcode is different for objects with different names | Project with a different name| testHashCodeWithDifferentProjects()  |



#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name  | Nullity   | null           | null               | Name cannot be null   |
|       |           | not null       | string             | testToString() |
|       | Emptiness | empty          | empty string       | Name cannot be empty  |
|       |           | not empty      | not empty string   | testToString()  |
|Workers| Emptiness | empty set      | empty set          | testToStringEmptyWorkers() |
|       |           | not empty set  | set with 1+ workers| testToString()  |
|       | Nullity   | null           | null               | workers cannot be null  |
|       |           | not null       | not null           | testToString()  |
| Status| Nullity   | null           | null               | status cannot be null  |
|       |           | not null       | not null           | testToString() |

#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name Element | Null | Null | null | testNullGetName() |
|  |  | Not null | "Test Project" | testGetName() |
|  | Empty | "" | testEmptyGetName() |
|  |  | Non-Empty | "Test Project" | testGetName() |

#### getSize Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| ProjectSize  | Nullity  |  not null  | SMALL  |  testGetSize() |
|              |          |            |  null  | size cannot be null  |


#### setSize Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| ProjectSize  | Nullity  | not null  | SMALL  | testSetSize()  |
|              |          | null      |  null  | testSetSizeNull()  |


#### getStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  ProjectStatus | Valid  | Return Status  |  status|   |

#### setStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| status | null  | null  | null  | testSetStatusNull()  |
|   |  not null | ProjectStatus  | ProjectStatus.ACTIVE  |  testSetAndGetStatus() |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker  | null  | null  | no value  |  testAddWorkerNullValue() |
|   |   |  not null | valid worker  |  testAddWorker() |
|  Set of workers | null  |  null | no initilized worker set  |  Cannot be null, see testSetOfWorkersNull() |
|   |   |  not null | initialized worker set  |  testAddWorker() |
|   | adds worker  |  add worker | worker  | testAddWorker()  |

#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | null-ness | Null  | Null |  testRemoveWorkerNullValue() |
|  | null-ness | Not null  | Worker object to remove existing in set | testRemoveWorker()  |
|  | Exists | Valid in set  | Worker object to remove existing in set | testRemoveWorker()  |
|  | Exists | Not in set  | Worker object to not in set | testRemoveWorkerNotInSet()  |
| Set of Workers | exists | Set already exists  | removeWorker() call on existing set |  testRemoveWorkers() |
|  | exists | Set does not exist  | removeWorker() call without existing set | not allowed by Constructor (set initliazed on construction)  |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Workers |  Emptiness | Empty | Worker set without members |   |
|  |  Emptiness | Null |  Worker set assigned null |  workers cannot be null. |
|  |  Emptiness | Not empty |  Returns set w/ workers | testGetWorkers()  |
|   |   |   |   |   |

#### removeAllWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  workers |  nullity   |  null     |  null | testRemoveAllNullWorkers()  |
|          |            | not null  |  an initialized workers set |  testRemoveAll() |
|          | emptiness  | empty     | an empty workers set   | testRemoveAllWorkersFromEmptyWorkers()  |
|          |            | not empty | a workers set with at least 1 worker  |  testRemoveAll() |

#### getRequiredQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Qualifications | Nullity  | Null      | Null  |   |
|                |          | Not null  | initialized qualificaitons      |   |

#### addQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  qualification | nullity | null    | null                         |   |
|                |         | not null| an initialized qualificaiton |   |
|                |presence in qualifications|not in qualifications|a qualification that isn't in qualifications|   |
|                |                          |already qualifications|a qualification that is in qualificaiton|   |
| qualifications | nullity  | null   | null  |   |
|                |          |not null|an initialized qualifications set|   |

#### getMissingQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Workers      |Nullity  |Null     |Null                |   |
|              |         |Not Null |Initialized Workers |   |
|              |Emptiness|Empty    |Empty set           |   |
|              |         |1 worker |set with 1 worker |   |
|              |         |>1 worker|set with 3 workers|   |
|Qualifications|Nullity  |Null     |Null                |   |
|              |         |Not Null |Initialized quals   |   |
|              |Emptiness|Empty    |Empty set           |   |
|              |         |1 qual   |set with 1 qual|   |
|              |         |>1 qual  |set with 3 quals   |   |
#### isHelpful Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker  | nullity  | null      | null                   | testNullIsHelpful() |
|         |          | not null  | an initialized worker  | testIsHelpful() |
|  |  |  |  |  |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  projectDTO Object | Nullity | Null     | Null projectDTO |   |
|                    |           | Not null | Valid projectDTO object |  |
| Qualificaitons | Nullity     | Null     | Null  |   |
|                |             | Not null | initialized qualifictaions |   |
|              |Emptiness|Empty    |Empty set           |   |
|              |         |1 qual   |set with 1 qual|   |
|              |         |>1 qual  |set with 3 quals   |   |
| Workers | Nullity     | Null     | Null             |   |
|         |             | Not null |initalized workers|   |
|         |  Emptiness  |  empty   |empty set         |   |
|         |             |1 worker  |set with 1 worker |   |
|         |             |>1 worker |set with 3 workers|   |
