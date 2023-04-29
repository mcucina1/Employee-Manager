import { assignWorker, unassignWorker, getProjects } from '../services/dataService'
import { getWorkers } from '../services/dataService';
import { Container} from 'reactstrap';
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
                    <ClickList active={active} list={projects} item={Project} path='/projects' id='name' />
                </div>
                
            </div>
        </Container>
    )
}


export default Projects