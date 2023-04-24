import { getProjects } from '../services/dataService'
import { Container} from 'reactstrap';
import { useEffect, useState } from 'react'
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
            Required Qualifications: Assigned Employees: <ClickList list={project.qualifications} styles={darkGrayContainerStyle} path="/projects" />
            <br></br>
            Missing Qualifications: Assigned Employees: <ClickList list={project.missingQualifications} styles={darkGrayContainerStyle} path="/projects" />

        </div>
    )
}

const Projects = () => {
    const [projects, setProjects] = useState([])
    useEffect(() => { getProjects().then(setProjects) }, [])
    const active = LocationID('projects', projects, 'name')
    return (
        <Container>
            <div style={pageStyle}>
                <h1>
                    This page displays a table containing all the projects.
                </h1>
                <ClickList active={active} list={projects} item={Project} path='/projects' id='name' />
            </div>
        </Container>
    )
}

export default Projects