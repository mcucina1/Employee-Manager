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
|  qualDTO Object | Null-ness | Null | Null qualDTO |   |
|  |  | Not null | Valid qualDTO object |  |
| Description | Initialized | Null |  |   |
|  |  | Not null |  |   |
| Workers | Initialized | Null |   |   |
|  |  | Not null |   |   |
|  |  | Not empty set |   |   |
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
| Hashcode | Initialized | Non-Null | Worker.name hashcode |   |
|  |  | Null | null value |   

#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker Object | Initialized | Non-Null | Worker w/ Name "John", Set of Qualifications, and Salary 30000.0 |   |
|   |  | Null | null value |   |
|   | Formatted | Correct | "John:2:10:30000" |   |
|   |  | Incorrect | Not following schema |   |


#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name Element | Null |  Null  | null |   |
|  |  |  Not null  |  "John" |   |
|   |   |   |   |   |

#### getSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Salary Element | Null | Null | null |   |
|  |  | Not null | 30000.0 |   |
|   |   |   |   |   |

#### setSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Type Conversions | Validity |  Valid | 30000  |   |
|  |  | Invalid | "30000" |   |

#### getQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| qualifications  | nullity  | null  |  null  |   |
|   |   |  not null | non-empty Set of qualifications |   |
|   | emptiness  |  empty set | empty Set of qualifications  |   |
|   | emptiness  |  Set with qualifications | Set with qualifications  |   |

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
| Set of Projects |  Emptiness | Empty | Project set without members |   |
|  |  Emptiness | Null |  Project set assigned null |   |
|  |  Emptiness | Not empty |  Returns set w/ projects |   |
|   |   |   |   |   |

#### addProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project | Null-ness | Null| Null |   |
|  | Null-ness | Not null | Object of project type |   |
| Set of Workers | exists | Set already exists  | addProject() call on existing set |   |
|  | exists | Set does not exist  | addProject() call without existing set |   |

#### removeProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Project | null-ness | Null  | Null |   |
|  | null-ness | Not null  | Project object to remove existing in set |   |
|  | Exists | Valid in set  | Project object to remove existing in set |   |
|  | Exists | Not in set  | Project object to not in set |   |
| Set of Projects | exists | Set already exists  | addProject() call on existing set |   |
|  | exists | Set does not exist  | addProject() call without existing set |   |

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
|   |   |   |   |   |
|   |   |   |   |   |

#### isAvailable Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |


## Project Class

#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  name |  null | null  |   |   |
|   |   | not null  |   |   |
|   |  emptiness | empty string  | ""  |   |
|   |   | white-space only string  | " "  |   |
|   |   | full string  | "Project 1"  |   |
|  qualifications | null  | null  |   |   |
|   |   | not null  |   |   |
|   | emptiness  | empty set  |   |   |
|   |   | filled set  |   |   |
|  size | null  | null  |  null |   |
|   |   | not null  |  Valid ProjectSize |   |
|  status | null  | null  |  null |   |
|   |   | not null  | must be status.PLANNED  |   |
#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| o  | null  | null  | null  |   |
|   |  | not null  | not null  |   |
|   | Object  |  Project | Project Object  |   |
|   |   |  non-Project | String Object  |   |
|   |   |  this.Project | current Object  |   |

#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getName Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getSize Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| ProjectSize  | Valid  |  Return size  | size  |   |
|   |   |   |   |   |


#### setSize Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| ProjectSize  | Valid  | Set Size  | SMALL  |   |
|   |   |   |   |   |


#### getStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  ProjectStatus | Valid  | Return Status  |  status|   |

#### setStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| status  | null  | null  | null  |   |
|   |  not null | ProjectStatus  | ProjectStatus.ACTIVE  |   |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker  | null  | null  | no value  |   |
|   |   |  not null | valid worker  |   |
|  Set of workers | null  |  null | no initilized worker set  |   |
|   |   |  not null | initialized worker set  |   |
|   | adds worker  |  add worker | worker  |   |

#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | null-ness | Null  | Null |   |
|  | null-ness | Not null  | Worker object to remove existing in set |   |
|  | Exists | Valid in set  | Worker object to remove existing in set |   |
|  | Exists | Not in set  | Worker object to not in set |   |
| Set of Workers | exists | Set already exists  | addWorker() call on existing set |   |
|  | exists | Set does not exist  | addWorkers() call without existing set |   |
|  |   |   |   |   |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Workers |  Emptiness | Empty | Worker set without members |   |
|  |  Emptiness | Null |  Worker set assigned null |   |
|  |  Emptiness | Not empty |  Returns set w/ workers |   |
|   |   |   |   |   |

#### removeAllWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  workers |  nullity   |  null     |  null |   |
|          |            | not null  |  an initialized workers set |   |
|          | emptiness  | empty     | an empty workers set   |   |
|          |            | not empty | a workers set with at least 1 worker  |   |

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
| Worker  | nullity  | null      | null                   |   |
|         |          | not null  | an initialized worker  |   |

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
