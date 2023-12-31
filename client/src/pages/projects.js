import { assignWorker, unassignWorker, getProjects, startProject, finishProject, getQualifications, createProject } from '../services/dataService'
import { getWorkers } from '../services/dataService';
import { Container } from 'reactstrap';
import { useEffect, useRef, useState } from 'react'
import ClickList from '../components/ClickList'
import LocationID from '../utils/location'
import { darkGrayContainerStyle, grayContainerStyle, pageStyle } from '../utils/styles'

const Project = (project, active) => {
    return (
        <div style={pageStyle}>
            <div>{project.name}</div>
            {active === true ? ProjectBody(project) : null}
        </div>
    )
}

const ProjectBody = (project) => {
    return (
        <div style={grayContainerStyle}>
            Name: {project.name}
            <br></br>
            Size: {project.size}
            <br></br>
            Status: {project.status}
            <br></br>
            Assigned Employees: <ClickList list={project.workers} styles={darkGrayContainerStyle} path="/projects" />
            <br></br>
            Required Qualifications: <ClickList list={project.qualifications} styles={darkGrayContainerStyle} path="/projects" />
            <br></br>
            Missing Qualifications: <ClickList list={project.missingQualifications} styles={darkGrayContainerStyle} path="/projects" />

        </div>
    )
}

const Projects = () => {
    const [projects, setProjects] = useState([])
    const [workers, setWorkers] = useState([])
    const inputWorker = useRef("")
    const inputProject = useRef("")
    const inputStartFinishProject = useRef("")

    useEffect(() => { getProjects().then(setProjects) }, [])
    useEffect(() => { getWorkers().then(setWorkers) }, [])
    const active = LocationID('projects', projects, 'name')

    const onButtonClickAssign = async () => {
        const worker = inputWorker.current.value;
        const project = inputProject.current.value;
        const request = {
            worker: worker,
            project: project
        };
        try {
            await assignWorker(request);
            const updatedProjects = await getProjects();
            setProjects(updatedProjects);
            alert(worker + " has been assigned to " + project + "!")
        } catch (error) {
            alert("Failed to assign worker. The worker might not meet the required qualifications, or the Project Status is already ACTIVE or FINISHED.");
        }
    };

    const startProjClick = async () => {
        const name = inputStartFinishProject.current.value;
        const request = {
            name: name,
        };
        try {
            await startProject(request);
            const updatedProjects = await getProjects();
            setProjects(updatedProjects);
            alert(name + " has been started!")
        } catch (error) {
            alert("Failed to start project.");
        }
    }

    const finishProjClick = async () => {
        const name = inputStartFinishProject.current.value;
        const request = {
            name: name,
        };
        try {
            await finishProject(request);
            const updatedProjects = await getProjects();
            setProjects(updatedProjects);
            alert(name + " has been finished!")
        } catch (error) {
            alert("Failed to finish project.");
        }
    }


    const onButtonClickUnassign = async () => {
        const worker = inputWorker.current.value;
        const project = inputProject.current.value;
        const request = {
            worker: worker,
            project: project
        };
        try {
            await unassignWorker(request);
            const updatedProjects = await getProjects();
            setProjects(updatedProjects);
            alert(worker + " has been unassigned from " + project + "!")
        } catch (error) {
            alert("Failed to unassign worker. The worker might not be assigned to the project.");
        }
    };

    const pageStyle = {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
    }
    const selectsContainer = {
        display: 'flex',
        justifyContent: 'center',
    }

    return (
        <Container>
            <div style={pageStyle}>
                <div>
                    <h1>
                        This page displays a table containing all the projects.
                    </h1>
                    <PostProject projets={projects} setProjects={setProjects} />
                    <div style={selectsContainer}>
                        <select ref={inputStartFinishProject}>
                            {projects.map((project) => {
                                return <option>{project.name}</option>;
                            })}
                        </select>
                        <button onClick={startProjClick}>Start Project</button>
                        <button onClick={finishProjClick}>Finish Project</button>
                    </div>
                    <div style={selectsContainer}>
                        <select ref={inputProject}>
                            {projects.map((project) => {
                                return <option>{project.name}</option>;
                            })}
                        </select>
                        <select ref={inputWorker}>
                            {workers.map((worker) => {
                                return <option>{worker.name}</option>;
                            })}
                        </select>
                        <button onClick={onButtonClickAssign}>Assign a Worker</button>
                        <button onClick={onButtonClickUnassign}>Unassign a Worker</button>
                    </div>
                </div>
                <ClickList active={active} list={projects} item={Project} path='/projects' id='name' />
            </div>
        </Container >
    )
}

const PostProject = (props) => {
    const [name, setName] = useState("")
    const [qualifications, setQualifications] = useState([]);
    const [select, setSelect] = useState([]);
    const [size, setSize] = useState("SMALL");
    const selectSize = useRef("")

    useEffect(() => { getQualifications().then(setQualifications) }, [])

    const handleChange = async (e) => {
        let value = Array.from(e.target.selectedOptions, option => option.value);
        setSelect(value);
    }
    const handleClick = async () => {
        const request = {
            name: name,
            size: size,   
            qualifications: select
        };
        try {
            await createProject(request);
            const updatedProjects = await getProjects();
            props.setProjects(updatedProjects);
            alert(name + " has been employed")
        } catch (error) {
            alert("Failed to create project. One of the requirements does not work.");
        }
    }

    const handleSize = async () => {
        setSize(selectSize.current.value)
    }

    return (
        <>
            <label> Name
                <input
                    type="text"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
            </label>
            <label> Qualifications
                <select size="4" onChange={(e) => handleChange(e)} multiple>
                    {qualifications.map((qualification) => {
                        return <option value={qualification.description}>{qualification.description}</option>;
                    })}
                </select>
            </label>
            <label> Size
                <select ref={selectSize} onChange={handleSize}>
                    <option>SMALL</option>
                    <option>MEDIUM</option>
                    <option>BIG</option>
                </select>
            </label>
            <button onClick={handleClick}>Create Project</button>
        </>
    )
}

export default Projects