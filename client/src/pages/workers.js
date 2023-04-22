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
            Qualifications: <ClickList list={worker.qualifications} styles={darkGrayContainerStyle} path="/qualifications" /> {"\n"}
            Salary: {worker.salary}{"\n"}
            Projects: <ClickList list={worker.projects} styles={darkGrayContainerStyle} path="/projects" /> {"\n"}
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
                <ClickList active={active} list={workers} item={Worker} path='/qualifications' id='description' />
            </div>
        </Container>
    )
}

export default Workers