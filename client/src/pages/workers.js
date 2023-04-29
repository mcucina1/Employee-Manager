import { getWorkers, createWorker, getQualifications } from '../services/dataService'
import { Container } from 'reactstrap';
import { useEffect, useState, useRef } from 'react'
import ClickList from '../components/ClickList'
import LocationID from '../utils/location'
import { darkGrayContainerStyle, grayContainerStyle, pageStyle } from '../utils/styles'
import Select from 'react-select'

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
                    This page displays a table containing all the workers.
                </h1>
                <PostWorker setWorkers={setWorkers} />
                <ClickList active={active} list={workers} item={Worker} path='/workers' id='name' />
            </div>
        </Container>
    )
}

const PostWorker = (props) => {
    const [name, setName] = useState("")
    const [qualifications, setQualifications] = useState([]);
    const [select, setSelect] = useState([]);
    const [salary, setSalary] = useState(0);
    const inputQualifications = useRef("");

    useEffect(() => { getQualifications().then(setQualifications) }, [])

    const handleChange = async (e) => {
        let value = Array.from(e.target.selectedOptions, option => option.value);
        setSelect(value);
    }
    const handleClick = async () => {
        const request = {
            name: name,
            qualifications: select,
            salary: salary
        };
        try {
            await createWorker(request);
            const updatedWorkers = await getWorkers();
            props.setWorkers(updatedWorkers);
            alert(name + " has been employed")
        } catch (error) {
            alert("Failed to employ worker. One of the requirements does not work.");
        }
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
            <label> Salary
                <input
                    type="text"
                    value={salary}
                    onChange={(e) => setSalary(e.target.value)}
                />
            </label>
            <button onClick={handleClick}>Employ Worker</button>
        </>
    )
}

export default Workers