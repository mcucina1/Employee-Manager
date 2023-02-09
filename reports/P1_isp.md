# Input Space Partitioning

## Qualification Class
#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description  | null strings  | null  |  null |   |
|   |   | not null  | "Engineer"  |   |
|   |  emptiness | empty string  | ""  |   |
|   |   | white-space only string  | " "  |   |
|   |   | full string  | "Engineer"  |   |

#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  |   |
|   |  | not null  | Qualification("Engineer")  |   |
|   | Object Type  |  Qualification | Qualification(Engineer))  |   |
|   |   |  non-Qualification | String nonQual = "Engineer"  |   |
|   |   |  this.Qualification | current Object  |   |
#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Hashcode | Initialized | Non-Null | Qualification.description hashcode |   |
|  |  | Null | null value |   |
#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description | Initialized | Non-Null | Qualification w/ description "Engineer" |   |
|  |  | Null | null value |   |
|   |   |   |   |   |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Workers |  Emptiness | Empty | Worker set without members |   |
|  |   | Null |  Worker set assigned null |   |
|  |   | Not empty |  Returns set w/ workers |   |
|   |   |   |   |   |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | Null-ness | Null| Null |   |
|  |  | Not null | Object of worker type |   |
| Set of Workers | exists | Set already exists  | addWroker() call on existing set |   |
|  |  | Set does not exist  | addWorkers() call without existing set |   |
|   |  |   |   |   |
#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | null-ness | Null  | Null |   |
|  |  | Not null  | Worker object to remove in existing set |   |
|  | Exists | Valid in set  | Worker object to remove existing in set |   |
|  |  | Not in set  | Worker object to not in set |   |
| Set of Workers | exists | Set already exists  | addWroker() call on existing set |   |
|  |  | Set does not exist  | addWorkers() call without existing set |   |
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
| Name | Null-ness |  Null | Null string |   |
|  |  |  Not null | Valid string |   |
|  | Emptiness | Empty String | "" |   |
|  |  |  String | "John" |   |
| Qualification Set | Null-ness | Null | Set of qualifications w/ valid contents |   |
|   |  |  Not null | Qualification set without contents |   |
| Qualification Set | Emptiness | Set has contents | Set of Qualifications |   |
|   |  |  Set is empty | Qualification set without contents |   |
| Salary | Negatve | Negative value | -1 |   |


#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  |   |
|   |  | not null  | Worker("John", testQualifications, 30000.0)  |   |
|   | Object Type  |  Worker | Worker("John", testQualifications, 30000.0))  |   |
|   |   |  Non-Worker | String nonWorker = "John"  |   |
|   |   |  Equals self | This.Worker  |   |

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
| Type Conversions | valid |  Int | 30000  |   |
|  | invalid | String | "30000" |   |

#### getQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### addQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getProjects Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### addProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### removeProject Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getWorkload Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

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
|   |   |   |   |   |
|   |   |   |   |   |

#### setSize Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### setStatus Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| status  | null  | null  | null  |   |
|   |  not null | ProjectStatus  | ProjectStatus.ACTIVE  |   |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker  |   |   |   |   |
|   |   |   |   |   |

#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| worker  |   |   |   |   |
|   |   |   |   |   |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### removeAllWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getRequiredQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### addQualification Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### getMissingQualifications Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### isHelpful Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |
