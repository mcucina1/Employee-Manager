import { useEffect, useState } from 'react'
import ClickList from '../components/ClickList'
import { getQualifications, createQualification } from '../services/dataService'
import LocationID from '../utils/location'
import { darkGrayContainerStyle, grayContainerStyle, pageStyle } from '../utils/styles'

const Qualification = (qualification, active) => {
    return (
        <div>
            <div>{qualification.description}</div>
            {active === true ? QualificationBody(qualification) : null}
        </div>
    )
}

const QualificationBody = (qualification) => {
    return (
        <div style={grayContainerStyle}>
            Workers: <ClickList list={qualification.workers} styles={darkGrayContainerStyle} path="/workers" />
        </div>
    )
}

const Qualifications = () => {
    const [qualifications, setQualifications] = useState([])
    useEffect(() => { getQualifications().then(setQualifications) }, [])
    const active = LocationID('qualifications', qualifications, 'description')
    return (
        <div style={pageStyle}>
            <h1>
                This page displays a table containing all the qualifications.
            </h1>
            <PostQualification setQualifications={setQualifications}/>
            <ClickList active={active} list={qualifications} item={Qualification} path='/qualifications' id='description' />
        </div>
    )
}

const PostQualification = (props) => {
    const [qualification, setQualification] = useState("")

     const handleButtonClick = async () => {
        const worker = inputWorker.current.value;
        const project = inputProject.current.value;
        const request = {
            qualification: qualification 
        };
        try {
            await createQualification(request);
            const updatedQualifications = await getQualifications();
            props.setQualifications(updatedQualifications)
            alert(qualification + " has been added")
        } catch (error) {
            alert("Failed to create Qualification");
        }
    };
   

    return (
        <>
        <label>Add Qualification
            <input 
            type="text" 
            value={qualification}
            onChange={(e) => setQualification(e.target.value)}
            />
        </label>
        <input type="submit" />
        <button onClick={handleButtonClick} />
        </>
    )
  }
  
export default Qualifications