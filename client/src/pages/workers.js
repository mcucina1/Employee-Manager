import { getWorkers } from '../services/dataService'
import { Container} from 'reactstrap';
import { useEffect, useState } from 'react'
import ClickList from '../components/ClickList'
import LocationID from '../utils/location'
import { darkGrayContainerStyle, grayContainerStyle, pageStyle } from '../utils/styles'

const Worker = (worker, active) => {
    return (
        <div>
            <div>{worker.name}</div>
            {active === true ? WorkerBody(worker) : null}
        </div>
    )
}

const WorkerBody = (worker) => {
    return (
        <div style={grayContainerStyle}>
            Name: {worker.name}
            <br></br>
            Salary: {worker.salary}
            <br></br>
            Current Workload: {worker.workload}
            <br></br>
            Projects: <ClickList list={worker.projects} styles={darkGrayContainerStyle} path="/projects" />
            Qualifications: <ClickList list={worker.qualifications} styles={darkGrayContainerStyle} path="/qualifications" /> {"\n"}
        </div>
    )
}

const Workers = () => {
    const [workers, setWorkers] = useState([])
    useEffect(() => { getWorkers().then(setWorkers) }, [])
    const active = LocationID('workers', workers, 'name')
    return (
        <Container>
            <div style={pageStyle}>
                <h1>
                    This page displays a table containing all the qualifications.
                </h1>
                <ClickList active={active} list={workers} item={Worker} path='/workers' id='name' />
            </div>
        </Container>
    )
}

export default Workers