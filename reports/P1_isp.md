# Input Space Partitioning

## Qualification Class
#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description  | null strings  | null  |  null |   |
|   |   | not null  | not null  |   |
|   |  emptiness | empty string  | ""  |   |
|   |   | white-space only string  | " "  |   |
|   |   | full string  | "Engineer"  |   |

#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| object  | null  | null  | null  |   |
|   |  | not null  | not null  |   |
|   | Object Type  |  Qualification | Qualification Object  |   |
|   |   |  non-Qualification | String Object  |   |
|   |   |  this.Qualification | current Object  |   |
#### hashCode Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Hashcode | Initialized | Non-Null | Description string |   |
|  | Initialized | Null | null value |   |
#### toString Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Description | Initialized | Non-Null | Description value |   |
|  | Initialized | Null | null value |   |
|   |   |   |   |   |

#### getWorkers Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Set of Workers |  Emptiness | Empty | Worker set without members |   |
|  |  Emptiness | Null |  Worker set assigned null |   |
|  |  Emptiness | Not empty |  Returns set w/ workers |   |
|   |   |   |   |   |

#### addWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | Null-ness | Null| Null |   |
|  | Null-ness | Not null | Object of worker type |   |
| Set of Workers | exists | Set already exists  | addWroker() call on existing set |   |
|  | exists | Set does not exist  | addWorkers() call without existing set |   |
|   |  |   |   |   |
#### removeWorker Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Worker | null-ness | Null  | Null |   |
|  | null-ness | Not null  | Worker object to remove existing in set |   |
|  | Exists | Valid in set  | Worker object to remove existing in set |   |
|  | Exists | Not in set  | Worker object to not in set |   |
| Set of Workers | exists | Set already exists  | addWroker() call on existing set |   |
|  | exists | Set does not exist  | addWorkers() call without existing set |   |
|  |   |   |   |   |

#### toDTO Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|  qualDTO Object | Null-ness | Null | Null qualDTO |   |
|  | Null-ness | Not null | Valid qualDTO object |  |
| Description | Initialized | Null |   |   |
| Description | Initialized | Not null |  |   |
| Workers | Initialized | Null |   |   |
| Workers | Initialized | Not null |   |   |
| Workers | Initialized | Not empty set |   |   |
## Worker Class
#### Constructor Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
| Name | Null-ness |  Null | Null string |   |
| Name | Null-ness |  Not null | Valid string |   |
|  | Emptiness | Empty String | "" |   |
|  | Emptiness |  String | Non-empty string |   |
| Qualification Set | Emptiness | Set has contents | Set of Qualifications |   |
|   | Emptiness |  Set is empty | Qualification set without contents |   |
| Salary | Negatve | Negative value | Negative number |   |


#### equals Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

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

#### getSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

#### setSalary Method
| Variable  | Characteristic  | Blocks  | Values | JUnit Test Name |
|---|---|---|---|---|
|   |   |   |   |   |
|   |   |   |   |   |

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
| qualification  | nullity  | null  |  null  |   |
|   |   |  not null | instantiated qualification |   |
| qualifications  | nullity  | null  |  null  |   |
|   |   |  not null | non-empty Set of qualifications |   |
|   | emptiness  |  empty set | empty Set of qualifications  |   |
|   | emptiness  |  Set with qualifications | Set with qualifications  |   |

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
